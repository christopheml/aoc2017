package day9;

import java.util.ArrayList;
import java.util.List;

public class StreamTokenizer {

    private static final char GROUP_OPEN = '{';
    private static final char GROUP_CLOSE = '}';
    private static final char GARBAGE_OPEN = '<';
    private static final char GARBAGE_CLOSE = '>';
    private static final char COMMENT = '!';

    private final String stream;

    private int position;

    private Stack<CharacterClassifier> classifiers;

    StreamTokenizer(String stream) {
        this.stream = stream;
        position = 0;
        classifiers = new Stack<>();
        classifiers.push(REGULAR_CLASSIFIER);
    }

    public List<Token> tokenize() {
        List<Token> tokens = new ArrayList<>();
        while (position < stream.length()) {
            tokens.add(nextToken());
        }
        return tokens;
    }

    private Token nextToken() {
        char current = stream.charAt(position);
        Token token = classifiers.peek().classify(current);
        switch (token) {
            case COMMENT:
                classifiers.push(COMMENT_CLASSIFIER);
                break;
            case GARBAGE_OPEN:
                classifiers.push(GARBAGE_CLASSIFIER);
                break;
            case GARBAGE_CLOSE:
            case COMMENTED:
                classifiers.pop();
                break;
            default:
                break;
        }
        position++;
        return token;
    }

    @FunctionalInterface
    private interface CharacterClassifier {
        Token classify(char character);
    }

    private static final CharacterClassifier REGULAR_CLASSIFIER = character -> {
        switch (character) {
            case GARBAGE_OPEN:
                return Token.GARBAGE_OPEN;
            case GROUP_OPEN:
                return Token.GROUP_OPEN;
            case GROUP_CLOSE:
                return Token.GROUP_CLOSE;
            case StreamTokenizer.COMMENT:
                return Token.COMMENT;
            default:
                return Token.REGULAR;
        }
    };

    private static final CharacterClassifier GARBAGE_CLASSIFIER = character -> {
        switch (character) {
            case GARBAGE_CLOSE:
                return Token.GARBAGE_CLOSE;
            case StreamTokenizer.COMMENT:
                return Token.COMMENT;
            default:
                return Token.GARBAGE;
        }
    };

    private static final CharacterClassifier COMMENT_CLASSIFIER = character -> Token.COMMENTED;

}
