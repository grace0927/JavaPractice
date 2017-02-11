/**
 * 
 */
package com.javapractice.lintcode;

/**
 * @author jianyu
 * http://www.lintcode.com/en/problem/partition-array/
 * Given an array nums of integers and an int k, partition the array (i.e move the elements in "nums") such that:
 * All elements < k are moved to the left
 * All elements >= k are moved to the right
 * Return the partitioning index, i.e the first index i nums[i] >= k.
 * If nums = [3,2,2,1] and k=2, a valid answer is 1.
 * You should do really partition in array nums instead of just counting the numbers of integers smaller than k.
 * If all elements in nums are smaller than k, then return nums.length
 * Can you partition the array in-place and in O(n)?
 *
 */
public class PartitionArray {
	/** 
     *@param nums: The integer array you should partition
     *@param k: As description
     *return: The index after partition
     */
    public int partitionArray(int[] nums, int k) {
	    //write your code here
	    int i=0, j=nums.length-1;
	    while(i < j) {
	    	while(i < nums.length && nums[i] < k) {
	    		i++;
	    	}
	    	while(j >= 0 && nums[j] >= k) {
	    		j--;
	    	}
	    	if(i > j) {
	    		return i;
	    	} else {
	    		int temp = nums[i];
	    		nums[i] = nums[j];
	    		nums[j] = temp;
	    	}
	    }

	    return i;
    }
}
