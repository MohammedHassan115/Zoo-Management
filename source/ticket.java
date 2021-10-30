package m;

import java.util.Scanner;

public class ticket {
	static Scanner s = new Scanner(System.in); 
	
	public static void managerActions() {
		System.out.println("What you want to do with tickets:\n* show - show you what ticket we have\n* sold tickets - show you number and type of tickets that sold\n* back - back to list of actions");
		String chooseT = s.nextLine().toLowerCase();
    	if(chooseT.equals("show")) {
    		ticketModel.showT("m");
    	} else if(chooseT.equals("sold tickets")) {
    		ticketModel.sold();
    	}else if(chooseT.equals("back")) {
    		
    	}else {
    		System.out.println("We don't have this action in list of actions\n");
    		managerActions();
    	}
	}
	public static void userActions() {
		System.out.println("What you want to do with tickets:\n* show - show you what ticket we have\n* buy - you can buy a ticket\n* back - back to list of actions");
		String chooseT = s.nextLine().toLowerCase();
    	if(chooseT.equals("show")) {
    		ticketModel.showT("u");
    	} else if(chooseT.equals("buy")) { 
    		ticketModel.buy();
    	}else if(chooseT.equals("back")) {
    		
    	}else {
    		System.out.println("We don't have this action in list of actions\n");
    		userActions();
    	}
	}
}