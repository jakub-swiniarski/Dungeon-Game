package com.dungeongame.classes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import java.awt.*;

public class Block {
    public Rectangle rect;
    public Texture img;

    public Block(){
        rect = new Rectangle();
        rect.x = 500;
        rect.y = 500;
        rect.width = 80;
        rect.height = 80;
    }
}
