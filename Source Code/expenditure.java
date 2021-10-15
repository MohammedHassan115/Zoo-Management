package m;

import java.util.Scanner;

public class expenditure {
	static Scanner s = new Scanner(System.in);
	static int price = 0;
	public static void managerActions() {
		System.out.println("What you want to do with expenditures:\n* update\n* clear\n* view");
		String chooseX = s.nextLine();
    	if(chooseX.equals("update")) {
    		System.out.print("Please enter the new expenditure: ");
    		price = s.nextInt();
    		updateX(price);
    	} else if(chooseX.equals("clear")) {
    		clearX();
    	}else if(chooseX.equals("view")) {
    		viewX();
    	}else {
    		System.out.println("We don't have this action in list of actions\n");
    	}
	}
	public static void updateX(int p) {
		price += p;
	}
    public static void clearX() {
		price = 0;
	}
    public static void viewX() {
		System.out.println("The expenditure is: " + price + "\n");
	}
}
