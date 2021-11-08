package m;

import java.util.Scanner;

public class ticketModel {
	static Scanner s = new Scanner(System.in);
	static int ticketsoldN = 0;
	static int ticketsoldV = 0;
	static int ticketsoldA = 0;
	static ticket t = new ticket();
	
	public static void showT(String c) {
		System.out.println("We have two tickets:\n* Normal: the Normal one is 10$\n* VIP: the VIP one is 30$\n");
		if(c.equals("u")) {
			ticket.userActions();
		}else {
			ticket.managerActions();
		}
		
	}
    public static void buy() {
    	System.out.print("which ticket do you want to buy: ");
		String ticket = s.nextLine().toLowerCase();
		System.out.print("please give money to the ticket: ");
		int priceT = s.nextInt();
		if(ticket.equals("normal")) {
			ticketsoldN++;
		}else if(ticket.equals("vip")) {
			ticketsoldV++;
		}
		ticketsoldA = ticketsoldV + ticketsoldN;
    	if((ticket.equals("vip") && priceT>=30) || (ticket.equals("normal") && priceT>=10)) {
    		System.out.println("You successfully buy " + ticket + " ticket by " + priceT + "$\n");
    		incomeModel.updateI(priceT);
    	}
    	else {
    		System.out.println("Please choose one of the ticket and give enough money\n");
    		showT("u");
    	}
    	t.userActions();
	}
    public static void sold() {
    	System.out.println("Normal ticket = " + ticketsoldN + "\nVIP ticket = " + ticketsoldV + "\nAll tickets = " + ticketsoldA);
    	ticket.managerActions();
    }
}
