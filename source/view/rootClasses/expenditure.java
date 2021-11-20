package m;

import java.io.IOException;
import java.util.Scanner;
public class expenditure {
    static Scanner s = new Scanner(System.in);

    public static void managerActions() throws IOException {
        System.out.println("What you want to do with expenditures:\n* increase - you can increase expenditure with it\n* decrease - you can decrease expenditure with it\n* clear - expenditure will be (0)\n* view - show you how many expenditure we have\n* back - back to list of actions");
        String chooseX = s.nextLine().toLowerCase();
        switch (chooseX) {
            case "increase" -> {
                System.out.print("Please enter the increased expenditure: ");
                int price2 = s.nextInt();
                expenditureModel.increaseX(price2);
            }
            case "decrease" -> {
                System.out.print("Please enter the decreased expenditure: ");
                int price2 = s.nextInt();
                expenditureModel.decreaseX(price2);
            }
            case "clear" -> expenditureModel.clearX();
            case "view" -> expenditureModel.viewX();
            case "back" -> {}
            default -> {
                System.out.println("We don't have this action in list of actions\n");
                managerActions();
            }
        }
    }
}
