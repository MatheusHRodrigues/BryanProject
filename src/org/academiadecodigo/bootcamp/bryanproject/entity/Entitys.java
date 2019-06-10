package org.academiadecodigo.bootcamp.bryanproject.entity;

public enum Entitys {
    BRYAN("Bryan"),
    OGRE("Ogre");

    private String name;

    Entitys(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
