package day7;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class Program {

    private final String name;

    private final int weight;

    private final List<Program> children = new ArrayList<>();

    private Program parent;

    Program(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    String getName() {
        return name;
    }

    int getWeight() {
        return weight;
    }

    void attachChild(Program child) {
        children.add(child);
        child.attachParent(this);
    }

    private void attachParent(Program program) {
        this.parent = program;
    }

    Optional<Program> getParent() {
        return Optional.ofNullable(parent);
    }

}
