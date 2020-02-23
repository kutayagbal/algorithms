package algorithms.sort.selection_sort;

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

	private static void selectionSort(int[] arr) {
		int minIndex = 0;

		for (int i = 0; i < arr.length - 1; i++) {
			minIndex = i;

			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[minIndex])
					minIndex = j;
			}

			if (minIndex != i)
				swap(arr, i, minIndex);
		}
	}

	private static void swap(int[] arr, int i, int j) {
		// System.out.println("swapping " + arr[i] + " and " + arr[j]);
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
