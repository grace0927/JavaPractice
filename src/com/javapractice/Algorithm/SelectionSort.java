/**
 * 
 */
package com.javapractice.Algorithm;

/**
 * @author feng
 *
 */
public class SelectionSort implements Sort {
	public void sort(int[] arr) {
		if(arr == null) {
			return;
		}
		int size = arr.length;
		for(int i=0; i<size-1; i++) {
			for(int j=i+1; j<size; j++) {
				int key = arr[j];
				if(arr[i] > key) {
					arr[j] = arr[i];
					arr[i] = key;
				}
			}
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Sort test = new SelectionSort();
		int[] arr = {5, 2, 4, 6, 1, 3};
		test.sort(arr);
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]);
			System.out.print(" ");
		}
	}
}
