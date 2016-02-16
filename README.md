# JavaPractice

## Algorithm
practice algorithm implementation. algorithms are from:
1. famous algorithm
2. introduction to algorithm
3. geeksforgeeks
4. articles

## Backtracking
special practice for backtracking algorithm

## Basic
JAVA basic concept understanding.

## cc150
Cracking Code Interview Problems

## Database
JAVA Database Manager and Connection

## Design Patterns
Design pattern for JAVA. Original ideas are from:
1. GoF Design Pattern: Elements of Reusable Object-Oriented Software
2. Head First Design Pattern
3. ISBN: 9787302162063

Details:
- Factory
- Strategy

## leetcode
Leetcode Algorithm problems

##### Hash Table
1. Two Sum<br>
Q: Given an array of integers, find two numbers such that they add up to a specific target number.<br>
A: use HashMap to map value to its index. O(n)<br>
lookup map for target-value. O(1)<br>

```
public int[] twoSum(int[] nums, int target) {
  int[] res = new int[2];
  HashMap<Integer, Integer> map = new HashMap<>();
  
  for(int i=0; i<nums.length; i++) {
      if(map.containsKey(target-nums[i])) {
          int idx = map.get(target-nums[i]);
          res[0] = (idx>i)?i+1:idx+1;
          res[1] = (idx>i)?idx+1:i+1;
      }
      map.put(nums[i], i);
  }
  
  return res;
}
```

2. Longest Substring Without Repeating Characters <br>
Q: Given a string, find the length of the longest substring without repeating characters. For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.<br>
A: use hash map to record each character latest index. mark starting point of current substring. calculate length and compare<br>

```
public int lengthOfLongestSubstring(String s) {
    HashMap<Character, Integer> map = new HashMap<>();
    int len = 0;
    int start = 0;
    
    for(int i=0; i<s.length(); i++) {
        char cur = s.charAt(i);
        if(map.containsKey(cur)) {
            start = Math.max(map.get(cur)+1, start);
        }
        map.put(cur, i);
        len = Math.max(len, i-start+1);
    }
    
    return len;
}
```

3. Valid Sudoku
Q: Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules. The Sudoku board could be partially filled, where empty cells are filled with the character '.'. A partially filled sudoku which is valid. Note: A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
```
public boolean isValidSudoku(char[][] board) {
    for(int i=0; i<9; i++) {
        for(int j=0; j<9; j++) {
            if(board[i][j]=='.') {
                continue;
            }
            
            if(!isValid(board, i, j, board[i][j])) {
                return false;
            }
        }
    }
    return true;
}

private boolean isValid(char[][] board, int row, int col, char val) {
    // row check
    for(int i=0; i<9; i++) {
        if(i!=col && board[row][i]!='.' && board[row][i]==val) {
            return false;
        }
    }
    
    // col check
    for(int i=0; i<9; i++) {
        if(i!=row && board[i][col]!='.' && board[i][col]==val) {
            return false;
        }
    }
    
    // block check
    int r1 = (row%3==2)?3:0;
    int r2 = (row%3==0)?0:3;
    int c1 = (col%3==2)?3:0;
    int c2 = (col%3==0)?0:3;
    if(board[row+1-r1][col+1-c1]==val
        || board[row+1-r1][col+2-c2]==val
        || board[row+2-r2][col+1-c1]==val
        || board[row+2-r2][col+2-c2]==val
    ) {
        return false;
    }
    
    return true;
}
```

##### Linked List
1. Add Two Numbers<br>
Q: You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.<br>
A: iterative add from left to right, use flag to mark over 10 sum. O(n)<br>

