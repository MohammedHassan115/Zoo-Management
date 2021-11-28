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
	static List<String> Informations = new ArrayList<>();
	static String nameA = "";
	static String infoA = "";
	static String url = "jdbc:mysql://localhost:3306/zoo";
	static String uname = "root";
	static String password = "12345";
	static String query = "";
	static Connection con = null;
	
	public static void addA() throws IOException, SQLException {
    	System.out.print("Please enter name of the animal: ");
		animal.setNameA(s.nextLine().toLowerCase());
		nameA = Optional.ofNullable(animal.getNameA()).orElse("unknown animal");
		System.out.print("And enter information about the animal: ");
		animal.setInformationA(s.nextLine().toLowerCase());
		infoA = Optional.ofNullable(animal.getInformationA()).orElse("unknown information");
    		animals.add(nameA);
    		Informations.add(infoA);
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
        		System.out.println(nameA + " added to the list of animals\n");
    		}catch(SQLException e) {
    			e.printStackTrace();
    		}
    	animal.managerActions();
    }
	public static void deleteA() throws IOException, SQLException {
    	System.out.print("Please enter name of the animal: ");
		nameA = s.nextLine();
		if(animals.contains(nameA)) {
		Informations.remove(animals.indexOf(nameA));
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
			System.out.println(nameA + " removed from the list of animals\n");
		}catch(SQLException e) {
			e.printStackTrace();
		}
    	animal.managerActions();
    }
    public static void updateA() throws IOException, SQLException {
    	System.out.print("Please enter name of the old animal: ");
    	nameA = s.nextLine().toLowerCase();
		System.out.print("Please enter name of the new animal: ");
		String nameR = s.nextLine().toLowerCase();
    	try {
			con = DriverManager.getConnection(url, uname, password);
			query = "UPDATE animals SET names=? WHERE names=?";
			PreparedStatement statement = con.prepareStatement(query);
			statement.setString(1, nameR);
			statement.setString(2, nameA);
			System.out.println(statement.executeUpdate());
			statement.close();
			con.close();
			System.out.println(nameA + " replace by " + nameR + "\n");
		}catch(SQLException e) {
			e.printStackTrace();
		}	
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
    	System.out.println();
    	if(c.equals("u")) {
    		animal.userActions();
    	}else {
    		animal.managerActions();
    	}
    }
    public static void searchA(String c) throws IOException, SQLException {
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
