package backTracking;

public class Coloring {

	/* define size of Vertices */
	private static int V = 4;
	
	private void printSolution(int color[]) {
		System.out.println("Solution Exists:");
		System.out.println("Following are the assigned colors");
		for(int i=0; i<V; i++){
			System.out.printf("%d", color[i]);
		}
		System.out.println("\n");
	}
	
	/* A utility function to check if the current color assignment
	 * is safe for vertex v */
	private boolean isSafe(int v, boolean[][] graph, int[] color, int c) {
		for(int i=0; i<V; i++) {
			if(graph[v][i]==true && c==color[i]) {
				return false;
			}
		}
		return true;
	}
	
	/* A recursive utility function to solve m coloring problem */
	private boolean graphColoringUtil(boolean[][] graph, int m, int[] color, int v) {
		/* base case: If all vertices are assigned a color then
		 * return true */
		if(v == V) {
			return true;
		}
		
		/* Consider this vertex v and try different colors */
		for(int c=1; c<m; c++) {
			if(isSafe(v, graph, color, c)) {
				color[v] = c;
				
				/* recur to assign colors to rest of the vertices */
				if(graphColoringUtil(graph, m, color, v+1) == true) {
					return true;
				}
				
				/* If assigning color c doesn't lead to a solution
	               then remove it */
				color[v] = 0;
			}
		}
		
		/* If no color can be assigned to this vertex then return false */
		return false;
	}
	
	/* This function solves the m Coloring problem using Backtracking.
	 * It mainly uses graphColoringUtil() to solve the problem. It returns
	 * false if the m colors cannot be assigned, otherwise return true and
	 * prints assignments of colors to all vertices. Please note that there
	 * may be more than one solutions, this function prints one of the
	 * feasible solutions.*/
	private boolean graphColoring(boolean graph[][], int m) {
		/* Initialize all color values as 0. This initialization is needed
		 * correct functioning of isSafe() */
		int[] color = new int[V];
		for(int i=0; i<V; i++) {
			color[i] = 0;
		}
		
		// Call graphColoringUtil() for vertex 0
		if(graphColoringUtil(graph, m, color, 0) == false) {
			System.out.println("Solution not found");
			return false;
		}
		
		// Print the solution
		printSolution(color);
		return true;
	}
	
	public static void main(String[] args) {
		/* Create following graph and test whether it is 3 colorable
	      (3)---(2)
	       |   / |
	       |  /  |
	       | /   |
	      (0)---(1)
	    */
		boolean[][] graph = {{false, true, true, true},
		        {true, false, true, false},
		        {true, true, false, true},
		        {true, false, true, false},
		    };
		int m = 3;
		Coloring test = new Coloring();
		test.graphColoring(graph, m+1);
	}

}
