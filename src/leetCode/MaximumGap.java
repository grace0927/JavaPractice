/**
 * 
 */
package leetCode;

import java.util.Arrays;

/**
 * @author jianyu
 * https://oj.leetcode.com/problems/maximum-gap/
 * Given an unsorted array, find the maximum difference between the successive elements in its sorted form.
 * Try to solve it in linear time/space.
 * Return 0 if the array contains less than 2 elements.
 * You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.
 *
 */
public class MaximumGap {
	public int maximumGap(int[] num) {
        int len = num.length;
		if(len < 2) {
			return 0;
		}
		Arrays.sort(num);
		int max = num[1] - num[0];
		for(int i=1; i<len-1; i++) {
		    int cur = num[i+1] - num[i];
		    if(max < cur) {
		        max = cur;
		    }
		}
		return max;
    }
	
	public int maximumGapUsingBucketSort(int[] num) {
        int len = num.length;
		if(len < 2) {
			return 0;
		}
		
		int max = num[0];
		int min = num[0];
		for(int i=1; i<len; i++) {
			int cur = num[i];
			if(cur > max) {
				max = cur;
				continue;
			}
			if(cur < min) {
				min = cur;
				continue;
			}
		}
		
		int lenBucket = (max-min)/len+1;
		int amountBucket = (max-min)/lenBucket+1;
		int[][] bucket = new int[amountBucket][2];
		for(int i=0; i<amountBucket; i++) {
			Arrays.fill(bucket[i], -1);
		}
		
		for(int i=0; i<len; i++) {
			int cur = num[i];
			int curBucket = (cur-min)/lenBucket;
			
			if(bucket[curBucket][0] == -1) {
				bucket[curBucket][0] = cur;
				bucket[curBucket][1] = cur;
				continue;
			}
			
			if(bucket[curBucket][0] > cur) {
				bucket[curBucket][0] = cur;
				continue;
			}
			if(bucket[curBucket][1] < cur) {
				bucket[curBucket][1] = cur;
				continue;
			}
		}
		
		int gap = 0;
		for(int i=1, prev=0; i<amountBucket; i++) {
			if(bucket[i][0] == -1) {
				continue;
			}
			int cur = bucket[i][0] - bucket[prev][1];
			if(cur > gap) {
				gap = cur;
			}
			prev = i;
		}
		
		return gap;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
