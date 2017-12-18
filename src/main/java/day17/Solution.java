package day17;

import java.util.List;

class Solution {

    public static void main(String... args) {
        Spinlock spinlock = new Spinlock(359, 2018);
        for (int i = 0; i < 2017; i++) {
            spinlock.insert();
        }

        List<Integer> values = spinlock.toList();
        Integer solution = values.get((spinlock.getPosition() + 1) % values.size());
        System.out.println("The value after the last written one is: " + solution);
    }

}
