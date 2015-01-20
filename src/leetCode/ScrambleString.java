/**
 * 
 */
package leetCode;

/**
 * @author jianyu
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
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ScrambleString test = new ScrambleString();
		System.out.println(test.isScramble("abb", "bab"));
	}

}
