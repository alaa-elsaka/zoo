package com.zoo.cryptozoology.zoodemo;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Habitat {

    private String name;
    private String type;

    private List<Animal> animals;


    public Habitat(String name, String type) {
        this.name = name;
        this.type = type;
        animals = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public List<Animal> getAnimals() {
        return animals;
    }
}
