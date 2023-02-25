package com.dungeongame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.dungeongame.classes.Player;

public class DungeonGame extends ApplicationAdapter {
	SpriteBatch batch;
	Player player;
	Texture background;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		player = new Player();
		background = new Texture(Gdx.files.internal("background.png"));
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 1);
		batch.begin();
		batch.draw(background, 0, 0);
		batch.draw(player.img,player.rect.x, player.rect.y);
		batch.end();
		player.checkForInput();
		player.borderCheck();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
