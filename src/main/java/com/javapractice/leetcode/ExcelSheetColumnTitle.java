/**
 *
 */
package com.javapractice.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Jianyu Feng
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

	public String convertToTitleRecursive(int n) {
		if (n<=26) {
			return n==0 ? "Z" : ""+(char)('A'+n-1);
		}

		return convertToTitle((n-1)/26) + convertToTitle(n%26);
	}
}
