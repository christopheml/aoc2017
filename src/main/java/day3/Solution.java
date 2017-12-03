package day3;

public class Solution {

    private static final int DESTINATION_STEP = 277678;

    public static void main(String... args) {

        CoordinateSequence sequence = new CoordinateSequence();
        while (sequence.getStep() < DESTINATION_STEP) {
            sequence.nextStep();
        }

        Coordinate position = sequence.getPosition();
        int distance = Math.abs(position.x) + Math.abs(position.y);

        System.out.println("Distance for " + DESTINATION_STEP + " is " + distance);
    }


}
