/**
 * 
 */
package com.javapractice.lintcode;

/**
 * @author jianyu
 * http://www.lintcode.com/en/problem/delete-digits/
 * Given string A representative a positive integer which has N digits, remove any k digits of the number, 
 * the remaining digits are arranged according to the original order to become a new positive integer.
 * Find the smallest integer after remove k digits.
 * N <= 240 and k <= N,
 * Given an integer A = "178542", k = 4
 * return a string "12"
 *
 */
public class DeleteDigits {
    /**
     *@param A: A positive integer which has N digits, A is a string.
     *@param k: Remove k digits.
     *@return: A string
     */
    public String deleteDigits(String A, int k) {
        // write your code here
        int len = A.length();
        if(k>=len) {
        	return "";
        }
        if(k==0) {
            return A;
        }
        char[] min = new char[]{A.charAt(0)};
        int cur = 0;
        for(int i=0; i<k+1; i++) {
            if(A.charAt(i)<min[0]) {
                min[0] = A.charAt(i);
                cur = i;
            } 
        }
        String res = new String(min);
        if(res.equals("0")) {
            res = "";
        }
        return res+deleteDigits(A.substring(cur+1), k-cur);
    }
}
