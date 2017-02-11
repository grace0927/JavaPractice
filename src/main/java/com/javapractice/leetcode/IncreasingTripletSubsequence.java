/**
 * 
 */
package com.javapractice.leetcode;

/**
 * @author Feng
 * https://leetcode.com/problems/increasing-triplet-subsequence/
 * Given an unsorted array return whether an increasing subsequence of length 3 exists 
 * or not in the array. 
 * Formally the function should:
 * Return true if there exists i, j, k 
 * such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
 * Your algorithm should run in O(n) time complexity and O(1) space complexity.
 * Examples:
 * Given [1, 2, 3, 4, 5],
 * return true.
 * Given [5, 4, 3, 2, 1],
 * return false.
 *
 */
public class IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        int n=nums.length;
        if(n<=2) {
            return false;
        }
        int[] max = new int[n];
        max[n-1] = nums[n-1];
        for(int i=n-2; i>=0; i--) {
            max[i] = Math.max(max[i+1], nums[i]);
        }
        int min = nums[0];
        for(int i=1; i<n-1; i++) {
            if(nums[i]>min && nums[i]<max[i+1]) {
                return true;
            }
            min = Math.min(nums[i], min);
        }
        return false;
    }
    
    // ref: https://leetcode.com/discuss/86891/concise-java-solution-with-comments
    public boolean increasingTripletLessSpace(int[] nums) {
        int n=nums.length;
        int min=Integer.MAX_VALUE, less=Integer.MAX_VALUE;
        for(int i=0; i<n; i++) {
            if(nums[i]<=min) {
                min = nums[i];
            } else if(nums[i]<=less) {
                less = nums[i];
            } else {
                return true;
            }
        }
        return false;
    }
}
