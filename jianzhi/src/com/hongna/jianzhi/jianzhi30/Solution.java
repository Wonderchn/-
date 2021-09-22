package com.hongna.jianzhi.jianzhi30;

import java.util.Stack;

/**
 * 这题的思路是维护一个辅助栈
 * 当我们每次新加一个元素的时候
 */
public class Solution {
    class MinStack {
        Stack<Integer> A, B;
        public MinStack() {
            A = new Stack<>();
            B = new Stack<>();
        }
        public void push(int x) {
            A.add(x);
            if(B.empty() || B.peek() >= x)
                B.add(x);
        }
        public void pop() {
            if(A.pop().equals(B.peek()))
                B.pop();
        }
        public int top() {
            return A.peek();
        }
        public int min() {
            return B.peek();
        }
    }
}
