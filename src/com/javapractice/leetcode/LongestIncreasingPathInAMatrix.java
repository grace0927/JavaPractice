/**
 * 
 */
package com.javapractice.leetcode;

/**
 * @author Feng
 * https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
 * Given an integer matrix, find the length of the longest increasing path.
 * From each cell, you can either move to four directions: left, right, up or down. 
 * You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).
 * Example 1:
 * nums = [
 * 	[9,9,4],
 *  [6,6,8],
 *  [2,1,1]
 * ]
 * Return 4
 * The longest increasing path is [1, 2, 6, 9].
 * 
 * Example 2:
 * nums = [
 *  [3,4,5],
 *  [3,2,6],
 *  [2,2,1]
 * ]
 * Return 4
 * The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
 *
 */
public class LongestIncreasingPathInAMatrix {
    public int longestIncreasingPath(int[][] matrix) {
        int max = 0;
        int row = matrix.length;
        if(row<=0) {
            return max;
        }
        int col = matrix[0].length;
        boolean[][] visit = new boolean[row][col];
        int[][] path = new int[row][col];
        
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                if(!visit[i][j]) {
                    max = Math.max(max, findPath(matrix, i, j, visit, path));
                }
            }
        }
        
        return max;
    }
    
    public int findPath(int[][] matrix, int x, int y, boolean[][] visit, int[][] path) {
        visit[x][y] = true;
        int max = 0;
        if(y+1<matrix[0].length && matrix[x][y] < matrix[x][y+1]) {
            if(path[x][y+1] == 0) {
                path[x][y+1] = findPath(matrix, x, y+1, visit, path);
            }
            max = Math.max(max, path[x][y+1]);
        }
        if(x+1<matrix.length && matrix[x][y] < matrix[x+1][y]) {
            if(path[x+1][y] == 0) {
                path[x+1][y] = findPath(matrix, x+1, y, visit, path);
            }
            max = Math.max(max, path[x+1][y]);
        }
        if(y-1>=0 && matrix[x][y] < matrix[x][y-1]) {
            if(path[x][y-1] == 0) {
                path[x][y-1] = findPath(matrix, x, y-1, visit, path);
            }
            max = Math.max(max, path[x][y-1]);
        }
        if(x-1>=0 && matrix[x][y] < matrix[x-1][y]) {
            if(path[x-1][y] == 0) {
                path[x-1][y] = findPath(matrix, x-1, y, visit, path);
            }
            max = Math.max(max, path[x-1][y]);
        }
        path[x][y] = max+1;
        return max+1;
    }
}
