/**
 * 
 */
package com.javapractice.lintcode;

/**
 * @author jianyu
 * http://www.lintcode.com/en/problem/next-permutation/
 * Given a list of integers, which denote a permutation.
 * Find the next permutation in ascending order.
 * For [1,3,2,3], the next permutation is [1,3,3,2]
 * For [4,3,2,1], the next permutation is [1,2,3,4]
 * The list may contains duplicate integers.
 *
 */
public class NextPermutation {
    /**
     * @param nums: an array of integers
     * @return: return nothing (void), do not return anything, modify nums in-place instead
     */
    public int[] nextPermutation(int[] nums) {
        // write your code here
        int len = nums.length;
        for(int i=len-1; i>0; i--) {
            if(nums[i-1] < nums[i]) {
                // move smallest number larger than i-1 to before
                int temp = nums[i-1];
                int j = len-1;
                while(nums[j]<=temp) {
                    j--;
                }
                nums[i-1] = nums[j];
                nums[j] = temp;
                // sort from i to len-1 accendently
                for(j=i; j<i+(len-i)/2; j++) {
                    if(nums[j] > nums[len-1-j+i]) {
                        int tempSort = nums[j];
                        nums[j] = nums[len-1-j+i];
                        nums[len-1-j+i] = tempSort;
                    }
                }
                return nums;
            }
        }
        for(int i=0; i<len/2; i++) {
            if(nums[i] > nums[len-i-1]) {
                int tempSort = nums[i];
                nums[i] = nums[len-i-1];
                nums[len-i-1] = tempSort;
            }
        }
        return nums;
    }
}
