/**
 * 
 */
package com.javapractice.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jianyu
 *
 */
public class UndirectedGraphNode {
	int label;
	List<UndirectedGraphNode> neighbors;
	
	UndirectedGraphNode(int x) {
		label = x;
		neighbors = new ArrayList<UndirectedGraphNode>();
	}
}
