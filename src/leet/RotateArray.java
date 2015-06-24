package leet;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class RotateArray {
	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8 };
		rotate(array, 2);
		System.out.println(Arrays.toString(array));
	}

	public static void rotate(int[] nums, int k) {
		if (k < 1 || k > nums.length - 1)
			return;
		int outer = (nums.length % k == 0) ? k : 1;
		int inner = (nums.length % k == 0) ? nums.length / k : nums.length;

		int counter = 0;
		for (int p = 0; p < outer; p++) {
			int buffer;
			int pos = p;
			buffer = nums[p];
			for (int i = 0; i < inner; i++) {
				System.out.println("\t" + counter++);
				pos = (pos + k) % (nums.length);
				int temp = nums[pos];
				nums[pos] = buffer;
				buffer = temp;

			}
		}
	}
}

