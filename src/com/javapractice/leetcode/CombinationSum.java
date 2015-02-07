/**
 * 
 */
package com.javapractice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author feng
 * https://oj.leetcode.com/problems/combination-sum/
 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 * The same repeated number may be chosen from C unlimited number of times.
 * Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, �? , ak) must be in non-descending order. (ie, a1 �? a2 �? �? �? ak).
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set 2,3,6,7 and target 7, 
 * A solution set is: 
 * [7] 
 * [2, 2, 3] 
 *
 */
public class CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        int sum = 0;
        Arrays.sort(candidates);
        combinationSumUtil(result, row, sum, 0, candidates, target);
        return result;
    }
    
    public void combinationSumUtil(List<List<Integer>> result, List<Integer> row, int sum, int start, int[] candidates, int target) {
        if(sum == target) {
            List<Integer> rowNew = new ArrayList<>(row);
            result.add(rowNew);
            return ;
        } else if(sum > target) {
            return ;
        } else {
            for(int i=start; i<candidates.length; i++) {
                Integer temp = candidates[i];
                if(temp > target) {
                    return ;
                }
                row.add(temp);
                sum += temp;
                combinationSumUtil(result, row, sum, i, candidates, target);
                sum -= temp;
                row.remove(temp);
            }
        }
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CombinationSum test = new CombinationSum();
		int[] candidates = new int[]{6,4,3,10,12};
		int target = 28;
		System.out.println(test.combinationSum(candidates, target));
	}

}
