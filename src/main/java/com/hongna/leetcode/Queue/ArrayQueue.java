package com.hongna.leetcode.Queue;

import com.hongna.leetcode.Array.Array;

public class ArrayQueue<E> implements  Queue<E> {

    public Array<E> array;


    public ArrayQueue(){
        array = new Array<E>();
    }

    public ArrayQueue(int capacity){
        array = new Array<E>(capacity);
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }


    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d ,capacity = %s\n", array.getSize(),this.array.getCapacity()));
        res.append("front:[");
        for (int i =0 ;i< array.getSize() ; i++){
            res.append(array.get(i));
            if (i != array.getSize()-1){
                res.append(",");
            }
        }
        res.append("]");
        return res.toString();
    }

    public static void main(String[] args) {
        ArrayQueue<Object> queue = new ArrayQueue<>();
        for (int i = 0; i<10;i++){
            queue.enqueue(i);
        }
        System.out.println(queue);
        queue.dequeue();
        System.out.println(queue);
    }
}
