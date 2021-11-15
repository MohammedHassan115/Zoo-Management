package m;

import java.io.IOException;
import java.util.Optional;
import java.util.Scanner;

public class view {
	static String username = "";
	static String password = "";
	
	public view() throws IOException {
		Scanner ss = new Scanner(System.in);
		
		System.out.println("Please enter username and password:");
    	System.out.print("Username: ");
    	login.setUsername(ss.nextLine());
    	username = Optional.ofNullable(login.getUsername()).orElse("unknown");
    	System.out.print("Password: ");
    	login.setPassword(ss.nextLine());
    	password = Optional.ofNullable(login.getPassword()).orElse("0000");
    	System.out.println();
    	
    	String actions = "";
    	if(username.equals("mohammed123") && password.equals("12345!@#$%")) {
    		System.out.println("Hello manager");
    		while(!actions.equals("exit")) {
        		display_options1();
        		System.out.println("Select an action: ");
                actions = ss.next().toLowerCase();
                System.out.println();    
        	switch(actions){
        	case "animal":
                animal.managerActions();
            break;
        	case "employee":
                employee.managerActions();
            break;
        	case "supply":
                supply.managerActions();
            break;
        	case "income":
                income.managerActions();
            break;
        	case "expenditure":
                expenditure.managerActions();
            break;
        	case "ticket":
                ticket.managerActions();
            break;
        	case "server":
                new client();
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
            animal.userActions();
            break;
            case "ticket":
            ticket.userActions();
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
        System.out.println("\nOptions:");
        System.out.println("1- animal - show you list of sub actions with animals");
        System.out.println("2- employee - show you list of sub actions with employees");
        System.out.println("3- supply - show you list of sub actions with supplies");
        System.out.println("4- income - show you list of sub actions with income");
        System.out.println("4- expenditure - show you list of sub actions with expenditure");
        System.out.println("5- ticket - show list of sub actions with tickets");
        System.out.println("6- server - client will conect to server");
        System.out.println("7- back - back to username and password place");

        System.out.println("--");
        System.out.println("options - display this options message");
        System.out.println("exit - exit the program\n");
    }
	public static void display_options2(){
        System.out.println("Options:");
        System.out.println("1- animal - show you list of sub actions with animals");
        System.out.println("2- ticket - show list of sub actions with tickets");
        System.out.println("4- back - back to username and password place");

        System.out.println("--");
        System.out.println("options - display this options message");
        System.out.println("exit - exit the program\n");
    }
}
