package com.hongna.leetcode.Array;


public class Array<E> {
    private E[] data;
    private int size;

    //构造函数,传入数组容量capacity构造Array
    public Array(int capacity) {
        this.data = (E[]) new Object[capacity];
        this.size = 0;
    }

    //无参数的构造函数
    public Array() {
        this(10);
    }

    //获取数组中的元素个数
    public int getSize() {
        return size;

    }

    //获取数组中的容量
    public int getCapacity() {
        return this.data.length;
    }

    //提供方法，查询数组是否为空
    public boolean isEmpty() {
        return this.size == 0;
    }

    //向所有元素后面添加一个新元素
    public void addLast(E e) {
        add(size, e);
    }

    public void addFirst(E e){
        add(0, e);
    }

    //向指定位置插入一个元素
    public void add(int index , E e){
        if (index <0 || index >size){
            throw new IllegalArgumentException("Add failed");
        }
        if (size == data.length){
            throw new IllegalArgumentException("Add failed");
        }
        for (int i = size-1 ; i>=index ; i--){
            data[i+1] = data[i];
        }
        data[index] = e;
        size ++;
    }

    //获取index索引位置的元素
    E get(int index){
        if (index < 0 || index > size){
            throw new IllegalArgumentException("Get failed ,Index is illegal");
        }
        return data[index];
    }
    //修改index索引位置的元素
    void set(int index,E e){
        if (index < 0 || index >=size){
            throw new IllegalArgumentException("Get failed.Index is illegal");
        }
        data[index] = e;
    }

    //查看数组中是否包含元素e
    public boolean contains(E e){
        for (int i = 0 ; i < size ;i ++){
            if (data[i] .equals(e)){
                return true;
            }
        }
        return false;
    }


    //查找数组中元素e所在的索引，如果不04存在元素e 则返回-1；
    public int find(int e){
        for (int i = 0 ; i < data.length ; i++){
            if (data[i] .equals(e)){
                return i;
            }
        }
        return  -1;
    }

    //从数组中删除Index位置的元素，返回删除的元素
    public E remove(int index){
        if (index < 0 || index >=size){
            throw  new IllegalArgumentException("Remove failed");
        }
        E ret = data[index];
        for (int i = index+1 ;i < size ;i++){
            data[i-1]  = data[i];
        }
        size--;
        return  ret;

    }

    //从数组中删除第一个元素，返回删除的元素
    public E removeFirst(){
        return remove(0);
    }

    public E removeLast(){
        return remove(size-1);
    }


    //从数组中删除元素e
    public void removeElement(int e){
        int index = find(e);
        if (index != -1){
            remove(index);
        }
    }


    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d ,capacity = %s\n", size,this.data.length));
        res.append("[");
        for (int i =0 ;i< size ; i++){
            res.append(data[i]);
            if (i != size-1){
                res.append(",");
            }
        }
        res.append("]");
        return res.toString();
    }
}

