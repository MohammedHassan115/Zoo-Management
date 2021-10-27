package m;

import java.util.Scanner;

public class ticket {
	static Scanner s = new Scanner(System.in); 
	static income i = new income();
	static String ticket = "";
	static int priceT = 0;
	static int ticketsoldN = 0;
	static int ticketsoldV = 0;
	static int ticketsoldA = 0;
	public static void managerActions() {
		System.out.println("What you want to do with tickets:\n* show - show you what ticket we have\n* sold tickets - show you number and type of tickets that sold\n* back - back to list of actions");
		String chooseT = s.nextLine().toLowerCase();
    	if(chooseT.equals("show")) {
    		showT("m");
    	} else if(chooseT.equals("sold tickets")) {
    		sold();
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
    		showT("u");
    	} else if(chooseT.equals("buy")) {
    		System.out.print("which ticket do you want to buy: ");
    		ticket = s.nextLine().toLowerCase();
    		System.out.print("please give money to the ticket: ");
    		priceT = s.nextInt();
    		if(ticket.equals("normal")) {
    			ticketsoldN++;
    		}else if(ticket.equals("vip")) {
    			ticketsoldV++;
    		}
    		ticketsoldA = ticketsoldV + ticketsoldN; 
    		buy(ticket, priceT);
    	}else if(chooseT.equals("back")) {
    		
    	}else {
    		System.out.println("We don't have this action in list of actions\n");
    		managerActions();
    	}
	}
	public static void showT(String c) {
		System.out.println("We have two tickets:\n* Normal ticket: the Normal one is 10$\n* VIP ticket: the VIP one is 30$\n");
		if(c.equals("u")) {
			userActions();
		}else {
			managerActions();
		}
		
	}
    public static void buy(String t, int pt) {
    	if((t.equals("vip") && pt>=30) || (t.equals("normal") && pt>=10)) {
    		System.out.println("You successfully buy " + t + " ticket by " + pt + "$\n");
    		i.updateI(pt);
    	}
    	else {
    		System.out.println("Please choose one of the ticket and give enough money\n");
    		showT("u");
    	}
    	userActions();
	}
    public static void sold() {
    	System.out.println("Normal ticket = " + ticketsoldN + "\nVIP ticket = " + ticketsoldV + "\nAll tickets = " + ticketsoldA);
    	managerActions();
    }
}
