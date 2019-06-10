package org.academiadecodigo.bootcamp.bryanproject.animation;

import org.academiadecodigo.bootcamp.bryanproject.entity.Entity;

public class Animation {
    private int frame = -1;
    private AnimationType currentType;
    private String path = "Game/Animations/";
    private String fileConcat = "-";
    //file exemple bryan-walk-00.png

    public void runAnimation(Entity entity, AnimationType type) {
        if (currentType == type) {
            frame++;
            currentType = type;
            if (frame <= 4) {
                entity.getGraphicsRep().load(path + "Entity/" + entity.getEntityType().getName() + "/" + entity.getEntityType().getName().toLowerCase() + fileConcat + "walk" + fileConcat + frame + ".png");
            } else {
                frame = -1;
            }
        } else {
            frame = -1;
            currentType = type;
            runAnimation(entity, type);
            return;
        }
    }
}
