/**
 * 
 */
package com.javapractice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author feng
 * https://oj.leetcode.com/problems/4sum/
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 * Note:
 * Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a �� b �� c �� d)
 * The solution set must not contain duplicate quadruplets.
 *     For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
 *     A solution set is:
 *     (-1,  0, 0, 1)
 *     (-2, -1, 1, 2)
 *     (-2,  0, 0, 2)
 *
 */
public class FourSum {
	public List<List<Integer>> fourSum(int[] num, int target) {
        List<Integer> list = new ArrayList<>();
        HashMap<List<Integer>, Integer> map = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        
        fourSumUtil(num, 0, list, map);
        
        for(List<Integer> cur:map.keySet()) {
            if(map.get(cur) == target) {
                result.add(cur);
            }
        }
        
        return result;
    }
    
    public void fourSumUtil(int[] num, int start, List<Integer> list, HashMap<List<Integer>, Integer> map) {
        if(list.size() == 4) {
            int sum = list.get(0)+list.get(1)+list.get(2)+list.get(3);
            List<Integer> temp = new ArrayList<>(list);
            map.put(temp, sum);
            return ;
        }
        
        int len = num.length;
        for(int i=start; i<len; i++) {
            Integer cur = new Integer(num[i]);
            list.add(cur);
            fourSumUtil(num, i+1, list, map);
            list.remove(cur);
        }
    }
    
    /*
     * ref: http://tech-wonderland.net/blog/4sum-problem-analysis-different-time-complexity.html
     * convert to 3sum, then to 2sum. then use 2sum.
     */
    public List<List<Integer>> fourSumN3(int[] num, int target) {
        List<List<Integer>> result = new ArrayList<>();
		
		if(num.length < 4) {
			return result;
		}
		
		int len = num.length;
		
		Arrays.sort(num);
		
		for(int i=0; i<len-3; i++) {
			if(i > 0 && num[i] == num[i-1]) {
				continue;
			}
			for(int j=i+1; j<len-2; j++) {
				if(j > i+1 && num[j] == num[j-1]) {
					continue;
				}
				
				int start = j+1;
				int end = len-1;
				
				while(start < end) {
					if(start > j+1 && num[start] == num[start-1]) {
						start++;
						continue;
					}
					int sum = num[i]+num[j]+num[start]+num[end];
					if(sum == target) {
						List<Integer> list = new ArrayList<>();
						list.add(0, num[i]);
						list.add(1, num[j]);
						list.add(2, num[start++]);
						list.add(3, num[end--]);
						result.add(list);
					} else if(sum > target) {
						end--;
					} else {
						start++;
					}
					System.out.println(start);
				}
			}
		}
		
		return result;
    }
}
