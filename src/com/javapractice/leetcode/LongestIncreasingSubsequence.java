/**
 * 
 */
package com.javapractice.leetcode;

/**
 * @author Feng
 * https://leetcode.com/problems/longest-increasing-subsequence/
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 * For example,
 * Given [10, 9, 2, 5, 3, 7, 101, 18],
 * The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. 
 * Note that there may be more than one LIS combination, 
 * it is only necessary for you to return the length.
 * Your algorithm should run in O(n2) complexity.
 * Follow up: Could you improve it to O(n log n) time complexity?
 *
 */
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if(len<=0) {
            return 0;
        }
        int[] lis = new int[len];
        
        for(int i=len-1; i>=0; i--) {
            lis[i] = 1;
            for(int j=i; j<len; j++) {
                int tmp = (nums[j]>nums[i])?lis[j]+1:1;
                lis[i] = Math.max(lis[i], tmp);
            }
        }
        
        for(int i=1; i<len; i++) {
            lis[i] = Math.max(lis[i], lis[i-1]);
        }
        
        return lis[len-1];
    }
    
    /*
     * n log n 
     * ref:http://www.geeksforgeeks.org/longest-monotonically-increasing-subsequence-size-n-log-n/
     */
    public int lengthOfLISFaster(int[] nums) {
        int len = nums.length;
        if(len<=0) {
            return 0;
        }
        int[] lis = new int[len];
        lis[0] = nums[0];
        int cnt = 1;
        
        for(int i=1; i<len; i++) {
            int idx = binarySearch(lis, 0, cnt-1, nums[i]);
            lis[idx] = nums[i];
            if(idx==cnt) {
                cnt++;
            }
        }
        
        return cnt;
    }
    
    public int binarySearch(int[] lis, int start, int end, int key) {
        if(key < lis[start]) {
            return start;
        } else if(key > lis[end]) {
            return end+1;
        } else {
            while(start < end-1) {
                int mid = start + (end-start)/2;
                if(lis[mid] >= key) {
                    end = mid;
                } else {
                    start = mid;
                }
            }
        }
        return end;
    }
}
