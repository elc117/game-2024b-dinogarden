package io.nathimaria.dinogarden;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.utils.ScreenUtils;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class DinoGarden extends ApplicationAdapter {
    private BackgroundScreen backgroundScreen;
    private DinoAnimation dinoAnimation;
    private Plants plants;
    private Quiz quizzes;
    private Points points;
    private boolean quiz;
    private int score;

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
        quizzes = new Quiz();
        score = 0;
        points = new Points();
    }

    @Override
    public void render() {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        backgroundScreen.display(this);
        dinoAnimation.display(this);
        plants.display(this);
        quizzes.display(this);
        points.drawPoints(this);
        if (dinoAnimation.catchPlant(plants)) {
            quiz = true;
        }
    }

    @Override
    public void dispose() {
        //batch.dispose();
        //image1.dispose();
        // image2.dispose();
    }

    public void score() {
        score += 10;
    }

    public int getScore() {
        return score;
    }
}
