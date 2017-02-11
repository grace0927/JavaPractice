/**
 * 
 */
package com.javapractice.lintcode;

import java.util.Arrays;

/**
 * @author jianyu
 * http://www.lintcode.com/en/problem/3-sum-closest/
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers.
 * For example, given array S = {-1 2 1 -4}, and target = 1. The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * You may assume that each input would have exactly one solution.
 * O(n^2) time, O(1) extra space
 *
 */
public class ThreeSumClosest {
    /**
     * @param numbers: Give an array numbers of n integer
     * @param target : An integer
     * @return : return the sum of the three integers, the sum closest target.
     */
    public int threeSumClosest(int[] numbers ,int target) {
        // write your code here
        Arrays.sort(numbers);

        int len = numbers.length;
        int min = numbers[0]+numbers[1]+numbers[2]-target;
        for(int i=0; i<len; i++) {
        	int j=i+1;
        	int k=len-1;
        	while(j<k) {
	        	int sum = numbers[i]+numbers[j]+numbers[k];
	        	int temp = sum-target;
	        	min = (Math.abs(temp)>Math.abs(min))?min:temp;
	        	if(sum > target) {
	        		k--;
	        	} else if(sum == target) {
	        		return sum;
	        	} else {
	        		j++;
	        	}
	        }
        }

        return target+min;
    }
}
