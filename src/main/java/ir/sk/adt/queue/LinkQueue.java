package ir.sk.adt.queue;

import ir.sk.adt.datastructure.linklist.FirstLastList;

import java.util.Iterator;

/**
 * 2-ended list
 *
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 1/31/2020.
 */
public class LinkQueue<T> implements Queue<T>, Iterable<T> {

    private FirstLastList<T> theList;

    public LinkQueue() {
        theList = new FirstLastList();
    }

    @Override
    public void add(T item) {
        enqueue(item);
    }

    @Override
    public boolean isEmpty() {
        return theList.isEmpty();
    }

    /**
     * @param j
     */
    @Override
    public void enqueue(T j) {
        theList.insertLast(j);
    }

    /**
     * @return
     */
    @Override
    public T dequeue() {
        return theList.deleteFirst();
    }

    @Override
    public T peek() {
        return theList.peakFirst();
    }

    public void display() {
        System.out.print("Queue (front-->rear): ");
        theList.displayList();
    }

    @Override
    public Iterator<T> iterator() {
        return theList.iterator();
    }
}