# Two Pointer

1. [Container With Most Water](#container-with-most-water)  
2. [3Sum](#3sum)  
3. [3Sum Closest](#3sum-closest)
4. [4Sum](#4sum)
5. [Remove Nth Node From End of List](#remove-nth-node-from-end-of-list)
6. [Remove Duplicates from Sorted Array](#remove-duplicates-from-sorted-array)
7. [Remove Element](#remove-element)
8. [Implement strStr()](#implement-strstr)
9. [Trapping Rain Water](#trapping-rain-water)
10. [Rotate List](#rotate-list)
11. [Sort Colors](#sort-colors)
12. [Remove Duplicates from Sorted Array II](#remove-duplicates-from-sorted-array-ii)
13. [Partition List](#partition-list)
14. [Merge Sorted Array](#merge-sorted-array)
15. [Valid Palindrome](#valid-palindrome)
16. [Linked List Cycle](#linked-list-cycle)
17. [Linked List Cycle II](#linked-list-cycle-ii)
18. [Minimum Size Subarray Sum](#minimum-size-subarray-sum)
19. [Palindrome Linked List](#palindrome-linked-list)
20. [Move Zeroes](#move-zeros)
21. [Find the Duplicate Number](#find-the-duplicate-number)
22. [Odd Even Linked List](#odd-even-linked-list)
23. [Minimum Window Substring](#minimum-window-substring)
24. [Reverse Vowels of a String](#reverse-vowels-of-a-string)

## Container With Most Water   
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

##  3Sum   
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

##  3Sum Closest   
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

##  4Sum   
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

##  Remove Nth Node From End of List   
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

##  Remove Duplicates from Sorted Array   
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

##  Remove Element   
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

##  Implement strStr()   
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

##  Trapping Rain Water   
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

##  Rotate List   
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

##  Sort Colors   
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

##  Remove Duplicates from Sorted Array II   
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

##  Partition List   
Q: Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x. You should preserve the original relative order of the nodes in each of the two partitions. For example, Given 1->4->3->2->5->2 and x = 3, return 1->2->2->4->3->5.
```
public ListNode partition(ListNode head, int x) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode pnt = dummy;
    while(pnt.next!=null && pnt.next.val<x) {
        pnt = pnt.next;
    }
    ListNode fast = pnt.next;
    while(fast!=null && fast.next!=null) {
        if(fast.next.val>=x) {
            fast = fast.next;
        } else {
            ListNode tmp = fast.next;
            fast.next = tmp.next;
            tmp.next = pnt.next;
            pnt.next = tmp;
            pnt = pnt.next;
        }
    }
    return dummy.next;
}
```

##  Merge Sorted Array
Q: Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.   
Note:   
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.   
```
public void merge(int[] nums1, int m, int[] nums2, int n) {
    while(n>0 && m>0) {
        if(nums1[m-1]>nums2[n-1]) {
            nums1[m+n-1] = nums1[m-1];
            m--;
        } else {
            nums1[m+n-1] = nums2[n-1];
            n--;
        }
    }
    while(n>0) {
        nums1[n-1] = nums2[n-1];
        n--;
    }
}
```

##  Valid Palindrome
Q: Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases. Have you consider that the string might be empty? This is a good question to ask during an interview.   
```
public boolean isPalindrome(String s) {
    s = s.toLowerCase();
    int head=0, end=s.length()-1;
    while(head<end) {
        while(head<end && !isValid(s.charAt(head))) {
            head++;
        }
        while(head<end && !isValid(s.charAt(end))) {
            end--;
        }
        if(s.charAt(head)!=s.charAt(end)) {
            return false;
        }
        head++;
        end--;
    }
    return true;
}

private boolean isValid(char a) {
    return (a>='a' && a<='z') || (a>='0' && a<='9');
}
```

##  Linked List Cycle
Q: Given a linked list, determine if it has a cycle in it.   
```
public boolean hasCycle(ListNode head) {
    ListNode fast=head, slow=head;
    while(fast!=null && fast.next!=null) {
        fast = fast.next.next;
        slow = slow.next;
        if(slow==fast) {
            return true;
        }
    }
    return false;
}
```

##  Linked List Cycle II
Q: Given a linked list, return the node where the cycle begins. If there is no cycle, return null.   
```
public ListNode detectCycle(ListNode head) {
    ListNode fast=head, slow=head;
    while(fast!=null && fast.next!=null) {
        fast = fast.next.next;
        slow = slow.next;
        if(fast==slow) {
            slow = head;
            while(slow!=fast) {
                slow = slow.next;
                fast = fast.next;
            }
            return fast;
        }
    }
    return null;
}
```

##  Minimum Size Subarray Sum
Q: Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum ≥ s. If there isn't one, return 0 instead.   
```
// O(n)
public int minSubArrayLen(int s, int[] nums) {
    int sum=0,slow=0,fast=0,min=Integer.MAX_VALUE;
    while(fast<nums.length) {
        sum += nums[fast];
        while(sum>=s) {
            min = Math.min(min, fast-slow+1);
            sum -= nums[slow++];
        }
        fast++;
    }
    return (slow==0)?0:min;
}
// O(nLogn) ref: https://leetcode.com/discuss/35378/solutions-java-with-time-complexity-nlogn-with-explanation
private int solveNLogN(int s, int[] nums) {
    int[] sums = new int[nums.length + 1];
    for (int i = 1; i < sums.length; i++) sums[i] = sums[i - 1] + nums[i - 1];
    int minLen = Integer.MAX_VALUE;
    for (int i = 0; i < sums.length; i++) {
        int end = binarySearch(i + 1, sums.length - 1, sums[i] + s, sums);
        if (end == sums.length) break;
        if (end - i < minLen) minLen = end - i;
    }
    return minLen == Integer.MAX_VALUE ? 0 : minLen;
}
```

## Palindrome Linked List
Q: Given a singly linked list, determine if it is a palindrome. Follow up: Could you do it in O(n) time and O(1) space?   
```
public boolean isPalindrome(ListNode head) {
    ListNode fast=head, slow=head, pre=null;
    while(fast!=null && fast.next!=null) {
        fast = fast.next.next;
        ListNode tmp = slow.next;
        slow.next = pre;
        pre = slow;
        slow = tmp;
    }
    slow = (fast==null)?slow:slow.next;
    fast = pre;
    while(slow!=null) {
        if(fast.val!=slow.val) {
            return false;
        }
        fast = fast.next;
        slow = slow.next;
    }
    return true;
}
```

## Move Zeroes
Q: Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements. You must do this in-place without making a copy of the array. Minimize the total number of operations.   
```
public void moveZeroes(int[] nums) {
    for(int i=0; i<nums.length; i++) {
        int pnt=i;
        while(nums[i]==0 && pnt<nums.length) {
            int tmp = nums[pnt];
            nums[pnt++]=nums[i];
            nums[i] = tmp;
        }
        if(pnt==nums.length) {
            return;
        }
    }
}
```

## Find the Duplicate Number
Q: Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one. Note: You must not modify the array (assume the array is read only). You must use only constant, O(1) extra space. Your runtime complexity should be less than O(n2). There is only one duplicate number in the array, but it could be repeated more than once.   
```
// can further improve to binary search
public int findDuplicate(int[] nums) {
    int n = nums.length-1;
    for(int i=1; i<=n; i++) {
        int cnt=0;
        for(int j=0; j<n+1; j++) {
            if(nums[j]==i) {
                cnt++;
            }
        }
        if(cnt>1) {
            return i;
        }
    }
    return n;        
}
// two pointer
public int findDuplicate(int[] nums) {
    int slow = nums[0];
    int fast = nums[nums[0]];
    while(slow!=fast) {
        slow = nums[slow];
        fast = nums[nums[fast]];
    }
    fast = 0;
    while(slow!=fast) {
        slow = nums[slow];
        fast = nums[fast];
    }
    return slow;
}
```

## Odd Even Linked List
Q: Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes. You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.   
```
public ListNode oddEvenList(ListNode head) {
    if(head==null || head.next==null) {
        return head;
    }
    ListNode odd=head, even=head.next, eHead=even;
    while(even!=null && even.next!=null) {
        ListNode on = odd.next.next;
        ListNode en = even.next.next;
        odd.next = on;
        even.next = en;
        odd = on;
        even = en;
    }
    odd.next = eHead;
    return head;
}
```

## Minimum Window Substring
Q: Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n). Note: If there is no such window in S that covers all characters in T, return the empty string "". If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.   
```
public String minWindow(String s, String t) {
    HashMap<Character, Integer> tc = new HashMap<>();
    for(int i=0; i<t.length(); i++) {
        char tmp = t.charAt(i);
        if(!tc.containsKey(tmp)) {
            tc.put(tmp, 0);
        }
        tc.put(tmp, tc.get(tmp)+1);
    }
    
    String res = "";
    int min=Integer.MAX_VALUE, from=0, len=0;
    
    for(int i=0; i<s.length(); i++) {
        char sc = s.charAt(i);
        if(tc.containsKey(sc)) {
            tc.put(sc, tc.get(sc)-1);
            if(tc.get(sc)>=0) {
                len++;
            }
        }
        while(len==t.length() && from<s.length()) {
            char fc = s.charAt(from);
            if(min>i-from+1) {
                res = s.substring(from, i+1);
                min = i-from+1;
            }
            if(tc.containsKey(fc)) {
                tc.put(fc, tc.get(fc)+1);
                if(tc.get(fc)>0) {
                    len--;
                }
            }
            from++;
        }
    }
    
    return res;
}
```

## Reverse Vowels of a String
Q: Write a function that takes a string as input and reverse only the vowels of a string.   
```
public String reverseVowels(String s) {
    char[] arr = s.toCharArray();
    int start=0, end=arr.length-1;
    while(start<end) {
        while(start<end && !isValid(arr[start])) {
            start++;
        }
        while(start<end && !isValid(arr[end])) {
            end--;
        }
        swap(arr, start++, end--);
    }
    return new String(arr);
}
private boolean isValid(char c) {
    return c=='a'||c=='e'||c=='i'||c=='o'||c=='u'||c=='A'||c=='E'||c=='I'||c=='O'||c=='U';
}
private void swap(char[] arr, int start, int end) {
    char tmp = arr[start];
    arr[start] = arr[end];
    arr[end] = tmp;
}
```





