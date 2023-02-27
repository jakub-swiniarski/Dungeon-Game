package com.dungeongame.classes.blocks;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Stone extends Block {
    public Stone(){
        img = new Texture(Gdx.files.internal("stone.png"));
    }
}
