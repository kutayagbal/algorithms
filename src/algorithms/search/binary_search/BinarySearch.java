package algorithms.search.binary_search;

public class BinarySearch {

	public static void main(String[] args) {
		int[] arr = { 1, 3, 5, 7, 9, 11, 13, 15 };

		System.out.println(binarySearchWithLoop(arr, 11));
		System.out.println(binarySearchRecursive(arr, 11, 0, arr.length - 1));
	}

	public static int binarySearchWithLoop(int[] arr, int x) {
		int left = 0;
		int right = arr.length - 1;
		int mid = -1;

		while (left <= right) {
			mid = (left + right) / 2;

			if (x > arr[mid]) {
				left = mid + 1;
			} else if (x < arr[mid]) {
				right = mid - 1;
			} else {
				return mid;
			}
		}

		return -1;
	}

	public static int binarySearchRecursive(int[] arr, int x, int left, int right) {
		if (left > right)
			return -1;

		int mid = (right + left) / 2;

		if (x > arr[mid]) {
			return binarySearchRecursive(arr, x, mid + 1, right);
		} else if (x < arr[mid]) {
			return binarySearchRecursive(arr, x, left, mid - 1);
		} else {
			return mid;
		}
	}
}
