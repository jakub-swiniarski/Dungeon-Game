package com.dungeongame.classes.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.dungeongame.classes.entities.Entity;

import java.awt.*;

public class Player extends Entity {
    private int[] inventory;

    public Player(){
        hp=5;
        inventory = new int[10];
        rect = new Rectangle();
        rect.x = 500;
        rect.y = 500;
        rect.width = 80;
        rect.height = 80;
        movingSpeed = 250;
        img = new Texture(Gdx.files.internal("player.png"));
    }
    public void checkForInput(){
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT) && !Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            rect.x -= movingSpeed * Gdx.graphics.getDeltaTime();
        }
        else if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)  && !Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            rect.x += movingSpeed * Gdx.graphics.getDeltaTime();
        }
        if(Gdx.input.isKeyPressed(Input.Keys.UP) && !Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            rect.y += movingSpeed * Gdx.graphics.getDeltaTime();
        }
        else if(Gdx.input.isKeyPressed(Input.Keys.DOWN)  && !Gdx.input.isKeyPressed(Input.Keys.UP)) {
            rect.y -= movingSpeed * Gdx.graphics.getDeltaTime();
        }
    }
    public void borderCheck(){
        if(rect.x < 0) {
            rect.x=0;
        }
        if(rect.x > 1280-rect.width){
            rect.x=1280-rect.width;
        }
        if(rect.y < 0) {
            rect.y=0;
        }
        if(rect.y > 720-rect.height){
            rect.y=720-rect.height;
        }
    }
}
