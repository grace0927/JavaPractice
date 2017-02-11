/**
 * 
 */
package com.javapractice.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jianyu
 * https://oj.leetcode.com/problems/spiral-matrix/
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 * For example,
 * Given the following matrix:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * You should return [1,2,3,6,9,8,7,4,5].
 *
 */
public class SpiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix == null) {
			return null;
		}
		if(matrix.length == 0) {
		    return new ArrayList<Integer>();
		}
		int row = matrix.length;
		int column = matrix[0].length;
		int total = row*column;
		int bottomRow = 0;
		int bottomColumn = 0;
		int count = 0;
		int curRow = 0;
		int curColumn = 0;
		int side = 0;
		List<Integer> list = new ArrayList<>();
		
		while(count < total) {
			list.add(matrix[curRow][curColumn]);
			switch(side) {
				case 0:
					if(curColumn != column-1) {
						curColumn++;
					} else {
						bottomRow++;
						side = 1;
						curRow++;
					}
					break;
				case 1:
					if(curRow != row-1) {
						curRow++;
					} else {
						side = 2;
						curColumn--;
					}
					break;
				case 2:
					if(curColumn != bottomColumn) {
						curColumn--;
					} else {
						side = 3;
						curRow--;
					}
					break;
				case 3:
					if(curRow != bottomRow) {
						curRow--;
					} else {
						side = 0;
						curColumn++;
						row--;
						column--;
						bottomColumn++;
					}
					break;
			}
			count++;
		}
		
		return list;
    }
}
