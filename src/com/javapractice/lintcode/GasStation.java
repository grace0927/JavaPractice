/**
 * 
 */
package com.javapractice.lintcode;

/**
 * @author jianyu
 * http://www.lintcode.com/en/problem/gas-station/
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1).
 * You begin the journey with an empty tank at one of the gas stations.
 * Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
 * Given 4 gas stations with gas[i]=[1,1,3,1], and the cost[i]=[2,2,1,1]. The starting gas station's index is 2.
 * The solution is guaranteed to be unique.
 * O(n) time and O(1) extra space
 *
 */
public class GasStation {
    /**
     * @param gas: an array of integers
     * @param cost: an array of integers
     * @return: an integer
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // write your code here
        int len = gas.length;
        for(int i=0; i<len; i++) {
            int temp = gas[i] - cost[i];
            int start = (i+1)%len;
            while(start!=i && temp>0) {
                temp += gas[start];
                temp -= cost[start];
                start = (start+1)%len;
            }
            if(temp < 0) {
                continue;
            }
            if(start == i) {
                return i;
            }
        }
        return -1;
    }
}
