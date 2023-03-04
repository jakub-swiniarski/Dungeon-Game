package com.dungeongame.classes.items;

import com.badlogic.gdx.graphics.Texture;
import com.dungeongame.classes.entities.Player;

import java.awt.*;

public class Item {
    public Rectangle rect;
    public Texture img;
    public Texture icon;
    public int id;
    public int slot;

    public Item(){
        id=0;
    }

    public void addToInv(){
        for(int i=0; i<5; i++){
            if(Player.inventory[i]==0){
                Player.inventory[i]=id;
                slot=i;
                i=5;
            }
        }
    }
    public void pickUpCheck() {
        if (Player.rect.y + Player.rect.height > rect.y && Player.rect.y < rect.y + rect.height) {
            //left side
            if (Player.rect.x + Player.rect.width > rect.x && Player.rect.x + Player.rect.width < rect.x + 5) {
                addToInv();
            }
            //right side
            if (Player.rect.x < rect.x + rect.width && Player.rect.x > rect.x + rect.width - 5) {
                addToInv();
            }
        }

        if (Player.rect.x + Player.rect.width > rect.x && Player.rect.x < rect.x + rect.width) {
            //bottom side
            if (Player.rect.y + Player.rect.height > rect.y && Player.rect.y + Player.rect.height < rect.y + 5) {
                addToInv();
            }
            //top side
            if (Player.rect.y < rect.y + rect.height && Player.rect.y > rect.y + rect.height - 5) {
                addToInv();
            }
        }
    }
}
