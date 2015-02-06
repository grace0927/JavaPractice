/**
 * 
 */
package com.javapractice.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jianyu
 * https://oj.leetcode.com/problems/combinations/
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * For example,
 * If n = 4 and k = 2, a solution is:
 * [
 *  [2,4],
 *  [3,4],
 *  [2,3],
 *  [1,2],
 *  [1,3],
 *  [1,4],
 *  ]
 *
 */
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> row = new ArrayList<>();
		
		combineUtil(result, row, n, k, 0);
		
		return result;
    }
	
	public void combineUtil(List<List<Integer>> result, List<Integer> row, int n, int k, int start) {
		if(row.size() == k) {
			List<Integer> rowNew = new ArrayList<>(row);
			result.add(rowNew);
			return ;
		}
		for(int i=start+1; i<n+1; i++) {
			Integer current = new Integer(i);
			row.add(current);
			combineUtil(result, row, n, k, i);
			row.remove(current);
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
