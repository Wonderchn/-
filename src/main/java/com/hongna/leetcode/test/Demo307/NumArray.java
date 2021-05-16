package com.hongna.leetcode.test.Demo307;

/**
 * 这种代码并不能解决更新区间的操作
 */
public class NumArray {
    private int[] sum;
    private int[] data;

    public NumArray(int[] nums ){
        data = new int[nums.length];
        for (int i = 0 ; i < nums.length; i++){
            data[i] = nums[i];
        }
        sum = new int[nums.length +1];
        sum[0] = 0;
        for (int i = 1 ; i < sum.length ; i++){
            sum[i] = sum[i -1] + nums[i - 1];
        }
    }

    public void update(int index , int val){
        data[index] = val ;
        for (int i = index +1 ; i < sum.length ; i++){
            sum[i] = sum[i -1] +data[i -1];
        }
    }

    public int sumRange(int i , int j){
        return sum[j +1] - sum[i];
    }
}
