/**
 * 
 */
package com.javapractice.leetcode;

import java.util.Arrays;

/**
 * @author Feng
 * https://leetcode.com/problems/wiggle-sort-ii/
 * Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....
 * Example:
 * (1) Given nums = [1, 5, 1, 1, 6, 4], one possible answer is [1, 4, 1, 5, 1, 6].
 * (2) Given nums = [1, 3, 2, 2, 3, 1], one possible answer is [2, 3, 1, 3, 1, 2].
 * Note:
 * You may assume all input has valid answer.
 * Follow Up:
 * Can you do it in O(n) time and/or in-place with O(1) extra space?
 *
 */
public class WiggleSortII {
    public void wiggleSort(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        int[] copy = Arrays.copyOf(nums, len);
        int odd = (len+1)/2-1;
        int even = len-1;
        for (int i=0;i<len;i++)
            nums[i] = i%2==0?copy[odd-i/2]:copy[even-i/2];
    }
}
