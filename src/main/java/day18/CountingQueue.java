package day18;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class CountingQueue<E> implements Queue<E> {

    private final Queue<E> queue;

    private int count;

    public CountingQueue(Queue queue) {
        count = 0;
        this.queue = queue;
    }

    public boolean add(E e) {
        count++;
        return queue.add(e);
    }

    public boolean offer(E e) {
        return queue.offer(e);
    }

    public E remove() {
        return queue.remove();
    }

    public E poll() {
        return queue.poll();
    }

    public E element() {
        return queue.element();
    }

    public E peek() {
        return queue.peek();
    }

    public int size() {
        return queue.size();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public boolean contains(Object o) {
        return queue.contains(o);
    }

    public Iterator<E> iterator() {
        return queue.iterator();
    }

    public Object[] toArray() {
        return queue.toArray();
    }

    public <T> T[] toArray(T[] a) {
        return queue.toArray(a);
    }

    public boolean remove(Object o) {
        return queue.remove(o);
    }

    public boolean containsAll(Collection<?> c) {
        return queue.containsAll(c);
    }

    public boolean addAll(Collection<? extends E> c) {
        return queue.addAll(c);
    }

    public boolean removeAll(Collection<?> c) {
        return queue.removeAll(c);
    }

    public boolean removeIf(Predicate<? super E> filter) {
        return queue.removeIf(filter);
    }

    public boolean retainAll(Collection<?> c) {
        return queue.retainAll(c);
    }

    public void clear() {
        queue.clear();
    }

    public Spliterator<E> spliterator() {
        return queue.spliterator();
    }

    public Stream<E> stream() {
        return queue.stream();
    }

    public Stream<E> parallelStream() {
        return queue.parallelStream();
    }

    public void forEach(Consumer<? super E> action) {
        queue.forEach(action);
    }

    public int getCount() {
        return count;
    }
}
