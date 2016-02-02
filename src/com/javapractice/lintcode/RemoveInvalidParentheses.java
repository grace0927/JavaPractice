/**
 * 
 */
package com.javapractice.lintcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author Feng
 * Remove the minimum number of invalid parentheses in order to make the input string valid. 
 * Return all possible results.
 * Note: The input string may contain letters other than the parentheses ( and ).
 * Examples:
 * "()())()" -> ["()()()", "(())()"]
 * "(a)())()" -> ["(a)()()", "(a())()"]
 * ")(" -> [""]
 *
 */
public class RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        if(isValid(s)) {
            res.add(s);
            return res;
        }
        HashSet<String> set = new HashSet<>();
        set.add(s);
        helper(res, set);
        
        return res;
    }
    
    public void helper(List<String> list, HashSet<String> set) {
        if(set.size()==0) {
            return ;
        }
        
        HashSet<String> newSet = new HashSet<>();
        boolean flag = false;
        for(String str:set) {
            for(int i=0; i<str.length(); i++) {
                String tmp = str.substring(0,i) + str.substring(i+1, str.length());
                if(isValid(tmp)) {
                    flag = true;
                    if(!list.contains(tmp)) {
                        list.add(tmp);
                    }
                }
                newSet.add(tmp);
            }
        }
        if(!flag) {
            helper(list, newSet);
        }
    }
    
    public boolean isValid(String str) {
        int val = 0;
        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i)=='(') {
                val++;
            } else if(str.charAt(i)==')') {
                val--;
            }
            if(val<0) {
                return false;
            }
        }
        
        return (val==0);
    }
}
