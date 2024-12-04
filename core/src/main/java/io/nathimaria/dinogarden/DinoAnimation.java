package io.nathimaria.dinogarden;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;


public class DinoAnimation  {

    private Animation<TextureRegion> dinoAnimation;
    private TextureRegion[] runFrames;
    private SpriteBatch batch;
    private float time, yMax, yMin;
    private boolean jumping;

    public DinoAnimation() {
        batch = new SpriteBatch();
        time = 0f;
        runFrames = new TextureRegion[8];
        yMin = 60f;
        yMax = 260f;
        jumping = false;
    }

    public void display() {

        for (int i = 0; i <= 7; i++) {
            runFrames[i] = new TextureRegion(new Texture("dino/Run" + i + ".png"));
        }

        dinoAnimation = new Animation(0.1f, runFrames);
        //Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // Clear screen
        time += Gdx.graphics.getDeltaTime(); // Accumulate elapsed animation time

        // Get current frame of animation for the current stateTime
        TextureRegion currentFrame = dinoAnimation.getKeyFrame(time, true);
        batch.begin();
        if(isJumping()) {
                jump();
        } else {
            batch.draw(currentFrame, 50, 60); // Draw current frame at (50, 50)
        }

        batch.end();
    }
    public boolean isJumping() {
        return Gdx.input.justTouched();
    }

    public void jump() {
        TextureRegion currentFrame = dinoAnimation.getKeyFrame(time, false);
        float y = yMin+1;
        float delta = 200 * Gdx.graphics.getDeltaTime();
        while (y < yMax) {
            y += delta;
        }

        batch.draw(currentFrame, 50, y);
    }

    public void dispose() {
        batch.dispose();
    }
}
