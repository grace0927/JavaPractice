/**
 * 
 */
package com.javapractice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jianyu
 * https://oj.leetcode.com/problems/3sum/
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
 * Find all unique triplets in the array which gives the sum of zero.
 * Note:
 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ¡Ü b ¡Ü c)
 * The solution set must not contain duplicate triplets.
 *     For example, given array S = {-1 0 1 2 -1 -4},
 *     A solution set is:
 *     (-1, 0, 1)
 *     (-1, -1, 2)
 *
 */
public class ThreeSum {
	public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> res = new ArrayList<>();
        if(num.length < 3) {
            return res;
        }
        Arrays.sort(num);
		int len = num.length;
		for(int i=0; i<len-2; i++) {
			if(i>0 && num[i]==num[i-1]) {
				continue;
			}
			for(int j=i+1; j<len-1; j++) {
				if(j>i+1 && num[j]==num[j-1]) {
					continue;
				}
				int start = j+1;
				int end = len-1;
				int startVal = num[start];
				int endVal = num[end];
				int target = 0-num[i]-num[j];
				if(target == startVal || target == endVal) {
					List<Integer> list = new ArrayList<>();
					list.add(num[i]);
					list.add(num[j]);
					int cur = (target==startVal)?startVal:endVal;
					list.add(cur);
					res.add(list);
				}
				if(target > startVal && target < endVal) {
					while(start < end-1) {
						int mid = (start+end)/2;
						int midVal = num[mid];
						if(midVal == target) {
							List<Integer> list = new ArrayList<>();
							list.add(num[i]);
							list.add(num[j]);
							list.add(midVal);
							res.add(list);
							break;
						} else if(midVal < target) {
							start = mid;
						} else {
							end = mid;
						}
					}
				}
			}
		}
		return res;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ThreeSum test = new ThreeSum();
		int[] num = {3,0,-2,-1,1,2};
		System.out.println(test.threeSum(num));

	}

}
