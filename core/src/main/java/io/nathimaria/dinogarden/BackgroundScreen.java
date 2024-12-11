package io.nathimaria.dinogarden;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class BackgroundScreen {
    private final SpriteBatch batch;
    private final Texture image1, image2;
    private float xMax, xCoord1, xCoord2;
    private final int BACKGROUND_MOVE_SPEED = 200;

    public BackgroundScreen() {
        batch = new SpriteBatch();
        image1 = new Texture("maxresdefault2.jpg");
        image2 = new Texture("maxresdefault2.jpg");
        xMax = Gdx.graphics.getWidth();
        xCoord1 = xMax;
        xCoord2 = 0;
    }

    public void display(DinoGarden game) {
        if(game.isQuiz()) {
            xCoord1 = BACKGROUND_MOVE_SPEED * Gdx.graphics.getDeltaTime();
            xCoord2 = xCoord1;
        } else {
            xCoord1 -= BACKGROUND_MOVE_SPEED * Gdx.graphics.getDeltaTime();
            xCoord2 = xCoord1 - xMax;  // We move the background, not the camera
        }

        if (xCoord1 <= 0) {
            xCoord1 = xMax;
            xCoord2 = 0;
        }
        batch.begin();
        batch.draw(image1, xCoord1, 0);
        batch.draw(image2, xCoord2, 0);
        batch.end();

    }

}

// TENTAR USAR SPRITE?
