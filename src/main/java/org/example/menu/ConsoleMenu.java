package org.example.menu;

import model.*;
import model.Animal;
import org.example.model.Animal;
import org.example.shelter.Shelter;

import java.util.Scanner;

public class ConsoleMenu {
    private final Shelter<Animal> shelter;
    private final Scanner scanner =  new Scanner(System.in);
    public ConsoleMenu(Shelter<Animal> shelter) {
        this.shelter = shelter;
    }


    public void start(){
        System.out.println("What would you like to do in the shelter?");
        ConsoleMenu obj = new ConsoleMenu(shelter);
        boolean working = true;

        while (working){
            obj.printMenu();
            String input = scanner.nextLine();

            while(input.isEmpty()){
                obj.printMenu();
                input = scanner.nextLine();
            }
            if (input.equals("1")){
                System.out.println("Animal name:");
                String name = scanner.nextLine();

                System.out.println("Animal age:");
                int age = Integer.parseInt(scanner.nextLine());

                System.out.println("Animal type (Dog, Cat, Bird, Monkey, Lizard):");
                String type = scanner.nextLine();

                Animal animal = null;

                if (type.equalsIgnoreCase("Dog")) {
                    animal = new Dog(new AnimalId(), name, age);

                } else if (type.equalsIgnoreCase("Cat")) {
                    animal = new Cat(new AnimalId(), name, age);

                } else if (type.equalsIgnoreCase("Bird")) {
                    animal = new Bird(new AnimalId(), name, age);

                } else if (type.equalsIgnoreCase("Monkey")) {
                    animal = new Monkey(new AnimalId(), name, age);

                } else if (type.equalsIgnoreCase("Lizard")) {
                    animal = new Lizard(new AnimalId(), name, age);
                }

                if (animal != null) {
                    shelter.addAnimal(animal);
                    System.out.println("Success");
                } else {
                    System.out.println("ERROR");
                }
                if (input.equals("0")){
                    working = false;
                }
            }
            else if (input.equals("2")){
                System.out.println(shelter.getAllAnimals());
            }
            else if  (input.equals("3")){
                System.out.println("Enter the wanted specie: ");
                String specie = scanner.nextLine();
                System.out.println(shelter.findBySpecies(specie));
            }
            else if (input.equals("4")){
                System.out.println(shelter.findAvailableAnimals());
            }
            else if (input.equals("5")){
                System.out.println("Enter animals ID: ");
                String ID = scanner.nextLine();
                shelter.markAsAdopted(ID);
            }
            else if (input.equals("0")){
                working = false;
                System.out.println("Thank you for visiting!");
            }
            else {
                System.out.println("ERROR");
            }
        }
    }


    private void printMenu(){
        System.out.println("""
                1. Add animal
                2. List all animals
                3. Find animals by species
                4. List available animals
                5. Mark animal as adopted
                0. Exit
                """);
    }
}
