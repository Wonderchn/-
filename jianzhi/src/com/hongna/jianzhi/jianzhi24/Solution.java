package com.hongna.jianzhi.jianzhi24;

class Solution {
    //反转链表
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur !=null){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev ;
    }
}
