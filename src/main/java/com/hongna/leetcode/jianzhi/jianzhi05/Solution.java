package com.hongna.leetcode.jianzhi.jianzhi05;

class Solution {
    public String replaceSpace(String s) {
        StringBuffer sb = new StringBuffer();
        for (int index=0;index<s.length();index++){
            if (s.charAt(index)!=' '){
                sb.append(s.charAt(index));
            }else {
                sb.append("%20");
            }
        }
        return sb.toString();
    }

}