package com.hongna.leetcode.Sort;

import java.util.Arrays;

public class MergeSort{
    private MergeSort(){

    }

    /**
     * 对于归并排序进行优化
     * 如果前一个数组的最后一个值小于后一个数组的首值，那么默认这两个数组是有序的 不用排序
     * @param arr
     * @param <E>
     */
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
        if (arr[mid].compareTo(arr[mid +1]) >0){
            merge(arr, l, mid, r);
        }
    }


    private static <E extends Comparable<E>> void SortBn(E[]arr){
        //自底向上的归并排序
        E[]temp = Arrays.copyOf(arr, arr.length);
        int n = temp.length;
        //假设我们是要合并一个长度为4的数组，那么这里就是指代分别长度为2的数组
        for (int sz = 1; sz< n ;sz += sz){
            //遍历合并的两个区间
            //合并[i,i+sz-1] 和 [i+sz,i+sz+sz-1]
            for (int i = 0; i+sz < n ; i += sz+sz) {
                if (arr[i + sz -1].compareTo(arr[i +sz]) > 0){
                    if (arr[i + sz -1].compareTo(arr[i+sz])>0){
                        merge2(arr, arr.length, i+sz-1, Math.min(i+sz+sz-1, n-1),temp);
                    }
                }
            }
        }
    }


    private static <E extends Comparable<E>> void sort2(E[]arr){
        E[] temp = Arrays.copyOf(arr, arr.length);

        sort2(arr, 0, arr.length-1,temp);
    }
    private static <E extends Comparable<E>> void sort2(E[]arr,int l,int r,E[] temp){
        if (l >= r){
            return;
        }
        int mid = l +(r-l)/2;
        sort(arr,l,mid);
        sort(arr, mid+1, r);
        if (arr[mid].compareTo(arr[mid +1]) >0){
            merge2(arr, l, mid, r, temp);
        }
    }




    private static<E extends Comparable> void  merge(E[] arr, int l, int mid, int r){
        E[] temp = Arrays.copyOfRange(arr, l, r+1);
        //初始化，i指向左半部分的启示索引位置l，i指向右半部分起始索引位置Mid+1

        int i = l, j =    mid +1 ;
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

    private static<E extends Comparable> void  merge2(E[] arr, int l, int mid, int r,E[]temp){
        //初始化，i指向左半部分的启示索引位置l，i指向右半部分起始索引位置Mid+1

        int i = l, j =    mid +1 ;
        // 每轮循环为arr[k]赋值
        for (int k = l ; k <= r ; k++){
            if (i > mid){
                arr[k] = temp[j  ];
                j++;
            }
            else if (j > r){
                arr[k] = temp[i ];
                i++;
            }
            else if (temp[i].compareTo(temp[j])>=0){
                arr[k] = temp[i] ;
                i++;
            }
            else{
                arr[k] = temp[j];
                j++;
            }
        }

    }




}
