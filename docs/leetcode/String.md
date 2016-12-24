#String
1. [Longest Palindromic Substring](#longest-palindromic-substring)
2. [ZigZag Conversion](#zigzag-conversion)
3. [Longest Common Prefix](#longest-common-prefix)
4. [String to Integer (atoi)](#string-to-integer-atoi)
5. [Count and Say](#count-and-say)
6. [Multiply Strings](#multiply-strings)
7. [Length of Last Word](#length-of-last-word)
8. [Add Binary](#add-binary)
9. [Text Justification](#text-justification)
10. [Reverse Words in a String](#reverse-words-in-a-string)
11. [Compare Version Numbers](#compare-version-numbers)
12. [Basic Calculator II](#basic-calculator-ii)
13. [Integer to English Words](#integer-to-english-words)
14. [Reverse String](#reverse-string)
15. [Shortest Palindrome](#shortest-palindrome)

## Longest Palindromic Substring
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

# ZigZag Conversion   
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

#Longest Common Prefix   
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

#String to Integer (atoi)   
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

#Count and Say   
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

#Multiply Strings   
Q: Given two numbers represented as strings, return multiplication of the numbers as a string. Note: The numbers can be arbitrarily large and are non-negative.   
better sol ref: https://leetcode.com/discuss/71593/easiest-java-solution-with-graph-explanation   
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

#Length of Last Word   
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

#Add Binary   
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

#Text Justification   
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

## Reverse Words in a String
Q: Given an input string, reverse the string word by word.
```
public String reverseWords(String s) {
    LinkedList<Character> stack = new LinkedList<>();
    StringBuilder sb = new StringBuilder();
    for(int i=s.length()-1; i>=0; i--) {
        char tmp = s.charAt(i);
        if(tmp==' ') {
            if(!stack.isEmpty()) {
                stack.add(0, tmp);
            }
            while(!stack.isEmpty()) {
                sb.append(stack.pollLast());
            }
        } else {
            stack.add(tmp);
        }
    }
    while(!stack.isEmpty()) {
        sb.append(stack.pollLast());
    }
    if(sb.length()>0 && sb.charAt(sb.length()-1)==' ') {
        sb.deleteCharAt(sb.length()-1);
    }
    return sb.toString();
}
```

##  Compare Version Numbers
Q: Compare two version numbers version1 and version2. If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0. You may assume that the version strings are non-empty and contain only digits and the . character. The . character does not represent a decimal point and is used to separate number sequences.   
```
public int compareVersion(String version1, String version2) {
    String[] token1 = version1.split("\\.");
    String[] token2 = version2.split("\\.");
    int i=0;
    for(i=0; i<token1.length && i<token2.length; i++) {
        int val1=Integer.parseInt(token1[i]), val2=Integer.parseInt(token2[i]);
        if(val1<val2) {
            return -1;
        } else if(val1>val2) {
            return 1;
        }
    }
    while(i<token1.length) {
        if(Integer.parseInt(token1[i])!=0) {
            return 1;
        }
        i++;
    }
    while(i<token2.length) {
        if(Integer.parseInt(token2[i])!=0) {
            return -1;
        }
        i++;
    }
    return 0;
}
```

## Basic Calculator II
Q: Implement a basic calculator to evaluate a simple expression string. The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero. You may assume that the given expression is always valid.   
```
class OperatorFactory {
    private static Operator op;
    public static Operator getOp(char a) {
        switch(a) {
            case '+':
                op = new Add();
                break;
            case '-':
                op = new Sub();
                break;
            case '*':
                op = new Mul();
                break;
            case '/':
                op = new De();
                break;
        }
        return op;
    }
}

class Operator {
    public String calculate(String b, String a) {
        return "";
    }
}
class Add extends Operator {
    public String calculate(String b, String a) {
        Long c = Long.parseLong(a)+Long.parseLong(b);
        return String.valueOf(c);
    }
}
class Sub extends Operator {
    public String calculate(String b, String a) {
        Long c = Long.parseLong(a)-Long.parseLong(b);
        return String.valueOf(c);
    }
}
class Mul extends Operator {
    public String calculate(String b, String a) {
        Long c = Long.parseLong(a)*Long.parseLong(b);
        return String.valueOf(c);
    }
}
class De extends Operator {
    public String calculate(String b, String a) {
        Long c = Long.parseLong(a)/Long.parseLong(b);
        return String.valueOf(c);
    }
}
public class Solution {
    public int calculate(String s) {
        LinkedList<String> num = new LinkedList<>();
        LinkedList<Character> op = new LinkedList<>();
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(isOp(c)) {
                if(!op.isEmpty() && isAdvanceOp(op.peekLast())) {
                    num.add(calculate(num.pollLast(), op.pollLast(), num.pollLast()));
                }
                op.add(c);
            } else if(isDigit(s, i)) {
                if(i>0 && isDigit(s, i-1)) {
                    num.add(num.pollLast()+c);
                } else {
                    num.add(""+c);
                }
            }
        }
        if(!op.isEmpty() && isAdvanceOp(op.peekLast())) {
            num.add(calculate(num.pollLast(), op.pollLast(), num.pollLast()));
        }
        while(!op.isEmpty()) {
            String a = num.poll();
            String b = num.poll();
            num.add(0, calculate(b, op.poll(), a));
        }
        return Integer.parseInt(num.poll());
    }

    private boolean isOp(char a) {
        return a=='*'||a=='/'||a=='+'||a=='-';
    }

    private boolean isDigit(String a, int idx) {
        return a.charAt(idx)>='0' && a.charAt(idx)<='9';
    }

    private boolean isAdvanceOp(char a) {
        return a=='*'||a=='/';
    }

    private String calculate(String b, char op, String a) {
        Operator operator = OperatorFactory.getOp(op);
        return operator.calculate(b, a);
    }

}
```

## Integer to English Words
Q: Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1.   
```
public String numberToWords(int num) {
    if(num==0) {
        return "Zero";
    }
    int idx=0;
    String[] base = {"", "Thousand ", "Million ", "Billion "};
    StringBuilder sb = new StringBuilder();
    while(num>0) {
        String a = say(num%1000);
        if(!a.equals("")) {
            sb.insert(0,a+base[idx]);
        }
        num /= 1000;
        idx++;
    }
    sb.deleteCharAt(sb.length()-1);
    return sb.toString();
}

private String say(int num) {
    StringBuilder sb = new StringBuilder();
    String[] one = {"", "One ", "Two ", "Three ", "Four ", "Five ", "Six ", "Seven ", "Eight ", "Nine "};
    String[] teen = {"Ten ", "Eleven ", "Twelve ", "Thirteen ", "Fourteen ", "Fifteen ", "Sixteen ", "Seventeen ", "Eighteen ", "Nineteen "};
    String[] ty = {"Twenty ", "Thirty ", "Forty ", "Fifty ", "Sixty ", "Seventy ", "Eighty ", "Ninety "};
    if(num>=100) {
        sb.append(one[num/100]+"Hundred ");
        num %= 100;
    }
    if(num>=20) {
        sb.append(ty[num/10-2]);
        num %= 10;
    }
    if(num>=10) {
        sb.append(teen[num-10]);
        num = 0;
    }
    if(num>=0) {
        sb.append(one[num]);
    }
    return sb.toString();
}
```

## Reverse String
Q: Write a function that takes a string as input and returns the string reversed.   
```
public String reverseString(String s) {
    StringBuilder sb = new StringBuilder();
    for(int i=0; i<s.length(); i++) {
        sb.insert(0, s.charAt(i));
    }
    return sb.toString();
}
```

## Shortest Palindrome
Q: Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it. Find and return the shortest palindrome you can find by performing this transformation.   
advance sol ref: https://leetcode.com/discuss/64309/clean-kmp-solution-with-super-detailed-explanation   
```
public String shortestPalindrome(String s) {
    int n=s.length(), j=0;
    for(int i=n-1; i>=0; i--) {
        if(s.charAt(i)==s.charAt(j)) {
            j++;
        }
    }
    if(j==n) {
        return s;
    }
    String suffix = s.substring(j);
    return new StringBuilder(suffix).reverse().toString()+shortestPalindrome(s.substring(0, j))+suffix;
}
```
