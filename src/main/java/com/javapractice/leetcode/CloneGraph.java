/**
 *
 */
package com.javapractice.leetcode;

import java.util.HashMap;

/**
 * @author Jianyu Feng
 * https://oj.leetcode.com/problems/clone-graph/
 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
 * OJ's undirected graph serialization:
 * Nodes are labeled uniquely.
 * We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
 * As an example, consider the serialized graph {0,1,2#1,2#2,2}.
 * The graph has a total of three nodes, and therefore contains three parts as separated by #.
 * 1. First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
 * 2. Second node is labeled as 1. Connect node 1 to node 2.
 * 3. Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
 * Visually, the graph looks like the following:
 *        1
 *       / \
 *      /   \
 *     0 --- 2
 *          / \
 *          \_/
 *
 */
public class CloneGraph {
	private HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if(node == null) {
			return null;
		}

		UndirectedGraphNode result = new UndirectedGraphNode(node.label);
		for(UndirectedGraphNode cur:node.neighbors) {
			if(cur != node) {
				if(map.containsKey(cur)) {
					result.neighbors.add(map.get(cur));
				} else {
					result.neighbors.add(cloneGraph(cur));
				}
			} else {
				result.neighbors.add(result);
			}
		}
		map.put(node, result);

		return result;
	}

	public UndirectedGraphNode cloneGraphIterative(UndirectedGraphNode root) {
		HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
		Queue<UndirectedGraphNode> queue = new LinkedList<>();
		if (root!=null) {
			queue.add(root);
		}

		while (!queue.isEmpty()) {
			UndirectedGraphNode node = queue.poll();
			if (!map.containsKey(node)) {
				UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
				map.put(node, clone);
			}
			for (UndirectedGraphNode neighbor:node.neighbors) {
				if (!map.containsKey(neighbor)) {
					queue.add(neighbor);
				}
			}
		}

		for (UndirectedGraphNode node:map.keySet()) {
			List<UndirectedGraphNode> cloneNeighbors = new ArrayList<>();
			for (UndirectedGraphNode neighbor:node.neighbors) {
				cloneNeighbors.add(map.get(neighbor));
			}
			map.get(node).neighbors = cloneNeighbors;
		}

		return map.containsKey(root) ? map.get(root) : null;
	}
}
