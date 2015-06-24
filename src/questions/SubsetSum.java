package questions;

public class SubsetSum {
	/* http://www.geeksforgeeks.org/dynamic-programming-subset-sum-problem/ */

	public static void main(String[] args) {
		int[] A = { 7, 3, 5, -1 };
		int sum = 6;
		System.out.println(naiveSum(A, 0, sum));
	}

	/* naive recursive approach TIME IS EXPONENTIAL O (2^n) */
	private static boolean naiveSum(int[] A, int n, int sum) {
		if (A[n] == sum)
			return true;
		else if (n == A.length - 1)
			return false;
		boolean result = naiveSum(A, n + 1, sum);
		if (A[n] < sum) {
			result = result || naiveSum(A, n + 1, sum - A[n]);
		}
		return result;
	}
}
