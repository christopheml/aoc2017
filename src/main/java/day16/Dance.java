package day16;

import day16.steps.Spin;
import day16.steps.SwapPositions;
import day16.steps.SwapPrograms;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Dance {

    private final List<Consumer<Line>> steps;

    public Dance(String steps) {
        this.steps = parse(steps);
    }

    private List<Consumer<Line>> parse(String steps) {
        String[] individualSteps = steps.split(",");
        return Arrays.stream(individualSteps).map(this::parseStep).collect(Collectors.toList());
    }

    private Consumer<Line> parseStep(String step) {
        String parameters = step.substring(1);
        if (step.startsWith("s")) {
            Integer offset = Integer.valueOf(parameters);
            return new Spin(offset);
        } else if (step.startsWith("x")) {
            String[] subparameters = parameters.split("/");
            int p1 = Integer.valueOf(subparameters[0]);
            int p2 = Integer.valueOf(subparameters[1]);
            return new SwapPositions(p1, p2);
        } else if (step.startsWith("p")) {
            return new SwapPrograms(parameters.charAt(0), parameters.charAt(2));
        }
        throw new IllegalArgumentException();
    }

    public void perform(Line line) {
        steps.forEach(step -> step.accept(line));
    }

}
