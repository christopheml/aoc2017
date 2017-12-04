package day4;

import common.FileReader;

public class Solution {

    private static final class Counter {

        private PassphraseValidator validator = new PassphraseValidator();

        private int validLines = 0;

        public Counter accumulate(String line) {
            if (validator.isValid(line)) {
                validLines++;
            }

            return this;
        }

        public Counter combine(Counter other) {
            this.validLines += other.validLines;
            return this;
        }

    }

    public static void main(String... args) throws Exception {

        try (FileReader reader = FileReader.read("/day4/passphrases.txt")) {
            Counter counter = reader.lines().collect(Counter::new, Counter::accumulate, Counter::combine);
            System.out.println("Valid passphrases: " + counter.validLines);
        }

    }

}
