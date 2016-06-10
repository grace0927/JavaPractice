/**
 * 
 */
package com.javapractice.leetcode;

/**
 * @author Feng
 * https://leetcode.com/problems/game-of-life/
 * According to the Wikipedia's article: "The Game of Life, also known simply as Life, 
 * is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
 * Given a board with m by n cells, each cell has an initial state live (1) or dead (0).
 * Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) 
 * using the following four rules (taken from the above Wikipedia article):
 * Any live cell with fewer than two live neighbors dies, as if caused by under-population.
 * Any live cell with two or three live neighbors lives on to the next generation.
 * Any live cell with more than three live neighbors dies, as if by over-population.
 * Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 * Write a function to compute the next state (after one update) of the board given its current 
 * state.
 * Could you solve it in-place? Remember that the board needs to be updated at the same time: 
 * You cannot update some cells first and then use their updated values to update other cells.
 * In this question, we represent the board using a 2D array. In principle, the board is infinite, 
 * which would cause problems when the active area encroaches the border of the array. 
 * How would you address these problems?
 *
 */
public class GameOfLife {
    public void gameOfLife(int[][] board) {
        int row = board.length;
        int col = board[0].length;
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if(willLive(board, i, j)) {
                    board[i][j] += 2;
                }
            }
        }
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                board[i][j] = (board[i][j]>=2)?1:0;
            }
        }
    }
    
    public boolean willLive(int[][] board, int x, int y) {
        int cnt = 0;
        
        for(int i=-1; i<=1; i++) {
            for(int j=-1; j<=1; j++) {
                cnt += (i==0&&j==0)?0:getVal(board, x+i, y+j);
            }
        }
        
        if((cnt==2&&board[x][y]==1) || cnt==3) {
            return true;
        }
        
        return false;
    }
    
    public int getVal(int[][] board, int x, int y) {
        if(x>=0 && x<board.length && y>=0 && y<board[0].length) {
            if(board[x][y]==1) {
                return 1;
            } else if(board[x][y] > 1) {
                return board[x][y]-2;
            }
        }
        return 0;
    }
    
    public void round4(int[][] board) {
        median(board);
        next(board);
    }
    private void median(int[][] board) {
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if(live(board, i, j)) {
                    board[i][j] += 2;
                }
            }
        }
    }
    private void next(int[][] board) {
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                board[i][j] >>= 1;
            }
        }
    }
    private boolean live(int[][] board, int r, int c) {
        int live = -board[r][c];
        for(int i=-1; i<2; i++) {
            for(int j=-1; j<2; j++) {
                if(r+i>=0 && r+i<board.length && c+j>=0 && c+j<board[0].length) {
                    live += board[r+i][c+j] & 1;
                }
            }
        }
        return (board[r][c]==1&&live==2) || (live==3);
    }
}
