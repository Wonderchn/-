package com.hongna.leetcode.test.Demo344;

public class Solution {
    public static void reverseString(char[] s) {
        int i = 0 ;
        reverse2(s, i);
    }

    //空间复杂度为o(n)
    public  static  void reverse(char[] s,int index){
        if (s==null ||index>=s.length){
            return;
        }
        reverse(s, index+1);
        System.out.println(s[index]);
    }

    //空间复杂度为o(1)
    public static void reverse2(char[]s , int index){
        int len = s.length;
        if (index >= len / 2){
            return;
        }
        //将头尾互换
        char temp = s[index];
        s[index] = s[len - index -1];
        s[len - index - 1] = temp;
        reverse2(s, index+1);
    }




    public static void main(String[] args) {
        char[] data = new char[]{'0','s','2','s','6'};
        Solution.reverseString(data);
        System.out.println(data);

    }
}
