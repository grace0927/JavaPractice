/**
 * 
 */
package com.javapractice.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author feng
 * https://oj.leetcode.com/problems/pascals-triangle-ii/
 * Given an index k, return the kth row of the Pascal's triangle.
 * For example, given k = 3,
 * Return [1,3,3,1].
 * Note:
 * Could you optimize your algorithm to use only O(k) extra space?
 *
 */
public class PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
		
		if(rowIndex >= 0) {
			result.add(1);
		}
		
		for(int i=1; i<rowIndex+1; i++) {	
			List<Integer> rowNew = new ArrayList<>();
			rowNew.add(1);
			for(int j=1; j<i; j++) {
				rowNew.add(result.get(j-1) + result.get(j));
			}
			rowNew.add(1);
			result = rowNew;
		}
		
		return result;
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
