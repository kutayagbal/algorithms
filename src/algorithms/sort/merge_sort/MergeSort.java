package algorithms.sort.merge_sort;

public class MergeSort {

	public static void main(String[] args) {
		int[] arr = { 9, 1, 2, 5, 2, 8, 4, 7, 0 };

		mergeSort(arr, new int[arr.length], 0, arr.length - 1);

		for (int i : arr) {
			System.out.print(i + ", ");
		}

	}

	public static void mergeSort(int[] arr, int[] temp, int leftStart, int rightEnd) {
		if (leftStart >= rightEnd)
			return;

		int mid = (leftStart + rightEnd) / 2;

		mergeSort(arr, temp, leftStart, mid);
		mergeSort(arr, temp, mid + 1, rightEnd);

		mergeHalves(arr, temp, leftStart, rightEnd);
	}

	public static void mergeHalves(int[] arr, int[] merged, int leftStart, int rightEnd) {
		int leftEnd = (leftStart + rightEnd) / 2;
		int left = leftStart;

		int rightStart = leftEnd + 1;
		int right = rightStart;

		int index = leftStart;

		while (left <= leftEnd && right <= rightEnd) {
			if (arr[left] <= arr[right]) {
				merged[index] = arr[left];
				left++;
			} else {
				merged[index] = arr[right];
				right++;
			}

			index++;
		}

		if (left > leftEnd) {
			System.arraycopy(arr, right, merged, index, rightEnd - right + 1);
		} else {
			System.arraycopy(arr, left, merged, index, leftEnd - left + 1);
		}

		int size = rightEnd - leftStart + 1;
		System.arraycopy(merged, leftStart, arr, leftStart, size);
	}

}
