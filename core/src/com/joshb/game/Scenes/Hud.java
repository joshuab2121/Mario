package com.joshb.game.Scenes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.joshb.game.MarioBros;

import java.util.Locale;

import static java.lang.String.format;

/**
 * Created by joshb on 12/29/2017.
 */

public class Hud {
    public Stage stage;
    private Viewport viewport;

    private Integer worldTimer;
    private float timeCount;
    private Integer score;

    Label countdownLabel;
    Label scoreLabel;
    Label timeLabel;
    Label levelLabel;
    Label worldLabel;
    Label marioLabel;

    Label.LabelStyle labelStyle = new Label.LabelStyle(new BitmapFont(), Color.WHITE);

    public Hud(SpriteBatch spriteBatch) {
        worldTimer = 300;
        timeCount = 0;
        score = 0;

        viewport = new FitViewport(MarioBros.V_WIDTH, MarioBros.V_HEIGHT, new OrthographicCamera());
        stage = new Stage((viewport), spriteBatch);

        Table table = new Table();
        table.top();
        table.setFillParent(true);

        countdownLabel = new Label(format(Locale.US,"%03d", worldTimer), labelStyle);
        scoreLabel = new Label(format(Locale.US,"%06d", score), labelStyle);
        timeLabel = new Label("Time", labelStyle);
        levelLabel = new Label("1-1", labelStyle);
        worldLabel = new Label("World", labelStyle);
        marioLabel = new Label("Mario", labelStyle);

        table.add(marioLabel).expandX().padTop(10);
        table.add(worldLabel).expandX().padTop(10);
        table.add(timeLabel).expandX().padTop(10);
        table.row();
        table.add(scoreLabel).expandX();
        table.add(levelLabel).expandX();
        table.add(countdownLabel).expandX();

        stage.addActor(table);


    }
}
