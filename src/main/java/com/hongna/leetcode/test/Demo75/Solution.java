package com.hongna.leetcode.test.Demo75;

import java.util.Random;

public class Solution {
    public void sortColors(int[] nums) {
        Sort(nums);
    }
    public static void Sort(int[] arr){
        Random random = new Random();
        Sort(arr,0,arr.length-1,random);
    }
    public static void Sort(int[] arr, int l, int r, Random random){
        if (l>=r){
            return;
        }
        int p = l + random.nextInt(r - l + 1);
        swap(arr, l, p);
        int lt = l , gt = r+1, i=l+1;
        while (i < gt){
            if (arr[i] < arr[l]){
                lt++;
                swap(arr, i, lt);
                i++;
            }
            else if (arr[i] > arr[l]){
                gt--;
                swap(arr, gt,i);
            }
            else {
                i++;
            }
        }
        swap(arr, l, lt);
        //arr [l,lt-1]< v ,arr[lt,gt-1] == v arr[gt,r] >v
        Sort(arr, l, lt-1, random);
        Sort(arr,gt,r,random);
    }



    private static void swap(int[]arr ,int i ,int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;

    }

    public static void main(String[] args) {
        int []arr = new int[]{2,0,2,1,1,0};
        Sort(arr);
        for (int i:arr
        ){
            System.out.println(i);
        }
    }
}