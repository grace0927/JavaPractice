/**
 * 
 */
package leetCode;

/**
 * @author jianyu
 * https://oj.leetcode.com/problems/count-and-say/submissions/
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth sequence.
 * Note: The sequence of integers will be represented as a string.
 *
 */
public class CountAndSay {
	public String countAndSay(int n) {
        if(n < 1) {
			return "";
		}
		if(n == 1) {
		    return "1";
		}
		
		String cur = countAndSay(n-1);
		StringBuilder result = new StringBuilder();
		
		int len = cur.length();
		int count = '1';
		for(int j=0; j<len-1; j++) {
			char curChar = cur.charAt(j);
			if(curChar == cur.charAt(j+1)) {
				count++;
			} else {
				result.append((char)count);
				result.append(curChar);
				count = '1';
			}
		}

		System.out.println((char)count);
		
		result.append((char)count);
		result.append(cur.charAt(len-1));

		System.out.println(result);
		return result.toString();
    }
	
	public String countAndSayIterative(int n) {
        if(n<1) {
			return "";
		}
		
		StringBuilder result = new StringBuilder();
		result.append("1");
		for(int i=1; i<n; i++) {
			int len = result.length();
			String cur = result.toString();
			int count = '1';
			for(int j=0; j<len-1; j++) {
				char curChar = cur.charAt(j);
				if(curChar == cur.charAt(j+1)) {
					count++;
				} else {
					char[] str = new char[2];
					str[0] = (char)count;
					str[1] = curChar;
					result.append(str);
					count = '1';
				}
			}
			char[] str = new char[2];
			str[0] = (char)count;
			str[1] = cur.charAt(len-1);
			result.append(str);
			result.delete(0, len);
		}
		
		return result.toString();
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CountAndSay test = new CountAndSay();
		System.out.println(test.countAndSayIterative(2));
	}

}
