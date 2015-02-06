/**
 * 
 */
package com.javapractice.Algorithm;

/**
 * @author feng
 *
 */
public class MergeSort implements Sort {
	public void sort(int[] arr) {
		// special case 
		if(arr == null) {
			return;
		} else if(arr.length == 1) {
			return;
		}
		
		// initialize parameters
		int size = arr.length;
		int sizeLeft = size/2;
		int sizeRight = size - sizeLeft;
		int[] arrLeft = new int[sizeLeft];
		int[] arrRight = new int[sizeRight];
		
		// divide and initialize subsequences
		for(int i=0; i<sizeLeft; i++) {
			arrLeft[i] = arr[i];
		}
		for(int j=0; j<sizeRight; j++) {
			arrRight[j] = arr[j+sizeLeft];
		}
		
		// conquer subsequences
		sort(arrLeft);
		sort(arrRight);
		
		// combine conquered subsequences
		int i=0;
		int j=0;
		for(int k=0; k<size; k++) {
			if(i == sizeLeft) {
				arr[k] = arrRight[j];
				j++;
				continue;
			}
			if(j == sizeRight) {
				arr[k] = arrLeft[i];
				i++;
				continue;
			}
			if(arrLeft[i] <= arrRight[j]) {
				arr[k] = arrLeft[i];
				i++;
			} else {
				arr[k] = arrRight[j];
				j++;
			}
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Sort test = new MergeSort();
		int[] arr = {5, 2, 4, 6, 1, 3};
		test.sort(arr);
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]);
			System.out.print(" ");
		}
	}

}
