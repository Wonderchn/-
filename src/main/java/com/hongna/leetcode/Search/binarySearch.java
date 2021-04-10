package com.hongna.leetcode.Search;

public class binarySearch {

    public int binarySearch(int []datasource,int searchNumber){
        int left = 0 ;
        int right = datasource.length -1;
        while (left <= right){
            int mid = (right + left)/2;
            if (datasource[mid] == searchNumber){
                return mid;
            }
            else if (searchNumber < datasource[mid] ){
                right = mid - 1;
            }
            else if (searchNumber > datasource[mid]){
                left = mid + 1;
            }
        }
        return -1;
    }
}
