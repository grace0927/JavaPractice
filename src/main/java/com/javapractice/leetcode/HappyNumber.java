/**
 *
 */
package com.javapractice.leetcode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author Jianyu Feng
 * https://leetcode.com/problems/happy-number/
 * Write an algorithm to determine if a number is "happy".
 * A happy number is a number defined by the following process: Starting with any positive integer,
 * replace the number by the sum of the squares of its digits, and repeat the
 * process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy
 * numbers.
 * Example: 19 is a happy number
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 *
 */
public class HappyNumber {
	public boolean isHappyMap(int n) {
		HashMap<Integer, Boolean> map = new HashMap<>();

		while(!map.containsKey(n)) {
			if(n==1){
				map.put(n, true);
			} else {
				map.put(n, false);
			}
			n = sum(n);
		}

		return map.get(n);
	}

	public int sum(int n) {
		int sum = 0;
		while(n>=10) {
			sum += (n%10)*(n%10);
			n /= 10;
		}
		sum += n*n;
		return sum;
	}

	public boolean isHappy(int n) {
		HashSet<Integer> set = new HashSet<>();
		set.add(n);
		while (n!=1) {
			n=next(n);
			if (set.contains(n)) {
				return false;
			}
			set.add(n);
		}
		return true;
	}

	private int next(int n) {
		int sum = 0;
		while (n>0) {
			sum += (n%10)*(n%10);
			n /= 10;
		}

		return sum;
	}
}
