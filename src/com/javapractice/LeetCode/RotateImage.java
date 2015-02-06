/**
 * 
 */
package com.javapractice.leetcode;

/**
 * @author jianyu
 * 
 * https://oj.leetcode.com/problems/rotate-image/
 * You are given an n x n 2D matrix representing an image.
 * Rotate the image by 90 degrees (clockwise).
 * Follow up:
 * Could you do this in-place?
 *
 */
public class RotateImage {
	
    public void rotate(int[][] matrix) {
        if(matrix.length == 0) {
            // special case 1: 0 by 0
            return ;
        } else if(matrix.length == 1) {
            // special case 2: 1 by 1
            return ;
        }
		
		int end = matrix.length-1;
		int start = 0;
		while(end > start) {
			for(int i=start; i<end; i++) {
				int temp = matrix[start][i];
				matrix[start][i] = matrix[end-i+start][start];
				matrix[end-i+start][start] = matrix[end][end-i+start];
				matrix[end][end-i+start] = matrix[i][end];
				matrix[i][end] = temp;
			}
			start++;
			end--;
		}
		return ;
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
