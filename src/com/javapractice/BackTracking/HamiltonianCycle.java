package com.javapractice.BackTracking;

/* http://www.geeksforgeeks.org/backtracking-set-7-hamiltonian-cycle/*/

public class HamiltonianCycle {

	private static int V = 5;
	
	/* A utility function to print solution */
	private void printSolution(int[] path) {
		System.out.println("Solution Exists:");
		System.out.println("Following is one Hamiltonian Cycle");
		for(int i=0; i<V; i++) {
			System.out.print(path[i]);
		}
		System.out.print(path[0] + "\n");
	}
	
	/* A utility function to check if the vertex v can be added at index 'pos'
	 * in the Hamiltonian Cycle constructed so far (stored in 'path[]') */
	private boolean isSafe(int v, boolean[][] graph, int[] path, int pos) {
		/* Check if this vertex is an adjacent vertex of the previously
		 * added vertex. */
		if(graph[v][path[pos-1]] == false) {
			return false;
		}
		
		/* Check if the vertex has already been included.
		 * This step can be optimized by creating an array of size V */
		for(int i=0; i<pos; i++) {
			if(path[i] == v) {
				return false;
			}
		}
		
		return true;
	}
	
	/* A recursive utility function to solve hamiltonian cycle problem */
	private boolean hamCycleUtil(boolean[][] graph, int[] path, int pos) {
		/* base case: If all vertices are included in Hamiltonian Cycle */
		if(pos == V) {
			/* And if there is an edge from the last included vertex to the 
			 * first vertex */
			if(graph[path[pos-1]][path[0]] == true) {
				return true;
			} else {
				return false;
			}
		}
		
		/* Try different vertices as a next candidate in Hamiltonian Cycle */
		for(int v=1; v<V; v++) {
			/* Check if this vertex can be added to Hamiltonian Cycle */
			if(isSafe(v, graph, path, pos)) {
				path[pos] = v;
				/* recur to construct rest of the path */
				if(hamCycleUtil(graph, path, pos+1) == true) {
					return true;
				}
				/* If adding vertex v doesn't lead to a solution,
				 * then remove it */
				path[pos] = -1;
			}
		}
		
		/* If no vertex can be added to Hamiltonian Cycle constructed so far,
		 * then return false */
		return false;
	}
	
	/* This function solves the Hamiltonian Cycle problem using Backtracking.
	 * It mainly uses hamCycleUtil() to solve the problem. It returns false
	 * if there is no Hamiltonian Cycle possible, otherwise return true and
	 * prints the path. Please note that there may be more than one solutions,
	 * this function prints one of the feasible solutions. */
	private boolean hamCycle(boolean[][] graph) {
		int[] path = new int[V];
		for(int i=0; i<V; i++) {
			path[i] = -1;
		}
		
		/* Let us put vertex 0 as the first vertex in the path. If there is
		 * a Hamiltonian Cycle, then the path can be started from any point
		 * of the cycle as the graph is undirected */
		path[0]=0;
		if(hamCycleUtil(graph, path, 1) == false) {
			System.out.println("Solution no found");
			return false;
		}
		
		printSolution(path);
		return true;
	}
	
	public static void main(String[] args) {
		boolean[][] graph = {{true, true, false, true, false},
                {true, true, true, true, true},
                {false, true, true, false, true},
                {true, true, false, true, true},
                {false, true, true, true, true},
               };
		
		HamiltonianCycle test = new HamiltonianCycle();
		test.hamCycle(graph);

	}

}
