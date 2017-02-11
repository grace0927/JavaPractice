/**
 * 
 */
package com.javapractice.leetcode;

/**
 * @author jianyu
 * https://oj.leetcode.com/problems/dungeon-game/
 * The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon. 
 * The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant knight (K) was initially positioned 
 * in the top-left room and must fight his way through the dungeon to rescue the princess.
 * The knight has an initial health point represented by a positive integer. 
 * If at any point his health point drops to 0 or below, he dies immediately.
 * Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms; 
 * other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).
 * In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.
 * Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.
 * For example, given the dungeon below, the initial health of the knight must be at least 7 if he follows the optimal path RIGHT-> RIGHT -> DOWN -> DOWN.
 * -2 (K)	-3	3
 * -5	-10	1
 * 10	30	-5 (P)
 * Notes:
 * The knight's health has no upper bound.
 * Any room can contain threats or power-ups, even the first room the knight enters and the bottom-right room where the princess is imprisoned.
 * ref: https://oj.leetcode.com/discuss/20721/my-ac-java-version-suggestions-are-welcome
 *
 */
public class DungeonGame {
	public int calculateMinimumHP(int[][] dungeon) {
        int row = dungeon.length;
		int col = dungeon[0].length;
		int[][] hp = new int[row][col];
		
		hp[row-1][col-1] = (dungeon[row-1][col-1]>0)?1:1-dungeon[row-1][col-1];
		for(int i=row-2; i>=0; i--) {
			hp[i][col-1] = Math.max(hp[i+1][col-1]-dungeon[i][col-1],1);
		}
		for(int i=col-2; i>=0; i--) {
			hp[row-1][i] = Math.max(hp[row-1][i+1]-dungeon[row-1][i],1);
		}
		for(int i=row-2; i>=0; i--) {
			for(int j=col-2; j>=0; j--) {
				hp[i][j] = Math.min(Math.max(hp[i+1][j]-dungeon[i][j],1), Math.max(hp[i][j+1]-dungeon[i][j], 1));
			}
		}
		
		return hp[0][0];
    }

}
