package com.hongna.leetcode.UnionFind;

public class UoionFind6 implements UF{
    private int[] parent;
    private int[] rank; // rank[i]表示以i为根的集合所表示的树的层数
    public UoionFind6(int size) {
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 1;


        }
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    //find 返回当前节点的父节点
    //P节点和p节点之上的节点都直接指向根节点
    private int find(int p) {
        if (p < 0 && p >= parent.length) {
            throw new IllegalArgumentException("p is out of bound");
        }
        if (p != parent[p]){
            //
           parent[p] = find(parent[p]);
        }
        return parent[p];

    }


    @Override
    public boolean isConnected(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        return pRoot == qRoot;
    }

    @Override
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        }
      if (rank[pRoot] < rank[qRoot]){
          parent[pRoot] = qRoot;
      }
      else if (rank[qRoot] < rank[pRoot]){
          parent[qRoot] = pRoot;

      }
        else{
            //rank[qRppt] == rank[Proot]
            parent[qRoot] = pRoot;
            rank[pRoot] += 1;


        }

    }


}
