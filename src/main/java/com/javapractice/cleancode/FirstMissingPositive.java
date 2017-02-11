/**
 * 
 */
package com.javapractice.cleancode;

/**
 * @author feng
 *
 */
public class FirstMissingPositive implements Solution {
	public void run() {
	}
	
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
}
