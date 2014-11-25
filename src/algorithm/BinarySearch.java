/**
 * 
 */
package algorithm;

/**
 * @author feng
 *
 */
public class BinarySearch implements Search {

	// valid only when arr is sorted
	public int binarySearch(int[] arr, int start, int end, int num) {
		if(arr == null || start > end) {
			return 0;
		}
		
		// check if arr is sorted
		for(int i=start+1; i<end; i++) {
			if(arr[i] < arr[i-1]) {
				System.out.println("array from " + start + " to " + end + " not sorted array");
				return 0;
			}
		}
		
		if(num < arr[start]) {
			return -1;
		}
		if(num > arr[end]) {
			return end;
		}
		
		// binary search
		if(end - start <= 1) {
			if(num > arr[end]) {
				return end;
			} else {
				return start;
			}
		} else {
			int mid = (start + end)/2;
			if(arr[mid] < num) {
				return binarySearch(arr, mid, end, num);
			} else {
				return binarySearch(arr, start, mid, num);
			}
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinarySearch test = new BinarySearch();
		int[] arr = {2, 4, 5, 6, 8, 9};
		int res = test.binarySearch(arr, 0, 5, 7);
		System.out.print(res);
	}

}
