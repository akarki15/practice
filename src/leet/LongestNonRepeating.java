package leet;

import java.util.HashSet;

public class LongestNonRepeating {
	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring2("au"));
	}

	public static int lengthOfLongestSubstring2(String s) {
		if (s.length() == 0)
			return 0;

		int longest = 1;
		String sub = "" + s.charAt(0);

		for (int end = 1; end < s.length(); end++) {
			int index = sub.indexOf(s.charAt(end));
			System.out.println(sub + " " + s.charAt(end) + "     " + index);
			if (index != -1) { // sub contains s.charAt(end)
				longest = (sub.length() > longest) ? sub.length() : longest;
				// truncate sub upto the part where the s.charAt(end) repeats
				sub = sub.substring(index + 1, sub.length());
				System.out.println(">>> " + sub);
			}
			sub += s.charAt(end);
		}
		longest = (sub.length() > longest) ? sub.length() : longest;
		return longest;
	}

	// We don't need to look every possible substring
	public static int lengthOfLongestSubstring(String s) {
		if (s.length() == 0)
			return 0;
		int[][] table = new int[s.length() - 1][s.length() - 1];
		// 1 is true, -1 is false, 0 is not evaluated
		int longest = 0;
		for (int i = 0; i < s.length() - 1; i++) {
			for (int j = i; j < s.length() - 1; j++) {
				if (isNonRepeating(s.substring(i, j + 1))) {
					longest = (j - i + 1 > longest) ? j - i + 1 : longest;
				}
			}
		}
		return longest;
	}

	public static boolean isNonRepeating(String s) {
		HashSet<String> set = new HashSet<String>();
		for (int i = 0; i < s.length(); i++) {
			if (set.contains("" + s.charAt(i)))
				return false;
			else
				set.add("" + s.charAt(i));
		}
		return true;
	}
}
