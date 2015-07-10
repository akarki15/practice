package leet;

public class NumberOfDigitOne {
	public static void main(String[] args) {
		System.out.println(countDigitOne1(1312));

	}

	public static int countDigitOne(int n) {
		int count = 0;
		int i = 12321312;
		
		
		/*for (int m = 10; m <= n; m = m * 10) {
			int a = n / m;
			int b = n % m;
			System.out.println(a + " " + b);
		}*/
		return count;
	}
	
	/*
	def lenDigit(i, total=0):
		if (i < 0):
			return 0 
		else 
			return lenDigit(i / 10) + 1
	*/
	public static int countDigitOne1(int n) {
		int ones = 0;
		for (long m = 1; m <= n; m *= 10)
			ones += (n / m + 8) / 10 * m + (n / m % 10 == 1 ? n % m + 1 : 0);
		return ones;
	}
}

/*
 * 11
 * 
 * 16 1 5, 99,
 */