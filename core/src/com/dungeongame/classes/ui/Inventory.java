package com.dungeongame.classes.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import java.awt.*;

public class Inventory extends UI{
    public Inventory(){
        rect = new Rectangle();
        rect.width = 250;
        rect.height = 50;
        rect.x = 1280 - rect.width - 15;
        rect.y = 720 - rect.height - 15;
        img = new Texture(Gdx.files.internal("inventory.png"));
    }
}
