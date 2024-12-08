package io.nathimaria.dinogarden;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class DinoAnimation  {

    private Animation<TextureRegion> dinoAnimation;
    private TextureRegion[] runFrames;
    private SpriteBatch batch;
    private float time, yMax, yMin, y;
    private boolean jumping, ascending;
    private Rectangle dinoRectangle;

    public DinoAnimation() {
        batch = new SpriteBatch();
        time = 0f;
        runFrames = new TextureRegion[8];
        yMin = 60f;
        y = yMin;
        yMax = 260f;
        jumping = false;
        ascending = false;
        dinoRectangle = new Rectangle();
    }

    // FAÇO O DISPLAY RECEBER O OBJETO JOGO PRA PEGAR O ESTADO DO QUIZ (??)
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
        if(Gdx.input.justTouched()) {
            jumping = true;
            ascending = true;
        }
        if(jumping) {
            currentFrame = dinoAnimation.getKeyFrame(time, false);
                if(ascending) {
                    ascend();
                }
                 else {
                    descend();
                }
        }

        dinoRectangle.set(50, y, 200, 139);
        batch.draw(currentFrame, 50, y); // Draw current frame at (50, 50)
        batch.end();
    }
    public void ascend() {
        if(y >= yMax) {
            ascending = false;
            //descending = true;
        } else {
            y += 600 * Gdx.graphics.getDeltaTime();
        }
    }

    public void descend() {
        if(y <= yMin) {
            //descending = false;
            jumping = false;
            y = yMin;
        } else {
            y -= 600 * Gdx.graphics.getDeltaTime();
        }
    }

    public boolean catchPlant(Plants plant) {
        return dinoRectangle.overlaps(plant.getPlantRectangle());
    }

    public Rectangle getDinoRectangle() {
        return dinoRectangle;
    }

    public void dispose() {
        batch.dispose();
    }
}
