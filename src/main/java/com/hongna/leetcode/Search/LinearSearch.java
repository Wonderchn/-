package com.hongna.leetcode.Search;

import com.hongna.leetcode.util.ArrayGenerator;

public class LinearSearch {

    public static <E> int search(E[] data, E target){
        for (int i = 0 ; i < data.length ; i++){
            if (data[i] .equals(target)){
                return  i ;
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        //泛型不能使用基本类型，只能使用对象类型
//        int result = search(new Integer[]{1, 2, 3, 4, 5}, 2);
//        System.out.println(result);
//
//
//
//        Student[] arr = new Student[]{new Student("dj"),new Student("xiaobi")};
//        int number = LinearSearch.search(arr, new Student("dj"));
//        System.out.println(number);
        int[] datasize = {100000,1000000};
        for (int n : datasize){
            Integer[] data = ArrayGenerator.generateOrderedArray(n);
            long startTime = System.nanoTime();
            int res2 = LinearSearch.search(data, 666);
            long endTime = System.nanoTime();
            double time = (endTime - startTime) / 1000000000.0;
            System.out.println(" n = " + n + ", 100 runs :" + time +" s");

        }
    }
}