```
public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
   ListNode dummy = new ListNode(0);
   ListNode pnt = dummy;
   dummy.next = pnt;
   
   boolean overflow = false;
   while(l1!=null && l2!=null) {
       int sum = (overflow)?1+l1.val+l2.val:l1.val+l2.val;
       if(sum>=10) {
           sum -= 10;
           overflow = true;
       } else {
           overflow = false;
       }
       ListNode tmp = new ListNode(sum);
       pnt.next = tmp;
       pnt = tmp;
       l1 = l1.next;
       l2 = l2.next;
   }
   ListNode l = (l1!=null)?l1:l2;
   while(l!=null) {
       int sum = (overflow)?1+l.val:l.val;
       if(sum>=10) {
           sum -= 10;
           overflow = true;
       } else {
           overflow = false;
       }
       ListNode tmp = new ListNode(sum);
       pnt.next = tmp;
       pnt = tmp;
       l = l.next;
   }
   if(overflow) {
       ListNode tmp = new ListNode(1);
       pnt.next = tmp;
   }
   
   return dummy.next;
}
```

2. Merge Two Sorted Lists
Q: Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
```
public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode pnt = new ListNode(0);
    ListNode head = pnt;
    
    while(l1!=null && l2!=null) {
        if(l1.val>l2.val) {
            pnt.next = l2;
            l2 = l2.next;
        } else {
            pnt.next = l1;
            l1 = l1.next;
        }
        pnt = pnt.next;
    }
    while(l1!=null) {
        pnt.next = l1;
        l1 = l1.next;
        pnt = pnt.next;
    }
    while(l2!=null) {
        pnt.next = l2;
        l2 = l2.next;
        pnt = pnt.next;
    }
    
    return head.next;
}
```

3.Swap Nodes in Pairs
Q: Given a linked list, swap every two adjacent nodes and return its head.
For example, Given 1->2->3->4, you should return the list as 2->1->4->3. Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
```
public ListNode swapPairs(ListNode head) {
    if(head==null || head.next==null) {
        return head;
    }
    
    ListNode dummy = new ListNode(0);
    ListNode pnt = dummy;
    dummy.next = head;
    ListNode prev = head;
    while(prev!=null && prev.next!=null) {
        pnt.next = prev.next;
        ListNode next = prev.next.next;
        prev.next.next = prev;
        prev.next = next;
        pnt = prev;
        prev = prev.next;
    }
    
    return dummy.next;
}
```

4. Reverse Nodes in k-Group
Q: Given a linked list, reverse the nodes of a linked list k at a time and return its modified list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is. You may not alter the values in the nodes, only nodes itself may be changed. Only constant memory is allowed.
For example,
Given this linked list: 1->2->3->4->5
For k = 2, you should return: 2->1->4->3->5
For k = 3, you should return: 3->2->1->4->5
```
public ListNode reverseKGroup(ListNode head, int k) {
    if(count(head)<k) {
        return head;
    }
    
    ListNode dummy = head;
    ListNode pnt = head.next;
    ListNode prev = null;
    head.next = prev;
    prev = head;
    head = pnt;
    for(int i=1; i<k; i++) {
        pnt = head.next;
        head.next = prev;
        prev = head;
        head = pnt;
    }
    dummy.next = reverseKGroup(head, k);
    
    return prev;
}

private int count(ListNode head) {
    ListNode pnt = head;
    int cnt = 0;
    while(pnt!=null) {
        pnt = pnt.next;
        cnt++;
    }
    return cnt;
}
```

##### String

1. Longest Palindromic Substring
Q: Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
A: My thought is to use dp to store the possible substring that is palindrome. With incresing length, we can mark the later one as the longest palindrome.
```
public String longestPalindrome(String s) {
    int len = s.length();
    boolean[][] dp = new boolean[len][len];
    int start = 0;
    int end = 0;
    
    for(int i=0; i<len; i++) {
        dp[i][i] = true;
        start = i;
        end = i+1;
    }
    
    for(int i=1; i<len; i++) {
        for(int j=0; j<len && i+j<len; j++) {
            if(s.charAt(j)==s.charAt(i+j)) {
                dp[j][i+j] = true;
                if(i>1) {
                    dp[j][i+j] &= dp[j+1][i+j-1];
                }
                if(dp[j][i+j]) {
                    start = j;
                    end = i+j+1;
                }
            }
        }
    }
    
    return s.substring(start, end);
}
```

