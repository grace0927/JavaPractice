/**
 * 
 */
package com.javapractice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author jianyu
 * https://oj.leetcode.com/problems/subsets/
 * Given a set of distinct integers, S, return all possible subsets.
 * Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * For example,
 * If S = [1,2,3], a solution is:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 *
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] S) {
        List<List<Integer>> result = new ArrayList<>();
		List<Integer> row = new ArrayList<>();
		
		Arrays.sort(S);
		subsetsUtil(S, S.length, 0, row, result);
		
		return result;
    }
    
    // backtracking
    public void subsetsUtil(int[] S, int len, int start, List<Integer> row, List<List<Integer>> result) {
        if(row.size() <= len) {
			List<Integer> newOne = new ArrayList<>(row);
			result.add(newOne);
		}
		for(int i=start; i<S.length; i++) {
			Integer key = S[i];
			if(row.contains(key)) {
				continue;
			} else {
				row.add(key);
				subsetsUtil(S, len, i+1, row, result);
				row.remove(key);
			}
		}
    }
    
    // bit manipulation
    public List<List<Integer>> subsetsBitManipulation(int[] S) {
        Arrays.sort(S);
        int totalNumber = 1 << S.length;
        List<List<Integer>> result = new ArrayList<List<Integer>>(totalNumber);
        for (int i=0; i<totalNumber; i++) {
            List<Integer> row = new LinkedList<Integer>();
            for (int j=0; j<S.length; j++) {
                if ((i & (1<<j)) != 0) {
                    row.add(S[j]);
                }
            }
            result.add(row);
        }
        return result;
    }
}
