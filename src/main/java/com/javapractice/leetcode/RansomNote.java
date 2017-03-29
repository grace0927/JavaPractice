/**
 *
 */
package com.javapractice.leetcode;

/**
 * @author Jianyu Feng
 * https://leetcode.com/problems/ransom-note/
 *  Given  an  arbitrary  ransom  note  string  and  another  string  containing  letters from  all  the  magazines,  write  a  function  
 * that  will  return  true  if  the  ransom   note  can  be  constructed  from  the  magazines ;  otherwise,  it  will  return  false.   
 * Each  letter  in  the  magazine  string  can  only  be  used  once  in  your  ransom  note.
 * Note:
 * You may assume that both strings contain only lowercase letters.
 *
 *
 */
public class RansomNote {
	public boolean canConstructOld(String ransomNote, String magazine) {
		int[] dict = new int[26];

		for(int i=0; i<magazine.length(); i++) {
			dict[magazine.charAt(i)]++;
		}

		for(int i=0; i<ransomNote.length(); i++) {
			if(dict[ransomNote.charAt(i)]<=0) {
				return false;
			}
			dict[ransomNote.charAt(i)]--;
		}

		return true;
	}

	public boolean canConstruct(String ransomNote, String magazine) {
		int[] charMap = new int[256];

		for (char c:magazine.toCharArray()) {
			charMap[(int)c]++;
		}

		for (char c:ransomNote.toCharArray()) {
			charMap[(int)c]--;
			if (charMap[(int)c]<0) {
				return false;
			}
		}

		return true;
	}
}
