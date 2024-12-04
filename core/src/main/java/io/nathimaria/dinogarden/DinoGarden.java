package io.nathimaria.dinogarden;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.utils.ScreenUtils;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class DinoGarden extends ApplicationAdapter {
    private BackgroundScreen backgroundScreen;
    private DinoAnimation dinoAnimation;
    private Plants plants;
    private boolean quiz;

    public boolean isQuiz() {
        return quiz;
    }

    public void setQuiz(boolean quiz) {
        this.quiz = quiz;
    }

    @Override
    public void create() {
        backgroundScreen = new BackgroundScreen();
        dinoAnimation = new DinoAnimation();
        plants = new Plants();
        quiz = false;
    }


    @Override
    public void render() {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);

        backgroundScreen.display();
        dinoAnimation.display();
        plants.display();
    }

    @Override
    public void dispose() {
        //batch.dispose();
        //image1.dispose();
        // image2.dispose();
    }
}
