package questions;

import java.util.HashSet;

public class DistinctPermutation {
	public static void main(String[] args) {
		String input = "ABCA";
		permutate(input, "");
	}

	// This recursive method is exactly like generating permutation
	// except now the recursive calls are made for only the unique letters

	private static void permutate(String input, String builder) {
		if (input.length() == 0) {
			System.out.println(builder);
			return;
		}
		HashSet<String> uniqueLetters = getUniqueLetters(input);
		for (int i = 0; i < input.length(); i++) {
			String s = "" + input.charAt(i);
			if (uniqueLetters.contains("" + s)) {
				String s1 = input.substring(0, i)
						+ input.substring(i + 1, input.length());
				permutate(s1, builder + "" + s);
				uniqueLetters.remove(s);
			}
		}
	}

	// Returns a hashset with just the unique letter
	private static HashSet<String> getUniqueLetters(String input) {
		HashSet<String> set = new HashSet<String>();
		for (int i = 0; i < input.length(); i++)
			if (!set.contains("" + input.charAt(i))) {
				set.add("" + input.charAt(i));
			}
		return set;
	}
}
