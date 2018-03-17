package com.joshb.game.Sprites;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import com.joshb.game.MarioBros;

/**
 * Created by joshb on 1/9/2018.
 */

public class Mario extends Sprite {
    public World world;
    public Body b2body;
    public final static float walk = .1f;
    public final static float walkBack = -.1f;
    public final static float run = .3f;
    public final static float runBack = -.3f;
    public final static float jump = 4f;

    public Mario(World world) {
        this.world = world;
        defineMario();
    }

    private void defineMario() {
        BodyDef bDef = new BodyDef();
        bDef.position.set(32 / MarioBros.PPM, 32 / MarioBros.PPM);
        bDef.type = BodyDef.BodyType.DynamicBody;
        b2body = world.createBody(bDef);

        FixtureDef fDef = new FixtureDef();
        CircleShape shape = new CircleShape();
        shape.setRadius(5 / MarioBros.PPM);

        fDef.shape = shape;
        b2body.createFixture(fDef);
    }


}
