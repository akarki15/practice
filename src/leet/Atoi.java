package leet;

// Not accepted but just matter of finding out the cases. e.g. +-2 should not be
// processed and becomes 0. BS i say
public class Atoi {
	public static void main(String[] args) {
		System.out.println(myAtoi("+-2"));

	}

	public static int myAtoi(String str) {
		int num = 0;
		boolean sign = true;
		boolean start = false;
		int startIndex = 0;
		int i = 0;
		for (; i < str.length(); i++) {
			if (!start) {
				if (str.charAt(i) == '-')
					sign = false;
				else if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
					start = true;
					startIndex = i;
				}
			}
			if (start) {
				if (str.charAt(i) == '.') {
					break;
				}
				num = num * 10 + (str.charAt(i) - '0');
			}
		}

		num *= sign ? 1 : -1;
		return num;
	}
}
