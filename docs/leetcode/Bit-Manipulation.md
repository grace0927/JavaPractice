#Bit Manipulation

1. [Single Number](#single-number)
2. [Single Number II](#single-number-ii)
3. [Reverse Bits](#reverse-bits)
4. [Number of 1 Bits](#number-of-1-bits)
5. [Bitwise AND of Numbers Range](#bitwise-and-of-numbers-range)
6. [Power of Two](#power-of-two)
7. [Single Number III](#single-number-iii)
8. [Maximum Product of Word Lengths](#maximum-product-of-word-lengths)
9. [Power of Four](#power-of-four)

##Single Number
Q: Given an array of integers, every element appears twice except for one. Find that single one. Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?   
```
public int singleNumber(int[] nums) {
    int res = 0;
    for(int i=0; i<nums.length; i++) {
        res ^= nums[i];
    }
    return res;
}
```

##Single Number II
Q: Given an array of integers, every element appears three times except for one. Find that single one.   
```
public int singleNumber(int[] nums) {
    int res = 0;
    for(int i=31; i>=0; i--) {
        int mask = 1<<i;
        int tmp = 0;
        for(int a:nums) {
            if((a&mask)!=0) {
                tmp++;
            }
        }
        tmp = (tmp%3==0)?0:1;
        res = (res<<1)+tmp;
    }
    return res;
}
```

##Reverse Bits
Q: Reverse bits of a given 32 bits unsigned integer. If this function is called many times, how would you optimize it?(use hash map)   
```
// you need treat n as an unsigned value
public int reverseBits(int n) {
    int res=0;
    for(int i=0; i<32; i++) {
        res += (1&n);
        n >>>= 1;
        if(i<31) {
            res <<= 1;
        }
    }
    return res;
}
```

## Number of 1 Bits
Q: Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).   
```
// you need to treat n as an unsigned value
public int hammingWeight(int n) {
    int cnt=0;
    for(int i=0; i<32; i++) {
        cnt += ((n&1)==1)?1:0;
        n >>>= 1;
    }
    return cnt;
}
```

## Bitwise AND of Numbers Range
Q: Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.   
```
public int rangeBitwiseAnd(int m, int n) {
    if(m<n/2) {
        return 0;
    }
    int res=m;
    while(m<n) {
        res &= (++m);
    }
    return res;
}
// better 
public int rangeBitwiseAnd(int m, int n) {
    int mask = Integer.MAX_VALUE;
    while((m&mask)!=(n&mask)) {
        mask <<= 1;
    }
    return m&mask;
}
```

##Power of Two
Q: Given an integer, write a function to determine if it is a power of two.   
```
public boolean isPowerOfTwo(int n) {
    return (n<=0)?false:(n&(n-1))==0;
}
```

##Single Number III
Q: Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once. The order of the result is not important. So in the above example, [5, 3] is also correct. Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?   
```
public int[] singleNumber(int[] nums) {
    int sum=0;
    int[] res = new int[2];
    for(int i=0; i<nums.length; i++) {
        sum ^= nums[i];
    }
    
    for(int i=0; i<32; i++) {
        int mask = 1<<i;
        if((sum&mask)!=0) {
            for(int num:nums) {
                if((num&mask)==0) {
                    res[0] ^= num;
                } else {
                    res[1] ^= num;
                }
            }
            return res;
        }
    }
    return res;
}
// ref: https://leetcode.com/discuss/52351/accepted-java-space-easy-solution-with-detail-explanations
public int[] singleNumber(int[] nums) {
    int sum=0;
    int[] res = new int[2];
    for(int i=0; i<nums.length; i++) {
        sum ^= nums[i];
    }
    // get the last set bit
    sum &= -sum;
    
    for(int num:nums) {
        if((num&sum)==0) {
            res[0] ^= num;
        } else {
            res[1] ^= num;
        }
    }
    return res;
}
```

##Maximum Product of Word Lengths
Q: Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters. You may assume that each word will contain only lower case letters. If no such two words exist, return 0.   
```
public int maxProduct(String[] words) {
    int len = 0;
    int[] set = new int[words.length];
    for(int i=0; i<words.length; i++) {
        for(int j=0; j<words[i].length(); j++) {
            set[i] |= 1<<(words[i].charAt(j)-'a');
        }
    }
    
    for(int i=0; i<words.length; i++) {
        int len1=words[i].length(), len2=0;
        for(int j=i+1; j<words.length; j++) {
            if((set[i]&set[j]) == 0) {
                len2 = Math.max(len2, words[j].length());
            }
        }
        len = Math.max(len, len1*len2);
    }
    return len;
}
```

##Power of Four
Q: Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
```
public boolean isPowerOfFour(int num) {
    int cnt=0, n=num;
    while(num>0) {
        cnt++;
        num >>= 1;
    }
    return n>0 && ((cnt%2)==1) && ((n&(n-1))==0);
}
```

