package com.company;
import java.util.Scanner;
public class ZooSystem {

    public static void main(String[] args) {
	    Animal[] animals = {
            new Penguin("Peter", 30),
        };
        Zoo zoo=new Zoo(animals);

        Scanner scan= new Scanner(System.in);

        String action="";
        zoo.display_summary();
        zoo.display_verbose();
        display_options();

        while(!action.equals("exit")){
            System.out.println("\nSelect action: ");
            action = scan.next().toLowerCase();
            System.out.println();

            switch(action){
                case "add":
                    zoo.add_animal();
                    zoo.display_summary();
                    break;
                case "delete":
                    zoo.delete_animal();
                    zoo.display_summary();
                    break;
                case "display":
                    zoo.display_animal();
                    break;
                case "summary":
                    zoo.display_summary();
                    break;
                case "verbose":
                    zoo.display_verbose();
                    break;
                case "options":
                    display_options();
                    break;
                case "exit":
                    System.out.println("GoodBye");
                    break;
                default:
                    System.out.println("Not a valid command");
            }
        }
    }
    public static void display_options(){
        System.out.println("Options:");
        System.out.println("add - add an animal");
        System.out.println("delete - delete an animal");
        System.out.println("display - display animal details");
        System.out.println("summary - get summary of animals");
        System.out.println("verbose - get verbose details of all animals");

        System.out.println("--");
        System.out.println("options - display this options message");
        System.out.println("exit - exit the program");
    }
}
