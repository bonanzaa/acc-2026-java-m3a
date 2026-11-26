package org.example.model;

public final class Lizard extends Animal{
    public Lizard(AnimalId id, String name, int age){
        super(id,name,age);
    }

    @Override
    public String getSpecies(){
        return "Lizard";
    }
}
