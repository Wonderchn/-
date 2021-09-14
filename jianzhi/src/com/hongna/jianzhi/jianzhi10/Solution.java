package com.hongna.jianzhi.jianzhi10;

class Solution {
    public int fib(int n) {
       if (n<2){
           return n;
       }
       long[] result = new long[n+1];
       result[0] = 0;
       result[1] = 1;
       for (int i =2 ; i<=n ; i++){
           result[i] = result[i - 1]+result[i-2];
           result[i] %= (Math.pow(10,9))+7;
       }
       return (int)result[n];
    }
}