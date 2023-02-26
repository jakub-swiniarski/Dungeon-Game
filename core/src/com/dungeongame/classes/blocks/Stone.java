package com.dungeongame.classes.blocks;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.dungeongame.classes.blocks.Block;

public class Stone extends Block {
    public Stone(){
        img = new Texture(Gdx.files.internal("stone.png"));
    }
}
