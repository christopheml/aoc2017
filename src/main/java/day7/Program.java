package day7;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Program {

    private final String name;

    private final int weight;

    private final List<Program> children = new ArrayList<>();

    private Program parent;

    public Program(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public void attachChild(Program child) {
        children.add(child);
        child.attachParent(this);
    }

    private void attachParent(Program program) {
        this.parent = program;
    }

    public Optional<Program> getParent() {
        return Optional.ofNullable(parent);
    }
}
