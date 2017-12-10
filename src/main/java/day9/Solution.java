package day9;

import common.FileReader;
import common.Node;

import java.util.List;

public final class Solution {

    private Solution() {
    }

    public static void main(String... args) throws Exception {
        try (FileReader reader = FileReader.read("/day9/stream.txt")) {
            String stream = reader.lines().findFirst().orElseThrow(IllegalStateException::new);

            StreamTokenizer tokenizer = new StreamTokenizer(stream);
            List<Token> tokens = tokenizer.tokenize();

            StreamParser parser = new StreamParser();
            Node<Integer> root = parser.parse(tokens);

            ScoreCalculator scoreCalculator = new ScoreCalculator();
            int totalScore = scoreCalculator.assignScores(root);

            System.out.println("Total score for the stream is: " + totalScore);

            long garbageCount = tokens.stream().filter(token -> token == Token.GARBAGE).count();
            System.out.println("Total garbage found: " + garbageCount);
        }

    }

}
