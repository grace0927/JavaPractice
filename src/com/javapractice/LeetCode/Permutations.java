/**
 * 
 */
package com.javapractice.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jianyu
 * 
 * https://oj.leetcode.com/problems/permutations/
 * Given a collection of numbers, return all possible permutations.
 * For example,
 * [1,2,3] have the following permutations:
 * [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 *
 */
public class Permutations {
	
	public static List<List<Integer>> permute(int[] num) {
		List<Integer> permutation = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
		permuteUtil(result, permutation, num);
		return result;
    }
	
	public static boolean isSafe(List<Integer> result, Integer num) {
		return !result.contains(num);
	}
	
	public static void permuteUtil(List<List<Integer>> result, List<Integer> permutation, int[] num) {
		if(permutation.size() == num.length) {
			List<Integer> ret = new ArrayList<>(permutation);
			result.add(ret);
			return ;
		}
		for(int i=0; i<num.length; i++) {
			Integer current = new Integer(num[i]);
			System.out.println("permutation: " + permutation);
			if(isSafe(permutation, current)) {
				permutation.add(current);
				permuteUtil(result, permutation, num);
				permutation.remove(current);
			}
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] num = {0, 1};
		List<List<Integer>> result = permute(num);
		System.out.println("result: " + result);
	}

}
