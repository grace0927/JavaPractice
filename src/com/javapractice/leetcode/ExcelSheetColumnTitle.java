/**
 * 
 */
package com.javapractice.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jianyu
 * https://oj.leetcode.com/problems/excel-sheet-column-title/
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 * For example:
 *     1 -> A
 *     2 -> B
 *     3 -> C
 *     ...
 *     26 -> Z
 *     27 -> AA
 *     28 -> AB 
 *
 */
public class ExcelSheetColumnTitle {
	public String convertToTitle(int n) {
        Queue<Integer> queue = new LinkedList<>();
		while(n > 26) {
			queue.add(n%26);
			n /= 26;
		}
		queue.add(n);
		
		StringBuilder str = new StringBuilder();
		boolean zero = false;
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			if(zero) {
				cur--;
			}
			if(cur == 0) {
				zero = true;
				if(!queue.isEmpty()) {
					str.insert(0, 'Z');
				}
			} else {
				zero = false;
				str.insert(0,(char)(cur+64));
			}
		}
		
		return str.toString();
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
