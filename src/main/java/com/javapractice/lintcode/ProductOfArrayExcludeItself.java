/**
 * 
 */
package com.javapractice.lintcode;

import java.util.ArrayList;

/**
 * @author jianyu
 * http://www.lintcode.com/en/problem/product-of-array-exclude-itself/
 * Given an integers array A.
 * Define B[i] = A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1], calculate B WITHOUT divide operation.
 * For A = [1, 2, 3], return [6, 3, 2].
 *
 */
public class ProductOfArrayExcludeItself {
    /**
     * @param A: Given an integers array A
     * @return: A Long array B and B[i]= A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1]
     */
    public ArrayList<Long> productExcludeItself(ArrayList<Integer> A) {
        // write your code
        int len = A.size();
        long[] C = new long[len];
        long[] D = new long[len];

        C[0] = 1;
        for(int i=1; i<len; i++) {
        	C[i] = (long)C[i-1] * A.get(i-1);
        }
        D[len-1] = 1;
        for(int i=len-2; i>=0; i--) {
        	D[i] = (long)D[i+1] * A.get(i+1);
        }

        ArrayList<Long> res = new ArrayList<>();
        for(int i=0; i<len; i++) {
        	res.add(new Long(C[i]*D[i]));
        }

        return res;
    }
}
