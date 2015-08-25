/**
 * 
 */
package com.javapractice.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jianyu
 * https://leetcode.com/problems/summary-ranges/
 * Given a sorted integer array without duplicates, return the summary of its ranges.
 * For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
 *
 */
public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        if(nums.length > 0) {
            summaryRangesUtil(nums, list, 0, nums.length-1);
        }
        return list;
    }
    
    public void summaryRangesUtil(int[] nums,List<String> list, int start, int end) {
        if(end-start == nums[end]-nums[start]) {
            String res = (end!=start)?""+nums[start]+"->"+nums[end] : ""+nums[start];
            list.add(res);
            return ;
        }
        
        int mid = start + (end-start)/2;
        int pnt = mid;
        
        while(pnt>=1 && nums[pnt]-nums[pnt-1]==1) {
            pnt--;
        }
        while(mid<end && nums[mid+1]-nums[mid]==1) {
            mid++;
        }
        
        if(pnt != mid) {
            if(pnt-1>=start) summaryRangesUtil(nums, list, start, pnt-1);
            String res = ""+nums[pnt]+"->"+nums[mid];
            list.add(res);
            if(mid+1<=end) summaryRangesUtil(nums, list, mid+1, end);
        } else {
            summaryRangesUtil(nums, list, start, pnt);
            summaryRangesUtil(nums, list, mid+1, end);
        }
    }
}
