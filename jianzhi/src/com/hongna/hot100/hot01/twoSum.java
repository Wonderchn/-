package com.hongna.hot100.hot01;

import java.util.HashMap;

class twoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(target - nums[i])){
                return new int[]{hashMap.get(target - nums[i]),i};
            }
            hashMap.put(nums[i],i);

        }
        throw new IllegalArgumentException("No two sum solution");
    }
}