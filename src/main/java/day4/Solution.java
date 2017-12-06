package day4;

import common.FileReader;

public class Solution {

    private static final class Counter {

        private PassphraseValidator validator = new PassphraseValidator();
        private int validLines = 0;

        private AdvancedPassphaseValidator advancedValidator = new AdvancedPassphaseValidator();
        private int advancedValidLines = 0;

        public Counter accumulate(String line) {
            if (validator.isValid(line)) {
                validLines++;
            }

            if (advancedValidator.isValid(line)) {
                advancedValidLines++;
            }

            return this;
        }

        public Counter combine(Counter other) {
            this.validLines += other.validLines;
            this.advancedValidLines += other.advancedValidLines;
            return this;
        }

    }

    public static void main(String... args) throws Exception {

        try (FileReader reader = FileReader.read("/day4/passphrases.txt")) {
            Counter counter = reader.lines().collect(Counter::new, Counter::accumulate, Counter::combine);
            System.out.println("Valid passphrases: " + counter.validLines);
            System.out.println("Valid advanced passphrases: " + counter.advancedValidLines);
        }

    }

}
