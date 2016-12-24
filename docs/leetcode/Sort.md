# Sort

1. [Insertion Sort List](#insertion-sort-list)
2. [Largest Number](#largest-number)
3. [Wiggle Sort II](#wiggle-sort-ii)
4. [Maximum Gap](#maximum-gap)


##Insertion Sort List
Q: Sort a linked list using insertion sort.   
```
public ListNode insertionSortList(ListNode head) {
    if(head==null) {
        return null;
    }
    ListNode pnt=head.next;
    head.next=null;
    while(pnt!=null) {
        ListNode tmp = pnt.next;
        pnt.next = null;
        if(pnt.val<head.val) {
            pnt.next = head;
            head = pnt;
        } else {
            ListNode tp=head, pre=tp;
            while(tp!=null && pnt.val>=tp.val) {
                pre = tp;
                tp = tp.next;
            }
            pre.next = pnt;
            pnt.next = tp;
        }
        pnt = tmp;
    }
    return head;
}
```

## Largest Number
Q: Given a list of non negative integers, arrange them such that they form the largest number. For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330. Note: The result may be very large, so you need to return a string instead of an integer.   
```
public String largestNumber(int[] nums) {
    Integer[] arr = new Integer[nums.length];
    for(int i=0; i<nums.length; i++) {
        arr[i] = nums[i];
    }
    Arrays.sort(arr, new Comparator<Integer>() {
        public int compare(Integer a, Integer b) {
            String as = Integer.toString(a);
            String bs = Integer.toString(b);
            return (as+bs).compareTo(bs+as);
        }
    });
    StringBuilder sb = new StringBuilder();
    for(int i=0; i<arr.length; i++) {
        sb.insert(0, arr[i]);
    }
    return (sb.charAt(0)=='0')?"0":sb.toString();
}
```

##Wiggle Sort II
Q: Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3].... Note: You may assume all input has valid answer. Follow Up: Can you do it in O(n) time and/or in-place with O(1) extra space?   
better sol ref: https://leetcode.com/discuss/77115/o-n-time-o-1-space-solution-with-detail-explanations   
```
public void wiggleSort(int[] nums) {
    PriorityQueue<Integer> heap = new PriorityQueue<>();
    for(int i=0; i<nums.length; i++) {
        heap.offer(nums[i]);
    }
    int end = (nums.length%2==0)?nums.length-2:nums.length-1;
    for(int i=end; i>=0; i-=2) {
        nums[i] = heap.poll();
    }
    end = (nums.length%2==0)?nums.length-1:nums.length-2;
    for(int i=end; i>=0; i-=2) {
        nums[i] = heap.poll();
    }
}
// better implement
public void wiggleSort(int[] nums) {
    Arrays.sort(nums);
    int[] copy = Arrays.copyOf(nums, nums.length);
    int smallEndIndex = (nums.length+1)/2-1;
    int largeEndIndex = nums.length-1;
    for (int i=0;i<nums.length;i++)
        nums[i] = i%2==0?copy[smallEndIndex-i/2]:copy[largeEndIndex-i/2];
}
```

##Maximum Gap
Q: Given an unsorted array, find the maximum difference between the successive elements in its sorted form. Try to solve it in linear time/space. Return 0 if the array contains less than 2 elements. You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.   
```
// bucket sort
public int maximumGap(int[] nums) {
    if(nums.length<2) {
        return 0;
    }
    int min=Integer.MAX_VALUE, max=Integer.MIN_VALUE, n=nums.length;
    for(int i=0; i<n; i++) {
        min = Math.min(min, nums[i]);
        max = Math.max(max, nums[i]);
    }
    
    int len = max-min;
    int size = len/n+1;
    int[][] bucket = new int[n][2];
    
    for(int i=0; i<n; i++) {
        int idx = (nums[i]-min)/size;
        if(bucket[idx][0]==0 || bucket[idx][0]>nums[i]) {
            bucket[idx][1] = (bucket[idx][1]==0)?bucket[idx][0]:bucket[idx][1];
            bucket[idx][0] = nums[i];
        } else if(bucket[idx][1]==0 || bucket[idx][1]<nums[i]) {
            bucket[idx][1] = nums[i];
        }
    }
    
    int last=min, gap=0;
    for(int i=0; i<n; i++) {
        gap = Math.max(gap, bucket[i][0]-last);
        last = Math.max(last, bucket[i][0]);
        gap = Math.max(gap, bucket[i][1]-last);
        last = Math.max(last, bucket[i][1]);
    }
    
    return gap;
}
// radix sort ref: https://leetcode.com/discuss/18487/i-solved-it-using-radix-sort
```




