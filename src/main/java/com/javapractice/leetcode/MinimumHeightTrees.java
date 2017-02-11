/**
 * 
 */
package com.javapractice.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Feng
 * https://leetcode.com/problems/minimum-height-trees/
 * For a undirected graph with tree characteristics, we can choose any node as the root. 
 * The result graph is then a rooted tree. 
 * Among all possible rooted trees, those with minimum height are called 
 * minimum height trees (MHTs). Given such a graph, write a function to find all the MHTs 
 * and return a list of their root labels.
 * Format
 * The graph contains n nodes which are labeled from 0 to n - 1. 
 * You will be given the number n and a list of undirected edges (each edge is a pair of labels).
 * You can assume that no duplicate edges will appear in edges. 
 * Since all edges are undirected, [0, 1] is the same as [1, 0] 
 * and thus will not appear together in edges.
 * Example 1:
 * Given n = 4, edges = [[1, 0], [1, 2], [1, 3]]
 * 		0
 * 		|
 * 		1
 *     / \
 *    2   3
 * return [1]
 * Example 2:
 * Given n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]
 *   0  1  2
 *    \ | /
 *      3
 *      |
 *      4
 *      |
 *      5
 * return [3, 4]
 * Note:
 * (1) According to the definition of tree on Wikipedia: 
 * “a tree is an undirected graph in which any two vertices are connected by exactly one path. 
 * In other words, any connected graph without simple cycles is a tree.”
 * (2) The height of a rooted tree is the number of edges on the longest downward path 
 * between the root and a leaf.
 *
 */
public class MinimumHeightTrees {
	/*
	 * http://algobox.org/minimum-height-trees/
	 */
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        // initial graph O(n)
        HashMap<Integer, Set<Integer>> graph = new HashMap<>();
        for(int i=0; i<n; i++) {
            graph.put(i, new HashSet<Integer>());
        }
        for(int i=0; i<edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        
        List<Integer> height = new ArrayList<>();
        for(int i=0; i<n; i++) {
            if(graph.get(i).size()<=1) {
                height.add(i);
            }
        }
        
        while(n>2) {
            n -= height.size();
            List<Integer> tmp = new ArrayList<>();
            for(Integer i:height) {
                for(Integer j:graph.get(i)) {
                    graph.get(j).remove(i);
                    if(graph.get(j).size()==1) {
                        tmp.add(j);
                    }
                }
            }
            height = tmp;
        }
        
        return height;
    }
    
	public List<Integer> findMinHeightTreesMyself(int n, int[][] edges) {
        // initial graph O(n)
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for(int i=0; i<n; i++) {
            graph.put(i, new ArrayList<Integer>());
        }
        for(int i=0; i<edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        
        int min = Integer.MAX_VALUE;
        HashMap<Integer, List<Integer>> height = new HashMap<>();
        // O(n^O(height function))
        for(int i=0; i<n; i++) {
            int hi = height(graph, i);
            min = Math.min(hi, min);
            if(!height.containsKey(hi)) {
                height.put(hi, new ArrayList<Integer>());
            }
            height.get(hi).add(i);
        }
        
        return height.get(min);
    }
    
    public int height(HashMap<Integer, List<Integer>> graph, int root) {
        // iterative BFS to calculating Height O(n)
        boolean[] visit = new boolean[graph.size()];
        List<Integer> row = new ArrayList<>();
        row.add(root);
        visit[root] = true;
        int height = 0;
        while(row.size()>0) {
            height++;
            List<Integer> newrow = new ArrayList<>();
            for(Integer i:row) {
                for(Integer j:graph.get(i)) {
                    if(!visit[j]) {
                        newrow.add(j);
                    }
                }
                visit[i] = true;
            }
            row = newrow;
        }
        return height;
    }
}
