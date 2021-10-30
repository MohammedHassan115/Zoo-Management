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

public class employeeModel {
	static Scanner s = new Scanner(System.in);
	static LinkedList<String> employees = new LinkedList<>();
	static List<String> informations = new ArrayList<>();
	static String nameE = "";
	static String infoE = "";
	
	public static void addE() throws IOException {
    	FileWriter fw = new FileWriter("employee.txt", true);
    	System.out.print("Please enter name of the employee: ");
		employee.setNameE(s.nextLine().toLowerCase());
		nameE = Optional.ofNullable(employee.getNameE()).orElse("unknown employee");
		System.out.print("And enter information about the emloyee: ");
		employee.setInformationE(s.nextLine().toLowerCase());
		infoE = Optional.ofNullable(employee.getInformationE()).orElse("unknown information");
    	if(!employees.contains(nameE)) {
    		employees.add(nameE);
    		informations.add(infoE);
    		System.out.println(nameE + " added to the list of employees\n");
    		for(int i=0; i<nameE.length(); i++)
    			fw.write(nameE.charAt(i));
    		fw.write("\n");
    		for(int i=0; i<infoE.length(); i++)
    			fw.write(infoE.charAt(i));
    		fw.write("\n\n");
    	}else {
    		System.out.println("This name already exist in the list of employees");
    	}
    	fw.close();
    	employee.managerActions();
    }
    public static void deleteE() throws IOException {
    	System.out.print("Please enter name of the employee: ");
		nameE = s.nextLine().toLowerCase();
    	informations.remove(employees.indexOf(nameE));
    	employees.remove(employees.indexOf(nameE));
    	System.out.println(nameE + " removed from the list of employees\n");
    	employee.managerActions();
    }
    public static void updateE() throws IOException {
    	System.out.print("Please enter name of the old employee: ");
		nameE = s.nextLine().toLowerCase();
		System.out.print("Please enter name of the new employee: ");
		String nameR = s.nextLine().toLowerCase();
    	employees.set(employees.indexOf(nameE), nameR);
    	System.out.println(nameE + " replaced by " + nameR + "\n");
    	employee.managerActions();
    }
    public static void viewE() throws IOException {
    	File f = new File("C:\\Users\\PC-BALEN\\eclipse-workspace\\mom\\employee.txt");
		BufferedReader br = new BufferedReader(new FileReader(f));
		String st;
		int s = 0;
		while((st = br.readLine()) != null){
			if(!st.equals("")) {
			if(s==0) {
				employees.add(st);
				s = 1;
			}else {
				informations.add(st);
				s = 0;
			}
			}
		}
    	int j = 0;
    	System.out.println("List of employees:");
    	for(int i=0; i<employees.size(); i++) {
    		if(!employees.get(i).equals("")) {
    			j = i;
    		    j++;
    		    System.out.println(j + "- " + employees.get(i) + " " + informations.get(i));
    		}
    	}
    	System.out.println();
    	employee.managerActions();
    }
    public static void searchE() throws IOException {
    	File f = new File("C:\\Users\\PC-BALEN\\eclipse-workspace\\mom\\employee.txt");
		BufferedReader br = new BufferedReader(new FileReader(f));
		System.out.print("Please enter name of the employee to find information about it: ");
		nameE = s.nextLine().toLowerCase();
		String st;
		int s = 0;
		while((st = br.readLine()) != null){
			if(!st.equals("")) {
			if(s==0) {
				employees.add(st);
				s = 1;
			}else {
				informations.add(st);
				s = 0;
			}
			}
			
		}
    	if(employees.contains(nameE)) {
    		System.out.println(employees.get(employees.indexOf(nameE)) + " " + informations.get(employees.indexOf(nameE)));
    	}else {
    		System.out.println("We don't have this employee in list of employees\n");
    	}
    	employee.managerActions();
    }
}
