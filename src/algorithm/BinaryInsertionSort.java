package algorithm;

/**
 * 
 */

/**
 * @author feng
 *
 */
public class BinaryInsertionSort extends BinarySearch implements Search, Sort {

	public void sort(int[] arr) {
		if(arr == null) {
			return;
		}
		int size = arr.length;
		if(size == 1) {
			return;
		}
		for(int i=1; i<size; i++) {
			int key = arr[i];
			try{
				int index = binarySearch(arr, 0, i-1, key) + 1;
				for(int k=i; k>index; k--) {
					arr[k] = arr[k-1];
				}
				arr[index] = key;
			} catch(Exception e) {
				System.out.println("Exception thrown  :" + e.getMessage());
			}
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Sort test = new BinaryInsertionSort();
		int[] arr = {5, 2, 4, 6, 1, 3};
		test.sort(arr);
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]);
			System.out.print(" ");
		}
	}
}
