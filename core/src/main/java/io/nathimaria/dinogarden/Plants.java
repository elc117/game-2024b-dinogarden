package io.nathimaria.dinogarden;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

import java.util.ArrayList;
import java.util.Random;

public class Plants {

    private final SpriteBatch batch;
    private final ArrayList<Texture> plantTextures;
    private final Texture plant;
    private float xCoord1, xMax;
    private final Rectangle plantRectangle;

    public Plants() {
        batch = new SpriteBatch();
        plantTextures = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            // era pra ser várias plantas, mas não funcionou muito bem até agora
            // fazer Sprites como o jogo do balde
            plantTextures.add(new Texture("plants/plant" + i + ".png"));
        }
        plant = new Texture("plants/39.png");
        xMax = Gdx.graphics.getWidth();
        xCoord1 = xMax;
        plantRectangle = new Rectangle();
    }

    public Rectangle getPlantRectangle() {
        return plantRectangle;
    }

    public void display(DinoGarden game) {
        Random ran = new Random();
        int frame = 0;
        int moveSpeed = 190;
        xCoord1 -= moveSpeed * Gdx.graphics.getDeltaTime();
        // We move the background, not the camera
        if (xCoord1 <= 0) {
            xCoord1 = xMax;
            frame = ran.nextInt(plantTextures.size());
        }
        batch.begin();
        plantRectangle.set(xCoord1, 285, 70, 64);
        batch.draw(plant, xCoord1, 285);
        batch.end();
    }

}
