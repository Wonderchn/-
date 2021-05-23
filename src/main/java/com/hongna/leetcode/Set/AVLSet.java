package com.hongna.leetcode.Set;

public class AVLSet<E extends  Comparable<E>> implements Set<E> {
    //这里我们使用的set 是不需要value值的，我们这里设置value的泛型为object，
    // 我们就可以在对值需要进行操控的时候传入object值
    private AVLTree<E ,Object> avl;

    public  AVLSet(){
        avl = new AVLTree<>();
    }


    @Override
    public int getSize(){
        return avl.getSize();
    }


    @Override
    public boolean isEmpty() {
        return avl.isEmpty();
    }

    @Override
    public void add(E e) {
        avl.add(e, null);
    }

    @Override
    public void remove(E e) {
        avl.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return avl.contains(e);
    }


}
