/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.javapractice.leetcode;

/**
 *
 * @author jianyu
 * 
 * https://oj.leetcode.com/problems/single-number/
 * Given an array of integers, every element appears twice except for one. Find that single one.
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * 
 */

public class SingleNumber {
    public int singleNumber(int[] A) {
        int num = 0;
        int i;
        for(i=0; i<A.length; i++) {
            num ^= A[i];
        }
        
        return num;
    }
    
    public int singleNumberThree(int[] A) {
    	int num = 0;
    	
    	return num;
    }
}
