# Dynamic Programming

1. [Longest Valid Parentheses](#longest-valid-parentheses)
2. [Unique Paths](#unique-paths)
3. [Unique Paths II](#unique-paths-ii)
4. [Minimum Path Sum](#minimum-path-sum)
5. [Climbing Stairs](#climbing-stairs)
6. [Edit Distance](#edit-distance)
7. [Unique Binary Search Trees](#unique-binary-search-trees)
8. [Unique Binary Search Trees II](#unique-binary-search-trees-ii)
9. [Decode Ways](#decode-ways)
10. [Triangle](#triangle)
11. [Best Time to Buy and Sell Stock](#best-time-to-buy-and-sell-stock)
12. [Word Break](#word-break)
13. [House Robber](#house-robber)
14. [Counting Bits](#counting-bits)
15. [House Robber II](#house-robber-ii)
16. [Range Sum Query - Immutable](#range-sum-query-immutable)
17. [Longest Increasing Subsequence](#longest-increasing-subsequence)
18. [Range Sum Query 2D - Immutable](#range-sum-query-2d-immutable)
19. [Coin Change](#coin-change)
20. [Maximal Square](#maximal-square)
21. [Maximum Product Subarray](#maximum-product-subarray)
22. [Best Time to Buy and Sell Stock with Cooldown](#best-time-to-buy-and-sell-stock-with-cooldown)
23. [Counting Bits](#counting-bits)
24. [Wildcard Matching](#wildcard-matching)
25. [Distinct Subsequences](#distinct-subsequences)
26. [Interleaving String](#interleaving-string)
27. [Scramble String](#scramble-string)
28. [Dungeon Game](#dungeon-game)
29. [Best Time to Buy and Sell Stock III](#best-time-to-buy-and-sell-stock-iii)
30. [Palindrome Partitioning II](#palindrome-partitioning-ii)
31. [Best Time to Buy and Sell Stock IV](#best-time-to-buy-and-sell-stock-iv)

## Longest Valid Parentheses   
Q: Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring. For "(()", the longest valid parentheses substring is "()", which has length = 2. Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.   
```
public int longestValidParentheses(String s) {
    if(s.length()<=1) {
        return 0;
    }
    int len = 0;
    int[] dp = new int[s.length()];
    int left = 0;
    int right = 0;
    for(int i=0; i<s.length(); i++) {
        char c = s.charAt(i);
        if(c=='(') {
            left++;
        } else {
            if(left>0) {
                dp[i] = dp[i-1]+2;
                left--;
                dp[i] += (i-dp[i]>0)?dp[i-dp[i]]:0;
            }
        }
        len = Math.max(len, dp[i]);
    }
    return len;
}
```

## Unique Paths   
Q: A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below). The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below). How many possible unique paths are there?   
```
public int uniquePaths(int m, int n) {
    int[][] dp = new int[m][n];

    // initialize
    for(int i=0; i<m; i++) {
        dp[i][0] = 1;
    }
    for(int i=0; i<n; i++) {
        dp[0][i] = 1;
    }

    // dynamic programming
    for(int i=1; i<m; i++) {
        for(int j=1; j<n; j++) {
            dp[i][j] = dp[i-1][j]+dp[i][j-1];
        }
    }

    return dp[m-1][n-1];
}
```

## Unique Paths II   
Q: Follow up for "Unique Paths": Now consider if some obstacles are added to the grids. How many unique paths would there be? An obstacle and empty space is marked as 1 and 0 respectively in the grid.   
```
public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int row=obstacleGrid.length;
    if(row==0) {
        return 0;
    }
    int col=obstacleGrid[0].length;
    int[][] dp = new int[row][col];

    // initialize
    boolean block = false;
    for(int i=0; i<row; i++) {
        if(obstacleGrid[i][0]==1) {
            block = true;
        }
        dp[i][0] = (block)?0:1;
    }
    block = false;
    for(int i=0; i<col; i++) {
        if(obstacleGrid[0][i]==1) {
            block = true;
        }
        dp[0][i] = (block)?0:1;
    }

    // dynamic programming
    for(int i=1; i<row; i++) {
        for(int j=1; j<col; j++) {
            dp[i][j] = (obstacleGrid[i][j]==1)?0:dp[i-1][j]+dp[i][j-1];
        }
    }

    return dp[row-1][col-1];
}
```

## Minimum Path Sum   
Q: Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path. Note: You can only move either down or right at any point in time.   
```
public int minPathSum(int[][] grid) {
    if(grid.length==0) {
        return 0;
    }
    int row = grid.length;
    int col = grid[0].length;
    int[] dp = new int[col];

    for(int i=0; i<row; i++) {
        dp[0] += grid[i][0];
        for(int j=1; j<col; j++) {
            int offset = (i==0)?dp[j-1]:Math.min(dp[j-1], dp[j]);
            dp[j] = offset+grid[i][j];
        }
    }

    return dp[col-1];
}
```

## Climbing Stairs   
Q: You are climbing a stair case. It takes n steps to reach to the top. Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?   
```
public int climbStairs(int n) {
    if(n<=1) {
        return 1;
    }

    int prev=1, cur=2;
    for(int i=2; i<n; i++) {
        int tmp = cur+prev;
        prev = cur;
        cur = tmp;
    }

    return cur;
}
```

## Edit Distance   
Q: Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.) You have the following 3 operations permitted on a word: a) Insert a character b) Delete a character c) Replace a character   
```
public int minDistance(String word1, String word2) {
    int row=word1.length(), col=word2.length();
    int[][] dp = new int[row+1][col+1];

    for(int i=0; i<=col; i++) {
        dp[0][i] = i;
    }

    for(int i=1; i<=row; i++) {
        dp[i][0] = i;
        for(int j=1; j<=col; j++) {
            dp[i][j] = (word1.charAt(i-1)==word2.charAt(j-1))?dp[i-1][j-1]:dp[i-1][j-1]+1;
            dp[i][j] = Math.min(dp[i][j], dp[i-1][j]+1);
            dp[i][j] = Math.min(dp[i][j], dp[i][j-1]+1);
        }
    }

    return dp[row][col];
}
```

## Unique Binary Search Trees
Q: Given n, how many structurally unique BST's (binary search trees) that store values 1...n?   
```
public int numTrees(int n) {
    int[] dp = new int[n+1];
    dp[0] = 1;
    dp[1] = 1;
    for(int i=2; i<=n; i++) {
        for(int j=1; j<=i; j++) {
            dp[i] += dp[j-1]*dp[i-j];
        }
    }
    return dp[n];
}
```

## Unique Binary Search Trees II
Q: Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.   
```
public List<TreeNode> generateTrees(int n) {
    return helper(1, n);
}

private List<TreeNode> helper(int start, int end) {
    List<TreeNode> list = new ArrayList<>();
    if(start>end) {
        return list;
    }
    if(start==end) {
        list.add(new TreeNode(start));
        return list;
    }
    for(TreeNode right:helper(start+1, end)) {
        TreeNode root = new TreeNode(start);
        root.right = right;
        list.add(root);
    }
    for(int i=start; i<end; i++) {
        for(TreeNode left:helper(start, i-1)) {
            for(TreeNode right:helper(i+1, end)) {
                TreeNode root = new TreeNode(i);
                root.left = left;
                root.right = right;
                list.add(root);
            }
        }
    }
    for(TreeNode left:helper(start, end-1)) {
        TreeNode root = new TreeNode(end);
        root.left = left;
        list.add(root);
    }
    return list;
}
```

## Decode Ways
Q: A message containing letters from A-Z is being encoded to numbers using the following mapping: 'A' -> 1 'B' -> 2 ...' Z' -> 26 Given an encoded message containing digits, determine the total number of ways to decode it.   
```
public int numDecodings(String s) {
    if(s.length()==0) {
        return 0;
    }
    int[] dp = new int[s.length()];
    for(int i=s.length()-1; i>=0; i--) {
        dp[i] = (i==s.length()-1)?1:dp[i+1];
        if(s.charAt(i)=='0') {
            dp[i] = 0;
        } else if(i<s.length()-1 && (s.charAt(i)=='1' || (s.charAt(i)=='2'&&s.charAt(i+1)<'7'))) {
            dp[i] += (i<s.length()-2)?dp[i+2]:1;
        }
    }
    return dp[0];
}
```

## Triangle
Q: Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below. Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.   
```
public int minimumTotal(List<List<Integer>> triangle) {
    if(triangle.size()==0) {
        return 0;
    }
    int[] dp = new int[triangle.size()];
    for(int i=0; i<triangle.size(); i++) {
        dp[i] = triangle.get(triangle.size()-1).get(i);
    }
    for(int i=triangle.size()-2; i>=0; i--) {
        List<Integer> cur = triangle.get(i);
        List<Integer> pre = triangle.get(i+1);
        for(int j=0; j<cur.size(); j++) {
            dp[j] = cur.get(j)+Math.min(dp[j], dp[j+1]);
        }
    }
    return dp[0];
}
```

##  Best Time to Buy and Sell Stock
Q: Say you have an array for which the ith element is the price of a given stock on day i. If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.   
```
public int maxProfit(int[] prices) {
    if(prices.length<2) {
        return 0;
    }
    int min=prices[0], profit=0;
    for(int i=0; i<prices.length; i++) {
        profit = Math.max(prices[i]-min, profit);
        min = Math.min(prices[i], min);
    }
    return profit;
}
```

## Word Break
Q: Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.   
```
public boolean wordBreak(String s, Set<String> wordDict) {
    HashSet<Integer> set = new HashSet<>();
    for(int i=1; i<=s.length(); i++) {
        if(wordDict.contains(s.substring(0, i))) {
            set.add(i);
            continue;
        }
        for(int j:set) {
            if(wordDict.contains(s.substring(j, i))) {
                set.add(i);
                break;
            }
        }
    }

    return set.contains(s.length());
}
```

## House Robber
Q: You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night. Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.   
```
public int rob(int[] nums) {
    if(nums.length<2) {
        return (nums.length==0)?0:nums[0];
    }
    int a=nums[0], b=Math.max(nums[1], nums[0]);
    for(int i=2; i<nums.length; i++) {
        int c = Math.max(a+nums[i], b);
        a = b;
        b = c;
    }
    return Math.max(a, b);
}
```

## Counting Bits
Q: Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array. Follow up: It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass? Space complexity should be O(n). Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.   
```
// O(n*sizeof(integer))
public int[] countBits(int num) {
    int[] res = new int[num+1];
    for(int i=0; i<=num; i++) {
        int j=0;
        while((i>>j)>0) {
            res[i] += (i>>j)&1;
            j++;
        }
    }
    return res;
}
// O(n) /possibly
public int[] countBits(int num) {
    int[] res = new int[num+1];
    int pnt=1;
    while(pnt<=num) {
        for(int i=0; i<pnt && pnt+i<=num; i++) {
            res[pnt+i] = res[i]+1;
        }
        pnt *= 2;
    }
    return res;
}
```

## House Robber II
Q: Note: This is an extension of House Robber. After robbing those houses on that street, the thief has found himself a new place for his thievery so that he will not get too much attention. This time, all houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, the security system for these houses remain the same as for those in the previous street. Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.   
```
public int rob(int[] nums) {
    int n=nums.length, res=0;
    if(n<=1) {
        return (n==1)?nums[0]:0;
    }
    int[] dp = new int[n];
    for(int i=0; i<n-1; i++) {
        dp[i] = (i>1)?Math.max(dp[i-2]+nums[i], dp[i-1]):(i==0)?nums[i]:Math.max(nums[i], nums[i-1]);
    }
    res = dp[n-2];
    dp[0] = 0;
    for(int i=1; i<n; i++) {
        dp[i] = (i>1)?Math.max(dp[i-2]+nums[i], dp[i-1]):nums[i];
    }
    res = Math.max(res, dp[n-1]);
    return res;
}
```

## Range Sum Query - Immutable
Q: Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive. Note: You may assume that the array does not change. There are many calls to sumRange function.   
```
public class NumArray {
    int[] sums;

    public NumArray(int[] nums) {
        this.sums = new int[nums.length];
        for(int i=0; i<nums.length; i++) {
            sums[i] = (i>0)?sums[i-1]+nums[i]:nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return (i>0)?sums[j]-sums[i-1]:sums[j];
    }
}
```

## Longest Increasing Subsequence
Q: Given an unsorted array of integers, find the length of longest increasing subsequence. Your algorithm should run in O(n2) complexity. Follow up: Could you improve it to O(n log n) time complexity?   
better solution ref: https://leetcode.com/discuss/67609/short-java-solution-using-dp-o-n-log-n   
```
public int lengthOfLIS(int[] nums) {
    int len=0, n=nums.length;
    int[] dp = new int[n];
    for(int i=n-1; i>=0; i--) {
        dp[i] = 1;
        for(int j=i+1; j<n; j++) {
            int tmp = (nums[j]>nums[i])?dp[j]+1:1;
            dp[i] = Math.max(tmp, dp[i]);
        }
        len = Math.max(len, dp[i]);
    }
    return len;
}
```

## Range Sum Query 2D - Immutable
Q: Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2). You may assume that the matrix does not change. There are many calls to sumRegion function. You may assume that row1 ≤ row2 and col1 ≤ col2.   
```
public class NumMatrix {
    private int[][] sums;

    public NumMatrix(int[][] matrix) {
        if(matrix!=null && matrix.length>0) {
        sums = new int[matrix.length][matrix[0].length];
            for(int i=0; i<matrix.length; i++) {
                sums[i][0] = (i>0)?matrix[i][0]+sums[i-1][0]:matrix[i][0];
                for(int j=1; j<matrix[0].length; j++) {
                    sums[i][j] = sums[i][j-1]+matrix[i][j];
                    sums[i][j] += (i>0)?sums[i-1][j]-sums[i-1][j-1]:0;
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(sums==null||sums.length==0) {
            return 0;
        }
        if(row1==0) {
            return (col1==0)?sums[row2][col2]:sums[row2][col2]-sums[row2][col1-1];
        }
        if(col1==0) {
            return sums[row2][col2]-sums[row1-1][col2];
        }
        return sums[row2][col2]-sums[row2][col1-1]-sums[row1-1][col2]+sums[row1-1][col1-1];
    }
}

```

## Coin Change
Q: You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1. You may assume that you have an infinite number of each kind of coin.    
good solution ref: https://leetcode.com/discuss/76217/java-both-iterative-recursive-solutions-with-explanations   
```
public int coinChange(int[] coins, int amount) {
    int[] dp = new int[amount+1];
    return helper(coins, amount, dp);
}

private int helper(int[] coins, int amount, int[] dp) {
    if(amount<=0) {
        return (amount==0)?0:-1;
    }

    int res=Integer.MIN_VALUE;
    for(int i=0; i<coins.length; i++) {
        if(amount<coins[i]) {
            continue;
        }
        int left = amount-coins[i];
        int tmp = (dp[left]!=0)?dp[left]:helper(coins, left, dp);
        if(tmp>=0) {
            res = (res>=0)?Math.min(res, tmp+1):tmp+1;
        }
    }

    res = Math.max(res, -1);
    dp[amount] = res;

    return res;
}
```

## Maximal Square
Q: Given a 2D binary matrix filled with 0's and 1's, find the largest square containing all 1's and return its area.   
```
public int maximalSquare(char[][] matrix) {
    int row=matrix.length;
    if(row<=0) {
        return 0;
    }
    int col=matrix[0].length, max=Integer.MIN_VALUE;
    int[][] dp = new int[row][col];
    for(int i=0; i<col; i++) {
        dp[0][i] = (matrix[0][i]=='1')?1:0;
        max = Math.max(max, dp[0][i]);
    }
    for(int i=1; i<row; i++) {
        dp[i][0] = (matrix[i][0]=='1')?1:0;
        max = Math.max(max, dp[i][0]);
        for(int j=1; j<col; j++) {
            if(matrix[i][j]=='1') {
                int up = Math.min(dp[i-1][j], dp[i-1][j-1]);
                int left = Math.min(dp[i][j-1], dp[i-1][j-1]);
                dp[i][j] = Math.min(up, left)+1;
            }
            max = Math.max(max, dp[i][j]);
        }
    }
    return max*max;
}
```

## Maximum Product Subarray
Q: Find the contiguous subarray within an array (containing at least one number) which has the largest product.   
```
public int maxProduct(int[] nums) {
    int n=nums.length;
    if(n==0) {
        return 0;
    }

    int max=1, min=1, res=Integer.MIN_VALUE;
    for(int i=0; i<n; i++) {
        if(nums[i]<0) {
            int tmp = max;
            max = Math.max(min*nums[i], nums[i]);
            min = Math.min(tmp*nums[i], nums[i]);
        } else {
            max = Math.max(max*nums[i], nums[i]);
            min = Math.min(min*nums[i], nums[i]);
        }
        res = Math.max(res, max);
    }

    return res;
}
```

## Best Time to Buy and Sell Stock with Cooldown
Q: Say you have an array for which the ith element is the price of a given stock on day i. Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions: You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again). After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)   
good ref: https://leetcode.com/discuss/71354/share-my-thinking-process   
https://leetcode.com/discuss/72030/share-my-dp-solution-by-state-machine-thinking   
https://leetcode.com/discuss/71391/easiest-java-solution-with-explanations   
```
public int maxProfit(int[] prices) {
    int n=prices.length;
    if(n<2) {
        return 0;
    }
    int[] profit=new int[n];
    int[] buy = new int[n];
    buy[0] = prices[0];
    for(int i=1; i<n; i++) {
        buy[i] = Math.min(buy[i-1], prices[i]);
        profit[i] = Math.max(0, prices[i]-buy[i-1]);
        for(int j=0; j<i-2; j++) {
            profit[i] = Math.max(profit[i], profit[j]+prices[i]-prices[j+2]);
        }
        profit[i] = Math.max(profit[i-1], profit[i]);
    }
    return profit[n-1];
}
// better
public int maxProfit(int[] prices) {
    int sell = 0, prev_sell = 0, buy = Integer.MIN_VALUE, prev_buy;
    for (int price : prices) {
        prev_buy = buy;
        buy = Math.max(prev_sell - price, prev_buy);
        prev_sell = sell;
        sell = Math.max(prev_buy + price, prev_sell);
    }
    return sell;

}
```

## Counting Bits
Q: Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array. Follow up: It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass? Space complexity should be O(n). Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.   
```
public int[] countBits(int num) {
    int[] res = new int[num+1];
    res[0] = 0;
    int base=1;
    while(base<=num) {
        for(int i=0; i<base; i++) {
            if(base+i>num) {
                return res;
            }
            res[base+i] = res[i]+1;
        }
        base<<=1;
    }
    return res;
}
// better idea
public int[] countBits(int num) {
    int[] f = new int[num + 1];
    for (int i=1; i<=num; i++) f[i] = f[i >> 1] + (i & 1);
    return f;
}
```

## Wildcard Matching
Q: Implement wildcard pattern matching with support for '?' and '*'. '?' Matches any single character. '*' Matches any sequence of characters (including the empty sequence). The matching should cover the entire input string (not partial).   
good ref: https://leetcode.com/discuss/52274/three-solutions-iterative-16ms-180ms-modified-recursion-88ms   
```
// dp
public boolean isMatch(String s, String p) {
    int ls=s.length(), lp=p.length();
    boolean[][] dp = new boolean[ls+1][lp+1];
    dp[0][0]=true;
    for(int i=0; i<lp; i++) {
        dp[0][i+1] = dp[0][i]&&p.charAt(i)=='*';
    }
    for(int i=0; i<ls; i++) {
        char sc = s.charAt(i);
        for(int j=0; j<lp; j++) {
            char pc = p.charAt(j);
            dp[i+1][j+1] = (dp[i][j] && (sc==pc || pc=='?' || pc=='*')) || (p.charAt(j)=='*' && (dp[i][j+1] || dp[i+1][j]));
        }
    }
    return dp[ls][lp];
}
// greedy && backtracking
public boolean isMatch(String s, String p) {
    int lenS=s.length(), lenP=p.length(), indexS=0, indexP=0, match=0, indexStar=-1;

    while(indexS < lenS) {
        char curS = s.charAt(indexS);

        if(indexP<lenP && (p.charAt(indexP)=='?' || p.charAt(indexP)==curS)) {
            indexS++;
            indexP++;
        } else if(indexP<lenP && p.charAt(indexP)=='*') {
            indexStar = indexP;
            match = indexS;
            indexP++;
        } else if(indexStar != -1) {
            indexP = indexStar+1;
            match++;
            indexS = match;
        } else {
            return false;
        }
    }

    while(indexP<lenP && p.charAt(indexP)=='*') {
        indexP++;
    }

    return (indexP==lenP);
}
```

## Distinct Subsequences
Q: Given a string S and a string T, count the number of distinct subsequences of T in S. A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not). Here is an example: S = "rabbbit", T = "rabbit" Return 3.   
```
public int numDistinct(String s, String t) {
    int ls=s.length(), lt=t.length();
    int[][] dp = new int[ls+1][lt+1];

    for(int i=0; i<=ls; i++) {
        dp[i][0] = 1;
    }

    for(int i=0; i<ls; i++) {
        char sc = s.charAt(i);
        for(int j=0; j<lt; j++) {
            char tc = t.charAt(j);
            dp[i+1][j+1] = dp[i][j+1];
            dp[i+1][j+1] += (sc==tc)?dp[i][j]:0;
        }
    }

    return dp[ls][lt];
}
```

## Interleaving String
Q: Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.   
good ref: https://leetcode.com/discuss/70689/summary-of-solutions-bfs-dfs-dp    
```
public boolean isInterleave(String s1, String s2, String s3) {
    int l1=s1.length(), l2=s2.length(), l3=s3.length();
    if(l1+l2!=l3) {
        return false;
    }
    if(l1==0 || l2==0) {
        return s3.equals(s1+s2);
    }

    boolean[][] dp = new boolean[l1+1][l2+1];
    dp[0][0] = true;
    for(int i=0; i<l1; i++) {
        dp[i+1][0] = (s1.charAt(i)==s3.charAt(i))&&dp[i][0];
    }
    for(int i=0; i<l2; i++) {
        dp[0][i+1] = (s2.charAt(i)==s3.charAt(i))&&dp[0][i];
    }

    for(int i=0; i<l1; i++) {
        char c1 = s1.charAt(i);
        for(int j=0; j<l2; j++) {
            char c2 = s2.charAt(j);
            char c3 = s3.charAt(i+j+1);
            dp[i+1][j+1] = (c2==c3 && dp[i+1][j]) || (c1==c3 && dp[i][j+1]);
        }
    }

    return dp[l1][l2];
}
```

## Scramble String
Q: Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively. Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.    
```
public boolean isScramble(String s1, String s2) {
    int l1=s1.length(), l2=s2.length();
    if(l1!=l2) {
        return false;
    }

    boolean[][][] dp = new boolean[l1][l1][l1+1];
    for(int i=0; i<l1; i++) {
        char c1 = s1.charAt(i);
        for(int j=0; j<l1; j++) {
            char c2 = s2.charAt(j);
            dp[i][j][1] = (c1==c2);
        }
    }

    for(int i=2; i<=l1; i++) {
        for(int j=0; j<l1 && j+i<=l1; j++) {
            for(int k=0; k<l1 && k+i<=l1; k++) {
                for(int l=1; l<i; l++) {
                    dp[j][k][i] |= dp[j][k][l] && dp[j+l][k+l][i-l];
                    dp[j][k][i] |= dp[j][k+i-l][l] && dp[j+l][k][i-l];
                }
            }
        }
    }

    return dp[0][0][l1];
}
```

## Dungeon Game
Q: The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant knight (K) was initially positioned in the top-left room and must fight his way through the dungeon to rescue the princess. The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately. Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms; other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers). In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step. Write a function to determine the knight's minimum initial health so that he is able to rescue the princess. Notes: The knight's health has no upper bound. Any room can contain threats or power-ups, even the first room the knight enters and the bottom-right room where the princess is imprisoned.   
```
public int calculateMinimumHP(int[][] dungeon) {
    int row = dungeon.length;
    if(row<=0) {
        return 0;
    }
    int col = dungeon[0].length;
    int[][] dp = new int[row][col];
    dp[row-1][col-1] = (dungeon[row-1][col-1]>=0)?1:-dungeon[row-1][col-1]+1;

    for(int i=col-2; i>=0; i--) {
        dp[row-1][i] = (dungeon[row-1][i]>=dp[row-1][i+1])?1:(dp[row-1][i+1]-dungeon[row-1][i]);
    }

    for(int i=row-2; i>=0; i--) {
        dp[i][col-1] = (dungeon[i][col-1]>=dp[i+1][col-1])?1:(dp[i+1][col-1]-dungeon[i][col-1]);
        for(int j=col-2; j>=0; j--) {
            int r = (dungeon[i][j]>=dp[i+1][j])?1:(dp[i+1][j]-dungeon[i][j]);
            int d = (dungeon[i][j]>=dp[i][j+1])?1:(dp[i][j+1]-dungeon[i][j]);
            dp[i][j] = Math.min(r, d);
        }
    }

    return dp[0][0];
}
```

## Best Time to Buy and Sell Stock III
Q: Say you have an array for which the ith element is the price of a given stock on day i. Design an algorithm to find the maximum profit. You may complete at most two transactions.   
```
public int maxProfit(int[] prices) {
    int n=prices.length, min=Integer.MAX_VALUE, max=Integer.MIN_VALUE;
    int[] left = new int[n];
    int[] right = new int[n];
    for(int i=0; i<n; i++) {
        left[i] = (prices[i]>min)?prices[i]-min:0;
        if(i>0) {
            left[i] = Math.max(left[i], left[i-1]);
        }
        min = Math.min(prices[i], min);
    }
    for(int i=n-1; i>=0; i--) {
        right[i] = (prices[i]<max)?max-prices[i]:0;
        if(i<n-1) {
            right[i] = Math.max(right[i], right[i+1]);
        }
        max = Math.max(prices[i], max);
    }

    max = 0;
    for(int i=0; i<n; i++) {
        max = Math.max(max, left[i]+right[i]);
    }

    return max;
}
```

## Palindrome Partitioning II
Q: Given a string s, partition s such that every substring of the partition is a palindrome. Return the minimum cuts needed for a palindrome partitioning of s.   
good ref: https://leetcode.com/discuss/9476/solution-does-not-need-table-palindrome-right-uses-only-space   
```
public int minCut(String s) {
    int n = s.length();
    boolean[][] dp = new boolean[n][n];
    for(int i=0; i<n; i++) {
        dp[i][i] = true;
    }
    for(int l=1; l<n; l++) {
        for(int i=0; i<n-l; i++) {
            dp[i][i+l] = s.charAt(i)==s.charAt(i+l);
            if(l>1) {
                 dp[i][i+l] &= dp[i+1][i+l-1];
            }
        }
    }

    int[] min = new int[n];
    for(int i=0; i<n; i++) {
        if(dp[0][i]) {
            min[i] = 0;
        } else {
            min[i] = min[i-1]+1;
            for(int j=0; j<i; j++) {
                if(dp[j+1][i]) {
                    min[i] = Math.min(min[j]+1, min[i]);
                }
            }
        }
    }

    return min[n-1];
}
```

## Best Time to Buy and Sell Stock IV
Q: Say you have an array for which the ith element is the price of a given stock on day i. Design an algorithm to find the maximum profit. You may complete at most k transactions. Note:You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).   
```
public int maxProfit(int k, int[] prices) {
    int n = prices.length;
    if(k>n/2) {
        return max(prices);
    }

    int[][] balance = new int[k+1][n];
    int[][] profit = new int[k+1][n];
    int max = Integer.MIN_VALUE;
    for(int i=1; i<=k; i++) {
        for(int j=0; j<n; j++) {
            balance[i][j] = (j==0)?-prices[j]:Math.max(profit[i-1][j-1]-prices[j], balance[i][j-1]);
            profit[i][j] = (j==0)?0:Math.max(balance[i][j]+prices[j], profit[i][j-1]);
        }
    }

    return profit[k][n-1];
}
private int max(int[] prices) {
    int max = 0;
    for(int i=1; i<prices.length; i++) {
        max += Math.max(prices[i]-prices[i-1], 0);
    }
    return max;
}
```
