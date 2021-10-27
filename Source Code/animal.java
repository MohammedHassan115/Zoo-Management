package m;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
	public static void userActions() throws IOException {
    	System.out.println("What you want to do with animals:\n* view - show list of animals\n* search - to find a specfic animal\n* back - back to list of actions");
    	String chooseA = s.nextLine().toLowerCase();
    	if(chooseA.equals("view")) {
    		viewA("u");
    	}else if(chooseA.equals("search")) {
    		System.out.print("Please enter name of the animal to find it: ");
    		name = s.nextLine().toLowerCase();
    		searchA(name, "u");
    	}else {
    		System.out.println("We don't have this action in list of actions");
    		userActions();
    	}
    }
	public static void managerActions() throws IOException {
		FileWriter fw = new FileWriter("animal.txt", true);
    	System.out.println("What you want to do with animals:\n* add - add an animal to list of animals\n* delete - remove an animal to list of animals\n* update  - replace an animal with another animal in list of animals\n* view - show list of animals\n* search - to find a specfic animal\n* back - back to list of actions");
    	String chooseA = s.nextLine().toLowerCase();
    	if(chooseA.equals("add")) {
    		System.out.print("Please enter name of the animal: ");
    		name = s.nextLine().toLowerCase();
    		System.out.print("And enter information about the animal: ");
    		informationA = s.nextLine().toLowerCase();
    		addA(name, informationA);
    		for(int i=0; i<name.length(); i++)
    			fw.write(name.charAt(i));
    		fw.write("\n");
    		for(int i=0; i<informationA.length(); i++)
    			fw.write(informationA.charAt(i));
    		fw.write("\n\n");
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
    		viewA("m");
    	}else if(chooseA.equals("search")) {
    		System.out.print("Please enter name of the animal to find it: ");
    		name = s.nextLine().toLowerCase();
    		searchA(name, "m");
    	}else if(chooseA.equals("back")) {
    		
    	}else {
    		System.out.println("We don't have this action in list of actions\n");
    		managerActions();
    	}
    	fw.close();
    }
    public static void addA(String n, String i) throws IOException {
    	if(!animals.contains(n)) {
    		animals.add(n);
    		informations.add(i);
        	System.out.println(n + " added to the list of animals\n");
    	}else {
    		System.out.println("This name already exist in the list of animals\n");
    	}
    	managerActions();
    }
    public static void deleteA(String n) throws IOException {
    	informations.remove(animals.indexOf(n));
    	animals.remove(animals.indexOf(n));
    	System.out.println(n + " removed from the list of animals\n");
    	managerActions();
    }
    public static void updateA(String n, String nR) throws IOException {
    	animals.set(animals.indexOf(n), nR);
    	System.out.println(n + " replace by " + nR + "\n");	
    	managerActions();
    }
    public static void viewA(String c) throws IOException {
    	File f = new File("C:\\Users\\PC-BALEN\\eclipse-workspace\\mom\\animal.txt");
		BufferedReader br = new BufferedReader(new FileReader(f));
		String st;
		int s = 0;
		while((st = br.readLine()) != null){
			if(!st.equals("")) {
			if(s==0) {
				animals.add(st);
				s = 1;
			}else {
				informations.add(st);
				s = 0;
			}
			}
		}
    	int j = 0;
    	System.out.println("List of animals:");
    	for(int i=0; i<animals.size(); i++) {
    		if(!animals.get(i).equals("")) {
    			j = i;
    		    j++;
    		    System.out.println(j + "- " + animals.get(i) + " " + informations.get(i));
    		}
    	}
    	System.out.println();
    	if(c.equals("u")) {
    		userActions();
    	}else {
    		managerActions();
    	}
    }
    public static void searchA(String n, String c) throws IOException {
    	File f = new File("C:\\Users\\PC-BALEN\\eclipse-workspace\\mom\\animal.txt");
		BufferedReader br = new BufferedReader(new FileReader(f));
		String st;
		int s = 0;
		while((st = br.readLine()) != null){
			if(!st.equals("")) {
			if(s==0) {
				animals.add(st);
				s = 1;
			}else {
				informations.add(st);
				s = 0;
			}
			}
		}
    	if(animals.contains(n)) {
    		System.out.println(animals.get(animals.indexOf(n)) + " " +informations.get(animals.indexOf(n)));
    	}else {
    		System.out.println("We don't have this animal in list of animals\n");
    	}
    	if(c.equals("u")) {
    		userActions();
    	}else {
    		managerActions();
    	}
    	
    }
 }
