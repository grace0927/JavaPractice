/**
 * 
 */
package com.javapractice.lintcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author jianyu
 * http://www.lintcode.com/en/problem/largest-number/
 * Given a list of non negative integers, arrange them such that they form the largest number.
 * Given [1, 20, 23, 4, 8], the largest formed number is 8423201.
 * The result may be very large, so you need to return a string instead of an integer.
 *
 */
public class LargestNumber {
    /**
     *@param num: A list of non negative integers
     *@return: A string
     */
    public String largestNumber(int[] num) {
        // write your code here
        int len = num.length;
        String[] res = new String[len];
        for(int i=0; i<len; i++) {
            res[i] = String.valueOf(num[i]);
        }
        
        Arrays.sort(res, new Comparator<String>() {
           public int compare(String one, String two) {
               String left = one+two;
               String right = two+one;
               return -left.compareTo(right);
           }
        });
        
        StringBuilder result = new StringBuilder();
        for(String i:res) {
            result.append(i);
        }
        
        while(result.charAt(0)=='0' && result.length()>1) {
            result.deleteCharAt(0);
        }
        
        return result.toString();
    }
}
