/**
 * 
 */
package com.javapractice.leetcode;

/**
 * @author jianyu
 * https://oj.leetcode.com/problems/gas-station/
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i 
 * to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
 * Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
 * Note:
 * The solution is guaranteed to be unique.
 *
 */
public class GasStation {
	public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
		if(len <= 0) {
			return -1;
		}
		
		int[] diff = new int[len];
		diff[0] = gas[0] - cost[0];
		for(int i=1; i<len; i++) {
			diff[i] = gas[i] - cost[i] + diff[i-1];
		}
		
		if(diff[len-1] < 0) {
			return -1;
		} else {
			int min = 0;
			for(int i=1; i<len; i++) {
				if(diff[i] <= diff[min]) {
					min = i;
				}
			}
			if(min == len-1) {
				return 0;
			} else {
				return min+1;
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
