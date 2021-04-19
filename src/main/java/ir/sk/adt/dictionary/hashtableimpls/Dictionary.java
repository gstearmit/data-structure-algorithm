package ir.sk.adt.dictionary.hashtableimpls;

import ir.sk.helper.Point;
import ir.sk.helper.complexity.AmortizedTimeComplexity;
import ir.sk.helper.complexity.TimeComplexity;

/**
 * Dictionary (map, association list) is a data structure, which is generally an association of unique keys with some values.
 * One may bind a value to a key, delete a key (and naturally an associated value) and lookup for a value by the key. Values are not required to be unique.
 * <p>
 * There are only three basic operations on Dictionary: searching, inserting, and deleting.
 *
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 8/24/2020.
 */
public interface Dictionary<K, V> {

    @AmortizedTimeComplexity("O(1)")
    void add(K key, V value);

    @TimeComplexity("O(1)")
    @Point("the best time complexity for search, others: linear:O(n), Binary:O(log n)")
    V get(K key);

    @AmortizedTimeComplexity("O(1)")
    V remove(K key);
}