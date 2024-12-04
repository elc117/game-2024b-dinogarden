package io.nathimaria.dinogarden;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.Random;

public class Plants {

    private final SpriteBatch batch;
    private final ArrayList<Texture> plantTextures;
    private float xCoord1, xMax;

    public Plants() {
        batch = new SpriteBatch();
        plantTextures = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            plantTextures.add(new Texture("plants/plant"+ i +".png"));
        }

        xMax = Gdx.graphics.getWidth();
        xCoord1 = xMax;
    }

    public void display() {
        Random ran  = new Random();
        int frame = 0;
        int moveSpeed = 190;
        xCoord1 -= moveSpeed * Gdx.graphics.getDeltaTime();
        // We move the background, not the camera
        if (xCoord1 <= 0) {
            xCoord1 = xMax;
            frame = ran.nextInt(plantTextures.size());
        }
        batch.begin();
        batch.draw(plantTextures.get(frame), xCoord1, 285);
        batch.end();
    }

}
