/**
 * 
 */
package com.javapractice.Algorithm;

/**
 * @author jianyu
 *
 */
public class InsertionSort implements Sort {
	public void sort(int[] arr) {
		for(int i=1; i<arr.length; i++) {
			int key = arr[i]; // get current key
			int j;
			for(j=i; j>0; j--) {
				if(key > arr[j-1]) {
					break;
				} else {
					arr[j] = arr[j-1];
				}
			}
			arr[j] = key;
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Sort test = new InsertionSort();
		int[] arr = {5, 2, 4, 6, 1, 3};
		test.sort(arr);
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]);
			System.out.print(" ");
		}
	}

}
