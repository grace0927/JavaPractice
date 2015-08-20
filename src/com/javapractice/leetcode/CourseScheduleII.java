/**
 * 
 */
package com.javapractice.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jianyu
 * https://leetcode.com/problems/course-schedule-ii/
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 * Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.
 * There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.
 * For example:
 * 2, [[1,0]]
 * There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1]
 * 4, [[1,0],[2,0],[3,1],[3,2]]
 * There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. 
 * So one correct course order is [0,1,2,3]. Another correct ordering is[0,2,1,3].
 * The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
 *
 */
public class CourseScheduleII {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
        // build edge map
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int i=0; i<prerequisites.length; i++) {
            if(!map.containsKey(prerequisites[i][0])) {
                map.put(prerequisites[i][0], new ArrayList<Integer>());
            }
            map.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        
        // using BFS
        boolean[] visit = new boolean[numCourses];
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<numCourses; i++) {
			if(visit[i]) {
				continue;
			}
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            boolean[] arr = new boolean[numCourses];
            ArrayList<Integer> temp = new ArrayList<>();
            while(!queue.isEmpty()) {
                Integer node = queue.poll();
				arr[node] = true;
                visit[node] = true;
                temp.add(0, node);
                if(map.containsKey(node)) {
                    for(Integer course : map.get(node)) {
                        if(arr[course]) {
                            return new int[0];
                        }
                        if(!visit[course]) {
                            queue.add(course);
                        }
                    }
                }
            }
            list.addAll(temp);
        }
        
        // convert to int array
        int[] res = new int[numCourses];
        Iterator<Integer> iterator = list.iterator();
        for(int i=0, j=0; i<list.size(); i++) {
            int cur = iterator.next().intValue();
            if(j==0) {
                res[j] = cur;
                j++;
            } else if(cur != res[j-1]) {
                res[j] = cur;
                j++;
            }
        }
        return res;
    }
}
