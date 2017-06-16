/**
 *
 */
package com.javapractice.leetcode;

/**
 * @author Jianyu Feng
 * https://leetcode.com/problems/third-maximum-number/
 * Given a non-empty array of integers, return the third maximum number in this array.
 * If it does not exist, return the maximum number. The time complexity must be in O(n).
 * Example 1:
 * Input: [3, 2, 1]
 * Output: 1
 * Explanation: The third maximum is 1.
 * Example 2:
 * Input: [1, 2]
 * Output: 2
 * Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
 * Example 3:
 * Input: [2, 2, 3, 1]
 * Output: 1
 * Explanation: Note that the third maximum here means the third maximum distinct number.
 * Both numbers with value 2 are both considered as second maximum.
 *
 */
public class ThirdMaximumNumber {
	public int thirdMax(int[] nums) {
		HashSet<Integer> set = new HashSet<>();
		PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
			public int compare(Integer a, Integer b) {
				return b.compareTo(a);
			}
		});
		for (int i:nums) {
			if (!set.contains(i)) {
				set.add(i);
				heap.add(i);
			}
		}

		return heap.size()<3 ? top(heap) : third(heap);
	}

	protected int top(PriorityQueue<Integer> heap) {
		return heap.isEmpty() ? 0 : heap.poll();
	}

	protected int third(PriorityQueue<Integer> heap) {
		for (int i=0; i<2; i++) {
			heap.poll();
		}

		return heap.peek();
	}

	public int thirdMaxOn(int[] nums) {
		if (nums.length<2) {
			return nums.length==0 ? 0 : nums[0];
		}
		if (nums.length<3) {
			return Math.max(nums[0], nums[1]);
		}

		HashSet<Integer> set = new HashSet<>();
		int first=Integer.MIN_VALUE, second=Integer.MIN_VALUE, third=Integer.MIN_VALUE;
		for (int i:nums) {
			if (!set.contains(i)) {
				set.add(i);
			}

			if (i>first) {
				third = second;
				second = first;
				first = i;
			} else if (i>second && i!=first) {
				third = second;
				second = i;
			} else if (i>third && i!=first && i!=second) {
				third = i;
			}
		}

		return set.size()>2 ? third : first;
	}
}
