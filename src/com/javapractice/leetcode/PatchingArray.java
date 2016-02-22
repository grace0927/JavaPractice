/**
 * 
 */
package com.javapractice.leetcode;

import java.util.HashSet;

/**
 * @author Feng
 * https://leetcode.com/problems/patching-array/
 * Given a sorted positive integer array nums and an integer n, 
 * add/patch elements to the array such that any number in range [1, n] 
 * inclusive can be formed by the sum of some elements in the array. 
 * Return the minimum number of patches required.
 * Example 1:
 * nums = [1, 3], n = 6
 * Return 1.
 * Combinations of nums are [1], [3], [1,3], which form possible sums of: 1, 3, 4.
 * Now if we add/patch 2 to nums, the combinations are: [1], [2], [3], [1,3], [2,3], [1,2,3].
 * Possible sums are 1, 2, 3, 4, 5, 6, which now covers the range [1, 6].
 * So we only need 1 patch.
 * 
 * Example 2:
 * nums = [1, 5, 10], n = 20
 * Return 2.
 * The two patches can be [2, 4].
 * 
 * Example 3:
 * nums = [1, 2, 2], n = 5
 * Return 0.
 *
 */
public class PatchingArray implements Solution {
	public void test() {
		PatchingArray test = new PatchingArray();
    	int[] arr = {1,5,10};
    	System.out.println(test.minPatches(arr, 50));
	}
	
	/*
	 * Greedy
	 */
    public int minPatches(int[] nums, int n) {
        long top=1;
        int pnt=0;
        int cnt = 0;
        while(top<=n) {
            if(pnt<nums.length && top>=nums[pnt]) {
                top += nums[pnt++];
            } else {
                top+=top;
                cnt++;
            }
        }
        
        return cnt;
    }
	
    public int minPatchesTrivial(int[] nums, int n) {
        HashSet<Integer> set = new HashSet<>();
        initSet(nums, set);
        
        return cntSet(n, set);
    }
    
    public void addSet(int value, HashSet<Integer> set) {
        for(int item:set.toArray(new Integer[set.size()])) {
            set.add(value+item);
        }
        set.add(value);
    }
    
    public void initSet(int[] nums, HashSet<Integer> set) {
        for(int i=0; i<nums.length; i++) {
            addSet(nums[0], set);
        }
    }
    
    public int cntSet(int n, HashSet<Integer> set) {
        int cnt = 0;
        for(int i=0; i<n; i++) {
            if(!set.contains(i+1)) {
                cnt++;
                addSet(i+1, set);
            }
        }
        return cnt;
    }
}
