package com.hongna.leetcode.Array;

import com.hongna.leetcode.Heap.MaxHeap.MaxHeap;

import java.util.Random;

public class Main {
    private static double testHeap(Integer[] testData, boolean isHeapify){
        long startTime = System.nanoTime();
        MaxHeap<Integer> maxHeap;
        if (isHeapify){
            maxHeap =  new MaxHeap<>(testData);
        }else {
            maxHeap = new MaxHeap<>();
            for (int num : testData){
                maxHeap.add(num);
            }
        }

        int[] arr = new int[testData.length];
        for (int i = 0 ; i < testData.length; i++){
            arr[i] = maxHeap.extractMax() ;
        }
        for (int i = 1 ; i < testData.length; i++){
            if (arr[i-1] < arr[i]){
                throw new IllegalArgumentException("Error");
            }
        }
        System.out.println("Test MaxHeap completed");
        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;

    }

    public static void main(String[] args) {
//        Array arr = new Array(20);
//        for (int i = 0 ; i<10;i++){
//            arr.addLast(i);
//        }
//        System.out.println(arr);
//
//        arr.add(1,100);
//        System.out.println(arr);
//
//        arr.addFirst(20);
//        System.out.println(arr);
//
//        Integer i = (Integer) arr.get(0);
//        System.out.println(i);
//
//        arr.set(0, 10);
//        System.out.println(arr);

        int n = 1000000;
        Random random = new Random();
        Integer[] testData = new Integer[n];
        for (int i = 0 ; i < n ; i++){
            testData[i] = random.nextInt(Integer.MAX_VALUE);
        }
        double time1 = testHeap(testData, false);

    }
}
