package day16;

public class Dance {

    private final String steps;

    public Dance(String steps) {
        this.steps = steps;
    }

    public void perform(Line line) {
        String[] actions = steps.split(",");
        for (String action : actions) {
            performAction(line, action);
        }
    }

    private void performAction(Line line, String action) {
        String parameters = action.substring(1);
        if (action.startsWith("s")) {
            int offset = Integer.valueOf(parameters);
            line.spin(offset);
        } else if (action.startsWith("x")) {
            String[] subparameters = parameters.split("/");
            int p1 = Integer.valueOf(subparameters[0]);
            int p2 = Integer.valueOf(subparameters[1]);
            line.swapPositions(p1, p2);
        } else if (action.startsWith("p")) {
            line.swapPrograms(parameters.charAt(0), parameters.charAt(2));
        }
    }

}
