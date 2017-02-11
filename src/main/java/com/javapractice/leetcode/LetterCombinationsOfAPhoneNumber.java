/**
 * 
 */
package com.javapractice.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author jianyu
 * Given a digit string, return all possible letter combinations that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * Note:
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 *
 */
public class LetterCombinationsOfAPhoneNumber {
	public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
		if(digits == null || digits.length() == 0) {
			result.add("");
			return result;
		}
		
		HashMap<Character, String> ret = new HashMap<>();
		for(int i=0; i<10; i++) {
			switch (i) {
				case 2:
					ret.put('2', "abc");
					break;
				case 3:
					ret.put('3', "def");
					break;
				case 4:
					ret.put('4', "ghi");
					break;
				case 5:
					ret.put('5', "jkl");
					break;
				case 6:
					ret.put('6', "mno");
					break;
				case 7:
					ret.put('7', "pqrs");
					break;
				case 8:
					ret.put('8', "tuv");
					break;
				case 9:
					ret.put('9', "wxyz");
					break;
				case 0:
					break;
				default:
					break;
			}
		}
		
		StringBuilder row = new StringBuilder();
		letterCombinationsUtil(result, row, digits, 0, ret);
		
		return result;
    }
	
	public void letterCombinationsUtil(List<String> result, StringBuilder row, String digits, int index, HashMap<Character, String> ret) {
		// last digit.
		

		System.out.println(index);
		if(digits.length() == index) {
			result.add(new String(row));
			return ;
		} else {
			Character test = new Character(digits.charAt(index));
			String cur = ret.get(test);
			for(int i=0; i<cur.length(); i++) {
				row.append(cur.charAt(i));
				index++;
				letterCombinationsUtil(result, row, digits, index, ret);
				index--;
				row.deleteCharAt(row.length()-1);
			}
		}
    }
}
