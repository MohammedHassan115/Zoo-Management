import java.util.Scanner;

public class ticket {
    static Scanner s = new Scanner(System.in);
    static income i = new income();
    static String ticket = "";
    static int priceT = 0;
    public static void publicActions() {
        System.out.println("What you want to do with tickets:\n* show\n* buy");
        String chooseT = s.nextLine();
        if(chooseT.equals("show")) {
            showT();
        } else if(chooseT.equals("buy")) {
            System.out.print("which ticket do you want to buy: ");
            ticket = s.nextLine().toLowerCase();
            System.out.print("please give money to the ticket: ");
            priceT = s.nextInt();
            buy(ticket, priceT);
        }else {
            System.out.println("We don't have this action in list of actions\n");
        }
    }
    public static void showT() {
        System.out.println("We have two tickets:\n* Normal ticket: the Normal one is 10$\n* VIP ticket: the VIP one is 30$\n");
    }
    public static void buy(String t, int pt) {
        if((t.equals("vip") && pt>=30) || (t.equals("normal") && pt>=10)) {
            System.out.println("You successfully buy " + t + " ticket by " + pt + "$\n");
            i.updateI(pt);
        }
        else {
            System.out.println("Please choose one of the ticket and give enough money\n");
            showT();
        }

    }
}
