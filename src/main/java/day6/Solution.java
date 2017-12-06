package day6;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String... args) {
        MemoryBanks banks = MemoryBanks.of(new int[] {11, 11, 13, 7, 0, 15, 5, 5, 4, 4, 1, 1, 7, 1, 15, 11}, 16);
        Set<Integer> previousStates = new HashSet<>();
        int state = banks.getState();
        int steps = 0;
        while (!previousStates.contains(state)) {
            previousStates.add(state);
            banks.cycle();
            state = banks.getState();
            steps++;
        }

        System.out.println("Cycle detected after " + steps + " steps");
    }

}
