package fun;

import java.util.*;

public class TwoSigma2 {
	public static void main(String[] args) {
		String[] d = { "a", "b", "ba", "bca", "bda", "bdca", "bdcad" };
		System.out.println(longest_chain(d));
	}

	static int longest_chain(String[] w) {
		HashSet<String> hashSet = new HashSet<String>(Arrays.asList(w));
		int largest = 0;
		for (int i = 0; i < w.length; i++) {
			if (canReduce(w[i], hashSet) && w[i].length() > largest) {
				largest = w[i].length();
			}
		}
		return largest;
	}

	static boolean canReduce(String s, HashSet<String> hashSet) {
		if (hashSet.contains(s))
			return true;
		else {
			for (int i = 0; i < s.length() - 1; i++) {
				if (canReduce(
						s.substring(0, i) + s.substring(i + 1, s.length()),
						hashSet)) {
					return true;
				}
			}
			return false;
		}
	}
}