2. ZigZag Conversion
Q: The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
```
public String convert(String s, int numRows) {
    if(numRows == 1) {
        return s;
    }
    int len = s.length();
    List<StringBuilder> list = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    
    for(int i=0; i<numRows; i++) {
        list.add(new StringBuilder());
    }
    for(int i=0; i<len; i++) {
        int idx = i%(numRows+numRows-2);
        if(idx>=numRows) {
            idx = numRows+numRows-2-idx;
        }
        list.get(idx).append(s.charAt(i));
    }
    for(int i=0; i<numRows; i++) {
        sb.append(list.get(i));
    }
    
    return sb.toString();
}
```

3. Longest Common Prefix
```
public String longestCommonPrefix(String[] strs) {
    if(strs.length <= 0) {
        return "";
    }
    
    for(int i=1; i<strs.length; i++) {
        if(strs[i].length()<strs[0].length()) {
            strs[0] = strs[0].substring(0, strs[i].length());
        }
        for(int j=0; j<strs[i].length(); j++) {
            if(j<strs[0].length() && strs[0].charAt(j)!=strs[i].charAt(j)) {
                strs[0] = strs[0].substring(0, j);
                break;
            }
        }
    }
    return strs[0];
}
```

4. String to Integer (atoi)
```
public int myAtoi(String str) {
    int len = str.length();
    if(len==0) {
        return 0;
    }
    int pnt = 0;
    long sum = 0;
    int sign = 1;
    while(pnt<len && str.charAt(pnt)==' ') {
        pnt++;
    }
    if(pnt<len && (str.charAt(pnt)=='+' || str.charAt(pnt)=='-')) {
        sign = (str.charAt(pnt)=='+')?1:-1;
        pnt++;
    }
    while(pnt<len && str.charAt(pnt)>='0' && str.charAt(pnt)<='9') {
        sum = sum*10+str.charAt(pnt)-'0';
        if(sum>Integer.MAX_VALUE || sum*sign<Integer.MIN_VALUE) {
            return (sign<0)?Integer.MIN_VALUE:Integer.MAX_VALUE;
        }
        pnt++;
    }
    return (int)sum*sign;
}
```

5. Count and Say
Q: The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ... 1 is read off as "one 1" or 11. 11 is read off as "two 1s" or 21. 21 is read off as "one 2, then one 1" or 1211. Given an integer n, generate the nth sequence. Note: The sequence of integers will be represented as a string.
```
public String countAndSay(int n) {
    if(n==0) {
        return new String("");
    }
    String str = "1";
    for(int i=1; i<n; i++) {
        char c = 0;
        long cnt = 0;
        StringBuilder sb = new StringBuilder();
        for(char a:str.toCharArray()) {
            if(a==c) {
                cnt++;
            } else {
                if(cnt!=0) {
                    sb.append(Long.toString(cnt));
                    sb.append(c);
                }
                c = a;
                cnt = 1;
            }
        }
        if(cnt!=0) {
            sb.append(Long.toString(cnt));
            sb.append(c);
        }
        str = sb.toString();
    }
    return str;
}
```

##### Math
1. Reverse Integer
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

2. Palindrome Number
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

3. Integer to Roman
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

4. Roman to Integer
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

