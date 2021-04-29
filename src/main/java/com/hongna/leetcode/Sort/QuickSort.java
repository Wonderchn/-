package com.hongna.leetcode.Sort;

import com.hongna.leetcode.util.SortingHelper;

import java.util.Random;

public class QuickSort {
    private QuickSort(){}
    public static <E extends Comparable<E>> void sort(E[]arr){
        Random rad = new Random();
        sort(arr, 0, arr.length-1,rad);
    }

    /**
     *
     * @param arr 指的是arr数组
     * @param l 指的是左边界
     * @param r 指的是右边界
     * @param rad 指的是随机数
     * @param <E>
     */
    private static <E extends Comparable<E>> void sort(E[] arr,int l ,int r ,Random rad ){

        if (l >= r)return;
        int p = partition(arr, l, r,rad);
        sort(arr,l,p-1,rad);
        sort(arr,p+1,r,rad);
        for (E x : arr){
            System.out.print(x);
        }
    }


    public static <E extends Comparable<E>> void sort2Ways(E[]arr){
        Random rad = new Random();
        sort2Ways(arr, 0, arr.length-1,rad);
    }
    private static <E extends Comparable<E>> void sort2Ways(E[] arr,int l ,int r ,Random rad ){

        if (l >= r)return;
        int p = partition2(arr, l, r,rad);
        sort2Ways(arr,l,p-1,rad);
        sort2Ways(arr,p+1,r,rad);
        for (E x : arr){
            System.out.print(x);
        }
    }


    private static <E extends Comparable<E>> int partition(E[]arr , int l ,int r ,Random rad) {
        //生成[l,r]之间的随机索引
        int p = l + rad.nextInt(r - l + 1);
        swap(arr, l, p);


        //在对同一数组操作下
        //arr[l+1...j] < v ; arr[j+1 ..i] >= v
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (arr[i].compareTo(arr[l]) < 0) {
                j++;
                swap(arr, i, j);
            }
        }
        swap(arr, l, j);
        return j;
    }
    private static <E extends Comparable<E>> int partition2(E[]arr , int l ,int r ,Random rad) {
        //生成[l,r]之间的随机索引
        int p = l + rad.nextInt(r - l + 1);
        swap(arr, l, p);
        // arr[l + ...i-1] <=v arr[j+1 ...r ]>=v
        int i  = l+1, j =r;
        while(true){
            //arr[l] 指的是数组的标定值
            while (i <=j && arr[i].compareTo(arr[l])<0){
                i++;
            }
            while (j>=i && arr[j].compareTo(arr[l]) >0 ){
                j--;
            }
            if (i >= j) break;
            swap(arr, i, j);
            i++;
            j--;
        }
        swap(arr, l, j);
        return j;

    }




    private static <E> void swap(E[]arr ,int i ,int j){
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;

    }


    public static void main(String[] args) {
//        Integer[] integers = new Integer[]{1,0,2};
//        for (int i = 0; i < integers.length; i++) {
//            System.out.print("-"+integers[i]);
//        }
//
//        SortingHelper.sortTest("QuickSort",integers);

            Integer[]  arr= new Integer[]{2,0,2,1,1,0};

            sort3Ways(arr);
        for (int i :
                arr) {
            System.out.println(i);
        }
    }



    public static <E extends Comparable<E>> void sort3Ways(E[]arr){
        Random rad = new Random();
        sort3Ways(arr, 0, arr.length-1,rad);
    }
    private static <E extends Comparable<E>> void sort3Ways(E[] arr,int l ,int r ,Random rad ){

        if (l >= r)return;
       // 生成[l,r]之间的随机索引
        int p = l + rad.nextInt(r - l + 1);
        swap(arr, l, p);


        //arr[l+1, lt] <v ,arr[lt+1, i-1] == v ,arr[gt,r] >v
        int lt = l,  i = l+1 , gt =r +1;
        while (i < gt){
            if (arr[i] .compareTo(arr[l]) < 0){
                lt ++;
                swap(arr, i, lt);
                i++;
            }
            else if (arr[i] .compareTo(arr[l])>0) {
                gt -- ;
                swap(arr, i, gt);
            }
            else {
                //arr[i] == arr[l]
                i++;
            }
        }
        swap(arr, l, lt);
        //arr [l,lt-1]< v ,arr[lt,gt-1] == v arr[gt,r] >v
        sort3Ways(arr, l, lt-1, rad);
        sort3Ways(arr,gt,r,rad);
    }



}
