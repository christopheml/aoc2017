package day16;

import day16.steps.Step;

import java.util.List;

public class Dance {

    private final List<Step> steps;

    public Dance(String steps) {
        DanceParser parser = new DanceParser();
        this.steps = parser.parse(steps);
    }

    public void perform(Line line) {
        steps.forEach(step -> step.accept(line));
    }

}
