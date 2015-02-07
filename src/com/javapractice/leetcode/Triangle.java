/**
 * 
 */
package com.javapractice.leetcode;

import java.util.List;

/**
 * @author jianyu
 * https://oj.leetcode.com/problems/triangle/
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 * For example, given the following triangle
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * Note:
 * Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 *
 */
public class Triangle {
	public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null) {
			return 0;
		}
		int len = triangle.size();
        int[] result = new int[len];
		for(int i=0; i<len; i++) {
			result[i] = 0;
		}
		
		result[0] = triangle.get(0).get(0);
		for(int i=1; i<len; i++) {
			result[i] = result[i-1] + triangle.get(i).get(i);
			for(int j=i-1; j>0; j--) {
				result[j] = Math.min(result[j-1], result[j]) + triangle.get(i).get(j);
			}
			result[0] += triangle.get(i).get(0);
		}
		
		int min = result[0];
		for(int i=1; i<len; i++) {
			if(min > result[i]) {
				min = result[i];
			}
		}
		return min;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
