package questions;

import com.sun.java.swing.plaf.windows.WindowsTreeUI.ExpandedIcon;

public class LongestPalindrome {
	/*
	 * http://articles.leetcode.com/2011/11/longest-palindromic-substring-part-i.
	 * html
	 */

	public static void main(String[] args) {
		System.out.println(longestPalindrome("yteetywfdsfsserew")) ;
	}

	/* expand around center approach O (n^2)  GOOD */
	static String longestPalindrome(String s) {
		String longest = s.charAt(0) + ""; // base case : a single char is
											// palindromic
		for (int i = 0; i < s.length() - 1; i++) {
			String s1 = expandAroundCenter(s, i, i);
			String s2 = expandAroundCenter(s, i, i + 1);
			System.out.println(s1+"____"+s2);
			if (s1.length() > longest.length())
				longest = s1;
			else if (s2.length() > longest.length())
				longest = s2;
		}
		return longest;
	}

	private static String expandAroundCenter(String s, int i, int j) {
		String output ="";
		if (i==j){
			output = s.charAt(i)+"";
			i--;
			j++;
		}
		
		while (i>=0 &&(j<=s.length()-1)){
			if (s.charAt(i)==s.charAt(j)){
				output = s.charAt(i)+ output+ s.charAt(j);
				i--;j++;
			}else {
				break;
			}
		}
		return output;
	}

	/* BRUTE FORCE SOLUTION. TAKES O (n^3), BAD */
	static String longestPalBF(String s) {
		if (s.length() == 1)
			return s;
		if (isPalindrome(s)) {
			return s;
		} else {
			String s1 = longestPalBF(s.substring(0, s.length() - 1));
			String s2 = longestPalBF(s.substring(1, s.length()));
			// System.out.println("SPLIT "+s+" into " +s.substring(0, s.length()
			// - 1)+" and  "+s.substring(1, s.length()));
			if (s1.length() > s2.length())
				return s1;
			else
				return s2;
		}
	}

	static boolean isPalindrome(String s) {
		boolean b = true;
		int n = s.length();
		for (int i = 0; i <= (n / 2); i++) {
			if (s.charAt(i) != s.charAt(n - 1 - i))
				b = false;
		}
		return b;
	}

}
