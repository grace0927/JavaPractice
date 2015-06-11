/**
 * 
 */
package com.javapractice.lintcode;

import java.util.ArrayList;

/**
 * @author jianyu
 * http://www.lintcode.com/en/problem/search-for-a-range/
 * Given a sorted array of n integers, find the starting and ending position of a given target value.
 * If the target is not found in the array, return [-1, -1].
 * Given [5, 7, 7, 8, 8, 10] and target value 8, return [3, 4].
 * O(log n) time.
 *
 */
public class SearchForARange {
    /** 
     *@param A : an integer sorted array
     *@param target :  an integer to be inserted
     *return : a list of length 2, [index1, index2]
     */
    public ArrayList<Integer> searchRange(ArrayList<Integer> A, int target) {
        // write your code here
        Integer[] arr = A.toArray(new Integer[A.size()]);
        int len = arr.length;
        ArrayList<Integer> res = new ArrayList<>();
        if(len == 0) {
        	res.add(-1);
        	res.add(-1);
        	return res;
        }

        if(arr[0] == target && arr[len-1] == target) {
        	res.add(0);
        	res.add(len-1);
        	return res;
        }

        int start = 0; 
        int end = len-1;
        // use binary search to find start position
        if(arr[0] == target) {
        	res.add(0);
        } else if(len>1 && arr[len-1]==target && arr[len-2]<arr[len-1]) {
        	res.add(len-1);
        	res.add(len-1);
        	return res;
        } else {
	        while(start < end-1) {
	        	int mid = start + (end-start)/2;
	        	if(arr[mid]==target && arr[mid]>arr[mid-1]) {
	        		res.add(mid);
	        		break;
	        	} else if(arr[mid]>=target) {
	        		end = mid;
	        	} else {
	        		start = mid;
	        	}
	        }
        }

        if(res.isEmpty()) {
        	res.add(-1);
        	res.add(-1);
        	return res;
        }

        // use binary search to find end position
        if(arr[len-1] == target) {
        	res.add(len-1);
        	return res;
        } else {
        	start = 0;
        	end = len-1;
	        while(start < end-1) {
	        	int mid = start + (end-start)/2;
	        	if(arr[mid]==target && arr[mid]<arr[mid+1]) {
	        		res.add(mid);
	        		break;
	        	} else if(arr[mid]<=target) {
	        		start = mid;
	        	} else {
	        		end = mid;
	        	}
	        }
        }

        return res;
    }
}
