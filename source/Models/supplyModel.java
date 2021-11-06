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

public class supplyModel {
		static Scanner s = new Scanner(System.in);
		static LinkedList<String> supplies = new LinkedList<>();
		static List<String> quantityS = new ArrayList<>();
		static List<Integer> priceS = new ArrayList<>();
		static String nameS = "";
		static String quantity = "";
		static int price= 0;
		
	public static void addS() throws IOException {
    	FileWriter fw = new FileWriter("supply.txt", true);
    	System.out.print("Please enter name of the supply: ");
		supply.setNameS(s.nextLine().toLowerCase());
		nameS = Optional.ofNullable(supply.getNameS()).orElse("unknown supply");
		System.out.print("Please enter quantity of the supply: ");
		supply.setQuantity(s.nextLine().toLowerCase());
		quantity = Optional.ofNullable(supply.getQuantity()).orElse("unknown quantity");
		System.out.print("And enter price of the supply: ");
		supply.setPriceS(s.nextInt());
		price = Optional.ofNullable(supply.getPriceS()).orElse(0);
    	if(!supplies.contains(nameS)) {
    		supplies.add(nameS);
    		quantityS.add(quantity);
    		priceS.add(price);
    		for(int i=0; i<nameS.length(); i++)
    			fw.write(nameS.charAt(i));
    		fw.write("\n");
    		for(int i=0; i<quantity.length(); i++)
    			fw.write(quantity.charAt(i));
    		fw.write("\n");
    		for(int i=0; i<String.valueOf(price).length(); i++)
    			fw.write(String.valueOf(price).charAt(i));
    		fw.write("\n\n");
        	System.out.println(quantity + " of " + nameS + " by " + price + "$ added to the list of supplies\n");
        	expenditureModel.increaseX(price);
    	}else {
    		System.out.println("This name already exist in the list of supplies\n");
    	}
    	fw.close();
    	supply.managerActions();
    }
    public static void deleteS() throws IOException {
    	System.out.print("Please enter name of the supply: ");
		nameS = s.nextLine().toLowerCase();
    	quantityS.remove(supplies.indexOf(nameS));
    	expenditureModel.decreaseX(priceS.get(supplies.indexOf(nameS)));
    	priceS.remove(supplies.indexOf(nameS));
    	supplies.remove(supplies.indexOf(nameS));
    	System.out.println(nameS + " removed from the list of supplies\n");
    	supply.managerActions();
    }
    public static void updateS() throws IOException {
    	System.out.print("Please enter name of the old supply: ");
		nameS = s.nextLine().toLowerCase();
		System.out.print("Please enter name of the new supply: ");
		String nameR = s.nextLine().toLowerCase();
    	supplies.set(supplies.indexOf(nameS), nameR);
    	System.out.println(nameS + " replaced by " + nameR + "\n");
    	supply.managerActions();
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
    	supply.managerActions();
    }
    public static void searchS() throws IOException {
    	File f = new File("C:\\Users\\PC-BALEN\\eclipse-workspace\\mom\\supply.txt");
		BufferedReader br = new BufferedReader(new FileReader(f));
		System.out.print("Please enter name of the supply to find it: ");
		nameS = s.nextLine().toLowerCase();
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
    	if(supplies.contains(nameS)) {
    		System.out.println(quantityS.get(supplies.indexOf(nameS)) + " of " + supplies.get(supplies.indexOf(nameS)) + " by " + priceS.get(supplies.indexOf(nameS)) +"$");
    	}else {
    		System.out.println("We don't have this employee in list of employees\n");
    	}
    	supply.managerActions();
    }
}
