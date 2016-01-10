/**
 * 
 */
package com.javapractice.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author feng
 * https://leetcode.com/problems/word-pattern/
 * Given a pattern and a string str, find if str follows the same pattern.
 * Here follow means a full match, such that there is a bijection between a 
 * letter in pattern and a non-empty word in str.
 * Examples:
 * pattern = "abba", str = "dog cat cat dog" should return true.
 * pattern = "abba", str = "dog cat cat fish" should return false.
 * pattern = "aaaa", str = "dog cat cat dog" should return false.
 * pattern = "abba", str = "dog dog dog dog" should return false.
 * You may assume pattern contains only lowercase letters, 
 * and str contains lowercase letters separated by a single space.
 *
 */
public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        HashMap<Character, String> cs = new HashMap<>();
        HashMap<String, Character> sc = new HashMap<>();
        String[] arr = cutStr(str);
        if(arr.length != pattern.length()) {
            return false;
        }
        
        for(int i=0; i<pattern.length(); i++) {
            Character key = pattern.charAt(i);
            String val = arr[i];
            if(!cs.containsKey(key)) {
                cs.put(key, val);
            }
            if(!sc.containsKey(val)) {
                sc.put(val, key);
            }
            if((!cs.get(key).equals(val)) || (sc.get(val)!=key)) {
                return false;
            }
        }
        
        return true;
    }
    
    public String[] cutStr(String str) {
        StringBuilder sb = new StringBuilder();
        ArrayList<String> list = new ArrayList<>();
        
        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i)==' ') {
                list.add(sb.toString());
                sb = new StringBuilder();
            } else {
                sb.append(str.charAt(i));
            }
        }
        list.add(sb.toString());
        
        return list.toArray(new String[list.size()]);
    }
    
    /*
     * ref: https://leetcode.com/discuss/62374/9-lines-simple-java?show=62383#a62383
     * use put function having return old value
     */
    public boolean wordPatternOp(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length())
            return false;
        Map<Object, Integer> index = new HashMap<>();
        for (Integer i=0; i<words.length; ++i)
            if (index.put(pattern.charAt(i), i) != index.put(words[i], i))
                return false;
        return true;
    }
}
