package com.hongna.leetcode.Array;

public class Main {
    public static void main(String[] args) {
        Array arr = new Array(20);
        for (int i = 0 ; i<10;i++){
            arr.addLast(i);
        }
        System.out.println(arr);

        arr.add(1,100);
        System.out.println(arr);

        arr.addFirst(20);
        System.out.println(arr);

        int i = arr.get(0);
        System.out.println(i);

        arr.set(0, 10);
        System.out.println(arr);
    }
}
