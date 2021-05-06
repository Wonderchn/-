package com.hongna.leetcode.Set;

import com.hongna.leetcode.Tree.BinarySearchTree.BST;

public class BSTSet<E extends Comparable<E>> implements Set<E> {
    private BST<E> bst ;

    public BSTSet(){
        bst = new BST<>();
    }

    @Override
    public int getSize() {
        return bst.size();
    }



    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }

    @Override
    public void add(E  e){
        bst.add(e);
    }

    @Override
    public void remove(E e) {

    }


    @Override
    public boolean contains(E e) {
        return bst.contains(e);

    }
}
