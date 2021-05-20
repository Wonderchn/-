package com.hongna.leetcode.UnionFind;

/**
 * 并查集接口
 *
 */
public interface UF {
    //查看元素数量
    int getSize();
    //看是否链接
    boolean isConnected(int p, int q);
    //合并
    void unionElements(int p , int q);
}
