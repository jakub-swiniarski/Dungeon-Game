package com.dungeongame.classes.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import java.awt.*;

public class InventoryPointer extends UI{
    public InventoryPointer(){
        rect = new Rectangle();
        rect.width = 50;
        rect.height = 50;
        rect.x = 765;
        rect.y = 600;
        img = new Texture(Gdx.files.internal("inventory-pointer.png"));
    }
}
