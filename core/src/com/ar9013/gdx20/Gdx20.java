package com.ar9013.gdx20;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class Gdx20 extends ApplicationAdapter implements InputProcessor{

	private String TAG = "GdX20";
	private Stage stage;
	private Skin skin;
	private Table table;
	private TextButton btn_start;
	private TextButton btn_quit;

		SpriteBatch batch;
		Sprite sprite;

	
	@Override
	public void create () {
		skin = new Skin(Gdx.files.internal("uiskin.json"));
		stage = new Stage(new ScreenViewport());

		table = new Table();
		table.setWidth(stage.getWidth());
		table.align(Align.center|Align.top);

		table.setPosition(0,Gdx.graphics.getHeight());

		btn_start = new TextButton("New Game",skin);
		btn_start.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				super.clicked(event, x, y);
				Gdx.app.log(TAG,"btn_start");
			}
		});

		btn_quit = new TextButton("Quit Game",skin);

		table.padTop(30);
		table.add(btn_start).padBottom(30); // 下方出現30 的距離
		table.row(); //加上這行從原本兩個按鈕排程一列，變成兩列
		table.add(btn_quit);

		stage.addActor(table);

		batch = new SpriteBatch();
		sprite = new Sprite(new Texture(Gdx.files.internal("badlogic.jpg")));
		sprite.setSize(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());

		InputMultiplexer im = new InputMultiplexer(stage,this);// 在上層的要先傳入
		Gdx.input.setInputProcessor(im);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();
		sprite.draw(batch);
		batch.end();


		stage.act(Gdx.graphics.getDeltaTime());
		stage.draw();

	}
	
	@Override
	public void dispose () {

	}

	@Override
	public boolean keyDown(int keycode) {
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		sprite.setFlip(!sprite.isFlipX(),sprite.isFlipY()); //
		return true;  // true 代表程序員要控制
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		return false;
	}
}
