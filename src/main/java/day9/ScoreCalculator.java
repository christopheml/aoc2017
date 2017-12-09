package day9;

import common.Node;

public class ScoreCalculator {

    public int assignScores(Node<Integer> node) {
        if (node.parent() == null) {
            node.setValue(1);
        } else {
            node.setValue(node.parent().value() + 1);
        }
        int childrenScore = node.children().stream()
                .map(this::assignScores)
                .reduce(0, Integer::sum);
        return node.value() + childrenScore;
    }

}
