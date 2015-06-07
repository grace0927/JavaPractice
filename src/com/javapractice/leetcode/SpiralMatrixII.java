/**
 * 
 */
package com.javapractice.leetcode;

/**
 * @author feng
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 * For example,
 * Given n = 3,
 * You should return the following matrix:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 *
 */
public class SpiralMatrixII {
	public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int count = 0;
        int curRow = 0;
        int curCol = 0;
        int maxRow = n;
        int maxCol = n;
        int minRow = 0;
        int minCol = 0;
        int side = 0;
        
        while(count < n*n) {
            res[curRow][curCol] = ++count;
            switch(side) {
                case 0:
                    if(curCol < maxCol-1) {
                        curCol++;
                    } else {
                        curRow++;
                        minRow++;
                        side = 1;
                    }
                    break;
                case 1:
                    if(curRow < maxRow-1) {
                        curRow++;
                    } else {
                        curCol--;
                        maxCol--;
                        side = 2;
                    }
                    break;
                case 2:
                    if(curCol > minCol) {
                        curCol--;
                    } else {
                        curRow--;
                        minCol++;
                        side = 3;
                    }
                    break;
                case 3:
                    if(curRow > minRow) {
                        curRow--;
                    } else {
                        curCol++;
                        maxRow--;
                        side = 0;
                    }
                    break;
            }
        }
        return res;
    }

}
