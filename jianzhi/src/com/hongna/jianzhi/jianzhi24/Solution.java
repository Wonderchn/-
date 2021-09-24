package com.hongna.jianzhi.jianzhi24;

class Solution {
    //反转链表
    //假设我们处理的节点后面的链表是已经被反转过得
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
