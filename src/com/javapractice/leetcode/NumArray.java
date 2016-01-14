/**
 * 
 */
package com.javapractice.leetcode;

import java.util.HashMap;

/**
 * @author Feng
 * https://leetcode.com/problems/range-sum-query-immutable/
 * Given an integer array nums, 
 * find the sum of the elements between indices i and j (i ≤ j), inclusive.
 * Example:
 * Given nums = [-2, 0, 3, -5, 2, -1]
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 * Note:
 * You may assume that the array does not change.
 * There are many calls to sumRange function.
 *
 */
public class NumArray {
    private HashMap<Integer, Integer> sums;

    public NumArray(int[] nums) {
        sums = new HashMap<>();
        sums.put(-1, 0);
        
        for(int i=0; i<nums.length; i++) {
            sums.put(i, sums.get(i-1)+nums[i]);
        }
    }

    public int sumRange(int i, int j) {
        return sums.get(j) - sums.get(i-1);
    }
}
