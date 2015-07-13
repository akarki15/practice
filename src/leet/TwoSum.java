package leet;

import java.util.HashMap;
import java.util.HashSet;

public class TwoSum {
	public static void main(String[] args) {
		int[] numbers = { 2, 7, 11, 15 };
		int target = 17;
		HashSet<Integer> hs = new HashSet<Integer>();
		
		System.out.println(twoSum(numbers, target, 0, 0));
	}
	
	/*public static void twoSum()*/
	// FUCK THIS IS SUBSET SUM NOOOOOT >>>>>>TWO<<<<<< SUM
	public static boolean twoSum(int[] nums, int target, int sum, int index) {
		System.out.println(index + " " + sum);
		if (index > nums.length - 1) {
			return false;
		}

		int newSum = sum + nums[index];
		// include index
		boolean result = false;
		
		if (newSum ==target)
			return true;
		else if (newSum < target) 
			result = twoSum(nums, target, newSum, index + 1);		

		result = result || twoSum(nums, target, sum, index + 1);

		return result;
	}
	
}
