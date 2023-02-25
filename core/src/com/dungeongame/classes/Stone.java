package com.dungeongame.classes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import java.awt.*;

public class Stone extends Block {
    public Stone(){
        img = new Texture(Gdx.files.internal("stone.png"));
    }
}
