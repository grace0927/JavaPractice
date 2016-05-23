/**
 * 
 */
package com.javapractice.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Feng
 * https://leetcode.com/problems/palindrome-pairs/
 * Given a list of unique words. Find all pairs of distinct indices (i, j) in the given list, 
 * so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.
 *
 */
public class PalindromePairs {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> lists = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<words.length; i++) {
            map.put(words[i], i);
        }
        for(int i=0; i<words.length; i++) {
            for(int j=0; j<=words[i].length(); j++) {
                String a = words[i].substring(0, j);
                String b = words[i].substring(j);
                if(valid(a)) {
                    String rev = new StringBuilder(b).reverse().toString();
                    if(map.containsKey(rev) && map.get(rev)!=i) {
                        helper(map.get(rev), i, lists);
                    }
                }
                if(valid(b) && j<words[i].length()) {
                    String rev = new StringBuilder(a).reverse().toString();
                    if(map.containsKey(rev) && map.get(rev)!=i) {
                        helper(i, map.get(rev), lists);
                    }
                }
            }
        }
        return lists;
    }
    
    private void helper(int i, int j, List<List<Integer>> lists) {
        List<Integer> list = new ArrayList<>();
        list.add(i);
        list.add(j);
        lists.add(list);
    }
    
    private boolean valid(String s) {
        int i=0, j=s.length()-1;
        while(i<j) {
            if(s.charAt(i++)!=s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
}
