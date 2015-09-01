/**
 * 
 */
package com.javapractice.leetcode;

/**
 * @author jianyu
 * https://leetcode.com/problems/sliding-window-maximum/
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. 
 * You can only see the k numbers in the window. Each time the sliding window moves right by one position.
 * For example,
 * Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * Therefore, return the max sliding window as [3,3,5,5,6,7].
 * You may assume k is always valid, ie: 1 ¡Ü k ¡Ü input array's size for non-empty array.
 * Could you solve it in linear time?
 * ref: http://articles.leetcode.com/2011/01/sliding-window-maximum.html
 *
 */
public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length<1 || k<1) {
            return nums;
        }
        int[] res = new int[nums.length-k+1];
        int[] win = new int[k];
        int fast = 0;
        int pnt = 0;
        for(int i=0; i<k; i++) {
            win[fast] = nums[fast];
            fast++;
        }
        res[pnt++] = maxSlidingWindowUtil(win);
        while(fast < nums.length) {
            win[fast%k] = nums[fast++];
            res[pnt++] = maxSlidingWindowUtil(win);
        }
        return res;
    }
    
    public int maxSlidingWindowUtil(int[] arr) {
        int temp = arr[0];
        for(int i=1; i<arr.length; i++) {
            temp = Math.max(temp, arr[i]);
        }
        return temp;
    }
}
