package leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
	public static void main(String[] args) {
		WordBreak wb = new WordBreak();
		Set<String> wordDict = new HashSet();
		String[] s = {"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};
		wordDict.addAll(Arrays.asList(s));
		List<String> result = wb.wordBreak2("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", wordDict);
		for (String r : result) {
			System.out.println(r);
		}
	}

	// BRUTE FORCE (2^n)
	public List<String> wordBreak(String s, Set<String> wordDict) {
		ArrayList<String> result = new ArrayList<String>();
		wordBreak(s, "", wordDict, result);
		return result;
	}

	private void wordBreak(String input, String previous, Set<String> wordDict,
			ArrayList<String> sentenceList) {

		if (input.length() == 0) {
			sentenceList.add(previous);
			return;
		}
		for (int i = 0; i <= input.length(); i++) {
			String word = input.substring(0, i);
			if (wordDict.contains(word)) {
				wordBreak(input.substring(i, input.length()), previous + " "
						+ word, wordDict, sentenceList);
			}
		}
	}

	// SAME METHOD AS ABOVE BUT Memoized to avoid duplicate calcualtion of input
	// string
	HashMap<String, List<String>> table = new HashMap<String, List<String>>();
	
	public List<String> wordBreak2(String s, Set<String> wordDict) {
		
		ArrayList<String> result = new ArrayList<String>();
		wordBreak2(s, "", wordDict, result);
		return result;
	}

	private void wordBreak2(String input, String previous,
			Set<String> wordDict, ArrayList<String> sentenceList) {
		System.out.println(input);
		if (input.length() == 0) {
			sentenceList.add(previous);
			table.put(previous.replaceAll("[\\s\\u00A0]+$", ""), sentenceList);
			return;
		}
		for (int i = 0; i <= input.length(); i++) {
			String word = input.substring(0, i);
			List<String> memoizedResult = table.get(word);
			// Found a memoizedResult
			if (memoizedResult != null) {
				for (String s : memoizedResult) {
					int sizeWord = i + s.length();
					wordBreak2(input.substring(sizeWord, input.length()),
							previous + " " + s, wordDict, sentenceList);
				}
			} else if (wordDict.contains(word)) { // word is a valid and we
													// haven't computed it
													// before
				wordBreak2(input.substring(i, input.length()), previous + " "
						+ word, wordDict, sentenceList);
			}
		}
	}
}
