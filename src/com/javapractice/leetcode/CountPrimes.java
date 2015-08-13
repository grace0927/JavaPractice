/**
 * 
 */
package com.javapractice.leetcode;

/**
 * @author jianyu
 * https://leetcode.com/problems/count-primes/
 * Count the number of prime numbers less than a non-negative number, n.
 *
 */
public class CountPrimes {
    public int countPrimes(int n) {
		if(n == 0) {
			return 0;
		}
        int[] res = new int[n];
		for(int i=0; i<n; i++) {
			res[i] = 1;
		}
		res[0] = 0;
		
		for(int i=1; (i+1)*(i+1)<n; i++) { // much faster when use this instead of i<n
			if(res[i] == 0) {
				continue;
			}
			int step = i+1;
			int pnt = i+i+1;
			while(pnt < n) {
				res[pnt] = 0;
				pnt += step;
			}
		}
		
		int cnt = 0;
		for(int i=0; i<n-1; i++) {
			cnt += (res[i]==0)?0:1;
		}
		
		return cnt;
    }
}
