/**
 *
 */
package com.javapractice.leetcode;

/**
 * @author Feng
 * https://leetcode.com/problems/beautiful-arrangement/
 * Suppose you have N integers from 1 to N.
 * We define a beautiful arrangement as an array that is constructed by these N numbers successfully
 * if one of the following is true for the ith position (1 ≤ i ≤ N) in this array:
 * The number at the ith position is divisible by i.
 * i is divisible by the number at the ith position.
 * Now given N, how many beautiful arrangements can you construct?
 *
 */
public class BeautifulArrangement {
	public int countArrangement(int N) {
		int[] arrangement = new int[N];
		boolean[] visit = new boolean[N];

		return countArrangement(arrangement, visit, 0, N);
	}

	public int countArrangement(int[] arrangement, boolean[] visit, int current, int total) {
		if (current==total) {
			return 1;
		}
		int count = 0;

		for (int i=1; i<=total; i++) {
			if (!visit[i-1] && isValid(current+1, i)) {
				visit[i-1] = true;
				arrangement[current] = i;
				count += countArrangement(arrangement, visit, current+1, total);
				arrangement[current] = 0;
				visit[i-1] = false;
			}
		}

		return count;
	}

	public boolean isValid(int a, int b) {
		return a%b==0 || b%a==0;
	}
}
