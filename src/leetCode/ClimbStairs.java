package leetCode;

public class ClimbStairs {
	public int climbStairs(int n) {
		int[] res = new int[n];
		if(n < 2) {
			return n;
		};
		
		res[0] = 1;
		res[1] = 2;
		for(int i = 0; i < n; i++) {
			res[i] = res[i-1] + res[i-2];
		}
		
		return res[n-1];
    }
	public int maxProfit(int[] prices) {
        int sum = 0;
        int[] buy = new int[2];
        buy[0] = 0;
        buy[1] = 0;
        for(int i = 0; i < prices.length-1; i++) {
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
        	sum += (prices[prices.length-1] - buy[1]);
        }
		
		return sum;
    }
}
