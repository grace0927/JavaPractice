/**
 * 
 */
package com.javapractice.lintcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jianyu
 * http://www.lintcode.com/en/problem/combination-sum/
 * Given a set of candidate numbers (C) and a target number (T), 
 * find all unique combinations in C where the candidate numbers sums to T.
 * The same repeated number may be chosen from C unlimited number of times.
 * For example, given candidate set 2,3,6,7 and target 7, 
 * A solution set is: 
 * [7] 
 * [2, 2, 3] 
 * given candidate set 2,3,6,7 and target 7
 * A solution set is: 
 * [7] 
 * [2, 2, 3] 
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, ¡­ , ak) must be in non-descending order. (ie, a1 ¡Ü a2 ¡Ü ¡­ ¡Ü ak).
 * The solution set must not contain duplicate combinations.
 *
 */
public class CombinationSum {
    /**
     * @param candidates: A list of integers
     * @param target:An integer
     * @return: A list of lists of integers
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // write your code here
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> cur = new ArrayList<>();
		Arrays.sort(candidates);
		combinationSumUtil(candidates, target, cur, res, 0);
		return res;
    }
	
	public void combinationSumUtil(int[] candidates, int target, List<Integer> cur, List<List<Integer>> res, int start) {
		if(target == 0) {
			if(!res.contains(cur)) {
				res.add(new ArrayList<Integer>(cur));
			}
			return ;
		}
		for(int i=start; i<candidates.length; i++) {
			if(target >= candidates[i]) {
				cur.add(candidates[i]);
				combinationSumUtil(candidates, target-candidates[i], cur, res, i);
				cur.remove(cur.size()-1);
			}
		}
    }
}
