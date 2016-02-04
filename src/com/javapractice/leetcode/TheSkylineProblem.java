/**
 * 
 */
package com.javapractice.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Feng
 * https://leetcode.com/problems/the-skyline-problem/
 * A city's skyline is the outer contour of the silhouette formed 
 * by all the buildings in that city when viewed from a distance. 
 * Now suppose you are given the locations and height of all the buildings 
 * as shown on a cityscape photo (Figure A), write a program to output 
 * the skyline formed by these buildings collectively (Figure B).
 * Buildings  Skyline Contour
 * The geometric information of each building is represented by a triplet of 
 * integers [Li, Ri, Hi], where Li and Ri are the x coordinates of the left 
 * and right edge of the ith building, respectively, and Hi is its height. 
 * It is guaranteed that 0 ≤ Li, Ri ≤ INT_MAX, 0 < Hi ≤ INT_MAX, and Ri - Li > 0. 
 * You may assume all buildings are perfect rectangles grounded on an absolutely flat surface 
 * at height 0.
 * For instance, the dimensions of all buildings in Figure A are recorded as: 
 * [ [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ] .
 * The output is a list of "key points" (red dots in Figure B) in the format of 
 * [ [x1,y1], [x2, y2], [x3, y3], ... ] that uniquely defines a skyline. 
 * A key point is the left endpoint of a horizontal line segment. 
 * Note that the last key point, where the rightmost building ends, 
 * is merely used to mark the termination of the skyline, and always has zero height. 
 * Also, the ground in between any two adjacent buildings should be considered part of 
 * the skyline contour.
 * For instance, the skyline in Figure B should be represented as:
 * [ [2 10], [3 15], [7 12], [12 0], [15 10], [20 8], [24, 0] ].
 * Notes:
 * The number of buildings in any input list is guaranteed to be in the range [0, 10000].
 * The input list is already sorted in ascending order by the left x position Li.
 * The output list must be sorted by the x position.
 * There must be no consecutive horizontal lines of equal height in the output skyline. 
 * For instance, [...[2 3], [4 5], [7 5], [11 5], [12 7]...] is not acceptable; 
 * the three lines of height 5 should be merged into one in the final output as such: 
 * [...[2 3], [4 5], [12 7], ...]
 * ref: http://www.geeksforgeeks.org/divide-and-conquer-set-7-the-skyline-problem/
 *
 */
public class TheSkylineProblem {
    public List<int[]> getSkyline(int[][] buildings) {
        if(buildings.length==0) {
            return new ArrayList<int[]>();
        }
        return helper(buildings, 0, buildings.length);
    }
    
    public List<int[]> helper(int[][] buildings, int start, int end) {
        if(start<end-1) {
            int mid = start + (end-start)/2;
            return merge(helper(buildings, start, mid), helper(buildings, mid, end));
        }
        List<int[]> res = new ArrayList<>();
        res.add(new int[]{buildings[start][0], buildings[start][2]});
        res.add(new int[]{buildings[start][1], 0});
        return res;
    }
    
    public List<int[]> merge(List<int[]> l1, List<int[]> l2) {
        List<int[]> res = new ArrayList<>();
        int h1=0,h2=0;
        
        while(l1.size()>0 && l2.size()>0) {
            int x1 = l1.get(0)[0];
            int x2 = l2.get(0)[0];
            int h=0,x=0;
            if(x1>x2) {
                h2 = l2.get(0)[1];
                h = Math.max(h1, h2);
                x = x2;
                l2.remove(0);
            } else if(x1<x2) {
                h1 = l1.get(0)[1];
                h = Math.max(h1, h2);
                x = x1;
                l1.remove(0);
            } else {
                h1 = l1.get(0)[1];
                h2 = l2.get(0)[1];
                h = Math.max(h1,h2);
                x = x1;
                l1.remove(0);
                l2.remove(0);
            }
            if(res.size()==0 || res.get(res.size()-1)[1]!=h) {
                res.add(new int[]{x, h});
            }
        }
        res.addAll(l1);
        res.addAll(l2);
        
        return res;
    }
}