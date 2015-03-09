/**
 * 
 */
package com.javapractice.leetcode;

/**
 * @author jianyu
 * https://leetcode.com/problems/compare-version-numbers/
 * Compare two version numbers version1 and version2.
 * If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.
 * You may assume that the version strings are non-empty and contain only digits and the . character.
 * The . character does not represent a decimal point and is used to separate number sequences.
 * For instance, 2.5 is not "two and a half" or "half way to version three", 
 * it is the fifth second-level revision of the second first-level revision.
 * Here is an example of version numbers ordering:
 * 0.1 < 1.1 < 1.2 < 13.37
 *
 */
public class CompareVersionNumbers {
	public int compareVersion(String version1, String version2) {
        int len1 = version1.length();
		int len2 = version2.length();
		
		int index1 = 0;
		int index2 = 0;
		while(index1<len1 && index2<len2) {
			long cur1 = 0;
			long cur2 = 0;
			
			while(index1<len1 && version1.charAt(index1)!='.') {
				cur1 = cur1*10+version1.charAt(index1)-48;
				index1++;
			}
			index1++;
			
			while(index2<len2 && version2.charAt(index2)!='.') {
				cur2 = cur2*10+version2.charAt(index2)-48;
				index2++;
			}
			index2++;
			
			if(cur1 > cur2) {
				return 1;
			} else if(cur1 < cur2) {
				return -1;
			}
		}
		
		while(index1 < len1) {
		    long cur1 = 0;
		    while(index1<len1 && version1.charAt(index1)!='.') {
				cur1 = cur1*10+version1.charAt(index1)-48;
				index1++;
			}
			index1++;
			if(cur1 > 0) {
			    return 1;
			}
		}
		while(index2 < len2) {
			long cur2 = 0;
		    while(index2<len2 && version2.charAt(index2)!='.') {
				cur2 = cur2*10+version2.charAt(index2)-48;
				index2++;
			}
			index2++;
			if(cur2 > 0) {
			    return -1;
			}
		}
		
		return 0;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CompareVersionNumbers test = new CompareVersionNumbers();
		System.out.println(test.compareVersion("01", "1"));

	}

}
