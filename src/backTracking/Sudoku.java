package backTracking;

/* http://www.geeksforgeeks.org/backtracking-set-7-suduku/ */

public class Sudoku {

	private static int N=9;
	
	private void printSudoku(int[][] graph) {
		System.out.println("Solution Exists:");
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(graph[i][j]);
				System.out.print(" ");
			}
			System.out.print("\n");
		}
	}
	
	private boolean isSafe(int[][] graph, int col, int row, int num) {
		
		for(int i=0; i<N; i++) {
			if(graph[i][col] == num) {
				return false;
			}
		}
		
		for(int j=0; j<N; j++) {
			if(graph[row][j] == num) {
				return false;
			}
		}
		
		int boxCol = col%3;
		int boxRow = row%3;
		
		if(boxCol == 0) {
			if(boxRow == 0) {
				if(graph[row+1][col+1] == num || graph[row+1][col+2] == num || graph[row+2][col+1] == num || 
						graph[row+2][col+2] == num) {
					return false;
				}
			} else if(boxRow == 1) {
				if(graph[row-1][col+1] == num || graph[row-1][col+2] == num || graph[row+1][col+1] == num || 
						graph[row+1][col+2] == num) {
					return false;
				}
			} else {
				if(graph[row-1][col+1] == num || graph[row-1][col+2] == num || graph[row-2][col+1] == num || 
						graph[row-2][col+2] == num) {
					return false;
				}
			}
		} else if(boxCol == 1) {
			if(boxRow == 0) {
				if(graph[row+1][col-1] == num || graph[row+1][col+1] == num || graph[row+2][col-1] == num || 
						graph[row+2][col+1] == num) {
					return false;
				}
			} else if(boxRow == 1) {
				if(graph[row-1][col-1] == num || graph[row-1][col+1] == num || graph[row+1][col-1] == num || 
						graph[row+1][col+1] == num) {
					return false;
				}
			} else {
				if(graph[row-1][col-1] == num || graph[row-1][col+1] == num || graph[row-2][col-1] == num || 
						graph[row-2][col+1] == num) {
					return false;
				}
			}
		} else {
			if(boxRow == 0) {
				if(graph[row+1][col-1] == num || graph[row+1][col-2] == num || graph[row+2][col-1] == num || 
						graph[row+2][col-2] == num) {
					return false;
				}
			} else if(boxRow == 1) {
				if(graph[row-1][col-1] == num || graph[row-1][col-2] == num || graph[row+1][col-1] == num || 
						graph[row+1][col-2] == num) {
					return false;
				}
			} else {
				if(graph[row-1][col-1] == num || graph[row-1][col-2] == num || graph[row-2][col-1] == num || 
						graph[row-2][col-2] == num) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	private boolean sudokuUtil(int[][] graph) {
		int col=0;
		int row=0;
		
		for(row=0; row<N; row++) {
			for(col=0; col<N; col++) {
				if(graph[row][col] == 0) {
					break;
				}
			}
			if(graph[row][col] == 0) {
				break;
			}
		}

		if(row == N-1 && col == N-1 && graph[row][col] != 0) {
			return true;
		}
		
		for(int num=1; num<N; num++) {
			System.out.print(row);
			System.out.print(" ");
			System.out.print(col);
			System.out.print("\n");
			if(isSafe(graph, col, row, num)) {
				graph[row][col]=num;
				if(sudokuUtil(graph)) {
					printSudoku(graph);
					return true;
				} else {
					graph[row][col] = 0;
				}
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		int[][] graph = {{3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}};
		
		Sudoku test = new Sudoku();
		test.sudokuUtil(graph);

	}

}
