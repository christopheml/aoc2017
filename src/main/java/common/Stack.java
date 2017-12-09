package common;

import java.util.ArrayList;
import java.util.List;

/**
 * Simple inefficient implementation of stack backed by an ArrayList.
 *
 * @param <T> Type of the elements of the stack.
 */
public class Stack<T> {

    private static final int STACK_TOP = 0;

    private final List<T> elements = new ArrayList<>();

    public T pop() {
        checkIfEmpty();
        return elements.remove(STACK_TOP);
    }

    public void push(T element) {
        elements.add(STACK_TOP, element);
    }

    public T peek() {
        checkIfEmpty();
        return elements.get(STACK_TOP);
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }

    private void checkIfEmpty() {
        if (elements.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
    }

}
