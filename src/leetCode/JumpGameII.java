/**
 * 
 */
package leetCode;

/**
 * @author jianyu
 * https://oj.leetcode.com/problems/jump-game-ii/
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Your goal is to reach the last index in the minimum number of jumps.
 * For example:
 * Given array A = [2,3,1,1,4]
 * The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 * reference: http://www.cnblogs.com/lichen782/p/leetcode_Jump_Game_II.html
 * https://oj.leetcode.com/discuss/422/is-there-better-solution-for-jump-game-ii
 *
 */
public class JumpGameII {
	public int jump(int[] A) {
        int len = A.length;
		if(len <= 1) {
			return 0;
		}
		
		int ret = 0; // count
		int last = 0; // maximum index using ret steps
		int cur = 0; // maximum index current can jump to
		
		for(int i=0; i<len; i++) {
			if(i > last) {
				if(cur == last) {
					return -1;
				}
				last = cur;
				ret++;
			}
			cur = Math.max(cur, i+A[i]);
		}
		
		return ret;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