##### Divide and Conquer
1. Median of Two Sorted Arrays
Q: There are two sorted arrays nums1 and nums2 of size m and n respectively. Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
```
public double findMedianSortedArrays(int A[], int B[]) {
    int lenA = A.length;
	int lenB = B.length;
	
	if((lenA+lenB)%2 != 0) {
		return (double)findMedian(A, B, (lenA+lenB)/2, 0, lenA-1, 0, lenB-1);
	} else {
		return (findMedian(A, B, (lenA+lenB)/2, 0, lenA-1, 0, lenB-1)+findMedian(A, B, (lenA+lenB)/2-1, 0, lenA-1, 0, lenB-1))*0.5;
	}
}

public int findMedian(int A[], int B[], int k, int startA, int endA, int startB, int endB) {
	int lenA = endA-startA+1;
	int lenB = endB-startB+1;
	
	if(lenA == 0) {
		return B[startB+k];
	}
	if(lenB == 0) {
		return A[startA+k];
	}
	if(k == 0) {
		return A[startA]<B[startB]?A[startA]:B[startB];
	}
	
	int midA = lenA*k/(lenA+lenB);
	int midB = k-midA-1;
	
	midA = midA+startA;
	midB = midB+startB;
	
	if(A[midA] > B[midB]) {
		k -= (midB-startB+1);
		endA = midA;
		startB = midB+1;
	} else {
		k -= (midA-startA+1);
		endB = midB;
		startA = midA+1;
	}
	
	return findMedian(A, B, k, startA, endA, startB, endB);
}
```

2. Merge k Sorted Lists
Q: Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
heap solution ref: https://leetcode.com/discuss/9279/a-java-solution-based-on-priority-queue
```
public ListNode mergeKLists(ListNode[] lists) {
    int len = lists.length;
    return mergeTwo(merge(lists, 0, len/2), merge(lists, len/2, len));
}

private ListNode merge(ListNode[] lists, int start, int end) {
    if(end<=start) {
        return null;
    } else if(end-start==1) {
        return lists[start];
    } else if(end-start==2) {
        return mergeTwo(lists[start], lists[start+1]);
    }
    int mid = start+(end-start)/2;
    return mergeTwo(merge(lists, start, mid), merge(lists, mid, end));
}

private ListNode mergeTwo(ListNode one, ListNode two) {
    ListNode head = new ListNode(0);
    ListNode pnt = head;
    while(one!=null && two!=null) {
        if(one.val>two.val) {
            pnt.next = two;
            two = two.next;
        } else {
            pnt.next = one;
            one = one.next;
        }
        pnt = pnt.next;
    }
    while(one!=null) {
        pnt.next = one;
        one = one.next;
        pnt = pnt.next;
    }
    while(two!=null) {
        pnt.next = two;
        two = two.next;
        pnt = pnt.next;
    }
    return head.next;
}
```

##### Two Pointer
1. Container With Most Water
Q: Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
```
public int maxArea(int[] height) {
    int start=0, end=height.length-1, sum=0, h=0;
    
    while(start<end) {
        if(height[start]>height[end]) {
            h = Math.max(h, height[end]);
            end--;
        } else {
            h = Math.max(h, height[start]);
            start++;
        }
        sum = Math.max(sum, h*(end-start+1));
    }
    
    return sum;
}
```

2. 3Sum
Q: Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:
Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
The solution set must not contain duplicate triplets.

```
public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    Arrays.sort(nums);
    
    for(int i=0; i<nums.length-2; i++) {
        if(i>0 && nums[i]==nums[i-1]) {
            continue;
        }
        int start = i+1;
        int end = nums.length-1;
        while(start<end) {
            if(start>i+1 && nums[start]==nums[start-1]) {
                start++;
                continue;
            }
            int sum = nums[start]+nums[end]+nums[i];
            if(sum==0) {
                List<Integer> row = new ArrayList<>();
                row.add(nums[i]);
                row.add(nums[start++]);
                row.add(nums[end--]);
                res.add(row);
            } else if(sum>0) {
                end--;
            } else {
                start++;
            }
        }
    }
    
    return res;
}
```

