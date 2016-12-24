# Heap

1. [Sliding Window Maximum](#sliding-window-maximum)
2. [Kth Largest Element in an Array](#kth-largest-element-in-an-array)
3. [Find Median from Data Stream](#find-median-from-data-stream)
4. [The Skyline Problem](#the-skyline-problem)

##  Sliding Window Maximum
Q: Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Note:  You may assume k is always valid, ie: 1 ≤ k ≤ input array's size for non-empty array. Follow up: Could you solve it in linear time?   
Deque solution ref: https://leetcode.com/discuss/46578/java-o-n-solution-using-deque-with-explanation      
```
public int[] maxSlidingWindow(int[] nums, int k) {
    if(k==0) {
        return nums;
    }
    int[] res = new int[nums.length-k+1];
    PriorityQueue<Integer> heap = new PriorityQueue<>(k, Collections.reverseOrder());
    for(int i=0; i<nums.length; i++) {
        if(i>=k) {
            res[i-k] = heap.peek();
            heap.remove(nums[i-k]);
        }
        heap.add(nums[i]);
    }
    res[nums.length-k] = heap.peek();
    return res;
}
```

## Kth Largest Element in an Array
Q: Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element. You may assume k is always valid, 1 ≤ k ≤ array's length.    
quickselect O(n) ref: https://leetcode.com/discuss/36966/solution-explained   
```
// heap
public int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> heap = new PriorityQueue<>(nums.length, Collections.reverseOrder());
    for(int i=0; i<nums.length; i++) {
        heap.add(nums[i]);
    }
    while(k>1) {
        heap.poll();
        k--;
    }
    return heap.poll();
}
// sort
public int findKthLargest(int[] nums, int k) {
    Arrays.sort(nums);
    return nums[nums.length-k];
}
```

## Find Median from Data Stream
Q: Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value. Design a data structure that supports the following two operations: void addNum(int num) - Add a integer number from the data stream to the data structure. double findMedian() - Return the median of all elements so far.   
```
class MedianFinder {

    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(1000, Collections.reverseOrder());
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    int size;

    // Adds a number into the data structure.
    public void addNum(int num) {
        size++;
        if(maxHeap.isEmpty()) {
            maxHeap.offer(num);
        } else {
            if(size%2==0) {
                if(num>maxHeap.peek()) {
                    minHeap.offer(num);
                } else {
                    minHeap.offer(maxHeap.poll());
                    maxHeap.offer(num);
                }
            } else {
                if(num>maxHeap.peek()) {
                    minHeap.offer(num);
                    maxHeap.offer(minHeap.poll());
                } else {
                    maxHeap.offer(num);
                }
            }
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if(size%2==1) {
            return (double)maxHeap.peek();
        }
        return (maxHeap.peek()+minHeap.peek())/2.0;
    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();
```

## The Skyline Problem
Q: A city's skyline is the outer contour of the silhouette formed by all the buildings in that city when viewed from a distance. Now suppose you are given the locations and height of all the buildings as shown on a cityscape photo (Figure A), write a program to output the skyline formed by these buildings collectively (Figure B). The geometric information of each building is represented by a triplet of integers [Li, Ri, Hi], where Li and Ri are the x coordinates of the left and right edge of the ith building, respectively, and Hi is its height. It is guaranteed that 0 ≤ Li, Ri ≤ INT_MAX, 0 < Hi ≤ INT_MAX, and Ri - Li > 0. You may assume all buildings are perfect rectangles grounded on an absolutely flat surface at height 0. For instance, the dimensions of all buildings in Figure A are recorded as: [ [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ] . The output is a list of "key points" (red dots in Figure B) in the format of [ [x1,y1], [x2, y2], [x3, y3], ... ] that uniquely defines a skyline. A key point is the left endpoint of a horizontal line segment. Note that the last key point, where the rightmost building ends, is merely used to mark the termination of the skyline, and always has zero height. Also, the ground in between any two adjacent buildings should be considered part of the skyline contour. For instance, the skyline in Figure B should be represented as:[ [2 10], [3 15], [7 12], [12 0], [15 10], [20 8], [24, 0] ]. Notes: The number of buildings in any input list is guaranteed to be in the range [0, 10000]. The input list is already sorted in ascending order by the left x position Li. The output list must be sorted by the x position. There must be no consecutive horizontal lines of equal height in the output skyline. For instance, [...[2 3], [4 5], [7 5], [11 5], [12 7]...] is not acceptable; the three lines of height 5 should be merged into one in the final output as such: [...[2 3], [4 5], [12 7], ...]   
dc solution: https://leetcode.com/discuss/40963/share-my-divide-and-conquer-java-solution-464-ms   
```
class Point {
    int x, y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public List<int[]> getSkyline(int[][] buildings) {
    int n = buildings.length==0?1:buildings.length;
    List<Point> points = new ArrayList<>();
    for(int i=0; i<buildings.length; i++) {
        points.add(new Point(buildings[i][0], -buildings[i][2]));
        points.add(new Point(buildings[i][1], buildings[i][2]));
    }
    Collections.sort(points, new Comparator<Point>() {
        public int compare(Point a, Point b) {
            return (a.x==b.x)?a.y-b.y:a.x-b.x;
        }
    });
    PriorityQueue<Integer> hi = new PriorityQueue<>(n, Collections.reverseOrder());
    List<int[]> list = new ArrayList<>();
    int y = 0;
    hi.offer(0); // add for last point
    for(Point p:points) {
        if(p.y<0) {
            hi.offer(-p.y);
        } else {
            hi.remove(p.y);
        }
        if(hi.peek()!=y) {
            list.add(new int[]{p.x, hi.peek()});
            y = hi.peek();
        }
    }
    return list;
}

// divide and conquer
public List<int[]> getSkyline(int[][] buildings) {
    if(buildings.length==0) {
        return new ArrayList<int[]>();
    }
    return helper(buildings, 0, buildings.length);
}

public List<int[]> helper(int[][] buildings, int start, int end) {
    if(start<end-1) {
        int mid = start + (end-start)/2;
        return merge(helper(buildings, start, mid), helper(buildings, mid, end));
    }
    List<int[]> res = new ArrayList<>();
    res.add(new int[]{buildings[start][0], buildings[start][2]});
    res.add(new int[]{buildings[start][1], 0});
    return res;
}

public List<int[]> merge(List<int[]> l1, List<int[]> l2) {
    List<int[]> res = new ArrayList<>();
    int h1=0,h2=0;

    while(l1.size()>0 && l2.size()>0) {
        int x1 = l1.get(0)[0];
        int x2 = l2.get(0)[0];
        int h=0,x=0;
        if(x1>x2) {
            h2 = l2.get(0)[1];
            h = Math.max(h1, h2);
            x = x2;
            l2.remove(0);
        } else if(x1<x2) {
            h1 = l1.get(0)[1];
            h = Math.max(h1, h2);
            x = x1;
            l1.remove(0);
        } else {
            h1 = l1.get(0)[1];
            h2 = l2.get(0)[1];
            h = Math.max(h1,h2);
            x = x1;
            l1.remove(0);
            l2.remove(0);
        }
        if(res.size()==0 || res.get(res.size()-1)[1]!=h) {
            res.add(new int[]{x, h});
        }
    }
    res.addAll(l1);
    res.addAll(l2);

    return res;
}
```
