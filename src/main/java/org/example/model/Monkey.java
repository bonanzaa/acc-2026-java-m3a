package org.example.model;

public final class Monkey extends Animal{
    public Monkey(AnimalId id, String name, int age){
        super(id,name,age);
    }

    @Override
    public String getSpecies(){
        return "Monkey";
    }
}
