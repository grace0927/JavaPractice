#Greedy

1. [Jump Game](#jump-game)
2. [Jump Game II](#jump-game-ii)
3. [Best Time to Buy and Sell Stock II](#best-time-to-buy-and-sell-stock-ii)
4. [Candy](#candy)
5. [Gas Station](#gas-station)
6. [Patching Array](#patching-array)
7. [Remove Duplicate Letters](#remove-duplicate-letters)
8. [Create Maximum Number](#create-maximum-number)

##Jump Game   
Q: Given an array of non-negative integers, you are initially positioned at the first index of the array. Each element in the array represents your maximum jump length at that position. Determine if you are able to reach the last index. For example:A = [2,3,1,1,4], return true.A = [3,2,1,0,4], return false.   
```
public boolean canJump(int[] nums) {
    int max=0, pnt=0;

    while(pnt<=max) {
        max = Math.max(max, pnt+nums[pnt]);
        if(max>=nums.length-1) {
            return true;
        }
        pnt++;
    }

    return false;
}
```

##Jump Game II   
Q: Given an array of non-negative integers, you are initially positioned at the first index of the array. Each element in the array represents your maximum jump length at that position. Your goal is to reach the last index in the minimum number of jumps.   
For example:   
Given array A = [2,3,1,1,4]   
The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)   
```
public int jump(int[] nums) {
    int step=0, max=0, prev=0;

    for(int i=0; i<nums.length-1; i++) {
        if(i>prev) {
            step++;
            prev = max;
        }
        int reach = i+nums[i];
        if(reach>=nums.length-1) {
            return step+1;
        }
        max = Math.max(max, reach);
    }

    return step;
}
```

##Best Time to Buy and Sell Stock II
Q: Say you have an array for which the ith element is the price of a given stock on day i. Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).   
```
public int maxProfit(int[] prices) {
    int profit = 0;
    for(int i=1; i<prices.length; i++) {
        profit += Math.max(prices[i]-prices[i-1], 0);
    }
    return profit;
}
```

##Candy
Q: There are N children standing in a line. Each child is assigned a rating value. You are giving candies to these children subjected to the following requirements: Each child must have at least one candy. Children with a higher rating get more candies than their neighbors. What is the minimum candies you must give?   
```
public int candy(int[] ratings) {
    int n=ratings.length, candy=ratings.length;
    if(n<2) {
        return n;
    }
    int[] arr = new int[n];

    for(int i=1; i<n; i++) {
        if(ratings[i]>ratings[i-1]) {
            arr[i] = arr[i-1]+1;
        }
    }
    for(int i=n-2; i>=0; i--) {
        if(ratings[i]>ratings[i+1] && arr[i]<=arr[i+1]) {
            arr[i] = arr[i+1]+1;
        }
    }
    for(int i=0; i<n; i++) {
        candy += arr[i];
    }

    return candy;
}
```

## Gas Station
Q: There are N gas stations along a circular route, where the amount of gas at station i is gas[i]. You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations. Return the starting gas station's index if you can travel around the circuit once, otherwise return -1. Note: The solution is guaranteed to be unique.   
```
public int canCompleteCircuit(int[] gas, int[] cost) {
    int pnt=0, start=0, tank=0;
    while(start<gas.length) {
        tank += gas[pnt]-cost[pnt];
        if(tank<0) {
            if(start == pnt+1) {
                return -1;
            }
            start = pnt+1;
            tank = 0;
        } else if(start==((pnt+1)%gas.length)) {
            return start;
        }
        pnt = (pnt+1)%gas.length;
    }
    return -1;
}
```

##Patching Array
Q: Given a sorted positive integer array nums and an integer n, add/patch elements to the array such that any number in range [1, n] inclusive can be formed by the sum of some elements in the array. Return the minimum number of patches required.   
good ref: https://leetcode.com/discuss/83272/share-my-thinking-process   
```
public int minPatches(int[] nums, int n) {
    long cnt=0, cur=1;
    int pnt=0;
    while(cur<=n) {
        if(pnt<nums.length && cur>=nums[pnt]) {
            cur += nums[pnt++];
        } else {
            cnt++;
            cur += cur;
        }
    }

    return (int)cnt;
}
```

##Remove Duplicate Letters
Q: Given a string which contains only lowercase letters, remove duplicate letters so that every letter appear once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.   
```
public String removeDuplicateLetters(String s) {
    int[] map = new int[26];
    for(int i=0; i<s.length(); i++) {
        map[s.charAt(i)-'a']++;
    }

    LinkedList<Character> stack = new LinkedList<>();
    for(int i=0; i<s.length(); i++) {
        char cur = s.charAt(i);
        if(stack.contains(cur)) {
            map[cur-'a']--;
            continue;
        }
        while(!stack.isEmpty() && stack.peekLast()>=cur && map[stack.peekLast()-'a']>0) {
            stack.pollLast();
        }
        stack.add(cur);
        map[cur-'a']--;
    }

    StringBuilder sb = new StringBuilder();
    while(!stack.isEmpty()) {
        sb.insert(0, stack.pollLast());
    }

    return sb.toString();
}
```

##Create Maximum Number
Q: Given two arrays of length m and n with digits 0-9 representing two numbers. Create the maximum number of length k <= m + n from digits of the two. The relative order of the digits from the same array must be preserved. Return an array of the k digits. You should try to optimize your time and space complexity.   
```
public int[] maxNumber(int[] nums1, int[] nums2, int k) {
    int[] res = new int[k];
    for(int i=0; i<=k; i++) {
        if(i>nums1.length || k-i>nums2.length) {
            continue;
        }
        int[] a = maxArray(nums1, i);
        int[] b = maxArray(nums2, k-i);
        int[] tmp = merge(a, b);
        if(!compare(res, 0, tmp, 0)) {
            res = tmp;
        }
    }
    return res;
}

private int[] maxArray(int[] num, int n) {
    int[] res = new int[n];
    int start=0, len=num.length;
    for(int i=0; i<n; i++) {
        int max=0;
        for(int j=start; j<len && j<len-n+i+1; j++) {
            if(num[j]>max) {
                max = num[j];
                start = j+1;
            }
        }
        res[i] = max;
    }
    return res;
}

// better maxArray
public int[] getMaxArray(int[] nums, int k) {
    int[] res = new int[k];
    int len = 0;
    for (int i = 0; i < nums.length; i++) {
        while (len > 0 && len + nums.length - i > k && res[len - 1] < nums[i]) {
            len--;
        }
        if (len < k)
            res[len++] = nums[i];
    }
    return res;
}

private int[] merge(int[] a, int[] b) {
    int la=a.length, lb=b.length, l=la+lb;
    int[] res = new int[l];
    for(int i=0, j=0; i+j<l;) {
        if(i==la) {
            res[i+j] = b[j++];
        } else if(j==lb) {
            res[i+j] = a[i++];
        } else if(compare(a, i, b, j)) {
            res[i+j] = a[i++];
        } else {
            res[i+j] = b[j++];
        }
    }
    return res;
}

private boolean compare(int[] a, int as, int[] b, int bs) {
    for(;as<a.length && bs<b.length;as++,bs++) {
        if(a[as]>b[bs]) {
            return true;
        } else if(a[as]<b[bs]) {
            return false;
        }
    }
    return as!=a.length;
}
```
