/**
 * 
 */
package com.javapractice.lintcode;

/**
 * @author jianyu
 * http://www.lintcode.com/en/problem/longest-common-prefix/
 * Given k strings, find the longest common prefix (LCP).
 * Example
 * For strings "ABCD", "ABEF" and "ACEF", the LCP is "A"
 * For strings "ABCDEFG", "ABCEFG" and "ABCEFA", the LCP is "ABC"
 *
 */
public class LongestCommonPrefix {
    /**
     * @param strs: A list of strings
     * @return: The longest common prefix
     */
    public String longestCommonPrefix(String[] strs) {
        // write your code here
        int len = strs.length;
        if(len == 0) {
            return "";
        }
        
        String res = strs[0];
        int max = res.length();
        for(int i=1; i<len; i++) {
            max = (strs[i].length()>max)?max:strs[i].length();
            while(!strs[i].substring(0, max).equals(res.substring(0,max))) {
                max--;
                if(max < 0){
                    return "";
                }
            }
            res = res.substring(0, max);
        }
        
        return res;
    }
}
