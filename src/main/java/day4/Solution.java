package day4;

import common.FileReader;

public class Solution {

    private static final class Counter {

        private PassphraseValidator validator = new PassphraseValidator();
        private int validLines = 0;

        private GoldPassphaseValidator goldValidator = new GoldPassphaseValidator();
        private int goldValidLines = 0;

        public Counter accumulate(String line) {
            if (validator.isValid(line)) {
                validLines++;
            }

            if (goldValidator.isValid(line)) {
                goldValidLines++;
            }

            return this;
        }

        public Counter combine(Counter other) {
            this.validLines += other.validLines;
            this.goldValidLines += other.goldValidLines;
            return this;
        }

    }

    public static void main(String... args) throws Exception {

        try (FileReader reader = FileReader.read("/day4/passphrases.txt")) {
            Counter counter = reader.lines().collect(Counter::new, Counter::accumulate, Counter::combine);
            System.out.println("Valid passphrases: " + counter.validLines);
            System.out.println("Valid gold passphrases: " + counter.goldValidLines);
        }

    }

}
