/**
 * 
 */
package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author jianyu
 * https://oj.leetcode.com/problems/subsets-ii/
 * Given a collection of integers that might contain duplicates, S, return all possible subsets.
 * Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * For example,
 * If S = [1,2,2], a solution is:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 *
 */
public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] num) {
        List<List<Integer>> result = new ArrayList<>();
		List<Integer> row = new ArrayList<>();
		
		Arrays.sort(num);
		subsetsUtil(num, num.length, 0, row, result);
		
		return result;
    }
    
    // backtracking
    public void subsetsUtil(int[] S, int len, int start, List<Integer> row, List<List<Integer>> result) {
        if(row.size() <= len) {
			List<Integer> newOne = new ArrayList<>(row);
			if(!result.contains(newOne)) { // which is reason of slow
				result.add(newOne);
			}
		}
		for(int i=start; i<S.length; i++) {
			Integer key = S[i];
			row.add(key);
			subsetsUtil(S, len, i+1, row, result);
			row.remove(row.size()-1);
		}
    }
    
    // backtracking faster
    public void subsetsFasterUtil(int[] S, int len, int start, List<Integer> row, List<List<Integer>> result) {
        if(row.size() <= len) {
			List<Integer> newOne = new ArrayList<>(row);
			result.add(newOne);
		}
		for(int i=start; i<S.length; i++) {
			Integer key = S[i];
			row.add(key);
			subsetsUtil(S, len, i+1, row, result);
			row.remove(row.size()-1);
			while(i+1<S.length && S[i+1] == S[i]) {
				i++;
			}
		}
    }
    
    // bit manipulation
    public List<List<Integer>> subsetsBitManipulation(int[] S) {
        Arrays.sort(S);
        int totalNumber = 1 << S.length;
        List<List<Integer>> result = new ArrayList<List<Integer>>(totalNumber);
        for (int i=0; i<totalNumber; i++) {
            List<Integer> row = new LinkedList<Integer>();
            for (int j=0; j<S.length; j++) {
                if ((i & (1<<j)) != 0) {
                    row.add(S[j]);
                }
            }
            if(!result.contains(row)) {
            	result.add(row);
            }
        }
        return result;
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
