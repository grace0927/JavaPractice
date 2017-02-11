/**
 * 
 */
package com.javapractice.lintcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jianyu
 * http://www.lintcode.com/en/problem/permutations/
 * Given a list of numbers, return all possible permutations.
 * For nums = [1,2,3], the permutations are:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 * Do it without recursion.
 *
 */
public class Permutations {
    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(nums == null) {
            return res;
        }
        
		int len = nums.size();
		Queue<ArrayList<Integer>> queue = new LinkedList<>();
		
		// initialize
		for(int i=0; i<len; i++) {
			Integer cur = nums.get(i);
			ArrayList<Integer> arr = new ArrayList<>();
			arr.add(cur);
			queue.add(arr);
		}
		
		while(!queue.isEmpty()) {
			ArrayList<Integer> cur = queue.poll();
			if(cur.size() == len) {
			    res.add(cur);
			    continue;
			}
			for(int i=0; i<len; i++) {
				if(!cur.contains(nums.get(i))) {
					cur.add(nums.get(i));
					queue.add(new ArrayList<Integer>(cur));
					cur.remove(cur.size()-1);
				}
			}
		}
		
		return res;
    }
}
