package com.example.mygame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.DelayAction;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class MyGdxGame extends ApplicationAdapter {
	Skin skin;
	Stage stage;
	Label label;
	float startDelay = 5f; //for my recording program
	@Override
	public void create () {
		skin = new Skin(Gdx.files.internal("ui/uiskin.json"));
		label = new Label("", skin);
		label.setFontScale(2f);
		label.setBounds(112f, 119f, 256f, 32f);
		label.setAlignment(Align.center);
		String[] phrases = {"Howdy, stranger!", "You look hungry.", "Have some apples.", "Only 10 rupees."};
		TypeWriterAction typeWriterAction = new TypeWriterAction(label, phrases, 2f, 0.1f);
		label.addAction(typeWriterAction);
		stage = new Stage(new FitViewport(480f, 270f));
		stage.addActor(label);
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 1);
		float delta = Gdx.graphics.getDeltaTime();
		startDelay-=delta; //only for my recording program
		if(startDelay<=0f){
			stage.act(Gdx.graphics.getDeltaTime());	
		}
		// stage.act(Gdx.graphics.getDeltaTime());
		stage.draw();
	}
	
	@Override
	public void dispose () {
		stage.dispose();
	}
}
