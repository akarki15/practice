package questions;

import java.util.Arrays;
import java.util.HashMap;

public class PythagoreanTriplet {
	public static void main(String[] args) {
		int[] input = { 3, 1, 4, 6, 5 };		
		Arrays.sort(input);
		System.out.println(findTriplet(input));				
	}

	private static boolean findTriplet(int[] input) {
		if (input.length < 3)
			return false;
		HashMap<Integer, Integer> hm = new HashMap<>();
		for (int i : input) {
			hm.put(i * i, i);
		}

		for (int i = input.length-1; i >=0; i--) {
			int sum = input[i]*input[i];
			for (int j=i-1;j>1;j--){
				int num = input[j]*input[j];
				if (hm.get(sum-num)!=null){
					System.out.println("Triplets: " + sum +" , "+ num +" , "+ (sum-num));
					return true;					
				}
			}
		}
		return false;
	}

	// returns whether a pair of ints exists between the start and the end index
	// of the list which add upto sum
	private static boolean pairExists(int[] list, int start, int end, int sum) {
		HashMap<Integer, Integer> map = new HashMap<>();
		if ((end-start+1)<2){			
			return false; }
		for(int i = start; i<=end;i++){
			int num = list[i];			
			if (map.get(sum-num)!=null)
				return true;
			else 
				map.put(num, num);
		}
		return false; 
	}

}
