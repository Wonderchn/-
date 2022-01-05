package com.hongna.array;//给定两个数组，编写一个函数来计算它们的交集。
//
//
//
// 示例 1：
//
// 输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2]
//
//
// 示例 2：
//
// 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[9,4]
//
//
//
// 说明：
//
//
// 输出结果中的每个元素一定是唯一的。
// 我们可以不考虑输出结果的顺序。
//
// Related Topics 数组 哈希表 双指针 二分查找 排序 👍 462 👎 0


import java.util.HashSet;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution349 {

    public int[] intersection(int[] nums1, int[] nums2) {
        //我们使用Set进行数组的便利
        HashSet<Integer> integers1 = new HashSet<Integer>();
        HashSet<Integer> integers2 = new HashSet<Integer>();
        for (int a :
                nums1) {
            integers1.add(a);
        }
        for (int b:
                nums2) {
            integers2.add(b);
        }
        return  compareAndReturnResult(integers1, integers2);
    }


    //比较两个Set的大小，并通过这个set进行输出
    public int[] compareAndReturnResult(Set<Integer> set1 ,Set<Integer> set2){
        if (set1.size() < set2.size()){
            compareAndReturnResult(set2, set1);
        }
        HashSet<Integer> hashSet = new HashSet<Integer>();
        for (int i : set1){
            if (set2.contains(i)){
                hashSet.add(i);
            }
        }
        int[] array = new int[hashSet.size()];
        int index = 0;
        for (int num : hashSet){
            array[index++] = num;
        }
        return  array;

    }



}
//leetcode submit region end(Prohibit modification and deletion)
