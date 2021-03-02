package ir.sk.datastructure.set;

import ir.sk.datastructure.Collection;

/**
 * Set is ADT of the collection of elements which disallows duplicates, (opposite of bag)
 */
public interface Set<T> extends Collection<T> {
    void add(T item);
    void remove(T item);
    boolean isEmpty();
}
