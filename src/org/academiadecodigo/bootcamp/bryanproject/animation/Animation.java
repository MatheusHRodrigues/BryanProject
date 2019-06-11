package org.academiadecodigo.bootcamp.bryanproject.animation;

import org.academiadecodigo.bootcamp.bryanproject.entity.Entity;

public class Animation {
    private int frame = -1;
    private AnimationType currentType;
    private String path = "Game/Animations/";
    private String fileConcat = "-";
    private String tag = "{}";
    //file exemple bryan-walk-00.png

    public void runAnimation(Entity entity, AnimationType type) {
        String load = path + "Entity/" + entity.getEntityType().getName() + "/" + entity.getEntityType().getName().toLowerCase() + fileConcat + "walk" + fileConcat + tag + ".png";
        run(entity,type,load);
    }

    public void runAnimation(Entity entity, AnimationType type, AnimationDirection animationDirection) {
        String load = path + "Entity/" + entity.getEntityType().getName() + "/" + entity.getEntityType().getName().toLowerCase() + fileConcat + "walk" + fileConcat + animationDirection.toString().toLowerCase() + fileConcat + tag + ".png";
        run(entity,type,load);

    }

    private void run(Entity entity, AnimationType type, String load) {
        if (currentType == type) {
            frame++;
            currentType = type;
            if (frame <= 4) {
                entity.getGraphicsRep().load(load.replace("{}",new Integer(frame).toString()));
            } else {
                frame = -1;
            }
        } else {
            frame = -1;
            currentType = type;
            run(entity, type, load);
            return;
        }
    }

}
