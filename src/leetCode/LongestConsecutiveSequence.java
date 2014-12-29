/**
 * 
 */
package leetCode;

import java.util.HashMap;

/**
 * @author jianyu
 * https://oj.leetcode.com/problems/longest-consecutive-sequence/
 *
 */
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] num) {
        if(num.length <= 0) {
			return 0;
		}
		
		HashMap<Integer, Integer> map = new HashMap<>();
		int max = 1;
		
		for(int i=0; i<num.length; i++) {
			int temp=num[i];
			int count=1;
			if(map.containsKey(temp-1)) {
				count += map.get(temp-1);
			}
			map.put(temp, count);
			max = max<count?count:max;
			
			int j=1;
			while(map.containsKey(temp+j)) {
				j++;
			}
			if(map.get(temp+j-1)!=null) {
			    int tempCount = map.get(temp+j-1)+count;
			    map.put(temp+j-1, tempCount);
			    max = max<tempCount?tempCount:max;
			}
		}
		
		return max;
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
