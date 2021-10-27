package m;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class supply {
	static view v = new view();
	static Scanner s = new Scanner(System.in);
	static LinkedList<String> supplies = new LinkedList<>();
	static List<String> quantityS = new ArrayList<>();
	static List<Integer> priceS = new ArrayList<>();
	static expenditure ex = new expenditure();
	static String name  = "";
	static String nameR  = "";
	static String quantity = "";
	static int p = 0;
	public static void managerActions() throws IOException {
		FileWriter fw = new FileWriter("supply.txt", true);
    	System.out.println("What you want to do with supplies:\n* add - add an supply to list of supplies\n* delete - remove an supply to list of supplies\n* update  - replace an supplies with another supplies in list of supplies\n* view - show list of supplies\n* search - to find a specific supply\n* back - back to list of actions");
    	String chooseS = s.nextLine().toLowerCase();
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
    	}else if(chooseS.equals("search")) {
    		System.out.print("Please enter name of the supply to find it: ");
    		name = s.nextLine().toLowerCase();
    		searchS(name);
    	}else if(chooseS.equals("back")) {
    		
    	}else {
    		System.out.println("We don't have this action in list of actions\n");
    		managerActions();
    	}
    	fw.close();		
    }
    public static void addS(String n, String q, int p) throws IOException {
    	if(!supplies.contains(n)) {
    		supplies.add(n);
    		quantityS.add(q);
    		priceS.add(p);
        	System.out.println(q + " of " + n + " by " + p + "$ added to the list of supplies\n");
        	ex.increaseX(p);
    	}else {
    		System.out.println("This name already exist in the list of supplies\n");
    	}
    	managerActions();
    }
    public static void deleteS(String n) throws IOException {
    	quantityS.remove(supplies.indexOf(n));
    	ex.decreaseX(priceS.get(supplies.indexOf(n)));
    	priceS.remove(supplies.indexOf(n));
    	supplies.remove(supplies.indexOf(n));
    	System.out.println(n + " removed from the list of supplies\n");
    	managerActions();
    }
    public static void updateS(String n, String nR) throws IOException {
    	supplies.set(supplies.indexOf(n), nR);
    	System.out.println(nR + " replaced by " + n + "\n");
    	managerActions();
    }
    public static void viewS() throws IOException {
    	File f = new File("C:\\Users\\PC-BALEN\\eclipse-workspace\\mom\\supply.txt");
		BufferedReader br = new BufferedReader(new FileReader(f));
		String st;
		int s = 0;
		while((st = br.readLine()) != null){
			if(!st.equals("")) {
			if(s==0) {
				supplies.add(st);
				s = 1;
			}else if(s==1){
				quantityS.add(st);
				s = 2;
			}else {
				priceS.add(Integer.parseInt(st));
				s = 0;
			}
			}
		}
    	int j = 0;
    	System.out.println("List of supplies:");
    	for(int i=0; i<supplies.size(); i++) {
    		j = i;
    		j++;
    		System.out.println(j + "- " + quantityS.get(i) + " of " + supplies.get(i) + " by " + priceS.get(i) +"$");
    	}
    	System.out.println();
    	managerActions();
    }
    public static void searchS(String n) throws IOException {
    	File f = new File("C:\\Users\\PC-BALEN\\eclipse-workspace\\mom\\supply.txt");
		BufferedReader br = new BufferedReader(new FileReader(f));
		String st;
		int s = 0;
		while((st = br.readLine()) != null){
			if(!st.equals("")) {
			if(s==0) {
				supplies.add(st);
				s = 1;
			}else if(s==1){
				quantityS.add(st);
				s = 2;
			}else {
				priceS.add(Integer.parseInt(st));
				s = 0;
			}
			}
		}
    	if(supplies.contains(n)) {
    		System.out.println(quantityS.get(supplies.indexOf(n)) + " of " + supplies.get(supplies.indexOf(n)) + " by " + priceS.get(supplies.lastIndexOf(n)) +"$");
    	}else {
    		System.out.println("We don't have this employee in list of employees\n");
    	}
    	managerActions();
    }
 }
