/**
 * 
 */
package com.javapractice.lintcode;

/**
 * @author jianyu
 * http://www.lintcode.com/en/problem/interleaving-string/
 * Given three strings: s1, s2, s3, determine whether s3 is formed by the interleaving of s1 and s2.
 * For s1 = "aabcc", s2 = "dbbca"
 * When s3 = "aadbbcbcac", return true.
 * When s3 = "aadbbbaccc", return false.
 * O(n2) time or better
 *
 */
public class InterleavingString {
    /**
     * Determine whether s3 is formed by interleaving of s1 and s2.
     * @param s1, s2, s3: As description.
     * @return: true or false.
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        // write your code here
		int len1 = s1.length();
		int len2 = s2.length();
		int len3 = s3.length();
		boolean[][][] res = new boolean[len1+1][len2+1][len3+1];
		
		res[0][0][0] = true;
		for(int k=1; k<=len3; k++) {
			for(int i=0; i<=k; i++) {
				if(k-i-1>=0&&k-i-1<len2&&i<=len1) {
					res[i][k-i][k] |= res[i][k-i-1][k-1]&&(s2.charAt(k-i-1)==s3.charAt(k-1));
				}
				if(i-1>=0&&i-1<len1&&k-i<=len2) {
					res[i][k-i][k] |= res[i-1][k-i][k-1]&&(s1.charAt(i-1)==s3.charAt(k-1));
				}
			}
		}
		
        return res[len1][len2][len3];
    }
}
