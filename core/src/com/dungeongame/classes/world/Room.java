package com.dungeongame.classes.world;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.dungeongame.classes.entities.Player;

public class Room {
    public Rectangle rect;
    public Texture img;

    public Room(){
        rect = new Rectangle();
        rect.width=1280;
        rect.height=720;
        rect.x=0;
        rect.y=0;
        img = new Texture(Gdx.files.internal("room.png"));
    }

    public void borderCheck(){
        //check if the room contains the player
        if(!(Player.rect.x+Player.rect.width<=rect.x || Player.rect.x>=rect.x+rect.width || Player.rect.y+Player.rect.height<=rect.y || Player.rect.y>=rect.y+rect.height)){
            //borders
            if((Player.rect.x>=rect.x+20 && Player.rect.x<=rect.x+560) || (Player.rect.x+Player.rect.width>=rect.x+720 && Player.rect.x+Player.rect.width<=rect.x+rect.width-20)) {
                if (Player.rect.y + Player.rect.height >= rect.y + rect.height - 40) {
                    Player.rect.y = (int) rect.y + (int) rect.height - 40 - Player.rect.height;
                }
                if (Player.rect.y <= rect.y + 40) {
                    Player.rect.y = (int) rect.y + 40;
                }
            }
            else if(Player.rect.y<=rect.y+40 || Player.rect.y+Player.rect.height>=rect.y+rect.height-40){
                if(Player.rect.x<=rect.x+565){
                    Player.rect.x=(int)rect.x+565;
                }
                if(Player.rect.x+Player.rect.width>=rect.x+715){
                    Player.rect.x=(int)rect.x+715-Player.rect.width;
                }
            }
            if(Player.rect.y<=rect.y+280 || Player.rect.y+Player.rect.height>=rect.y+440){
                if(Player.rect.x<=rect.x+40){
                    Player.rect.x=(int)rect.x+40;
                    if(Player.rect.y+Player.rect.height>=rect.y+rect.height-40){
                        Player.rect.y=(int)rect.y+(int)rect.height-40-Player.rect.height;
                    }
                    if(Player.rect.y<=rect.y+40){
                        Player.rect.y=(int)rect.y+40;
                    }
                }
                if(Player.rect.x+Player.rect.width>=rect.x+rect.width-40){
                    Player.rect.x=(int)rect.x+(int)rect.width-40-Player.rect.width;
                    if(Player.rect.y+Player.rect.height>=rect.y+rect.height-40){
                        Player.rect.y=(int)rect.y+(int)rect.height-40-Player.rect.height;
                    }
                    if(Player.rect.y<=rect.y+40){
                        Player.rect.y=(int)rect.y+40;
                    }
                }
            }
            else if(Player.rect.x<=rect.x+40 || Player.rect.x+Player.rect.width>=rect.x+rect.width-40){
                if(Player.rect.y<=rect.y+285){
                    Player.rect.y=(int)rect.y+285;
                }
                if(Player.rect.y+Player.rect.height>=rect.y+435){
                    Player.rect.y=(int)rect.y+435-Player.rect.height;
                }
            }
        }
    }
}
