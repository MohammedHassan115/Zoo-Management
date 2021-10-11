package m;
import java.util.Scanner;

public class Zoo {
	static String email = "";
	static String password = "";
    public static void main(String args[]) {
    	EP();
    }
    	
	public static void display_options1(){
        System.out.println("Options:");
        System.out.println("1- animal - show you list of sub actions with animals");
        System.out.println("2- employee - show you list of sub actions with employees");
        System.out.println("3- supply - show you list of sub actions with supplies");
        System.out.println("4- income - show you list of sub actions with income");
        System.out.println("4- expenditure - show you list of sub actions with expenditure");
        System.out.println("5- ticket - show list of sub actions with tickets");
        System.out.println("6- back - back to email and password please");

        System.out.println("--");
        System.out.println("options - display this options message");
        System.out.println("exit - exit the program\n");
    }
	public static void display_options2(){
        System.out.println("Options:");
        System.out.println("1- animal - show you list of sub actions with animals");
        System.out.println("2- ticket - show list of sub actions with tickets");
        System.out.println("3- back - back to email and password please");

        System.out.println("--");
        System.out.println("options - display this options message");
        System.out.println("exit - exit the program\n");
    }
	public static void EP(){
		Scanner s = new Scanner(System.in);
		System.out.println("Please enter email and password:");
    	System.out.print("Email: ");
    	email = s.nextLine();
    	System.out.print("Password: ");
    	password = s.nextLine();
    	System.out.println();
    	animal a = new animal();
    	employee e = new employee();
    	supply sp = new supply();
    	income i = new income();
    	expenditure ex = new expenditure();
    	ticket t = new ticket();
    	login l = new login();
    	String actions = "";
    	if(email.equals("muhamad23@gmail.com") && password.equals("12345!@#$%")) {
    		while(!actions.equals("exit")) {
        		display_options1();
        		System.out.println("Select an action: ");
                actions = s.next().toLowerCase();
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
                t.publicActions();
            break;
        	case "back":
                EP();
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
        	while(!actions.equals("exit")) {
    		display_options2();
    		System.out.println("Select an action: ");
            actions = s.next().toLowerCase();
            System.out.println();    
            switch(actions){
            case "animal":
            a.userActions();
            break;
            case "ticket":
            t.publicActions();
            break;
            case "back":
                EP();
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
}
