/**
 * 
 */
package com.javapractice.lintcode;

/**
 * @author jianyu
 *
 */
public class CompareStrings {
    /**
     * @param A : A string includes Upper Case letters
     * @param B : A string includes Upper Case letter
     * @return :  if string A contains all of the characters in B return true else return false
     */
    public boolean compareStrings(String A, String B) {
        // write your code here
        int lenA = A.length();
        int lenB = B.length();
        int[] arr = new int[26];
        
        for(int i=0; i<lenA; i++) {
            arr[A.charAt(i)-65]++;
        }
        
        for(int i=0; i<lenB; i++) {
            arr[B.charAt(i)-65]--;
        }
        
        for(int i=0; i<26; i++) {
            if(arr[i] < 0) {
                return false;
            }
        }
        
        return true;
    }
}
