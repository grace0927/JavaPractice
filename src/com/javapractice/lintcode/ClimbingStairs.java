/**
 * 
 */
package com.javapractice.lintcode;

/**
 * @author jianyu
 * http://www.lintcode.com/en/problem/climbing-stairs/
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps.
 * In how many distinct ways can you climb to the top?
 * Given an example n=3 , 1+1+1=2+1=1+2=3
 * return 3
 *
 */
public class ClimbingStairs {
	/**
	 * @param n: An integer
	 * @return: An integer
	 */
	public int climbStairs(int n) {
		// write your code here
		if(n<=0) {
			return 0;
		} else if(n == 1) {
			return 1;
		} else if(n == 2) {
			return 2;
		}

		int[] res= new int[n];
		res[0] = 1;
		res[1] = 2;

		for(int i=2; i<n; i++) {
			res[i] = res[i-2] + res[i-1];
		}

		return res[n-1];
	}
}
