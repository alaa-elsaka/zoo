package com.zoo.cryptozoology.zoodemo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zoo.cryptozoology.zoodemo.repository.ZooRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ZoodemoApplicationTests {

    @Autowired
    MockMvc mockMvc;

    ObjectMapper mapper;

    @Autowired
    ZooRepository zooRepository;

    @BeforeEach
    public void setup(){
        mapper = new ObjectMapper();
    }

    @Test
    public void whenAddAnimal() throws Exception{

        Animal animal = new Animal("Lion");
        String postAnimal = mapper.writeValueAsString(animal);

        mockMvc.perform((post("/addanimal")).contentType(MediaType.APPLICATION_JSON)
        .content(postAnimal)).andExpect(status().isCreated())
        .andExpect(jsonPath("$.name").value("Lion")).andDo(print());


    }

    @Test
    public void whenGetAllAnimals() throws Exception{

        mockMvc.perform(get("/animals")).andExpect(status().isOk())
        .andExpect(jsonPath("$").isEmpty());
    }

    @Test
    public void whenTreatAnimal() throws Exception{
        Animal animal = new Animal("Lion");

        animal = zooRepository.save(animal);
        String postAnimal = mapper.writeValueAsString(animal);

        Long Id = animal.getId();
        mockMvc.perform(((put("/treatanimal/"+Id))).contentType(MediaType.APPLICATION_JSON)
                .content(postAnimal)).andExpect(status().isAccepted())
                .andExpect(jsonPath("$.name").value("Lion"))
                .andExpect(jsonPath("$.status").value("Happy")).andDo(print());

    }

    @Test
    public void whenAddAnimaltoHabtat() throws Exception{
        Animal animal = new Animal("Tiger", "walking");
        //Habitat habitat = new Habitat("forest", "waking");
        animal = zooRepository.save(animal);
        String postAnimal = mapper.writeValueAsString(animal);

        Long Id = animal.getId();
        mockMvc.perform(((put("/animalhabitat/"+Id))).contentType(MediaType.APPLICATION_JSON)
                .content(postAnimal)).andExpect(status().isAccepted())
                .andExpect(jsonPath("$.name").value("Lion")).andDo(print());
    }

}
