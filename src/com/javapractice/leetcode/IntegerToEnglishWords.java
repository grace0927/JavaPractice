/**
 * 
 */
package com.javapractice.leetcode;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author feng
 * https://leetcode.com/problems/integer-to-english-words/
 * Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1.
 * For example,
 * 123 -> "One Hundred Twenty Three"
 * 12345 -> "Twelve Thousand Three Hundred Forty Five"
 * 1234567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 *
 */
public class IntegerToEnglishWords {
    public String numberToWords(int num) {
        if(num == 0) {
            return "Zero";
        }
        HashMap<Integer, String> map = new HashMap<>();
        map.put(0, "Zero");
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");
        map.put(4, "Four");
        map.put(5, "Five");
        map.put(6, "Six");
        map.put(7, "Seven");
        map.put(8, "Eight");
        map.put(9, "Nine");
        map.put(10, "Ten");
        map.put(11, "Eleven");
        map.put(12, "Twelve");
        map.put(13, "Thirteen");
        map.put(14, "Fourteen");
        map.put(15, "Fifteen");
        map.put(16, "Sixteen");
        map.put(17, "Seventeen");
        map.put(18, "Eighteen");
        map.put(19, "Nineteen");
        map.put(20, "Twenty");
        map.put(30, "Thirty");
        map.put(40, "Forty");
        map.put(50, "Fifty");
        map.put(60, "Sixty");
        map.put(70, "Seventy");
        map.put(80, "Eighty");
        map.put(90, "Ninety");
        
        HashMap<Integer,String> stage = new HashMap<>();
        stage.put(3, "Thousand");
        stage.put(6, "Million");
        stage.put(9, "Billion");
        stage.put(12, "Trillion");
        stage.put(15, "Pillion");
        
        Stack<Integer> stack = new Stack<>();
        
        while(num >= 10) {
            stack.push(num%10);
            num /= 10;
        }
        stack.add(num);
        StringBuilder str = new StringBuilder();
        int last = 0;
        
        while(!stack.isEmpty()) {
            int cur = stack.pop();
            int level = (stack.size()+1)%3;
            switch(level) {
                case 0:
                    if(cur != 0) {
                        str.append(" ");
                        str.append(map.get(cur));
                        str.append(" Hundred");
                    }
                    last = cur;
                    break;
                case 1:
                    if(cur != 0) {
                        str.append(" ");
                        str.append(map.get(cur));
                    }
                    last = last*10+cur;
                    break;
                case 2:
                    if(cur==1) {
                        str.append(" ");
                        str.append(map.get(cur*10+stack.pop()));
                    } else if(cur>1) {
                        str.append(" ");
                        str.append(map.get(cur*10));
                    }
                    last = last*10+cur;
                    break;
            }
            if(stage.containsKey(stack.size())) {
                if(last != 0) {
                    str.append(" ");
                    str.append(stage.get(stack.size()));
                }
                last = 0;
            }
        }
        str.deleteCharAt(0);
        
        return str.toString();
    }
}
