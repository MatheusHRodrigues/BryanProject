package org.academiadecodigo.bootcamp.bryanproject.animation;

public enum AnimationType {
    WALK("walk"),
    RUN("run"),
    JUMP("jump");

    private String name;


    AnimationType(String name) {
        this.name = name;
    }
}