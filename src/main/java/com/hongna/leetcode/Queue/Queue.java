package com.hongna.leetcode.Queue;

public interface Queue<E> {
    //得到队列中元素个数
    int getSize();
    //查看队列是否为空
    boolean isEmpty();
    //添加队列元素
    void enqueue(E e);
    //出队操作
    E dequeue();
    //查看队首
    E getFront();
}
