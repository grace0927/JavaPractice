/**
 * 
 */
package com.javapractice.lintcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author jianyu
 * http://www.lintcode.com/en/problem/permutations-ii/
 * Given a list of numbers with duplicate number in it. Find all unique permutations.
 * For numbers [1,2,2] the unique permutations are:
 * [
 *     [1,2,2],
 *     [2,1,2],
 *     [2,2,1]
 * ]
 * Do it without recursion.
 *
 */
public class PermutationsII {
    /**
     * @param nums: A list of integers.
     * @return: A list of unique permutations.
     */
    public ArrayList<ArrayList<Integer>> permuteUnique(ArrayList<Integer> nums) {
        // write your code here
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		if(nums == null) {
			return res;
		}
		
		Integer[] arr = nums.toArray(new Integer[nums.size()]);
		int len = arr.length;
		ArrayList<Integer> row = new ArrayList<>();
		boolean[] visit = new boolean[len];
		
		Arrays.sort(arr);
		for(int i=0; i<len; i++) {
			visit[i] = false;
		}
		
		permuteUniqueUtil(res, row, arr, visit);
		
		return res;
    }
	
	public void permuteUniqueUtil(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> row, Integer[] arr, boolean[] visit) {
		int len = arr.length;
		if(row.size() == len) {
			res.add(new ArrayList<Integer>(row));
		}
		
		for(int i=0; i<len; i++) {
			if(visit[i] || (i>0 && arr[i]==arr[i-1] && !visit[i-1])) {
				continue;
			}
			row.add(arr[i]);
			visit[i] = true;
			permuteUniqueUtil(res, row, arr, visit);
			row.remove(row.size()-1);
			visit[i] = false;
		}
    }
	
	public ArrayList<ArrayList<Integer>> permuteUniqueIterative(ArrayList<Integer> nums) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		if(nums == null) {
			return res;
		}

		int len = nums.size();
		int[] arr = new int[len];
		
		for(int i=0; i<len; i++) {
			arr[i] = i;
		}
		
		while(true) {
		    if(!res.contains(nums)) {
			    res.add(new ArrayList<Integer>(nums));
		    }
			for(int i=0; i<=len; i++) {
				if(i == len) {
					return res;
				}
				if(arr[i] == 0) {
					arr[i] = i;
					swap(nums, 0, i);
				} else {
					swap(nums, arr[i], i);
					arr[i]--;
					swap(nums, arr[i], i);
					break;
				}
			}
		}
	}
	
	public void swap(ArrayList<Integer> nums, int i, int j) {
		if(i != j) {
			int tempI = nums.get(i);
			nums.set(i, nums.get(j));
			nums.set(j, tempI);
		}
	}
}
