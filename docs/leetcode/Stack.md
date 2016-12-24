#Stack & Queue

1. [Valid Parentheses](#valid-parentheses)
2. [Simplify Path](#simplify-path)
3. [Largest Rectangle in Histogram](#largest-rectangle-in-histogram)
4. [Min Stack](#min-stack)
5. [Evaluate Reverse Polish Notation](#evaluate-reverse-polish-notation)
6. [Binary Search Tree Iterator](#binary-search-tree-iterator)
7. [Implement Stack using Queues](#implement-stack-using-queues)
8. [Implement Queue using Stacks](#implement-queue-using-stacks)
9. [Peeking Iterator](#peeking-iterator)
10. [Verify Preorder Serialization of a Binary Tree](#verify-preorder-serialization-of-a-binary-tree)
11. [Maximal Rectangle](#maximal-rectangle)
12. [Flatten Nested List Iterator](#flatten-nested-list-iterator)

##Valid Parentheses   
Q: Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid. The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.   
```
public boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();
    
    for(Character c:s.toCharArray()) {
        if(c=='(' || c=='[' || c=='{') {
            stack.push(c);
        } else {
            if(stack.isEmpty() || Math.abs(c-stack.pop())>2) {
                return false;
            }
        }
    }
    return stack.isEmpty();
}
```

##Simplify Path   
Q: Given an absolute path for a file (Unix-style), simplify it.   
```
public String simplifyPath(String path) {
    Stack<String> stack = new Stack<>();
    for(String str:path.split("/")) {
        if(str.equals(".") || str.equals("")) {
            continue;
        } else if(str.equals("..")) {
            if(!stack.empty()) {
                stack.pop();
            }
        } else {
            stack.push(str);
        }
    }
    
    StringBuilder sb = new StringBuilder();
    if(stack.empty() && path.length()>0) {
        sb.append('/');
    }
    while(!stack.empty()) {
        sb.insert(0,stack.pop());
        sb.insert(0,'/');
    }
    
    return sb.toString();
}
```

##Largest Rectangle in Histogram   
Q: Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram. For example, Given heights = [2,1,5,6,2,3], return 10.   
```
public int largestRectangleArea(int[] heights) {
    LinkedList<Integer> idx = new LinkedList<>();
    int area = 0;
    for(int i=0; i<heights.length; i++) {
        if(idx.isEmpty()) {
            idx.add(i);
            area = Math.max((i+1)*heights[i], area);
        } else {
            while(!idx.isEmpty() && heights[idx.peekLast()]>heights[i]) {
                int h = heights[idx.pollLast()];
                int w = idx.isEmpty()?i:i-idx.peekLast()-1;
                area = Math.max(area, h*w);
            }
            idx.add(i);
        }
    }
    while(!idx.isEmpty()) {
        int h = heights[idx.pollLast()];
        int w = idx.isEmpty()?heights.length:heights.length-idx.peekLast()-1;
        area = Math.max(area, h*w);
    }
    return area;
}
```

##Min Stack
Q: Design a stack that supports push, pop, top, and retrieving the minimum element in constant time. push(x) -- Push element x onto stack. pop() -- Removes the element on top of the stack. top() -- Get the top element. getMin() -- Retrieve the minimum element in the stack.   
```
class MinStack {
    LinkedList<Integer> min = new LinkedList<>();
    LinkedList<Integer> stack = new LinkedList<>();
    
    public void push(int x) {
        stack.add(x);
        if(min.isEmpty() || x<=min.peekLast()) {
            min.add(x);
        } else {
            min.add(min.peekLast());
        }
    }

    public void pop() {
        stack.pollLast();
        min.pollLast();
    }

    public int top() {
        return stack.peekLast();
    }

    public int getMin() {
        return min.peekLast();
    }
}
```

##Evaluate Reverse Polish Notation
Q: Evaluate the value of an arithmetic expression in Reverse Polish Notation.Valid operators are +, -, *, /. Each operand may be an integer or another expression.   
```
public int evalRPN(String[] tokens) {
    LinkedList<String> stack = new LinkedList<>();
    for(int i=0; i<tokens.length; i++) {
        if(isOpt(tokens[i])) {
            String a = stack.pollLast();
            String b = stack.pollLast();
            String c = cal(a, b, tokens[i]);
            stack.add(c);
        } else {
            stack.add(tokens[i]);
        }
    }
    return Integer.parseInt(stack.pollLast());
}

private boolean isOpt(String a) {
    return a.equals("+") || a.equals("-") || a.equals("*") || a.equals("/");
}

private String cal(String as, String bs, String op) {
    Long a = Long.parseLong(as);
    Long b = Long.parseLong(bs);
    Long c = new Long(0);
    if(op.equals("+")) {
        c = a+b;
    } else if(op.equals("-")) {
        c = b-a;
    } else if(op.equals("*")) {
        c = b*a;
    } else {
        c = b/a;
    }
    return Long.toString(c);
}
```

##Binary Search Tree Iterator
Q: Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST. Calling next() will return the next smallest number in the BST. Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.   
```
public class BSTIterator {
    
    private LinkedList<TreeNode> stack = new LinkedList<>();

    public BSTIterator(TreeNode root) {
        addNode(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pollLast();
        addNode(node.right);
        return node.val;
    }
    
    private void addNode(TreeNode root) {
        while(root!=null) {
            stack.add(root);
            root = root.left;
        }
    }
}
```

##Implement Stack using Queues
Q: Implement the following operations of a stack using queues. push(x) -- Push element x onto stack. pop() -- Removes the element on top of the stack. top() -- Get the top element. empty() -- Return whether the stack is empty. Notes: You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid. Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue. You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).   
```
class MyStack {
    LinkedList<Integer> queue = new LinkedList<>();
    int top;
    
    // Push element x onto stack.
    public void push(int x) {
        queue.add(x);
        top = x;
    }

    // Removes the element on top of the stack.
    public void pop() {
        LinkedList<Integer> tmp = new LinkedList<>();
        while(!queue.isEmpty() && queue.size()>1) {
            top = queue.poll();
            tmp.add(top);
        }
        queue = tmp;
    }

    // Get the top element.
    public int top() {
        return top;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue.isEmpty();
    }
}
```

##Implement Queue using Stacks
Q: Implement the following operations of a queue using stacks. push(x) -- Push element x to the back of queue. pop() -- Removes the element from in front of queue. peek() -- Get the front element. empty() -- Return whether the queue is empty. Notes: You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid. Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack. You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).   
```
class MyQueue {
    Stack<Integer> stack = new Stack<>();
    
    // Push element x to the back of queue.
    public void push(int x) {
        Stack<Integer> tmp = new Stack<>();
        while(!stack.isEmpty()) {
            tmp.push(stack.pop());
        }
        stack.push(x);
        while(!tmp.isEmpty()) {
            stack.push(tmp.pop());
        }
    }

    // Removes the element from in front of queue.
    public void pop() {
        stack.pop();
    }

    // Get the front element.
    public int peek() {
        return stack.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stack.isEmpty();
    }
}
```

##Peeking Iterator
Q: Given an Iterator class interface with methods: next() and hasNext(), design and implement a PeekingIterator that support the peek() operation -- it essentially peek() at the element that will be returned by the next call to next(). Follow up: How would you extend your design to be generic and work with all types, not just integer?   
```
class PeekingIterator implements Iterator<Integer> {
    Queue<Integer> queue = new LinkedList<>();

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        while(iterator.hasNext()) {
            queue.add(iterator.next());
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return queue.peek();
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        return queue.poll();
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }
}
```

##Verify Preorder Serialization of a Binary Tree
Q: One way to serialize a binary tree is to use pre-order traversal. When we encounter a non-null node, we record the node's value. If it is a null node, we record using a sentinel value such as #.   
better sol ref: https://leetcode.com/discuss/83824/7-lines-easy-java-solution   
```
public boolean isValidSerialization(String preorder) {
    LinkedList<Integer> stack = new LinkedList<>();
    String[] arr = preorder.split(",");
    for(int i=0; i<arr.length; i++) {
        if(i>0 && stack.isEmpty()) {
            return false;
        }
        if(!arr[i].equals("#")) {
            stack.add(0);
        } else {
            while(!stack.isEmpty() && stack.peekLast()==1) {
                stack.pollLast();
            }
            if(!stack.isEmpty()) {
                stack.pollLast();
                stack.add(1);
            }
        }
    }
    return stack.isEmpty();
}
```

##Maximal Rectangle
Q: Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area.   
dp ref: https://leetcode.com/discuss/20240/share-my-dp-solution   
```
public int maximalRectangle(char[][] matrix) {
    int row=matrix.length;
    if(row==0) {
        return 0;
    }
    int col=matrix[0].length, area=0;
    int[] h = new int[col];
    for(int i=0; i<row; i++) {
        for(int j=0; j<col; j++) {
            h[j] = (matrix[i][j]=='1')?h[j]+1:0;
        }
        area = Math.max(area, area(h));
    }
    return area;
}

private int area(int[] h) {
    LinkedList<Integer> idx = new LinkedList<>();
    LinkedList<Integer> hi = new LinkedList<>();
    int area = 0;
    
    for(int i=0; i<h.length; i++) {
        while(!hi.isEmpty() && h[i]<=hi.peekLast()) {
            int ht = hi.pollLast();
            idx.pollLast();
            if(idx.isEmpty()) {
                area = Math.max(i*ht, area);
            } else {
                area = Math.max((i-idx.peekLast()-1)*ht, area);
            }
        }
        idx.add(i);
        hi.add(h[i]);
    }
    
    while(!hi.isEmpty()) {
        int ht = hi.pollLast();
        idx.pollLast();
        if(idx.isEmpty()) {
            area = Math.max(h.length*ht, area);
        } else {
            area = Math.max((h.length-idx.peekLast()-1)*ht, area);
        }
    }
    
    return area;
}
```

##Flatten Nested List Iterator 
Q: Given a nested list of integers, implement an iterator to flatten it. Each element is either an integer, or a list -- whose elements may also be integers or other lists.   
```
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {

    LinkedList<Integer> queue = new LinkedList<>();

    public NestedIterator(List<NestedInteger> nestedList) {
        helper(nestedList);
    }
    
    private void helper(List<NestedInteger> nestedList) {
        for(NestedInteger i:nestedList) {
            if(!i.isInteger()) {
                helper(i.getList());
            } else {
                queue.add(i.getInteger());
            }
        }
    }

    @Override
    public Integer next() {
        return queue.poll();
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
```






