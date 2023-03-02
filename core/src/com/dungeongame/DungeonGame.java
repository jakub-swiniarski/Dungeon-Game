package com.dungeongame;

import box2dLight.PointLight;
import box2dLight.RayHandler;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import com.dungeongame.classes.entities.Player;
import com.dungeongame.classes.items.Torch;
import com.dungeongame.classes.ui.Heart;
import com.dungeongame.classes.ui.Inventory;
import com.dungeongame.classes.ui.InventoryPointer;
import com.dungeongame.classes.world.Room;

public class DungeonGame extends ApplicationAdapter {
	SpriteBatch batch;
	Player player;
	World world;
	RayHandler rayHandler;
	Stage stage;
	Heart[] heart = new Heart[5];
	Inventory playerInv;
	InventoryPointer invPointer;
	Torch torch;
	Texture toDraw;
	OrthographicCamera playerCam;
	OrthographicCamera worldCam;
	Room[] room = new Room[9];
	FreeTypeFontGenerator generator;
	FreeTypeFontGenerator.FreeTypeFontParameter parameter;
	BitmapFont font24;

	@Override
	public void create () {
		playerCam = new OrthographicCamera(1280*2,720*2);
		worldCam = new OrthographicCamera(1280,720);
		batch = new SpriteBatch();
		player = new Player();

		for(int i=0; i<5; i++){
			heart[i] = new Heart();
			heart[i].rect.y=665;
			heart[i].rect.x=10+i*heart[i].rect.width;
		}

		torch = new Torch();

		playerInv = new Inventory();
		invPointer = new InventoryPointer();

		worldCam.position.set(0,0, 0);


		for(int i=0; i<9; i++){
			room[i]=new Room();
		}
		for(int i=0; i<3; i++){
			room[i].rect.x=-1280+1280*i;
			room[i].rect.y=-720;
		}
		for(int i=3; i<6; i++){
			room[i].rect.x=-1280+1280*(i-3);
			room[i].rect.y=0;
		}
		for(int i=6; i<9; i++){
			room[i].rect.x=-1280+1280*(i-6);
			room[i].rect.y=720;
		}
		for(int i=0; i<9; i++){
			room[i].generateContent();
		}

		//lightning
		stage = new Stage();
		world = new World(new Vector2(0,0),false);
		rayHandler = new RayHandler(world);
		rayHandler.setCombinedMatrix(playerCam.combined);
		torch.light = new PointLight(rayHandler,50, Color.ORANGE,torch.brightness, 9999,9999);

		//font
		generator = new FreeTypeFontGenerator(Gdx.files.internal("font.otf"));
		parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
		parameter.size = 24;
		font24 = generator.generateFont(parameter);
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 1);
		batch.setProjectionMatrix(playerCam.combined);
		playerCam.position.set(player.rect.x,player.rect.y,0);
		playerCam.update();
		//affected by light
		batch.begin();
		for(int i=0; i<9; i++){
			batch.draw(room[i].img,room[i].rect.x,room[i].rect.y);
			for(int j=0; j<room[i].chestAmount; j++){
				batch.draw(room[i].chest[j].img,room[i].chest[j].rect.x,room[i].chest[j].rect.y);
			}
		}
		batch.draw(player.img,player.rect.x, player.rect.y);
		if(torch.slot!=5){
			if(torch.slot==player.currentSlot){
				if(!torch.lightReset){
					torch.brightness=400;
					torch.lightReset=true;
				}
				batch.draw(torch.img,torch.rect.x, torch.rect.y);
				torch.lightOn=true;
				rayHandler.setCombinedMatrix(playerCam.combined);
			}
			else {
				torch.lightOn=false;
				torch.lightReset=false;
			}
		}
		else {
			batch.draw(torch.img,torch.rect.x, torch.rect.y);
			rayHandler.setCombinedMatrix(playerCam.combined);
		}
		batch.end();
		//rayHandler.updateAndRender();

		batch.setProjectionMatrix(stage.getBatch().getProjectionMatrix());
		//not affected by light
		batch.begin();
		font24.draw(batch, "FPS: "+Gdx.graphics.getFramesPerSecond(), 5, 20);
		for(int i=0; i<player.hp; i++){
			batch.draw(heart[i].img, heart[i].rect.x, heart[i].rect.y);
		}

		//inventory
		batch.draw(playerInv.img,playerInv.rect.x,playerInv.rect.y);
		batch.draw(invPointer.img,1015+player.currentSlot*50,invPointer.rect.y);
		for(int i=0; i<5; i++){
			if(player.inventory[i]==1) {
				toDraw=new Texture(Gdx.files.internal("torch-icon.png"));
				batch.draw(toDraw, 1015+i*50, playerInv.rect.y);
			}
		}
		batch.end();

		player.checkForInput();
		//player.borderCheck();
		torch.animation();
		if(torch.slot==5) torch.pickUpCheck();
		else {
			torch.rect.x=player.rect.x-torch.rect.width;
			torch.rect.y=player.rect.y;
		}
		for(int i=0; i<9; i++){
			room[i].borderCheck();
			for(int j=0; j<room[i].chestAmount; j++){
				room[i].chest[j].collisionCheck();
			}
		}
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		player.img.dispose();
		for(int i=0; i<5; i++) heart[i].img.dispose();
		playerInv.img.dispose();
		invPointer.img.dispose();
		torch.img.dispose();
		generator.dispose();
		font24.dispose();
		torch.light.dispose();
		world.dispose();
		stage.dispose();
		//rayHandler.dispose();
		toDraw.dispose();
		torch.icon.dispose();
		for(int i=0; i<9; i++) {
			room[i].img.dispose();
			for(int j=0; j<room[i].chestAmount; j++){
				room[i].chest[j].img.dispose();
			}
		}
	}
}