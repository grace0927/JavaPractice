/**
 * 
 */
package com.javapractice.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jianyu
 * https://oj.leetcode.com/problems/combination-sum-ii/
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 * Each number in C may only be used once in the combination.
 * Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, ¡­ , ak) must be in non-descending order. (ie, a1 ¡Ü a2 ¡Ü ¡­ ¡Ü ak).
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
 * A solution set is: 
 * [1, 7] 
 * [1, 2, 5] 
 * [2, 6] 
 * [1, 1, 6] 
 *
 */
public class CombinationsSumII {
	public List<List<Integer>> combinationSum2(int[] num, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        int sum = 0;
        Arrays.sort(num);
        combinationSumUtil(result, row, sum, 0, num, target);
        return result;
    }
    
    public void combinationSumUtil(List<List<Integer>> result, List<Integer> row, int sum, int start, int[] num, int target) {
        if(sum == target) {
            List<Integer> rowNew = new ArrayList<>(row);
            if(!result.contains(rowNew)) {
                result.add(rowNew);
            }
            return ;
        } else if(sum > target) {
            return ;
        } else {
            for(int i=start; i<num.length; i++) {
                Integer temp = num[i];
                if(temp > target) {
                    return ;
                }
                row.add(temp);
                sum += temp;
                combinationSumUtil(result, row, sum, i+1, num, target);
                sum -= temp;
                row.remove(temp);
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
