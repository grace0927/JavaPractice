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

4. Group Anagrams
Q:Given an array of strings, group anagrams together. For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], Return:
[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
] 
Note: For the return value, each inner list's elements must follow the lexicographic order. All inputs will be in lower-case. 
```
public List<List<String>> groupAnagrams(String[] strs) {
    HashMap<String, List<String>> map = new HashMap<>();
    Arrays.sort(strs);
    for(String s:strs) {
        int[] set = new int[26];
        for(int i=0; i<s.length(); i++) {
            set[s.charAt(i)-'a']++;
        }
        String res = Arrays.toString(set);
        if(!map.containsKey(res)) {
            map.put(res, new ArrayList<String>());
        }
        map.get(res).add(s);
    }
    List<List<String>> lists = new ArrayList<>();
    for(String s:map.keySet()) {
        lists.add(map.get(s));
    }
    return lists;
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

5. Remove Duplicates from Sorted List II
Q: Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. For example, Given 1->2->3->3->4->4->5, return 1->2->5. Given 1->1->1->2->3, return 2->3.
```
public ListNode deleteDuplicates(ListNode head) {
    ListNode dummy = new ListNode(0), prev = dummy, pnt=head;
    dummy.next = head;
    while(pnt!=null && pnt.next!=null) {
        if(pnt.val==pnt.next.val) {
            int val = pnt.val;
            while(pnt!=null && pnt.val==val) {
                pnt = pnt.next;
            }
            prev.next = pnt;
        } else {
            prev = pnt;
            pnt = pnt.next;
        }
    }
    return dummy.next;
}
```

6. Remove Duplicates from Sorted List
Q: Given a sorted linked list, delete all duplicates such that each element appear only once. For example, Given 1->1->2, return 1->2. Given 1->1->2->3->3, return 1->2->3.
```
public ListNode deleteDuplicates(ListNode head) {
    ListNode pnt = head;
    while(pnt!=null && pnt.next!=null) {
        if(pnt.val==pnt.next.val) {
            pnt.next = pnt.next.next;
        } else {
            pnt = pnt.next;
        }
    }
    return head;
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

6. Multiply Strings
Q: Given two numbers represented as strings, return multiplication of the numbers as a string. Note: The numbers can be arbitrarily large and are non-negative.
```
public String multiply(String num1, String num2) {
    if(num1.equals("0") || num2.equals("0")) {
        return "0";
    }
    String res = new String("");
    
    for(int i=0; i<num2.length(); i++) {
        StringBuilder sb = new StringBuilder();
        for(int j=i+1; j<num2.length(); j++) {
            sb.append('0');
        }
        res = add(res, multiply(num1, num2.charAt(i))+sb.toString());
    }
    
    return res;
}

private String multiply(String num, char a) {
    StringBuilder sb = new StringBuilder();
    int cur2 = a-'0';
    int pnt = num.length()-1;
    int cur = 0;
    
    while(pnt>=0) {
        int cur1 = num.charAt(pnt)-'0';
        cur += cur1*cur2;
        sb.insert(0, cur%10);
        cur /= 10;
        pnt--;
    }
    if(cur>0) {
        sb.insert(0, cur);
    }
    
    return sb.toString();
}

private String add(String a, String b) {
    int pntA = a.length()-1;
    int pntB = b.length()-1;
    StringBuilder sb = new StringBuilder();
    int cur = 0;
    boolean flag = false;
    while(pntA>=0 && pntB>=0) {
        int curA = a.charAt(pntA)-'0';
        int curB = b.charAt(pntB)-'0';
        cur = curA+curB;
        if(flag) {
            cur += 1;
            flag = false;
        }
        if(cur>=10) {
            cur -= 10;
            flag = true;
        }
        sb.insert(0, cur);
        pntA--;
        pntB--;
    }
    while(pntA>=0) {
        int curA = a.charAt(pntA)-'0';
        if(flag) {
            curA += 1;
            flag = false;
        }
        if(curA>=10) {
            curA -= 10;
            flag = true;
        }
        sb.insert(0, curA);
        pntA--;
    }
    while(pntB>=0) {
        int curB = b.charAt(pntB)-'0';
        if(flag) {
            curB += 1;
            flag = false;
        }
        if(curB>=10) {
            curB -= 10;
            flag = true;
        }
        sb.insert(0, curB);
        pntB--;
    }
    if(flag) {
        sb.insert(0, '1');
    }
    
    return sb.toString();
}
```

7. Length of Last Word
Q:Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string. If the last word does not exist, return 0. Note: A word is defined as a character sequence consists of non-space characters only.
```
public int lengthOfLastWord(String s) {
    char[] c = s.toCharArray();
    int len = 0;
    boolean start = false;
    for(int i=c.length-1; i>=0; i--) {
        if(c[i]==' ') {
            if(start) {
                return len;
            }
            continue;
        } else {
            start = true;
            len++;
        }
    }
    return len;
}
```

8. Add Binary
Q: Given two binary strings, return their sum (also a binary string).
```
public String addBinary(String a, String b) {
    int pntA=a.length()-1, pntB=b.length()-1, offset=0;
    StringBuilder sb = new StringBuilder();
    while(pntA>=0 || pntB>=0) {
        int cur = offset;
        if(pntA>=0) {
            cur += a.charAt(pntA)-'0';
            pntA--;
        }
        if(pntB>=0) {
            cur += b.charAt(pntB)-'0';
            pntB--;
        }
        offset = cur/2;
        cur %= 2;
        sb.insert(0, (char)(cur+'0'));
    }
    if(offset>0) {
        sb.insert(0, '1');
    }
    return sb.toString();
}
```

9. Text Justification
Q: Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified. You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters. Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right. For the last line of text, it should be left justified and no extra space is inserted between words.
```
public List<String> fullJustify(String[] words, int maxWidth) {
    int cnt=0, len=0;
    List<String> list = new ArrayList<>();
    
    for(int i=0; i<words.length; i++) {
        int next = len+words[i].length();
        if(next==maxWidth) {
            StringBuilder sb = new StringBuilder();
            for(int j=i-cnt; j<i; j++) {
                sb.append(words[j]);
                sb.append(' ');
            }
            sb.append(words[i]);
            list.add(sb.toString());
            cnt = 0;
            len = 0;
        } else if(next>maxWidth) {
            int mnt = maxWidth-len+1;
            StringBuilder sb = new StringBuilder();
            for(int j=i-cnt; j<i-1; j++) {
                sb.append(words[j]);
                sb.append(' ');
                for(int k=0,limit=(mnt%(i-j-1)==0)?mnt/(i-j-1):mnt/(i-j-1)+1; k<limit; k++) {
                    sb.append(' ');
                }
                mnt -= (mnt%(i-j-1)==0)?mnt/(i-j-1):mnt/(i-j-1)+1;
            }
            sb.append(words[i-1]);
            while(sb.length()<maxWidth) {
                sb.append(' ');
            }
            list.add(sb.toString());
            len = words[i].length()+1;
            cnt = 1;
        } else {
            len += words[i].length()+1;
            cnt++;
        }
    }
    if(len>0) {
        int i = words.length;
        StringBuilder sb = new StringBuilder();
        for(int j=i-cnt; j<i-1; j++) {
            sb.append(words[j]);
            sb.append(' ');
        }
        sb.append(words[i-1]);
        while(sb.length()<maxWidth) {
            sb.append(' ');
        }
        list.add(sb.toString());
    }
    
    return list;
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

5. Permutation Sequence
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

9. Trapping Rain Water
Q: Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining. For example, Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
ref: https://leetcode.com/discuss/10046/share-my-short-solution
```
public int trap(int[] height) {
    int left=0, right=0, pntL=0, pntR=height.length-1, sum=0;
    while(pntL<=pntR) {
        left = Math.max(left, height[pntL]);
        right = Math.max(right, height[pntR]);
        if(left<right) {
            sum += (left-height[pntL]);
            pntL++;
        } else {
            sum += (right-height[pntR]);
            pntR--;
        }
    }
    return sum;
}
```

10. Rotate List
Q: Given a list, rotate the list to the right by k places, where k is non-negative.
```
public ListNode rotateRight(ListNode head, int k) {
    if(head==null || head.next==null || k==0) {
        return head;
    }
    ListNode fast = head;
    int len = 0;
    while(k>0) {
        if(fast==null) {
            fast = head;
            k %= len;
            continue;
        }
        fast = fast.next;
        k--;
        len++;
    }
    if(fast!=null) {
        ListNode slow = head;
        while(fast!=null && fast.next!=null) {
            fast = fast.next;
            slow = slow.next;
        }
        fast.next = head;
        head = slow.next;
        slow.next = null;
    }
    
    return head;
}
```

11. Sort Colors
Q: Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue. Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively. Note: You are not suppose to use the library's sort function for this problem. Follow up: A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's. Could you come up with an one-pass algorithm using only constant space?
```
public void sortColors(int[] nums) {
    int start = 0, len=nums.length;
    while(start<len && nums[start]==0) {
        start++;
    }
    int end=len-1, pnt=start;
    while(pnt<=end) {
        switch(nums[pnt]) {
            case 0:
                nums[pnt] = nums[start];
                nums[start] = 0;
                start++;
                pnt = Math.max(pnt, start);
                break;
            case 1:
                pnt++;
                break;
            case 2:
                nums[pnt] = nums[end];
                nums[end] = 2;
                end--;
                break;
        }
    }
}
```

12. Remove Duplicates from Sorted Array II
Q: Follow up for "Remove Duplicates": What if duplicates are allowed at most twice? For example, Given sorted array nums = [1,1,1,2,2,3], Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.
```
public int removeDuplicates(int[] nums) {
    if(nums.length<=2) {
        return nums.length;
    }
    
    int cur=nums[0], pnt=1, mnt=1;
    while(mnt<=2 && pnt<nums.length) {
        if(nums[pnt]==cur) {
            mnt++;
            if(mnt>2) {
                break;
            }
        } else {
            cur = nums[pnt];
            mnt = 1;
        }
        pnt++;
    }
    for(int i=pnt+1; i<nums.length; i++) {
        if(nums[i]!=cur) {
            cur = nums[i];
            mnt = 1;
            nums[pnt] = cur;
            pnt++;
        } else {
            if(mnt==1) {
                nums[pnt] = cur;
                pnt++;
            }
            mnt++;
        }
    }
    
    return pnt;
}
// ref: https://leetcode.com/discuss/42348/3-6-easy-lines-c-java-python-ruby
public int removeDuplicates(int[] nums) {
    int i = 0;
    for (int n : nums)
        if (i < 2 || n > nums[i-2])
            nums[i++] = n;
    return i;
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

6. Permutations
Q: Given a collection of distinct numbers, return all possible permutations. For example,[1,2,3] have the following permutations: [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
```
public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> lists = new ArrayList<>();
    LinkedList<Integer> list = new LinkedList<>();
    helper(lists, list, nums);
    return lists;
}

private void helper(List<List<Integer>> lists, LinkedList<Integer> list, int[] nums) {
    if(list.size()==nums.length) {
        lists.add(new LinkedList<Integer>(list));
        return ;
    }
    for(int i=0; i<nums.length; i++) {
        if(!list.contains(nums[i])) {
            list.add(nums[i]);
            helper(lists, list, nums);
            list.removeLast();
        }
    }
}
```

7. Permutations II
Q: 
```
public List<List<Integer>> permuteUnique(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> lists = new ArrayList<>();
    lists.add(new ArrayList<Integer>());
    helper(lists, nums, 0);
    return lists;
}

private void helper(List<List<Integer>> lists, int[] nums, int start) {
    if(start == nums.length) {
        return ;
    }
    List<List<Integer>> updates = new ArrayList<>();
    for(List<Integer> list:lists) {
        for(int i=0; i<=list.size(); i++) {
            ArrayList<Integer> update = new ArrayList<>(list);
            update.add(i, nums[start]);
            if(!updates.contains(update)) {
                updates.add(update);
            }
        }
    }
    lists.clear();
    lists.addAll(updates);
    helper(lists, nums, start+1);
}
```

8. N-Queens, N-Queens II
Q: The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other. Given an integer n, return all distinct solutions to the n-queens puzzle. Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
```
public List<List<String>> solveNQueens(int n) {
    List<List<String>> lists = new ArrayList<>();
    LinkedList<String> list = new LinkedList<>();
    boolean[][] visit = new boolean[n][n];
    char[][] board = new char[n][n];
    
    for(int i=0; i<n; i++) {
        for(int j=0; j<n; j++) {
            board[i][j] = '.';
        }
    }
    
    helper(lists, list, visit, board, 0, n);
    
    return lists;
}

private void helper(List<List<String>> lists, LinkedList<String> list, boolean[][] visit, char[][] board, int row, int n) {
    if(row==n) {
        lists.add(new LinkedList<String>(list));
        return ;
    }
    for(int i=0; i<n; i++) {
        if(isValid(visit, row, i)) {
            visit[row][i] = true;
            board[row][i] = 'Q';
            list.add(new String(board[row]));
            helper(lists, list, visit, board, row+1, n);
            list.removeLast();
            board[row][i] = '.';
            visit[row][i] = false;
        }
    }
}

private boolean isValid(boolean[][] visit, int row, int col) {
    int n = visit.length;
    for(int i=0; i<n; i++) {
        if(visit[row][i] || visit[i][col]) {
            return false;
        }
        // no need to check row >= current row because they stay with no changes
        if(row-i>=0 && col-i>=0 && visit[row-i][col-i]) {
            return false;
        }
        if(row-i>=0 && col+i<n && visit[row-i][col+i]) {
            return false;
        }
    }
    return true;
}
```

9. Combinations
Q: Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
```
public List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> lists = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    
    helper(n, k, 0, lists, list);
    
    return lists;
}

private void helper(int n, int k, int start, List<List<Integer>> lists, List<Integer> list) {
    if(k==0) {
        lists.add(new ArrayList<Integer>(list));
        return ;
    }
    for(int i=start; i<n; i++) {
        list.add(i+1);
        helper(n, k-1, i+1, lists, list);
        list.remove(list.size()-1);
    }
}
```

10. Subsets
Q: Given a set of distinct integers, nums, return all possible subsets. Note: Elements in a subset must be in non-descending order. The solution set must not contain duplicate subsets.
```
public List<List<Integer>> subsets(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> lists = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    lists.add(new ArrayList<>(list));
    
    helper(nums, 0, lists, list);
    
    return lists;
}

private void helper(int[] nums, int start, List<List<Integer>> lists, List<Integer> list) {
    if(start==nums.length) {
        return ;
    }
    for(int i=start; i<nums.length; i++) {
        list.add(nums[i]);
        lists.add(new ArrayList<>(list));
        helper(nums, i+1, lists, list);
        list.remove(list.size()-1);
    }

// bit manipulation ref: https://leetcode.com/discuss/9213/my-solution-using-bit-manipulation
public List<List<Integer>> subsets(int[] S) {
    Arrays.sort(S);
    int totalNumber = 1 << S.length;
    List<List<Integer>> collection = new ArrayList<List<Integer>>(totalNumber);
    for (int i=0; i<totalNumber; i++) {
        List<Integer> set = new LinkedList<Integer>();
        for (int j=0; j<S.length; j++) {
            if ((i & (1<<j)) != 0) {
                set.add(S[j]);
            }
        }
        collection.add(set);
    }
    return collection;
}
}
```

11. Word Search
Q: Given a 2D board and a word, find if the word exists in the grid. The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
```
public boolean exist(char[][] board, String word) {
    for(int i=0; i<board.length; i++) {
        for(int j=0; j<board[0].length; j++) {
            if(helper(board, word, i, j, 0)) {
                return true;
            }
        }
    }
    
    return false;
}

private boolean helper(char[][] board, String word, int row, int col, int idx) {
    if(word.length()==idx) {
        return true;
    }
    if(row<board.length && row>=0 && 
        col<board[0].length && col>=0 && 
        board[row][col]==word.charAt(idx)) {
        char a = board[row][col];
        board[row][col] = '.';
        if(helper(board, word, row-1, col, idx+1) ||
            helper(board, word, row+1, col, idx+1) ||
            helper(board, word, row, col-1, idx+1) ||
            helper(board, word, row, col+1, idx+1)) {
            return true;
        }
        board[row][col] = a;
    }
    
    return false;
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

2. Simplify Path
Q: Given an absolute path for a file (Unix-style), simplify it.
```
public String simplifyPath(String path) {
    Stack<String> stack = new Stack<>();
    for(String str:path.split("/")) {
        if(str.equals(".") || str.equals("")) {
            continue;
        } else if(str.equals("..")) {
            if(!stack.empty()) {
                stack.pop();
            }
        } else {
            stack.push(str);
        }
    }
    
    StringBuilder sb = new StringBuilder();
    if(stack.empty() && path.length()>0) {
        sb.append('/');
    }
    while(!stack.empty()) {
        sb.insert(0,stack.pop());
        sb.insert(0,'/');
    }
    
    return sb.toString();
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

5. Pow(x, n)
Q: Implement pow(x, n).
```
public double myPow(double x, int n) {
    if(n<0) {
        n = -n;
        x = 1/x;
    }
    double[] base = new double[32];
    base[0] = x;
    double sum = 1;
    int mask = 1;
    if((mask&n) != 0) {
        sum *= base[0];
    }
    for(int i=1; i<32; i++) {
        mask *= 2;
        base[i] = base[i-1]*base[i-1];
        if((mask&n) != 0) {
            sum *= base[i];
        }
    }
    return sum;
}
```

6. Sqrt(x)
Q: Implement int sqrt(int x). Compute and return the square root of x.
```
public int mySqrt(int x) {
    if(x==0) return 0;
    int start = 1, end = x;
    
    while(start<end-1) {
        int mid = start+(end-start)/2;
        if(mid>x/mid) {
            end = mid;
        } else {
            start = mid;
        }
    }
    
    return start;
}
```

7. Search a 2D Matrix
Q: Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties: Integers in each row are sorted from left to right. The first integer of each row is greater than the last integer of the previous row.
```
public boolean searchMatrix(int[][] matrix, int target) {
    int row = matrix.length;
    if(row==0) {
        return false;
    }
    int col = matrix[0].length;
    
    // search in row
    int[] arr = new int[row];
    for(int i=0; i<row; i++) {
        arr[i] = matrix[i][0];
    }
    int rIdx = search(arr, target);
    
    // search in col
    int cIdx = search(matrix[rIdx], target);
    
    return (matrix[rIdx][cIdx]==target);
}

private int search(int[] arr, int target) {
    if(target<=arr[0]) {
        return 0;
    } else if(target>=arr[arr.length-1]) {
        return arr.length-1;
    }
    int start = 0;
    int end = arr.length-1;
    while(start<end-1) {
        int mid = start + (end-start)/2;
        if(arr[mid]==target) {
            return mid;
        } else if(arr[mid]>target) {
            end = mid;
        } else {
            start = mid;
        }
    }
    return start;
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

2. Unique Paths
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

3. Unique Paths II
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

4. Minimum Path Sum
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

5. Climbing Stairs
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

6. Edit Distance
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

2. Rotate Image
Q: You are given an n x n 2D matrix representing an image. Rotate the image by 90 degrees (clockwise).
```
public void rotate(int[][] matrix) {
    int n = matrix.length;
    for(int i=0; i<n/2; i++) {
        int boundary = n-i-1;
        for(int j=i; j<boundary; j++) {
            int tmp = matrix[i][j];
            matrix[i][j] = matrix[n-j-1][i];
            matrix[n-j-1][i] = matrix[boundary][n-j-1];
            matrix[boundary][n-j-1] = matrix[j][boundary];
            matrix[j][boundary] = tmp;
        }
    }
}
```

3. Spiral Matrix
Q: Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
```
public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> list = new ArrayList<>();
    if(matrix.length==0 || matrix[0].length==0) {
        return list;
    }
    int maxR=matrix.length-1, minR=0;
    int maxC=matrix[0].length-1, minC=0;
    int pnt=0, pntR=0, pntC=0, side=0;
    int max=(maxC+1)*(maxR+1);
    
    while(pnt<max) {
        list.add(matrix[pntR][pntC]);
        switch(side) {
            case 0:
                if(pntC==maxC) {
                    pntR++;
                    side=1;
                    minR++;
                } else {
                    pntC++;
                }
                break;
            case 1:
                if(pntR==maxR) {
                    pntC--;
                    side=2;
                } else {
                    pntR++;
                }
                break;
            case 2:
                if(pntC==minC) {
                    pntR--;
                    side=3;
                } else {
                    pntC--;
                }
                break;
            case 3:
                if(pntR==minR) {
                    pntC++;
                    side=0;
                    maxR--;
                    minC++;
                    maxC--;
                } else {
                    pntR--;
                }
                break;
        }
        pnt++;
    }
    
    return list;
}
```

4. Next Permutation
Q:Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers. If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order). The replacement must be in-place, do not allocate extra memory. Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
```
public void nextPermutation(int[] nums) {
    int pnt = nums.length-2;
    // find abnormal idx
    while(pnt>=0 && nums[pnt]>=nums[pnt+1]) {
        pnt--;
    }
    
    // swap abnormal idx when there is one
    int start = pnt;
    if(start>=0) {
        pnt = nums.length-1;
        while(nums[start]>=nums[pnt]) {
            pnt--;
        }
        swap(nums, pnt, start);
    }
    
    // reverse tail
    start++;
    pnt = nums.length-1;
    while(start<pnt) {
        swap(nums, start, pnt);
        start++;
        pnt--;
    }
}

private void swap(int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
}
```

5. Spiral Matrix II
Q: Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
```
public int[][] generateMatrix(int n) {
    int side = 0, max = n-1, min = 0, len = n*n, pnt = 1, row=0, col=0;
    int[][] res = new int[n][n];
    
    while(pnt<=len) {
        res[row][col] = pnt;
        switch(side) {
            case 0:
                if(col==max) {
                    side = 1;
                    row++;
                } else {
                    col++;
                }
                break;
            case 1:
                if(row==max) {
                    side = 2;
                    col--;
                } else {
                    row++;
                }
                break;
            case 2:
                if(col==min) {
                    side = 3;
                    row--;
                    min++;
                } else {
                    col--;
                }
                break;
            case 3:
                if(row==min) {
                    side = 0;
                    col++;
                    max--;
                } else {
                    row--;
                }
                break;
        }
        pnt++;
    }
    
    return res;
}
```

6. Merge Intervals
Q: Given a collection of intervals, merge all overlapping intervals.
good ref: https://leetcode.com/discuss/13953/a-simple-java-solution
```
public List<Interval> merge(List<Interval> intervals) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for(Interval interval:intervals) {
        if(!map.containsKey(interval.start)) {
            map.put(interval.start, interval.end);
        } else {
            map.put(interval.start, Math.max(map.get(interval.start),interval.end));
        }
    }
    
    LinkedList<Interval> list = new LinkedList<>();
    Integer[] set = new Integer[map.size()];
    map.keySet().toArray(set);
    Arrays.sort(set);
    for(Integer key:set) {
        if(list.isEmpty()) {
            list.add(new Interval(key, map.get(key)));
        } else {
            if(key>list.peekLast().end) {
                list.add(new Interval(key, map.get(key)));
            } else {
                Interval last = list.pollLast();
                list.add(new Interval(last.start, Math.max(last.end, map.get(key))));
            }
        }
    }
    
    return list;
}
```

7. Insert Interval
Q: Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary). You may assume that the intervals were initially sorted according to their start times.
```
public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    LinkedList<Interval> list = new LinkedList<>();
    for(Interval interval:intervals) {
        if(newInterval.start>interval.end) {
            list.add(interval);
        } else if(newInterval.end<interval.start) {
            if(list.isEmpty() || list.peekLast().end<newInterval.start) {
                list.add(newInterval);
            }
            list.add(interval);
        }else {
            if(!list.isEmpty() && list.peekLast().end>newInterval.start) {
                Interval prev = list.pollLast();
                list.add(new Interval(prev.start, Math.max(prev.end, interval.end)));
            } else {
                list.add(new Interval(Math.min(interval.start, newInterval.start), 
                    Math.max(interval.end, newInterval.end)));
            }
        }
    }
    if(list.isEmpty() || list.peekLast().end<newInterval.start) {
        list.add(newInterval);
    }
    return list;
}
// more concise
public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    int pnt=0;
    
    while(pnt<intervals.size() && intervals.get(pnt).end<newInterval.start) {
        pnt++;
    }
    while(pnt<intervals.size() && intervals.get(pnt).start<=newInterval.end) {
        newInterval.start = Math.min(newInterval.start, intervals.get(pnt).start);
        newInterval.end = Math.max(newInterval.end, intervals.get(pnt).end);
        intervals.remove(pnt);
    }
    intervals.add(pnt, newInterval);
    
    return intervals;
}
// use iterator
public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    ListIterator<Interval> iter = intervals.listIterator();
    
    while(iter.hasNext()) {
        Interval cur = iter.next();
        if(cur.start>newInterval.end) {
            iter.previous();
            break;
        }
        if(cur.end<newInterval.start) {
            continue;
        }
        if(cur.start<=newInterval.end) {
            newInterval.start = Math.min(newInterval.start, cur.start);
            newInterval.end = Math.max(newInterval.end, cur.end);
            iter.remove();    
        }
    }
    iter.add(newInterval);
    
    return intervals;
}
```

8. Maximum Subarray
Q: Find the contiguous subarray within an array (containing at least one number) which has the largest sum. For example, given the array [−2,1,−3,4,−1,2,1,−5,4], the contiguous subarray [4,−1,2,1] has the largest sum = 6.
```
public int maxSubArray(int[] nums) {
    int max = nums[0], sum = nums[0];
    
    for(int i=1; i<nums.length; i++) {
        if(sum<0) {
            sum = 0;
        }
        sum += nums[i];
        max = Math.max(max, sum);
    }
    
    return max;
}
```

9. Plus One
Q: Given a non-negative number represented as an array of digits, plus one to the number. The digits are stored such that the most significant digit is at the head of the list.
```
public int[] plusOne(int[] digits) {
    int pnt = digits.length-1;
    while(pnt>=0 && digits[pnt]==9) {
        digits[pnt] = 0;
        pnt--;
    }
    if(pnt<0) {
        int[] res = new int[digits.length+1];
        res[0] = 1;
        return res;
    }
    digits[pnt]++;
    return digits;
}
```

10. Set Matrix Zeroes
Q: Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
```
public void setZeroes(int[][] matrix) {
    int row = matrix.length;
    int col = matrix[0].length;
    boolean[] rows = new boolean[row];
    boolean[] cols = new boolean[col];
    
    for(int i=0; i<row; i++) {
        for(int j=0; j<col; j++) {
            if(matrix[i][j] == 0) {
                rows[i] = true;
                cols[j] = true;
            }
        }
    }
    
    for(int i=0; i<row; i++) {
        if(rows[i]) {
            for(int j=0; j<col; j++) {
                matrix[i][j] = 0;
            }
        }
    }
    
    for(int i=0; i<col; i++) {
        if(cols[i]) {
            for(int j=0; j<row; j++) {
                matrix[j][i] = 0;
            }
        }
    }
}
```

##### Greedy
1. Jump Game
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

2. Jump Game II
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

## lintcode
Lintcode Algorithm problems
