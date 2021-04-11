package com.hongna.leetcode.Search;
import org.junit.Before;
import org.junit.Test;

public class binarySearchTest{
    int [] arr;
    binarySearch binarySearch;
    @Before
    public void test1(){
       arr = new int[]{1,2,3,4};
       binarySearch = new binarySearch();
    }

    @Test
    public void binarySearch(){
        int i = binarySearch.binarySearch(arr, 2);
        System.out.println(i);
    }
}