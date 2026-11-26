package org.example;

import org.example.menu.ConsoleMenu;
import org.example.model.*;
import org.example.shelter.Shelter;

public class Main {
    public static void main (String[] args) {
        System.out.println("Welcome to my animal shelter system!!!");

        Shelter<Animal> shelter = new Shelter();

        shelter.addAnimal(new Dog(new AnimalId(), "Gregory", 1));
        shelter.addAnimal(new Monkey(new AnimalId(), "Mike", 4));
        shelter.addAnimal(new Cat(new AnimalId(), "Pineapple", 2));
        shelter.addAnimal(new Lizard(new AnimalId(), "Slimy", 3));
        shelter.addAnimal(new Bird(new AnimalId(), "Felix", 2));

        ConsoleMenu consoleMenu = new ConsoleMenu(shelter);
        consoleMenu.start();
    }
}