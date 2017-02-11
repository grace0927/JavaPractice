/**
 * 
 */
package com.javapractice.lintcode;

import java.util.ArrayList;

/**
 * @author jianyu
 * http://www.lintcode.com/en/problem/subarray-sum/
 * Given an integer array, find a subarray where the sum of numbers is zero. 
 * Your code should return the index of the first number and the index of the last number.
 * Given [-3, 1, 2, -3, 4], return [0, 2] or [1, 3].
 * There is at least one subarray that it's sum equals to zero.
 *
 */
public class SubarraySum {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
    public ArrayList<Integer> subarraySum(int[] nums) {
        // write your code here
        int len = nums.length;
        
        for(int i=0; i<len; i++) {
            int sum = nums[i];
            for(int j=i+1; j<len; j++) {
                if(sum == 0) {
                    ArrayList<Integer> result = new ArrayList<>();
                    result.add(i);
                    result.add(j-1);
                    return result;
                } 
                sum += nums[j];
            }
            if(sum == 0) {
                ArrayList<Integer> result = new ArrayList<>();
                result.add(i);
                result.add(len-1);
                return result;
            }
        }
        
        return new ArrayList<Integer>();
    }
}
