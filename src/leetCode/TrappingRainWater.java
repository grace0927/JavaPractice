/**
 * 
 */
package leetCode;

import java.util.ArrayList;

/**
 * @author jianyu
 * https://oj.leetcode.com/problems/trapping-rain-water/
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, 
 * compute how much water it is able to trap after raining.
 * For example, 
 * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 *
 */
public class TrappingRainWater {
    public int trap(int[] A) {
        int sum = 0;
		ArrayList<Integer> row = new ArrayList<>();
		boolean start = false;
		boolean end = false;
		int stand = 0;
		
		if(A.length < 3) {
			return 0;
		}
		
		for(int i=1; i<A.length; i++) {
			if(start) {
				if(A[i] >= A[stand]) {
					end = true;
					start = false;
				}
				row.add(A[i]);
			} else {
				if(A[i] < A[i-1]) {
					start = true;
					stand = i-1;
					row.add(A[i-1]);
					row.add(A[i]);
				}
			}
			if(end) {
				sum += trapUtil(row.toArray(new Integer[row.size()]));
				row.clear();
				end = false;
			}
		}
		
		int newStand = stand;
		if(start && !end) {
			row.clear();
			start = false;
			for(int i=A.length-2; i>=newStand; i--) {
				if(start) {
					if(A[i] >= A[stand]) {
						end = true;
						start = false;
					}
					row.add(A[i]);
				} else {
					if(A[i] < A[i+1]) {
						start = true;
						stand = i+1;
						row.add(A[i+1]);
						row.add(A[i]);
					}
				}
				if(end) {
					sum += trapUtil(row.toArray(new Integer[row.size()]));
					row.clear();
					end = false;
				}
			}
		}
		
		return sum;
    }
	
	public int trapUtil(Integer[] row) {
		int high = (row[0] < row[row.length-1])?row[0]:row[row.length-1];
		int sum = 0;
		
		for(int i=1; i<row.length-1; i++) {
			sum += (high - row[i]);
		}
		
		return sum;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TrappingRainWater test = new TrappingRainWater();
		int[] A = new int[] {4,2,0,3,2,4,3,4};
		System.out.println(test.trap(A));
	}

}
