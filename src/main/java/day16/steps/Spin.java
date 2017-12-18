package day16.steps;

import day16.Line;

public class Spin implements Step {

    private final int offset;

    public Spin(int offset) {
        this.offset = offset;
    }

    @Override
    public void accept(Line line) {
        line.spin(offset);
    }

}
