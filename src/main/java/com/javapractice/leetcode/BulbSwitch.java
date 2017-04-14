/**
 *
 */
package com.javapractice.leetcode;

/**
 * @author Feng
 * https://leetcode.com/problems/bulb-switcher/
 * There are n bulbs that are initially off. You first turn on all the bulbs.
 * Then, you turn off every second bulb. On the third round, you toggle every
 * third bulb (turning on if it's off or turning off if it's on).
 * For the nth round, you only toggle the last bulb. Find how many bulbs are on after n rounds.
 *
 */
public class BulbSwitch {
	public int bulbSwitchNaive(int n) {
		boolean[] arr = new boolean[n];
		int cnt = 0;

		for(int i=1; i<=n; i++) {
			int pnt = i-1;
			while(pnt<n) {
				arr[pnt] = arr[pnt]?false:true;
				pnt += i;
			}
		}

		for(int i=0; i<n; i++) {
			cnt = arr[i]?cnt+1:cnt;
		}

		return cnt;
	}

	/*
	 * deep observation find that only square number bulb will light up after n round.
	 * so count the total square number under n. n/2 check is enough except 1.
	 */
	public int bulbSwitch(int n) {
		int cnt = 0;

		for(int i=1; i<=n; i++) {
			if(i<= n/i) {
				cnt++;
			}
		}

		return cnt;
	}
}
