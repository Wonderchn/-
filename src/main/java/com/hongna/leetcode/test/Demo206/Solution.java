package com.hongna.leetcode.test.Demo206;

public class Solution {
    public  static  ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur !=null){
            ListNode next = cur .next;
            prev = cur;
            cur = next;
        }
        return prev;

    }


    public static ListNode reverseList2(ListNode head){
        if (head == null|| head.next ==null){
            return head;
        }
        ListNode nextNode = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return nextNode;
    }


    public static void main(String[] args) {
        ListNode listNode = new ListNode(new int[]{10, 9, 8, 7});
        ListNode node1 = reverseList2(listNode);
        System.out.println(node1);
    }
}
