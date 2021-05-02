package com.hongna.leetcode.test.Demo875;

import java.util.Arrays;

/**
 * 珂珂喜欢吃香蕉。这里有N堆香蕉，第 i 堆中有piles[i]根香蕉。警卫已经离开了，将在H小时后回来。
 *
 * 珂珂可以决定她吃香蕉的速度K（单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 K 根。如果这堆香蕉少于 K 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。  
 *
 * 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
 *
 * 返回她可以在 H 小时内吃掉所有香蕉的最小速度 K（K 为整数）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/koko-eating-bananas
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 个人理解 :
 * 如果piles中，我们现在的数据为[3,6,7,11]
 * 我们每小时能吃1个，那么这里需要 27小时
 * 如果每小时能吃2个，那么这里需要2 +3 + 4 + 6  15小时
 * 很明显，这个小时呈现一个线性结构，我们可以使用二分查找法来实现
 *
 *
 */
public class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1 ; int r = Arrays.stream(piles).max().getAsInt();
        while (l < r){
            int mid = l + (r - l)/2;
            if (eatingTime(piles, mid) <= h){
                r = mid;
            }
            else {
                l = mid +1;
            }
        }
        return l;
    }

    private int eatingTime(int[] piles , int k){
        int res = 0 ;
        for (int pile : piles){
            res += pile / k + (pile % k > 0 ? 1 : 0);

        }
        return res;
    }
}