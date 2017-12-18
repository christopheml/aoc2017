package day17;

import java.util.List;

class Solution {

    public static void main(String... args) {
        firstPartSolution();
        secondPartSolution();
    }

    private static void firstPartSolution() {
        Spinlock spinlock = new Spinlock(359, 2018);
        for (int i = 0; i < 2017; i++) {
            spinlock.insert();
        }

        List<Integer> values = spinlock.toList();
        Integer solution = values.get((spinlock.getPosition() + 1) % values.size());
        System.out.println("The value after the last written one is: " + solution);
    }

    private static void secondPartSolution() {
        SimulatedSpinlock simulatedSpinlock = new SimulatedSpinlock(359);
        int solution = simulatedSpinlock.simulate(50000000);
        System.out.println("The value after 0 is: " + solution);
    }


}
