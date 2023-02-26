package com.dungeongame.classes.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import java.awt.*;

public class Heart extends UI{
    public Heart(){
        rect = new Rectangle();
        rect.x = 9999;
        rect.y = 9999;
        rect.width = 50;
        rect.height = 50;
        img = new Texture(Gdx.files.internal("heart.png"));
    }
}
