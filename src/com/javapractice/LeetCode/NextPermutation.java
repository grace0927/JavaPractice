/**
 * 
 */
package com.javapractice.LeetCode;

/**
 * @author jianyu
 * https://oj.leetcode.com/problems/next-permutation/
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 * The replacement must be in-place, do not allocate extra memory.
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 * 1,2,3 ¡ú 1,3,2
 * 3,2,1 ¡ú 1,2,3
 * 1,1,5 ¡ú 1,5,1
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
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
