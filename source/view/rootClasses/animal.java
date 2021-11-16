package m;

import java.io.IOException;
import java.util.Scanner;

public class animal {
	static Scanner s = new Scanner(System.in);
	static String chooseA = "";
	private static String nameA  = "";
	private static String informationA = "";
	public static void userActions() throws IOException {
    	System.out.println("What you want to do with animals:\n* view - show list of animals\n* search - to find a specfic animal\n* back - back to list of actions");
    	chooseA = s.nextLine().toLowerCase();
    	if(chooseA.equals("view")) {
    		animalModel.viewA("u");
    	}else if(chooseA.equals("search")) {
    		animalModel.searchA("u");
    	}else if(chooseA.equals("back")) {
    		
    	}else {
    		System.out.println("We don't have this action in list of actions");
    		userActions();
    	}
    }
	public static void managerActions() throws IOException {
    	System.out.println("What you want to do with animals:\n* add - add an animal to list of animals\n* delete - remove an animal to list of animals\n* update  - replace an animal with another animal in list of animals\n* view - show list of animals\n* search - to find a specfic animal\n* back - back to list of actions");
    	chooseA = s.nextLine().toLowerCase();
    	if(chooseA.equals("add")) {
    		animalModel.addA();
    	} else if(chooseA.equals("delete")) {
    		animalModel.deleteA();
    	}else if(chooseA.equals("update")) {
    		animalModel.updateA();
    	}else if(chooseA.equals("view")) {
    		animalModel.viewA("m");
    	}else if(chooseA.equals("search")) {
    		animalModel.searchA("m");
    	}else if(chooseA.equals("back")) {
    		
    	}else {
    		System.out.println("We don't have this action in list of actions\n");
    		managerActions();
    	}
    }
	public static void setNameA(String n) {
		nameA = n;
	}
	public static String getNameA() {
		return nameA;
	}
	public static void setInformationA(String infoA) {
		informationA = infoA;
	}
	public static String getInformationA() {
		return informationA;
	}
 }
