package edu.ithaca.dragon.datastructures.set;

import java.util.ArrayList;


public class TreeSet<T extends Comparable<T>> implements Set<T>{
    private BTNode<T> root;

    public TreeSet(){
        root = new BTNode<T>(null);
    }

    @Override
    public void add(T item) {
        BSTNodeUtil.bstAdd(root, item);
    }

    @Override
    public boolean contains(T item) {
        return BSTNodeUtil.bstContains(root, item);
    }

    @Override
    public int size() {
        return BTNodeUtil.nodeCount(root);
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
