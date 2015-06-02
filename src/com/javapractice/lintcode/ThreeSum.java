/**
 * 
 */
package com.javapractice.lintcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author jianyu
 * http://www.lintcode.com/en/problem/3-sum/
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * For example, given array S = {-1 0 1 2 -1 -4}, A solution set is:
 * (-1, 0, 1)
 * (-1, -1, 2)
 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ¡Ü b ¡Ü c)
 * The solution set must not contain duplicate triplets.
 *
 */
public class ThreeSum {
    /**
     * @param numbers : Give an array numbers of n integer
     * @return : Find all unique triplets in the array which gives the sum of zero.
     */
    public ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
        // write your code here
        Arrays.sort(numbers);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        int len = numbers.length;
        for(int i=0; i<len-2; i++) {
        	if(i>0 && numbers[i] == numbers[i-1]) {
        		continue;
        	}
        	for(int j=i+1; j<len-1;j++) {
        		if(j>i+1 && numbers[j] == numbers[j-1]) {
        			continue;
        		}
        		for(int k=j+1; k<len; k++) {
            		if(k>j+1 && numbers[k] == numbers[k-1]) {
            			continue;
            		}
        			if(numbers[i]+numbers[j]+numbers[k] == 0) {
        				ArrayList<Integer> row = new ArrayList<>();
        				row.add(numbers[i]);
        				row.add(numbers[j]);
        				row.add(numbers[k]);
        				res.add(row);
        			}
        		}
        	}
        }
        return res;
    }
}
