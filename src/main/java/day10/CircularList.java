package day10;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;

public class CircularList<T> extends AbstractCollection<T> implements Collection<T> {

    private final Object[] elements;

    CircularList(Collection<T> elements) {
        this.elements = elements.toArray(new Object[elements.size()]);
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        while (index < 0) index += elements.length;
        return (T) elements[index % elements.length];
    }

    public void set(int index, T value) {
        while (index < 0) index += elements.length;
        elements[index % elements.length] = value;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayIterator();
    }

    public int size() {
        return elements.length;
    }

    public void swap(int a, int b) {
        T firstElement = get(a);
        T secondElement = get(b);
        set(a, secondElement);
        set(b, firstElement);
    }

    private class ArrayIterator implements Iterator<T> {

        private int index;

        private ArrayIterator() {
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            return index < elements.length;
        }

        @Override
        public T next() {
            return (T) elements[index++];
        }

    }

}
