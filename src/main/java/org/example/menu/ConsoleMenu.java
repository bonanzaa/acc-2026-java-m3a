package org.example.menu;

import org.example.model.*;
import org.example.shelter.Shelter;

import java.net.SocketOption;
import java.util.Scanner;

public class ConsoleMenu {
    private final Shelter<Animal> shelter;
    private final Scanner scanner = new Scanner(System.in);

    public ConsoleMenu(Shelter<Animal> shelter) {
        this.shelter = shelter;
    }

    public void start() {
        while (true) {
            printMenu();
            System.out.print("Enter command: ");
            String command = scanner.nextLine();
            switch (command) {
                case "1":
                    askAboutAnimal();
                    break;
                case "2":
                    System.out.println(shelter.getAllAnimals());
                    break;
                case "3":
                    System.out.print("Enter spiece: ");
                    String spiece = scanner.nextLine();
                    System.out.println(shelter.findBySpecies(spiece));
                    break;
                case "4":
                    System.out.println(shelter.findAvailableAnimals());
                    break;
                case "5":
                    System.out.print("Enter animal id: ");
                    String animalId = scanner.nextLine();
                    shelter.markAsAdopted(animalId);
                    break;
                case "0":
                    System.out.println("Bye!");
                    break;

            }


        }
    }

    private void printMenu() {
        System.out.println("""
                1. Add animal
                2. List all animals
                3. Find animals by species
                4. List available animals
                5. Mark animal as adopted
                0. Exit
                """);
    }


    private void askAboutAnimal() {
        System.out.println("Enter animal name: ");
        String animalName = scanner.nextLine();
        System.out.println("Enter animal age: ");
        int animalAge = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter animal spiece: ");
        String animalSpecies = scanner.nextLine();
        switch (animalSpecies.toLowerCase().trim()) {
            case "dog":
                shelter.addAnimal(new Dog(new AnimalId(), animalName, animalAge));
                break;
            case "cat":
                shelter.addAnimal(new Cat(new AnimalId(), animalName, animalAge));
                break;
            case "bird":
                shelter.addAnimal(new Bird(new AnimalId(), animalName, animalAge));
                break;
            default:
                System.out.println("Invalid animal species");
                break;
        }
    }
}
