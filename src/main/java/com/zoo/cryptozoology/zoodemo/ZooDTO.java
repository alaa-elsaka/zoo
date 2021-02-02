package com.zoo.cryptozoology.zoodemo;

public class ZooDTO {
    private String name;

    private String status;

    private Habitat habitat;
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public Habitat getHabitat() {
        return habitat;
    }

    public String getStatus() {
        return status;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setHabitat(Habitat habitat) {
        this.habitat = habitat;
    }
}
