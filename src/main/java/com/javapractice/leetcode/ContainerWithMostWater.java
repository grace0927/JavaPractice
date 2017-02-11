/**
 * 
 */
package com.javapractice.leetcode;

/**
 * @author jianyu
 * https://oj.leetcode.com/problems/container-with-most-water/
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). 
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and 
 * (i, 0). Find two lines, which together with x-axis forms a container, such that the container 
 * contains the most water.
 * Note: You may not slant the container.
 *
 */
public class ContainerWithMostWater {
	
    public int maxArea(int[] height) {
        if(height == null) {
        	// special case
            return 0;
        } else if(height.length == 0) {
        	// special case
            return 0;
        }
        
        // parameters initialization
        int max = 0;
        int start = 0;
        int end = height.length - 1;
        
        while(start < end) {
            if(height[start] > height[end]) {
            	// case 1
                int space = height[end] * (end-start);
                max = (space>max)?space:max;
                end--;
            } else {
            	// case 2
                int space = height[start] * (end-start);
                max = (space>max)?space:max;
                start++;
            }
        }
        
        return max;
    }
    
    public int maxAreaFaster(int[] height) {
        if(height == null) {
            return 0;
        } else if(height.length == 0) {
            return 0;
        }
        
        int max = 0;
        int start = 0;
        int end = height.length - 1;
        
        while(start < end) {
            if(height[start] > height[end]) {
                int space = height[end] * (end-start);
                max = (space>max)?space:max;
                int now = height[end];
                do {
                    end--;
                } while(height[end] < now && end > start);
            } else {
                int space = height[start] * (end-start);
                max = (space>max)?space:max;
                int now = height[start];
                do {
                    start++;
                } while(height[start] < now && end > start);
            }
        }
        
        return max;
    }
}
