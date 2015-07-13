package leet;

public class PalindromeNumber {
	public static void main(String[] args) {
		System.out.println(isPalindrome(-2147447412));
	}

	public static boolean isPalindrome(int i) {
		if (i<0) return false;
		int input = i; 
		int rev = 0;
		while (i > 0) {
			rev = rev * 10 + (i % 10);
			i /= 10;
		}
		if (rev == input)
			return true; 
		else 
			return false;
	}

	// 3443
	// Didn't work. Tried to check first and last digit (Like checking string
	// palindrome)
	public static boolean isPalindrome1(int x) {
		// detect overflows
		if ((long) x >= Integer.MAX_VALUE || (long) x <= Integer.MIN_VALUE
				|| Double.isNaN(Math.log10(x)))
			return false;

		int len = (int) Math.log10(x) + 1; // len of int x
		for (int i = 1; i <= len / 2; i++) {
			System.out.println(x);
			int last = (x - ((int) (x / 10)) * 10);
			int first = x / ((int) Math.pow(10, len - i));

			System.out.println(last + " , " + first);

			if (last != first)
				return false;

			// Truncate first and last digits and update len
			x %= (int) Math.pow(10, len - i); // truncate first
			x /= 10; // truncate last
			int prevLen = len;
			len = (int) Math.log10(x) + 1; // update len

			if (prevLen - 2 != len) // indicates preceeding zeroes after
									// truncation
				return false;
		}
		return true;
	}
}
