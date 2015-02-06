/**
 * 
 */
package com.javapractice.leetcode;

/**
 * @author jianyu
 * https://oj.leetcode.com/problems/add-binary/
 * Given two binary strings, return their sum (also a binary string).
 * For example,
 * a = "11"
 * b = "1"
 * Return "100".
 *
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        int lenA = a.length();
		int lenB = b.length();
		boolean exceed = false;
		StringBuilder result = new StringBuilder();
		
		while(lenA>0 && lenB>0) {
			int curA = a.charAt(lenA-1)-48;
			int curB = b.charAt(lenB-1)-48;
			int cur = curA+curB;
			
			if(exceed) {
				cur += 1;
			}
			
			lenA--;
			lenB--;
			
			switch(cur) {
				case 0:
					result.insert(0, '0');
					exceed = false;
					break;
				case 1:
					result.insert(0, '1');
					exceed = false;
					break;
				case 2:
					result.insert(0, '0');
					exceed = true;
					break;
				case 3:
					result.insert(0, '1');
					exceed = true;
					break;
			}
		}
		
		if(lenA != 0 || lenB != 0) {
			int len = (lenA>lenB)?lenA:lenB;
			while(len>0) {
				int cur = (lenA>lenB)?(a.charAt(len-1)-48):(b.charAt(len-1)-48);
				
				if(exceed) {
					cur += 1;
				}
				len--;
				
				switch(cur) {
					case 0:
						result.insert(0, '0');
						exceed = false;
						break;
					case 1:
						result.insert(0, '1');
						exceed = false;
						break;
					case 2:
						result.insert(0, '0');
						exceed = true;
						break;
				}
			}	
		}
		
		if(exceed) {
			result.insert(0, '1');
		}
		
		return result.toString();
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
