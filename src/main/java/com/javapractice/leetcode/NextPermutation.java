/**
 * 
 */
package com.javapractice.leetcode;

/**
 * @author jianyu
 * https://oj.leetcode.com/problems/next-permutation/
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 * The replacement must be in-place, do not allocate extra memory.
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 * 1,2,3 �� 1,3,2
 * 3,2,1 �� 1,2,3
 * 1,1,5 �� 1,5,1
 * reference: http://baike.baidu.com/view/4670107.htm
 *
 */
public class NextPermutation {
	public void nextPermutation(int[] num) {
        int len = num.length;
		int pivot = len - 1;
		
		// find pivot index
		for(int i=len-2; i>=0; i--) {
			if(num[i] < num[i+1]) {
				pivot = i;
				break;
			}
		}
		
		if(pivot == len-1) {
			// special case: descending order
			int start = 0;
			int end = len-1;
			while(start < end) {
			    int temp = num[start];
			    num[start] = num[end];
			    num[end] = temp;
			    start++;
			    end--;
		    }
		} else {
			int change = len-1;
			int pivotValue = num[pivot];
			
			for(int i=len-1; i>pivot; i--) {
				if(num[i] > pivotValue) {
					change = i;
					break;
				}
			}
			
			num[pivot] = num[change];
			num[change] = pivotValue;
			
			int start = pivot+1;
			int end = len-1;
			while(start < end) {
			    int temp = num[start];
			    num[start] = num[end];
			    num[end] = temp;
			    start++;
			    end--;
		    }
		}
    }
	
	// neat code in round 4
    public void round4(int[] nums) {
        int n=nums.length, pnt=n-1;
        while(pnt>0 && nums[pnt]<=nums[pnt-1]) {
            pnt--;
        }
        if(pnt==0) {
            reverse(nums, 0, n-1);
        } else {
            int i=pnt;
            while(i<n && nums[i]>nums[pnt-1]) {
                i++;
            }
            swap(nums, pnt-1, i-1);
            reverse(nums, pnt, n-1);
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    
    private void reverse(int[] nums, int start, int end) {
        while(start<end) {
            swap(nums, start++, end--);
        }
    }
}
