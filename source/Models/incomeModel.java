package m;

import java.io.IOException;
import java.util.Scanner;

public class incomeModel {
    static Scanner s = new Scanner(System.in);
    static int price = 0;
    public static void updateI(int p, String w) throws IOException {
        price += p;
        if(w.equals("t")) ticket.userActions();
        else income.managerActions();
    }
    public static void clearI() throws IOException {
        price = 0;
        System.out.println("The income is: " + price + "$\n");
        income.managerActions();
    }
    public static void viewI() throws IOException {
        System.out.println("The income is: " + price + "$\n");
        income.managerActions();
    }
}
