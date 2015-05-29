/**
 * 
 */
package com.javapractice.lintcode;

/**
 * @author jianyu
 * http://www.lintcode.com/en/problem/remove-duplicates-from-sorted-array/
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * Given input array A = [1,1,2],
 * Your function should return length = 2, and A is now [1,2].
 *
 */
public class RemoveDuplicatesFromSortedArray {
    /**
     * @param A: a array of integers
     * @return : return an integer
     */
    public int removeDuplicates(int[] nums) {
        // write your code here
        int len = nums.length;
        if(len == 0) {
        	return 0;
        }
        
        int slow = 1;
        while(slow<len && nums[slow]!=nums[slow-1]) {
        	slow++;
        }
        if(slow == len) {
        	return len;
        }
        
        int fast = slow+1;
        int last = nums[slow];
        while(fast<len) {
        	if(nums[fast] == last) {
        		fast++;
        	} else {
        		nums[slow] = nums[fast];
        		slow++;
        		last = nums[fast];
        		fast++;
        	}
        }
        
        return slow;
    }
}
