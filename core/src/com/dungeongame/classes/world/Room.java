package com.dungeongame.classes.world;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.dungeongame.classes.blocks.Chest;
import com.dungeongame.classes.entities.Player;

public class Room {
    public Rectangle rect;
    public static Texture img;

    public int chestAmount;
    public int enemyAmount; //can only start following you when you're in the same room
    public Chest[] chest;

    public Room(){
        chestAmount = (int)(Math.random() * 2);
        enemyAmount = (int)(Math.random() * 5);
        chest = new Chest[chestAmount];
        rect = new Rectangle();
        rect.width=1280;
        rect.height=720;
        rect.x=0;
        rect.y=0;
        img = new Texture(Gdx.files.internal("room.png"));
    }

    public void generateContent(){
        for(int i=0; i<chestAmount; i++){   //REMEMBER TO DISPOSE THE CONTENT
            chest[i] = new Chest();
            chest[i].rect.x=(int)rect.x+(int)(Math.random() * 1000 + 50);
            chest[i].rect.y=(int)rect.y+(int)(Math.random() * 500 + 50);
        }
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
