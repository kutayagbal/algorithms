package algorithms.sort.quick_sort;

public class QuickSort {

	public static void main(String[] args) {
		int[] arr = { 9, 1, 2, 5, 2, 8, 4, 7, 0 };

		quickSort(arr, 0, arr.length - 1);

		for (int i : arr)
			System.out.print(i + ", ");
	}

	private static void quickSort(int[] arr, int left, int right) {
		if (left >= right)
			return;

		int pivot = arr[(left + right) / 2];

		int index = partition(arr, left, right, pivot);// returns the division point

		quickSort(arr, left, index - 1);
		quickSort(arr, index, right);
	}

	private static int partition(int[] arr, int left, int right, int pivot) {
		while (left <= right) {
			while (arr[left] < pivot)
				left++;

			while (arr[right] > pivot)
				right--;

			if (left <= right) {
				swap(arr, left, right);
				left++;
				right--;
			}
		}

		return left;
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
