package m;

import java.util.Scanner;
public class expenditure {
	static Scanner s = new Scanner(System.in);
	static int price1 = 0;
	static int price2 = 0;
	public static void managerActions() {
		System.out.println("What you want to do with expenditures:\n* increase\n* decrease\n* clear\n* view");
		String chooseX = s.nextLine().toLowerCase();
    	if(chooseX.equals("increase")) {
    		System.out.print("Please enter the increased expenditure: ");
    		price2 = s.nextInt();
    		increaseX(price2);
    	}else if(chooseX.equals("decrease")) {
    		System.out.print("Please enter the decreased expenditure: ");
    		price2 = s.nextInt();
    		decreaseX(price2);
    	} else if(chooseX.equals("clear")) {
    		clearX();
    	}else if(chooseX.equals("view")) {
    		viewX();
    	}else {
    		System.out.println("We don't have this action in list of actions\n");
    	}
	}
	public static void increaseX(int p) {
		price1 += p;
	}
	public static void decreaseX(int p) {
		if(price1!=0)
		price1 -= p;
		else
			System.out.println("Your expenditure is 0$");
	}
    public static void clearX() {
		price1 = 0;
	}
    public static void viewX() {
		System.out.println("The expenditure is: " + price1 + "$\n");
	}
}
