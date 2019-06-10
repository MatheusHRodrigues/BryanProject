package org.academiadecodigo.bootcamp.bryanproject.entity;

public enum EntityType {
    BRYAN("Bryan"),
    OGRE("Ogre");

    private String name;

    EntityType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
