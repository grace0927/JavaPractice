/**
 * 
 */
package com.javapractice.lintcode;

/**
 * @author jianyu
 * http://www.lintcode.com/en/problem/backpack/
 * Given n items with size Ai, an integer m denotes the size of a backpack. How full you can fill this backpack?
 * If we have 4 items with size [2, 3, 5, 7], the backpack size is 11, we can select
 * [2, 3, 5], so that the max size we can fill this backpack is 10.
 * If the backpack size is 12. we can select [2, 3, 7] so that we can fulfill the backpack.
 * You function should return the max size we can fill in the given backpack.
 * You can not divide any item into small pieces.
 * O(n x m) time and O(m) memory.
 * O(n x m) memory is also acceptable if you do not know how to optimize memory.
 * ref: http://algorithm.yuanbin.me/dynamic_programming/backpack.html
 * https://en.wikipedia.org/wiki/Knapsack_problem
 *
 */
public class BackPack {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] A) {
        // write your code here
		boolean[] res = new boolean[m+1];
		res[0] = true;
		
		for(int i=0; i<A.length; i++) {
			for(int j=m; j>=A[i]; j--) {
				res[j] |= res[j-A[i]];
			}
		}
		
		for(int i=m; i>=0; i--) {
			if(res[i]) {
				return i;
			}
		}
		
		return 0;
    }
}
