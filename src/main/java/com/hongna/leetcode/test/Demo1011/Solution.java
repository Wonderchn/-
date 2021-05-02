package com.hongna.leetcode.test.Demo1011;


import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5};
        int i = shipWithinDays(arr, 1);
        System.out.println(i);
    }

    public static int shipWithinDays(int[] weights, int D) {
        int l = Arrays.stream(weights).max().getAsInt();
        int r = Arrays.stream(weights).sum();
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (check(weights, mid, D)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return r;

    }

    //k是我们要传入的一艘船的载重量， D是限定的天数
    public static boolean check(int[] weights, int k, int D) {
        int now = 1;
        int cap = 0;
        for (int weight : weights) {
            if (cap + weight > k) {
                now++;
                cap = 0;
            }
            cap += weight;
        }
        return now <= D;
    }

}

