/**
 * 
 */
package com.javapractice.leetcode;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author jianyu
 * https://oj.leetcode.com/problems/valid-sudoku/
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 * Note:
 * A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
 *
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        if(board == null) {
			return false;
		}
		int row = board.length;
		int column = board[0].length;
		if(row != 9 || column != 9) {
			return false;
		}
		
		ArrayList<HashMap<Character, Character>> columnCache = new ArrayList<>();
		ArrayList<HashMap<Character, Character>> rowCache = new ArrayList<>();
		for(int i=0; i<column; i++) {
		    HashMap<Character, Character> cache = new HashMap<>();
		    columnCache.add(cache);
		}
		for(int i=0; i<row; i++) {
		    HashMap<Character, Character> cache = new HashMap<>();
		    rowCache.add(cache);
		}
		
		for(int i=0; i<row; i++) {
			for(int j=0; j<column; j++) {
				Character temp = board[i][j];
				
				if(temp != '.') {
					if(columnCache.get(j).containsKey(temp) || rowCache.get(i).containsKey(temp)) {
						return false;
					} else {
						columnCache.get(j).put(temp, temp);
						rowCache.get(i).put(temp, temp);
					}
				}
			}
		}
		for(int i=0; i<row; i++) {
			for(int j=0; j<column; j++) {
				Character temp = board[i][j];
				
				if(temp != '.') {
					switch(j%3) {
						case 0:
					        switch(i%3) {
						        case 0:
						        	if(board[i+1][j+1] == temp || board[i+2][j+1] == temp || board[i+1][j+2] == temp || board[i+2][j+2] == temp) {
						    		return false;
						           	}
						        	break;
					        	case 1:
					        		if(board[i-1][j+1] == temp || board[i+1][j+1] == temp || board[i-1][j+2] == temp || board[i+1][j+2] == temp) {
							        	return false;
							        }
							        break;
						        case 2: 
							        if(board[i-1][j+1] == temp || board[i-1][j+1] == temp || board[i-2][j+2] == temp || board[i-2][j+2] == temp) {
								        return false;
							        }
							        break;
        					}
        					break;
						case 1:
					        switch(i%3) {
						        case 0:
						        	if(board[i+1][j-1] == temp || board[i+2][j-1] == temp || board[i+1][j+1] == temp || board[i+2][j+1] == temp) {
						    		return false;
						           	}
						        	break;
					        	case 1:
					        		if(board[i-1][j+1] == temp || board[i+1][j+1] == temp || board[i-1][j-1] == temp || board[i+1][j-1] == temp) {
							        	return false;
							        }
							        break;
						        case 2: 
							        if(board[i-1][j-1] == temp || board[i-1][j+1] == temp || board[i-2][j-1] == temp || board[i-2][j+1] == temp) {
								        return false;
							        }
							        break;
        					}
        					break;
						case 2:
					        switch(i%3) {
						        case 0:
						        	if(board[i+1][j-2] == temp || board[i+1][j-1] == temp || board[i+2][j-2] == temp || board[i+2][j-1] == temp) {
						    		return false;
						           	}
						        	break;
					        	case 1:
					        		if(board[i-1][j-2] == temp || board[i-1][j-1] == temp || board[i+1][j-2] == temp || board[i+1][j-1] == temp) {
							        	return false;
							        }
							        break;
						        case 2: 
							        if(board[i-1][j-2] == temp || board[i-1][j-1] == temp || board[i-2][j-2] == temp || board[i-2][j-1] == temp) {
								        return false;
							        }
							        break;
        					}
        					break;
					}
				}
			}
		}
		return true;
    }
    
    // https://oj.leetcode.com/discuss/9216/my-solution-for-your-reference
    public boolean isValidSudokuAlternate(char[][] board) {
        if (board.length!=9||board[0].length!=9) {
        	return false;
        }

        int[] row= new int[9];
        int[] col= new int[9];
        int[] sqr= new int[9];   

        for (int i=0;i<9;i++){
        	for (int j=0;j<9;j++){
        		if (board[i][j]!='.') {
                    int num = board[i][j]-'0';
                    if ((row[i]&1<<num)>0) {
                    	return false;
                    } else {
                    	row[i]|=1<<num;
                    }

                    if ((col[j]&1<<num)>0) {
                    	return false;
                    } else {
                    	col[j]|=1<<num;
                    }

                    int sqr_num=(i-i%3)+j/3;
                    if ((sqr[sqr_num]&1<<num)>0) {
                    	return false;
                    } else {
                    	sqr[sqr_num]|=1<<num;
                    }
                }
            }
        }
        return true;
    }
}
