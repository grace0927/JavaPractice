/**
 * 
 */
package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author feng
 * Given an array of strings, return all groups of strings that are anagrams.
 * Note: All inputs will be in lower-case.
 *
 */
public class Anagrams {
	public List<String> anagrams(String[] strs) {
        List<String> result = new ArrayList<>();
        HashMap<String, String> map = new HashMap<>();
        
        for(int i=0; i<strs.length; i++) {
            String cur = strs[i];
            Integer[] val = new Integer[26];
            Arrays.fill(val, 0);
            for(int j=0; j<cur.length(); j++) {
                val[cur.charAt(j)-97] ++;
            }
            String key = Arrays.toString(val);
            if(!map.containsKey(key)) {
                map.put(key, cur);
            } else {
                if(!result.contains(map.get(key))) {
                    result.add(map.get(key));
                }
                result.add(cur);
            }
        }
        
        return result;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	}

}
