package com.hongna.leetcode.Queue;


public class LoopQueue<E> implements Queue<E> {
    private E[] data;
    private int front;
    private int tail;
    private int size;


    public LoopQueue(int capacity){
        data = (E[]) new Object[capacity+1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue(){
        this(10);
    }
    public int getcapacity(){
        return data.length -1;
    }


    @Override
    public boolean isEmpty() {
        return front == tail;
    }


    @Override
    public int getSize(){
        return size;
    }


    public void enqueue(E e){
        if ((tail +1)% data.length == front){
            resize(getcapacity() * 2);

        }
        data[tail] = e;
        tail = (tail +1) % data.length;
        size++;

    }

    private void resize(int newCapacity){
        E[] newData =(E[]) new Object[newCapacity+1];
        for (int i = 0; i< size ;i++){
            newData[i] = data[i+front%(data.length)];

        }
        data = newData;
        front = 0;
        tail = size;
    }


    public E dequeue(){
        if (isEmpty()){
            throw new IllegalArgumentException("Cannot dequeue from an empty dequeue");
        }
        E ret = data[front];
        data[front] = null;
        front++;
        size --;
        if (size == getcapacity() /4 && getcapacity() /2 !=0){
            resize(getcapacity()/2);
        }
        return  ret;

    }

    @Override
    public E getFront(){
        if (isEmpty()){
            throw new IllegalArgumentException("queue is empty");
        }
        return  data[front];
    }

    @Override

    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d ,capacity = %s\n", size,getcapacity()));
        res.append("front");
        for (int i =front ;i !=tail ; i= (i+1) %data.length){
            res.append(data[i]);
            if ((i+1) %data.length !=tail){
                res.append(",");
                
            }
        }
        res.append("]");
        return res.toString();
    }
}
