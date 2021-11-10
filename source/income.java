package m;

import java.util.Scanner;

public class income {
	static Scanner s = new Scanner(System.in);
	
	public static void managerActions() {
		System.out.println("What you want to do with incomes:\n* update - update your income\n* clear - income will be (0)\n* view - show you how many income we have\n* back - back to list of actions");
		String chooseI = s.nextLine().toLowerCase();
    	if(chooseI.equals("update")) {
    		System.out.print("Please enter the new income: ");
    		int p = s.nextInt();
    		incomeModel.updateI(p, "i");
    	} else if(chooseI.equals("clear")) {
    		incomeModel.clearI();
    	}else if(chooseI.equals("view")) {
    		incomeModel.viewI();
    	}else if(chooseI.equals("view")) {
    		
    	}else {
    		System.out.println("We don't have this action in list of actions\n");
    		managerActions();
    	}
	}
}
