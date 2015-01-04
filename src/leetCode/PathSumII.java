/**
 * 
 */
package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author feng
 * https://oj.leetcode.com/problems/path-sum-ii/
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * For example:
 * Given the below binary tree and sum = 22,
 *            5
 *           / \
 *          4   8
 *         /   / \
 *        11  13  4
 *       /  \      \
 *      7    2      1
 * return
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 *
 */
public class PathSumII {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        pathSumUtil(result, row, root, sum);
        return result;
    }
    
    public void pathSumUtil(List<List<Integer>> result, List<Integer> row, TreeNode root, int sum) {
        if(root == null) {
            return ;
        }
        
        Integer cur = root.val;
        int left = sum - cur;
        row.add(cur);
        System.out.println(row);
        if(left == 0) {
            if(root.left == null && root.right == null) {
                List<Integer> temp = new ArrayList<>(row);
                result.add(temp);
            } else {
                pathSumUtil(result, row, root.left, left);
                pathSumUtil(result, row, root.right, left);
            }
            row.remove(row.size()-1);
            return ;
        } else {
            pathSumUtil(result, row, root.left, left);
            pathSumUtil(result, row, root.right, left);
            row.remove(row.size()-1);
        }
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PathSumII test = new PathSumII();
		TreeNode one = new TreeNode(1);
		TreeNode two = new TreeNode(-2);
		TreeNode thr = new TreeNode(-3);
		TreeNode fou = new TreeNode(1);
		TreeNode fiv = new TreeNode(3);
		TreeNode six = new TreeNode(-2);
		TreeNode sev = new TreeNode(-1);
		one.left = two;
		one.right = thr;
		two.left = fou;
		two.right = fiv;
		thr.left = six;
		fou.left = sev;
		int target = -1;
		System.out.println(test.pathSum(one, target));

	}

}
