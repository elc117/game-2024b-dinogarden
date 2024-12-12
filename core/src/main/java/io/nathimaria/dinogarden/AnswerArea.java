package io.nathimaria.dinogarden;

public class AnswerArea {
    private float xMin;
    private float xMax;
    private float yMin;
    private float yMax;

    public AnswerArea(float yMin, float yMax) {
        xMin = 80f;
        xMax = 130f;
        this.yMin = yMin;
        this.yMax = yMax;
    }

    public float getxMin() {
        return xMin;
    }

    public void setxMin(float xMin) {
        this.xMin = xMin;
    }

    public float getxMax() {
        return xMax;
    }

    public void setxMax(float xMax) {
        this.xMax = xMax;
    }

    public float getyMin() {
        return yMin;
    }

    public void setyMin(float yMin) {
        this.yMin = yMin;
    }

    public float getyMax() {
        return yMax;
    }

    public void setyMax(float yMax) {
        this.yMax = yMax;
    }

    public boolean clicked(float x, float y) {
        return x >= xMin && x <= xMax && y >= yMin && y <= yMax;
    }
}


