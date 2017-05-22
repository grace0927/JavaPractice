/**
 *
 */
package com.javapractice.leetcode;

/**
 * @author Feng
 * https://leetcode.com/problems/perfect-squares/
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
 * For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.
 *
 */
public class PerfectSquares {
	public int numSquares(int n) {
		int[] cnt = new int[n+1];
		cnt[0] = 0;

		for(int i=1; i<=n; i++) {
			for(int j=1; j<=(int)Math.sqrt(i); j++) {
				int target = cnt[i-j*j]+1;
				if(cnt[i]==0 || cnt[i]>target) {
					cnt[i] = target;
				}
			}
		}

		return cnt[n];
	}

	public int numSquaresHashSet(int n) {
		int[] dp = new int[n];
		HashSet<Integer> square = new HashSet<>();

		for (int i=1; i<=n/i; i++) {
			square.add(i*i);
			dp[i*i-1] = 1;
		}

		for (int i=0; i<n; i++) {
			for (int j:square) {
				if (i+j<n) {
					int min = Math.min(dp[i+j], dp[i]+1);
					dp[i+j] = min==0 ? dp[i]+1 : min;
				}
			}
		}

		return dp[n-1];
	}
}
