/**
 * 
 */
package com.javapractice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Feng
 * https://leetcode.com/problems/reconstruct-itinerary/
 * Given a list of airline tickets represented by pairs of departure and 
 * arrival airports [from, to], reconstruct the itinerary in order. 
 * All of the tickets belong to a man who departs from JFK. 
 * Thus, the itinerary must begin with JFK.
 * Note:
 * If there are multiple valid itineraries, you should return the itinerary 
 * that has the smallest lexical order when read as a single string. 
 * For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
 * All airports are represented by three capital letters (IATA code).
 * You may assume all tickets may form at least one valid itinerary.
 * Example 1:
 * tickets = [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 * Return ["JFK", "MUC", "LHR", "SFO", "SJC"].
 * Example 2:
 * tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * Return ["JFK","ATL","JFK","SFO","ATL","SFO"].
 * Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"]. 
 * But it is larger in lexical order.
 *
 */
public class ReconstructItinerary implements Solution {
	@Override
	public void test() {
    	ReconstructItinerary test = new ReconstructItinerary();
    	String[][] tickets = new String[][] {
    		{"EZE","TIA"},{"EZE","HBA"},{"AXA","TIA"},{"JFK","AXA"},
    		{"ANU","JFK"},{"ADL","ANU"},{"TIA","AUA"},{"ANU","AUA"},
    		{"ADL","EZE"},{"ADL","EZE"},{"EZE","ADL"},{"AXA","EZE"},
    		{"AUA","AXA"},{"JFK","AXA"},{"AXA","AUA"},{"AUA","ADL"},
    		{"ANU","EZE"},{"TIA","ADL"},{"EZE","ANU"},{"AUA","ANU"}
    	};
    	test.findItinerary(tickets);
	}
	
    public List<String> findItinerary(String[][] tickets) {
        LinkedList<String> list = new LinkedList<>();
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        
        // pre-process
        for(int i=0; i<tickets.length; i++) {
            if(!map.containsKey(tickets[i][0])) {
                ArrayList<String> queue = new ArrayList<>();
                map.put(tickets[i][0], queue);
            }
            map.get(tickets[i][0]).add(tickets[i][1]);
        }
        
        list.add("JFK");
        helper(list, tickets.length+1, map, "JFK");
        return list;
    }
    
    public void helper(LinkedList<String> list, int total, 
    		HashMap<String, ArrayList<String>> map, String from) {
        if(!map.containsKey(from) || map.get(from).isEmpty()) {
            return ;
        }
        String[] arr = map.get(from).toArray(new String[map.get(from).size()]);
        Arrays.sort(arr);
        for(String dest:arr) {
            map.get(from).remove(dest);
            list.add(dest);
            helper(list, total, map, dest);
            if(list.size()==total) {
                return ;
            }
            list.removeLast();
            map.get(from).add(dest);
        }
        
    }
}