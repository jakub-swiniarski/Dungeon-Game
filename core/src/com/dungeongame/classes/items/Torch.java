package com.dungeongame.classes.items;

import box2dLight.PointLight;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import java.awt.*;

public class Torch extends Item {
    public int brightness;
    public Texture[] animImg = new Texture[9];
    public int currentFrame;
    public PointLight light;
    public boolean animReversed;
    public boolean lightOn;
    public boolean lightReset;

    public Torch() {
        lightReset = false;
        lightOn = true;
        slot=5;
        animReversed = false;
        currentFrame = 0;
        id=1;
        rect = new Rectangle();
        rect.width = 60;
        rect.height = 60;
        rect.x = 100;
        rect.y = 100;
        brightness = 400;
        img = new Texture(Gdx.files.internal("player.png"));
        icon = new Texture(Gdx.files.internal("torch-icon.png"));
        for (int i = 0; i < animImg.length; i++) {
            animImg[i] = new Texture(Gdx.files.internal("torch-animation/" + i + ".png"));
        }
    }

    public void animation() {
        light.setPosition(rect.x + rect.width / 2, rect.y + rect.height - 10);
        light.setDistance(brightness);
        img = animImg[currentFrame];
        if (animReversed) {
            currentFrame--;
            if(lightOn) brightness -= 10;
        } else {
            currentFrame++;
            if(lightOn) brightness += 10;
        }
        if (currentFrame == 8) {
            animReversed = true;
        }
        if(currentFrame == 0) {
            animReversed = false;
        }
        if(!lightOn) brightness=0;
    }
}