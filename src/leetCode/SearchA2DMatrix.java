/**
 * 
 */
package leetCode;

/**
 * @author feng
 * https://oj.leetcode.com/problems/search-a-2d-matrix/
 * Write an efficient algorithm that searches for a value in an m x n matrix. 
 * This matrix has the following properties:
 *  1. Integers in each row are sorted from left to right.
 *  2. The first integer of each row is greater than the last integer of the previous row.
 * For example,
 * Consider the following matrix:
 * [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * Given target = 3, return true.
 *
 */
public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int startRow = 0; 
        int endRow = matrix.length - 1;
        
        if(matrix[startRow][0] == target) {
            return true;
        }
        if(matrix[endRow][0] == target) {
            return true;
        }
        if(target < matrix[startRow][0]) {
            return false;
        }
        if(target > matrix[endRow][0]) {
            return searchSortedArray(matrix[endRow], target);
        }
        
        // binary search the right row
        while(startRow < endRow) {
            if(endRow == startRow + 1) {
                break;
            }
            int midRow = (startRow + endRow)/2;
            int midValue = matrix[midRow][0];
            
            if(midValue == target) {
                return true;
            }
            if(midValue > target) {
                endRow = midRow;
                continue;
            } else {
                startRow = midRow;
                continue;
            }
        }
        // binary search in right row
        return searchSortedArray(matrix[startRow], target);
    }
    
    public boolean searchSortedArray(int[] row, int target) {
        if(target < row[0]) {
            return false;
        } else if(target > row[row.length-1]) {
            return false;
        } else {
            int start = 0;
            int end = row.length - 1;
            // check boundary
            if(row[start] == target) {
                return true;
            }
            if(row[end] == target) {
                return true;
            }
            
            // binary search in a sorted array
            while(start < end) {
                if(end == start + 1) {
                    return false;
                }
                
                int mid = (start + end)/2;
                int midValue = row[mid];
                if(midValue == target) {
                    return true;
                }
                
                if(midValue > target) {
                    end = mid;
                    continue;
                } else {
                    start = mid;
                    continue;
                }
            }
        }
        return false;
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
