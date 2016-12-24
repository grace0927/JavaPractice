#Binary Search

1. [Divide Two Integers](#divide-two-integers)
2. [Search for a Range](#search-for-a-range)
3. [Search Insert Position](#search-insert-position)
4. [Search in Rotated Sorted Array](#search-in-rotated-sorted-array)
5. [Pow(x, n)](#powx-n)
6. [Sqrt(x)](#sqrtx)
7. [Search a 2D Matrix](#search-a-2d-matrix)
8. [Search in Rotated Sorted Array II](#search-in-rotated-sorted-array-ii)
9. [Find Minimum in Rotated Sorted Array](#find-minimum-in-rotated-sorted-array)
10. [Find Minimum in Rotated Sorted Array II](#find-minimum-in-rotated-sorted-array-ii)
11. [Search a 2D Matrix II](#search-a-2d-matrix-ii)
12. [First Bad Version](#first-bad-version)
13. [H-Index II](#h-index-ii)
14. [Find Peak Element](#find-peak-element)

##Divide Two Integers   
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

##Search for a Range   
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

##Search Insert Position   
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

##Search in Rotated Sorted Array   
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

##Pow(x, n)   
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

#Sqrt(x)   
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

##Search a 2D Matrix   
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

## Search in Rotated Sorted Array II
Q: Follow up for "Search in Rotated Sorted Array": What if duplicates are allowed? Would this affect the run-time complexity? How and why? Write a function to determine if a given target is in the array.   
```
public boolean search(int[] nums, int target) {
    return helper(nums, target, 0, nums.length-1);
}

private boolean helper(int[] nums, int target, int start, int end) {
    if(nums[start]<nums[end]) {
        return binarySearch(nums, target, start, end);
    }
    
    while(start<end-1 && nums[start]>=nums[end]) {
        int pivot = start + (end-start)/2;
        if(nums[pivot]>nums[end]) {
            start = pivot;
        } else if(nums[pivot]<nums[end]) {
            end = pivot;
        } else {
            return helper(nums, target, start, pivot) || helper(nums, target, pivot+1, end);
        }
    }
    
    return binarySearch(nums, target, 0, start) || binarySearch(nums, target, end, nums.length-1);
}

private boolean binarySearch(int[] nums, int target, int start, int end) {
    if(nums[start]>target||nums[end]<target) {
        return false;
    }
    if(nums[start]==target) {
        return true;
    } else if(nums[end]==target) {
        return true;
    }
    while(start<end-1) {
        int mid = start+(end-start)/2;
        if(nums[mid]==target) {
            return true;
        } else if(nums[mid]>target) {
            end = mid;
        } else {
            start = mid;
        }
    }
    return false;
}
```

##Find Minimum in Rotated Sorted Array
Q: Suppose a sorted array is rotated at some pivot unknown to you beforehand. (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2). Find the minimum element.   
```
public int findMin(int[] nums) {
    int n=nums.length, start=0, end=nums.length-1;
    while(start<end-1 && nums[start]>nums[end]) {
        int mid = start+(end-start)/2;
        if(nums[mid]>nums[end]) {
            start = mid;
        } else {
            end = mid;
        }
    }
    return (nums[start]<nums[end])?nums[start]:nums[end];
}
```

##Find Minimum in Rotated Sorted Array II
Q: Suppose a sorted array is rotated at some pivot unknown to you beforehand. (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2). Find the minimum element. The array may contain duplicates.   
```
public int findMin(int[] nums) {
    return helper(nums, 0, nums.length-1);
}

private int helper(int[] nums, int start, int end) {
    int n=nums.length;
    while(start<end-1 && nums[start]>=nums[end]) {
        int mid = start+(end-start)/2;
        if(nums[mid]>nums[end]) {
            start = mid;
        } else if(nums[mid]==nums[end]) {
            return Math.min(helper(nums, start, mid), helper(nums, mid+1, end));
        } else {
            end = mid;
        }
    }
    return (nums[start]<nums[end])?nums[start]:nums[end];
}
```

##Search a 2D Matrix II
Q: Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties: Integers in each row are sorted in ascending from left to right. Integers in each column are sorted in ascending from top to bottom.   
```
public boolean searchMatrix(int[][] matrix, int target) {
    
    for(int i=0; i<matrix.length; i++) {
        int col = matrix[i].length;
        if(target>=matrix[i][0] && target<=matrix[i][col-1] && binarySearch(matrix[i], target)) {
            return true;
        } else if(target<matrix[i][0]) {
            return false;
        }
    }
    return false;
}

private boolean binarySearch(int[] row, int target) {
    int start=0,end=row.length-1;
    if(row[0]==target || row[end]==target) {
        return true;
    }
    while(start<end-1) {
        int mid = start+(end-start)/2;
        if(row[mid]==target) {
            return true;
        } else if(row[mid]>target) {
            end = mid;
        } else {
            start = mid;
        }
    }
    return false;
}
```

##First Bad Version
Q: You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad. Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad. You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.   
```
public int firstBadVersion(int n) {
    int start=0, end=n;
    if(isBadVersion(start)==true) {
        return 0;
    }
    while(start<end-1) {
        int mid = start+(end-start)/2;
        if(isBadVersion(mid)) {
            end = mid;
        } else {
            start = mid;
        }
    }
    return end;
}
```

##H-Index II
Q: Follow up for H-Index: What if the citations array is sorted in ascending order? Could you optimize your algorithm?   
```
public int hIndex(int[] citations) {
    if(citations.length==0) {
        return 0;
    }
    int start=0, end=citations[citations.length-1], n=citations.length;
    int idx=binarySearch(citations, end);
    if(idx<=n-end) {
        return end;
    }
    while(start<end-1) {
        int mid = start+(end-start)/2;
        idx=binarySearch(citations, mid);
        if(idx<=n-mid) {
            start = mid;
        } else {
            end = mid;
        }
    }
    return start;
}

private int binarySearch(int[] arr, int target) {
    int start=0, end=arr.length-1;
    if(target<=arr[start]) {
        return 0;
    }
    if(target>arr[end]) {
        return end+1;
    }
    while(start<end-1) {
        int mid = start+(end-start)/2;
        if(target>arr[mid]) {
            start = mid;
        } else {
            end = mid;
        }
    }
    return end;
}

// logn
public int hIndex(int[] citations) {
    int start = 0;
    int end = citations.length-1;
    
    if(end<0 || citations[end]<1) {
        return 0;
    }
    
    while(start < end) {
        int mid = start + (end-start)/2;
        int h = citations.length-mid;
        if(citations[mid] >= h) {
            end = mid;
        } else {
            start = mid+1;
        }
    }
    
    return citations.length-end;
}
```

##Find Peak Element
Q: A peak element is an element that is greater than its neighbors. Given an input array where num[i] ≠ num[i+1], find a peak element and return its index. The array may contain multiple peaks, in that case return the index to any one of the peaks is fine. You may imagine that num[-1] = num[n] = -∞.   
```
public int findPeakElement(int[] nums) {
    int n=nums.length;
    if(n<=1) {
        return 0;
    }
    int start=0, end=n-1;
    if(nums[start+1]<nums[start]) {
        return start;
    }
    if(nums[end-1]<nums[end]) {
        return end;
    }
    while(start<end-1) {
        int mid = start+(end-start)/2;
        if(nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1]) {
            return mid;
        }
        if(nums[mid]>nums[mid-1]) {
            start = mid;
        } else {
            end = mid;
        }
    }
    return start;
}
```




