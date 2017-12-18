package day16.steps;

import day16.Line;

public class SwapPrograms implements Step {

    private final char c1;
    private final char c2;

    public SwapPrograms(char c1, char c2) {
        this.c1 = c1;
        this.c2 = c2;
    }

    @Override
    public void accept(Line line) {
        line.swapPrograms(c1, c2);
    }

}
