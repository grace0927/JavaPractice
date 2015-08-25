/**
 * 
 */
package com.javapractice.leetcode;

import java.util.Stack;

/**
 * @author jianyu
 * https://leetcode.com/problems/basic-calculator/
 * Implement a basic calculator to evaluate a simple expression string.
 * The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .
 * You may assume that the given expression is always valid.
 * Some examples:
 * "1 + 1" = 2
 * " 2-1 + 2 " = 3
 * "(1+(4+5+2)-3)+(6+8)" = 23
 * Note: Do not use the eval built-in library function.
 *
 */
public class BasicCalculator {
    public int calculate(String s) {
        Stack<Integer> num = new Stack<>();
        num.push(0);
        Stack<Character> op = new Stack<>();
        Stack<Boolean> flip = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            char cur = s.charAt(i);
            if(cur>='0' && cur<='9') {
                num.push(num.pop()*10+cur-'0');
            } else if(cur == ' ') {
                continue;
            } else if(cur == '(') {
                if(op.isEmpty()) {
                    flip.push(false);
                } else {
                    flip.push(op.peek()=='-');
                }
            } else if(cur == ')') {
                flip.pop();
            } else {
                if(!flip.isEmpty() && flip.peek()) {
                    cur = (cur=='+')?'-':'+';
                }
                op.push(cur);
                num.push(0);
            }
        }
        
        Stack<Integer> str = new Stack<>();
        while(!num.isEmpty()) {
            str.push(num.pop());
        }
        Stack<Character> ope = new Stack<>();
        while(!op.isEmpty()) {
            ope.push(op.pop());
        }
        
        int sum = str.pop();
        while(!ope.isEmpty()) {
            char operate = ope.pop();
            switch(operate) {
                case '+':
                    sum += str.pop();
                    break;
                case '-':
                    sum -= str.pop();
                    break;
            }
        }
        return sum;
    }
}