3. 3Sum Closest
Q: Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
```
public int threeSumClosest(int[] nums, int target) {
    int min = Integer.MAX_VALUE;
    int res = 0;
    Arrays.sort(nums);
    for(int i=0; i<nums.length-2; i++) {
        if(i>0 && nums[i]==nums[i-1]) {
            continue;
        }
        int start = i+1;
        int end = nums.length-1;
        while(start<end) {
            int sum = nums[i]+nums[start]+nums[end];
            int diff = Math.abs(sum-target);
            if(diff<min) {
                min = diff;
                res = sum;
            }
            if(min==0) {
                return target;
            }
            if(sum>target) {
                end--;
            } else {
                start++;
            }
        }
    }
    
    return res;
}
```

4. 4Sum
Q: Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note:
Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
The solution set must not contain duplicate quadruplets.
```
public List<List<Integer>> fourSum(int[] nums, int target) {
    List<List<Integer>> res = new ArrayList<>();
    Arrays.sort(nums);
    for(int i=0; i<nums.length-3; i++) {
        if(i>0 && nums[i]==nums[i-1]) {
            continue;
        }
        for(int j=i+1; j<nums.length-2; j++) {
            if(j>i+1 && nums[j]==nums[j-1]) {
                continue;
            }
            int start = j+1;
            int end = nums.length-1;
            while(start<end) {
                if(start>j+1 && nums[start]==nums[start-1]) {
                    start++;
                    continue;
                }
                int sum = nums[i]+nums[j]+nums[start]+nums[end];
                if(sum==target) {
                    List<Integer> entry = new ArrayList<>();
                    entry.add(nums[i]);
                    entry.add(nums[j]);
                    entry.add(nums[start]);
                    entry.add(nums[end]);
                    res.add(entry);
                    start++;
                    end--;
                } else if(sum>target) {
                    end--;
                } else {
                    start++;
                }
            }
        }
    }
    return res;
}
```

5. Remove Nth Node From End of List
Q: Given a linked list, remove the nth node from the end of list and return its head.
```
public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode fast = head;
    for(int i=0; i<=n; i++) {
        if(fast==null) {
            return head.next;
        }
        fast = fast.next;
    }
    
    ListNode slow = head;
    while(fast!=null) {
        fast = fast.next;
        slow = slow.next;
    }
    slow.next = slow.next.next;
    
    return head;
}
```

6. Remove Duplicates from Sorted Array
Q: Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length. Do not allocate extra space for another array, you must do this in place with constant memory.
For example,
Given input array nums = [1,1,2],
Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.
```
public int removeDuplicates(int[] nums) {
    int len = 0;
    int pnt = 1;
    for(int i=len+1; i<nums.length; i++, len++) {
        while(nums[i]<=nums[i-1]) {
            if(pnt==nums.length) {
                return len+1;
            }
            int tmp = nums[pnt];
            nums[i] = nums[pnt];
            nums[pnt++] = tmp;
        }
    }
    return len+1;
}
```

7. Remove Element
Q: Given an array and a value, remove all instances of that value in place and return the new length. The order of elements can be changed. It doesn't matter what you leave beyond the new length.
```
public int removeElement(int[] nums, int val) {
    int cnt = 0;
    int start = 0;
    int end = nums.length-1;
    while(start<end) {
        if(nums[start]==val) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            end--;
        } else {
            cnt++;
            start++;
        }
    }
    if(start<nums.length && nums[start]!=val) {
        cnt++;
    }
    return cnt;
}
```

8. Implement strStr()
Q: Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
KMP algorithm ref: https://www.topcoder.com/community/data-science/data-science-tutorials/introduction-to-string-searching-algorithms/
```
public int strStr(String haystack, String needle) {
    char[] nee = needle.toCharArray();
    char[] hay = haystack.toCharArray();
    int pnt = 0;
    
    for(int i=0; i<=hay.length-nee.length; i++) {
        while(pnt<nee.length && hay[i+pnt]==nee[pnt]) {
            pnt++;
        }
        if(pnt==nee.length) {
            return i;
        }
        pnt = 0;
    }
    return -1;
}
```

