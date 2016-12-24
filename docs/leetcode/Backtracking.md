# Backtracking

1. [Letter Combinations of a Phone Number](#letter-combinations-of-a-phone-number)   
2. [Generate Parentheses](#generate-parentheses)   
3. [Sudoku Solver](#sudoku-solver)   
4. [Combination Sum](#combination-sum)   
5. [Combination Sum II](#combination-sum-ii)   
6. [Permutations](#permutations)   
7. [Permutations II](#permutations-ii)   
8. [N-Queens, N-Queens II](#n-queens-n-queens-ii)   
9. [Combinations](#combinations)   
10. [Subsets](#subsets)   
11. [Word Search](#word-search)   
12. [Gray Code](#gray-code)
13. [Subsets II](#subsets-ii)
14. [Restore IP Addresses](#restore-ip-address)
15. [Palindrome Partitioning](#palindrome-partitioning)
16. [Add and Search Word - Data structure design](#add-and-search-word-data-structure-design)
17. [Combination Sum III](#combination-sum-iii)
18. [Additive Number](#additive-number)
19. [Regular Expression Matching](#regular-expression-matching)
20. [Word Break II](#word-break-ii)
21. [Expression Add Operators](#expression-add-operators)

## Letter Combinations of a Phone Number   
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

## Generate Parentheses   
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

## Sudoku Solver   
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

## Combination Sum   
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

## Combination Sum II   
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

## Permutations   
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

## Permutations II   
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

## N-Queens, N-Queens II   
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

## Combinations   
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

## Subsets   
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

## Word Search   
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

##  Gray Code
The gray code is a binary numeral system where two successive values differ in only one bit. Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.   

For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:   
00 - 0   
01 - 1   
11 - 3   
10 - 2   
Note:   
For a given n, a gray code sequence is not uniquely defined. For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.For now, the judge is able to judge based on one instance of gray code sequence.   
```
public List<Integer> grayCode(int n) {
    List<Integer> list = new ArrayList<>();

    if(n==0) {
        list.add(0);
    } else {
        ListIterator<Integer> it = grayCode(n-1).listIterator();
        while(it.hasNext()) {
            list.add(it.next());
        }
        int base = 1<<(n-1);
        while(it.hasPrevious()) {
            list.add(it.previous()+base);
        }
    }

    return list;
}
```

##  Subsets II
Q: Given a collection of integers that might contain duplicates, nums, return all possible subsets. Note: Elements in a subset must be in non-descending order. The solution set must not contain duplicate subsets.
```
public List<List<Integer>> subsetsWithDup(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> lists = new ArrayList<>();
    LinkedList<Integer> list = new LinkedList<>();
    lists.add(new LinkedList<Integer>());
    helper(lists, list, nums, 0);
    return lists;
}

private void helper(List<List<Integer>> lists, LinkedList<Integer> list, int[] nums, int start) {
    if(start==nums.length) {
        return ;
    }
    for(int i=start; i<nums.length; i++) {
        if(i>start && nums[i]==nums[i-1]) {
            continue;
        }
        list.add(nums[i]);
        lists.add(new LinkedList<Integer>(list));
        helper(lists, list, nums, i+1);
        list.removeLast();
    }
}
```

##  Restore IP Addresses
Q: Given a string containing only digits, restore it by returning all possible valid IP address combinations.   
```
public List<String> restoreIpAddresses(String s) {
    List<String> list = new ArrayList<>();
    StringBuilder sb = new StringBuilder(s);
    helper(list, sb, 0, 0);
    return list;
}

private void helper(List<String> list, StringBuilder sb, int start, int cnt) {
    if(cnt==3) {
        if(start>=sb.length()-3 && start<sb.length()
            && Integer.parseInt(sb.substring(start))<256
            && !(start!=sb.length()-1 && sb.charAt(start)=='0')) {
            list.add(sb.toString());
        }
        return ;
    }
    for(int i=start+1; i<sb.length() && Integer.parseInt(sb.substring(start, i))<256; i++) {
        if(i>start+1 && sb.charAt(start)=='0') {
            break;
        }
        sb.insert(i, '.');
        helper(list, sb, i+1, cnt+1);
        sb.deleteCharAt(i);
    }
}
```

## Palindrome Partitioning
Q: Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.   
```
public List<List<String>> partition(String s) {
    List<List<String>> lists = new ArrayList<>();
    List<String> list = new ArrayList<>();
    helper(lists, list, s, 0);
    return lists;
}

private void helper(List<List<String>> lists, List<String> list, String s, int start) {
    if(start==s.length()) {
        lists.add(new ArrayList<>(list));
    }
    for(int i=start+1; i<=s.length(); i++) {
        String tmp = s.substring(start, i);
        if(isPalindrome(tmp)) {
            list.add(tmp);
            helper(lists, list, s, i);
            list.remove(list.size()-1);
        }
    }
}

private boolean isPalindrome(String s) {
    for(int i=0; i<s.length()/2; i++) {
        if(s.charAt(i)!=s.charAt(s.length()-1-i)) {
            return false;
        }
    }
    return true;
}
```

## Add and Search Word - Data structure design
Q: Design a data structure that supports the following two operations: void addWord(word) bool search(word) search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.   
```
public class WordDictionary {
    class TrieNode {
        char val;
        TrieNode[] map;
        boolean end;
        TrieNode(char a) {
            val = a;
            map = new TrieNode[26];
            end = false;
        }
    }

    TrieNode root = new TrieNode('#');

    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode pnt = root;
        for(int i=0; i<word.length(); i++) {
            int idx = word.charAt(i)-'a';
            if(pnt.map[idx]==null) {
                pnt.map[idx] = new TrieNode(word.charAt(i));
            }
            pnt = pnt.map[idx];
        }
        pnt.end = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return helper(root, word);
    }

    private boolean helper(TrieNode pnt, String word) {
        for(int i=0; i<word.length(); i++) {
            char tmp = word.charAt(i);
            if(tmp == '.') {
                String str = word.substring(i+1);
                for(TrieNode a:pnt.map) {
                    if(a!=null && helper(a, str)) {
                        return true;
                    }
                }
                return false;
            } else {
                if(pnt.map[tmp-'a']==null) {
                    return false;
                }
                pnt = pnt.map[tmp-'a'];
            }
        }

        return pnt.end;
    }
}
```

## Combination Sum III
Q: Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers. Ensure that numbers within the set are sorted in ascending order.   
```
public List<List<Integer>> combinationSum3(int k, int n) {
    List<List<Integer>> lists = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    helper(lists, list, k, n, 1);
    return lists;
}
private void helper(List<List<Integer>> lists, List<Integer> list, int k, int n, int start) {
    if(k==0) {
        if(n==0) {
            lists.add(new ArrayList<Integer>(list));
        }
        return ;
    }
    for(int i=start; i<=9 && i<=n; i++) {
        list.add(i);
        helper(lists, list, k-1, n-i, i+1);
        list.remove(list.size()-1);
    }
}
```

## Additive Number
Q: Additive number is a string whose digits can form additive sequence. A valid additive sequence should contain at least three numbers. Except for the first two numbers, each subsequent number in the sequence must be the sum of the preceding two. Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid. Given a string containing only digits '0'-'9', write a function to determine if it's an additive number. Follow up: How would you handle overflow for very large input integers?   
```
public boolean isAdditiveNumber(String num) {
    int n=num.length();
    if(n<3) {
        return false;
    }

    for(int i=1; i<=n/2; i++) {
        if(num.charAt(0)=='0' && i>1) {
            break;
        }
        String a = num.substring(0, i);
        for(int j=i+1; j<=n/3*2+1; j++) {
            if(num.charAt(i)=='0' && j>i+1) {
                break;
            }
            String b = num.substring(i, j);
            String c = helper(a, b, n);
            if(c.equals(num)) {
                return true;
            }
        }
    }

    return false;
}

private String helper(String a, String b, int n) {
    StringBuilder sb = new StringBuilder();
    sb.append(a);
    sb.append(b);
    Long al = Long.parseLong(a);
    Long bl = Long.parseLong(b);
    if(sb.length()>=n) {
        return "";
    }
    while(sb.length()<n) {
        Long cl = al + bl;
        String c = cl.toString();
        sb.append(c);
        al = bl;
        bl = cl;
    }
    return sb.toString();
}
```

## Regular Expression Matching
Q: Implement regular expression matching with support for '.' and '*'. '.' Matches any single character. '*' Matches zero or more of the preceding element. The matching should cover the entire input string (not partial).   
```
// backtracking
public boolean isMatch(String s, String p) {
    return helper(s, 0, p, 0);
}

private boolean helper(String s, int ss, String p, int ps) {
    if(ss<s.length() && ps==p.length()) {
        return false;
    }
    char last = ' ';
    while(ss<s.length() && ps<p.length()) {
        char sc = s.charAt(ss);
        char pc = p.charAt(ps);
        if(sc==pc || pc=='.') {
            ss++;
            ps++;
            last = pc;
            continue;
        } else if(pc=='*') {
            if(ss>0 && helper(s, ss-1, p, ps+1)) {
                return true;
            }
            if(helper(s, ss, p, ps+1)) {
                return true;
            }
            int tmp=ss;
            while(tmp<s.length() && (s.charAt(tmp)==last || last=='.')) {
                if(helper(s, tmp+1, p, ps+1)) {
                    return true;
                }
                tmp++;
            }
            return false;
        } else {
            return (ps+1<p.length() && p.charAt(ps+1)=='*' && helper(s, ss, p, ps+2));
        }
    }

    while(ps<p.length()) {
        if(p.charAt(ps)!='*' && (ps+1>=p.length() || p.charAt(ps+1)!='*')) {
            return false;
        }
        if(p.charAt(ps)=='*') {
            if(ss>0 && helper(s, ss-1, p, ps+1)) {
                return true;
            }
            if(helper(s, ss, p, ps+1)) {
                return true;
            }
            int tmp=ss;
            while(tmp<s.length() && (s.charAt(tmp)==last || last=='.')) {
                if(helper(s, tmp+1, p, ps+1)) {
                    return true;
                }
                tmp++;
            }
            return false;
        }
        ps += 2;
    }

    return (ss==s.length() && ps>=p.length());
}
// dp
public boolean isMatch(String s, String p) {
    int lenS = s.length();
    int lenP = p.length();
    boolean[][] table = new boolean[lenS+1][lenP+1];

    table[0][0] = true;
    for(int i=0; i<lenS; i++) {
        table[i+1][0] = false;
    }
    for(int i=0; i<lenP; i++) {
        table[0][i+1] = (i>0 && table[0][i-1] && p.charAt(i)=='*');
    }

    for(int i=0; i<lenS; i++) {
        for(int j=0; j<lenP; j++) {
            char curS = s.charAt(i);
            char curP = p.charAt(j);
            if(curP != '*') {
                table[i+1][j+1] = (table[i][j] && (curS==curP || curP=='.'));
            } else {
                table[i+1][j+1] = ((j>0 && table[i+1][j-1]) || table[i+1][j] || (j>0 && table[i][j+1] && (p.charAt(j-1)=='.' || curS == p.charAt(j-1))));
            }
        }
    }

    return table[lenS][lenP];
}
```

## Word Break II
Q: Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences.   
```
public List<String> wordBreak(String s, Set<String> wordDict) {
    List<String> list = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    HashMap<Integer, Boolean> cache = new HashMap<>();
    helper(list, s, wordDict, sb, 0, cache);
    return list;
}

private void helper(List<String> list, String s, Set<String> dict, StringBuilder sb, int start, HashMap<Integer, Boolean> cache) {
    if(s.length()==start) {
        sb.deleteCharAt(sb.length()-1);
        list.add(new String(sb.toString()));
        return ;
    }
    for(int i=start+1; i<=s.length(); i++) {
        String str = s.substring(start, i);
        if(dict.contains(str) && (!cache.containsKey(i) || cache.get(i))) {
            int ls = sb.length();
            int ll = list.size();
            sb.append(str);
            sb.append(" ");
            helper(list, s, dict, sb, i, cache);
            sb.delete(ls, sb.length());
            if(ll<list.size()) {
                cache.put(i, true);
            } else {
                cache.put(i, false);
            }
        }
    }
}
```

## Expression Add Operators
Q: Given a string that contains only digits 0-9 and a target value, return all possibilities to add binary operators (not unary) +, -, or * between the digits so they evaluate to the target value.   
```
public List<String> addOperators(String num, int target) {
    List<String> list = new ArrayList<>();
    for(int i=1; i<=num.length(); i++) {
        if(num.charAt(0)=='0' && i>1) {
            break;
        }
        String str = num.substring(0, i);
        long res = Long.parseLong(str);
        helper(num, i, res, res, target, list, str);
    }

    return list;
}
private void helper(String num, int start, long res, long pre, int target, List<String> list, String s) {
    if(start==num.length()) {
        if(res==(long)target) {
            list.add(s);
        }
        return ;
    }
    for(int i=start+1; i<=num.length(); i++) {
        if(num.charAt(start)=='0' && i>start+1) {
            break;
        }
        String str = num.substring(start, i);
        long cur = Long.parseLong(str);
        helper(num, i, res+cur, cur, target, list, s+"+"+str);
        helper(num, i, res-cur, -cur, target, list, s+"-"+str);
        helper(num, i, res-pre+pre*cur, pre*cur, target, list, s+"*"+str);
    }
}
```
