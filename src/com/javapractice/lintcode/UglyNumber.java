/**
 * 
 */
package com.javapractice.lintcode;

/**
 * @author jianyu
 * http://www.lintcode.com/en/problem/ugly-number/
 * Ugly number is a number that only have factors 3, 5 and 7.
 * Design an algorithm to find the Kth ugly number. The first 5 ugly numbers are 3, 5, 7, 9, 15 ...
 * If K=4, return 9.
 * O(K log K) or O(K) time.
 *
 */
public class UglyNumber {
    /**
     * @param k: The number k.
     * @return: The kth prime number as description.
     */
    public long kthPrimeNumber(int k) {
        // write your code here
		if(k==0) {
			return 0;
		} else if(k==1) {
			return 3;
		} else if(k==2) {
			return 5;
		} else if(k==3) {
			return 7;
		}
		long[] res = new long[k];
		res[0] = 3;
		res[1] = 5;
		res[2] = 7;
		int[] pnt = new int[]{0, 0, 0};
		long[] arr = new long[]{9, 15, 21};
		long[] base = new long[]{3, 5, 7};
		for(int i=3; i<k; i++) {
			long cur = arr[0];
			int cnt = 0;
			for(int j=1; j<3; j++) {
				if(arr[j] < cur) {
					cur = arr[j];
					cnt = j;
				} else if(arr[j] == cur) {
					pnt[j]++;
					arr[j] = res[pnt[j]]*base[j];
				}
			}
			pnt[cnt]++;
			arr[cnt] = res[pnt[cnt]]*base[cnt];
			res[i] = cur;
		}
		
		return res[k-1];
    }
}
