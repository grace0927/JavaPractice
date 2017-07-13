/**
 *
 */
package com.javapractice.leetcode;

/**
 * @author Jianyu Feng
 * https://leetcode.com/problems/guess-number-higher-or-lower/
 * We are playing the Guess Game. The game is as follows:
 * I pick a number from 1 to n. You have to guess which number I picked.
 * Every time you guess wrong, I'll tell you whether the number is higher or lower.
 * You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):
 * -1 : My number is lower
 * 1 : My number is higher
 * 0 : Congrats! You got it!
 * Example:
 * n = 10, I pick 6.
 * Return 6.
 *
 */
public class GuessNumberHigherOrLower {
	public int guessNumber(int n) {
		int start=1, end=n;

		while (start<end) {
			int mid=start+(end-start)/2, check=guess(mid);
			switch(check) {
				case 0:
					return mid;
				case 1:
					start = mid+1;
					break;
				case -1:
					end = mid-1;
					break;
			}
		}

		return end;
	}

	private int pick;
	protected int guess(int num) {
		return num>pick ? -1 : num==pick ? 0 : 1;
	}
}
