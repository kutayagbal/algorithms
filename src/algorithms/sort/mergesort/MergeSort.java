package algorithms.sort.mergesort;

public class MergeSort {

	public static void main(String[] args) {
		int[] arr = { 9, 1, 2, 5, 2, 8, 4, 7, 0 };

		mergeSort(arr);

		for (int i : arr) {
			System.out.print(i + ", ");
		}

	}

	static void mergeSort(int[] arr) {
		int[] helper = new int[arr.length];
		mergeSort(arr, helper, 0, arr.length - 1);
	}

	static void mergeSort(int[] arr, int[] helper, int low, int high) {
		if (low < high) {
			int middle = (low + high) / 2;

			mergeSort(arr, helper, low, middle); // Sort left half

			mergeSort(arr, helper, middle + 1, high); // Sort right half

			merge(arr, helper, low, middle, high);
		}
	}

	static void print(int[] arr) {
		for (int i : arr) {
			System.out.print(i + ", ");
		}
		System.out.println();
	}

	static void merge(int[] arr, int[] helper, int low, int middle, int high) {
		// Copy both halves into a helper array.
		for (int i = low; i <= high; i++) {
			helper[i] = arr[i];
		}

		int helperLeft = low;
		int helperRight = middle + 1;
		int current = low;

		/*
		 * Iterate through helper array. Compare the left and right half, copying back
		 * the smaller elementfrom the two halves into the original array.
		 */
		while (helperLeft <= middle && helperRight <= high) {
			if (helper[helperLeft] <= helper[helperRight]) {
				arr[current] = helper[helperLeft];
				helperLeft++;
			} else {
				arr[current] = helper[helperRight];
				helperRight++;
			}

			current++;
		}

		/* Copy the rest of the left side of the array into the target array. */
		int remaining = middle - helperLeft;
		for (int i = 0; i <= remaining; i++) {
			arr[current + i] = helper[helperLeft + i];
		}
	}

}
