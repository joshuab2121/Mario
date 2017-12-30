package com.joshb.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.joshb.game.Screens.PlayScreen;

public class MarioBros extends Game {
	public 	SpriteBatch batch;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
        setScreen(new PlayScreen(this));
    }

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
