/**
 * 
 */
package com.javapractice.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jianyu
 * https://leetcode.com/problems/course-schedule/
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 * For example:
 * 2, [[1,0]]
 * There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.
 * 2, [[1,0],[0,1]]
 * There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 * The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
 *
 */
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
		for(int i=0; i<prerequisites.length; i++) {
			int cur = prerequisites[i][0];
			if(!map.containsKey(cur)) {
				map.put(cur, new ArrayList<Integer>());
			} 
			map.get(cur).add(prerequisites[i][1]);
		}
		
		boolean[] visit = new boolean[numCourses];
        for(int i=0; i<numCourses; i++) {
			if(hasCircle(visit, i, map)) {
				return false;
			}
		}
		return true;
    }
	
    /*
     * DFS
     */
	public boolean hasCircle(boolean[] visit, int i, HashMap<Integer, ArrayList<Integer>> map) {
		if(visit[i]) {
			return true;
		}
		visit[i] = true;
		if(map.containsKey(i)) {
    		for(Integer course : map.get(i)) {
    			if(hasCircle(visit, course, map)) {
    				return true;
    			}
    		}
		}
		visit[i] = false;
		return false;
    }
	
    /*
     * BFS
     */
	public boolean canFinishBFS(int numCourses, int[][] prerequisites) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
		for(int i=0; i<prerequisites.length; i++) {
			int cur = prerequisites[i][0];
			if(!map.containsKey(cur)) {
				map.put(cur, new ArrayList<Integer>());
			} 
			map.get(cur).add(prerequisites[i][1]);
		}
		
		boolean[] visit = new boolean[numCourses];
        for(int i=0; i<numCourses; i++) {
			if(visit[i]) {
				continue;
			}
			Queue<Integer> queue = new LinkedList<>();
			queue.add(i);
			boolean[] arr = new boolean[numCourses];
			while(!queue.isEmpty()) {
				int node = queue.poll();
				arr[node] = true;
				visit[node] = true;
				if(map.containsKey(node)) {
    				for(Integer course : map.get(node)) {
						if(arr[course]) {
							return false;
						}
    					if(!visit[course]) {
    						queue.add(course);
    					}
    				}
				}
			}
		}
		return true;
    }
}
