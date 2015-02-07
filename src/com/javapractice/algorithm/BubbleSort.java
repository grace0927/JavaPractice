package com.javapractice.algorithm;

/**
 * @author jianyu
 *
 */
public class BubbleSort implements Sort {

	public void sort(int[] arr) {
		if(arr == null) {
			return;
		}
		int size = arr.length;
		for(int i=0; i<size-1; i++) {
			for(int j=size-1; j>i; j--) {
				int key = arr[j];
				if(key < arr[i]) {
					arr[j] = arr[i];
					arr[i] = key;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Sort test = new BubbleSort();
		int[] arr = {5, 2, 4, 6, 1, 3};
		test.sort(arr);
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]);
			System.out.print(" ");
		}

	}

}
