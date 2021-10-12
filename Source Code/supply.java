package m;

import java.util.LinkedList;
import java.util.Scanner;

public class supply {
	static Scanner s = new Scanner(System.in);
	static LinkedList<String> supplies = new LinkedList<>();
	static expenditure ex = new expenditure();
	static String name  = "";
	static String nameR  = "";
	static int price = 0;
	public static void managerActions() {
    	System.out.println("What you want to do with supplies:\n* add\n* delete\n* update\n* view");
    	String chooseS = s.nextLine();
    	if(chooseS.equals("add")) {
    		System.out.print("Please enter name of the supply: ");
    		name = s.nextLine().toLowerCase();
    		System.out.print("And enter price of the supply: ");
    		price = s.nextInt();
    		addS(name, price);
    		ex.updateX(price);
    	} else if(chooseS.equals("delete")) {
    		System.out.print("Please enter name of the supply: ");
    		name = s.nextLine().toLowerCase();
    		deleteS(name);
    	}else if(chooseS.equals("update")) {
    		System.out.print("Please enter name of the old supply: ");
    		name = s.nextLine().toLowerCase();
    		System.out.print("Please enter name of the new supply: ");
    		nameR = s.nextLine().toLowerCase();
    		updateS(name, nameR);
    	}else if(chooseS.equals("view")) {
    		viewS();
    	}else {
    		System.out.println("We don't have this action in list of actions\n");
    	}
    		
    }
    public static void addS(String n, int p) {
    	if(!supplies.contains(n)) {
    		supplies.add(n);
        	System.out.println(n + " by " + p + "$ added to the list of supplies\n");
    	}else {
    		System.out.println("This name already exist in the list of supplies\n");
    	}
    }
    public static void deleteS(String n) {
    	supplies.remove(supplies.indexOf(n));
    	System.out.println(n + " removed from the list of supplies\n");	
    }
    public static void updateS(String n, String nR) {
    	supplies.set(supplies.indexOf(n), nR);
    	System.out.println(nR + " replaced by " + n + "\n");	
    }
    public static void viewS() {
    	int j = 0;
    	System.out.println("List of supplies:");
    	for(int i=0; i<supplies.size(); i++) {
    		j = i;
    		j++;
    		System.out.println(j + "- " + supplies.get(i));
    	}
    	System.out.println();
    }
 }
