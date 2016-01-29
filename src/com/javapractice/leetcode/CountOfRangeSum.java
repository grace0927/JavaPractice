/**
 * 
 */
package com.javapractice.leetcode;

/**
 * @author Feng
 * https://leetcode.com/problems/count-of-range-sum/
 * Given an integer array nums, return the number of range sums 
 * that lie in [lower, upper] inclusive.
 * Range sum S(i, j) is defined as the sum of the elements in nums 
 * between indices i and j (i ≤ j), inclusive.
 * Note:
 * A naive algorithm of O(n2) is trivial. You MUST do better than that.
 * Example:
 * Given nums = [-2, 5, -1], lower = -2, upper = 2,
 * Return 3.
 * The three ranges are : [0, 0], [2, 2], [0, 2] and their respective sums are: -2, -1, 2.
 *
 */
public class CountOfRangeSum {
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
    
    public int countRangeSum(int[] nums, int lower, int upper) {
        long[] sums = new long[nums.length+1];
        for(int i=0; i<nums.length; i++) {
            sums[i+1] = sums[i]+nums[i];
        }
        
        return countMergeSort(sums, 0, nums.length+1, lower, upper);
    }
    
    // use divide and conquer, most important part is merging idea
    private int countMergeSort(long[] sums, int start, int end, int lower, int upper) {
        if(end<=start+1) {
            return 0;
        }
        int mid = start + (end-start)/2;
        int cnt = countMergeSort(sums, start, mid, lower, upper) + 
        		countMergeSort(sums, mid, end, lower, upper);
        
        long[] cache = new long[end-start];
        int left = mid, right = mid, pnt = mid, cpnt = 0;
        
        for(int i=start; i<mid; i++) {
            while(right<end && sums[right]-sums[i]<=upper) {
                right++;
            }
            while(left<end && sums[left]-sums[i]<lower) {
                left++;
            }
            while(pnt<end && sums[i]>sums[pnt]) {
                cache[cpnt++] = sums[pnt++];
            }
            cache[cpnt++] = sums[i];
            cnt += (right-left);
        }
        while(cpnt<end-start) {
            cache[cpnt++] = sums[pnt++];
        }
        for(int i=start; i<end; i++) {
            sums[i] = cache[i-start];
        }
        
        return cnt;
    }
}
