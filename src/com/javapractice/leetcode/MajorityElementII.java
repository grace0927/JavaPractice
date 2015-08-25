/**
 * 
 */
package com.javapractice.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author jianyu
 * https://leetcode.com/problems/majority-element-ii/
 * Given an integer array of size n, find all elements that appear more than |_ n/3 _| times. The algorithm should run in linear time and in O(1) space.
 *
 */
public class MajorityElementII {
	/**
	 * @param nums
	 * @return
	 * O(n) space
	 */
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            if(map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i])+1);
            } else {
                map.put(nums[i], 1);
            }
        }
        List<Integer> list = new ArrayList<>();
        for(Integer key : map.keySet()) {
            if(map.get(key)>nums.length/3) {
                list.add(key);
            }
        }
        return list;
    }
    
    /*
     * ref: http://www.programcreek.com/2014/07/leetcode-majority-element-ii-java/
     */
    public List<Integer> majorityElementVoteAlg(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        Integer one = null;
        Integer two = null;
        int cnt1 = 0;
        int cnt2 = 0;
        
        for(int i=0; i<nums.length; i++) {
        	if(one!=null && one.intValue()==nums[i]) {
        		cnt1++;
        	} else if(two!=null && two.intValue()==nums[i]) {
        		cnt2++;
        	} else if(cnt1==0) {
        		one = nums[i];
        		cnt1 = 1;
        	} else if(cnt2==0) {
        		two = nums[i];
        		cnt2 = 1;
        	} else {
        		cnt1--;
        		cnt2--;
        	}
        }
        
        cnt1 = cnt2 = 0;
     
        for(int i=0; i<nums.length; i++){
            if(nums[i]==one.intValue()){
                cnt1++;
            }else if(nums[i]==two.intValue()){
                cnt2++;
            }
        }
     
        if(cnt1>nums.length/3)
            list.add(one);
        if(cnt2>nums.length/3)
            list.add(two);
     
        return list;
    }
}
