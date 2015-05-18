/**
 * 
 */
package com.javapractice.lintcode;

/**
 * @author jianyu
 *
 */
public class StrStr {
    /**
     * Returns a index to the first occurrence of target in source,
     * or -1  if target is not part of source.
     * @param source string to be scanned.
     * @param target string containing the sequence of characters to match.
     */
    public int strStr(String source, String target) {
        //write your code here
        if(source == null || target == null) {
            return -1;
        }
        int lenT = target.length();
        int lenS = source.length();
        
        for(int i=0; i<=lenS-lenT; i++) {
            if(target.equals(source.substring(i, i+lenT))) {
                return i;
            }
        }
        return -1;
    }
}
