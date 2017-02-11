/**
 * 
 */
package com.javapractice.leetcode;

/**
 * @author jianyu
 * https://leetcode.com/problems/rectangle-area/
 * Find the total area covered by two rectilinear rectangles in a 2D plane.
 * Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.
 * Assume that the total area is never beyond the maximum possible value of int.
 *
 */
public class RectangleArea {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area = (D-B)*(C-A) + (G-E)*(H-F);
        if(E>C || A>G || F>D || B>H) {
            return area;
        }
        
        int leftX = Math.max(A, E);
        int rightX = Math.min(C, G);
        int downY = Math.max(B, F);
        int upY = Math.min(D, H);
        int overlap = (rightX - leftX) * (upY - downY);
        
        return area - overlap;
    }
}
