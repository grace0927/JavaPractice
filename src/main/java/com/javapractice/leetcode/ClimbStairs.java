package com.javapractice.leetcode;

/*
 * Input is guaranteed to be within the range from 1 to 3999.
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 */

public class ClimbStairs {
	public int climbStairsOld(int n) {
		int[] res = new int[n];
		if(n < 2) {
			return n;
		};

		res[0] = 1;
		res[1] = 2;
		for(int i = 0; i < n; i++) {
			res[i] = res[i-1] + res[i-2];
		}

		return res[n-1];
	}

	public int climbStairs(int n) {
		int twoStep=0, oneStep=1, total=0;
		for (int i=0; i<n; i++) {
			total = oneStep+twoStep;
			twoStep = oneStep;
			oneStep = total;
		}

		return total;
	}
}
