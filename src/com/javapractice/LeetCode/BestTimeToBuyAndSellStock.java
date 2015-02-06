/**
 * 
 */
package com.javapractice.LeetCode;

/**
 * @author jianyu
 * https://oj.leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one 
 * share of the stock), design an algorithm to find the maximum profit.
 *
 */
public class BestTimeToBuyAndSellStock {
	public int maxProfit(int[] prices) {
        if(prices == null) {
            // special case 1: no price list
            return 0;
        } else if(prices.length == 0) {
            // special case 2: no price list
            return 0;
        }
        
        int max = 0;
        int low = prices[0];
        for(int i=1; i<prices.length; i++) {
            if(prices[i] >= prices[i-1]) {
                int temp = prices[i] - low;
                max = (temp>max)?temp:max;
            } else {
                low = prices[i]>low?low:prices[i];
            }
        }
        return max;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
