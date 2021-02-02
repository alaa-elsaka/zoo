package com.zoo.cryptozoology.zoodemo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Animal {

    private  String type;
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    public Animal(String name, String type) {
        this(name);
        this.type = type;
    }

    public Long getId() {
        return Id;
    }

    private String name;

    public String getStatus() {
        return status;
    }

    private String status;

    public Animal(){}

    public Animal(String name) {
        this.name = name;
        this.status ="unHappy";
    }

    public String getName() {
        return name;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return this.type;
    }
}
