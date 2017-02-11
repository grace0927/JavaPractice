/**
 * 
 */
package com.javapractice.leetcode;

/**
 * @author Feng
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. 
 * You may complete as many transactions as you like 
 * (ie, buy one and sell one share of the stock multiple times) with the following restrictions:
 * You may not engage in multiple transactions at the same time 
 * (ie, you must sell the stock before you buy again).
 * After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
 * Example:
 * prices = [1, 2, 3, 0, 2]
 * maxProfit = 3transactions = [buy, sell, cooldown, buy, sell]
 *
 */
public class BestTimeToBuyAndSellStockWithCooldown implements Solution {
	public void test() {
    	int[] prices = {6,1,3,2,4,7}; 
    	maxProfit(prices);
	}
	
	/*
	 * ref: https://leetcode.com/discuss/71354/share-my-thinking-process
    int sell = 0, prev_sell = 0, buy = Integer.MIN_VALUE, prev_buy;
    for (int price : prices) {
        prev_buy = buy;
        buy = Math.max(prev_sell - price, prev_buy);
        prev_sell = sell;
        sell = Math.max(prev_buy + price, prev_sell);
    }
    return sell;
	 */
	public int maxProfit(int[] prices) {
        int len = prices.length;
        if(len<=0) {
            return 0;
        }
        int[] buy = new int[len];
        int[] sell = new int[len];
        int[] cool = new int[len];
        for(int i=0; i<len; i++) {
            buy[i] = (i>0)?Math.max(buy[i-1], cool[i-1]-prices[i]):-prices[i];
            sell[i] = (i>0)?Math.max(buy[i-1]+prices[i], sell[i-1]):0;
            cool[i] = (i>0)?Math.max(sell[i-1], cool[i-1]):0;
        }
        
        return Math.max(buy[len-1], Math.max(sell[len-1], cool[len-1]));
    }
}
