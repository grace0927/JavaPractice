/**
 * 
 */
package leetCode;

/**
 * @author jianyu
 * https://oj.leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 * Note:
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 *
 */
public class BestTimeToBuyAndSellStockIII {
	public int maxProfit(int[] prices) {
		int len = prices.length;
		if(len <= 1) {
			return 0;
		}
		
        int result = 0; // record max profit we made
		int lowest = prices[0]; // record the lowest price we meet
		int highest = prices[len-1]; // record the highest price we meet
		int[] profit = new int[len]; // record the max profix we could made at day
		
		// from left to right, we calculate max profit made using one transaction
		for(int i=0; i<len; i++) {
			lowest = Math.min(lowest, prices[i]);
			result = Math.max(result, prices[i] - lowest);
			profit[i] = result;
		}
		
		// from right to left, we calculate the max profit made using two transaction
		for(int i=len-1; i>=0; i--) {
			highest = Math.max(highest, prices[i]);
			result = Math.max(result, highest - prices[i] + profit[i]);
		}
		
		return result;
    }
	
	/*
	 * https://oj.leetcode.com/discuss/18330/is-it-best-solution-with-o-n-o-1
	 */
	public int maxProfitDPHidden(int[] prices) {
        int hold1 = Integer.MIN_VALUE, hold2 = Integer.MIN_VALUE;
        int release1 = 0, release2 = 0;
        for(int i:prices){                              // Assume we only have 0 money at first
            release2 = Math.max(release2, hold2+i);     // The maximum if we've just sold 2nd stock so far.
            hold2    = Math.max(hold2,    release1-i);  // The maximum if we've just buy  2nd stock so far.
            release1 = Math.max(release1, hold1+i);     // The maximum if we've just sold 1nd stock so far.
            hold1    = Math.max(hold1,    -i);          // The maximum if we've just buy  1st stock so far. 
        }
        return release2; ///Since release1 is initiated as 0, so release2 will always higher than release1.
    }
	
	/*
	 * https://oj.leetcode.com/discuss/15153/a-clean-dp-solution-which-generalizes-to-k-transactions
	 */
	public int maxProfitDP(int[] prices) {
		int len = prices.length;
		if(len <= 1) {
			return 0;
		}
		
        int result = 0; // record max profit we made
		int trans = 2; // max times of transactions
		int[][] ret = new int[trans+1][len]; // ret[i][j] shows max profit at j using at most i trans
		
		for(int i=1; i<=trans; i++) {
			int temp = ret[i-1][0] - prices[0];
			for(int j=1; j<len; j++) {
				ret[i][j] = Math.max(ret[i][j-1], prices[j]+temp);
				temp = Math.max(temp, ret[i-1][j]-prices[j]);
				result = Math.max(result, ret[i][j]);
			}
		}
		
		return result;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
