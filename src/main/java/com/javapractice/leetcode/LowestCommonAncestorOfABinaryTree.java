/**
 * 
 */
package com.javapractice.leetcode;

import java.util.Stack;

/**
 * @author feng
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 * According to the definition of LCA on Wikipedia: ��The lowest common ancestor is defined between 
 * two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).��
 *         _______3______
 *        /              \
 *     ___5__          ___1__
 *    /      \        /      \
 *    6      _2       0       8
 *          /  \
 *          7   4
 * For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. Another example is LCA of nodes 5 and 4 is 5, 
 * since a node can be a descendant of itself according to the LCA definition.
 *
 */
public class LowestCommonAncestorOfABinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> ansP = lowestCommonAncestorUtil(root, p);
        Stack<TreeNode> ansQ = lowestCommonAncestorUtil(root, q);
        
        while(!ansP.isEmpty() && !ansQ.isEmpty() && ansP.peek()==ansQ.peek()) {
            root = ansP.pop();
            ansQ.pop();
        }
        
        return root;
    }
    
    public Stack<TreeNode> lowestCommonAncestorUtil(TreeNode root, TreeNode p) {
        Stack<TreeNode> ans = new Stack<>();
        Stack<Integer> visit = new Stack<>();
        
        ans.push(root);
        visit.push(0);
        while(ans.peek()!=p) {
            switch(visit.peek()) {
                case 0:
                    visit.pop();
                    if(ans.peek().left!=null) {
                        visit.push(1);
                        ans.push(ans.peek().left);
                        visit.push(0);
                    } else if(ans.peek().right!=null) {
                        visit.push(2);
                        ans.push(ans.peek().right);
                        visit.push(0);
                    } else {
                        ans.pop();
                    }
                    break;
                case 1:
                    visit.pop();
                    if(ans.peek().right!=null) {
                        visit.push(2);
                        ans.push(ans.peek().right);
                        visit.push(0);
                    } else {
                        ans.pop();
                    }
                    break;
                case 2:
                    visit.pop();
                    ans.pop();
                    break;
            }
        }
        
        Stack<TreeNode> res = new Stack<>();
        while(!ans.isEmpty()) {
            res.push(ans.pop());
        }
        
        return res;
    }
}
