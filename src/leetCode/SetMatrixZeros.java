/**
 * 
 */
package leetCode;

import java.util.Stack;

/**
 * @author jianyu
 * https://oj.leetcode.com/problems/set-matrix-zeroes/
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
 * Follow up:
 * Did you use extra space?
 * A straight forward solution using O(mn) space is probably a bad idea.
 * A simple improvement uses O(m + n) space, but still not the best solution.
 * Could you devise a constant space solution?
 *
 */
public class SetMatrixZeros {
    public void setZeroes(int[][] matrix) {
        if(matrix == null || matrix.length == 0) {
			return ;
		}
		
        Stack<Integer> rowMark = new Stack<>();
		Stack<Integer> columnMark = new Stack<>();
		
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[0].length; j++) {
				if(matrix[i][j] == 0) {
					rowMark.add(i);
					columnMark.add(j);
				}
			}
		}
		
		while(!rowMark.isEmpty()) {
			int current = rowMark.pop();
			for(int i=0; i<matrix[0].length; i++) {
				matrix[current][i] = 0;
			}
		}
		
		while(!columnMark.isEmpty()) {
			int current = columnMark.pop();
			for(int i=0; i<matrix.length; i++) {
				matrix[i][current] = 0;
			}
		}
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
