# DFS

1. [Same Tree](#same-tree)
2. [Validate Binary Search Tree](#validate-binary-search-tree)
3. [Symmetric Tree](#symmetric-tree)
4. [Construct Binary Tree from Preorder and Inorder Traversal](#construct-binary-tree-from-preorder-and-inorder-traversal)
5. [Construct Binary Tree from Inorder and Postorder Traversal](#construct-binary-tree-from-inorder-and-postorder-traversal)
6. [Convert Sorted Array to Binary Search Tree](#convert-sorted-array-to-binary-search-tree)
7. [Balanced Binary Tree](#balanced-binary-tree)
8. [Convert Sorted List to Binary Search Tree](#convert-sorted-list-to-binary-search-tree)
9. [Minimum Depth of Binary Tree](#minimum-depth-of-binary-tree)
10. [Path Sum](#path-sum)
11. [Path Sum II](#path-sum-ii)
12. [Flatten Binary Tree to Linked List](#flatten-binary-tree-to-linked-list)
13. [Recover Binary Search Tree](#recover-binary-search-tree)
14. [Populating Next Right Pointers in Each Node](#populating-next-right-pointers-in-each-node)
15. [Populating Next Right Pointers in Each Node II](#polulating-next-right-pointers-in-each-node-ii)
16. [Number of Islands](#number-of-islands)
17. [Course Schedule](#course-schedule)
18. [Binary Tree Paths](#binary-tree-paths)
19. [Longest Increasing Path in a Matrix](#longest-increasing-path-in-a-matrix)
20. [House Robber III](#house-robber-iii)
21. [Binary Tree Maximum Path Sum](#binary-tree-maximum-path-sum)

##  Same Tree
Q: Given two binary trees, write a function to check if they are equal or not. Two binary trees are considered equal if they are structurally identical and the nodes have the same value.   
```
public boolean isSameTree(TreeNode p, TreeNode q) {
    if(p==null&&q==null) {
        return true;
    }
    if(p!=null&&q!=null) {
        return (p.val==q.val)&&isSameTree(p.left, q.left)&&isSameTree(p.right, q.right);
    }
    return false;
}
```

##  Validate Binary Search Tree
Q: Given a binary tree, determine if it is a valid binary search tree (BST). Assume a BST is defined as follows: The left subtree of a node contains only nodes with keys less than the node's key. The right subtree of a node contains only nodes with keys greater than the node's key. Both the left and right subtrees must also be binary search trees.   
```
public boolean isValidBST(TreeNode root) {
    HashMap<TreeNode, Integer[]> map = new HashMap<>();
    return helper(root, map);
}

private boolean helper(TreeNode root, HashMap<TreeNode, Integer[]> map) {
    if(root==null) {
        return true;
    } else if(root.left==null&&root.right==null) {
        map.put(root, new Integer[]{root.val, root.val});
        return true;
    } else if(root.left==null&&root.right!=null) {
        if(helper(root.right, map) && map.get(root.right)[0]>root.val) {
            map.put(root, new Integer[]{root.val, map.get(root.right)[1]});
            return true;
        }
        return false;
    } else if(root.left!=null&&root.right==null) {
        if(helper(root.left, map) && root.val>map.get(root.left)[1]) {
            map.put(root, new Integer[]{map.get(root.left)[0], root.val});
            return true;
        }
        return false;
    }
    
    if(helper(root.left, map) && helper(root.right, map) 
        && map.get(root.left)[1]<root.val && map.get(root.right)[0]>root.val) {
        map.put(root, new Integer[]{map.get(root.left)[0], map.get(root.right)[1]});
        return true;
    }
    
    return false;
}

// ref: https://leetcode.com/discuss/21411/my-simple-java-solution-in-3-lines
public boolean isValidBSTHelper(TreeNode root, long minVal, long maxVal) {
    if (root == null) return true;
    if (root.val >= maxVal || root.val <= minVal) return false;
    return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
}

// iterative one ref: https://leetcode.com/discuss/22234/my-java-inorder-iteration-solution
```

## Symmetric Tree
Q: Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).   
```
// recursive
public boolean isSymmetric(TreeNode root) {
    if(root==null || compare(root.right, root.left)) {
        return true;
    }
    return false;
}

private boolean compare(TreeNode right, TreeNode left) {
    if(right==null&&left==null) {
        return true;
    } else if(right!=null&&left!=null&&right.val==left.val) {
        return compare(right.left, left.right)&&compare(right.right, left.left);
    }
    
    return false;
}
// iterative
public boolean isSymmetric(TreeNode root) {
    if(root==null) {
        return true;
    }
    LinkedList<TreeNode> left = new LinkedList<>();
    LinkedList<TreeNode> right = new LinkedList<>();
    left.add(root.left);
    right.add(root.right);
    while(!left.isEmpty() && !right.isEmpty()) {
        while(left.peekLast()!=null) {
            left.add(left.peekLast().left);
        }
        left.pollLast();
        while(right.peekLast()!=null) {
            right.add(right.peekLast().right);
        }
        right.pollLast();
        if(left.size()!=right.size()) {
            return false;
        }
        TreeNode l = left.pollLast();
        TreeNode r = right.pollLast();
        if((l!=null&&r==null)||(l==null&&r!=null)) {
            return false;
        }
        while(l!=null&&r!=null) {
            if((l.val!=r.val)||(l.right!=null && r.left==null)||(l.right==null && r.left!=null)) {
                return false;
            } else if(l.right==null&&r.left==null) {
                l=left.pollLast();
                r=right.pollLast();
            } else {
                left.add(l.right);
                right.add(r.left);
                break;
            }
        }
    }
    
    return left.isEmpty()&&right.isEmpty();
}
```

## Construct Binary Tree from Preorder and Inorder Traversal
Q: Given preorder and inorder traversal of a tree, construct the binary tree. You may assume that duplicates do not exist in the tree.   
```
// iterative
public TreeNode buildTree(int[] preorder, int[] inorder) {
    if(preorder.length==0) {
        return null;
    }
    
    HashMap<Integer, Integer> map = new HashMap<>();
    for(int i=0; i<inorder.length; i++) {
        map.put(inorder[i], i);
    }
    
    LinkedList<TreeNode> stack = new LinkedList<>();
    TreeNode root = new TreeNode(preorder[0]);
    stack.add(root);
    for(int i=1; i<preorder.length; i++) {
        TreeNode node = new TreeNode(preorder[i]);
        if(stack.isEmpty()) {
            stack.add(node);
        } else {
            if(map.get(stack.peekLast().val)>map.get(node.val)) {
                stack.peekLast().left=node;
                stack.add(node);
            } else {
                TreeNode tmp = stack.pollLast();
                while(!stack.isEmpty() && map.get(stack.peekLast().val)<map.get(node.val)) {
                    tmp = stack.pollLast();
                }
                tmp.right = node;
                stack.add(node);
            }
        }
    }
    
    return root;
}

// recursive
// ref: https://leetcode.com/discuss/12179/my-accepted-java-solution
public TreeNode buildTree(int[] preorder, int[] inorder) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for(int i=0; i<inorder.length; i++) {
        map.put(inorder[i], i);
    }
    return helper(0, 0, inorder.length, preorder, map);
}

private TreeNode helper(int pnt, int is, int ie, int[] preorder, HashMap<Integer, Integer> map) {
    if(pnt>=map.size() || is>=ie) {
        return null;
    }
    TreeNode root = new TreeNode(preorder[pnt]);
    int idx = map.get(preorder[pnt]);
    root.left = helper(pnt+1, is, idx, preorder, map);
    root.right = helper(pnt+idx-is+1, idx+1, ie, preorder, map);
    return root;
}
```


## Construct Binary Tree from Inorder and Postorder Traversal
Q: Given inorder and postorder traversal of a tree, construct the binary tree. Note: You may assume that duplicates do not exist in the tree.   
```
// recursive
public TreeNode buildTree(int[] inorder, int[] postorder) {
    if(inorder.length==0) {
        return null;
    }
    
    HashMap<Integer, Integer> map = new HashMap<>();
    for(int i=0; i<inorder.length; i++) {
        map.put(inorder[i], i);
    }
    
    return helper(postorder, 0, postorder.length-1, 0, inorder.length-1, map);
}

private TreeNode helper(int[] postorder, int ps, int pe, int is, int ie, HashMap<Integer, Integer> map) {
    if(ps>pe || is>ie) {
        return null;
    }
    
    TreeNode root = new TreeNode(postorder[pe]);
    int idx = map.get(postorder[pe]);
    root.left = helper(postorder, ps, ps+idx-is-1, is, idx-1, map);
    root.right = helper(postorder, ps+idx-is, pe-1, idx+1, ie, map);
    
    return root;
}
```

##  Convert Sorted Array to Binary Search Tree
Q: Given an array where elements are sorted in ascending order, convert it to a height balanced BST.   
```
public TreeNode sortedArrayToBST(int[] nums) {
    return helper(nums, 0, nums.length);
}

private TreeNode helper(int[] nums, int s, int e) {
    if(s>=e) {
        return null;
    }
    
    int mid = s+(e-s)/2;
    TreeNode root = new TreeNode(nums[mid]);
    root.left = helper(nums, s, mid);
    root.right = helper(nums, mid+1, e);
    
    return root;
}
```

## Balanced Binary Tree
Q: Given a binary tree, determine if it is height-balanced. For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
```
public boolean isBalanced(TreeNode root) {
    return helper(root, new HashMap<TreeNode, Integer>());
}

private boolean helper(TreeNode node, HashMap<TreeNode, Integer> map) {
    if(node==null) {
        map.put(node, 0);
        return true;
    }
    
    boolean left = helper(node.left, map);
    boolean right = helper(node.right, map);
    
    map.put(node, Math.max(map.get(node.left), map.get(node.right))+1);
    
    return left && right && (Math.abs(map.get(node.left)-map.get(node.right))<2);
}
```

## Convert Sorted List to Binary Search Tree
Q: Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.   
```
public TreeNode sortedListToBST(ListNode head) {
    int cnt = 0;
    ListNode pnt = head;
    while(pnt!=null) {
        pnt = pnt.next;
        cnt++;
    }
    return helper(head, cnt);
}

private TreeNode helper(ListNode head, int cnt) {
    if(head==null || cnt<=0) {
        return null;
    }
    
    int mid = cnt/2;
    ListNode pnt = head;
    while(mid>0) {
        pnt = pnt.next;
        mid--;
    }
    ListNode right = pnt.next;
    pnt.next = null;
    TreeNode root = new TreeNode(pnt.val);
    root.left = helper(head, cnt/2);
    root.right = helper(right, cnt-cnt/2-1);
    
    return root;
}
```

##  Minimum Depth of Binary Tree
Q: Given a binary tree, find its minimum depth. The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.   
```
public int minDepth(TreeNode root) {
    if(root==null) {
        return 0;
    } else if(root.left==null && root.right==null) {
        return 1;
    }
    
    int left=(root.left==null)?Integer.MAX_VALUE:minDepth(root.left);
    int right=(root.right==null)?Integer.MAX_VALUE:minDepth(root.right);
    
    return Math.min(left, right)+1;
}
```

## Path Sum
Q: Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.   
```
public boolean hasPathSum(TreeNode root, int sum) {
    if((root!=null) && ((root.left==null && root.right==null && root.val==sum)
        || (root.left!=null && hasPathSum(root.left, sum-root.val))
        || (root.right!=null && hasPathSum(root.right, sum-root.val)))) {
        return true;
    }
    return false;
}
```

##  Path Sum II
Q: Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.   
```
public List<List<Integer>> pathSum(TreeNode root, int sum) {
    List<List<Integer>> lists = new ArrayList<>();
    if(root==null) {
        return lists;
    }
    helper(lists, new LinkedList<Integer>(), root, sum);
    return lists;
}

private void helper(List<List<Integer>> lists, LinkedList<Integer> list, TreeNode root, int sum) {
    list.add(root.val);
    if(sum==root.val && root.left==null && root.right==null) {
        lists.add(new LinkedList<Integer>(list));
        list.pollLast();
        return ;
    }
    
    if(root.left!=null) {
        helper(lists, list, root.left, sum-root.val);
    }
    if(root.right!=null) {
        helper(lists, list, root.right, sum-root.val);
    }
    
    list.pollLast();
}
```

##  Flatten Binary Tree to Linked List
Q: Given a binary tree, flatten it to a linked list in-place.   
```
public void flatten(TreeNode root) {
    if(root==null) {
        return ;
    }
    flatten(root.right);
    TreeNode tmp = root.right;
    flatten(root.left);
    root.right = root.left;
    root.left = null;
    while(root.right!=null) {
        root = root.right;
    }
    root.right = tmp;
}
```

##  Recover Binary Search Tree
Q: Two elements of a binary search tree (BST) are swapped by mistake. Recover the tree without changing its structure. Note: A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?   
```
// inorder traversal
public void recoverTree(TreeNode root) {
    ArrayList<TreeNode> list = new ArrayList<>();
    traverse(root, list);
    TreeNode a=null, b=null;
    for(int i=0; i<list.size()-1; i++) {
        if(a==null && list.get(i).val>list.get(i+1).val) {
            a = list.get(i);
        }
        if(a!=null && list.get(i).val>list.get(i+1).val) {
            b = list.get(i+1);
        }
    }
    swap(a,b);
}

private void traverse(TreeNode root, ArrayList<TreeNode> list) {
    if(root.left!=null) {
        traverse(root.left, list);
    }
    list.add(root);
    if(root.right!=null) {
        traverse(root.right, list);
    }
}

private void swap(TreeNode a, TreeNode b) {
    int tmp = a.val;
    a.val = b.val;
    b.val = tmp;
}

// morris traversal
// ref: https://leetcode.com/discuss/26310/detail-explain-about-morris-traversal-finds-incorrect-pointer
```

## Populating Next Right Pointers in Each Node
Q: Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL. Initially, all next pointers are set to NULL. You may only use constant extra space.
You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).   
```
public void connect(TreeLinkNode root) {
    if(root!=null) {
        LinkedList<TreeLinkNode> stack = new LinkedList<>();
        stack.add(root);
        while(!stack.isEmpty()) {
            TreeLinkNode tmp = stack.pollLast();
            if(tmp.left!=null) {
                tmp.left.next = tmp.right;
                stack.add(tmp.left);
            }
            if(tmp.right!=null) {
                tmp.right.next = (tmp.next!=null)?tmp.next.left:null;
                stack.add(tmp.right);
            }
        }
    }
}
// o(1) space
public void connect(TreeLinkNode root) {
    while(root!=null && root.left!=null) {
        root.left.next = root.right;
        root.right.next = (root.next==null)?null:root.next.left;
        connect(root.right);
        root = root.left;
    }
}
```

##  Populating Next Right Pointers in Each Node II
Q: Follow up for problem "Populating Next Right Pointers in Each Node". What if the given tree could be any binary tree? Would your previous solution still work? Note: You may only use constant extra space.   
```
public void connect(TreeLinkNode root) {
    while(root!=null) {
        TreeLinkNode tmp = root;
        TreeLinkNode first = null;
        // connect next level & find first node
        while(tmp!=null && tmp.left==null && tmp.right==null) {
            tmp = tmp.next;
        }
        if(tmp!=null) {
            first = (tmp.left==null)?tmp.right:tmp.left;
        }
        
        TreeLinkNode pre = null;
        while(tmp!=null) {
            while(tmp!=null && tmp.left==null && tmp.right==null) {
                tmp = tmp.next;
            }
            if(tmp!=null) {
                if(tmp.left!=null) {
                    if(pre==null) {
                        pre = tmp.left;
                    } else {
                        pre.next = tmp.left;
                        pre = pre.next;
                    }
                }
                if(tmp.right!=null) {
                    if(pre==null) {
                        pre = tmp.right;
                    } else {
                        pre.next = tmp.right;
                        pre = pre.next;
                    }
                }
                
                tmp = tmp.next;
            }
        }
        
        root = first;
    }
}
```

##  Number of Islands
Q: Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.   
```
public int numIslands(char[][] grid) {
    int res=0, m=grid.length;
    if(m==0) {
        return res;
    }
    int n = grid[0].length;
    int[][] dp = new int[m][n];
    for(int i=0; i<m; i++) {
        for(int j=0; j<n; j++) {
            if(grid[i][j]=='1') {
                flip(grid, i, j);
                res++;
            }
        }
    }
    return res;
}

private void flip(char[][] grid, int i, int j) {
    grid[i][j] = '*';
    for(int k=-1; k<2; k+=2) {
        if(i+k>=0 && i+k<grid.length && grid[i+k][j]=='1') {
            flip(grid, i+k, j);
        }
        if(j+k>=0 && j+k<grid[0].length && grid[i][j+k]=='1') {
            flip(grid, i, j+k);
        }
    }
}
```

##  Course Schedule
Q: There are a total of n courses you have to take, labeled from 0 to n - 1. Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1] Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses? ref: https://en.wikipedia.org/wiki/Topological_sorting#Algorithms   
```
public boolean canFinish(int numCourses, int[][] prerequisites) {
    HashMap<Integer, LinkedList<Integer>> map = new HashMap<>();
    for(int i=0; i<numCourses; i++) {
        map.put(i, new LinkedList<Integer>());
    }
    for(int i=0; i<prerequisites.length; i++) {
        map.get(prerequisites[i][0]).add(prerequisites[i][1]);
    }
    
    boolean[] visit = new boolean[numCourses];
    boolean[] check = new boolean[numCourses];
    for(int i=0; i<numCourses; i++) {
        visit[i] = true;
        if(!check[i] && !valid(visit, i, map, check)) {
            return false;
        }
        check[i] = true;
        visit[i] = false;
    }
    return true;
}

private boolean valid(boolean[] visit, int node, HashMap<Integer, LinkedList<Integer>> map, boolean[] check) {
    for(int a:map.get(node)) {
        if(visit[a]) {
            return false;
        }
        visit[a] = true;
        if(!check[a] && !valid(visit, a, map, check)) {
            return false;
        }
        check[a] = true;
        visit[a] = false;
    }
    return true;
}
```

## Binary Tree Paths
Q: Given a binary tree, return all root-to-leaf paths.   
```
public List<String> binaryTreePaths(TreeNode root) {
    List<String> list = new ArrayList<>();
    if(root==null) {
        return list;
    }
    
    HashMap<TreeNode, String> map = new HashMap<>();
    LinkedList<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while(!queue.isEmpty()) {
        // bfs
        TreeNode node = queue.poll();
        // dfs
        // TreeNode node = queue.pollLast();
        if(!map.containsKey(node)) {
            map.put(node, ""+node.val);
        }
        if(node.left==null && node.right==null) {
            // leaf
            list.add(map.get(node));
        } else {
            if(node.left!=null) {
                queue.add(node.left);
                map.put(node.left, map.get(node)+"->"+node.left.val);
            }
            if(node.right!=null) {
                queue.add(node.right);
                map.put(node.right, map.get(node)+"->"+node.right.val);
            }
        }
    }
    
    return list;
}
```

## Longest Increasing Path in a Matrix
Q: Given an integer matrix, find the length of the longest increasing path. From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).   
```
public int longestIncreasingPath(int[][] matrix) {
    int row = matrix.length;
    if(row==0) {
        return 0;
    }
    
    int col=matrix[0].length, max=0;
    int[][] dp = new int[row][col];
    
    for(int i=0; i<row; i++) {
        for(int j=0; j<col; j++) {
            if(dp[i][j]==0) {
                helper(matrix, dp, i, j);
            }
            max = Math.max(max, dp[i][j]);
        }
    }
    
    return max;
}

private void helper(int[][] matrix, int[][] dp, int r, int c) {
    dp[r][c] = 1;
    for(int i=-1; i<2; i+=2) {
        if(r+i>=0 && r+i<matrix.length) {
            if(matrix[r+i][c]>matrix[r][c]) {
                if(dp[r+i][c]==0) {
                    helper(matrix, dp, r+i, c);
                }
                dp[r][c] = Math.max(dp[r][c], dp[r+i][c]+1);
            }
        }
        if(c+i>=0 && c+i<matrix[0].length) {
            if(matrix[r][c+i]>matrix[r][c]) {
                if(dp[r][c+i]==0) {
                    helper(matrix, dp, r, c+i);
                }
                dp[r][c] = Math.max(dp[r][c], dp[r][c+i]+1);
            }
        }
    }
}
```

## House Robber III
Q: The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night. Determine the maximum amount of money the thief can rob tonight without alerting the police.   
good improve ref: https://leetcode.com/discuss/91899/step-by-step-tackling-of-the-problem   
```
public int rob(TreeNode root) {
    if(root==null) {
        return 0;
    }
    int left = rob(root.left);
    int right = rob(root.right);
    int base = root.val;
    if(root.left!=null) {
        base += rob(root.left.left);
        base += rob(root.left.right);
    }
    if(root.right!=null) {
        base += rob(root.right.left);
        base += rob(root.right.right);
    }
    return Math.max(base, left+right);
}
```

## Binary Tree Maximum Path Sum
Q: Given a binary tree, find the maximum path sum. For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path does not need to go through the root.   
```
public int maxPathSum(TreeNode root) {
    HashMap<TreeNode, Integer> cache = new HashMap<>();
    return helper(root, cache);
}

private int helper(TreeNode root, HashMap<TreeNode, Integer> cache) {
    if(root==null) {
        cache.put(root, 0);
        return 0;
    }
    
    int left = helper(root.left, cache);
    int right = helper(root.right, cache);
    
    int local = Math.max(root.val, root.val+Math.max(cache.get(root.left), cache.get(root.right)));
    cache.put(root, local);
    
    
    int max = Math.max(local, cache.get(root.left)+cache.get(root.right)+root.val);
    if(root.left!=null) {
        max = Math.max(max, left);
    }
    if(root.right!=null) {
        max = Math.max(max, right);
    }
    return max;
}
```