##### Backtracking
1. Letter Combinations of a Phone Number
Q: Given a digit string, return all possible letter combinations that the number could represent. A mapping of digit to letters (just like on the telephone buttons) is given below.
```
public List<String> letterCombinations(String digits) {
    if(digits.length()==0) {
        return new ArrayList<>();
    }
    
    int[] num = new int[]{2, 3, 4, 5, 6, 7, 8, 9};
    String[] s = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    HashMap<Integer, char[]> map = new HashMap<>();
    for(int i=0; i<num.length; i++) {
        map.put(num[i], s[i].toCharArray());
    }
    
    return helper(digits, map);
}

public List<String> helper(String digits, HashMap<Integer, char[]> map) {
    if(digits.length()==1) {
        char head = digits.charAt(0);
        List<String> res = new ArrayList<>();
        for(Character c:map.get(head-'0')) {
            res.add(c+"");
        }
        return res;
    }
    char head = digits.charAt(0);
    List<String> res = new ArrayList<>();
    for(String s:helper(digits.substring(1), map)) {
        for(Character c:map.get(head-'0')) {
            res.add(c+s);
        }
    }
    return res;
}
```

2. Generate Parentheses
Q: Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses. For example, given n = 3, a solution set is: "((()))", "(()())", "(())()", "()(())", "()()()"
```
public List<String> generateParenthesis(int n) {
    List<String> list = new ArrayList<>();
    if(n==0) {
        list.add("");
        return list;
    }
    StringBuilder sb = new StringBuilder();
    helper(n, n, sb, list);
    return list;
}

private void helper(int left, int right, StringBuilder sb, List<String> list) {
    if(left==0 && right==0) {
        String str = sb.toString();
        if(!list.contains(str)) {
            list.add(str);
        }
    }
    if(left>0) {
        helper(left-1, right, sb.append('('), list);
        sb.deleteCharAt(sb.length()-1);
    }
    if(right>0 && right>left) {
        helper(left, right-1, sb.append(')'), list);
        sb.deleteCharAt(sb.length()-1);
    }
}
```

3. Sudoku Solver
Q: Write a program to solve a Sudoku puzzle by filling the empty cells. Empty cells are indicated by the character '.'. You may assume that there will be only one unique solution.
```
public void solveSudoku(char[][] board) {
    solver(board);
}

private boolean solver(char[][] board) {
    for(int i=0; i<9; i++) {
        for(int j=0; j<9; j++) {
            if(board[i][j]!='.') {
                continue;
            }
            for(char k='1'; k<='9'; k++) {
                if(isValid(board, i, j, k)) {
                    board[i][j] = k;
                    if(solver(board)) {
                        return true;
                    }
                    board[i][j] = '.';
                }
            }
            return false;
        }
    }
    return true;
}

private boolean isValid(char[][] board, int row, int col, char val) {
    // row check
    for(int i=0; i<9; i++) {
        if(i!=col && board[row][i]!='.' && board[row][i]==val) {
            return false;
        }
    }
    
    // col check
    for(int i=0; i<9; i++) {
        if(i!=row && board[i][col]!='.' && board[i][col]==val) {
            return false;
        }
    }
    
    // block check
    int r1 = (row%3==2)?3:0;
    int r2 = (row%3==0)?0:3;
    int c1 = (col%3==2)?3:0;
    int c2 = (col%3==0)?0:3;
    if(board[row+1-r1][col+1-c1]==val
        || board[row+1-r1][col+2-c2]==val
        || board[row+2-r2][col+1-c1]==val
        || board[row+2-r2][col+2-c2]==val
    ) {
        return false;
    }
    
    return true;
}
```

