package org.example.menu;

import org.example.model.Animal;
import org.example.shelter.Shelter;

import java.awt.*;
import java.util.List;
import java.util.Scanner;

public class ConsoleMenu {
    private final Shelter<Animal> shelter;
    private final Scanner scanner =  new Scanner(System.in);
    public ConsoleMenu(Shelter<Animal> shelter) {
        this.shelter = shelter;
    }

    public void start(){
        boolean active = true;
        while(active == true) {
            printMenu();
            System.out.println("Choose what you want to do : ");
            int number = scanner.nextInt();
            switch(number) {
                case 0:
                    active = false;
                    break;
                case 2:
                    List<Animal> animals = shelter.getAllAnimals();
                    animals.forEach(System.out::println);
                    break;
                case 3:
                    System.out.println("Select a species: ");
                    String species = scanner.next();
                    List<Animal> listedAnimals = shelter.findBySpecies(species);
                    listedAnimals.forEach(System.out::println);
                    break;
                case 4:
                    List<Animal> availableAnimals = shelter.findAvailableAnimals();
                    availableAnimals.forEach(System.out::println);
                    break;
                case 5:
                    System.out.println("Write an animal id: ");
                    String id = scanner.next();
                    shelter.markAsAdopted(id);
                    break;
            }
        }


        // TODO:
        // Show menu in a loop
        // Read user input
        // Call correct 'Shelter' methods based on selected option
    }

    private void printMenu(){
        for(MenuOption option : options) {
            System.out.println(option.number() + " " + option.label());
        }
    }
    private final List<MenuOption> options = List.of(
            new MenuOption(1, "Add animal"),
            new MenuOption(2, "List all animals"),
            new MenuOption(3, "find animals by species"),
            new MenuOption(4,"List available animals"),
            new MenuOption(5, "mark animal as adopted"),
            new MenuOption(0, "Exit")
    );
}
