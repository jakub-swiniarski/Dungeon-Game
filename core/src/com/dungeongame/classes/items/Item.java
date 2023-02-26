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
}
