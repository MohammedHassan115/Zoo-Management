package m;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
	static String url = "jdbc:mysql://localhost:3306/zoo";
	static String uname = "root";
	static String password = "12345";
	static String query = "";
	static Connection con = null;
	
	public static void addA() throws IOException, SQLException {
		//FileWriter fw = new FileWriter("animal.txt", true);
    	System.out.print("Please enter name of the animal: ");
		animal.setNameA(s.nextLine().toLowerCase());
		nameA = Optional.ofNullable(animal.getNameA()).orElse("unknown animal");
		System.out.print("And enter information about the animal: ");
		animal.setInformationA(s.nextLine().toLowerCase());
		infoA = Optional.ofNullable(animal.getInformationA()).orElse("unknown information");
    	if(!animals.contains(nameA)) {
    		animals.add(nameA);
    		informations.add(infoA);
    		/*for(int i=0; i<nameA.length(); i++)
    			fw.write(nameA.charAt(i));
    		fw.write("\n");
    		for(int i=0; i<infoA.length(); i++)
    			fw.write(infoA.charAt(i));
    		fw.write("\n\n");*/
    		try {
    			con = DriverManager.getConnection(url, uname, password);
    			query = "insert into animals (names, information) values (?, ?)";
    			PreparedStatement Pstatement = con.prepareStatement(query);
    			Pstatement.setString(1, nameA);
    			Pstatement.setString(2, infoA);
    			int row = Pstatement.executeUpdate();
    			System.out.println(row + " added\n");
    			Pstatement.close();
        		con.close();
    		}catch(SQLException e) {
    			e.printStackTrace();
    		}
    		System.out.println(nameA + " added to the list of animals\n");
    	}else {
    		System.out.println("This name already exist in the list of animals\n");
    	}
    	//fw.close();
    	animal.managerActions();
    }
	public static void deleteA() throws IOException, SQLException {
    	System.out.print("Please enter name of the animal: ");
		nameA = s.nextLine();
		if(animals.contains(nameA)) {
		informations.remove(animals.indexOf(nameA));
		animals.remove(animals.indexOf(nameA));
		}
    	try {
			con = DriverManager.getConnection(url, uname, password);
			query = "DELETE FROM animals WHERE names=?";
			PreparedStatement statement = con.prepareStatement(query);
			statement.setString(1, nameA);
			statement.executeUpdate();
			statement.close();
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
    	System.out.println(nameA + " removed from the list of animals\n");
    	animal.managerActions();
    }
    public static void updateA() throws IOException, SQLException {
    	System.out.print("Please enter name of the old animal: ");
    	nameA = s.nextLine().toLowerCase();
		System.out.print("Please enter name of the new animal: ");
		String nameR = s.nextLine().toLowerCase();
    	//animals.set(animals.indexOf(nameO), nameR);
    	try {
			con = DriverManager.getConnection(url, uname, password);
			query = "UPDATE animals SET names=? WHERE names=?";
			PreparedStatement statement = con.prepareStatement(query);
			statement.setString(1, nameR);
			statement.setString(2, nameA);
			System.out.println(statement.executeUpdate());
			statement.close();
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
    	System.out.println(nameA + " replace by " + nameR + "\n");	
    	animal.managerActions();
    }
    public static void viewA(String c) throws IOException, SQLException {
    	query = "select * from animals";
		try {
			con = DriverManager.getConnection(url, uname, password);
			Statement statement = con.createStatement();
			ResultSet result = statement.executeQuery(query);
			while(result.next()) {
				String names  = result.getString("names");
				String informations  = result.getString("information");
				System.out.println(names + ": " + informations);
			}
			statement.close();
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
    	/*FileWriter fw = new FileWriter("animal.txt", true);
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
    	}*/
    	System.out.println();
    	if(c.equals("u")) {
    		animal.userActions();
    	}else {
    		animal.managerActions();
    	}
    }
    public static void searchA(String c) throws IOException, SQLException {
    	//FileWriter fw = new FileWriter("animal.txt", true);
    	//File f = new File("C:\\Users\\PC-BALEN\\eclipse-workspace\\mom\\animal.txt");
		//BufferedReader br = new BufferedReader(new FileReader(f));
		/*String st;
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
		}*/
    	System.out.print("Please enter name of the animal to find it: ");
		nameA = s.nextLine();
		try {
			con = DriverManager.getConnection(url, uname, password);
			query = new String("SELECT * FROM animals where names=?");
		    PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, nameA);
			ResultSet result = ps.executeQuery();
			while(result.next()) {
				String names  = result.getString("names");
				String informations  = result.getString("information");
				System.out.println(names + ": " + informations);
			}
			ps.close();
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
    	if(c.equals("u")) {
    		animal.userActions();
    	}else {
    		animal.managerActions();
    	}
    	
    }
}
