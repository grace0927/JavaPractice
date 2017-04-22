/**
 *
 */
package com.javapractice.leetcode;

/**
 * @author jianyu
 * https://leetcode.com/problems/student-attendance-record-i/
 * You are given a string representing an attendance record for a student.
 * The record only contains the following three characters:
 * 'A' : Absent.
 * 'L' : Late.
 * 'P' : Present.
 * A student could be rewarded if his attendance record doesn't contain more than one 'A' (absent)
 * or more than two continuous 'L' (late).
 * You need to return whether the student could be rewarded according to his attendance record.
 * Example 1:
 * Input: "PPALLP"
 * Output: True
 * Example 2:
 * Input: "PPALLL"
 * Output: False
 *
 */
public class StudentAttendanceRecordI {
	public boolean checkRecord(String s) {
		char[] records = s.toCharArray();
		boolean flag = false;

		for (int i=0; i<records.length; i++) {
			if (records[i]=='A') {
				if (flag) {
					return false;
				}
				flag = true;
			}

			if (records[i]=='L' && i>1 && records[i-1]=='L' && records[i-2]=='L') {
				return false;
			}
		}

		return true;
	}
}
