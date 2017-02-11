/**
 * 
 */
package com.javapractice.leetcode;

import java.util.Arrays;

/**
 * @author jianyu
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * For example,
 * Given [3,2,1,5,6,4] and k = 2, return 5.
 * Note: 
 * You may assume k is always valid, 1 ¡Ü k ¡Ü array's length.
 *
 */
public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }
}
