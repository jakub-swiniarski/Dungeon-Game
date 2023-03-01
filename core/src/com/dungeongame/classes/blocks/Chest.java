package com.dungeongame.classes.blocks;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import java.awt.*;

public class Chest extends Block{
    int content;

    public Chest(){
        content=0;
        img = new Texture(Gdx.files.internal("chest-closed.png"));
    }
}
