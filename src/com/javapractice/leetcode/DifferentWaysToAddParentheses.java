/**
 * 
 */
package com.javapractice.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jianyu
 * Given a string of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. 
 * The valid operators are +, - and *.
 * Example 1
 * Input: "2-1-1".
 * ((2-1)-1) = 0
 * (2-(1-1)) = 2
 * Output: [0, 2]
 * Example 2
 * Input: "2*3-4*5"
 * (2*(3-(4*5))) = -34
 * ((2*3)-(4*5)) = -14
 * ((2*(3-4))*5) = -10
 * (2*((3-4)*5)) = -10
 * (((2*3)-4)*5) = 10
 * Output: [-34, -14, -10, -10, 10]
 *
 */
public class DifferentWaysToAddParentheses {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> list = new ArrayList<>();
        List<Integer> num = new ArrayList<>();
        List<Character> op = new ArrayList<>();
        if(input.length()>0) {
            num.add(0);
        }
        for(int i=0; i<input.length(); i++) {
            char cur = input.charAt(i);
            if(cur>='0' && cur<='9') {
                int temp = num.get(num.size()-1)*10+cur-'0';
                num.remove(num.size()-1);
                num.add(temp);
            } else {
                op.add(cur);
                num.add(0);
            }
        }
        diffWaysToComputeUtil(num, op, list);
        return list;
    }
    
    public void diffWaysToComputeUtil(List<Integer> num, List<Character> op, List<Integer> list) {
        if(num.size() == 1) {
            list.add(num.get(0));
            return ;
        }
        
        for(int i=0; i<op.size(); i++) {
            List<Integer> left = new ArrayList<>();
            List<Integer> right = new ArrayList<>();
            Character opt = op.get(i);
            diffWaysToComputeUtil(num.subList(0, i+1), op.subList(0, i), left);
            diffWaysToComputeUtil(num.subList(i+1, num.size()), op.subList(i+1, op.size()), right);
            for(Integer resLeft : left) {
                for(Integer resRight : right) {
                    Integer temp = 0;
                    switch(opt) {
                        case '+':
                            temp = resLeft + resRight;
                            break;
                        case '-':
                            temp = resLeft - resRight;
                            break;
                        case '*':
                            temp = resLeft * resRight;
                            break;
                    }
                    list.add(temp);
                }
            }
        }
    }
}
