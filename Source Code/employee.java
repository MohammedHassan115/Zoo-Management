package m;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class employee {
	static Scanner s = new Scanner(System.in);
	static LinkedList<String> employees = new LinkedList<>();
	static List<String> informations = new ArrayList<>();
	static String name  = "";
	static String nameR  = "";
	static String informationE = "";
	public static void managerActions() throws IOException {
		FileWriter fw = new FileWriter("employee.txt", true);
    	System.out.println("What you want to do with employees:\n* add\n* delete\n* update\n* view\n* information");
    	String chooseE = s.nextLine().toLowerCase();
    	if(chooseE.equals("add")) {
    		System.out.print("Please enter name of the employee: ");
    		name = s.nextLine().toLowerCase();
    		for(int i=0; i<name.length(); i++)
    			fw.write(name.charAt(i));
    		fw.write("\n");
    		System.out.print("And enter information about the emloyee: ");
    		informationE = s.nextLine().toLowerCase();
    		for(int i=0; i<informationE.length(); i++)
    			fw.write(informationE.charAt(i));
    		fw.write("\n\n");
    		addE(name, informationE);
    	} else if(chooseE.equals("delete")) {
    		System.out.print("Please enter name of the employee: ");
    		name = s.nextLine().toLowerCase();
    		deleteE(name);
    	}else if(chooseE.equals("update")) {
    		System.out.print("Please enter name of the old employee: ");
    		name = s.nextLine().toLowerCase();
    		System.out.print("Please enter name of the new employee: ");
    		nameR = s.nextLine().toLowerCase();
    		updateE(name, nameR);
    	}else if(chooseE.equals("view")) {
    		viewE();
    	}
    	else if(chooseE.equals("information")) {
    		System.out.print("Please enter name of the animal to find information about it: ");
    		name = s.nextLine().toLowerCase();
    		informationE(name);
    	}
    	else {
    		System.out.println("We don't have this action in list of actions\n");
    	}
    	fw.close();	
    }
    public static void addE(String n, String i) {
    	if(!employees.contains(n)) {
    		employees.add(n);
    		informations.add(i);
        	System.out.println(n + " added to the list of employees\n");
    	}else {
    		System.out.println("This name already exist in the list of employees");
    	}
    }
    public static void deleteE(String n) {
    	informations.remove(employees.indexOf(n));
    	employees.remove(employees.indexOf(n));
    	System.out.println(n + " removed from the list of employees\n");	
    }
    public static void updateE(String n, String nR) {
    	employees.set(employees.indexOf(n), nR);
    	System.out.println(n + " replaced by " + nR + "\n");	
    }
    public static void viewE() {
    	int j = 0;
    	System.out.println("List of employees:");
    	for(int i=0; i<employees.size(); i++) {
    		j = i;
    		j++;
    		System.out.println(j + "- " + employees.get(i));
    	}
    	System.out.println();
    }
    public static void informationE(String n) {
    	if(employees.contains(n)) {
    		System.out.println(informations.get(employees.indexOf(n)));
    	}else {
    		System.out.println("We don't have this employee in list of employees\n");
    	}
    }
 }
