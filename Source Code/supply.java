package m;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
//add quantity to supply && update -
//edit expenditure

public class supply {
	static Scanner s = new Scanner(System.in);
	static LinkedList<String> supplies = new LinkedList<>();
	static List<String> quantityS = new ArrayList<>();
	static expenditure ex = new expenditure();
	static String name  = "";
	static String nameR  = "";
	static String quantity = "";
	static int p = 0;
	public static void managerActions() throws IOException {
		FileWriter fw = new FileWriter("supply.txt", true);
    	System.out.println("What you want to do with supplies:\n* add\n* delete\n* update\n* view");
    	String chooseS = s.nextLine();
    	if(chooseS.equals("add")) {
    		System.out.print("Please enter name of the supply: ");
    		name = s.nextLine().toLowerCase();
    		for(int i=0; i<name.length(); i++)
    			fw.write(name.charAt(i));
    		fw.write("\n");
    		System.out.print("Please enter quantity of the supply: ");
    		quantity = s.nextLine().toLowerCase();
    		for(int i=0; i<quantity.length(); i++)
    			fw.write(quantity.charAt(i));
    		fw.write("\n");
    		System.out.print("And enter price of the supply: ");
    		p = s.nextInt();
    		for(int i=0; i<String.valueOf(p).length(); i++)
    			fw.write(String.valueOf(p).charAt(i));
    		fw.write("\n\n");
    		addS(name, quantity, p);
    		ex.updateX(p);
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
    	fw.close();		
    }
    public static void addS(String n, String q, int p) {
    	if(!supplies.contains(n)) {
    		supplies.add(n);
    		quantityS.add(q);
        	System.out.println(q + " of " + n + " by " + p + "$ added to the list of supplies\n");
    	}else {
    		System.out.println("This name already exist in the list of supplies\n");
    	}
    }
    public static void deleteS(String n) {
    	quantityS.remove(supplies.indexOf(n));
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