4. Combination Sum
Q: Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T. The same repeated number may be chosen from C unlimited number of times. Note: All numbers (including target) will be positive integers. Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak). The solution set must not contain duplicate combinations. For example, given candidate set 2,3,6,7 and target 7, A solution set is: [7] [2, 2, 3] 
```
public List<List<Integer>> combinationSum(int[] candidates, int target) {
    Arrays.sort(candidates);
    List<List<Integer>> list = new ArrayList<>();
    for(int i=0; i<candidates.length; i++) {
        ArrayList<Integer> row = new ArrayList<>();
        if(target>=candidates[i]) {
            row.add(candidates[i]);
            helper(list, row, candidates, target-candidates[i], i);
        }
    }
    return list;
}

private void helper(List<List<Integer>> list, ArrayList<Integer> row, int[] candidates, int target,int start) {
    if(target==0) {
        list.add(new ArrayList<>(row));
        return ;
    }
    for(int i=start; i<candidates.length; i++) {
        if(target>=candidates[i]) {
            row.add(candidates[i]);
            helper(list, row, candidates, target-candidates[i], i);
            row.remove(row.size()-1);
        } else {
            return ;
        }
    }
}
```

5. Combination Sum II
Q: Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T. Each number in C may only be used once in the combination. Note: All numbers (including target) will be positive integers. Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak). The solution set must not contain duplicate combinations. For example, given candidate set 10,1,2,7,6,1,5 and target 8, A solution set is: [1, 7] [1, 2, 5] [2, 6] [1, 1, 6] 
```
public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
    List<List<Integer>> list = new ArrayList<>();
    for(int i=0; i<candidates.length; i++) {
        if(i>0 && candidates[i]==candidates[i-1]) {
            continue;
        }
        ArrayList<Integer> row = new ArrayList<>();
        if(target>=candidates[i]) {
            row.add(candidates[i]);
            helper(list, row, candidates, target-candidates[i], i+1);
        }
    }
    return list;
}

private void helper(List<List<Integer>> list, ArrayList<Integer> row, int[] candidates, int target,int start) {
    if(target==0) {
        list.add(new ArrayList<>(row));
        return ;
    }
    for(int i=start; i<candidates.length; i++) {
        if(i>start && candidates[i]==candidates[i-1]) {
            continue;
        }
        if(target>=candidates[i]) {
            row.add(candidates[i]);
            helper(list, row, candidates, target-candidates[i], i+1);
            row.remove(row.size()-1);
        } else {
            return ;
        }
    }
}
```


##### Stack
1. Valid Parentheses
Q: Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid. The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
```
public boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();
    
    for(Character c:s.toCharArray()) {
        if(c=='(' || c=='[' || c=='{') {
            stack.push(c);
        } else {
            if(stack.isEmpty() || Math.abs(c-stack.pop())>2) {
                return false;
            }
        }
    }
    return stack.isEmpty();
}
```

##### Binary Search
1. Divide Two Integers
Q: Divide two integers without using multiplication, division and mod operator. If it is overflow, return MAX_INT.
```
public int divide(int dividend, int divisor) {
    if(divisor==0) {
        return Integer.MAX_VALUE;
    }
    long sum = 0;
    int cnt = 0;
    boolean sign = false;
    long end = dividend;
    long sor = divisor;
    if(sor<0&&end>0 || sor>0&&end<0) {
        sign = true;
        if(sor<0) {
            sor = -sor;
        } else {
            end = -end;
        }
    }
    if(sor<0&&end<0) {
        sor = -sor;
        end = -end;
    }
    
    while(sum<=end) {
        long base = sor;
        long prev = 0;
        int cBase = 1;
        int cPrev = 0;
        while(end-base>=sum) {
            prev = base;
            base += base;
            cPrev = cBase;
            cBase += cBase;
        }
        if(prev == 0) {
            break;
        }
        sum += prev;
        if(sign&&Integer.MAX_VALUE-cPrev+1<=cnt) {
            return Integer.MIN_VALUE;
        } else if(Integer.MAX_VALUE-cPrev<=cnt) {
            return Integer.MAX_VALUE;
        }
        cnt += cPrev;
    }
    
    return (sign)?-cnt:cnt;
}
```

