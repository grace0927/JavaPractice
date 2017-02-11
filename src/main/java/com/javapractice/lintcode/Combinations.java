/**
 * 
 */
package com.javapractice.lintcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jianyu
 * http://www.lintcode.com/en/problem/combinations/
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * For example,
 * If n = 4 and k = 2, a solution is:
 * [[2,4],[3,4],[2,3],[1,2],[1,3],[1,4]]
 *
 */
public class Combinations {
    /**
     * @param n: Given the range of numbers
     * @param k: Given the numbers of combinations
     * @return: All the combinations of k numbers out of 1..n
     */
    public List<List<Integer>> combine(int n, int k) {
		// write your code here
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> cur = new ArrayList<>();
		combineUtil(n, k, 1, cur, res);
		return res;
    }
	
	public void combineUtil(int n, int k, int start, List<Integer> cur, List<List<Integer>> res) {
		if(k == 0) {
			res.add(new ArrayList<Integer>(cur));
			return ;
		}
		for(int i=start; i<=n; i++) {
			cur.add(i);
			combineUtil(n, k-1, i+1, cur, res);
			cur.remove(cur.size()-1);
		}
    }
}
