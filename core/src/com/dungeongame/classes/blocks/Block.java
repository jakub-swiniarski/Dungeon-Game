package com.dungeongame.classes.blocks;

import com.badlogic.gdx.graphics.Texture;

import java.awt.*;

public class Block {
    public Rectangle rect;
    public Texture img;

    public Block(){
        rect = new Rectangle();
        rect.width=80;
        rect.height=80;
        rect.x=9999;
        rect.y=9999;
    }
    public boolean collisionCheck(){ //return value will be used to determine if the chest should be opened
        return false;
    }
}
