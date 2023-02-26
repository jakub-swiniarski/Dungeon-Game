package com.dungeongame;

import box2dLight.PointLight;
import box2dLight.RayHandler;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import com.dungeongame.classes.entities.Player;
import com.dungeongame.classes.blocks.Stone;
import com.dungeongame.classes.ui.Heart;

public class DungeonGame extends ApplicationAdapter {
	SpriteBatch batch;
	Player player;
	Texture background;
	BitmapFont font;
	Stone[] stone = new Stone[40];
	World world;
	RayHandler rayHandler;
	Stage stage;
	PointLight light;
	Heart[] heart = new Heart[5];
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		player = new Player();
		background = new Texture(Gdx.files.internal("background.png"));
		font=new BitmapFont();
		font.setColor(255,255,255,255);
		for(int i=0; i<40; i++){
			stone[i] = new Stone();
		}
		for(int i=0; i<32; i++){
			if(i<16){
				stone[i].rect.y=720-stone[i].rect.height;
				stone[i].rect.x=i*stone[i].rect.width;
			}
			else{
				stone[i].rect.y=0;
				stone[i].rect.x=(i-16)*stone[i].rect.width;
			}
		}
		for(int i=32; i<36; i++){
			stone[i].rect.x=0;
		}
		stone[32].rect.y=560;
		stone[33].rect.y=480;
		stone[34].rect.y=80;
		stone[35].rect.y=160;

		for(int i=36; i<40; i++){
			stone[i].rect.x=1280-stone[i].rect.width;
		}
		stone[36].rect.y=560;
		stone[37].rect.y=480;
		stone[38].rect.y=80;
		stone[39].rect.y=160;

		for(int i=0; i<5; i++){
			heart[i] = new Heart();
			heart[i].rect.y=665;
			heart[i].rect.x=10+i*heart[i].rect.width;
		}

		stage = new Stage();
		world = new World(new Vector2(0,0),false);
		rayHandler = new RayHandler(world);
		rayHandler.setCombinedMatrix(stage.getCamera().combined);
		light = new PointLight(rayHandler,1000, Color.ORANGE,500,player.rect.x+player.rect.width/2, player.rect.y+player.rect.height/2);
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 1);
		batch.begin();
		batch.draw(background, 0, 0);
		for(int i=0; i<40; i++){
			batch.draw(stone[i].img,stone[i].rect.x, stone[i].rect.y);
		}
		batch.draw(player.img,player.rect.x, player.rect.y);
		batch.end();
		rayHandler.updateAndRender();
		light.setPosition(player.rect.x+player.rect.width/2, player.rect.y+player.rect.height/2);
		//not affected by light
		batch.begin();
		font.draw(batch, "FPS: "+Gdx.graphics.getFramesPerSecond(), 5, 20);
		for(int i=0; i<player.hp; i++){
			batch.draw(heart[i].img, heart[i].rect.x, heart[i].rect.y);
		}
		batch.end();
		player.checkForInput();
		//player.borderCheck();
		for(int i=0; i<40; i++){
			stone[i].collisionCheck();
		}
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		background.dispose();
		player.img.dispose();
		for(int i=0; i<40; i++){
			stone[i].img.dispose();
		}
		for(int i=0; i<5; i++){
			heart[i].img.dispose();
		}
	}
}
