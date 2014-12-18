/**
 * 
 */
package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jianyu
 * 
 * https://oj.leetcode.com/problems/generate-parentheses/
 * Given n pairs of parentheses, write a function to generate 
 * all combinations of well-formed parentheses.
 * For example, given n = 3, a solution set is:
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 *
 */
public class GenerateParentheses {
	
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        // special case
        if(n<1) {
            return result;
        }
        
        String res = new String();
        generator(0, 0, res, result, n);
        return result;
    }
    
    // Go Depth-First Generator
    public void generator(int left, int right, String res, List<String> result, int max) {
    	// add when left and right reach the max
        if(left == max && right == max) {
            result.add(res);
            return ;
        }
        // invalid if there are rights without left
        if(left < right) {
            return;
        }
        
        // go left 
        if(left >= 0 && left < max) {
            generator(left+1, right, res+'(', result, max);
        }
        // go right
        if(right >= 0 && right < max) {
            generator(left, right+1, res+')', result, max);
        }
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
