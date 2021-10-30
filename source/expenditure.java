package m;

import java.util.Scanner;
public class expenditure {
	static Scanner s = new Scanner(System.in);
	
	public static void managerActions() {
		System.out.println("What you want to do with expenditures:\n* increase - you can increase expenditure with it\n* decrease - you can decrease expenditure with it\n* clear - expenditure will be (0)\n* view - show you how many expenditure we have\n* back - back to list of actions");
		String chooseX = s.nextLine().toLowerCase();
    	if(chooseX.equals("increase")) {
    		System.out.print("Please enter the increased expenditure: ");
    		int price2 = s.nextInt();
    		expenditureModel.increaseX(price2);
    	}else if(chooseX.equals("decrease")) {
    		System.out.print("Please enter the decreased expenditure: ");
    		int price2 = s.nextInt();
    		expenditureModel.decreaseX(price2);
    	}else if(chooseX.equals("clear")) {
    		expenditureModel.clearX();
    	}else if(chooseX.equals("view")) {
    		expenditureModel.viewX();
    	}else if(chooseX.equals("back")) {
    		
    	}else {
    		System.out.println("We don't have this action in list of actions\n");
    		managerActions();
		}
	}
}
