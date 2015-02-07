/**
 * 
 */
package com.javapractice.algorithm;

/**
 * @author feng
 *
 */
public class BinarySearch implements Search {

	// valid only when arr is sorted
	public int binarySearch(int[] arr, int start, int end, int num) throws Exception {
		if(arr == null || start > end || start > arr.length || end > arr.length) {
			throw new Exception("Empty array or Out of bound");
		}
		
		// check if arr is sorted
		for(int i=start+1; i<end; i++) {
			if(arr[i] < arr[i-1]) {
				System.out.println("array from " + start + " to " + end + " not sorted array");
				throw new Exception("Unsorted array given");
			}
		}

		// binary search
		if(num < arr[start]) {
			return start-1;
		}
		if(num > arr[end]) {
			return end;
		}
		if(end - start <= 1) {
			return start;
		} else {
			int mid = (start + end)/2;
			if(arr[mid] < num) {
				return binarySearch(arr, mid, end, num);
			} else {
				return binarySearch(arr, start, mid, num);
			}
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinarySearch test = new BinarySearch();
		int[] arr = {2, 4, 5, 6, 8, 9};
		try{
			int res = test.binarySearch(arr, 0, 5, 7);
			System.out.print(res);
		} catch(Exception e) {
			System.out.println("Exception thrown  :" + e.getMessage());
		}
	}

}
