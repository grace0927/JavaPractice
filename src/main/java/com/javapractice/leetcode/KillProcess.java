/**
 *
 */
package com.javapractice.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Jianyu Feng
 * https://leetcode.com/problems/kill-process/
 * Given n processes, each process has a unique PID (process id) and its PPID (parent process id).
 * Each process only has one parent process, but may have one or more children processes.
 * This is just like a tree structure. Only one process has PPID that is 0,
 * which means this process has no parent process. All the PIDs will be distinct positive integers.
 * We use two list of integers to represent a list of processes,
 * where the first list contains PID for each process and the second list contains the corresponding PPID.
 * Now given the two lists, and a PID representing a process you want to kill,
 * return a list of PIDs of processes that will be killed in the end.
 * You should assume that when a process is killed, all its children processes will be killed.
 * No order is required for the final answer.
 * Example 1:
 * Input:
 * pid =  [1, 3, 10, 5]
 * ppid = [3, 0, 5, 3]
 * kill = 5
 * Output: [5,10]
 * Explanation:
 *            3
 *          /   \
 *         1     5
 *              /
 *             10
 * Kill 5 will also kill 10.
 * Note:
 * The given kill id is guaranteed to be one of the given PIDs.
 * n >= 1.
 *
 */
public class KillProcess {
	public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
		HashMap<Integer, List<Integer>> map = buildMap(pid, ppid);
		List<Integer> list = new ArrayList<>();

		Queue<Integer> bfs = new LinkedList<>();
		bfs.add(kill);

		while (!bfs.isEmpty()) {
			int parent = bfs.poll();
			list.add(parent);

			if (map.containsKey(parent)) {
				for (int child:map.get(parent)) {
					if (!list.contains(child)) {
						bfs.add(child);
					}
				}
			}
		}

		return list;
	}

	protected HashMap<Integer, List<Integer>> buildMap(List<Integer> pid, List<Integer> ppid) {
		HashMap<Integer, List<Integer>> map = new HashMap<>();

		for (int i=0; i<pid.size(); i++) {
			int child=pid.get(i), parent=ppid.get(i);

			if (!map.containsKey(parent)) {
				map.put(parent, new ArrayList<>());
			}

			map.get(parent).add(child);
		}

		return map;
	}
}
