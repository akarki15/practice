package questions;

/*
 * Build Lowest Number by Removing n digits from a given number Given a string
 * ‘str’ of digits and an integer ‘n’, build the lowest possible number by
 * removing ‘n’ digits from the string and not changing the order of input
 * digits.
 * 
 * Examples:
 * 
 * Input: str = "4325043", n = 3 Output: "2043"
 * 
 * Input: str = "765028321", n = 5 Output: "0221"
 * 
 * Input: str = "121198", n = 2 Output: "1118"
 */
public class BuildLowestNumberByRemovingN {
	public static void main(String[] args) {
		String str = "121198";
		int n = 2;
		build(str, 0, n-1, "", n);
	}

	private static void build(String s, int i, int j, String build, int count) {
		System.out.println(i + " , " + j);
		if (count == 0) {
			System.out.println(build + s.charAt(i));
			return;
		}

		int min = findMin(s, i, j);
		build += s.charAt(min);
		s = s.substring(0, min) + "-" + s.substring(min + 1, s.length());
		build(s, min + 1, j + 1, build, count-1);
	}

	// finds the minimum between i and j index (both inclusive)
	static int findMin(String s, int i, int j) {

		int minIndex = i;
		i++;
		for (; i <= j; i++) {
			if (s.charAt(i) != '-') {
				int min = Integer.parseInt("" + s.charAt(minIndex));
				int num = Integer.parseInt("" + s.charAt(i));
				if (num < min) {
					minIndex = i;
				}
			}
		}		
		System.out.println(minIndex);
		return minIndex;
	}
}
