# Array

1. [First Missing Positive](#first-missing-positive)
2. [Rotate Image](#rotate-image)
3. [Spiral Matrix](#spiral-matrix)
4. [Next Permutation](#next-permutation)
5. [Spiral Matrix II](#spiral-matrix-ii)
6. [Merge Intervals](#merge-intervals)
7. [Insert Interval](#insert-interval)
8. [Maximum Subarray](#maximum-subarray)
9. [Plus One](#plus-one)
10. [Set Matrix Zeroes](#set-matrix-zeroes)
11. [Pascal's Triangle](#pascals-triangle)
12. [Pascal's Triangle II](#pascals-triangle-ii)
13. [Majority Element](#majority-element)
14. [Rotate Array](#rotate-array)
15. [Summary Ranges](#summary-ranges)
16. [Product of Array Except Self](#product-of-array-except-self)
17. [Missing Number](#missing-number)
18. [Game of Life](#game-of-life)
19. [Increasing Triplet Subsequence](#increasing-triplet-subsequence)
20. [Majority Element II](#majority-element-ii)

##  First Missing Positive   
Q: Given an unsorted integer array, find the first missing positive integer. For example, Given `[1,2,0]` return `3`, and `[3,4,-1,1]` return `2`. Your algorithm should run in `O(n)` time and uses constant space.     

{% highlight java linenos %}
public int firstMissingPositive( int[] nums ) {
	// sort array first o(n)
	sortArray( nums );

	// find by scan array o(n)
	return scanArray( nums );
}

public void sortArray( int[] nums ) {
	for( int i=0; i<nums.length; i++ ) {
		while( nums[i]!=i+1 && nums[i]<=nums.length && nums[i]>0 && nums[i]!=nums[nums[i]-1] ) {
			swap( nums, i, nums[i]-1 );
		}
	}
}

public int scanArray( int[] nums ) {
	for( int i=0; i<nums.length; i++ ) {
		if( nums[i]!=i+1 ) {
			return i+1;
		}
	}

	return nums.length+1;
}

public void swap( int[] nums, int i, int j ) {
	int tmp = nums[i];
	nums[i] = nums[j];
	nums[j] = tmp;
}
{% endhighlight %}

##  Rotate Image   
Q: You are given an n x n 2D matrix representing an image. Rotate the image by 90 degrees (clockwise).   

{% highlight java linenos %}
public void rotate( int[][] matrix ) {
	int n = matrix.length;
	for( int i=0; i<n/2; i++ ) {
		int boundary = n-i-1;
		for( int j=i; j<boundary; j++ ) {
			int tmp = matrix[i][j];
			matrix[i][j] = matrix[n-j-1][i];
			matrix[n-j-1][i] = matrix[boundary][n-j-1];
			matrix[boundary][n-j-1] = matrix[j][boundary];
			matrix[j][boundary] = tmp;
		}
	}
}
{% endhighlight %}

##  Spiral Matrix   
Q: Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.   

{% highlight java linenos %}
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
{% endhighlight %}

##  Next Permutation   
Q:Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers. If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order). The replacement must be in-place, do not allocate extra memory. Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.   

{% highlight java linenos %}
public void nextPermutation(int[] nums) {
	// find abnormal idx
	int start = findAbnormalIndex( nums );

	// swap abnormal idx when there is one
	if(start>=0) {
		swapAbnormalIndex(nums, start);
	}

	// reverse tail
	reverseArray(nums, start+1, nums.length-1);
}

private int findAbnormalIndex(int[] nums) {
	int pnt = nums.length-2;

	// find abnormal idx
	while(pnt>=0 && nums[pnt]>=nums[pnt+1]) {
		pnt--;
	}

	return pnt;
}

private void swapAbnormalIndex(int[] nums, int idx) {
	pnt = nums.length-1;

	while(nums[start]>=nums[pnt]) {
		pnt--;
	}

	swap(nums, pnt, start);
}

private void reverseArray(int[] nums, int start, int end) {
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
{% endhighlight %}

##  Spiral Matrix II   
Q: Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.   

{% highlight java linenos %}
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
{% endhighlight %}

##  Merge Intervals   
Q: Given a collection of intervals, merge all overlapping intervals.   
good ref: https://leetcode.com/discuss/13953/a-simple-java-solution   

{% highlight java linenos %}
public List<Interval> merge(List<Interval> intervals) {
	// first pass to store interval start point to its furest
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

	// sort start points
	map.keySet().toArray(set);
	Arrays.sort(set);

	// second pass to compare start point with previous end point, and merge
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
{% endhighlight %}

##  Insert Interval   
Q: Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary). You may assume that the intervals were initially sorted according to their start times.   

{% highlight java linenos %}
// use stack to push one by one, merge interval if needed.
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
{% endhighlight %}

##  Maximum Subarray   
Q: Find the contiguous subarray within an array (containing at least one number) which has the largest sum. For example, given the array [−2,1,−3,4,−1,2,1,−5,4], the contiguous subarray [4,−1,2,1] has the largest sum = 6.   

{% highlight java linenos %}
public int maxSubArray(int[] nums) {
	int max = nums[0], sum = nums[0];

	// loop over array to have sub sum. drop the prev sum if it is under zero.
	for(int i=1; i<nums.length; i++) {
		if(sum<0) {
			sum = 0;
		}
		sum += nums[i];
		max = Math.max(max, sum);
	}

	return max;
}
{% endhighlight %}

##  Plus One   
Q: Given a non-negative number represented as an array of digits, plus one to the number. The digits are stored such that the most significant digit is at the head of the list.   

{% highlight java linenos %}
public int[] plusOne(int[] digits) {
	int pnt = digits.length-1;
	// loop from left to right to find the position of valid plus
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
{% endhighlight %}

##  Set Matrix Zeroes   
Q: Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.   

{% highlight java linenos %}
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
{% endhighlight %}

##  Pascal's Triangle
Q: Given numRows, generate the first numRows of Pascal's triangle.   

{% highlight java linenos %}
public List<List<Integer>> generate(int numRows) {
	LinkedList<List<Integer>> lists = new LinkedList<>();
	if(numRows>0) {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		lists.add(list);
		for(int i=2; i<=numRows; i++) {
			ArrayList<Integer> row = new ArrayList<>();
			row.add(1);
			for(int j=0; j<i-2; j++) {
				row.add(lists.peekLast().get(j)+lists.peekLast().get(j+1));
			}
			row.add(1);
			lists.add(row);
		}
	}
	return lists;
}
{% endhighlight %}

##  Pascal's Triangle II
Q: Given an index k, return the kth row of the Pascal's triangle. For example, given k = 3, Return [1,3,3,1]. Note: Could you optimize your algorithm to use only O(k) extra space?   

{% highlight java linenos %}
public List<Integer> getRow(int rowIndex) {
	if(rowIndex<0) {
		return null;
	}
	Integer[] res = new Integer[rowIndex+1];
	res[0] = 1;
	for(int i=1; i<=rowIndex; i++) {
		res[i] = 0;
		for(int j=i; j>0; j--) {
			res[j] += res[j-1];
		}
	}

	return Arrays.asList(res);
}
{% endhighlight %}

##   Majority Element
Q: Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times. You may assume that the array is non-empty and the majority element always exist in the array.
ref for multiple solutions: https://leetcode.com/discuss/42929/6-suggested-solutions-in-c-with-explanations     
{% highlight java linenos %}
public int majorityElement(int[] nums) {
	int n = nums.length;
	Arrays.sort(nums);
	return nums[n/2];
}
{% endhighlight %}

##  Rotate Array
Q: Rotate an array of n elements to the right by k steps.   

{% highlight java linenos %}
// rotate one by one
public void rotate(int[] nums, int k) {
	k %= nums.length;
	int[] res = new int[k];
	for(int i=0; i<k; i++) {
		int n=nums[i], step=k;
		while(i+step<nums.length) {
			int tmp = nums[i+step];
			nums[i+step] = n;
			n = tmp;
			step += k;
		}
		res[(i+step)%nums.length] = n;
	}
	for(int i=0; i<k; i++) {
		nums[i] = res[i];
	}
}

public void rotate(int[] nums, int k) {
	k %= nums.length;
	int[] res = new int[nums.length];
	for(int i=0; i<nums.length; i++) {
		res[(i+k)%nums.length] = nums[i];
	}
	for(int i=0; i<nums.length; i++) {
		nums[i] = res[i];
	}
}
{% endhighlight %}

##   Summary Ranges
Q: Given a sorted integer array without duplicates, return the summary of its ranges.   

{% highlight java linenos %}
public List<String> summaryRanges(int[] nums) {
	List<String> list = new ArrayList<>();
	if(nums.length==0) {
		return list;
	}
	int cur=nums[0], start=nums[0];
	for(int i=1; i<nums.length; i++) {
		if(nums[i]!=cur+1) {
			String s = (start==cur)?""+cur:""+start+"->"+cur;
			list.add(s);
			start = nums[i];
		}
		cur = nums[i];
	}
	String s = (start==cur)?""+cur:""+start+"->"+cur;
	list.add(s);
	return list;
}
{% endhighlight %}

##  Product of Array Except Self
Q: Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i]. Solve it without division and in O(n). For example, given [1,2,3,4], return [24,12,8,6]. Follow up: Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space complexity analysis.)   
```
public int[] productExceptSelf(int[] nums) {
	int[] res = new int[nums.length];
	for(int i=0; i<nums.length; i++) {
		res[i] = (i>0)?res[i-1]*nums[i]:nums[i];
	}
	for(int i=nums.length-2; i>=0; i--) {
		nums[i] *= nums[i+1];
	}
	for(int i=0; i<nums.length; i++) {
		nums[i] = res[i];
		res[i] = (i>0)?(i==nums.length-1)?nums[i-1]:nums[i-1]*nums[i+1]:nums[i+1];
	}
	return res;
}
```

##  Missing Number
Q: Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array. Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?   
```
public int missingNumber(int[] nums) {
	int idx=0;
	while(idx<nums.length) {
		if(idx==nums[idx] || nums[idx]>=nums.length) {
			idx++;
		} else {
			int tmp = nums[nums[idx]];
			nums[nums[idx]] = nums[idx];
			nums[idx] = tmp;
		}
	}
	for(int i=0; i<nums.length; i++) {
		if(i!=nums[i]) {
			return i;
		}
	}
	return nums.length;
}
```

##  Game of Life
Q: According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970." Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article): Any live cell with fewer than two live neighbors dies, as if caused by under-population. Any live cell with two or three live neighbors lives on to the next generation. Any live cell with more than three live neighbors dies, as if by over-population.. Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction. Write a function to compute the next state (after one update) of the board given its current state. Follow up: Could you solve it in-place? Remember that the board needs to be updated at the same time: You cannot update some cells first and then use their updated values to update other cells. In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches the border of the array. How would you address these problems?   
```
public void gameOfLife(int[][] board) {
	for(int i=0; i<board.length; i++) {
		for(int j=0; j<board[0].length; j++) {
			helper(board, i, j);
		}
	}
	for(int i=0; i<board.length; i++) {
		for(int j=0; j<board[0].length; j++) {
			board[i][j] += (board[i][j]>=0)?0:2;
		}
	}
}

private void helper(int[][] board, int row, int col) {
	int cnt = 0;
	for(int i=-1; i<2; i++) {
		for(int j=-1; j<2; j++) {
			if(i==0 && j==0) {
				continue;
			}
			if(row+i>=0 && row+i<board.length
				&& col+j>=0 && col+j<board[0].length
				&& (board[row+i][col+j]==1 || board[row+i][col+j]==-2)) {
				cnt++;
			}
		}
	}
	if(board[row][col]==1 && cnt!=2 && cnt!=3) {
		board[row][col] = -2;
	}
	if(board[row][col]==0 && cnt==3) {
		board[row][col] = -1;
	}
}
```

##  Increasing Triplet Subsequence
Q: Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array. Formally the function should: Return true if there exists i, j, k such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false. Your algorithm should run in O(n) time complexity and O(1) space complexity.   
```
public boolean increasingTriplet(int[] nums) {
	int n=nums.length;
	if(n<=2) {
		return false;
	}

	int min=nums[0], sec=Integer.MAX_VALUE;
	for(int i=1; i<n; i++) {
		if(nums[i]>min && nums[i]>sec) {
			return true;
		} else if(nums[i]<=min) {
			min = nums[i];
		} else if(nums[i]<sec) {
			sec = nums[i];
		}
	}

	return false;
}
```

##  Majority Element II
Q: Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times. The algorithm should run in linear time and in O(1) space.   
good ref: http://www.geeksforgeeks.org/majority-element/   
https://en.wikipedia.org/wiki/Boyer%E2%80%93Moore_majority_vote_algorithm   
```
public List<Integer> majorityElement(int[] nums) {
	List<Integer> res = new ArrayList<>();
	int num1=0, num2=0, cnt1=0, cnt2=0;
	for(int i=0; i<nums.length; i++) {
		if(nums[i]==num1) {
			cnt1++;
		} else if(nums[i]==num2) {
			cnt2++;
		} else if(cnt1==0) {
			num1 = nums[i];
			cnt1++;
		} else if(cnt2==0) {
			num2 = nums[i];
			cnt2++;
		} else {
			cnt1--;
			cnt2--;
		}
	}

	cnt1=0;
	cnt2=0;
	for(int i=0; i<nums.length; i++) {
		if(nums[i]==num1) {
			cnt1++;
		} else if(nums[i]==num2) {
			cnt2++;
		}
	}

	if(cnt1>nums.length/3) {
		res.add(num1);
	}
	if(cnt2>nums.length/3) {
		res.add(num2);
	}

	return res;
}
```
