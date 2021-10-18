package m;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class animal {
	static Scanner s = new Scanner(System.in);
	static LinkedList<String> animals = new LinkedList<>();
	static List<String> informations = new ArrayList<>();
	static String name  = "";
	static String nameR  = "";
	static String chooseA = "";
	static String informationA = "";
	public static void userActions() {
    	System.out.println("What you want to do with animals:\n* information\n* view");
    	String chooseA = s.nextLine();
    	if(chooseA.equals("information")) {
    		System.out.print("Please enter name of the animal to find information about it: ");
    		name = s.nextLine().toLowerCase();
    		informationA(name);
    	}else if(chooseA.equals("view")) {
    		viewA();
    	}else {
    		System.out.println("We don't have this action in list of actions");
    	}
    }
	public static void managerActions() throws IOException {
		FileWriter fw = new FileWriter("animal.txt", true);
    	System.out.println("What you want to do with animals:\n* add\n* delete\n* update\n* view\n* information");
    	String chooseA = s.nextLine();
    	if(chooseA.equals("add")) {
    		System.out.print("Please enter name of the animal: ");
    		name = s.nextLine().toLowerCase();
    		for(int i=0; i<name.length(); i++)
    			fw.write(name.charAt(i));
    		fw.write("\n");
    		System.out.print("And enter information about the animal: ");
    		informationA = s.nextLine().toLowerCase();
    		for(int i=0; i<informationA.length(); i++)
    			fw.write(informationA.charAt(i));
    		fw.write("\n\n");
    		addA(name, informationA);
    	} else if(chooseA.equals("delete")) {
    		System.out.print("Please enter name of the animal: ");
    		name = s.nextLine().toLowerCase();
    		deleteA(name);
    	}else if(chooseA.equals("update")) {
    		System.out.print("Please enter name of the old animal: ");
    		name = s.nextLine().toLowerCase();
    		System.out.print("Please enter name of the new animal: ");
    		nameR = s.nextLine().toLowerCase();
    		updateA(name, nameR);
    	}else if(chooseA.equals("view")) {
    		viewA();
    	}else if(chooseA.equals("information")) {
    		System.out.print("Please enter name of the animal to find information about it: ");
    		name = s.nextLine().toLowerCase();
    		informationA(name);
    	}else {
    		System.out.println("We don't have this action in list of actions\n");
    	}
    	fw.close();
    }
    public static void addA(String n, String i) {
    	if(!animals.contains(n)) {
    		animals.add(n);
    		informations.add(i);
        	System.out.println(n + " added to the list of animals\n");
    	}else {
    		System.out.println("This name already exist in the list of animals\n");
    	}
    }
    public static void deleteA(String n) {
    	informations.remove(animals.indexOf(n));
    	animals.remove(animals.indexOf(n));
    	System.out.println(n + " removed from the list of animals\n");	
    }
    public static void updateA(String n, String nR) {
    	animals.set(animals.indexOf(n), nR);
    	System.out.println(n + " replace by " + nR + "\n");	
    }
    public static void viewA() {
    	int j = 0;
    	System.out.println("List of aimals:");
    	for(int i=0; i<animals.size(); i++) {
    		j = i;
    		j++;
    		System.out.println(j + "- " + animals.get(i));
    	}
    	System.out.println();
    }
    public static void informationA(String n) {
    	if(animals.contains(n)) {
    		System.out.println(informations.get(animals.indexOf(n)));
    	}else {
    		System.out.println("We don't have this animal in list of animals\n");
    	}
    }
 }
