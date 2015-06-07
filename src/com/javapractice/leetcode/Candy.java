package com.javapractice.leetcode;

/*
 * https://oj.leetcode.com/problems/candy/
 * 
 * There are N children standing in a line. Each child is assigned a rating value.
 * You are giving candies to these children subjected to the following requirements:
 *   1. Each child must have at least one candy.
 *   2. Children with a higher rating get more candies than their neighbors.
 * What is the minimum candies you must give?
 * 
 */

public class Candy {
    public int candy(int[] ratings) {
        int size = ratings.length;
        int sum = size;
        
        int candy = 0;
        int[] candyArr = new int[size];
        candyArr[0] = 0;
        for(int i=1; i < size; i++) {
        	if(ratings[i] > ratings[i-1]) {
        		candy++;
        	} else {
        		candy=0;
        	}
        	candyArr[i]=candy;
        }
        candy=0;
        for(int i=size-2; i>=0; i--) {
        	if(ratings[i] > ratings[i+1]) {
        		candy++;
        	} else {
        		candy=0;
        	}
        	sum+=Math.max(candy, candyArr[i]); // pick the maximum required candies
        }
        sum+=candyArr[size-1]; // handle the last one element
        return sum;
    }
}
