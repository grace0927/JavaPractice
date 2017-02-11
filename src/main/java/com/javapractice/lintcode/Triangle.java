/**
 * 
 */
package com.javapractice.lintcode;

import java.util.ArrayList;

/**
 * @author jianyu
 * http://www.lintcode.com/en/problem/triangle/
 * Given a triangle, find the minimum path sum from top to bottom.
 * Each step you may move to adjacent numbers on the row below.
 * For example, given the following triangle
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 *
 */
public class Triangle {
    /**
     * @param triangle: a list of lists of integers.
     * @return: An integer, minimum path sum.
     */
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        // write your code here
		if(triangle == null) {
			return 0;
		}
		int[] res = new int[triangle.size()];
		
		for(ArrayList<Integer> row:triangle) {
			for(int i=row.size()-1; i>0; i--) {
				res[i] = (i==row.size()-1)?res[i-1]:((res[i]>res[i-1])?res[i-1]:res[i]);
				res[i] += row.get(i);
				
			}
			res[0] += row.get(0);
		}
		
		int min = res[0];
		for(int i=1; i<res.length; i++) {
			min = (min>res[i])?res[i]:min;
		}
		
		return min;
    }
}
