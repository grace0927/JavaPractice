/**
 * 
 */
package com.javapractice.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Feng
 * https://leetcode.com/problems/count-of-smaller-numbers-after-self/
 * You are given an integer array nums and you have to return a new counts array. 
 * The counts array has the property where counts[i] is 
 * the number of smaller elements to the right of nums[i].
 * Example:
 * Given nums = [5, 2, 6, 1]
 * To the right of 5 there are 2 smaller elements (2 and 1).
 * To the right of 2 there is only 1 smaller element (1).
 * To the right of 6 there is 1 smaller element (1).
 * To the right of 1 there is 0 smaller element.
 * Return the array [2, 1, 1, 0].
 *
 */
public class CountOfSmallerNumbersAfterSelf implements Solution {
	public void test() {
		CountOfSmallerNumbersAfterSelf test = new CountOfSmallerNumbersAfterSelf();
    	int[] nums = {1,0,2};
    	System.out.println(test.countSmaller(nums));
	}
	
    public List<Integer> countSmaller(int[] nums) {
        int len = nums.length;
        List<Integer> list = new ArrayList<>();
        int[] sort = new int[len];
        for(int i=0; i<len; i++) {
            list.add(0);
            sort[i] = nums[i];
        }
        helper(nums, list, 0, len, sort);
        return list;
    }
    
    public void helper(int[] nums, List<Integer> list, int start, int end, int[] sort) {
        if(end<=start+1) {
            return ;
        }
        int mid = start+(end-start)/2;
        helper(nums, list, start, mid, sort);
        helper(nums, list, mid, end, sort);
        
        for(int i=start; i<mid; i++) {
            int right=mid;
            while(right<end && nums[i]>sort[right]) {
                right++;
            }
            list.set(i, list.get(i)+right-mid);
        }
        
        int right=mid, cpnt=0;
        int[] cache = new int[end-start];
        for(int i=start; i<mid; i++) {
            while(right<end && sort[i]>sort[right]) {
                cache[cpnt++] = sort[right++];
            }
            cache[cpnt++] = sort[i];
        }
        for(int i=cpnt; i<cache.length; i++) {
        	cache[cpnt++] = sort[right++];
        }
        for(int i=0; i<cache.length; i++) {
            sort[start+i] = cache[i];
        }
    }
}
