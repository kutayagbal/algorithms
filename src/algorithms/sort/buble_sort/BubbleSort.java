package algorithms.sort.buble_sort;

/*
 * Start at the beginning of the array and swap the first two elements if the
 * first is greater than the second. Then, go to the next pair, and so on,
 * continuously making sweeps of the array until it is sorted. In doing so, the
 * smaller items slowly "bubble" up to the beginning of the list.
 */
public class BubbleSort {

	public static void main(String[] args) {
		int[] arr = { 9, 1, 2, 5, 2, 8, 4, 7 };

		bubbleSort(arr);

		for (int i : arr) {
			System.out.print(i + ", ");
		}
	}

	public static void bubbleSort(int[] arr) {
		boolean isSorted = false;

		while (!isSorted) {
			isSorted = true;

			for (int i = 0; i < arr.length - 1; i++) {
				if (arr[i] > arr[i + 1]) {
					swap(arr, i, i + 1);
					isSorted = false;
				}
			}
		}
	}

	private static void swap(int[] arr, int i, int j) {
		// System.out.println("swapping " + arr[i] + " and " + arr[j]);
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}