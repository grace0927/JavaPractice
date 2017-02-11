/**
 * 
 */
package com.javapractice.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author feng
 * https://leetcode.com/problems/expression-add-operators/
 * Given a string that contains only digits 0-9 and a target value, 
 * return all possibilities to add binary operators (not unary) +, -, or * 
 * between the digits so they evaluate to the target value.
 * Examples:
 * "123", 6 -> ["1+2+3", "1*2*3"]
 * "232", 8 -> ["2*3+2", "2+3*2"]
 * "105", 5 -> ["1*0+5","10-5"]
 * "00", 0 -> ["0+0", "0-0", "0*0"]
 * "3456237490", 9191 -> []
 *
 */
public class ExpressionAddOperators {
    public List<String> addOperators(String num, int target) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        
        for(int i=1; i<=num.length(); i++) {
            if(num.charAt(0)=='0' && i>1) {
                break;
            }
            long cur = Long.parseLong(num.substring(0, i));
            helper(list, sb.append(cur), num, target, i, cur, cur);
            sb.delete(0,sb.length());
        }
        
        return list;
    }
    
    public void helper(List<String> list, StringBuilder sb, String num, 
    		int target, int start, long sum, long pre) {
        if(sum==target && start==num.length()) {
            String res = sb.toString();
            list.add(res);
            return ;
        }
        
        for(int i=start+1; i<=num.length(); i++) {
            if(num.charAt(start)=='0' && i>start+1) {
                break;
            }
            long cur = Long.parseLong(num.substring(start, i));
            int idx = sb.length();
            helper(list, sb.append("+"+cur), num, target, i, sum+cur, cur);
            sb.delete(idx, sb.length());
            helper(list, sb.append("-"+cur), num, target, i, sum-cur, -cur);
            sb.delete(idx, sb.length());
            helper(list, sb.append("*"+cur), num, target, i, sum-pre+pre*cur, pre*cur);
            sb.delete(idx, sb.length());
        }
    }
}
