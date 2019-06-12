package org.academiadecodigo.bootcamp.bryanproject.animation;

public enum AnimationType {
    WALK("walk"),
    RUN("run"),
    JUMP("jump"),
    IDLE("idle");

    private String name;


    AnimationType(String name) {
        this.name = name;
    }
}
