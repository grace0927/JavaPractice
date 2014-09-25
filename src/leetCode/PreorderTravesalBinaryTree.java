/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package leetCode;

import java.util.ArrayList;

/**
 *
 * @author jianyu
 */
public class PreorderTravesalBinaryTree {
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList res = new ArrayList();
        if(root == null) {
        } else if(root.left == null && root.right != null) {
            res.add(root.val);
            res.addAll(preorderTraversal(root.right));
        } else if(root.left != null && root.right == null) {
            res.add(root.val);
            res.addAll(preorderTraversal(root.left));
        } else if(root.left == null && root.right == null) {
            res.add(root.val);
        } else {
            res.add(root.val);
            res.addAll(preorderTraversal(root.left));
            res.addAll(preorderTraversal(root.right));
        }
        return res;
    }
}
