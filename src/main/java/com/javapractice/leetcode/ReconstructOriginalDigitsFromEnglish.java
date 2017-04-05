/**
 *
 */
package com.javapractice.leetcode;

/**
 * @author Jianyu Feng
 * https://leetcode.com/problems/reconstruct-original-digits-from-english/
 * Given a non-empty string containing an out-of-order English representation of digits 0-9,
 * output the digits in ascending order.
 * Note:
 * Input contains only lowercase English letters.
 * Input is guaranteed to be valid and can be transformed to its original digits.
 * That means invalid inputs such as "abc" or "zerone" are not permitted.
 * Input length is less than 50,000.
 * Example 1:
 * Input: "owoztneoer"
 * Output: "012"
 * Example 2:
 * Input: "fviefuro"
 * Output: "45"
 *
 */
public class ReconstructOriginalDigitsFromEnglish {
	public String originalDigits(String s) {
		int[] count = buildCount(s);

		return buildString(count);
	}

	public String buildString(int[] count) {
		StringBuilder sb = new StringBuilder();

		for (int i=0; i<10; i++) {
			for (int j=0; j<count[i]; j++) {
				sb.append(i);
			}
		}

		return sb.toString();
	}

	public int[] buildCount(String s) {
		HashMap<Character, Integer> map = buildMap();
		int[] count = new int[10];

		for (char c:s.toCharArray()) {
			if (map.containsKey(c)) {
				count[map.get(c)]++;
			}
		}

		count[3] -= count[8];
		count[5] -= count[4];
		count[7] -= count[6];
		count[1] -= count[0] + count[2] + count[4];
		count[9] -= count[6] + count[8] + count[5];

		return count;
	}

	public HashMap<Character, Integer> buildMap() {
		char[] charMap = new char[]{ 'z', 'o', 'w', 'h', 'u', 'f', 'x', 's', 'g', 'i' };
		HashMap<Character, Integer> map = new HashMap<>();

		for (int i=0; i<10; i++) {
			map.put(charMap[i], i);
		}

		return map;
	}
}
