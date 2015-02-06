/**
 * 
 */
package com.javapractice.LeetCode;

import java.util.Arrays;

/**
 * @author feng
 * https://oj.leetcode.com/problems/3sum-closest/
 * Given an array S of n integers, find three integers in S 
 * such that the sum is closest to a given number, target. Return the sum of the three 
 * integers. You may assume that each input would have exactly one solution.
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 *
 */
public class ThreeSumClosest {
	public int threeSumClosest(int[] num, int target) {
        Arrays.sort(num);
        int min = target - num[0] - num[1] - num[2];
        int absMin = Math.abs(min);
        for(int i=0; i<num.length; i++) {
            int first = i+1;
            int last = num.length - 1;
            while(first < last) {
                int diff = target - num[i] - num[first] - num[last];
                int absDiff = Math.abs(diff);
                if(absMin > absDiff) {
                    min = diff;
                    absMin = absDiff;
                }
                if(diff == 0) {
                    return target;
                } else if(diff < 0) {
                    if(Math.abs(diff+num[last]-num[last-1]) <= absDiff) {
                        last--;
                    } else {
                        first = last;
                    }
                } else {
                    if(Math.abs(diff+num[first]-num[first+1]) <= absDiff) {
                        first++;
                    } else {
                        first = last;
                    }
                }
            }
        }
        return target-min;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
