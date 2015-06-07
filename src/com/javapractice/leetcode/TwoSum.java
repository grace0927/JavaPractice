/**
 * 
 */
package com.javapractice.leetcode;

import java.util.HashMap;

/**
 * @author feng
 * https://oj.leetcode.com/problems/two-sum/
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 * The function twoSum should return indices of the two numbers such that they add up to the target, 
 * where index1 must be less than index2. 
 * Please note that your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution.
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 *
 */
public class TwoSum {
	public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int len = numbers.length;
        for(int i=0; i<len; i++) {
            if(map.containsKey(numbers[i])) {
                map.put(numbers[i], map.get(numbers[i])+i+1);
            } else {
                map.put(numbers[i], i+1);
            }
        }
        
        int[] ret = new int[2];
        for(int i=0; i<len; i++) {
            if(map.containsKey(target-numbers[i])) {
                if(target==numbers[i]*2) {
                    if(i == map.get(numbers[i])-1) {
                        continue;
                    }
                    ret[0] = Math.min(i+1, map.get(numbers[i])-i-1);
                    ret[1] = Math.max(i+1, map.get(numbers[i])-i-1);
                    break;
                } else {
                    ret[0] = Math.min(i+1, map.get(target-numbers[i]));
                    ret[1] = Math.max(i+1, map.get(target-numbers[i]));
                    break;
                }
            }
        }
        
        return ret;
    }
}
