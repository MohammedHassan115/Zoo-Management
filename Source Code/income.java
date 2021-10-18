package m;

import java.util.Scanner;

public class income {
	static Scanner s = new Scanner(System.in);
	static int price = 0;
	public static void managerActions() {
		System.out.println("What you want to do with incomes:\n* update\n* clear\n* view");
		String chooseI = s.nextLine().toLowerCase();
    	if(chooseI.equals("update")) {
    		System.out.print("Please enter the new income: ");
    		price = s.nextInt();
    		updateI(price);
    	} else if(chooseI.equals("clear")) {
    		clearI();
    	}else if(chooseI.equals("view")) {
    		viewI();
    	}else {
    		System.out.println("We don't have this action in list of actions\n");
    	}
	}
	public static void updateI(int p) {
		price += p;
	}
    public static void clearI() {
		price = 0;
	}
    public static void viewI() {
		System.out.println("The income is: " + price + "\n");
	}
}
