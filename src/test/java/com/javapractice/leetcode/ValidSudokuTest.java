/**
 *
 */
package com.javapractice.leetcode;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Jianyu Feng
 *
 */
public class ValidSudokuTest {
	@Test
	public void testFunctionName() {
        ValidSudoku test = new ValidSudoku();
		char[][] graph = {
			{0,8,7,6,5,4,3,2,1},
            {2,0,0,0,0,0,0,0,0},
            {3,0,0,0,0,0,0,0,0},
            {4,0,0,0,0,0,0,0,0},
            {5,0,0,0,0,0,0,0,0},
            {6,0,0,0,0,0,0,0,0},
            {7,0,0,0,0,0,0,0,0},
            {8,0,0,0,0,0,0,0,0},
            {9,0,0,0,0,0,0,0,0}
        };

        assertTrue( test.isValidSudoku( graph ) );
	}
}
