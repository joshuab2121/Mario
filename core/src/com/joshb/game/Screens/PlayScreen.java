package com.joshb.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.joshb.game.MarioBros;
import com.joshb.game.RoundTo;
import com.joshb.game.Scenes.Hud;

/**
 * Created by joshb on 12/24/2017.
 */

public class PlayScreen implements Screen {
    private MarioBros game;

    private OrthographicCamera gameCam;
    private Viewport gamePort;
    private Hud hud;

    private TmxMapLoader mapLoader;
    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;

    public PlayScreen(MarioBros game) {
        this.game = game;
        gameCam = new OrthographicCamera();
        gamePort = new FitViewport(MarioBros.V_WIDTH,MarioBros.V_HEIGHT, gameCam);
        hud = new Hud(game.batch);

        mapLoader = new TmxMapLoader();
        map = mapLoader.load("level_1.tmx");
        renderer = new OrthogonalTiledMapRenderer(map);
        gameCam.position.set(gamePort.getWorldWidth() / 2,gamePort.getWorldHeight() / 2,0);
    }
    @Override
    public void show() {

    }

    public void update(float dt) {
        handleInput(dt);
        gameCam.update();
        renderer.setView(gameCam);
    }

    private void handleInput(float dt) {
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            if (Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT))
                gameCam.position.x -= RoundTo.RoundToNearest(300 * dt, CameraPixel(gameCam));
            else
                gameCam.translate(-100 * dt, 0);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            if (Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT))
                gameCam.position.x += RoundTo.RoundToNearest(300 * dt, CameraPixel(gameCam));
            else
                gameCam.position.x += RoundTo.RoundToNearest(100 * dt, CameraPixel(gameCam));
        }
    }

    @Override
    public void render(float delta) {
        update(delta);

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        renderer.render();

        game.batch.setProjectionMatrix(hud.stage.getCamera().combined);
        hud.stage.draw();
    }

    public static float CameraPixel(final OrthographicCamera pCamera){
        int width = Gdx.graphics.getWidth();
        int height = Gdx.graphics.getHeight();
        float CameraPixel;

        float targetRatio = (float)width/(float)height;
        float sourceRatio = pCamera.viewportWidth/pCamera.viewportHeight;

        if(targetRatio > sourceRatio)
            CameraPixel = height/pCamera.viewportHeight;
        else
            CameraPixel = width/pCamera.viewportWidth;

        return (int)CameraPixel;
    }

    @Override
    public void resize(int width, int height) {
        gamePort.update(width, height);

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
