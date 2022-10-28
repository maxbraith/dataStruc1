package edu.ithaca.dragon.datastructures.set;

import java.util.ArrayList;
import java.util.Arrays;

public class ListSet<T extends Comparable<T>> implements Set<T>{
    Comparable[] mySet;

    public ListSet() {
        mySet = new Comparable[0];
    }

    @Override
    public void add(T item) {
        int setLength = mySet.length;
        Comparable[] newArray;

        if (setLength == 0) {
            newArray = new Comparable[1];
            newArray[0] = item;
            mySet = newArray;
        }
        else if (contains(item)) {
            mySet = mySet; //This does nothing
        }
        else {
            newArray = new Comparable[setLength + 1];
            for (int i = 0; i < setLength; i++) {
                newArray[i] = mySet[i];
            }
            newArray[setLength] = item;
            Arrays.sort(newArray);
            mySet = newArray;
        }
    }

    @Override
    public boolean contains(T item) {
        int low = 0;
        int high = mySet.length - 1;
        while (low <= high) {
            int middle = low + ((high - low) / 2);
            if (mySet[middle].compareTo(item) < 0) {
                low = middle + 1;
            } else if (mySet[middle].compareTo(item) > 0) {
                high = middle - 1;
            } else if (mySet[middle].compareTo(item) == 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return mySet.length;
    }

    @Override
    public ArrayList<T> toOrderedList() {
        ArrayList<T> arrayList = new ArrayList<>();
        T item;
        for (int i = 0; i < mySet.length; i++) {
            arrayList.add((T) mySet[i]);
        }
        return arrayList;
    }

    @Override
    public Set<T> union(Set<T> otherSet) {
        Set<T> unionOfSets = new ListSet();
        ArrayList<T> otherSetArray = otherSet.toOrderedList();

        for (int i = 0; i < mySet.length; i++) {
            unionOfSets.add((T) mySet[i]);
        }
        for (int i = 0; i < otherSetArray.size(); i++) {
            unionOfSets.add(otherSetArray.get(i));
        }
        return unionOfSets;
    }

    @Override
    public Set<T> intersection(Set<T> otherSet) {
        Set<T> intersectionOfSets = new ListSet();

        for (int i = 0; i < mySet.length; i++) {
            if (otherSet.contains((T) mySet[i])) {
                intersectionOfSets.add((T) mySet[i]);
            }
        }
        return intersectionOfSets;
    }
}
