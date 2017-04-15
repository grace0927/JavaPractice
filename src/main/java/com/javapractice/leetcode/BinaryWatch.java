/**
 *
 */
package com.javapractice.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jianyu Feng
 * https://leetcode.com/problems/binary-watch/
 * A binary watch has 4 LEDs on the top which represent the hours (0-11),
 * and the 6 LEDs on the bottom represent the minutes (0-59).
 * Each LED represents a zero or one, with the least significant bit on the right.
 * For example, the above binary watch reads "3:25".
 * Given a non-negative integer n which represents the number of LEDs that are currently on,
 * return all possible times the watch could represent.
 * Example:
 * Input: n = 1
 * Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
 * Note:
 * The order of output does not matter.
 * The hour must not contain a leading zero, for example "01:00" is not valid, it should be "1:00".
 * The minute must be consist of two digits and may contain a leading zero,
 * for example "10:2" is not valid, it should be "10:02".
 *
 */
public class BinaryWatch {
	public List<String> readBinaryWatch(int num) {
		List<String> list = new ArrayList<>();

		for (int i=0; i<=num && i<5; i++) {
			for (String hour:possibleHours(i)) {
				for (String minute:possibleMinutes(num-i)) {
					list.add(hour+":"+minute);
				}
			}
		}

		return list;
	}

	// should be generated automatically
	public String[] possibleHours(int i) {
		switch(i) {
			case 0:
				return new String[]{ "0" };
			case 1:
				return new String[]{ "1", "2", "4", "8" };
			case 2:
				return new String[]{ "3", "5", "6", "9", "10" };
			case 3:
				return new String[]{ "7", "11" };
		}

		return new String[0];
	}

	// should be generated automatically
	public String[] possibleMinutes(int i) {
		switch(i) {
			case 0:
				return new String[]{ "00" };
			case 1:
				return new String[]{ "01", "02", "04", "08", "16", "32" };
			case 2:
				return new String[]{ "03", "05", "06", "09", "10", "12", "17", "18", "20", "24", "33", "34", "36", "40", "48" };
			case 3:
				return new String[]{ "07", "11", "13", "14", "19", "21", "22", "25", "26", "28", "35", "37", "38", "41", "42", "44", "49", "50", "52", "56" };
			case 4:
				return new String[]{ "15", "23", "27", "29", "30", "39", "43", "45", "46", "51", "53", "54", "57", "58" };
			case 5:
				return new String[]{ "31", "47", "55", "59" };
		}

		return new String[0];
	}
}
