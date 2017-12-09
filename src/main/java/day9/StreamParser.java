package day9;

import common.Node;
import common.Stack;

import java.util.List;

public class StreamParser {

    private final Stack<Node<Integer>> nodes;

    private Node<Integer> root;

    public StreamParser() {
        nodes = new Stack<>();
    }

    public Node<Integer> parse(List<Token> tokens) {
        tokens.stream()
            .filter(token -> token == Token.GROUP_OPEN || token == Token.GROUP_CLOSE)
            .forEach(this::consume);
        return root;
    }

    private void consume(Token token) {
        if (token == Token.GROUP_OPEN) {
            nodes.push(new Node<>(null));
        } else if (token == Token.GROUP_CLOSE) {
            Node<Integer> child = nodes.pop();
            if (nodes.isEmpty()) {
                root = child;
            } else {
                root = nodes.peek();
                root.addChild(child);
            }
        }
    }

}
