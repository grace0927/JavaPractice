/**
 * 
 */
package com.javapractice.leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author jianyu
 * https://leetcode.com/problems/basic-calculator-ii/
 * Implement a basic calculator to evaluate a simple expression string.
 * The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.
 * You may assume that the given expression is always valid.
 * Some examples:
 * "3+2*2" = 7
 * " 3/2 " = 1
 * " 3+5 / 2 " = 5
 *
 */
public class BasicCalculatorII {
    public int calculate(String s) {
        Stack<Integer> num = new Stack<>();
        Queue<Character> op = new LinkedList<>();
        boolean multi = false;
        boolean div = false;
        
        num.push(0);
        for(int i=0; i<s.length(); i++) {
            char cur = s.charAt(i);
            if(cur>='0' && cur<='9') {
                num.push(num.pop()*10+cur-'0');
            } else {
                if(cur==' ') {
                    continue;
                }
                if(multi) {
                    num.push(num.pop()*num.pop());
                    multi = false;
                }
                if(div) {
                    int temp = num.pop();
                    num.push((int)num.pop()/temp);
                    div = false;
                }
                if(cur=='*') {
                    multi = true;
                } else if(cur=='/') {
                    div = true;
                } else {
                    op.add(cur);
                }
                num.push(0);
            }
        }
        if(multi) {
            num.push(num.pop()*num.pop());
            multi = false;
        }
        if(div) {
            int temp = num.pop();
            num.push((int)num.pop()/temp);
            div = false;
        }
        
        Stack<Integer> value = new Stack<>();
        while(!num.isEmpty()) {
            value.push(num.pop());
        }
        
        int sum = value.pop();
        while(!op.isEmpty()) {
            switch(op.poll()) {
                case '+':
                    sum += value.pop();
                    break;
                case '-':
                    sum -= value.pop();
                    break;
            }
        }
        return sum;
    }
}
