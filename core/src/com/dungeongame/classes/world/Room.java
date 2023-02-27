package com.dungeongame.classes.world;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.dungeongame.classes.entities.Player;

public class Room {
    public Rectangle rect;
    public Texture img;
    public boolean containsPlayer;

    public Room(){
        containsPlayer = false;
        rect = new Rectangle();
        rect.width=1280;
        rect.height=720;
        rect.x=0;
        rect.y=0;
        img = new Texture(Gdx.files.internal("room.png"));
    }

    public void borderCheck(){
        if((Player.rect.x>=rect.x+40 && Player.rect.x<=rect.x+560) || (Player.rect.x+Player.rect.width>=rect.x+720 && Player.rect.x+Player.rect.width<=rect.x+rect.width-40)){
            if(Player.rect.y+Player.rect.height>=rect.y+rect.height-40 && containsPlayer){
                Player.rect.y=(int)rect.y+(int)rect.height-40-Player.rect.height;
            }
            if(Player.rect.y<=rect.y+40 && containsPlayer){
                Player.rect.y=(int)rect.y+40;
            }
        }
        /*else{
            if(Player.rect.y<=rect.y+280+1 && containsPlayer){
                Player.rect.y=(int)rect.y+280+1;
            }
            if(Player.rect.y+Player.rect.height>=rect.y+440-1 && containsPlayer){
                Player.rect.y=(int)rect.y+440-Player.rect.height-1;
            }
        }*/
        if(Player.rect.y<=rect.y+280 || Player.rect.y+Player.rect.height>=rect.y+440){
            if(Player.rect.x<=rect.x+40 && containsPlayer){
                Player.rect.x=(int)rect.x+40;
                if(Player.rect.y+Player.rect.height>=rect.y+rect.height-40 && containsPlayer){
                    Player.rect.y=(int)rect.y+(int)rect.height-40-Player.rect.height;
                }
                if(Player.rect.y<=rect.y+40 && containsPlayer){
                    Player.rect.y=(int)rect.y+40;
                }
            }
            if(Player.rect.x+Player.rect.width>=rect.x+rect.width-40 && containsPlayer){
                Player.rect.x=(int)rect.x+(int)rect.width-40-Player.rect.width;
                if(Player.rect.y+Player.rect.height>=rect.y+rect.height-40 && containsPlayer){
                    Player.rect.y=(int)rect.y+(int)rect.height-40-Player.rect.height;
                }
                if(Player.rect.y<=rect.y+40 && containsPlayer){
                    Player.rect.y=(int)rect.y+40;
                }
            }
        }/*
        if(!(Player.rect.y>rect.y+40 && Player.rect.y+Player.rect.height<rect.y+rect.height-40)){
            if(Player.rect.x>=rect.x+560+1 && containsPlayer){
                Player.rect.x=(int)rect.x+560+1;
            }
            if(Player.rect.x+Player.rect.width>=rect.x+720-1 && containsPlayer){
                Player.rect.x=(int)rect.x+720+Player.rect.width-1;
            }
        }*/
        if(Player.rect.x+Player.rect.width<=rect.x || Player.rect.x>=rect.x+rect.width || Player.rect.y+Player.rect.height<=rect.y || Player.rect.y>=rect.y+rect.height){
            containsPlayer = false;
        }
        else{
            containsPlayer = true;
        }
    }
}
