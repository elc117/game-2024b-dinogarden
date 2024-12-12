package io.nathimaria.dinogarden;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.Random;

public class Quiz {
    private final SpriteBatch batch;
    private final ArrayList<Texture> questions;
    private ArrayList<AnswerArea> answers;
    private int questionIndex;
    private float touchX, touchY;
    private AnswerArea a, b, c;
    private Random ran;

    public Quiz() {
        ran = new Random();
        questions = new ArrayList<>();
        for (int i = 1; i < 7; i++) {
            questions.add(new Texture("questions/" + i + ".png"));
        }
        batch = new SpriteBatch();
        answers = new ArrayList<>();
        a = new AnswerArea(251,306);
        b = new AnswerArea(174,229);
        c = new AnswerArea(92,147);
        answers.add(b);
        answers.add(a);
        answers.add(b);
        answers.add(a);
        answers.add(c);
        answers.add(c);
        questionIndex = ran.nextInt(questions.size());
    }

    public void display(DinoGarden game) {
        batch.begin();
        if(game.isQuiz()) {
            batch.draw(questions.get(questionIndex), 50,30);
        }
        if (Gdx.input.isTouched()) {
            touchX = Gdx.input.getX();
            touchY = Gdx.input.getY();
            if(answers.get(questionIndex).clicked(touchX, touchY)) {
                game.score();
                game.setQuiz(false);
            } else {
                game.setQuiz(false);
                questionIndex = ran.nextInt(questions.size());
            }
        }

        batch.end();
    }

}
