/**
 * 
 */
package com.javapractice.lintcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author jianyu
 * http://www.lintcode.com/en/problem/subsets/
 * Given a set of distinct integers, return all possible subsets.
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
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 *
 */
public class Subsets {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> S) {
        // write your code here
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		if(S == null) {
			return res;
		}
		
		ArrayList<Integer> row = new ArrayList<>();
		Integer[] set = new Integer[S.size()];
		set = S.toArray(set);
		
		Arrays.sort(set);
		subsetsUtil(res, row, set, 0);
		
		return res;
    }
	
	public void subsetsUtil(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> row, Integer[] set, int start) {
		if(!res.contains(row)) {
			res.add(new ArrayList<Integer>(row));
		}
		for(int i=start; i<set.length; i++) {
			row.add(set[i]);
			subsetsUtil(res, row, set, i+1);
			row.remove(row.size()-1);
		}
    }
}
