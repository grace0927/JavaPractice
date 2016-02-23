/**
 * 
 */
package com.javapractice.leetcode;

/**
 * @author Feng
 * https://leetcode.com/problems/create-maximum-number/
 * Given two arrays of length m and n with digits 0-9 representing two numbers. 
 * Create the maximum number of length k <= m + n from digits of the two. 
 * The relative order of the digits from the same array must be preserved. 
 * Return an array of the k digits. You should try to optimize your time and space complexity.
 * Example 1:
 * nums1 = [3, 4, 6, 5]
 * nums2 = [9, 1, 2, 5, 8, 3]
 * k = 5
 * return [9, 8, 6, 5, 3]
 * 
 * Example 2:
 * nums1 = [6, 7]
 * nums2 = [6, 0, 4]
 * k = 5
 * return [6, 7, 6, 0, 4]
 * 
 * Example 3:
 * nums1 = [3, 9]
 * nums2 = [8, 9]
 * k = 3
 * return [9, 8, 9]
 *
 */
public class CreateMaximumNumber implements Solution{
	public void test() {
    	maxNumber(new int[]{8,6,9}, new int[]{1,7,5}, 3);
	}
	
    public int[] maxNumberTrivial(int[] nums1, int[] nums2, int k) {
        int[] res = new int[k];
        maxNumberHelper(nums1, 0, nums2, 0, k, res);
        return res;
    }
    
    public void maxNumberHelper(int[] nums1, int start1, int[] nums2, 
    		int start2, int k, int[] res) {
        if(k==0) {
            return ;
        }
        int max = 0;
        int idx1 = Math.min(nums1.length+nums2.length-start2-k+1, nums1.length);
        int idx2 = Math.min(nums1.length+nums2.length-start1-k+1, nums2.length);
        for(int i=start1; i<idx1; i++) {
            max = Math.max(nums1[i], max);
        }
        for(int i=start2; i<idx2; i++) {
            max = Math.max(nums2[i], max);
        }
        
        if(res[res.length-k]>max) {
            return ;
        }
        res[res.length-k] = max;
        for(int i=start1; i<idx1; i++) {
            if(nums1[i]==max) {
                maxNumberHelper(nums1, i+1, nums2, start2, k-1, res);
            }
        }
        for(int i=start2; i<idx2; i++) {
            if(nums2[i]==max) {
                maxNumberHelper(nums1, start1, nums2, i+1, k-1, res);
            }
        }
    }
    
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] res = new int[k];
        
        for(int i=Math.max(0, k-nums2.length); i<=Math.min(nums1.length, k); i++) {
            int[] res1 = maxArray(nums1, i);
            int[] res2 = maxArray(nums2, k-i);
            int[] tmp = new int[k];
            mergeArray(res1, res2, tmp);
            for(int j=0; j<k; j++) {
                if(tmp[j]>res[j]) {
                    res = tmp;
                    break;
                } else if(tmp[j]<res[j]) {
                    break;
                }
            }
        }
        
        return res;
    }
    
    public void mergeArray(int[] res1, int[] res2, int[] res) {
        int pnt = 0;
        int i=0, j=0;
        while(pnt<res.length) {
            if(i>=res1.length) {
                res[pnt++] = res2[j++];
                continue;
            }
            if(j>=res2.length) {
                res[pnt++] = res1[i++];
                continue;
            }
            if(res1[i] > res2[j]) {
                res[pnt++] = res1[i++];
            } else if(res1[i]<res2[j]) {
                res[pnt++] = res2[j++];
            } else {
                int tmp1 = i;
                int tmp2 = j;
                while(tmp1<res1.length && tmp2<res2.length && res1[tmp1]==res2[tmp2]) {
                    tmp1++;
                    tmp2++;
                }
                if(tmp2==res2.length || (tmp1<res1.length && res1[tmp1]>res2[tmp2])) {
                    res[pnt++] = res1[i++];
                } else {
                    res[pnt++] = res2[j++];
                }
            }
        }
    }
    
    public int[] maxArray(int[] nums, int k) {
        int[] res = new int[k];
        for(int i=0, j=0; i<nums.length; i++) {
            while(j>0 && nums.length-i+j>k && nums[i]>res[j-1]) {
                j--;
            }
            if(j<k) {
                res[j++] = nums[i];
            }
        }
        return res;
    }
}
