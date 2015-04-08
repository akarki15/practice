package questions;

import java.util.Arrays;

public class PathsInMatrix {
	public static void main(String[] args) {
		int[][] A = { { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 0, 1, 1 },
				{ 1, 1, 1, 1 } };
		findPaths(A);
	}

	static void findPaths(int[][] A) {
		int[][] table = new int[A.length + 1][A.length + 1];

		for (int i = 0; i < table.length; i++) {
			table[0][i] = 0;
			table[i][0] = 0;
		}

		for (int i = 1; i < table.length; i++) {
			for (int j = 1; j < table.length; j++) {
				int left = table[i][j - 1] * A[i - 1][j - 1];
				int right = table[i - 1][j] * A[i - 1][j - 1];
				if (i == 1 && j == 1)
					table[i][j] = 1;// start at (1,1)
				else if (i == 0) {
					table[i][j] = left;
				} else if (j == 0) {
					table[i][j] = right;
				} else
					table[i][j] = left + right;
			}
		}
		System.out.println(Arrays.deepToString(table));
	}
	
}
