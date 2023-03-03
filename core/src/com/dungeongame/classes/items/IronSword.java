package com.dungeongame.classes.items;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import java.awt.*;

public class IronSword extends Item{
    public int dmg;

    public IronSword() {
        dmg=20;
        id=2;
        rect=new Rectangle();
        rect.width=60;
        rect.height=120;
        rect.x=9999;
        rect.y=9999;
        img = new Texture(Gdx.files.internal("iron-sword.png"));
        icon = new Texture(Gdx.files.internal("iron-sword-icon.png"));
    }
}
