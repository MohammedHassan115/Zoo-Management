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

public class supplyModel {
	static Scanner s = new Scanner(System.in);
	static LinkedList<String> supplies = new LinkedList<>();
	static List<String> quantityS = new ArrayList<>();
	static List<Integer> priceS = new ArrayList<>();
	static String nameS = "";
	static String quantity = "";
	static int price= 0;
	static String url = "jdbc:mysql://localhost:3306/zoo";
	static String uname = "root";
	static String password = "12345";
	static String query = "";
	static Connection con = null;
	
	public static void addS() throws IOException, SQLException {
    	System.out.print("Please enter name of the supply: ");
		supply.setNameS(s.nextLine().toLowerCase());
		nameS = Optional.ofNullable(supply.getNameS()).orElse("unknown supply");
		System.out.print("please enter quantity of the supply: ");
		supply.setQuantity(s.nextLine().toLowerCase());
		quantity = Optional.ofNullable(supply.getQuantity()).orElse("unknown quantity");
		System.out.print("And enter price of the supply: ");
		supply.setPriceS(s.nextInt());
		price = Optional.ofNullable(supply.getPriceS()).orElse(0);
    		supplies.add(nameS);
    		quantityS.add(quantity);
    		priceS.add(price);
    		try {
    			con = DriverManager.getConnection(url, uname, password);
    			query = "insert into supplies (names, quantities, prices) values (?, ?, ?)";
    			PreparedStatement Pstatement = con.prepareStatement(query);
    			Pstatement.setString(1, nameS);
    			Pstatement.setString(2, quantity);
    			Pstatement.setString(3, String.valueOf(price));
    			Pstatement.executeUpdate();
    			Pstatement.close();
        		con.close();
        		System.out.println(nameS + " added to the list of supplies\n");
    		}catch(SQLException e) {
    			e.printStackTrace();
    		}
    	expenditureModel.increaseX(price);
    	supply.managerActions();
    }
	public static void deleteS() throws IOException, SQLException {
    	System.out.print("Please enter name of the supply: ");
		nameS = s.nextLine();
		if(supplies.contains(nameS)) {
		quantityS.remove(supplies.indexOf(nameS));
		priceS.remove(supplies.indexOf(nameS));
        supplies.remove(supplies.indexOf(nameS));
		}
    	try {
			con = DriverManager.getConnection(url, uname, password);
			query = "DELETE FROM supplies WHERE names=?";
			PreparedStatement statement = con.prepareStatement(query);
			statement.setString(1, nameS);
			statement.executeUpdate();
			statement.close();
			con.close();
			System.out.println(nameS + " removed from the list of supplies\n");
		}catch(SQLException e) {
			e.printStackTrace();
		}
    	supply.managerActions();
    }
    public static void updateS() throws IOException, SQLException {
    	System.out.print("Please enter name of the old supply: ");
    	nameS = s.nextLine().toLowerCase();
		System.out.print("Please enter name of the new supply: ");
		String nameR = s.nextLine().toLowerCase();
		if(supplies.contains(nameS))
    	supplies.set(supplies.indexOf(nameS), nameR);
    	try {
			con = DriverManager.getConnection(url, uname, password);
			query = "UPDATE supplies SET names=? WHERE names=?";
			PreparedStatement statement = con.prepareStatement(query);
			statement.setString(1, nameR);
			statement.setString(2, nameS);
			statement.executeUpdate();
			statement.close();
			con.close();
			System.out.println(nameS + " replace by " + nameR + "\n");
		}catch(SQLException e) {
			e.printStackTrace();
		}	
    	supply.managerActions();
    }
    public static void viewS() throws IOException, SQLException {
    	query = "select * from supplies";
		try {
			con = DriverManager.getConnection(url, uname, password);
			Statement statement = con.createStatement();
			ResultSet result = statement.executeQuery(query);
			while(result.next()) {
				String names  = result.getString("names");
				String quantity  = result.getString("quantities");
				String price  = result.getString("prices");
				System.out.println(names + ": " + quantity + ": " + price);
			}
			statement.close();
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
    	System.out.println();
    	supply.managerActions();
    }
    public static void searchS() throws IOException, SQLException {
    	System.out.print("Please enter name of the supply to find it: ");
		nameS = s.nextLine();
		try {
			con = DriverManager.getConnection(url, uname, password);
			query = new String("SELECT * FROM supplies where names=?");
		    PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, nameS);
			ResultSet result = ps.executeQuery();
			while(result.next()) {
				String names  = result.getString("names");
				String quantity  = result.getString("quantities");
				String price  = result.getString("prices");
				System.out.println(names + ": " + quantity + ": " + price +"$");
			}
			ps.close();
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
    	supply.managerActions();
    }
}
