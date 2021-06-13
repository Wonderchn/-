package com.hongna.leetcode.Array;

public class Demo {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        Thread thread = new Thread(ticket);
        Thread thread2 = new Thread(ticket);
        Thread thread3 = new Thread(ticket);
        thread.start();
        thread2.start();
        thread3.start();
    }


}
