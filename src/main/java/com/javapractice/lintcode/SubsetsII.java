/**
 * 
 */
package com.javapractice.lintcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author jianyu
 * http://www.lintcode.com/en/problem/subsets-ii/
 * Given a list of numbers that may has duplicate numbers, return all possible subsets
 * If S = [1,2,2], a solution is:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 * Each element in a subset must be in non-descending order.
 * The ordering between two subsets is free.
 * The solution set must not contain duplicate subsets.
 *
 */
public class SubsetsII {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> S) {
        // write your code here
		Integer[] src = S.toArray(new Integer[S.size()]);
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		ArrayList<Integer> row = new ArrayList<>();
		Arrays.sort(src);
		
		subsetsWithDupUtil(row, res, src, 0);
		
		return res;
    }
	
	public void subsetsWithDupUtil(ArrayList<Integer> row, ArrayList<ArrayList<Integer>> res, Integer[] src, int start) {
		if(!res.contains(row)) {
			res.add(new ArrayList<Integer>(row));
		}
		
		for(int i=start; i<src.length; i++) {
			row.add(src[i]);
			subsetsWithDupUtil(row, res, src, i+1);
			row.remove(row.size()-1);
		}
    }
}
