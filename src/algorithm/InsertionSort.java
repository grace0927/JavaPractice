/**
 * 
 */
package algorithm;

/**
 * @author jianyu
 *
 */
public class InsertionSort {

	private void insertionSort(int[] arr) {
		for(int i=1; i<arr.length; i++) {
			int key = arr[i];
			int j=i-1;
			while(j>0 && arr[j]>key) {
				arr[j+1] = arr[j];
				j--;
			}
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
		int[] arr = {5, 2, 7, 3, 6};
		test.insertionSort(arr);
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]);
			System.out.print(" ");
		}

	}

}
