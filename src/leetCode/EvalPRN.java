/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package leetCode;

import java.util.Stack;

/**
 *
 * @author jianyu
 */
public class EvalPRN {
        public int evalRPN(String[] tokens) {
        Stack st = new Stack();
        int i = 0;
        while(i < tokens.length) {
            switch (tokens[i]) {
                case "+":
                    {
                        int one = (int) st.pop();
                        int two = (int) st.pop();
                        int total = two + one;
                        st.push(new Integer(total));
                        break;
                    }
                case "-":
                    {
                        int one = (int) st.pop();
                        int two = (int) st.pop();
                        int total = two - one;
                        st.push(new Integer(total));
                        break;
                    }
                case "*":
                    {
                        int one = (int) st.pop();
                        int two = (int) st.pop();
                        int total = two * one;
                        st.push(new Integer(total));
                        break;
                    }
                case "/":
                    {
                        int one = (int) st.pop();
                        int two = (int) st.pop();
                        int total = two / one;
                        st.push(new Integer(total));
                        break;
                    }
                default:
                    st.push(new Integer(tokens[i]));
                    break;
            }
            i++;
        }
        return (int) st.pop();
    }
}

