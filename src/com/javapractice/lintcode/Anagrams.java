/**
 * 
 */
package com.javapractice.lintcode;

/**
 * @author jianyu
 *
 */
public class Anagrams {
    /**
     * @param s: The first string
     * @param b: The second string
     * @return true or false
     */
    public boolean anagram(String s, String t) {
        if(s.equals(t)) {
            return true;
        }
        
        int lenS = s.length();
        int lenT = t.length();
        if(lenS != lenT) {
            return false;
        }
        
        int[] arr = new int[26];
        for(int i=0; i<lenS; i++) {
            arr[s.charAt(i)-97]++;
            arr[t.charAt(i)-97]--;
        }
        
        for(int i=0; i<26; i++) {
            if(arr[i] != 0) {
                return false;
            }
        }
        
        return true;
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Anagrams test = new Anagrams();
		System.out.println(test.anagram("\"abcd\"", "\"aabd\""));

	}

}
