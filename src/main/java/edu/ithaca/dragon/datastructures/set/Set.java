package edu.ithaca.dragon.datastructures.set;

import java.util.ArrayList;

/**
 * A set is collection of *unique* items. 
 * No matter how many times the same item is added to a Set, 
 * it will only appear in the set once
 */
public interface Set<T extends Comparable<T>> {
    
    /**
     * @post Adds an item to the current set, if it is not already in the set.
     *       If the item was already in the set, the set remains unchanged
     */
    void add(T item);

    /**
     * @return true if the item is in the set, false otherwise
     */
    boolean contains(T item);

    /**
     * @return the current number of unique items in the set
     */
    int size();

    /**
     * @return a new ArrayList of references to all items currently in the StringSet, 
     * sorted by their natural order
     */
    ArrayList<T> toOrderedList();

    /**
     * @return a Set representing the union of this Set and otherSet,
     * meaning a Set containing all items that are in either this Set or otherSet, or both
     * see https://byjus.com/maths/set-operations/ for more description
     */
    Set<T> union(Set<T> otherSet);

    /**
     * @return a Set representing the intersection of this Set and otherSet,
     * meaning a Set containing only items that are in both this Set and otherSet
     * see https://byjus.com/maths/set-operations/ for more description
     */
    Set<T> intersection(Set<T> otherSet);
}
