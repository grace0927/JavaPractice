# BFS

1. [Binary Tree Level Order Traversal](#binary-tree-level-order-traversal)
2. [Binary Tree Zigzag Level Order Traversal](#binary-tree-zigzag-level-order-traversal)
3. [Maximum Depth of Binary Tree](#maximum-depth-of-binary-tree)
4. [Binary Tree Level Order Traversal II](#binary-tree-level-order-traversal-ii)
5. [Word Ladder](#word-ladder)
6. [Sum Root to Leaf Numbers](#sum-root-to-leaf-numbers)
7. [Surrounded Regions](#surrounded-regions)
8. [Clone Graph](#clone-graph)
9. [Binary Tree Right Side View](#binary-tree-right-side-view)
10. [Perfect Squares](#perfect-squares)
11. [Minimum Height Trees](#minimum-height-trees)
12. [Word Ladder II](#word-ladder-ii)
13. [Remove Invalid Parentheses](#remove-invalid-parentheses)

## Binary Tree Level Order Traversal
Q: Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).   
```
public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> lists = new ArrayList<>();
    if(root==null) {
        return lists;
    }
    LinkedList<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while(!queue.isEmpty()) {
        List<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> tmp = new LinkedList<>();
        for(TreeNode pnt:queue) {
            list.add(pnt.val);
            if(pnt.left!=null) {
                tmp.add(pnt.left);
            }
            if(pnt.right!=null) {
                tmp.add(pnt.right);
            }
        }
        lists.add(list);
        queue = tmp;
    }
    return lists;
}
```

## Binary Tree Zigzag Level Order Traversal
Q: Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).   
```
public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> lists = new ArrayList<>();
    if(root==null) {
        return lists;
    }
    LinkedList<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    boolean flag = true;
    while(!queue.isEmpty()) {
        List<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> tmp = new LinkedList<>();
        while(!queue.isEmpty()) {
            TreeNode cur = queue.pollLast();
            list.add(cur.val);
            if(flag) {
                if(cur.left!=null) {
                    tmp.add(cur.left);
                }
                if(cur.right!=null) {
                    tmp.add(cur.right);
                }
            } else {
                if(cur.right!=null) {
                    tmp.add(cur.right);
                }
                if(cur.left!=null) {
                    tmp.add(cur.left);
                }
            }
        }
        lists.add(list);
        flag = (flag)?false:true;
        queue = tmp;
    }
    return lists;
}
```

## Maximum Depth of Binary Tree
Q: Given a binary tree, find its maximum depth. The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.   
```
// BFS
public int maxDepth(TreeNode root) {
    int level = 0;
    
    if(root!=null) {
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        list.add(null);
        while(!list.isEmpty()) {
            TreeNode tmp = list.poll();
            if(tmp!=null) {
                if(tmp.left!=null) {
                    list.add(tmp.left);
                }
                if(tmp.right!=null) {
                    list.add(tmp.right);
                }
            } else {
                level++;
                if(!list.isEmpty()) {
                    list.add(null);
                }
            }
        }
    }
    
    return level;
}

// DFS
public int maxDepth(TreeNode root) {
    return root==null? 0 : Math.max(maxDepth(root.left), maxDepth(root.right))+1;
}
```

## Binary Tree Level Order Traversal II
Q: Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).   
```
public List<List<Integer>> levelOrderBottom(TreeNode root) {
    List<List<Integer>> lists = new ArrayList<>();
    if(root==null) {
        return lists;
    }
    
    LinkedList<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while(!queue.isEmpty()) {
        List<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> tmp = new LinkedList<>();
        for(TreeNode node:queue) {
            list.add(node.val);
            if(node.left!=null) {
                tmp.add(node.left);
            }
            if(node.right!=null) {
                tmp.add(node.right);
            }
        }
        lists.add(0, list);
        queue = tmp;
    }
    
    return lists;
}
```

## Word Ladder
Q: Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that: Only one letter can be changed at a time Each intermediate word must exist in the word list For example, Given: beginWord = "hit" endWord = "cog" wordList = ["hot","dot","dog","lot","log"] As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog", return its length 5. Note: Return 0 if there is no such transformation sequence. All words have the same length. All words contain only lowercase alphabetic characters.   
```
public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
    StringBuilder sb = new StringBuilder(beginWord);
    Set<String> set = new HashSet<>();
    int level = 1;
    
    set.add(beginWord);
    while(!set.isEmpty()) {
        Set<String> tmp = new HashSet<>();
        for(String cur:set) {
            char[] arr = cur.toCharArray();
            for(int i=0; i<arr.length; i++) {
                char c = arr[i];
                for(char a='a'; a<='z'; a++) {
                    arr[i] = a;
                    String str = new String(arr);
                    if(str.equals(endWord)) {
                        return (a==c)?level:level+1;
                    }
                    if(wordList.contains(str)) {
                        tmp.add(str);
                        wordList.remove(str);
                    }
                }
                arr[i] = c;
            }
        }
        level++;
        set = tmp;
    }
    
    return 0;
}
```

## Sum Root to Leaf Numbers
Q: Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number. An example is the root-to-leaf path 1->2->3 which represents the number 123.Find the total sum of all root-to-leaf numbers.   
```
public int sumNumbers(TreeNode root) {
    LinkedList<TreeNode> queue = new LinkedList<>();
    if(root!=null) {
        queue.add(root);
    }
    int sum = 0;
    while(!queue.isEmpty()) {
        TreeNode pnt = queue.poll();
        if(pnt.left!=null) {
            pnt.left.val += pnt.val*10;
            queue.add(pnt.left);
        }
        if(pnt.right!=null) {
            pnt.right.val += pnt.val*10;
            queue.add(pnt.right);
        }
        if(pnt.left==null && pnt.right==null) {
            sum += pnt.val;
        }
    }
    return sum;
}
```

## Surrounded Regions
Q: Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'. A region is captured by flipping all 'O's into 'X's in that surrounded region.   
```
public void solve(char[][] board) {
    if(board.length<=1 || board[0].length<=1) {
        return ;
    }
    int row=board.length, col=board[0].length;
    
    LinkedList<Integer> queR = new LinkedList<>();
    LinkedList<Integer> queC = new LinkedList<>();
    
    // find safe O and mark them
    for(int i=0; i<col; i++) {
        validate(board, 0, i, queR, queC);
        validate(board, row-1, i, queR, queC);
    }
    for(int i=0; i<row; i++) {
        validate(board, i, 0, queR, queC);
        validate(board, i, col-1, queR, queC);
    }
    while(!queR.isEmpty()) {
        int r=queR.poll(), c=queC.poll();
        validate(board, r-1, c, queR, queC);
        validate(board, r+1, c, queR, queC);
        validate(board, r, c-1, queR, queC);
        validate(board, r, c+1, queR, queC);
    }
    
    // flip
    for(int i=0; i<row; i++) {
        for(int j=0; j<col; j++) {
            if(board[i][j]!='X') {
                board[i][j] = (board[i][j]=='|')?'O':'X';
            }
        }
    }
}

private void validate(char[][] board, int r, int c, LinkedList<Integer> queR, LinkedList<Integer> queC) {
    if(r>=0 && r<board.length && c>=0 && c<board[0].length && board[r][c]=='O') {
        board[r][c] = '|';
        queR.add(r);
        queC.add(c);
    }
}
```

## Clone Graph
Q: Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors. Nodes are labeled uniquely.   
```
public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    if(node==null) {
        return null;
    }
    
    HashMap<Integer, UndirectedGraphNode> map = new HashMap<>();
    LinkedList<UndirectedGraphNode> queue = new LinkedList<>();
    queue.add(node);
    
    while(!queue.isEmpty()) {
        UndirectedGraphNode head = queue.poll();
        if(!map.containsKey(head.label)) {
            map.put(head.label, new UndirectedGraphNode(head.label));
        }
        UndirectedGraphNode cur = map.get(head.label);
        for(UndirectedGraphNode neighbor:head.neighbors) {
            int label = neighbor.label;
            if(!map.containsKey(label)) {
                map.put(label, new UndirectedGraphNode(label));
                queue.add(neighbor);
            }
            UndirectedGraphNode tmp = map.get(label);
            cur.neighbors.add(tmp);
        }
    }
    
    return map.get(node.label);
}
```

##Binary Tree Right Side View
Q: Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.   
```
public List<Integer> rightSideView(TreeNode root) {
    LinkedList<TreeNode> queue = new LinkedList<>();
    List<Integer> list = new ArrayList<>();
    if(root==null) {
        return list;
    }
    queue.add(root);
    while(!queue.isEmpty()) {
        LinkedList<TreeNode> tmp = new LinkedList<>();
        TreeNode node = queue.peek();
        while(!queue.isEmpty()) {
            node = queue.poll();
            if(node.left!=null) {
                tmp.add(node.left);
            }
            if(node.right!=null) {
                tmp.add(node.right);
            }
        }
        list.add(node.val);
        queue = tmp;
    }
    return list;
}
```

##Perfect Squares
Q: Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n. For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.   
good ref: https://leetcode.com/discuss/58056/summary-of-different-solutions-bfs-static-and-mathematics   
```
public int numSquares(int n) {
    if(n==1) {
        return 1;
    }
    int[] square = new int[n/2];
    for(int i=0; i<n/2; i++) {
        square[i] = (i+1)*(i+1);
    }
    HashSet<Integer> set = new HashSet<>();
    int level = 0;
    set.add(0);
    while(!set.contains(n)) {
        HashSet<Integer> tmp = new HashSet<>();
        for(int a:set) {
            for(int i=0; i<n/2; i++) {
                int s = a+square[i];
                if(s>n) {
                    break;
                }
                tmp.add(s);
            }
        }
        set = tmp;
        level++;
    }
    return level;
}
```

##Minimum Height Trees
Q: For a undirected graph with tree characteristics, we can choose any node as the root. The result graph is then a rooted tree. Among all possible rooted trees, those with minimum height are called minimum height trees (MHTs). Given such a graph, write a function to find all the MHTs and return a list of their root labels. Format The graph contains n nodes which are labeled from 0 to n - 1. You will be given the number n and a list of undirected edges (each edge is a pair of labels). You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.   
```
public List<Integer> findMinHeightTrees(int n, int[][] edges) {
    int[] ret = new int[n];
    HashMap<Integer, LinkedList<Integer>> map = new HashMap<>();
    for(int i=0; i<edges.length; i++) {
        ret[edges[i][0]]++;
        ret[edges[i][1]]++;
        if(!map.containsKey(edges[i][0])) {
            map.put(edges[i][0], new LinkedList<>());
        }
        if(!map.containsKey(edges[i][1])) {
            map.put(edges[i][1], new LinkedList<>());
        }
        map.get(edges[i][0]).add(edges[i][1]);
        map.get(edges[i][1]).add(edges[i][0]);
    }
    
    boolean[] visit = new boolean[n];
    HashSet<Integer> set = helper(ret, visit);
    List<Integer> res = new ArrayList<>(set);
    while(!set.isEmpty()) {
        for(int i:set) {
            if(map.containsKey(i)) {
                for(int j:map.get(i)) {
                    ret[j]--;
                }
            }
        }
        set = helper(ret, visit);
        if(!set.isEmpty()) {
            res = new ArrayList<>(set);
        }
    }
    return res;
}
private HashSet<Integer> helper(int[] ret, boolean[] visit) {
    HashSet<Integer> set = new HashSet<>();
    for(int i=0; i<ret.length; i++) {
        if(!visit[i] && ret[i]<=1) {
            set.add(i);
            ret[i]--;
            visit[i] = true;
        }
    }
    return set;
}
```

##Word Ladder II
Q: Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that: Only one letter can be changed at a time Each intermediate word must exist in the word list Note: All words have the same length. All words contain only lowercase alphabetic characters.      
good ref: https://leetcode.com/discuss/64808/my-concise-java-solution-based-on-bfs-and-dfs   
```
public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
    List<List<String>> lists = new ArrayList<>();
    LinkedList<String> list = new LinkedList<>();
    list.add(beginWord);
    if(beginWord.equals(endWord)) {
        lists.add(list);
        return lists;
    }
    
    int len = beginWord.length();
    LinkedList<LinkedList<String>> queue = new LinkedList<>();
    queue.add(list);
    wordList.remove(beginWord);
    
    while(!queue.isEmpty()) {
        boolean end = false;
        LinkedList<LinkedList<String>> tmp = new LinkedList<>();
        HashSet<String> set = new HashSet<>();
        while(!queue.isEmpty()) {
            LinkedList<String> row = queue.poll();
            String str = row.peekLast();
            char[] arr = str.toCharArray();
            for(int i=0; i<len; i++) {
                char tc = arr[i];
                for(char c='a'; c<='z'; c++) {
                    arr[i] = c;
                    String ns = new String(arr);
                    if(ns.equals(endWord)) {
                        end = true;
                        row.add(ns);
                        lists.add(new LinkedList<>(row));
                        row.pollLast();
                    } else if(wordList.contains(ns)) {
                        row.add(ns);
                        set.add(ns);
                        tmp.add(new LinkedList<>(row));
                        row.pollLast();
                    }
                }
                arr[i] = tc;
            }
        }
        wordList.removeAll(set);
        if(!end) {
            queue = tmp;
        }
    }
    
    return lists;
}
```

##Remove Invalid Parentheses
Q: Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results. Note: The input string may contain letters other than the parentheses ( and ).   
dfs ref: http://algobox.org/remove-invalid-parentheses/   
```
// bfs
public List<String> removeInvalidParentheses(String s) {
    List<String> list = new ArrayList<>();
    HashSet<String> set = new HashSet<>();
    set.add(s);
    while(list.isEmpty()) {
        HashSet<String> next = new HashSet<>();
        for(String st:set) {
            if(isValid(st)) {
                list.add(st);
            } else {
                add(next, st);
            }
        }
        set = next;
    }
    return list;
}

private void add(HashSet<String> list, String s) {
    StringBuilder sb = new StringBuilder(s);
    for(int i=0; i<sb.length(); i++) {
        char c = sb.charAt(i);
        if(c=='(' || c==')') {
            sb.deleteCharAt(i);
            list.add(sb.toString());
            sb.insert(i, c);
        }
    }
}

private boolean isValid(String s) {
    int cnt=0;
    for(int i=0; i<s.length(); i++) {
        if(s.charAt(i)=='(') {
            cnt++;
        } else if(s.charAt(i)==')') {
            cnt--;
        }
        if(cnt<0) {
            return false;
        }
    }
    return cnt==0;
}
```








