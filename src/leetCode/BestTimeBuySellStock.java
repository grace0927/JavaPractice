/**
 * 
 */
package leetCode;

/**
 * 
 * https://oj.leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like 
 * (ie, buy one and sell one share of the stock multiple times). However, 
 * you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 *
 */
public class BestTimeBuySellStock {

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
            	// case 1: price goes up
                int temp = prices[i] - low;
                max = (temp>max)?temp:max;
            } else {
            	// case 2: price goes down
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
