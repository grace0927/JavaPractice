/**
 * 
 */
package com.javapractice.leetcode;

import java.util.Stack;

/**
 * @author feng
 * https://oj.leetcode.com/problems/largest-rectangle-in-histogram/
 * Given n non-negative integers representing the histogram's bar 
 * height where the width of each bar is 1, find the area of largest rectangle in the histogram.
 * For example,
 * Given height = [2,1,5,6,2,3],
 * return 10.
 *
 */
public class LargestRectangleInHistogram {
	// ref: http://www.geeksforgeeks.org/largest-rectangle-under-histogram/
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
	
	// ref: http://www.geeksforgeeks.org/largest-rectangular-area-in-a-histogram-set-1/
	public int largestRectangleAreaDC(int[] height) {
        // to be implemented
		return 0;
    }
}
