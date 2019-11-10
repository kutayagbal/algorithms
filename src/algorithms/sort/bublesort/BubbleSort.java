package algorithms.sort.bublesort;

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
		// myBubbleSort(arr);

		for (int i : arr) {
			System.out.print(i + ", ");
		}
	}

	static void myBubbleSort(int[] arr) {
		int index = 0;
		int len = arr.length;
		while (index + 1 < len) {
			if (index < 0) {
				index = 0;
			}

			if (arr[index] > arr[index + 1]) {
				swap(arr, index, index + 1);
				index--;
			} else {
				index++;
			}
		}
	}

	/*
	 * First loop goes to length-1. Because control statement compares i and i+1
	 * elements. So for lenght-2 the last element will be reached as i+1. Second for
	 * loop goes to (length-1-i). Because for every cycle of the first for loop, one
	 * element will be brought to the rightmost correct position. There is no need
	 * to look at that rightmost i positions again. So second loop goes to
	 * length-1-i instead of length-1.
	 */
	public static void bubbleSort(int arr[]) {
		int len = arr.length;
		for (int i = 0; i < len - 1; i++) {
			for (int j = 0; j < len - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					swap(arr, j, j + 1);
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