# Math

1. [Reverse Integer](#reverse-integer)
2. [Palindrome Number](#palindrome-number)
3. [Integer to Roman](#integer-to-roman)
4. [Roman to Integer](#roman-to-integer)
5. [Permutation Sequence](#permutation-sequence)
6. [Excel Sheet Column Title](#excel-sheet-column-title)
7. [Excel Sheet Column Number](#excel-sheet-column-number)
8. [Factorial Trailing Zeroes](#factorial-trailing-zeros)
9. [Rectangle Area](#rectangle-area)
10. [Basic Calculator](#basic-calculator)
11. [Add Digits](#add-digits)
12. [Ugly Number](#ugly-number)
13. [Ugly Number II](#ugly-number-ii)
14. [Nim Game](#nim-game)
15. [Super Ugly Number](#super-ugly-number)
16. [Bulb Switcher](#bulb-switcher)
17. [Power of Three](#power-of-three)
18. [Number of Digit One](#number-of-digit-one)
19. [Self Crossing](#self-crossing)
20. [Integer Break](#integer-break)

## Reverse Integer   
Q: Reverse digits of an integer.   
Example1: x = 123, return 321   
Example2: x = -123, return -321   
```
public int reverse(int x) {
    long res = 0;
    boolean flag = (x<0)?true:false;
    x = (flag)?-x:x;
    
    while(x>0) {
        res = res*10+(x%10);
        x /= 10;
    }
    
    if(res > Integer.MAX_VALUE) {
        return 0;
    }
    if(-res < Integer.MIN_VALUE) {
        return 0;
    }
    
    return (flag)?(int)-res:(int)res;
}
```

## Palindrome Number   
Q: Determine whether an integer is a palindrome. Do this without extra space.   
A: reverse the number and compare.   
Better Idea:  
ref: https://leetcode.com/discuss/23563/line-accepted-java-code-without-the-need-handling-overflow   
reverse half of the number and compare.   
```
public boolean isPalindrome(int x) {
    long res = reverse(x);
    if(res>Integer.MAX_VALUE || res<Integer.MIN_VALUE) {
        return false;
    }
    return ((int)res==x);
}

public long reverse(int x) {
    long res = 0;
    while(x>0) {
        res = res*10+(x%10);
        x /= 10;
    }
    return res;
}
```

## Integer to Roman   
Q: Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to 3999.   
```
public String intToRoman(int num) {
    HashMap<Integer, Character> map = new HashMap<>();
    char[] vals = new char[]{'I', 'V', 'X', 'L', 'C', 'D', 'M'};
    int[] keys = new int[] {1, 5, 10, 50, 100, 500, 1000};
    for(int i=0; i<keys.length; i++) {
        map.put(keys[i], vals[i]);
    }
    
    StringBuilder sb = new StringBuilder();
    int[] base = new int[]{1000, 100, 10, 1};
    
    for(int i=0; i<4; i++) {
        int b = base[i];
        int m = num/b;
        while(m>0) {
            if(m==9) {
                num -= 9*b;
                sb.append(map.get(b));
                sb.append(map.get(b*10));
                m-=9;
            } else if(m==4) {
                num -= 4*b;
                sb.append(map.get(b));
                sb.append(map.get(b*5));
                m-=4;
            } else if(m>=5) {
                num -= 5*b;
                sb.append(map.get(b*5));
                m-=5;
            } else {
                num -= 1*b;
                sb.append(map.get(b));
                m--;
            }
        }   
    }
    
    return sb.toString();
}
```

## Roman to Integer   
Q: Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.   
```
public int romanToInt(String s) {
    int res = 0;
    for(int i=0; i<s.length(); i++) {
        switch(s.charAt(i)) {
            case 'M':
                res += 1000;
                break;
            case 'D':
                res += 500;
                break;
            case 'C':
                if(i+1<s.length() && (s.charAt(i+1)=='M' || s.charAt(i+1)=='D')) {
                    res -= 100;
                } else {
                    res += 100;
                }
                break;
            case 'L':
                res += 50;
                break;
            case 'X':
                if(i+1<s.length() && (s.charAt(i+1)=='L' || s.charAt(i+1)=='C')) {
                    res -= 10;
                } else {
                    res += 10;
                }
                break;
            case 'V':
                res += 5;
                break;
            case 'I':
                if(i+1<s.length() && (s.charAt(i+1)=='V' || s.charAt(i+1)=='X')) {
                    res -= 1;
                } else {
                    res += 1;
                }
                break;
        }
    }
    return res;
}
```

## Permutation Sequence   
Q: The set [1,2,3,…,n] contains a total of n! unique permutations. Given n and k, return the kth permutation sequence. Note: Given n will be between 1 and 9 inclusive.   
```
public String getPermutation(int n, int k) {
    int[] res = new int[n];
    ArrayList<Integer> list = new ArrayList<>();
    for(int i=0; i<n; i++) {
        res[i] = i+1;
        res[i] *= (i>0)?res[i-1]:1;
        list.add(i+1);
    }
    
    k--;
    k %= res[n-1];
    StringBuilder sb = new StringBuilder();
    for(int i=n-2; i>=0; i--) {
        int idx = k/res[i];
        sb.append(list.get(idx));
        list.remove(idx);
        k %= res[i];
    }
    sb.append(list.get(0));
    
    return sb.toString();
}
```

## Excel Sheet Column Title
Q: Given a positive integer, return its corresponding column title as appear in an Excel sheet.   
```
public String convertToTitle(int n) {
    StringBuilder sb = new StringBuilder();
    while(n>0) {
        sb.insert(0, (char)('A'+(n-1)%26));
        n = (n-1)/26;
    }
    return sb.toString();
}
```

## Excel Sheet Column Number
Q: Given a column title as appear in an Excel sheet, return its corresponding column number.   
```
public int titleToNumber(String s) {
    int base=1, res=0;
    for(int i=s.length()-1; i>=0; i--) {
        res += (s.charAt(i)-'A'+1)*base;
        base *= 26;
    }
    return res;
}
```

## Factorial Trailing Zeroes
Q: Given an integer n, return the number of trailing zeroes in n!. Note: Your solution should be in logarithmic time complexity.   
```
public int trailingZeroes(int n) {
    long base=5, res=0;
    while(n/base!=0) {
        res += (n/base);
        base *= 5;
    }
    return (int)res;
}
```

## Rectangle Area
Q: Find the total area covered by two rectilinear rectangles in a 2D plane. Each rectangle is defined by its bottom left corner and top right corner as shown in the figure. Rectangle Area Assume that the total area is never beyond the maximum possible value of int.     
```
public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
    if(E>C || G<A || F>D || H<B) {
        return (D-B)*(C-A)+(H-F)*(G-E);
    }
    int lx = Math.max(A, E);
    int ly = Math.max(B, F);
    int rx = Math.min(C, G);
    int ry = Math.min(D, H);
    return (D-B)*(C-A)+(H-F)*(G-E)-(rx-lx)*(ry-ly);
}
```

##  Basic Calculator
Q: Implement a basic calculator to evaluate a simple expression string. The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces . You may assume that the given expression is always valid.   
```
public int calculate(String s) {
    LinkedList<String> num = new LinkedList<>();
    LinkedList<Character> op = new LinkedList<>();
    for(int i=0; i<s.length(); i++) {
        char a = s.charAt(i);
        switch(a) {
            case '(':
                op.add(a);
                break;
            case '+':
                opLast(num, op);
                op.add(a);
                break;
            case '-':
                opLast(num, op);
                op.add(a);
                break;
            case ')':
                opLast(num, op);
                op.pollLast();
                opLast(num, op);
                break;
            case ' ':
                break;
            default:
                if(i>0 && s.charAt(i-1)>='0' && s.charAt(i-1)<='9') {
                    num.add(num.pollLast()+a);
                } else {
                    num.add(""+a);
                }
        }
    }
    opLast(num, op);
    return Integer.parseInt(num.pollLast());
}

private void opLast(LinkedList<String> num, LinkedList<Character> op) {
    while(!op.isEmpty() && op.peekLast()!='(') {
        num.add(helper(num.pollLast(), op.pollLast(), num.pollLast()));
    }
}

private String helper(String c, char b, String a) {
    Long d = (b=='+')?(Long.parseLong(a)+Long.parseLong(c)):(Long.parseLong(a)-Long.parseLong(c));
    return String.valueOf(d);
}
```

## Add Digits
Q: Given a non-negative integer num, repeatedly add all its digits until the result has only one digit. Follow up: Could you do it without any loop/recursion in O(1) runtime?    
```
public int addDigits(int num) {
    int res = 0;
    while(num>0) {
        res += num%10;
        num /= 10;
    }
    return (res<10)?res:addDigits(res);
}
public int addDigits(int num) {
    return (num%9==0&&num>0)?9:num%9;
}
```

## Ugly Number
Q: Write a program to check whether a given number is an ugly number. Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7. Note that 1 is typically treated as an ugly number.   
```
public boolean isUgly(int num) {
    if(num<=0) {
        return false;
    }
    num = helper(num, 5);
    num = helper(num, 3);
    num = helper(num, 2);
    return num==1;
}
private int helper(int num, int prime) {
    while(num%prime==0) {
        num /= prime;
    }
    return num;
}
```

## Ugly Number II
Q: Write a program to find the n-th ugly number. Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers. Note that 1 is typically treated as an ugly number.   
```
public int nthUglyNumber(int n) {
    int[] res = new int[n];
    int[] dp = new int[3];
    res[0] = 1;
    for(int i=1; i<n; i++) {
        int a=res[dp[0]]*2, b=res[dp[1]]*3, c=res[dp[2]]*5;
        int min = Math.min(a, Math.min(b, c));
        res[i] = min;
        if(a==min) {
            dp[0]++;
        }
        if(b==min) {
            dp[1]++;
        }
        if(c==min) {
            dp[2]++;
        }
    }
    return res[n-1];
}
```

## Nim Game
Q: You are playing the following Nim Game with your friend: There is a heap of stones on the table, each time one of you take turns to remove 1 to 3 stones. The one who removes the last stone will be the winner. You will take the first turn to remove the stones. Both of you are very clever and have optimal strategies for the game. Write a function to determine whether you can win the game given the number of stones in the heap. For example, if there are 4 stones in the heap, then you will never win the game: no matter 1, 2, or 3 stones you remove, the last stone will always be removed by your friend.   
```
public boolean canWinNim(int n) {
    return !(n%4==0);
}
```

## Super Ugly Number
Q: Write a program to find the nth super ugly number. Super ugly numbers are positive numbers whose all prime factors are in the given prime list primes of size k. For example, [1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 32] is the sequence of the first 12 super ugly numbers given primes = [2, 7, 13, 19] of size 4. Note: (1) 1 is a super ugly number for any given primes. (2) The given numbers in primes are in ascending order. (3) 0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000.   
more solution ref: https://leetcode.com/discuss/81411/java-three-methods-23ms-58ms-with-heap-performance-explained   
```
public int nthSuperUglyNumber(int n, int[] primes) {
    int[] dp = new int[n];
    int[] iSet = new int[primes.length];
    dp[0] = 1;
    for(int i=1; i<n; i++) {
        HashSet<Integer> set = new HashSet<>();
        int min = Integer.MAX_VALUE;
        for(int j=0; j<primes.length; j++) {
            int tmp = dp[iSet[j]]*primes[j];
            if(min>tmp) {
                min = tmp;
                set.clear();
                set.add(j);
            } else if(min==tmp) {
                set.add(j);
            }
        }
        for(int tmp:set) {
            iSet[tmp]++;
        }
        dp[i] = min;
    }
    return dp[n-1];
}
```

## Bulb Switcher
Q: There are n bulbs that are initially off. You first turn on all the bulbs. Then, you turn off every second bulb. On the third round, you toggle every third bulb (turning on if it's off or turning off if it's on). For the ith round, you toggle every i bulb. For the nth round, you only toggle the last bulb. Find how many bulbs are on after n rounds.   
```
public int bulbSwitch(int n) {
    int mnt=0, i=1;
    while(i<=n) {
        if(i*i<=n) {
            mnt++;
            i++;
        } else {
            return mnt;
        }
    }
    return mnt;
}
```

## Power of Three
Q: Given an integer, write a function to determine if it is a power of three.Follow up: Could you do it without using any loop / recursion?   
good ref: https://leetcode.com/discuss/78532/summary-all-solutions-new-method-included-at-15-30pm-jan-8th   
```
public boolean isPowerOfThree(int n) {
    while(n%3==0 && n>1) {
        n/=3;
    }
    return n==1;
}
```

## Number of Digit One
Q: Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.   
```
public int countDigitOne(int n) {
    int base=1, left=0, cnt=0;
    while(n>0) {
        int mod=n%10, div=n/10;
        cnt += base*div;
        if(mod>1) {
            cnt += base;
        } else if(mod==1) {
            cnt += left+1;
        }
        n = div;
        left = mod*base+left;
        base *= 10;
    }
    return cnt;
}
```

## Self Crossing
Q: You are given an array x of n positive numbers. You start at point (0,0) and moves x[0] metres to the north, then x[1] metres to the west, x[2] metres to the south, x[3] metres to the east and so on. In other words, after each move your direction changes counter-clockwise. Write a one-pass algorithm with O(1) extra space to determine, if your path crosses itself, or not.   
```
public boolean isSelfCrossing(int[] x) {
    int n=x.length;
    for(int i=3; i<n; i++) {
        if(x[i]>=x[i-2] && x[i-1]<=x[i-3]) {
            return true;
        }
        if(i>3 && (x[i]+x[i-4])>=x[i-2] && x[i-2]>=x[i-4] && x[i-1]==x[i-3]) {
            return true;
        }
        if(i>4 && (x[i]+x[i-4])>=x[i-2] && x[i-2]>=x[i-4] && x[i-1]<=x[i-3] && (x[i-1]+x[i-5])>=x[i-3]) {
            return true;
        }
    }
    return false;
}
```

## Integer Break
Q: Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers. Return the maximum product you can get.   
```
public int integerBreak(int n) {
    if(n<4) {
        return n-1;
    }
    int res=1;
    while(n>4) {
        res*=3;
        n-=3;
    }
    return res*n;
}
```






