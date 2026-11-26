package org.example.shelter;
import org.example.model.*;

import java.util.ArrayList;
import java.util.List;

public class Shelter <T extends Animal>{
    private final List<T> animals = new ArrayList<>();
    public void addAnimal(T animal){
        animals.add(animal);
    }

    public List<T> getAllAnimals(){
        return animals;
    }

    public List<T> findBySpecies(String species){
        List<T> animalSpecies = new ArrayList<>();
        for (T type : animals){
            if (type.getSpecies().equals(species)){
                animalSpecies.add(type);
            }
        }
        return animalSpecies;
    }

    public List<T> findAvailableAnimals(){
        List<T> availableAnimals = new ArrayList<>();
        for (T available : animals){
            if (available.getAdoptionStatus() == AdoptionStatus.AVAILABLE){
                availableAnimals.add(available);
            }
        }
        return availableAnimals;
    }

    public void markAsAdopted(String id){
        for (T animal : animals){
            if (animal.getId().toString().equals(id)){
                animal.markAsAdopted();
            }
        }
    }
}