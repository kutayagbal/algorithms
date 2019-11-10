package algorithms.sort.selectionsort;

/*
 * Find the smallest element using a linear scan and move it to the front (swapping it with the front element). 
 * Then, find the second smallest and move it, again doing a linear scan. 
 * Continue doing this until all the elements are in place.
 */
public class SelectionSort {

	public static void main(String... args) {
		int[] arr = { 9, 1, 2, 5, 2, 8, 4, 7, 0 };

		// mySelectionSort(arr);
		selectionSort(arr);

		for (int i : arr) {
			System.out.print(i + ", ");
		}
	}

	static void mySelectionSort(int[] arr) {
		int len = arr.length;

		for (int i = 0; i < len; i++) {
			int smallestIndex = -1;
			int smallest = Integer.MAX_VALUE;

			for (int j = i; j < len; j++) {
				if (arr[j] < smallest) {
					smallestIndex = j;
					smallest = arr[j];
				}
			}

			swap(arr, smallestIndex, i);
		}
	}

	/*
	 * Second loop starts with i+1 because min_index is already set as i at first
	 * loop. So control statement compares starts with comparing i.th element with
	 * (i+1).th element. First loop ends at length-2 because there is one element
	 * after that and it will be compared with this one in second loop.
	 */
	private static void selectionSort(int[] arr) {
		int len = arr.length;

		for (int i = 0; i < len - 1; i++) {
			int min_index = i;

			for (int j = i + 1; j < len; j++) {
				if (arr[j] < arr[min_index])
					min_index = j;
			}

			swap(arr, i, min_index);
		}

	}

	static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
