package questions;

/*You are given a list of pairs of numbers. In each pair, one is larger than the other. You

must create an algorithm to choose a sequence of numbers according to the following

rules:

• From each pair, you may choose one number, or neither number.

• You can only choose the larger number if you did not choose a number from the

PRECEDING pair.

Your objective is to choose the sequence with the largest sum.

For example, if the list is:

(1,2) (2,5) (2,10)

then if you choose either the 1 or the 2 from the first pair, you cannot choose the 5

from the second pair. In this case the largest sum is 2+10.

Give a dynamic programming algorithm to find the optimal sum. How long does your

algorithm take?*/

public class CompQuestion {
	public static void main(String[] args) {
		int [][] A ={{1,2},{2,5}}; // Input Array
		int [] mem = new int [A.length+2]; // Store results
		mem [0] = 0;
		mem [1] = 0;
		for (int i=2;i<mem.length;i++){
			int option1 = mem[i-1]+A[i-2][0];
			int option2 = mem [i-2]+A[i-2][1];
			mem[i]= (option1>option2)?option1:option2;
		}
		System.out.println(mem[mem.length-1]);
	}
	
}
