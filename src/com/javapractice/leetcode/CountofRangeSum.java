/**
 * 
 */
package com.javapractice.leetcode;

/**
 * @author Feng
 *
 */
public class CountofRangeSum {
    public int countRangeSumTrivial(int[] nums, int lower, int upper) {
        // O(n^2) trivial
        int[] sums = new int[nums.length];
        int sum = 0;
        int cnt = 0;
        
        for(int i=0; i<nums.length; i++) {
            sum += nums[i];
            sums[i] = sum;
        }
        
        for(int i=0; i<nums.length; i++) {
            for(int j=0; j<i; j++) {
                int sumRange = sums[j]-sums[i];
                if(sumRange>=lower && sumRange<=upper) {
                    cnt++;
                }
            }
        }
        
        return cnt;
    }
}
