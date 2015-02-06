/**
 * 
 */
package com.javapractice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author feng
 * https://oj.leetcode.com/problems/permutations-ii/
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * For example,
 * [1,1,2] have the following unique permutations:
 * [1,1,2], [1,2,1], and [2,1,1].
 *
 */
public class PermutationII {
	public List<List<Integer>> permuteUnique(int[] num) {
        List<Integer> permutation = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        int[] row = new int[num.length];
        for(int i=0; i<num.length; i++) {
            row[i] = 0;
        }
        Arrays.sort(num);
		permuteUtil(result, permutation, num, row);
		return result;
    }
	
	public void permuteUtil(List<List<Integer>> result, List<Integer> permutation, int[] num, int[] row) {
		if(permutation.size() == num.length) {
			List<Integer> ret = new ArrayList<>(permutation);
			if(!result.contains(ret)) {
				result.add(ret);
			}
			return ;
		}
		
		for(int i=0; i<num.length; i++) {
			Integer current = new Integer(num[i]);
			if(i>0 && num[i] == num[i-1] && row[i-1] == 1) {
			    continue;
			}
			if(row[i] == 0) {
			    permutation.add(current);
			    row[i] = 1;
			    permuteUtil(result, permutation, num, row);
			    row[i] = 0;
			    permutation.remove(permutation.size()-1);
			}
		}
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PermutationII test = new PermutationII();
		int[] num = {1,1,0,0,1,-1,-1,1};
		System.out.println(test.permuteUnique(num));

	}

}
