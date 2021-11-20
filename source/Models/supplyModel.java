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
		//FileWriter fw = new FileWriter("supply.txt", true);
    	System.out.print("Please enter name of the supply: ");
		supply.setNameS(s.nextLine().toLowerCase());
		nameS = Optional.ofNullable(supply.getNameS()).orElse("unknown supply");
		System.out.print("please enter quantity of the supply: ");
		supply.setQuantity(s.nextLine().toLowerCase());
		quantity = Optional.ofNullable(supply.getQuantity()).orElse("unknown quantity");
		System.out.print("And enter price of the supply: ");
		supply.setPriceS(s.nextInt());
		price = Optional.ofNullable(supply.getPriceS()).orElse(0);
    	if(!supplies.contains(nameS)) {
    		supplies.add(nameS);
    		quantityS.add(quantity);
    		priceS.add(price);
    		/*for(int i=0; i<nameS.length(); i++)
    			fw.write(nameS.charAt(i));
    		fw.write("\n");
    		for(int i=0; i<infoS.length(); i++)
    			fw.write(infoS.charAt(i));
    		fw.write("\n\n");*/
    		try {
    			con = DriverManager.getConnection(url, uname, password);
    			query = "insert into supply (names, quantities, prices) values (?, ?)";
    			PreparedStatement Pstatement = con.prepareStatement(query);
    			Pstatement.setString(1, nameS);
    			Pstatement.setString(2, quantity);
    			Pstatement.setString(3, String.valueOf(price));
    			Pstatement.executeUpdate();
    			Pstatement.close();
        		con.close();
    		}catch(SQLException e) {
    			e.printStackTrace();
    		}
    		System.out.println(nameS + " added to the list of supplies\n");
    	}else {
    		System.out.println("This name already exist in the list of supplies\n");
    	}
    	expenditureModel.increaseX(price);
    	//fw.close();
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
			query = "DELETE FROM supply WHERE names=?";
			PreparedStatement statement = con.prepareStatement(query);
			statement.setString(1, nameS);
			statement.executeUpdate();
			statement.close();
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
    	System.out.println(nameS + " removed from the list of supplies\n");
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
			query = "UPDATE supply SET names=? WHERE names=?";
			PreparedStatement statement = con.prepareStatement(query);
			statement.setString(1, nameR);
			statement.setString(2, nameS);
			statement.executeUpdate();
			statement.close();
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
    	System.out.println(nameS + " replace by " + nameR + "\n");	
    	supply.managerActions();
    }
    public static void viewS() throws IOException, SQLException {
    	query = "select * from supply";
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
    	/*FileWriter fw = new FileWriter("employee.txt", true);
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
    	}*/
    	System.out.println();
    	supply.managerActions();
    }
    public static void searchS() throws IOException, SQLException {
    	//FileWriter fw = new FileWriter("employee.txt", true);
    	//File f = new File("C:\\Users\\PC-BALEN\\eclipse-workspace\\mom\\employee.txt");
		//BufferedReader br = new BufferedReader(new FileReader(f));
		/*String st;
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
		}*/
		//System.out.print("Please enter name of the supply: ");
		//nameS = s.nextLine();
    	System.out.print("Please enter name of the supply to find it: ");
		nameS = s.nextLine();
		try {
			con = DriverManager.getConnection(url, uname, password);
			query = new String("SELECT * FROM supply where names=?");
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
