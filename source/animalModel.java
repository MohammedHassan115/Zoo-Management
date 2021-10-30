package m;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class animalModel {
	static Scanner s = new Scanner(System.in);
	static LinkedList<String> animals = new LinkedList<>();
	static List<String> informations = new ArrayList<>();
	static String nameA = "";
	static String infoA = "";
	
	
	public static void addA() throws IOException {
    	FileWriter fw = new FileWriter("animal.txt", true);
    		System.out.print("Please enter name of the animal: ");
    		animal.setNameA(s.nextLine().toLowerCase());
    		nameA = Optional.ofNullable(animal.getNameA()).orElse("unknown animal");
    		System.out.print("And enter information about the animal: ");
    		animal.setInformationA(s.nextLine().toLowerCase());
    		infoA = Optional.ofNullable(animal.getInformationA()).orElse("no information");
    		System.out.println(nameA + " " + infoA);
    		if(!animals.contains(nameA)) {
    		animals.add(nameA);
    		informations.add(infoA);
    		System.out.println(nameA + " added to the list of animals\n");
    		for(int i=0; i<nameA.length(); i++)
    			fw.write(nameA.charAt(i));
    		fw.write("\n");
    		for(int i=0; i<infoA.length(); i++)
    			fw.write(infoA.charAt(i));
    		fw.write("\n\n");
    	}else {
    		System.out.println("This name already exist in the list of animals\n");
    	}
    	fw.close();
    	animal.managerActions();
    }
    public static void deleteA() throws IOException {
    	System.out.print("Please enter name of the animal: ");
		nameA = s.nextLine().toLowerCase();
    	informations.remove(animals.indexOf(nameA));
    	animals.remove(animals.indexOf(nameA));
    	System.out.println(nameA + " removed from the list of animals\n");
    	animal.managerActions();
    }
    public static void updateA() throws IOException {
    	System.out.print("Please enter name of the old animal: ");
    	nameA = s.nextLine().toLowerCase();
		System.out.print("Please enter name of the new animal: ");
		String nameR = s.nextLine().toLowerCase();
    	animals.set(animals.indexOf(nameA), nameR);
    	System.out.println(nameA + " replace by " + nameR + "\n");	
    	animal.managerActions();
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
    		animal.userActions();
    	}else {
    		animal.managerActions();
    	}
    }
    public static void searchA(String c) throws IOException {
    	File f = new File("C:\\Users\\PC-BALEN\\eclipse-workspace\\mom\\animal.txt");
		BufferedReader br = new BufferedReader(new FileReader(f));
		System.out.print("Please enter name of the animal to find it: ");
		nameA = s.nextLine().toLowerCase();
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
    	if(animals.contains(nameA)) {
    		System.out.println(animals.get(animals.indexOf(nameA)) + " " +informations.get(animals.indexOf(nameA)));
    	}else {
    		System.out.println("We don't have this animal in list of animals\n");
    	}
    	if(c.equals("u")) {
    		animal.userActions();
    	}else {
    		animal.managerActions();
    	}
    	
    }
}
