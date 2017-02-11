/**
 * 
 */
package com.javapractice.leetcode;

/**
 * @author jianyu
 * https://leetcode.com/problems/product-of-array-except-self/
 * Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 * Solve it without division and in O(n).
 * For example, given [1,2,3,4], return [24,12,8,6].
 * Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space complexity analysis.)
 *
 */
public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] front = new int[len];
        for(int i=0; i<len; i++) {
            front[i] = (i==0)?nums[0]:front[i-1]*nums[i];
        }
        for(int i=len-2; i>=0; i--) {
            nums[i] = nums[i+1]*nums[i];
        }
        nums[0] = nums[1];
        for(int i=1; i<len-1; i++) {
            nums[i] = front[i-1]*nums[i+1];
        }
        nums[len-1] = front[len-2];
        return nums;
    }
}
