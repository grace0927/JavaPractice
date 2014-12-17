/**
 * 
 */
package leetCode;

/**
 * @author jianyu
 * 
 * https://oj.leetcode.com/problems/remove-duplicates-from-sorted-array/
 * Given a sorted array, remove the duplicates in place such that each element appear only once 
 * and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * For example,
 * Given input array A = [1,1,2],
 * Your function should return length = 2, and A is now [1,2].
 *
 */
public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] A) {
        if(A == null) {
            return 0;
        } else if(A.length == 0) {
            return 0;
        } else if(A.length == 1) {
            return 1;
        }
        
        int slowIndex = 1;
        int fastIndex = 1;
        int level = A[0];
        
        while(fastIndex < A.length) {
            if(A[slowIndex] <= level) {
                if(A[fastIndex] <= level) {
                    fastIndex++;
                } else {
                    int temp = A[slowIndex];
                    A[slowIndex] = A[fastIndex];
                    A[fastIndex] = temp;
                    level = A[slowIndex];
                    slowIndex++;
                    fastIndex++;
                }
            } else {
                level = A[slowIndex];
                slowIndex++;
                fastIndex++;
            }
        }
        
        return slowIndex;
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
