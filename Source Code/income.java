package m;

import java.util.Scanner;

public class income {
	static Scanner s = new Scanner(System.in);
	static int price = 0;
	public static void managerActions() {
		System.out.println("What you want to do with incomes:\n* update - update your income\n* clear - income will be (0)\n* view - show you how many income we have\n* back - back to list of actions");
		String chooseI = s.nextLine().toLowerCase();
    	if(chooseI.equals("update")) {
    		System.out.print("Please enter the new income: ");
    		price = s.nextInt();
    		updateI(price);
    	} else if(chooseI.equals("clear")) {
    		clearI();
    	}else if(chooseI.equals("view")) {
    		viewI();
    	}else if(chooseI.equals("view")) {
    		
    	}else {
    		System.out.println("We don't have this action in list of actions\n");
    		managerActions();
    	}
	}
	public static void updateI(int p) {
		price += p;
		managerActions();
	}
    public static void clearI() {
		price = 0;
		System.out.println("The income is: " + price + "\n");
		managerActions();
	}
    public static void viewI() {
		System.out.println("The income is: " + price + "\n");
		managerActions();
	}
}
