import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class employee {
    static Scanner s = new Scanner(System.in);
    static List<String> employees = new ArrayList<>();
    static String name  = "";
    static String nameR  = "";
    public static void managerActions() {
        System.out.println("What you want to do with employees:\n* add\n* delete\n* update\n* view");
        String chooseE = s.nextLine();
        if(chooseE.equals("add")) {
            System.out.print("Please enter name of the employee: ");
            name = s.nextLine().toLowerCase();
            addE(name);
        } else if(chooseE.equals("delete")) {
            System.out.print("Please enter name of the employee: ");
            name = s.nextLine().toLowerCase();
            deleteE(name);
        }else if(chooseE.equals("update")) {
            System.out.print("Please enter name of the old employee: ");
            name = s.nextLine().toLowerCase();
            System.out.print("Please enter name of the new employee: ");
            nameR = s.nextLine().toLowerCase();
            updateE(name, nameR);
        }else if(chooseE.equals("view")) {
            viewE();
        }

    }
    public static void addE(String n) {
        if(!employees.contains(n)) {
            employees.add(n);
            System.out.println(n + " added to the list of employees\n");
        }else {
            System.out.println("This name already exist in the list of employees");
        }
    }
    public static void deleteE(String n) {
        employees.remove(employees.indexOf(n));
        System.out.println(n + " removed from the list of employees\n");
    }
    public static void updateE(String n, String nR) {
        employees.set(employees.indexOf(n), nR);
        System.out.println(n + " replaced by " + nR + "\n");
    }
    public static void viewE() {
        int j = 0;
        System.out.println("List of employees:");
        for(int i=0; i<employees.size(); i++) {
            j = i;
            j++;
            System.out.println(j + "- " + employees.get(i));
        }
        System.out.println();
    }
}
