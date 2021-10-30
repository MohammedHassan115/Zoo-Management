package m;

import java.io.IOException;
import java.util.Scanner;

public class supply {
	static Scanner s = new Scanner(System.in);
	private static String nameS  = "";
	private static String quantity = "";
	private static int priceS = 0;
	public static void managerActions() throws IOException {
    	System.out.println("What you want to do with supplies:\n* add - add an supply to list of supplies\n* delete - remove an supply to list of supplies\n* update  - replace an supplies with another supplies in list of supplies\n* view - show list of supplies\n* search - to find a specific supply\n* back - back to list of actions");
    	String chooseS = s.nextLine().toLowerCase();
    	if(chooseS.equals("add")) {
    		supplyModel.addS();
    	} else if(chooseS.equals("delete")) {
    		supplyModel.deleteS();
    	}else if(chooseS.equals("update")) {
    		supplyModel.updateS();
    	}else if(chooseS.equals("view")) {
    		supplyModel.viewS();
    	}else if(chooseS.equals("search")) {
    		supplyModel.searchS();
    	}else if(chooseS.equals("back")) {
    		
    	}else {
    		System.out.println("We don't have this action in list of actions\n");
    		managerActions();
    	}		
    }
	public static void setNameS(String nS) {
		nameS = nS;
	}
	public static String getNameS() {
		return nameS;
	}
	public static void setQuantity(String q) {
		quantity = q;
	}
	public static String getQuantity() {
		return quantity;
	}
	public static void setPriceS(int p) {
		priceS = p;
	}
	public static int getPriceS() {
		return priceS;
	}
 }
