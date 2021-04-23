package com.hongna.leetcode.List;

/**
 * 使用递归实现 链表的增删改查
 */
public class LinkedList2<E> {
    public class  Node{
        private E e;
        private Node next;

        public Node(){
            this(null,null);
        }
        public Node(E e,Node next){
            this.e = e;
            this.next = next;

        }
        public Node(E e){
            this(e,null);

        }
        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node head;
    private int size;



    //获取链表中的元素个数
    public int getSize(){
        return size;
    }

    //返回链表是否为空
    public boolean isEmpty(){
        return size ==0;

    }

    //指定位置添加元素
    private void add(int index , E e){

    }

    //使用递归 实现链表的插入元素实现
    //基本问题，在Index位置上插入e元素
    private void add(Node head,int index,E e){
        if (head ==null){
            return;
        }

        add(head, index-1, e);


    }
}
