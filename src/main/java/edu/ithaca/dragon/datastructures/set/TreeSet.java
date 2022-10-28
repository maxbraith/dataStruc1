package edu.ithaca.dragon.datastructures.set;

import java.util.ArrayList;

public class TreeSet<T extends Comparable<T>> implements Set<T>{


    @Override
    public void add(T item) {
    }

    @Override
    public boolean contains(T item) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public ArrayList<T> toOrderedList() {
        return null;
    }

    @Override
    public Set<T> union(Set<T> otherSet) {
        return null;
    }

    @Override
    public Set<T> intersection(Set<T> otherSet) {
        return null;
    }
}
