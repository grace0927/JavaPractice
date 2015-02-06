/**
 * 
 */
package com.javapractice.leetcode;

/**
 * @author jianyu
 * https://oj.leetcode.com/problems/palindrome-number/
 * Determine whether an integer is a palindrome. Do this without extra space.
 * Some hints:
 * Could negative integers be palindromes? (ie, -1)
 * If you are thinking of converting the integer to string, note the restriction of using extra space.
 * You could also try reversing an integer. However, if you have solved the problem "Reverse Integer",
 * you know that the reversed integer might overflow. How would you 
 * handle such case?
 * There is a more generic way of solving this problem.
 *
 */
public class PalindromeNumber {
	public boolean isPalindromeAlternate(int x) {
        int palindromeX = 0;
        int inputX = x;
        while(x>0){
            palindromeX = palindromeX*10 + (x % 10);
            x = x/10;
        }
        return palindromeX==inputX; 
    }
	
    public boolean isPalindrome(int x) {
        if(x<0) {
			return false;
		}
		if(x >= 0 && x < 10) {
			return true;
		}
		
		int index = 1;
		int remain = x % 10;
		int head = x/10;
		
		while(head >= 10) {
			index++;
			head = (int)Math.floor(x/Math.pow(10, index));
		}
		
		if(head != remain) {
			return false;
		}
		
		int left = (int)Math.floor((x - head*Math.pow(10, index) - remain)/10);
		if(left == 0) {
			return true;
		}
		
		index = index-2;
		while(left < Math.pow(10, index) && index >= 0) {
			int leftRemain = left % 10;
			if(leftRemain != 0) {
				return false;
			}
			index--;
			left = (int)(left-leftRemain)/10;
			index--;
		}
		
		return isPalindrome(left);
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}