/**
 * 
 */
package leetCode;

/**
 * @author jianyu
 * https://oj.leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
 * Follow up for "Remove Duplicates":
 * What if duplicates are allowed at most twice?
 * For example,
 * Given sorted array A = [1,1,1,2,2,3],
 * Your function should return length = 5, and A is now [1,1,2,2,3].
 * reference: https://oj.leetcode.com/discuss/2754/is-it-possible-to-solve-this-question-in-place
 *
 */
public class RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] A) {
    	// special case
        if (A.length <= 2) return A.length;
        
        int slow = 2;
        int fast = 2;
        while (fast < A.length) {
            if (A[fast] > A[slow-2]) { 
                A[slow] = A[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RemoveDuplicatesFromSortedArrayII test = new RemoveDuplicatesFromSortedArrayII();
		int[] A = {1, 1, 1, 1, 1, 2, 2, 2};
		int res = test.removeDuplicates(A);
		System.out.println(res);
		for(int i=0; i<A.length; i++) {
			System.out.println(A[i]);
		}
	}

}
