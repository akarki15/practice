package review;

import java.util.Arrays;

import com.sun.org.apache.bcel.internal.generic.SWAP;

public class MergeSort {
	public static void main(String[] args) {
		int[] list = { 2, 3, 1, 34, 2 };
		mergeSort(list, 0, list.length);
		System.out.println(Arrays.toString(list));
	}

	static void mergeSort(int[] list, int left, int right) {
		System.out.println(left + " " + right);
		if (left == right) {
			return;
		}
		int mid = (left + right) / 2;
		mergeSort(list, left, mid);
		mergeSort(list, mid + 1, right);
		merge(list, left, mid, right);
	}

	private static int[] merge(int[] list, int left, int mid, int right) {
		
		int leftPtr = 0;
		int rightPtr = 0;
		int[] newArray = new int[combinedSize];
		for (int i = 0; i < combinedSize; i++) {
			if (leftPtr < leftList.length && rightPtr < rightList.length) {
				if (leftList[leftPtr] < rightList[rightPtr]) {
					newArray[i] = leftList[leftPtr];
					leftPtr++;
				} else {
					newArray[i] = rightList[rightPtr];
					rightPtr++;
				}
			} else if (leftPtr < leftList.length) {
				newArray[i] = leftList[leftPtr];
				leftPtr++;
			} else {
				newArray[i] = rightList[rightPtr];
				rightPtr++;
			}
		}

		return newArray;

	}

	private static void swap(int[] list, int leftSmallest, int rightSmallest) {
		int temp = list[leftSmallest];
		list[leftSmallest] = list[rightSmallest];
		list[rightSmallest] = temp;

	}
}
