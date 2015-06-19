package questions;

public class NumPossSquares {
	
	public static void main(String[] args) {
		int size = 8;						
		System.out.println(findMaxPossibleSquares(size));
	}
	
	private static int findMaxPossibleSquares(int size) {				
		int count = 0 ; // counts the no. of possible squares for size
		// break down the problem into summing possible squares for size 1,2 ... size
		for (int i = 1; i<size; i++){
			int diff = size -i + 1;
			int possibleSquares = diff * diff; // no. of possible squares of size diff 
			count += possibleSquares; 
		}
		count ++ ; // accounting for the one possible sizeXsize square		
		return count; 
	}
}
