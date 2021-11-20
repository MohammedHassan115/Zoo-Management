package m;

import java.io.IOException;
import java.util.Scanner;

public class employee {
    static Scanner s = new Scanner(System.in);
    private static String nameE  = "";
    private static String informationE = "";
    public static void managerActions() throws IOException {
        System.out.println("What you want to do with employees:\n* add - add an employee to list of employees\n* delete - remove an employee to list of employees\n* update  - replace an employee with another employee in list of employees\n* view - show list of employees\n* search - to find a specific employee\n* back - back to list of actions");
        String chooseE = s.nextLine().toLowerCase();
        switch (chooseE) {
            case "add" -> employeeModel.addE();
            case "delete" -> employeeModel.deleteE();
            case "update" -> employeeModel.updateE();
            case "view" -> employeeModel.viewE();
            case "search" -> employeeModel.searchE();
            case "back" -> {}
            default -> {
                System.out.println("We don't have this action in list of actions\n");
                managerActions();
            }
        }
    }
    public static void setNameE(String nE) {
        nameE = nE;
    }
    public static String getNameE() {
        return nameE;
    }
    public static void setInformationE(String infoE) {
        informationE = infoE;
    }
    public static String getInformationE() {
        return informationE;
    }
}
