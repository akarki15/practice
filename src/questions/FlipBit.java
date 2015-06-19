package questions;
/*You are given a binary array with N elements: d[0], d[1], ... d[N - 1]. 
You can perform AT MOST one move on the array: choose any two integers [L, R], and flip all the elements between (and including) the L-th and R-th bits. L and R represent the left-most and right-most index of the bits marking the boundaries of the segment which you have decided to flip.

What is the maximum number of '1'-bits (indicated by S) which you can obtain in the final bit-string? 

'Flipping' a bit means, that a 0 is transformed to a 1 and a 1 is transformed to a 0 (0->1,1->0). 
Input Format 
An integer N 
Next line contains the N bits, separated by spaces: d[0] d[1] ... d[N - 1] 

Output: 
S 

Constraints: 
1 <= N <= 100000 
d[i] can only be 0 or 1f 
0 <= L <= R < n 

Sample Input: 
8 
1 0 0 1 0 0 1 0 

Sample Output: 
6 

Explanation: 

We can get a maximum of 6 ones in the given binary array by performing either of the following operations: 
Flip [1, 5] ==> 1 1 1 0 1 1 1 0

*/

public class FlipBit {
	public static void main(String[] args) {		
		int [] input = {1, 0, 0, 1,0};
		
		System.out.println(findMaxNumberOfOnes(input,0, input.length-1));
	}
	static int nn =1;
	private static int findMaxNumberOfOnes(int[] input, int i, int j) {		
		System.out.println(i+" , "+j+ "   "+ (nn++));
		if (i==j)
			return 1;
		int option1 = input[i] + findMaxNumberOfOnes(input, i+1, j);
		int option2 = count(input , i , j, true);
		int option3 = count(input, i, j, false);
		int option4 =findMaxNumberOfOnes(input, i, j-1) +input[j]; 
		return Math.max(option1, Math.max(option2,Math.max(option3,option4)));
	}

	private static int count(int[] input, int i, int j, boolean flipped) {
		int a = flipped?0:1;
		int count = 0;
		while (i<=j){
			count += (input[i++]==a)?1:0;
		}
		return count;
	}
}
