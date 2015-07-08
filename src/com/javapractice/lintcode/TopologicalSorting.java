/**
 * 
 */
package com.javapractice.lintcode;

import java.util.ArrayList;

/**
 * @author jianyu
 * http://www.lintcode.com/en/problem/topological-sorting/
 * Given an directed graph, a topological order of the graph nodes is defined as follow:
 * For each directed edge A -> B in graph, A must before B in the order list.
 * The first node in the order can be any node in the graph with no nodes direct to it.
 * Find any topological order for the given graph.
 * For graph as follow:
 * {0,1,2,3#1,4#2,4,5#3,4,5#4#5}
 * The topological order can be:
 * [0, 1, 2, 3, 4, 5]
 * [0, 2, 3, 1, 5, 4]
 * ...
 * You can assume that there is at least one topological order in the graph.
 * Can you do it in both BFS and DFS?
 *
 */
public class TopologicalSorting {
    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */    
    public ArrayList<DirectedGraphNode> topSortBFS(ArrayList<DirectedGraphNode> graph) {
        // write your code here
		ArrayList<DirectedGraphNode> res = new ArrayList<>();
		int len = graph.size();
		if(len == 1) {
			return graph;
		}
		ArrayList<DirectedGraphNode> temp = new ArrayList<>();
		for(int i=0; i<len; i++) {
			DirectedGraphNode node = graph.get(i);
			for(int j=0; j<node.neighbors.size(); j++) {
				if(!temp.contains(node.neighbors.get(j))) {
					temp.add(node.neighbors.get(j));
				}
			}
		}
		
		for(int i=0; i<len; i++) {
			DirectedGraphNode node = graph.get(i);
			if(!temp.contains(node)) {
				res.add(node);
			}
		}
		
		res.addAll(topSort(temp));
		
		return res;
    }
}
