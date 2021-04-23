package com.hongna.leetcode.Sort;

import java.util.Arrays;

public class MergeSort{
    private MergeSort(){

    }

    private static <E extends Comparable<E>> void sort(E[]arr){
        sort(arr, 0, arr.length-1);
    }
    private static <E extends Comparable<E>> void sort(E[]arr,int l,int r){
        if (l >= r){
            return;
        }
        int mid = l +(r-l)/2;
        sort(arr,l,mid);
        sort(arr, mid+1, r);
        merge(arr, l, mid, r);
        

    }

    /**
     * 对于归并排序进行优化
     * @param arr
     * @param <E>
     */
    private static <E extends Comparable<E>> void sort2(E[]arr){
        sort(arr, 0, arr.length-1);
    }
    private static <E extends Comparable<E>> void sort2(E[]arr,int l,int r){
        if (l >= r){
            return;
        }
        int mid = l +(r-l)/2;
        sort(arr,l,mid);
        sort(arr, mid+1, r);
        if (arr[mid].compareTo(arr[mid +1]) >0){
            merge(arr, l, mid, r);
        }



    }
    private static<E extends Comparable> void  merge(E[] arr, int l, int mid, int r){
        E[] temp = Arrays.copyOfRange(arr, l, r+1);
        //初始化，i指向左半部分的启示索引位置l，i指向右半部分起始索引位置Mid+1

        int i = l, j = mid +1 ;
        // 每轮循环为arr[k]赋值
        for (int k = l ; k <= r ; k++){
            if (i > mid){
                arr[k] = temp[j - l ];
                j++;
            }
            else if (j > r){
                arr[k] = temp[i - l];
                i++;
            }
            else if (temp[i -l].compareTo(temp[j-l])>=0){
                arr[k] = temp[j-l] ;
                i++;
            }
            else{
                arr[k] = temp[j-l];
                j++;
            }
        }

    }

}
