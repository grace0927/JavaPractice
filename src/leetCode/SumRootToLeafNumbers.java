/**
 * 
 */
package leetCode;

import java.util.ArrayList;

/**
 * @author feng
 * https://oj.leetcode.com/problems/sum-root-to-leaf-numbers/
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * Find the total sum of all root-to-leaf numbers.
 * For example,
 *     1
 *    / \
 *   2   3
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * Return the sum = 12 + 13 = 25.
 *
 */
public class SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        int sum = 0;
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Integer> row = new ArrayList<>();
        
        sumNumbersUtil(root, row, result);
        System.out.println(result);
        
        for(int i=0; i<result.size(); i++) {
            sum += result.get(i);
        }
        return sum;
    }
    
    public void sumNumbersUtil(TreeNode root, ArrayList<Integer> row, ArrayList<Integer> result) {
        if(root.left == null && root.right == null) {
            int sum = 0;
            row.add(root.val);
            System.out.println(row);
            for(int i=0; i<row.size(); i++) {
                sum += row.get(i) * Math.pow(10, row.size()-i-1);
            }
            row.remove(row.size()-1);
            result.add(sum);
            return ;
        }
        
        row.add(root.val);
        if(root.left != null) {
        	System.out.println(row);
            sumNumbersUtil(root.left, row, result);
            System.out.println(row);
        }
        if(root.right != null) {
        	System.out.println(row);
            sumNumbersUtil(root.right, row, result);
            System.out.println(row);
        }
        row.remove(row.size()-1);
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode root = new TreeNode(9);
		TreeNode one = new TreeNode(0);
		TreeNode two = new TreeNode(3);
		TreeNode three = new TreeNode(2);
		TreeNode four = new TreeNode(3);
		TreeNode five = new TreeNode(4);
		TreeNode six = new TreeNode(7);
		root.left = one;
		root.right = two;
		two.left = three;
		three.left = four;
		three.right = five;
		five.right = six;
		
		SumRootToLeafNumbers test = new SumRootToLeafNumbers();
		System.out.println(test.sumNumbers(root));
		
	}

}