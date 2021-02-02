package com.zoo.cryptozoology.zoodemo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Habitat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    private String name;
    private String type;

    @OneToMany
    private List<Animal> animals = new ArrayList<>();

     public Habitat(){}

    public Habitat(String name, String type) {
        this.name = name;
        this.type = type;
        //animals = new ArrayList<>();
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

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    public void add(Animal animal) {
        animals.add(animal);
    }
}