2. Search for a Range
Q: Given a sorted array of integers, find the starting and ending position of a given target value. Your algorithm's runtime complexity must be in the order of O(log n). If the target is not found in the array, return [-1, -1].
For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].
```
public int[] searchRange(int[] nums, int target) {
    int[] res = new int[]{-1, -1};
    if(nums.length==0 || nums[0]>target || nums[nums.length-1]<target) {
        return res;
    }
    int left = findTarget(nums, target, true);
    int right = findTarget(nums, target, false);
    if(nums[left]==target) {
        res[0]=left;
        res[1]=right;
    }
    
    return res;
}

private int findTarget(int[] nums, int target, boolean direction) {
    int start = 0;
    int end = nums.length;
    while(start<end-1) {
        int mid = start+(end-start)/2;
        if(nums[mid]>target) {
            end = mid;
        } else if(nums[mid]<target) {
            start = mid;
        } else {
            if(direction) {
                end = mid;
            } else {
                start = mid;
            }
        }
    }
    return (nums[start]==target)?start:end;
}
```

3. Search Insert Position
Q: Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order. You may assume no duplicates in the array.
Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0
```
public int searchInsert(int[] nums, int target) {
    if(nums.length==0 || nums[0]>=target) {
        return 0;
    }
    int start = 0;
    int end = nums.length-1;
    while(start<end-1) {
        int mid = start + (end-start)/2;
        if(nums[mid]==target) {
            return mid;
        } else if(nums[mid]>target) {
            end = mid;
        } else {
            start = mid;
        }
    }
    return (nums[end]>=target)?end:end+1;
}
```

4. Search in Rotated Sorted Array
Q: Suppose a sorted array is rotated at some pivot unknown to you beforehand. (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2). You are given a target value to search. If found in the array return its index, otherwise return -1. You may assume no duplicate exists in the array.
```
public int search(int[] nums, int target) {
    int start=0, end=nums.length-1;
    if(nums[start]<nums[end]) {
        return binarySearch(nums, target, start, end);
    }
    while(start<end-1 && nums[start]>nums[end]) {
        int pivot = start + (end-start)/2;
        if(nums[pivot]>nums[end]) {
            start = pivot;
        } else {
            end = pivot;
        }
    }
    int left = binarySearch(nums, target, 0, start);
    int right = binarySearch(nums, target, end, nums.length-1);
    return (left==-1&&right==-1)?-1:Math.max(left, right);
}

private int binarySearch(int[] nums, int target, int start, int end) {
    if(nums[start]>target||nums[end]<target) {
        return -1;
    }
    if(nums[start]==target) {
        return start;
    } else if(nums[end]==target) {
        return end;
    }
    while(start<end-1) {
        int mid = start+(end-start)/2;
        if(nums[mid]==target) {
            return mid;
        } else if(nums[mid]>target) {
            end = mid;
        } else {
            start = mid;
        }
    }
    return -1;
}
```

##### Dynamic Programming

1. Longest Valid Parentheses
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


##### Array
1. First Missing Positive
Q: Given an unsorted integer array, find the first missing positive integer. For example, Given [1,2,0] return 3, and [3,4,-1,1] return 2. Your algorithm should run in O(n) time and uses constant space.
```
public int firstMissingPositive(int[] nums) {
    for(int i=0; i<nums.length; i++) {
        while(nums[i]!=i+1 && nums[i]<=nums.length && nums[i]>0 && nums[i]!=nums[nums[i]-1]) {
            int tmp = nums[i];
            nums[i] = nums[tmp-1];
            nums[tmp-1] = tmp;
        }
    }
    for(int i=0; i<nums.length; i++) {
        if(nums[i]!=i+1) {
            return i+1;
        }
    }
    return nums.length+1;
}
```

## lintcode
Lintcode Algorithm problems
