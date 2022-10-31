package edu.ithaca.dragon.datastructures.set;

import java.util.ArrayList;
import java.util.List;

public class BTNodeUtil{

    public static <T extends Comparable<T>> int nodeCount(BTNode<T> root){
        if(root == null || root.getItem() == null){
            return 0;
        }
        else{
            return nodeCount(root.getLeft()) + nodeCount(root.getRight()) + 1;
        }
    }

    public static <T extends Comparable<T>> boolean contains(BTNode<T> root, T keyToFind){
        if(root == null){
            return false;
        }
        if(root.getItem().equals(keyToFind)){
            return true;
        }
        if(contains(root.getLeft(), keyToFind) == true || contains(root.getRight(), keyToFind)==true){
            return true;
        }
        return false;
        
    }

    public static <T extends Comparable<T>> String preOrderString(BTNode<T> root){
        if (root == null){
            return "";
        }
        else {
            return root.getItem().toString() + ", " + preOrderString(root.getLeft()) + preOrderString(root.getRight()); 
        }
    }

    public static <T extends Comparable<T>> String inOrderString(BTNode<T> root){
        if(root==null){
            return "";
        }
        else{
            return inOrderString(root.getLeft()) + root.getItem().toString() + ", " + inOrderString(root.getRight());
        }
    }

    public static <T extends Comparable<T>> ArrayList<T> inOrderList(BTNode<T> root, ArrayList<T> myList){
        if(root==null){
            return null;
        }
        else{
            inOrderList(root.getLeft(), myList);  
            if(root.getItem() != null){
                myList.add(root.getItem());
            }
            inOrderList(root.getRight(), myList);
        }
        return myList;
    }

    public static <T extends Comparable<T>> String postOrderString(BTNode<T> root){
        if(root==null){
            return "";
        }
        else{
            return postOrderString(root.getLeft()) + postOrderString(root.getRight())  + root.getItem().toString() + ", ";
        }
    }

    public static <T extends Comparable<T>> int height(BTNode<T> root){
        if(root == null){
            return -1;
        }
        else{
            int leftHeight = height(root.getLeft());
            int rightHeight = height(root.getRight());
            if(leftHeight>rightHeight){
                return leftHeight+1;
            }
            else{
                return rightHeight+1;
            }
        }
    }

    public static <T extends Comparable<T>> void balancedAdd(BTNode<T> root, T newKey){
        if (root == null){
            throw new IllegalArgumentException("Can't add to a non-existant root");
        }
        else {
            if (root.getLeft() == null){
                root.setLeft(new BTNode<>(newKey));
            }
            else if (root.getRight() == null){
                root.setRight(new BTNode<>(newKey));
            }
            else {
                if (height(root.getLeft())> height(root.getRight())){
                    balancedAdd(root.getRight(), newKey);
                }
                else {
                    balancedAdd(root.getLeft(), newKey);
                }
            }
        }
    }
    
}

