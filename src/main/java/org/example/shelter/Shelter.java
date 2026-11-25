package org.example.shelter;

import org.example.model.AdoptionStatus;
import org.example.model.Animal;

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
        return animals.stream()
                .filter(animal -> animal.getSpecies().equalsIgnoreCase(species))
                .toList();
    }

    public List<T> findAvailableAnimals(){
        return animals.stream()
                .filter(animal -> animal.getAdoptionStatus().equals(AdoptionStatus.AVAILABLE))
                .toList();
    }

    public void markAsAdopted(String id){
        for(Animal animal : animals) {
            if(animal.getId().toString().equals(id)) {
                animal.setAdoptionStatus(AdoptionStatus.ADOPTED);
            }
        }
    }
}
