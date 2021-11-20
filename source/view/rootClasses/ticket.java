package m;

import java.io.IOException;
import java.util.Scanner;

public class ticket {
    static Scanner s = new Scanner(System.in);

    public static void managerActions() throws IOException {

        System.out.println("What you want to do with tickets:\n* show - show you what ticket we have\n* sold tickets - show you number and type of tickets that sold\n* back - back to list of actions");
        String chooseT = s.nextLine().toLowerCase();
        switch (chooseT) {
            case "show" -> ticketModel.showT("m");
            case "sold tickets" -> ticketModel.sold();
            case "back" -> {}
            default -> {
                System.out.println("We don't have this action in list of actions\n");
                managerActions();
            }
        }
    }
    public static void userActions() throws IOException {
        System.out.println("What you want to do with tickets:\n* show - show you what ticket we have\n* buy - you can buy a ticket\n* back - back to list of actions");
        String chooseT = s.nextLine().toLowerCase();
        switch (chooseT) {
            case "show" -> ticketModel.showT("u");
            case "buy" -> ticketModel.buy();
            case "back" -> {}
            default -> {
                System.out.println("We don't have this action in list of actions\n");
                userActions();
            }
        }
    }
}
