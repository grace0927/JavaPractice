/**
 * 
 */
package com.javapractice.leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Feng
 * https://leetcode.com/problems/combination-sum-iv/
 * Given an integer array with all positive numbers and no duplicates, 
 * find the number of possible combinations that add up to a positive integer target.
 * Follow up:
 * What if negative numbers are allowed in the given array?
 * How does it change the problem?
 * What limitation we need to add to the question to allow negative numbers?
 *
 */
public class CombinationSumIV {
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        return helper(nums, target, new HashMap<Integer, Integer>());
    }
    
    private int helper(int[] nums, int target, HashMap<Integer, Integer> cache) {
        if(cache.containsKey(target)) {
            return cache.get(target);
        }
        int cnt=0;
        for(int i=0; i<nums.length && nums[i]<=target; i++) {
            if(nums[i]==target) {
                cnt++;
                continue ;
            }
            cnt += helper(nums, target-nums[i], cache);
        }
        cache.put(target, cnt);
        return cnt;
    }
}
