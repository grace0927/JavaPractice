/**
 * 
 */
package com.javapractice.leetcode;

import java.util.TreeSet;

/**
 * @author jianyu
 * https://leetcode.com/problems/contains-duplicate-iii/
 * Given an array of integers, 
 * find out whether there are two distinct indices i and j in the array such that the difference 
 * between nums[i] and nums[j] is at most t and the difference between i and j is at most k.
 * href: http://www.programcreek.com/2014/06/leetcode-contains-duplicate-iii-java/
 *
 */
public class ContainsDuplicateIII {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums.length <= 1) {
            return false;
        }
        
        TreeSet<Integer> set = new TreeSet<>();
        for(int i=0; i<nums.length; i++) {
            int cur = nums[i];
            if((set.floor(cur)!=null && cur<=set.floor(cur)+t) || (set.ceiling(cur)!=null && cur>=set.ceiling(cur)-t)) {
                return true;
            }
            set.add(cur);
            if(i >= k) {
                set.remove(nums[i-k]);
            }
        }
        
        return false;
    }
}
