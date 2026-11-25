package org.example.menu;

import org.example.model.*;
import org.example.shelter.Shelter;

import java.awt.*;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ConsoleMenu {
    private final Shelter<Animal> shelter;
    private final Scanner scanner = new Scanner(System.in);

    public ConsoleMenu(Shelter<Animal> shelter) {
        this.shelter = shelter;
    }

    public void start() throws InputMismatchException {
            boolean active = true;
            while (active == true) {
                    printMenu();
                    System.out.println("Choose what you want to do : ");

                    int number = scanner.nextInt();
                    switch (number) {
                        case 0 -> active = false;
                        case 1 -> {
                            System.out.println("""
                                    Choose animal type:
                                    1. Dog
                                    2. Cat
                                    3. Bird""");
                            int choose = scanner.nextInt();
                            System.out.println("Enter animal name: ");
                            String name = scanner.next();
                            System.out.println("Enter animal age: ");
                            int age = scanner.nextInt();
                            switch (choose) {
                                case 1 -> {
                                    shelter.addAnimal(new Dog(new AnimalId(), name, 3));
                                }
                                case 2 -> {
                                    shelter.addAnimal(new Cat(new AnimalId(), name, age));
                                }
                                case 3 -> {
                                    shelter.addAnimal(new Bird(new AnimalId(), name, age));
                                }

                            }
                        }
                        case 2 -> {
                            List<Animal> animals = shelter.getAllAnimals();
                            animals.forEach(System.out::println);
                        }
                        case 3 -> {
                            System.out.println("Select a species: ");

                            String species = scanner.next();
                            List<Animal> listedAnimals = shelter.findBySpecies(species);
                            listedAnimals.forEach(System.out::println);
                        }
                        case 4 -> {
                            List<Animal> availableAnimals = shelter.findAvailableAnimals();
                            availableAnimals.forEach(System.out::println);
                        }
                        case 5 -> {
                            System.out.println("Write an animal id: ");
                            String id = scanner.next();
                            shelter.markAsAdopted(id);
                        }
                        default -> {
                            System.out.println("Input must be a number from 0 to 5");
                        }
                    }


            }
        }

        private void printMenu () {
            for (MenuOption option : options) {
                System.out.println(option.number() + " " + option.label());
            }
        }
        private final List<MenuOption> options = List.of(
                new MenuOption(1, "Add animal"),
                new MenuOption(2, "List all animals"),
                new MenuOption(3, "find animals by species"),
                new MenuOption(4, "List available animals"),
                new MenuOption(5, "mark animal as adopted"),
                new MenuOption(0, "Exit")
        );
    }

