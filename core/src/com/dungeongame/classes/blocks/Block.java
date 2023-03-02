package com.dungeongame.classes.blocks;

import com.badlogic.gdx.graphics.Texture;
import com.dungeongame.classes.entities.Player;

import java.awt.*;

public class Block {
    public Rectangle rect;
    public Texture img;

    public Block(){
        rect = new Rectangle();
        rect.width=80;
        rect.height=80;
        rect.x=9999;
        rect.y=9999;
    }
    public boolean collisionCheck(){ //return value will be used to determine if the chest should be opened
        if(Player.rect.y+Player.rect.height>=rect.y && Player.rect.y<=rect.y+rect.height){
            if(Player.rect.x<=rect.x+rect.width && Player.rect.x>=rect.x+rect.width/2){
                Player.rect.x=rect.x+rect.width;
                return true;
            }
            if(Player.rect.x+Player.rect.width>=rect.x && Player.rect.x+Player.rect.width<=rect.x+rect.width/2){
                Player.rect.x=rect.x-Player.rect.width;
                return true;
            }
        }
        if(Player.rect.x+Player.rect.width>=rect.x && Player.rect.x<=rect.x+rect.width){
            if(Player.rect.y<=rect.y+rect.height && Player.rect.y>=rect.y+rect.height/2){
                Player.rect.y=rect.y+rect.height;
                return true;
            }
            if(Player.rect.y+Player.rect.height>=rect.y && Player.rect.y+Player.rect.height<=rect.y+rect.height/2){
                Player.rect.y=rect.y-Player.rect.height;
                return true;
            }
        }
        return false;
    }
}
