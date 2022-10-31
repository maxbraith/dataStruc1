package edu.ithaca.dragon.datastructures.set;

public class BSTNodeUtil {

    /**
     * @pre root must be a node of a valid binary search tree
     * @pre the BST from root must not already contain item 
     * @post BST from root will be mutatated to contain a new node with the given item
     * @throws IllegalArgumentException if root is null or the BST already contains item
     */
    public static <T extends Comparable<T>> void bstAddTail(BTNode<T> root, T item){
        if(root == null){
            root = new BTNode<T>(item);
        }
        if(item.compareTo(root.getItem()) > 0){
            if(root.getRight() == null){
                root.setRight(new BTNode<T>(item));
            }
            else{
                bstAddTail(root.getRight(), item);
            }
        }
        if(item.compareTo(root.getItem()) < 0){
            if(root.getLeft() == null){
                root.setLeft(new BTNode<T>(item));
            }
            else{
                bstAddTail(root.getLeft(), item);
            }
            
        } 

        
    }

    /**
     * @pre root must be a node of a valid binary search tree, or null
     * @pre the bst from root must not already contain item 
     * @return  the root of a BST which contains a new node the given item
     * @post original BST might be modified to contain a new node with the given item
     * @throws IllegalArgumentException if the bst already contains item
     */
    public static <T extends Comparable<T>> BTNode<T> bstAdd(BTNode<T> root, T item){
        if(root == null || root.getItem() == null){
            return new BTNode<T>(item);
        }
        if(item.compareTo(root.getItem()) > 0){
            if(root.getRight() == null){
                root.setRight(new BTNode<T>(item));
            }
            else{
                root.setRight(bstAdd(root.getRight(), item));
            }
        }
        else if(item.compareTo(root.getItem()) < 0){
            if(root.getLeft() == null){
                root.setLeft(new BTNode<T>(item));
            }
            else{
                root.setLeft(bstAdd(root.getLeft(), item));
            }
            
        } 
        return root;

    }

    /**
     * @pre root must be a node of a valid binary search tree, or null
     * @return true if the item is found in the bst, false otherwise 
     */
    public static <T extends Comparable<T>> boolean bstContains(BTNode<T> root, T item){
        if(root == null){
            return false;
        }
        if(root.getItem().equals(item)){
            return true;
        }
        if(bstContains(root.getLeft(), item) == true || bstContains(root.getRight(), item)==true){
            return true;
        }
        return false;
    }
}

