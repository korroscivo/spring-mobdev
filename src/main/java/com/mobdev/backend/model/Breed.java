package com.mobdev.backend.model;

import java.util.List;

public class Breed {
    public Breed(String name) {
        this.name = name;
    }

    private String name;
    private List<Breed> subBreed = null;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Breed> getSubBreed() {
        return subBreed;
    }

    public void setSubBreed(List<Breed> subBreed) {
        this.subBreed = subBreed;
    }
}
