package leet;

public class ReverseInt {
	public static void main(String[] args) {
		System.out.println(reverse(1534236469));
	}

	public static int reverse(int x) {
		int rev = 0;
		boolean sign = (x >= 0) ? true : false;
		x = (x >= 0) ? x : x * -1;
		while (x > 0) {
			// if there is an int overflow, return 0
			if ((long) (rev) * 10 > Integer.MAX_VALUE)
				return 0;
			rev = rev * 10 + (x - (int) (x / 10) * 10);
			x /= 10;
			System.out.println(x + "\t" + rev);
		}
		return (sign) ? rev : rev * -1;
	}
}
