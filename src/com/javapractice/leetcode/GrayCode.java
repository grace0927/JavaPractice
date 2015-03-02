/**
 * 
 */
package com.javapractice.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jianyu
 * 
 * https://oj.leetcode.com/problems/gray-code/
 * 
 * The gray code is a binary numeral system where two successive values differ in only one bit.
 * Given a non-negative integer n representing the total number of bits in the code, print the 
 * sequence of gray code. A gray code sequence must begin with 0.
 * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
 * 00 - 0 
 * 01 - 1
 * 11 - 3
 * 10 - 2
 * Note:
 * For a given n, a gray code sequence is not uniquely defined.
 * For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.
 * For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.
 * ref: http://blog.csdn.net/u010500263/article/details/18209669
 * 
 */
public class GrayCode {
	public List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>();
		list.add(0);
		
		for(int i=0; i<n; i++) {
			int cur = 1<<i;
			for(int j=list.size()-1; j>=0; j--) {
				list.add(list.get(j)+cur);
			}
		}
		
		return list;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
