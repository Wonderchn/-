package com.hongna.leetcode.test.Demo203;

public class Solution3 {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null){
            return  null;
    }
        ListNode nextNode = removeElements(head.next, val);
        if (head.val == val){
            return nextNode;
        }
        else {
            head.next = nextNode;
            return head;

        }
    }
    public static void main(String[] args) {
        int[] nums = {1,2,6};
        ListNode head = new ListNode(nums);
        System.out.println(head);
        ListNode res = new Solution3().removeElements(head, 6);
        System.out.println(res);
    }
}
