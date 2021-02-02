package com.zoo.cryptozoology.zoodemo.controllers;

import com.zoo.cryptozoology.zoodemo.Animal;
import com.zoo.cryptozoology.zoodemo.services.ZooService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ZooController {


    private ZooService zooService;

    public ZooController(ZooService zooService){
        this.zooService = zooService;
    }


    @PostMapping("/addanimal")
    @ResponseStatus(HttpStatus.CREATED)
    public Animal addAnimal(@RequestBody Animal animal){

        return zooService.add(animal);

    }

    @GetMapping("/animals")
    @ResponseStatus(HttpStatus.OK)
    public List<Animal> getAnimals(){

        //List<Animal> animals = List.of((new Animal("Lion")));
        return zooService.listAnimals();
    }

    @PutMapping("treatanimal/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Animal treatAnimal(@PathVariable Long id,
                            @RequestBody Animal animal)
    {
        return zooService.treatAnimal(animal);
    }

    @PutMapping("animalhabitat/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void addAnimalToHabitat(@PathVariable Long id,
                                   @RequestBody Animal animal){
        zooService.addAnimaltoHabitat(animal);

    }
}
