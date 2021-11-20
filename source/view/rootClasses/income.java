package m;

import java.io.IOException;
import java.util.Scanner;

public class income {
    static Scanner s = new Scanner(System.in);

    public static void managerActions() throws IOException {
        System.out.println("What you want to do with incomes:\n* update - update your income\n* clear - income will be (0)\n* view - show you how many income we have\n* back - back to list of actions");
        String chooseI = s.nextLine().toLowerCase();
        switch (chooseI) {
            case "update" -> {
                System.out.print("Please enter the new income: ");
                int p = s.nextInt();
                incomeModel.updateI(p, "i");
            }
            case "clear" -> incomeModel.clearI();
            case "view" -> incomeModel.viewI();
            case "back" -> {}
            default -> {System.out.println("We don't have this action in list of actions\n");
                managerActions();
            }
        }
    }
}
