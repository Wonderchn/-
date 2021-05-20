package com.hongna.leetcode.test.Demo677;

import java.util.TreeMap;

public class MapSum {
    private class Node{
        //此处为权重值
        public int value;
        public TreeMap<Character,Node> next;
        public Node(int value){
            this.value = value;
            next = new TreeMap<>();

        }
        public Node(){
            this(0);
        }
    }
    private  Node root;


    /** Initialize your data structure here. */
    public MapSum() {
        root = new Node();
    }

    public void insert(String word, int val) {
        Node cur = root;
        for (int i = 0 ; i <  word.length(); i++){
            char c = word.charAt(i);
            if (cur.next.get(c) == null){
                cur.next.put(c, new Node());
            }
        }
        cur.value = val;
    }
    //找到以prefix为前缀的值
    public int sum(String prefix) {
        Node cur = root;
        for (int i = 0 ; i< prefix.length() ; i++){
            char c = prefix .charAt(i);
            if (cur.next.get(c) == null){
                return 0;
            }
            cur = cur.next.get(c);
        }
        //此时返回的就是以prefix为前缀树，我们返回最后一个元素
        return sum(cur);
    }

    private int sum(Node node){
        if (node.next.size()==0){
            return node.value;
        }
        int res = node.value;
        for (char c :node.next.keySet()){
            res += sum(node.next.get(c));

        }
        return res;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */