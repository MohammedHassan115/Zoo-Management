package m;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Optional;
import java.util.Scanner;

public class view {
	static String username = "";
	static String password = "";
	
	public view() throws IOException {
		Scanner ss = new Scanner(System.in);
	    Socket echoSocket = null;
		PrintWriter out = null;
		BufferedReader in = null;
		
		System.out.println("Please enter username and password:");
    	System.out.print("Username: ");
    	login.setUsername(ss.nextLine());
    	username = Optional.ofNullable(login.getUsername()).orElse("unknown");
    	System.out.print("Password: ");
    	login.setPassword(ss.nextLine());
    	password = Optional.ofNullable(login.getPassword()).orElse("0000");
    	System.out.println();
    	try {
    		echoSocket = new Socket("127.0.0.1", 7777); 
    		out = new PrintWriter(echoSocket.getOutputStream(), true);
    		in=new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
    		} catch (UnknownHostException ee) {
    		System.err.println("Don't know host: toshiba.");
    		System.exit(1);
    			} catch (IOException ei) {
    			System.err.println("Couldn't get I/O for "
    			+ "the connection to: toshiba.");
    			System.exit(1);
    			}
    			String userInput = username + " " + password;
    			System.out.println(in.readLine());
    			out.println(userInput);
    			System.out.println("echo: " + in.readLine() + "\n");
    			out.close();
    			in.close();
    			echoSocket.close();
    	animal a = new animal();
    	employee e = new employee();
    	supply sp = new supply();
    	income i = new income();
    	expenditure ex = new expenditure();
    	ticket t = new ticket();
    	
    	String actions = "";
    	if(username.equals("mohammed123") && password.equals("12345!@#$%")) {
    		System.out.println("Hello manager\n");
    		while(!actions.equals("exit")) {
        		display_options1();
        		System.out.println("Select an action: ");
                actions = ss.next().toLowerCase();
                System.out.println();    
        	switch(actions){
        	case "animal":
                a.managerActions();
            break;
        	case "employee":
                e.managerActions();
            break;
        	case "supply":
                sp.managerActions();
            break;
        	case "income":
                i.managerActions();
            break;
        	case "expenditure":
                ex.managerActions();
            break;
        	case "ticket":
                t.managerActions();
            break;
        	case "back":
                new view();
            break;
        	case "exit":
                System.exit(0);
            break;
            default:
            	System.out.println("Please choose an action from list of actions\n");
        	}
        }
    	}
        else {
        	System.out.println("Hello user\n");
        	while(!actions.equals("exit")) {
    		display_options2();
    		System.out.println("Select an action: ");
            actions = ss.next().toLowerCase();
            System.out.println();    
            switch(actions){
            case "animal":
            a.userActions();
            break;
            case "ticket":
            t.userActions();
            break;
            case "back":
                new view();
            break;
            case "exit":
                System.exit(0);
            break;
            default:
            	System.out.println("Please choose an action from list of actions\n");
    	}
    }
    }
	}
	public static void display_options1(){
        System.out.println("Options:");
        System.out.println("1- animal - show you list of sub actions with animals");
        System.out.println("2- employee - show you list of sub actions with employees");
        System.out.println("3- supply - show you list of sub actions with supplies");
        System.out.println("4- income - show you list of sub actions with income");
        System.out.println("4- expenditure - show you list of sub actions with expenditure");
        System.out.println("5- ticket - show list of sub actions with tickets");
        System.out.println("6- back - back to username and password place");

        System.out.println("--");
        System.out.println("options - display this options message");
        System.out.println("exit - exit the program\n");
    }
	public static void display_options2(){
        System.out.println("Options:");
        System.out.println("1- animal - show you list of sub actions with animals");
        System.out.println("2- ticket - show list of sub actions with tickets");
        System.out.println("3- back - back to username and password place");

        System.out.println("--");
        System.out.println("options - display this options message");
        System.out.println("exit - exit the program\n");
    }
}
