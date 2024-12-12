package io.nathimaria.dinogarden;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Points {
    BitmapFont font;
    SpriteBatch batch;

    public Points() {
        font = new BitmapFont();
        batch = new SpriteBatch();
    }

    public void drawPoints(DinoGarden game) {
        batch.begin();
        font.setColor(Color.BLACK);
        font.draw(batch, "Pontos: "+game.getScore(), 50, 400);
        batch.end();
    }
}
