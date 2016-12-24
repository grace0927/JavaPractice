#Hash Table

1. [Two Sum](#two-sum)
2. [Longest Substring Without Repeating Characters](#longest-substring-without-repeating-characters)
3. [Valid Sudoku](#valid-sudoku)
4. [Group Anagrams](#group-anagrams)
5. [Substring with Concatenation of All Words](#substring-with-concatenation-of-all-words)
6. [Copy List with Random Pointer](#copy-list-with-random-pointer)
7. [LRU Cache](#lru-cache)
8. [Max Points on a Line](#max-points-on-a-line)
9. [Fraction to Recurring Decimal](#fraction-to-recurring-decimal)
10. [Isomorphic Strings](#isomorphic-strings)
11. [Count Primes](#count-primes)
12. [Happy Number](#happy-number)
13. [Repeated DNA Sequences](#repeated-dna-sequences)
14. [Contains Duplicate](#contains-duplicate)
15. [Contains Duplicate II](#contains-duplicate-ii)
16. [Contains Duplicate III](#contains-duplicate-iii)
17. [Valid Anagram](#valid-anagram)
18. [H-Index](#h-index)
19. [Word Pattern](#word-pattern)
20. [Bulls and Cows](#bulls-and-cows)
21. [Longest Consecutive Sequence](#longest-consecutive-sequence)
22. [Palindrome Pairs](#palindrome-pairs)
23. [Top K Frequent Elements](#top-k-frequent-elements)
24. [Intersection of Two Arrays](#intersection-of-two-arrays)
25. [Intersection of Two Arrays II](#intersection-of-two-arrays-ii)


## Two Sum
Q: Given an array of integers, find two numbers such that they add up to a specific target number.   
A: use HashMap to map value to its index. O(n)   
lookup map for target-value. O(1)   

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

## Longest Substring Without Repeating Characters    
Q: Given a string, find the length of the longest substring without repeating characters. For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.   
A: use hash map to record each character latest index. mark starting point of current substring. calculate length and compare   

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

## Valid Sudoku
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

## Group Anagrams
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

## Substring with Concatenation of All Words
Q: You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.   
```
public List<Integer> findSubstring(String s, String[] words) {
    List<Integer> list = new ArrayList<>();
    if(words.length==0) {
        return list;
    }
    int len = words[0].length();
    if(len>s.length()) {
        return list;
    }

    HashMap<String, Integer> set = new HashMap<>();
    for(int i=0; i<words.length; i++) {
        int cnt = (set.containsKey(words[i]))?set.get(words[i])+1:1;
        set.put(words[i], cnt);
    }
    HashMap<String, Integer> map = new HashMap<>();
    for(int i=0; i<len; i++) {
        int start = i;
        int pnt = start;
        int cnt = 0;
        while(pnt<=s.length()-len) {
            String cur = s.substring(pnt, pnt+len);
            if(set.containsKey(cur)) {
                int c = (map.containsKey(cur))?map.get(cur)+1:1;
                map.put(cur, c);
                if(set.get(cur)>=map.get(cur)) {
                    cnt++;
                    if(cnt==words.length) {
                        list.add(start);
                        String tmp = s.substring(start, start+len);
                        map.put(tmp, map.get(tmp)-1);
                        start += len;
                        cnt--;
                    }
                } else {
                    // duplicate
                    while(set.get(cur)<map.get(cur)) {
                        String tmp = s.substring(start, start+len);
                        map.put(tmp, map.get(tmp)-1);
                        start += len;
                        cnt--;
                    }
                    cnt++;
                }
            } else {
                map.clear();
                cnt = 0;
                start = pnt+len;
            }
            pnt += len;
        }
        map.clear();
    }

    return list;
}
```

## Copy List with Random Pointer
Q: A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null. Return a deep copy of the list.   
```
public RandomListNode copyRandomList(RandomListNode head) {
    HashMap<RandomListNode, RandomListNode> map = new HashMap<>();

    RandomListNode pnt = head;
    while(pnt!=null) {
        if(!map.containsKey(pnt)) {
            RandomListNode cur = new RandomListNode(pnt.label);
            map.put(pnt, cur);
        }
        if(pnt.next!=null && !map.containsKey(pnt.next)) {
            RandomListNode next = new RandomListNode(pnt.next.label);
            map.put(pnt.next, next);
        }
        if(pnt.random!=null && !map.containsKey(pnt.random)) {
            RandomListNode random = new RandomListNode(pnt.random.label);
            map.put(pnt.random, random);
        }
        map.get(pnt).random = (pnt.random==null)?null:map.get(pnt.random);
        map.get(pnt).next = (pnt.next==null)?null:map.get(pnt.next);
        pnt = pnt.next;
    }

    return map.get(head);
}
```

##  LRU Cache
Q: Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set. get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1. set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.   
```
public class LRUCache {
    private int capacity = 0;
    private HashMap<Integer, Integer> map;
    private ArrayList<Integer> key;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        key = new ArrayList<>();
    }

    public int get(int key) {
        if(map.containsKey(key)) {
            this.key.remove(this.key.indexOf(key));
            this.key.add(key);
        }
        return (map.containsKey(key))?map.get(key):-1;
    }

    public void set(int key, int value) {
        if(map.containsKey(key)) {
            this.key.remove(this.key.indexOf(key));
        } else {
            if(this.key.size()==capacity) {
                map.remove(this.key.get(0));
                this.key.remove(0);
            }
        }

        map.put(key, value);
        this.key.add(key);
    }
}
```

##  Max Points on a Line
Q: Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.   
```
public int maxPoints(Point[] points) {
    HashMap<String, Integer> map = new HashMap<>();
    int max = 0;
    for(int i=0; i<points.length; i++) {
        int base=1, tmp=0;
        for(int j=i+1; j<points.length; j++) {
            if(equals(points[i], points[j])) {
                base++;
                continue;
            }
            String k = cal(points[i], points[j]);
            int t = (map.containsKey(k))?map.get(k)+1:1;
            map.put(k, t);
            tmp = Math.max(tmp, t);
        }
        max = Math.max(max, tmp+base);
        map.clear();
    }
    return max;
}

private String cal(Point a, Point b) {
    if(a.y==b.y) {
        return "0";
    }
    return (a.x!=b.x)?Double.toString((double)(a.y-b.y)/(a.x-b.x)):"Inf";
}

private boolean equals(Point a, Point b) {
    return (a.x==b.x)&&(a.y==b.y);
}
```

##  Fraction to Recurring Decimal
Q: Given two integers representing the numerator and denominator of a fraction, return the fraction in string format. If the fractional part is repeating, enclose the repeating part in parentheses.   
```
public String fractionToDecimal(int numerator, int denominator) {
    StringBuilder sb = new StringBuilder();
    if((numerator<0&&denominator>0) || (numerator>0&&denominator<0)) {
        sb.append('-');
    }
    long num = Math.abs(numerator);
    long den = Math.abs(denominator);
    sb.append(Math.abs(num/den));
    if(num%den == 0) {
        return sb.toString();
    }
    sb.append('.');
    HashMap<Long, Integer> map = new HashMap<>();
    while(num%den!=0) {
        num %= den;
        num *= 10;
        if(map.containsKey(num)) {
            sb.insert(map.get(num).intValue()-1, '(');
            sb.append(')');
            return sb.toString();
        }
        sb.append(Math.abs(num/den));
        map.put(num, sb.length());
    }
    return sb.toString();
}
```

## Isomorphic Strings
Q: Given two strings s and t, determine if they are isomorphic. Two strings are isomorphic if the characters in s can be replaced to get t. All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.   
```
public boolean isIsomorphic(String s, String t) {
    HashMap<Character, Character> sm = new HashMap<>();
    HashMap<Character, Character> tm = new HashMap<>();
    for(int i=0; i<s.length(); i++) {
        if(!sm.containsKey(s.charAt(i))) {
            sm.put(s.charAt(i), t.charAt(i));
        }
        if(!tm.containsKey(t.charAt(i))) {
            tm.put(t.charAt(i), s.charAt(i));
        }
        if(sm.get(s.charAt(i))!=t.charAt(i) || tm.get(t.charAt(i))!=s.charAt(i)) {
            return false;
        }
    }
    return true;
}
```

##  Count Primes
Q: Count the number of prime numbers less than a non-negative number, n.   
```
public int countPrimes(int n) {
    boolean[] res = new boolean[n];
    int cnt = 0;
    for(int i=2; i<n; i++) {
        if(!res[i]) {
            cnt++;
            for(int j=i; j<=n/i && i*j<n; j++) {
                res[i*j] = true;
            }
        }
    }
    return cnt;
}
```

## Happy Number
Q: Write an algorithm to determine if a number is "happy". A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.   
```
public boolean isHappy(int n) {
    Set<Integer> set = new HashSet<>();
    while(n!=1) {
        if(set.contains(n)) {
            return false;
        }
        set.add(n);
        int tmp = 0;
        while(n>0) {
            tmp += (n%10)*(n%10);
            n /= 10;
        }
        n = tmp;
    }
    return true;
}
```

##  Repeated DNA Sequences
Q: All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA. Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.   
```
public List<String> findRepeatedDnaSequences(String s) {
    List<String> list = new ArrayList<>();
    HashMap<String, Integer> map = new HashMap<String, Integer>();
    for(int i=0; i<=s.length()-10; i++) {
        String str = s.substring(i, i+10);
        if(map.containsKey(str) && map.get(str)==1) {
            list.add(str);
        }
        map.put(str, map.containsKey(str)?map.get(str)+1:1);
    }
    return list;
}
```

## Contains Duplicate
Q: Given an array of integers, find if the array contains any duplicates. Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.   
```
public boolean containsDuplicate(int[] nums) {
    HashSet<Integer> set = new HashSet<>();
    for(int n:nums) {
        if(set.contains(n)) {
            return true;
        }
        set.add(n);
    }
    return false;
}
```

## Contains Duplicate II
Q: Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the difference between i and j is at most k.   
```
public boolean containsNearbyDuplicate(int[] nums, int k) {
    HashSet<Integer> set = new HashSet<>();
    for(int i=0, j=0; i<nums.length; i++) {
        if(i-j>k) {
            set.remove(nums[j++]);
        }
        if(set.contains(nums[i])) {
            return true;
        }
        set.add(nums[i]);
    }
    return false;
}
```

## Contains Duplicate III
Q: Given an array of integers, find out whether there are two distinct indices i and j in the array such that the difference between nums[i] and nums[j] is at most t and the difference between i and j is at most k.   
```
// bucket sort
public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    if(k<1 || t<0) {
        return false;
    }
    HashMap<Long, Long> map = new HashMap<>();
    for(int i=0; i<nums.length; i++) {
        long value = (long)nums[i]-Integer.MIN_VALUE;
        long key = value/((long)t+1);
        if(map.containsKey(key)) {
            return true;
        } else if(map.containsKey(key-1) && value-map.get(key-1)<=t) {
            return true;
        } else if(map.containsKey(key+1) && map.get(key+1)-value<=t) {
            return true;
        }
        if(i>=k) {
            map.remove(((long)nums[i-k]-Integer.MIN_VALUE)/((long)t+1));
        }
        map.put(key, value);
    }
    return false;
}
// BST
public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    if(nums.length <= 1) {
        return false;
    }

    TreeSet<Integer> set = new TreeSet<>();
    for(int i=0; i<nums.length; i++) {
        int cur = nums[i];
        if((set.floor(cur)!=null && cur<=set.floor(cur)+t) || (set.ceiling(cur)!=null && cur>=set.ceiling(cur)-t)) {
            return true;
        }
        set.add(cur);
        if(i >= k) {
            set.remove(nums[i-k]);
        }
    }

    return false;
}
```

## Valid Anagram
Q: Given two strings s and t, write a function to determine if t is an anagram of s. Note: You may assume the string contains only lowercase alphabets. Follow up: What if the inputs contain unicode characters? How would you adapt your solution to such case?   
```
public boolean isAnagram(String s, String t) {
    if(s.length()!=t.length()) {
        return false;
    }
    int[] set = new int[26];
    for(int i=0; i<s.length(); i++) {
        set[s.charAt(i)-'a']++;
        set[t.charAt(i)-'a']--;
    }
    for(int i=0; i<26; i++) {
        if(set[i]!=0) {
            return false;
        }
    }
    return true;
}
```

## H-Index
Q: Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index. According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each." For example, given citations = [3, 0, 6, 1, 5], which means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively. Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, his h-index is 3. Note: If there are several possible values for h, the maximum one is taken as the h-index.   
```
public int hIndex(int[] citations) {
    int n=citations.length;
    int[] res = new int[n+1];
    for(int i=0; i<n; i++) {
        if(citations[i]>n) {
            res[n]++;
        } else {
            res[citations[i]]++;
        }
    }
    for(int i=n; i>=0; i--) {
        res[i] = (i<n)?res[i]+res[i+1]:res[i];
        if(i<=res[i]) {
            return i;
        }
    }
    return 0;
}
```

## Word Pattern
Q: Given a pattern and a string str, find if str follows the same pattern. Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str. Notes: You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.   
```
public boolean wordPattern(String pattern, String str) {
    HashMap<Character, String> aMap = new HashMap<>();
    HashMap<String, Character> sMap = new HashMap<>();
    String[] arr = str.split(" ");
    if(pattern.length()!=arr.length) {
        return false;
    }
    for(int i=0; i<arr.length; i++) {
        Character a = pattern.charAt(i);
        String s = arr[i];
        if(aMap.containsKey(a) && !aMap.get(a).equals(s)) {
            return false;
        }
        if(sMap.containsKey(s) && sMap.get(s)!=a) {
            return false;
        }
        aMap.put(a, s);
        sMap.put(s, a);
    }
    return true;
}
```

## Bulls and Cows
Q: You are playing the following Bulls and Cows game with your friend: You write down a number and ask your friend to guess what the number is. Each time your friend makes a guess, you provide a hint that indicates how many digits in said guess match your secret number exactly in both digit and position (called "bulls") and how many digits match the secret number but locate in the wrong position (called "cows"). Your friend will use successive guesses and hints to eventually derive the secret number. For example: Secret number:  "1807" Friend's guess: "7810" Hint: 1 bull and 3 cows. (The bull is 8, the cows are 0, 1 and 7.) Write a function to return a hint according to the secret number and friend's guess, use A to indicate the bulls and B to indicate the cows. In the above example, your function should return "1A3B". Please note that both secret number and friend's guess may contain duplicate digits, for example: Secret number:  "1123"Friend's guess: "0111" In this case, the 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow, and your function should return "1A1B". You may assume that the secret number and your friend's guess only contain digits, and their lengths are always equal.   
```
public String getHint(String secret, String guess) {
    int bulls=0, cows=0;
    int[] ret = new int[10];
    for(int i=0; i<secret.length(); i++) {
        int s = secret.charAt(i)-'0';
        int g = guess.charAt(i)-'0';
        if(s==g) {
            bulls++;
        } else {
            if(ret[s]<0) {
                cows++;
            }
            if(ret[g]>0) {
                cows++;
            }
            ret[s]++;
            ret[g]--;
        }
    }
    return bulls+"A"+cows+"B";
}
```

## Longest Consecutive Sequence
Q: Given an unsorted array of integers, find the length of the longest consecutive elements sequence. Your algorithm should run in O(n) complexity.   
```
public int longestConsecutive(int[] nums) {
    HashMap<Integer, Integer> map = new HashMap<>();
    HashSet<Integer> set = new HashSet<>();
    for(int i=0; i<nums.length; i++) {
        if(set.contains(nums[i])) {
            continue;
        }
        int top=nums[i], bottom=nums[i];
        if(map.containsKey(nums[i]+1)) {
            top = Math.max(map.get(nums[i]+1), nums[i]+1);
        }
        if(map.containsKey(nums[i]-1)) {
            bottom = Math.min(map.get(nums[i]-1), nums[i]-1);
        }
        map.put(top, bottom);
        map.put(bottom, top);
        set.add(nums[i]);
    }

    int max=0;
    for(int key:map.keySet()) {
        max = Math.max(map.get(key)-key+1, max);
    }

    return max;
}
// another one
public int longestConsecutive(int[] num) {
    HashSet<Integer> set = new HashSet<>();
    int max = 0;

    for(int i=0; i<num.length; i++) {
        set.add(num[i]);
    }

    for(int i=0; i<num.length; i++) {
        int key = num[i], len=1, down=key-1, up=key+1;
        if(!set.contains(key)) {
            continue;
        }
        while(set.contains(down)){
            set.remove(down--);
            len++;
        }
        while(set.contains(up)) {
            set.remove(up++);
            len++;
        }
        max = Math.max(max, len);
    }

    return max;
}
// ref: https://leetcode.com/discuss/18886/my-really-simple-java-o-n-solution-accepted
public int longestConsecutive(int[] num) {
    int res = 0;
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int n : num) {
        if (!map.containsKey(n)) {
            int left = (map.containsKey(n - 1)) ? map.get(n - 1) : 0;
            int right = (map.containsKey(n + 1)) ? map.get(n + 1) : 0;
            // sum: length of the sequence n is in
            int sum = left + right + 1;
            map.put(n, sum);

            // keep track of the max length
            res = Math.max(res, sum);

            // extend the length to the boundary(s)
            // of the sequence
            // will do nothing if n has no neighbors
            map.put(n - left, sum);
            map.put(n + right, sum);
        }
        else {
            // duplicates
            continue;
        }
    }
    return res;
}
```

## Palindrome Pairs
Q: Given a list of unique words. Find all pairs of distinct indices (i, j) in the given list, so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.   
```
public List<List<Integer>> palindromePairs(String[] words) {
    List<List<Integer>> lists = new ArrayList<>();
    HashMap<String, Integer> dict = new HashMap<>();
    for(int i=0; i<words.length; i++) {
        dict.put(words[i], i);
    }
    for(int i=0; i<words.length; i++) {
        for(int j=0; j<words[i].length(); j++) {
            String left = words[i].substring(0, j);
            String right = words[i].substring(j);
            helper(left, right, dict, lists, i, true);
            helper(right, left, dict, lists, i, false);
        }
        helper(words[i], "", dict, lists, i, true);
    }
    return lists;
}

private void helper(String main, String rev, HashMap<String, Integer> dict, List<List<Integer>> lists, int idx, boolean flag) {
    if(isPalindrome(main)) {
        String s = new StringBuilder(rev).reverse().toString();
        if(dict.containsKey(s) && dict.get(s)!=idx) {
            List<Integer> list = new ArrayList<>();
            if(!flag) {
                list.add(idx);
                list.add(dict.get(s));
            } else {
                list.add(dict.get(s));
                list.add(idx);
            }
            lists.add(list);
        }
    }
}

private boolean isPalindrome(String s) {
    int start=0, end=s.length()-1;
    while(start<end) {
        if(s.charAt(start++)!=s.charAt(end--)) {
            return false;
        }
    }
    return true;
}
```

## Top K Frequent Elements
Q: Given a non-empty array of integers, return the k most frequent elements.   
more sol ref: https://leetcode.com/discuss/100713/3-ways-to-solve-this-problem   
```
class Node {
    int val;
    int cnt;
    public Node(int val) {
        this.val = val;
        this.cnt = 1;
    }
}

public List<Integer> topKFrequent(int[] nums, int k) {
    HashMap<Integer, Node> map = new HashMap<>();
    ArrayList<Node> list = new ArrayList<>();
    for(int i=0; i<nums.length; i++) {
        if(!map.containsKey(nums[i])) {
            Node node = new Node(nums[i]);
            map.put(nums[i], node);
            list.add(node);
        } else {
            map.get(nums[i]).cnt++;
        }
    }
    Collections.sort(list, new Comparator<Node>(){
        public int compare(Node a, Node b) {
            return b.cnt-a.cnt;
        }
    });
    List<Integer> lists = new ArrayList<>();
    for(int i=0; i<k; i++) {
        lists.add(list.get(i).val);
    }
    return lists;
}
```

## Intersection of Two Arrays
Q: Given two arrays, write a function to compute their intersection. Note: Each element in the result must be unique. The result can be in any order.   
```
// Hash Table
public int[] intersection(int[] nums1, int[] nums2) {
    HashSet<Integer> set = new HashSet<>();
    for(int i=0; i<nums1.length; i++) {
        set.add(nums1[i]);
    }
    HashSet<Integer> inter = new HashSet<>();
    for(int i=0; i<nums2.length; i++) {
        if(set.contains(nums2[i])) {
            inter.add(nums2[i]);
        }
    }
    return toArray(inter);
}

private int[] toArray(HashSet<Integer> set) {
    int[] res = new int[set.size()];
    int j=0;
    for(int i:set) {
        res[j++] = i;
    }
    return res;
}
// Binary Search
public int[] intersection(int[] nums1, int[] nums2) {
    HashSet<Integer> set = new HashSet<>();
    HashSet<Integer> inter = new HashSet<>();
    Arrays.sort(nums2);
    for(int i=0; i<nums1.length; i++) {
        if(!set.contains(nums1[i])) {
            set.add(nums1[i]);
            if(Arrays.binarySearch(nums2, nums1[i])>=0) {
                inter.add(nums1[i]);
            }
        }
    }

    return toArray(inter);
}
```

## Intersection of Two Arrays II
Q: Given two arrays, write a function to compute their intersection. Note: Each element in the result should appear as many times as it shows in both arrays. The result can be in any order. Follow up: What if the given array is already sorted? How would you optimize your algorithm? What if nums1's size is small compared to num2's size? Which algorithm is better? What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?   
```
public int[] intersect(int[] nums1, int[] nums2) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for(int i=0; i<nums1.length; i++) {
        if(!map.containsKey(nums1[i])) {
            map.put(nums1[i], 1);
        } else {
            map.put(nums1[i], map.get(nums1[i])+1);
        }
    }
    List<Integer> list = new ArrayList<>();
    for(int i=0; i<nums2.length; i++) {
        if(map.containsKey(nums2[i]) && map.get(nums2[i])>0) {
            map.put(nums2[i], map.get(nums2[i])-1);
            list.add(nums2[i]);
        }
    }
    return toArray(list);
}

private int[] toArray(List<Integer> list) {
    int[] arr = new int[list.size()];
    int pnt = 0;
    for(int i:list) {
        arr[pnt++] = i;
    }
    return arr;
}
```
