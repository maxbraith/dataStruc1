package edu.ithaca.dragon.datastructures.set;

import java.util.ArrayList;


public class TreeSet<T extends Comparable<T>> implements Set<T>{
    private BTNode<T> root;

    public TreeSet(){
        root = new BTNode<T>(null);
    }

    @Override
    public void add(T item) {
        root = BSTNodeUtil.bstAdd(root, item);
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
        return BTNodeUtil.inOrderList(root, new ArrayList<T>());
    }

    @Override
    public Set<T> union(Set<T> otherSet) {
        ArrayList<T> thisSetList = this.toOrderedList();
        ArrayList<T> otherSetList = otherSet.toOrderedList();
        Set<T> unionTree = new TreeSet<T>();
        for(int i=0; i<thisSetList.size(); i++){
            unionTree.add(thisSetList.get(i));
        }
        for(int i =0; i<otherSetList.size(); i++){
            unionTree.add(otherSetList.get(i));
        }
        return unionTree;
    }

    @Override
    public Set<T> intersection(Set<T> otherSet) {
        ArrayList<T> thisSetList = this.toOrderedList();
        Set<T> intersectionTree = new TreeSet<T>();
        for(int i=0; i<thisSetList.size(); i++){
            if(otherSet.contains(thisSetList.get(i))){
                intersectionTree.add(thisSetList.get(i));
            }
        }
        return intersectionTree;

    }

}
