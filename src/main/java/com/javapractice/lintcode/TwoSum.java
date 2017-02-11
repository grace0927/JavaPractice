/**
 * 
 */
package com.javapractice.lintcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author jianyu
 * http://www.lintcode.com/en/problem/2-sum/
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. 
 * Please note that your returned answers (both index1 and index2) are NOT zero-based.
 * numbers=[2, 7, 11, 15], target=9
 * return [1, 2]
 * You may assume that each input would have exactly one solution
 * Either of the following solutions are acceptable:
 * O(1) Space, O(nlogn) Time
 * O(n) Space, O(n) Time
 *
 */
public class TwoSum {
    /*
     * @param numbers : An array of Integer
     * @param target : target = numbers[index1] + numbers[index2]
     * @return : [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] numbers, int target) {
        // write your code here
    	
    	/** 
    	 * O(n) Space, O(nlogn) Time
    	 * has duplicate bug
    	 */
        int len = numbers.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<len; i++) {
            map.put(numbers[i], i+1);
        }
        
        Arrays.sort(numbers);
        int[] res = new int[2];

        int i=1;
        int j=len;
        while(i < j) {
        	int sum = numbers[i-1] + numbers[j-1];
        	if(sum > target) {
        		j--;
        	} else if(sum == target) {
        		int index1 = map.get(numbers[i-1]);
        		int index2 = map.get(numbers[j-1]);
        		res[0] = (index1>index2)?index2:index1;
        		res[1] = (index1>index2)?index1:index2;
        		return res;
        	} else {
        		i++;
        	}
        }
        
        return res;
    }
    
    public int[] twoSumAlter1(int[] numbers, int target) {
    	/** 
    	 * O(n) Space, O(n) Time
    	 */
        int len = numbers.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<len; i++) {
        	if(map.containsKey(numbers[i])) {
        		map.put(numbers[i], map.get(numbers[i])+i+1);
        	} else {
        		map.put(numbers[i], i+1);
        	}
        }
        
        int[] res = new int[2];
        for(int i=0; i<len; i++) {
        	int left = target-numbers[i];
        	if(map.containsKey(left)) {
        		if(left == numbers[i]) {
        			if(map.get(left)==i+1) {
        				continue;
        			} else {
        				int index1 = i+1;
        				int index2 = map.get(left)-i-1;
        				res[0] = (index1>index2)?index2:index1;
        				res[1] = (index1>index2)?index1:index2;
        				return res;
        			}
        		}
				int index1 = i+1;
				int index2 = map.get(left);
				res[0] = (index1>index2)?index2:index1;
				res[1] = (index1>index2)?index1:index2;
				return res;
        		
        	}
        }
        
        return res;
    }
    
    public int[] twoSumAlter2(int[] numbers, int target) {
    	/** 
    	 * O(n) Space, O(n) Time
    	 */
        int len = numbers.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        
        for(int i=0; i<len; i++) {
        	int left = target - numbers[i];
        	if(map.containsKey(left)) {
        		res[0] = map.get(left);
        		res[1] = i+1;
        		return res;
        	} else {
        		map.put(numbers[i], i+1);
        	}
        }
        
        return res;
    }
}
