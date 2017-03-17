/**
 *
 */
package com.javapractice.leetcode;

/**
 * @author Jianyu Feng
 * https://leetcode.com/problems/keyboard-row/
 * Given a List of words, return the words
 * that can be typed using letters of alphabet on only one row's of American keyboard like the image below.
 * Example 1:
 * Input: ["Hello", "Alaska", "Dad", "Peace"]
 * Output: ["Alaska", "Dad"]
 * Note:
 * You may use one character in the keyboard more than once.
 * You may assume the input string will only contain letters of alphabet.
 *
 */
public class KeyboardRow {
	public String[] findWords(String[] words) {
		int[] map = new int[] {1, 2, 2, 1, 0, 1, 1, 1, 0, 1, 1, 1, 2, 2, 0, 0, 0, 0, 1, 0, 0, 2, 0, 2, 0, 2};
		ArrayList<String> list = new ArrayList<>();

		for (String word:words) {
			String lowerWord = word.toLowerCase();
			boolean invalid = false;
			for (char c:lowerWord.toCharArray()) {
				if (map[c-'a'] != map[lowerWord.charAt(0)-'a']) {
					invalid = true;
					break;
				}
			}
			if (!invalid) {
				list.add(word);
			}
		}

		return list.toArray(new String[list.size()]);
	}
}
