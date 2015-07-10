package leet;

public class Atoi {
	public static void main(String[] args) {
		System.out.println(myAtoi("-2342.26"));
			
	}

	public static int myAtoi(String str) {
		int num = 0;
		boolean sign = true;
		boolean start = false;

		for (int i = 0; i < str.length(); i++) {
			if (!start) {
				if (str.charAt(i) == '-')
					sign = false;
				else if (str.charAt(i) >= '0' && str.charAt(i) <= '9')
					start = true;
			}
			if (start) {
				if (str.charAt(i) == '.') {
					break;
				}
				num += Math.pow(10, i) * (str.charAt(i) - '0');
			}
		}
		System.out.println(num);
		int revNum = 0;
		int count = 0;
		while (num > 0) {
			int temp = ((int) (num / 10)) * 10;
			revNum += (num - temp) * Math.pow(10, count++);
			num = num / 10;
		}
		revNum *= sign ? 1 : -1;
		return revNum;
	}
}
