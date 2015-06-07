/**
 * 
 */
package com.javapractice.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jianyu
 * https://oj.leetcode.com/problems/pascals-triangle/
 * Given numRows, generate the first numRows of Pascal's triangle.
 * For example, given numRows = 5,
 * Return
 * [
 *      [1], 
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 *
 */
public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> result = new ArrayList<>();
		
		if(numRows >= 1) {
			List<Integer> row = new ArrayList<>();
			row.add(1);
			result.add(row);
		}
		
		for(int i=1; i<numRows; i++) {	
			List<Integer> rowNew = new ArrayList<>();
			rowNew.add(1);
			for(int j=1; j<i; j++) {
				rowNew.add(result.get(i-1).get(j-1) + result.get(i-1).get(j));
			}
			rowNew.add(1);
			result.add(rowNew);
		}
		
		return result;
    }
}
