/**
 *
 */
package com.javapractice.leetcode;

/**
 * @author Jianyu Feng
 * https://leetcode.com/problems/count-numbers-with-unique-digits/
 * Given a non-negative integer n, count all numbers with unique digits, x,
 * where 0 ≤ x < 10n.
 *
 */
public class QueueReconstructionByHeight {
	public int[][] reconstructQueue(int[][] people) {
		if(people.length==0) {
			return people;
		}

		PriorityQueue<Integer[]> minHeap = new PriorityQueue<>(people.length, new Comparator<Integer[]>() {
			public int compare(Integer[] a, Integer[] b) {
				return a[1]!=b[1] ? a[1]-b[1] : a[0]-b[0];
			}
		});

		for (int i=0; i<people.length; i++) {
			minHeap.add(new Integer[] {people[i][0], people[i][1]});
		}

		LinkedList<Integer[]> list = new LinkedList<>();
		while(!minHeap.isEmpty()) {
			insert(list, minHeap.poll());
		}

		return convertToArray(list);
	}

	public void insert(LinkedList<Integer[]> list, Integer[] node) {
		int count=0, index=list.size();

		for(int i=0; i<list.size(); i++) {
			if(list.get(i)[0] >= node[0]) {
				count++;
			}
			if(count > node[1]) {
				index = i;
				break;
			}
		}

		list.add(index, node);
	}

	public int[][] convertToArray(LinkedList<Integer[]> list) {
		int[][] array = new int[list.size()][2];

		for(int i=0; i<list.size(); i++) {
			array[i][0] = list.get(i)[0];
			array[i][1] = list.get(i)[1];
		}

		return array;
	}

	// https://discuss.leetcode.com/topic/60394/easy-concept-with-python-c-java-solution/4
	public int[][] reconstructQueue(int[][] people) {
		//pick up the tallest guy first
		//when insert the next tall guy, just need to insert him into kth position
		//repeat until all people are inserted into list
		Arrays.sort(people,new Comparator<int[]>(){
		   @Override
		   public int compare(int[] o1, int[] o2){
			   return o1[0]!=o2[0]?-o1[0]+o2[0]:o1[1]-o2[1];
		   }
		});

		List<int[]> res = new LinkedList<>();
		for(int[] cur : people){
			res.add(cur[1],cur);
		}

		return res.toArray(new int[people.length][]);
	}
}
