package com.javapractice.leetcode;

/*
 * https://oj.leetcode.com/problems/unique-binary-search-trees/
 * 
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 * For example,
 * Given n = 3, there are a total of 5 unique BST's.
 *    1         3     3      2      1
 *    \       /     /      / \      \
 *     3     2     1      1   3      2
 *    /     /       \                 \
 *   2     1         2                 3
 *  
 */

public class UniqueBST {
    public int numTrees(int n) {
    	/* recursive */
        switch(n) {
            case 0:
                return 1;
            case 1:
                return 1;
            case 2:
                return 2;
            default:
                int result=0;
                for(int i=0; i<n; i++) {
                    result += numTrees(i) * numTrees(n-1-i);
                }
                return result;
        }
    }
    
    public int numTreesDP(int n){
    	/* iteration (Dynamic Program) */
    	if(n<0) {
    		return 0;
    	} else if(n==0) {
    		return 1;
    	} else {
    		Integer[] result = new Integer[n+1];
    		result[0] = 1;
    		result[1] = 1;
    		for(int i=2; i<n+1; i++) {
    			result[i]=0;
    			for(int j=0; j<i; j++){
    				result[i] += result[j] * result[i-j-1];
    			}
    		}
    		return result[n];
    	}
    }
}
