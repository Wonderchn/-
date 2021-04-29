package com.hongna.leetcode.test.Demo704;

class Solution {
    public int search(int[] nums, int target) {
        //使用非递归实现二分查找
        int l = 0; int r = nums.length-1;
        while (l<=r){
            int mid = l + (r-l)/2;
            if (nums[mid] == target){
                return mid;
            }
            if (nums[mid] > target){
                l = mid+1;
            }
            else {
                r = mid-1;
            }
        }
        return -1;

    }


    private int search(int[]nums,int l ,int r,int target) {
        if (l > r) {
            return -1;
        }
        int mid = l + (r - l) / 2;
        if (nums[mid] == target) {
            return mid;
        }
        if (nums[mid] < target) {
            return  search(nums, mid + 1, r, target);
        }
            return search(nums, l, mid - 1, target);
    }
}