/**
 *
 */
package com.javapractice.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jianyu Feng
 * https://leetcode.com/problems/combination-sum-iii/
 * Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
 * Ensure that numbers within the set are sorted in ascending order.
 * Example 1:
 * Input: k = 3, n = 7
 * Output:
 * [[1,2,4]]
 * Example 2:
 * Input: k = 3, n = 9
 * Output:
 * [[1,2,6], [1,3,5], [2,3,4]]
 *
 */
public class CombinationSumIII {
	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> list = new ArrayList<>();
		List<Integer> row = new ArrayList<>();

		combinationSum3Util(list, row, k, n, 1);

		return list;
	}

	public void combinationSum3Util(List<List<Integer>> list, List<Integer> row, int k, int n, int start) {
		if(k==1) {
			if(n<10 && n>=start) {
				row.add(n);
				list.add(new ArrayList<>(row));
				row.remove(row.size()-1);
			}
			return ;
		}

		for(int i=start; i<10; i++) {
			row.add(i);
			combinationSum3Util(list, row, k-1, n-i, i+1);
			row.remove(row.size()-1);
		}
	}

	public void combinationSum3Helper(int k, int n, int start, List<Integer> list, List<List<Integer>> collection) {
		if(k==0 && n==0) {
			collection.add(new ArrayList<>(list));
			return ;
		}

		if(n<=0 || k==0) {
			return ;
		}

		for(int i=start; i<=9; i++) {
			list.add(i);
			combinationSum3Helper(k-1, n-i, i+1, list, collection);
			list.remove(list.size()-1);
		}
	}
}
