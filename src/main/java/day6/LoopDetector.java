package day6;

import java.util.HashSet;
import java.util.Set;

class LoopDetector {

    private final MemoryBanks banks;

    private final Set<Integer> previousStates = new HashSet<>();

    LoopDetector(MemoryBanks banks) {
        this.banks = banks;
    }

    int getNextCycleSize() {
        previousStates.clear();
        int steps = 0;
        int state = banks.getState();
        while (!previousStates.contains(state)) {
            previousStates.add(state);
            banks.cycle();
            state = banks.getState();
            steps++;
        }
        return steps;
    }

}
