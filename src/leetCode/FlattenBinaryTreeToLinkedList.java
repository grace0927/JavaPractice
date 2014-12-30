/**
 * 
 */
package leetCode;

/**
 * @author jianyu
 * https://oj.leetcode.com/problems/flatten-binary-tree-to-linked-list/
 * Given a binary tree, flatten it to a linked list in-place.
 * For example,
 * Given
 *          1
 *         / \
 *        2   5
 *       / \   \
 *      3   4   6
 * The flattened tree should look like:
 *    1
 *     \
 *      2
 *       \
 *        3
 *         \
 *          4
 *           \
 *            5
 *             \
 *              6
 * Hints:
 * If you notice carefully in the flattened tree, 
 * each node's right child points to the next node of a pre-order traversal.
 *
 */
public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
		if(root == null) {
			return ;
		}
        flattenUtil(root);
    }
	
	public TreeNode flattenUtil(TreeNode root) {
		if(root.left == null && root.right == null) {
			return root;
		} else if(root.left != null && root.right == null) {
			TreeNode left = flattenUtil(root.left);
			root.right = root.left;
			root.left = null;
			return left;
		} else if(root.left == null && root.right != null) {
			TreeNode right = flattenUtil(root.right);
			return right;
		} else {
			TreeNode left = flattenUtil(root.left);
			TreeNode right = flattenUtil(root.right);
			left.right = root.right;
			root.right = root.left;
			root.left = null;
			return right;
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FlattenBinaryTreeToLinkedList test = new FlattenBinaryTreeToLinkedList();
		TreeNode root = new TreeNode(1);
		TreeNode right = new TreeNode(2);
		root.right = right;
		test.flatten(root);
		System.out.println(root);

	}

}
