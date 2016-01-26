/**
 * 
 */
package com.javapractice.datastructure;

/**
 * @author Feng
 *
 */
public class DS {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, 3, 5, 7, 9, 11};
		SegmentTree test = new SegmentTree(arr);
		//test.display();
		System.out.println(test.getSum(1, 3));
		test.update(arr, 1, 10);
		System.out.println(test.getSum(1, 3));
	}

}
