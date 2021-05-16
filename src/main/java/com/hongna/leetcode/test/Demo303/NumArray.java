package com.hongna.leetcode.test.Demo303;

import com.hongna.leetcode.Tree.SegmentTree.SegmentTree;

public class NumArray {
    private SegmentTree<Integer> segmentTree;
    public NumArray(int[] nums){
        if (nums.length > 0 ){
            Integer[] data = new Integer[nums.length];
            for (int i = 0 ; i < nums.length ; i++){
                data[i] = nums[i];
            }
            segmentTree = new SegmentTree<>(data, (a ,b )-> a+b);
        }
    }
    public int sumRange(int i ,int j ){
        if (segmentTree == null){
            throw new IllegalArgumentException("Segment is null");
        }

        return segmentTree.query(i, j);
    }
}
