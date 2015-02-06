/**
 * 
 */
package com.javapractice.LeetCode;

import java.util.Stack;

/**
 * @author jianyu
 * https://oj.leetcode.com/problems/maximal-rectangle/
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area.
 *
 */
public class MaximalRectangle {
	public int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        if(row <= 0) {
            return 0;
        }
		int column = matrix[0].length;
		int area = 0;
		int[] cur = new int[column];
		
		for(int i=0; i<row; i++) {
			for(int j=0; j<column; j++) {
				if(i == 0) {
					cur[j] = matrix[0][j]-48;
				} else {
					if(matrix[i][j] == 48) {
						cur[j] = 0;
					} else {
						cur[j]++;
					}
				}
			}
			area = Math.max(area, largestRectangleArea(cur));
		}
		
		return area;
    }
    
    public int largestRectangleArea(int[] height) {
        if(height.length < 1) {
            return 0;
        }
        
        Stack<Integer> histogram = new Stack<>();
        int max = height[0];
        histogram.push(0);
        int i = 0;
        for(i=1; i<height.length; i++) {
            int cur = height[i];
            while((!histogram.empty()) && cur < height[histogram.peek()]) {
                int temp = height[histogram.pop()];
                int width = histogram.empty()?i:i-histogram.peek()-1;
                max = Math.max(temp*width, max);
                width++;
            }
            histogram.push(i);
        }
        
        while(!histogram.empty()) {
            int temp = height[histogram.pop()];
            int width = histogram.empty()?i:i-histogram.peek()-1;
            max = Math.max(temp*width, max);
            width++;
        }
        
        return max;
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

}
