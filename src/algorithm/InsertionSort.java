/**
 * 
 */
package algorithm;

/**
 * @author jianyu
 *
 */
public class InsertionSort implements Sort {
	public void sort(int[] arr) {
		for(int i=1; i<arr.length; i++) {
			int key = arr[i]; // get current key
			int j = i-1;
			
			// check forwarded
			while(j > 0 && arr[j] > key) {
				arr[j+1] = arr[j];
				j--;
			}
			
			// last key
			if(arr[j]>key) {
				arr[j+1] = arr[j];
				arr[j] = key;
			} else {
				arr[j+1] = key;
			}
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		InsertionSort test = new InsertionSort();
		int[] arr = {5, 2, 4, 6, 1, 3};
		test.sort(arr);
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]);
			System.out.print(" ");
		}
	}

}
