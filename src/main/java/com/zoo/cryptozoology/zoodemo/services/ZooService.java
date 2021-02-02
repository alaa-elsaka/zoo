package com.zoo.cryptozoology.zoodemo.services;

import com.zoo.cryptozoology.zoodemo.Animal;
import com.zoo.cryptozoology.zoodemo.Habitat;
import com.zoo.cryptozoology.zoodemo.repository.ZooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZooService {

    @Autowired
    ZooRepository zooRepository;


    public Animal add(Animal animal) {
        return zooRepository.save(animal);
    }

    public List<Animal> listAnimals() {
        return zooRepository.findAll();
    }

    public Animal treatAnimal(Animal animal) {
        if(animal.getStatus().equals("unHappy"))
            animal.setStatus("Happy");
        return zooRepository.save((animal));
    }

    public Animal addAnimaltoHabitat(Animal animal) {

        if(animal.getType().equals(habitat.getType))
            habitat.add(animal);
        return zooRepository.save(animal);

    }
}
