/**
 * 
 */
package com.javapractice.leetcode;

/**
 * @author jianyu
 * https://oj.leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete at most k transactions.
 * Note:
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * ref: https://oj.leetcode.com/discuss/25603/a-concise-dp-solution-in-java
 *
 */
public class BestTimeToBuyAndSellStockIV {
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
		if(k >= len/2) {
			return maximum(prices);
		}
		
		int[] balance = new int[k+1];
		int[] profit = new int[k+1];
		
		for(int i=0; i<len; i++) {
			for(int j=1; j<=k; j++) {
			    if(i==0) {
			        balance[j] = -prices[0];
			    } else {
				    balance[j] = Math.max(profit[j-1]-prices[i], balance[j]);
			    }
				profit[j] = Math.max(balance[j]+prices[i], profit[j]);
			}
		}
		
		return profit[k];
    }
	
	public int maximum(int[] prices) {
		int len = prices.length;
		if(len == 0) {
			return 0;
		}
		
		int lastPrice = prices[0];
		int sumProfit = 0;
		for(int i=1; i<len; i++) {
			int curPrice = prices[i];
			if(curPrice > lastPrice) {
				sumProfit += (curPrice - lastPrice);
			}
			lastPrice = curPrice;
		}
		
		return sumProfit;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
