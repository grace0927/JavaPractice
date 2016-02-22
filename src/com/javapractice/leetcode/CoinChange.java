/**
 * 
 */
package com.javapractice.leetcode;

import java.util.Arrays;

/**
 * @author Feng
 * https://leetcode.com/problems/coin-change/
 * You are given coins of different denominations and a total amount of money amount. 
 * Write a function to compute the fewest number of coins that you need to make up that 
 * amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 * Example 1:
 * coins = [1, 2, 5], amount = 11
 * return 3 (11 = 5 + 5 + 1)
 * Example 2:
 * coins = [2], amount = 3
 * return -1.
 * Note:
 * You may assume that you have an infinite number of each kind of coin.
 *
 */
public class CoinChange implements Solution {
	public void test() {
		CoinChange test = new CoinChange();
    	int[] coins = {186, 419, 83, 408};
    	System.out.println(test.coinChangeItertive(coins, 6249));
	}
	
	public int coinChangeItertive(int[] coins, int amount) {
		if(amount <= 0) {
			return 0;
		}
		
		int[] buf = new int[amount+1];
		buf[0] = 0;
		for(int i=1; i<=amount; i++) {
			buf[i] = Integer.MAX_VALUE;
		}
		
		for(int i=0; i<=amount; i++) {
			for(int coin:coins) {
				if(i-coin>=0 && buf[i-coin]<Integer.MAX_VALUE && buf[i]>buf[i-coin]+1) {
					buf[i] = buf[i-coin]+1;
				}
			}
		}
		return buf[amount]<Integer.MAX_VALUE?buf[amount]:-1;
	}
	
    public int coinChangeRecurisve(int[] coins, int amount) {
        Arrays.sort(coins);
        return coinChangeUtil(coins, amount, coins.length-1);
    }
    
    public int coinChangeUtil(int[] coins, int amount, int end) {
        if(amount == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        
        for(int i=end; i>=0; i--) {
            if(coins[i]>amount) {
                continue;
            }
            int len = coinChangeUtil(coins, amount-coins[i], i);
            if(len >= 0) {
                min = Math.min(len+1, min);
            }
        }
        
        return (min<Integer.MAX_VALUE)?min:-1;
    }
    
    public int coinChangeUtilDP(int[] coins, int amount, int[] buf) {
        if(amount == 0) {
            return 0;
        }
        if(buf[amount-1] != 0) {
            return buf[amount-1];
        }
        int min = Integer.MAX_VALUE;
        
        for(int i=coins.length-1; i>=0; i--) {
            if(coins[i]>amount) {
                continue;
            }
            int len = coinChangeUtilDP(coins, amount-coins[i], buf);
            if(len >= 0) {
                min = Math.min(len+1, min);
            }
        }
        
        buf[amount-1] = (min<Integer.MAX_VALUE)?min:-1;
        return buf[amount-1];
    }
}
