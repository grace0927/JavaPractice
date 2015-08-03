/**
 * 
 */
package com.javapractice.lintcode;

/**
 * @author jianyu
 * http://www.lintcode.com/en/problem/largest-rectangle-in-histogram/
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, 
 * find the area of largest rectangle in the histogram.
 * Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
 * The largest rectangle is shown in the shaded area, which has area = 10 unit.
 * Given height = [2,1,5,6,2,3],
 * return 10.
 *
 */
public class LargestRectangleInHistogram {
    /**
     * @param height: A list of integer
     * @return: The area of largest rectangle in the histogram
     */
    public int largestRectangleArea(int[] height) {
        // write your code here
		int max = 0;
		
		for(int i=0; i<height.length; i++) {
			int cur = height[i];
			int area = cur;
			for(int j=i+1; j<height.length; j++) {
				if(height[j] >= cur) {
					area += cur;
				} else {
					break;
				}
			}
			for(int j=i-1; j>=0; j--) {
				if(height[j] >= cur) {
					area += cur;
				} else {
					break;
				}
			}
			max = (max>area)?max:area;
		}
		
		return max;
    }
}
