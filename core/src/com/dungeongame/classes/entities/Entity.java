package com.dungeongame.classes.entities;

import java.awt.*;
import com.badlogic.gdx.graphics.Texture;

public class Entity {
    public Rectangle rect;
    public Texture img;
    public int movingSpeed;
    public int hp;

    public Entity(){
        rect = new Rectangle();
    }
    public void walkingAnimation(){

    }
}
