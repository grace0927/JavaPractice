/**
 * 
 */
package com.javapractice.lintcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

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
     * @param strs: A list of strings
     * @return: A list of strings
     */
    public List<String> anagrams(String[] strs) {
        // write your code here
        List<String> res = new ArrayList<>();
        HashMap<String, String> map = new HashMap<>();
        
        for(int i=0; i<strs.length; i++) {
            int[] row = new int[26];
            for(int j=0; j<strs[i].length(); j++) {
                row[(strs[i].charAt(j)-97)]++;
            }
            String key = Arrays.toString(row);
            if(map.containsKey(key)) {
                if(!res.contains(map.get(key))) {
                    res.add(map.get(key));
                }
                res.add(strs[i]);
            } else {
                map.put(key, strs[i]);
            }
        }
        
        return res;
    }

}
