package com.hongna.leetcode.test.Demo206;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }


    //链表
    public ListNode(int[] arr){
        if (arr ==null || arr.length ==0){
            throw new IllegalArgumentException("arr can not be empty");
        }
        this.val = arr[0];
        ListNode cur = this;
        for (int i = 1; i< arr.length ; i++){
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
    }

    //以当前节点为头结点的链表信息字符串
    @Override
    public String toString() {
       StringBuilder res =new StringBuilder();
       ListNode cur = this;
       while (cur !=null){
           res.append(cur.val +"->");
           cur = cur.next;
       }
       res.append("NUll");
       return res.toString();
    }
}