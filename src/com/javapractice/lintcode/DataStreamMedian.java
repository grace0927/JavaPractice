/**
 * 
 */
package com.javapractice.lintcode;

import java.util.ArrayList;

/**
 * @author jianyu
 * http://www.lintcode.com/en/problem/data-stream-median/
 * Numbers keep coming, return the median of numbers at every time a new number added.
 * For numbers coming list: [1, 2, 3, 4, 5], return [1, 1, 2, 2, 3].
 * For numbers coming list: [4, 5, 1, 3, 2, 6, 0], return [4, 4, 4, 3, 3, 3, 3].
 * For numbers coming list: [2, 20, 100], return [2, 2, 20].
 * Total run time in O(nlogn).
 * What's the definition of Median? - Median is the number that in the middle of a sorted array. 
 * If there are n numbers in a sorted array A, the median is A[(n - 1) / 2]. 
 * For example, if A=[1,2,3], median is 2. If A=[1,19], median is 1.
 *
 */
public class DataStreamMedian {
    /**
     * @param nums: A list of integers.
     * @return: the median of numbers
     */
    public int[] medianII(int[] nums) {
        // write your code here
		if(nums.length == 0) {
			return nums;
		}
		int[] res = new int[nums.length];
		
		// O(nlogn)
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(nums[0]);
		res[0] = nums[0];
		for(int i=1; i<nums.length; i++) {
			int cur = nums[i];
			int start = 0;
			int end = i;
			// O(logn)
			if(cur > arr.get(end-1)) {
				arr.add(cur);
			} else if(cur < arr.get(start)) {
				arr.add(0, cur);
			} else {
    			while(start < end-1) {
					int mid = start+(end-start)/2;
					if(cur > arr.get(mid)) {
						start = mid;
					} else {
						end = mid;
					}
    			}
			    arr.add(start+1, cur);
			}
			res[i] = arr.get(i/2);
		}
		
		return res;
    }
}
