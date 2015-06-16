/**
 * 
 */
package com.javapractice.lintcode;

/**
 * @author jianyu
 * http://www.lintcode.com/en/problem/unique-binary-search-trees/
 * Given n, how many structurally unique BSTs (binary search trees) that store values 1...n?
 * Given n = 3, there are a total of 5 unique BST's.
 * 1           3    3       2      1
 *  \         /    /       / \      \
 *   3      2     1       1   3      2
 *  /      /       \                  \
 * 2     1          2                  3
 *
 */
public class UniqueBinarySearchTrees {
    /**
     * @paramn n: An integer
     * @return: An integer
     */
    public int numTrees(int n) {
        // write your code here
        if(n==0) {
            return 1;
        }
        int[] ret = new int[n+1];
        ret[0] = 1;
        ret[1] = 1;
        for(int i=2; i<n+1; i++) {
        	for(int j=0; j<i; j++) {
        		ret[i] += ret[j]*ret[i-j-1];
        	}
        }
        return ret[n];
    }
}
