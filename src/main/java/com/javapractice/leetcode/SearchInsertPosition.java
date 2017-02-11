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
 * https://oj.leetcode.com/problems/search-insert-position/
 * 
 * Given a sorted array and a target value, return the index if the target is found. 
 * If not, return the index where it would be if it were inserted in order.
 * You may assume no duplicates in the array.
 * Here are few examples.
 * [1,3,5,6], 5 �� 2
 * [1,3,5,6], 2 �� 1
 * [1,3,5,6], 7 �� 4
 * [1,3,5,6], 0 �� 0
 * 
 */
public class SearchInsertPosition {
    public int searchInsert(int[] A, int target) {
        int index = 0;
        for(index = 0; index < A.length; index++) {
        	if(target < A[index]) {
        		break;
        	} else if(target == A[index]){
        		break;
        	} else {
        		continue;
        	}
        }
        return index;
    }
}
