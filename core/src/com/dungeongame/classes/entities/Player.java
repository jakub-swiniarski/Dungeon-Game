package com.dungeongame.classes.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;

import java.awt.*;

public class Player extends Entity {
    public static Rectangle rect;
    public static int[] inventory;
    public static int currentSlot;

    public Player(){
        rect=new Rectangle();
        hp=5;
        inventory = new int[5];
        rect.width = 80;
        rect.height = 80;
        rect.x = 1280/2-rect.width/2;
        rect.y = 720/2-rect.height/2;
        movingSpeed = 250;
        img = new Texture(Gdx.files.internal("player.png"));
        for(int i=0; i<5; i++){
            inventory[i] = 0;
        }
    }
    public void checkForInput(){
        //movement
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

        //inventory
        if(Gdx.input.isKeyJustPressed(Input.Keys.NUM_1)) currentSlot=0;
        if(Gdx.input.isKeyJustPressed(Input.Keys.NUM_2)) currentSlot=1;
        if(Gdx.input.isKeyJustPressed(Input.Keys.NUM_3)) currentSlot=2;
        if(Gdx.input.isKeyJustPressed(Input.Keys.NUM_4)) currentSlot=3;
        if(Gdx.input.isKeyJustPressed(Input.Keys.NUM_5)) currentSlot=4;
    }
    /*public void borderCheck(){
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
    }*/
}
