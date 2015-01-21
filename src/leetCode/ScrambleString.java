/**
 * 
 */
package leetCode;

/**
 * @author jianyu
 * https://oj.leetcode.com/problems/scramble-string/
 * Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.
 * Below is one possible representation of s1 = "great":
 *     great
 *    /    \
 *   gr    eat
 *  / \    /  \
 * g   r  e   at
 *            / \
 *           a   t
 * To scramble the string, we may choose any non-leaf node and swap its two children.
 * For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".
 *     rgeat
 *    /    \
 *   rg    eat
 *  / \    /  \
 * r   g  e   at
 *            / \
 *           a   t
 * We say that "rgeat" is a scrambled string of "great".
 * Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".
 * We say that "rgtae" is a scrambled string of "great".
 * Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
 *     rgtae
 *    /    \
 *   rg    tae
 *  / \    /  \
 * r   g  ta  e
 *       / \
 *      t   a 
 *
 */
public class ScrambleString {
	public boolean isScramble(String s1, String s2) {
		if(s1 == s2) {
			return true;
		}
		
		int len1 = s1.length();
		int len2 = s2.length();
		if(len1 != len2 || len1 == 1) {
			return false;
		}
		
		for(int i=0; i<len1-1; i++) {
			String s11 = s1.substring(0, i);
			String s12 = s1.substring(i+1, len1);
			String s21 = s2.substring(0, i);
			String s22 = s2.substring(i+1, len1);
			
			if(isScramble(s11, s21) && isScramble(s12, s22)) {
				return true;
			}
			
			s21 = s2.substring(0, len1-1-i);
			s22 = s2.substring(len1-i, len1);
			
			if(isScramble(s11, s22) && isScramble(s12, s21)) {
				return true;
			}
		}
		
		return false;
    }
	
	public boolean isScrambleDP(String s1, String s2) {
        if(s1.length() != s2.length()) {
			return false;
		}
		if(s1.length() == 0 || s1.equals(s2)) {
			return true;
		}
		
		int len = s1.length();
		boolean[][][] ret = new boolean[len][len][len];
		
		for(int i=0; i<len; i++) {
			for(int j=0; j<len; j++) {
				ret[i][j][0] = (s1.charAt(i) == s2.charAt(j));
			}
		}
		
		for(int i=1; i<len; i++) {
			// for diff len
			for(int j=0; j<len-i; j++) {
				// for s1
				for(int k=0; k<len-i; k++) {
					// for s2
					for(int l=0; l<i; l++) {
						ret[j][k][i] = (((ret[j][k][l]&&ret[j+l+1][k+l+1][i-l-1])||(ret[j][k+i-l][l]&&ret[j+l+1][k][i-l-1]))||ret[j][k][i]);
					}
				}
			}
		}
		
		return ret[0][0][len-1];
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ScrambleString test = new ScrambleString();
		System.out.println(test.isScrambleDP("abc", "bca"));
	}

}
