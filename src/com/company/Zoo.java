package com.company;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.lang.Integer;

public class Zoo {
    private ArrayList<Animal> animals = new ArrayList<Animal>();
    private HashMap<String, Integer> speciesCounts = new HashMap<String, Integer>();

    public Zoo(Animal[] animals) {
        Collections.addAll(this.animals, animals);


        for (Animal animal : this.animals) {
            if (speciesCounts.containsKey(animal.getSpecies()))
                speciesCounts.put(animal.getSpecies(), speciesCounts.get(animal.getSpecies()) + 1);
            else
                speciesCounts.put(animal.getSpecies(), 1);

        }
    }

    public void add_animal() {
        System.out.println("what animal would you like to add to the zoo ? (i.e. penguin peter)");
        Scanner scan = new Scanner(System.in);
        String species = scan.next().toLowerCase();
        String name = scan.next();

        switch(species) {
            case "penguin":
                System.out.printf("How fast does %s swim? (i.e. 40): ", name);
                int speed = Integer.parseInt(scan.next());
                this.animals.add(new Penguin(name, speed));
                speciesCounts.put("Penguin", speciesCounts.get("Penguin") + 1);
                break;
            default:
                System.out.printf("We don't have %ss in this zoo!\n", name);
        }
    }
    public void display_summary() {
        System.out.println("summary:");
        System.out.printf("There are %d animals in the zoo.\n", this.animals.size());

        for(Map.Entry<String, Integer> set : this.speciesCounts.entrySet())
            System.out.printf("%d %s(s)\n", set.getValue(), set.getKey());
        System.out.println();

    }
    public void display_verbose() {
        System.out.println("Verbose:");
        System.out.println("     Name     Species");
        int index = 1;
        for(Animal a : animals) {
            System.out.printf("%-2d: %-8s %-8s\n", index, a.name, a.species);
            index++;
        }
        System.out.println();
    }
    public void display_animal() {
        System.out.println("What animal would you like to display information about? (enter a name)");
        Scanner scan = new Scanner(System.in);
        String name = scan.next();

        getAnimal(name).display();

    }
    public void delete_animal() {
        System.out.println("What animal would you like to remove? (enter a name)");
        Scanner scan = new Scanner(System.in);
        String name = scan.next();
        boolean deleted = false;

        for(int i = 0; i < animals.size(); i++) {
            if(animals.get(i).getName().toLowerCase().equals(name.toLowerCase())) {
                String species = animals.get(i).getSpecies();
                int count = speciesCounts.get(species);
                speciesCounts.put(species, count-1);
                animals.remove(i);
                deleted = true;
            }
            if(deleted)
                System.out.printf("Removed %s from the zoo!\n", name);
            else
                System.out.printf("Couldn't find %s in the zoo!\n", name);
        }
    }
    private boolean has_animal(String name) {
        boolean b = false;
        for(Animal animal : animals)
            if(animal.getName().toLowerCase().equals(name.toLowerCase())) {
                b = true;
                break;
            }
        return b;
    }
    private Animal getAnimal(String name) {
        if(has_animal(name)) {
            for(Animal animal : animals)
                if(animal.getName().toLowerCase().equals(name.toLowerCase()))
                    return animal;
        }

        System.out.printf("We can not find %s in the zoo!\n", name);
        return new Penguin("Error", 0);
    }
}



