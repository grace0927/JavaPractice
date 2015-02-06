/**
 * 
 */
package com.javapractice.LeetCode;

/**
 * @author jianyu
 * https://oj.leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete as many transactions 
 * as you like (ie, buy one and sell one share of the stock multiple times). However,
 * you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again). 
 *
 */
public class BestTimeToBuyAndSellStockII {
	public int maxProfit(int[] prices) {
        int sum = 0;
        int[] buy = new int[2];
        buy[0] = 0;
        buy[1] = 0;
        int len = prices.length;
        for(int i = 0; i < len -1; i++) {
        	if(prices[i] <= prices[i+1]) {
        		if(buy[0] == 0) {
        			buy[0] = 1;
        			buy[1] = prices[i];
        		} else {
        			continue;
        		}
        	} else {
        		if(buy[0] == 1) {
        			buy[0] = 0;
        			sum += (prices[i] - buy[1]);
        			buy[1] = 0;
        		} else {
        			continue;
        		}
        	}
        }
        
        if(buy[0] == 1) {
        	sum += (prices[len-1] - buy[1]);
        }
		
		return sum;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
