package review;

// A Comment import java.awt.*; class Base{};
import java.util.Arrays;

class MyRunnable implements Runnable {

	@Override
	public void run() {
		System.out.println("damn son!");
	}
}

public class QuickSort {
	public static void main(String[] args) {

		String s1 = "abc";
		String s2 = "def";
		
		
	}

	private static void quickSort(int[] a, int si, int ei) {
		if (ei > si) {
			int partitionIndex = partition(a, si, ei);
			quickSort(a, si, partitionIndex - 1);
			quickSort(a, partitionIndex + 1, ei);
		}
	}

	private static int partition(int[] a, int si, int ei) {
		while (si < ei) {
			if (a[ei - 1] > a[ei]) {
				swap(a, ei - 1, ei);
				ei--;
			} else {
				swap(a, ei - 1, si);
				si++;
			}
		}
		System.out.println(ei);
		return ei;
	}

	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
