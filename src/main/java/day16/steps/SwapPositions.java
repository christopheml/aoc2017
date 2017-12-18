package day16.steps;

import day16.Line;

public class SwapPositions implements Step {

    private final int p1;
    private final int p2;

    public SwapPositions(int p1, int p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    @Override
    public void accept(Line line) {
        line.swapPositions(p1, p2);
    }

}
