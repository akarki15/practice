package leet;

public class HouseRobber {
	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5 };
		System.out.println(rob(array));
	}

	// Works, but times out. wth!
	/*
	 * Thats because this is not DP! This is just vanilla hardcore recursion. DP
	 * = Recursion + memoization
	 */

	public static int rob(int[] nums) {
		// table[i] stores highest rob for [i...table.length()-1]
		int[] table = new int[nums.length];
		for (int i = 0; i < table.length; i++) {
			table[i] = -1;
		}

		return findMax(nums, 0, table);
	}

	public static int findMax(int[] nums, int index, int[] table) {
		
		if (index > nums.length - 1) {
			return 0;
		}
		if (table[index] != -1)
			return table[index];

		int score1 = nums[index] + findMax(nums, index + 2, table); // Choose
																	// the
		// number
		int score2 = findMax(nums, index + 1, table); // Don't choose the number
		int max = Math.max(score1, score2);
		table[index] = max;
		return max;
	}

}
