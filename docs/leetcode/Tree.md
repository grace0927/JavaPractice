# Tree

1. [Binary Tree Inorder Traversal](#binary-tree-inorder-traversal)
2. [Binary Tree Preorder Traversal](#binary-tree-preorder-traversal)
3. [Binary Tree Postorder Traversal](#binary-tree-postorder-traversal)
4. [Count Complete Tree Nodes](#count-complete-tree-nodes)
5. [Invert Binary Tree](#invert-binary-tree)
6. [Kth Smallest Element in a BST](#kth-smallest-element-in-a-bst)
7. [Lowest Common Ancestor of a Binary Search Tree](#lowest-common-ancestor-of-a-binary-search-tree)
8. [Serialize and Deserialize Binary Tree](#serialize-and-deserialize-binary-tree)
9. [Lowest Common Ancestor of a Binary Tree](#lowest-common-ancestor-of-a-binary-tree)
10. [Count of Smaller Numbers After Self](#count-of-smaller-numbers-after-self)

## Binary Tree Inorder Traversal
Q: Given a binary tree, return the inorder traversal of its nodes' values. Note: Recursive solution is trivial, could you do it iteratively?   
```
// recursive
public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    
    if(root!=null) {
        if(root.left!=null) {
            list.addAll(inorderTraversal(root.left));
        }
        list.add(root.val);
        if(root.right!=null) {
            list.addAll(inorderTraversal(root.right));
        }
    }
    
    return list;
}
// iteratively
public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> list = new LinkedList<>();
    HashSet<TreeNode> set = new HashSet<>();
    LinkedList<TreeNode> stack = new LinkedList<>();
    
    if(root!=null) {
        stack.add(root);
        while(!stack.isEmpty()) {
            while(!set.contains(stack.peekLast()) && stack.peekLast().left!=null) {
                set.add(stack.peekLast());
                stack.add(stack.peekLast().left);
            }
            TreeNode tmp = stack.pollLast();
            list.add(tmp.val);
            if(tmp.right!=null) {
                stack.add(tmp.right);
            }
        }
    }
    
    return list;
}
```

##Binary Tree Preorder Traversal
Q: Given a binary tree, return the preorder traversal of its nodes' values.   
```
public List<Integer> preorderTraversal(TreeNode root) {
    LinkedList<TreeNode> stack = new LinkedList<>();
    List<Integer> trvl = new ArrayList<>();
    if(root!=null) {
        stack.add(root);
    }
    while(!stack.isEmpty()) {
        TreeNode tmp = stack.pollLast();
        if(tmp.right!=null) {
            stack.add(tmp.right);
        }
        if(tmp.left!=null) {
            stack.add(tmp.left);
        }
        trvl.add(tmp.val);
    }
    return trvl;
}
```

##Binary Tree Postorder Traversal
Q: Given a binary tree, return the postorder traversal of its nodes' values.   
```
public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> trvl = new ArrayList<>();
    LinkedList<TreeNode> stack = new LinkedList<>();
    if(root!=null) {
        stack.add(root);
    }
    while(!stack.isEmpty()) {
        TreeNode tmp = stack.pollLast();
        if(tmp.left!=null) {
            stack.add(tmp.left);
        }
        if(tmp.right!=null) {
            stack.add(tmp.right);
        }
        trvl.add(0, tmp.val);
    }
    return trvl;
}
```

##Count Complete Tree Nodes
Q: Given a complete binary tree, count the number of nodes. Definition of a complete binary tree from Wikipedia: In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.   
```
public int countNodes(TreeNode root) {
    int res=0,h=0;
    int left = height(root);
    while(left>0) {
        left--;
        int right = height(root.right);
        h++;
        root = (left==right)?root.right:root.left;
        int cnt = (left>0)?(1<<(left-1)):0;
        res += (left==right)?(cnt):0;
    }
    return (h==0)?0:res+sum(h-1)+1;
}

public int height(TreeNode root) {
    int h=0;
    while(root!=null) {
        h++;
        root = root.left;
    }
    return h;
}

public int sum(int height) {
    return (1<<height)-1;
}
```

## Invert Binary Tree
Q: Invert a binary tree.   
```
public TreeNode invertTree(TreeNode root) {
    if(root!=null) {
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
    }
    return root;
}
```

## Kth Smallest Element in a BST
Q: Given a binary search tree, write a function kthSmallest to find the kth smallest element in it. Note: You may assume k is always valid, 1 ≤ k ≤ BST's total elements. Follow up: What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?   
better solution ref: http://www.geeksforgeeks.org/find-k-th-smallest-element-in-bst-order-statistics-in-bst/   
```
public int kthSmallest(TreeNode root, int k) {
    List<Integer> list = new ArrayList<>();
    preorder(root, list);
    return list.get(k-1);
}
private void preorder(TreeNode root, List<Integer> list) {
    if(root==null) {
        return ;
    }
    preorder(root.left, list);
    list.add(root.val);
    preorder(root.right, list);
}
```

##Lowest Common Ancestor of a Binary Search Tree
Q: Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST. According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”   
```
public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    while((p.val>root.val && q.val>root.val) || (p.val<root.val && q.val<root.val)) {
        root = (p.val>root.val && q.val>root.val)?root.right:root.left;
    }
    return root;
}
```

##Serialize and Deserialize Binary Tree
Q: Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment. Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.   
```
// Encodes a tree to a single string.
public String serialize(TreeNode root) {
    StringBuilder sb = new StringBuilder();
    LinkedList<TreeNode> list = new LinkedList<>();
    list.add(root);
    while(!list.isEmpty()) {
        TreeNode node = list.poll();
        if(node!=null) {
            list.add(node.left);
            list.add(node.right);
            sb.append(node.val);
            sb.append(",");
        } else {
            sb.append("null");
            sb.append(",");
        }
    }
    sb.deleteCharAt(sb.length()-1);
    return sb.toString();
}

// Decodes your encoded data to tree.
public TreeNode deserialize(String data) {
    String[] s = data.split(",");
    TreeNode root = (s[0].equals("null"))?null:new TreeNode(Integer.parseInt(s[0]));
    LinkedList<TreeNode> list = new LinkedList<>();
    list.add(root);
    for(int i=1; i<s.length-1; i++) {
        TreeNode left = (s[i].equals("null"))?null:new TreeNode(Integer.parseInt(s[i]));
        TreeNode right = (s[i+1].equals("null"))?null:new TreeNode(Integer.parseInt(s[i+1]));
        i++;
        TreeNode node = list.poll();
        node.left = left;
        node.right = right;
        if(left!=null) {
            list.add(left);
        }
        if(right!=null) {
            list.add(right);
        }
    }
    return root;
}
```

##Lowest Common Ancestor of a Binary Tree
Q: Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree. According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”   
```
public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if(p==root || q==root) {
        return root;
    }
    boolean pLeft = find(root.left, p);
    boolean qLeft = find(root.left, q);
    if(pLeft && qLeft) {
        return lowestCommonAncestor(root.left, p, q);
    } else if(!pLeft && !qLeft) {
        return lowestCommonAncestor(root.right, p, q);
    }
    return root;
}
private boolean find(TreeNode root, TreeNode p) {
    if(root==null) {
        return false;
    }
    if(p==root) {
        return true;
    }
    return find(root.left, p) || find(root.right, p);
}
```

##Count of Smaller Numbers After Self
Q: You are given an integer array nums and you have to return a new counts array. The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].   
good ref: http://bookshadow.com/weblog/2015/12/06/leetcode-count-of-smaller-numbers-after-self/    
```
public class Solution {
    class Node {
        int val;
        int cnt;
        Node left;
        Node right;
        public Node(int val) {
            this.val = val;
            this.cnt = 0;
            this.left = null;
            this.right = null;
        }
    }
    
    private Node root = null;
    
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int i=nums.length-1; i>=0; i--) {
            Node node = new Node(nums[i]);
            if(root==null) {
                root = node;
                list.add(0);
            } else {
                list.add(0, add(root, node));
            }
        }
        return list;
    }
    
    private int add(Node root, Node node) {
        if(node.val>root.val) {
            if(root.right==null) {
                root.right = node;
                return root.cnt+1;
            } else {
                return add(root.right, node)+root.cnt+1;
            }
        } else if(node.val<root.val) {
            root.cnt++;
            if(root.left==null) {
                root.left = node;
                return 0;
            } else {
                return add(root.left, node);
            }
        } else {
            if(root.right==null) {
                root.right = node;
                return root.cnt;
            } else {
                return add(root.right, node)+root.cnt;
            }
        }
    }
}
```









