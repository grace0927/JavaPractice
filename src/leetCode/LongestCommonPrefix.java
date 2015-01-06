/**
 * 
 */
package leetCode;

import java.util.HashMap;

/**
 * @author jianyu
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 */
public class LongestCommonPrefix {
	// idea: record all prefix in a hash table and find the longest one
	public String longestCommonPrefix(String[] strs) {
        if(strs == null) {
			return new String();
		}
		
		HashMap<String, Integer> ret = new  HashMap<>();
		for(int i=0; i<strs.length; i++) {
			String row = strs[i];
			for(int j=0; j<row.length()+1; j++) {
				String part = row.substring(0, j);
				if(ret.containsKey(part)) {
					ret.put(part, ret.get(part)+1);
				} else {
					ret.put(part, 1);
				}
			}
		}
		
		String result = new String();
		int max = 0;
		for(String row : ret.keySet()) {
			if(ret.get(row)>max) {
				max = ret.get(row);
				result = row;
			} else if(ret.get(row) == max) {
				if(row.length() > result.length()) {
					result = row;
				}
			}
		}
		
		return result;
    }
	
	// better idea, compare character by character, return the fastest
	public String longestCommonPrefixOptimal(String[] strs) {
        if(strs == null || strs.length == 0) {
			return new String();
		}
		
		for (int i = 0; i < strs[0].length() ; i++){
            char cur = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j ++) {
                if (i == strs[j].length() || strs[j].charAt(i) != cur) {
                    return strs[0].substring(0, i);
                }
            }
        }
        
        return strs[0];
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
