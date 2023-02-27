package com.dungeongame.classes.world;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import java.awt.*;

public class Room {
    public Rectangle rect;
    public Texture img;

    public Room(){
        rect = new Rectangle();
        rect.width=1280;
        rect.height=720;
        rect.x=0;
        rect.y=0;
        img = new Texture(Gdx.files.internal("room.png"));
    }
}
