/**
 *
 */
package com.javapractice.leetcode;

/**
 * @author Jianyu Feng
 * https://leetcode.com/problems/reverse-words-in-a-string-iii/
 * Given a string, you need to reverse the order of characters in each word
 * within a sentence while still preserving whitespace and initial word order.
 * Example 1:
 * Input: "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 * Note: In the string, each word is separated by single space and there will not be any extra space in the string.
 *
 */
public class ReverseWordsInAStringIII {
	public String reverseWords(String s) {
		StringBuilder sb = new StringBuilder();

		for (String word:s.split(" ")) {
			sb.append(reverse(word));
			sb.append(" ");
		}

		sb.deleteCharAt(sb.length()-1);

		return sb.toString();
	}

	public String reverse(String s) {
		StringBuilder sb = new StringBuilder();

		for (char c:s.toCharArray()) {
			sb.insert(0, c);
		}

		return sb.toString();
	}
}
