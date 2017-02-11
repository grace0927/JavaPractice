/**
 * 
 */
package com.javapractice.lintcode;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author jianyu
 * http://www.lintcode.com/en/problem/majority-number/
 * Given an array of integers, the majority number is the number that occurs more than half of the size of the array. Find it.
 * Given [1, 1, 1, 1, 2, 2, 2], return 1
 * O(n) time and O(1) extra space
 *
 */
public class MajorityNumber {    
	/**
     * @param nums: a list of integers
     * @return: find a  majority number
     */
    public int majorityNumber(ArrayList<Integer> nums) {
        // write your code
        HashMap<Integer, Integer> map = new HashMap<>();
        int limit = nums.size()/2;
        for(Integer cur:nums) {
            if(map.containsKey(cur)) {
                map.put(cur, map.get(cur)+1);
            } else {
                map.put(cur, 1);
            }
            if(map.get(cur) > limit) {
                return cur;
            }
        }
        return 0;
    }

}
