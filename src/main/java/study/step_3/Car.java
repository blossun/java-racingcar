package study.step_3;

public class Car {
    private int position;

    public void move(boolean movable) {
        if (movable) {
            this.position++;
        }
    }

    public int count() {
        return this.position;
    }
}