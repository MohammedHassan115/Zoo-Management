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

public class employeeModel {
	static Scanner s = new Scanner(System.in);
	static LinkedList<String> employees = new LinkedList<>();
	static List<String> informations = new ArrayList<>();
	static String nameE = "";
	static String infoE = "";
	static String url = "jdbc:mysql://localhost:3306/zoo";
	static String uname = "root";
	static String password = "12345";
	static String query = "";
	static Connection con = null;
	
	public static void addE() throws IOException, SQLException {
		//FileWriter fw = new FileWriter("employee.txt", true);
    	System.out.print("Please enter name of the employee: ");
		employee.setNameE(s.nextLine().toLowerCase());
		nameE = Optional.ofNullable(employee.getNameE()).orElse("unknown employee");
		System.out.print("And enter information about the employee: ");
		employee.setInformationE(s.nextLine().toLowerCase());
		infoE = Optional.ofNullable(employee.getInformationE()).orElse("unknown information");
    	if(!employees.contains(nameE)) {
    		employees.add(nameE);
    		informations.add(infoE);
    		/*for(int i=0; i<nameE.length(); i++)
    			fw.write(nameE.charAt(i));
    		fw.write("\n");
    		for(int i=0; i<infoA.length(); i++)
    			fw.write(infoE.charAt(i));
    		fw.write("\n\n");*/
    		try {
    			con = DriverManager.getConnection(url, uname, password);
    			query = "insert into employees (names, information) values (?, ?)";
    			PreparedStatement Pstatement = con.prepareStatement(query);
    			Pstatement.setString(1, nameE);
    			Pstatement.setString(2, infoE);
    			Pstatement.executeUpdate();
    			Pstatement.close();
        		con.close();
    		}catch(SQLException e) {
    			e.printStackTrace();
    		}
    		System.out.println(nameE + " added to the list of employees\n");
    	}else {
    		System.out.println("This name already exist in the list of employees\n");
    	}
    	//fw.close();
    	employee.managerActions();
    }
	public static void deleteE() throws IOException, SQLException {
    	System.out.print("Please enter name of the employee: ");
		nameE = s.nextLine();
		if(employees.contains(nameE)) {
		informations.remove(employees.indexOf(nameE));
		employees.remove(employees.indexOf(nameE));
		}
    	try {
			con = DriverManager.getConnection(url, uname, password);
			query = "DELETE FROM employees WHERE names=?";
			PreparedStatement statement = con.prepareStatement(query);
			statement.setString(1, nameE);
			statement.executeUpdate();
			statement.close();
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
    	System.out.println(nameE + " removed from the list of employees\n");
    	employee.managerActions();
    }
    public static void updateE() throws IOException, SQLException {
    	System.out.print("Please enter name of the old employee: ");
    	nameE = s.nextLine().toLowerCase();
		System.out.print("Please enter name of the new employee: ");
		String nameR = s.nextLine().toLowerCase();
		if(employees.contains(nameE))
    	employees.set(employees.indexOf(nameE), nameR);
    	try {
			con = DriverManager.getConnection(url, uname, password);
			query = "UPDATE employees SET names=? WHERE names=?";
			PreparedStatement statement = con.prepareStatement(query);
			statement.setString(1, nameR);
			statement.setString(2, nameE);
			System.out.println(statement.executeUpdate());
			statement.close();
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
    	System.out.println(nameE + " replace by " + nameR + "\n");	
    	employee.managerActions();
    }
    public static void viewE() throws IOException, SQLException {
    	query = "select * from employees";
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
    	employee.managerActions();
    }
    public static void searchE() throws IOException, SQLException {
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
		System.out.print("Please enter name of the employee to find it: ");
		nameE = s.nextLine();
		try {
			con = DriverManager.getConnection(url, uname, password);
			query = new String("SELECT * FROM employees where names=?");
		    PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, nameE);
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
    	employee.managerActions();
    	
    }
}
