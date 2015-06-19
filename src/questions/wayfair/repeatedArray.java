package questions.wayfair;

import java.util.HashSet;

// Given an array where each element is repeated twice except for one element,
// find that element.

//O(n) time, O(n) space
public class repeatedArray {
	public static void main(String[] args) {
		int[] input = {1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5,7 };
		findNonRepeatingElement(input);
	}

	private static void findNonRepeatingElement(int[] input) {
		HashSet <Integer> hset = new HashSet<Integer>();
		HashSet <Integer> hset2 = new HashSet<Integer>();
		for (int i : input) {
			if (hset2.contains(i)){
				hset2.remove(i);
				hset.add(i);
			} else if (!hset.contains(i)){
				hset2.add(i);
			}			
		}
		for(int i: hset2){
			System.out.println(i);
		}
	}
}
