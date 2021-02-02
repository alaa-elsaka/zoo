package com.zoo.cryptozoology.zoodemo.services;

import com.zoo.cryptozoology.zoodemo.Animal;
import com.zoo.cryptozoology.zoodemo.Habitat;
import com.zoo.cryptozoology.zoodemo.ZooDTO;
import com.zoo.cryptozoology.zoodemo.repository.HabitatRepository;
import com.zoo.cryptozoology.zoodemo.repository.ZooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZooService {

    @Autowired
    ZooRepository zooRepository;
    @Autowired
    HabitatRepository habitatRepository;


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

    public ZooDTO addAnimaltoHabitat(Animal animal) {
//        Habitat habitat = new Habitat("forest", "wakinggg");
//        habitat = habitatRepository.save(habitat);

        Habitat habitat = habitatRepository.findByType("walkinggg");
        boolean added = false;

        //Habitat habitat = new Habitat("forest", "walking");
        System.out.println("------------>"+habitat.getType());
        System.out.println("------------>"+animal.getType());
        if(animal.getType().equals(habitat.getType())){
            habitat.add(animal);
            added = true;
        }

        zooRepository.save(animal);

        ZooDTO zooDTO = new ZooDTO();

        zooDTO.setName(animal.getName());
        zooDTO.setStatus(animal.getStatus());
        zooDTO.setType(animal.getType());

        if(added){
            zooDTO.setHabitat(habitat);
        }
        return zooDTO;

    }
}
