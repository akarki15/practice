package questions;

/*
 * http://www.geeksforgeeks.org/how-to-print-maximum-number-of-a-using-given-four
 * -keys/
 */
public class MaxNumAs {
	static int[] table;

	public static void main(String[] args) {
		for (int n = 1; n <= 20; n++) {
			table = new int[n + 1];
			System.out.println(findMax(n));
		}
	}

	static int findMax(int n) {
		if (n <= 6)
			return n;
		int option1 = 2 * findMax(n - 3); // select, copy & paste
		int option2 = findMax(n - 1) + 1; // type "A"
		int option3 = 3 * findMax(n - 4); // Paste again
		return Math.max(Math.max(option1, option2), option3);
	}

}
