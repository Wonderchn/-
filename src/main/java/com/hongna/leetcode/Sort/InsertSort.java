package com.hongna.leetcode.Sort;

import com.hongna.leetcode.util.ArrayGenerator;
import com.hongna.leetcode.util.SortingHelper;

public class InsertSort {
    public InsertSort(){};

    public static <E extends Comparable<E>> void sort(E[] arr){
        for (int i = 0 ; i < arr.length ; i++){
            //把arr[i]插入到适合的位置

            //循环不变量是 arr[0,i)已经排序
            //循环体是 swap(arr, j, j-1);
//            for (int j =i ; i-1 >= 0; i--){
//                if ( arr[j].compareTo(arr[j-1]) <0){
//                    swap(arr, j, j-1);
//                }
//                else break;
//            }
            for (int j = i ; j-1 >= 0 && arr[j].compareTo(arr[j-1]) <0; j--){
                swap(arr, j, j-1);
            }


        }
    }
    public static <E extends Comparable<E>> void sort2(E[] arr){
        for (int i = 0 ; i < arr.length ; i++){
            //将arr[i]插入到合适的位置
            E t = arr[i];
            int j ;
            for (j= i; j-1 >=0 && t.compareTo(arr[j-1])<0 ; j--){
                arr[j] = arr[j-1];
            }
            arr[j] = t;
        }

    }

    private static <E> void swap(E[] arr , int i ,int j){
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int[] dataSize = {10000,100000};
        for (int n : dataSize){
            Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
            SortingHelper.sortTest("InsertionSort", arr);
        }
    }

}
