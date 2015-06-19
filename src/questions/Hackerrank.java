package questions;

import java.util.ArrayList;
import java.util.Collections;

/* Algorithm to find integer X such that product of its digits is input N */

/*
 * http://stackoverflow.com/questions/21403720/algorithm-to-find-integer-such-that
 * -product-of-its-digits-is-n
 */public class Hackerrank {
	public static void main(String[] args) {
		System.out.println(getXNumber(2520));
	}

	static String getXNumber(int n) {
		ArrayList<Integer> factors = factorize(n);
		ArrayList<Integer> digits = new ArrayList<>();
		int runningProduct = 1;
		for (int f : factors) {
			// if the no. of digits>1, stop the runningproduct
			int numDigitsF = (int) (Math.log10(f) + 1);
			// if a prime factor has more than one digit return -1
			if (numDigitsF > 1)
				return (-1) + "";
			int numDigits = (int) (Math.log10(runningProduct * f) + 1);

			if (numDigits > 1) {
				digits.add(runningProduct);
				runningProduct = f;
			} else {
				runningProduct *= f;
			}
		}
		digits.add(runningProduct);
		Collections.sort(digits);
		int output = 0;
		int count = 0;

		for (int i = digits.size() - 1; i >= 0; i--) {
			output += digits.get(i) * Math.pow(10, count++);
		}

		return output + "";
	}

	static ArrayList<Integer> factorize(int input) {
		ArrayList<Integer> factors = new ArrayList<>();
		for (int i = 2; i <= input / i; i++) {
			while (input % i == 0) {

				factors.add(i);
				input = input / i;
			}
		}
		if (input > 1)
			factors.add(input);
		return factors;
	}
}
