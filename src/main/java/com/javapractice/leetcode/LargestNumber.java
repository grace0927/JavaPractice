/**
 * 
 */
package com.javapractice.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author jianyu
 * https://leetcode.com/problems/largest-number/
 * Given a list of non negative integers, arrange them such that they form the largest number.
 * For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 * Note: The result may be very large, so you need to return a string instead of an integer.
 *
 */
public class LargestNumber {
	/*
	 * ref: https://leetcode.com/discuss/21683/a-simple-c-solution
	 * http://docs.oracle.com/javase/7/docs/api/java/util/Comparator.html
	 */
	public String largestNumber(int[] num) {
        int len = num.length;
		String[] arr = new String[len];
		for(int i=0; i<len; i++) {
			arr[i] = ""+num[i];
		}
		Arrays.sort(arr, new Comparator<String>(){
			@Override
			public int compare(String s1, String s2) {
				return (s1+s2).compareTo(s2+s1);
			}
		});
		
		if(arr[len-1].equals("0")) {
			return "0";
		}
		
		String res = "";
		for(int i=len-1; i>=0; i--) {
			res += arr[i];
		}
		
		return res;
    }
	
	/*
	 * the same idea I came out firstly
	 * ref: http://blog.xiaohuahua.org/2015/01/13/leetcode-largest-number/
	 */
	public String largestNumberAlter(int[] num) {
		// to be implemented
        return "";
    }
}
