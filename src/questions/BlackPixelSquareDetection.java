package questions;

/*
 * 3. You are part of a team writing image recognition software and your
 * team needs assistance. Help them by writing a function that accepts an
 * image as a NxN two dimensional array representing pixel colors (each
 * pixel is either "B" for black, "W" for white, or "Y" for yellow) and
 * determines whether all black pixels are in a square shape. Here are two
 * examples:
 * 
 * f([ [ W, W, B, B], [ W, W, B, B], [ Y, Y, Y, Y], [ Y, W, Y, W],]) => true
 * 
 * f([ [ W, W, Y, B], [ W, W, B, B], [ Y, B, Y, Y], [ Y, W, Y, W],]) =>
 * false
 */

public class BlackPixelSquareDetection {
	
	public static void main(String[] args) {
		
		// First Test Case
		char[][] A = { 	{ 'W', 'W', 'B', 'B' }, 
						{ 'W', 'W', 'B', 'B' },
						{ 'Y', 'Y', 'Y', 'Y' }, 
						{ 'Y', 'W', 'Y', 'W' }, };
		
		// Second Test Case		
		char[][] B = { 	{ 'W', 'W', 'Y', 'B' }, 
						{ 'W', 'W', 'B', 'B' },
						{ 'Y', 'B', 'Y', 'Y' }, 
						{ 'Y', 'W', 'Y', 'W' }, };
		
		 /*My own test case to see if two square black pixels can be detected 
		or not*/
		char[][] C = { 	{ 'W', 'W', 'B', 'B' }, 
						{ 'W', 'W', 'B', 'B' },
						{ 'B', 'B', 'Y', 'Y' }, 
						{ 'B', 'B', 'Y', 'W' }, };
		
		System.out.println(areBlackPixelsSquare(A));
		System.out.println(areBlackPixelsSquare(B));
		System.out.println(areBlackPixelsSquare(C));
	}
	
	static boolean areBlackPixelsSquare(char[][] image) {
		/*
		 * tracker tracks whether certain pixel has been visited
		 */
		boolean[][] tracker = new boolean[image.length][image.length];
		
		/*Go through all the pixels and  if a black pixel is found try to 
		 * 'grow' a square of black pixels around it by using the found black
		 * pixel as the top the leftmost pixel */ 		
		for (int i = 0; i < image.length; i++) {
			for (int j = 0; j < image.length; j++) {
				if (image[i][j] == 'B' && tracker[i][j] == false) {
					tracker[i][j] = true;					
					if (growSquare(tracker, image, i, j) == false)
						return false;
				}
			}
		}
		return true;
	}

	/*
	 * Takes the upperleft black pixel (of a potential square) and tries to
	 * 'grow' a black square- one fringe at a time .In the first test case,
	 * Array[0][2] would be the upperleft black pixel, and
	 * {Array[0][3],Array[1][2],Array[1][3]} would be the first fringe. Returns 
	 * true if successful and false if unsuccessful in growing a square.
	 */

	private static boolean growSquare(boolean[][] tracker, char[][] image,
			int i, int j) {
		int counterI = i + 1;
		int counterJ = j + 1;
		// return false for lone black pixel
		if (counterI < image.length && counterJ < image.length
				&& image[counterI][counterJ] != 'B')
			return false;

		boolean b; // tracks if image [counterI][counterJ] is black or not
		while (counterI < image.length && counterJ < image.length) {
			b = image[counterI][counterJ] == 'B' ? true : false;
			tracker[counterI][counterJ] = true;
			
			/*Check if the fringe is correct i.e. entirely black/non-black*/
			for (int k = 1; k < counterI - i + 1; k++) {
				tracker[counterI - k][counterJ] = tracker[counterI][counterJ
						- k] = true;

				boolean pixel1 = (image[counterI - k][counterJ] == 'B') ? true
						: false;
				boolean pixel2 = (image[counterI][counterJ - k] == 'B') ? true
						: false;

				/*
				 * if the fringe we are growing contains black + non-black
				 * pixels, return false 
				 */
				if (!(pixel1 == pixel2 && pixel2 == b))
					return false;				
			}
			/*
			 * stop growing square if the fringe is made entirely up of
			 * non-black pixels
			 */
			if (!b)
				break;
			/*
			 * keep on growing the square if the fringe under consideration was
			 * all black pixels
			 */
			counterI++;
			counterJ++;
		}
		return true;
	}
}
