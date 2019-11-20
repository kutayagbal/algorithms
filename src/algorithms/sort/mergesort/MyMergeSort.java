package algorithms.sort.mergesort;

public class MyMergeSort {

	public static void main(String[] args) {
		int[] arr = { 9, 1, 2, 5, 2, 8, 4, 7, 0 };

		arr = mergeSort(arr);

		for (int i : arr) {
			System.out.print(i + ", ");
		}
	}

	static int[] mergeSort(int[] arr) {
		return mergeSort(arr, 0, arr.length - 1);
	}

	static int[] mergeSort(int[] arr, int low, int high) {
		int[] mergedArr = new int[high - low];

		if (low < high) {
			int mid = (low + high) / 2;

			int[] leftArr = mergeSort(arr, low, mid);
			int[] rightArr = mergeSort(arr, mid + 1, high);

			mergedArr = merge(leftArr, rightArr);
		} else {
			return new int[] { arr[low] };
		}

		return mergedArr;
	}

	static int[] merge(int[] leftArr, int[] rightArr) {
		int rightSize = rightArr.length;
		int leftSize = leftArr.length;

		int[] mergedArr = new int[rightSize + leftSize];

		int mergeIndex = 0;
		int leftIndex = 0;
		int rightIndex = 0;
		while (rightIndex < rightSize && leftIndex < leftSize) {
			if (leftArr[leftIndex] < rightArr[rightIndex]) {
				mergedArr[mergeIndex] = leftArr[leftIndex];
				leftIndex++;
			} else {
				mergedArr[mergeIndex] = rightArr[rightIndex];
				rightIndex++;
			}

			mergeIndex++;
		}

		if (rightIndex >= rightSize) {
			// copy remaining in left arr
			System.arraycopy(leftArr, leftIndex, mergedArr, mergeIndex, rightSize + leftSize - mergeIndex);
		} else if (leftIndex >= leftSize) {
			// copy remaining in right arr
			System.arraycopy(rightArr, rightIndex, mergedArr, mergeIndex, rightSize + leftSize - mergeIndex);
		}

		return mergedArr;
	}

	static void print(int[] arr) {
		for (int i : arr) {
			System.out.print(i + ", ");
		}
		System.out.println();
	}

}
