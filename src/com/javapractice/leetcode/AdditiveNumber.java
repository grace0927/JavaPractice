/**
 * 
 */
package com.javapractice.leetcode;

/**
 * @author feng
 * https://leetcode.com/problems/additive-number/
 * Additive number is a string whose digits can form additive sequence.
 * A valid additive sequence should contain at least three numbers. 
 * Except for the first two numbers, each subsequent number 
 * in the sequence must be the sum of the preceding two.
 * For example:
 * "112358" is an additive number because the digits can form an additive sequence: 1, 1, 2, 3, 5, 8.
 * 1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
 * "199100199" is also an additive number, the additive sequence is: 1, 99, 100, 199.
 * 1 + 99 = 100, 99 + 100 = 199
 * Note: Numbers in the additive sequence cannot have leading zeros, 
 * so sequence 1, 2, 03 or 1, 02, 3 is invalid.
 * Given a string containing only digits '0'-'9', 
 * write a function to determine if it's an additive number.
 * Follow up:
 * How would you handle overflow for very large input integers?
 *
 */
public class AdditiveNumber implements Solution {
	@Override
	public void test() {
		AdditiveNumber test = new AdditiveNumber();
    	System.out.println(test.isAdditiveNumber("112358"));
	}
	
	public boolean isAdditiveNumber(String num) {
        int len = num.length();
        
        for(int i=1; i<len/2+1; i++) {
            long one = Long.parseLong(num.substring(0, i));
            for(int j=i+1; j<len; j++) {
                if(num.charAt(i)=='0' && j>i+1) {
                    continue;
                }
                long two = Long.parseLong(num.substring(i, j));
                long res = one+two;
                StringBuilder sb = new StringBuilder();
                sb.append(res);
                if(sb.length()<=len-j && sb.toString().equals(num.substring(j,j+sb.length()))) {
                    if(sb.length()==len-j || gen(len, one, two, num)) {
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
    
    public boolean gen(int len, long one, long two, String num) {
        StringBuilder sb = new StringBuilder();
        sb.append(one);
        sb.append(two);
        while(sb.length()<len) {
            long res = one+two;
            sb.append(res);
            one = two;
            two = res;
        }
        return sb.toString().equals(num);
    }
}