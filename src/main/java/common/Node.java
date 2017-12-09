package common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Node<T> {

    private final List<Node<T>> children;

    private T value;

    private Node<T> parent;

    public Node(Node<T> parent) {
        this(parent, null);
    }

    public Node(Node<T> parent, T value) {
        this.value = value;
        children = new ArrayList<>();
    }

    public void setValue(T value) {
        this.value = value;
    }

    public T value() {
        return value;
    }

    public Node<T> parent() {
        return parent;
    }

    private void setParent(Node<T> parent) {
        this.parent = parent;
    }

    public void removeChild(Node<T> child) {
        children.remove(child);
    }

    public void addChild(Node<T> child) {
        child.setParent(this);
        children.add(child);
    }

    public List<Node<T>> children() {
        return Collections.unmodifiableList(children);
    }

}
