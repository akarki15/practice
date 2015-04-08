package questions;

public class BlackPixelSquareDetection {
	public static void main(String[] args) {
		char [][] A = {{ 'W', 'W', 'B', 'B'},
				       { 'W', 'W', 'B', 'B'}, 
				       { 'B', 'B', 'Y', 'Y'},
				       { 'B', 'B', 'Y', 'W'},};
		System.out.println(areBlackPixelsSquare(A));
	}
/*	3. You are part of a team writing image recognition software and your team needs assistance. 
 * Help them by writing a function that accepts an image as a NxN two dimensional array representing
 *  pixel colors (each pixel is either "B" for black, "W" for white, or "Y" for yellow) and determines
 *   whether all black pixels are in a square shape. Here are two examples:

		f([ [ W, W, B, B],
		    [ W, W, B, B], 
		    [ Y, Y, Y, Y],
		    [ Y, W, Y, W],]) => true

		f([ [ W, W, Y, B],
		    [ W, W, B, B],
		    [ Y, B, Y, Y],
		    [ Y, W, Y, W],]) => false*/
	
	static boolean areBlackPixelsSquare(char[][] image){
		boolean [][] tracker = new boolean[image.length][image.length]; // tracker tracks whether certain pixel has been visited
		for (int i= 0;i <image.length;i++){
			for (int j= 0;j <image.length;j++){
				if (image[i][j]=='B' && tracker[i][j]==false){
					tracker[i][j] = true;
					System.out.println(i+" "+j+"<---------");
					if (growSquare(tracker, image,i,j)==false)
						return false; 
				}
			}
		}
		return true;		
	}

	/* Takes the upperleft black pixel and tries to 'grow' a black square. Returns false if
	 * it is unable to based on the image array
	 * */ 
	
	private static boolean growSquare(boolean[][] tracker, char[][] image, int i, int j) {
		int counterI = i+1;
		int counterJ = j+1; 
		// return false for lone black pixel
		if (counterI<image.length && counterJ<image.length && image[counterI][counterJ]!='B')
			return false;
		
		boolean b; // tracks if image [counterI][counterJ] is black or not
		while (counterI<image.length && counterJ<image.length){									 
			b= image[counterI][counterJ]=='B'?true:false; 
			tracker[counterI][counterJ] = true; 
			boolean otherPixelsAround = b; //  tracks if all pixels above and to the left of image[counterI][counterJ] are black or not 
			
			for (int k = 1; k<counterI-i+1;k++){
				tracker[counterI-k][counterJ] = tracker[counterI][counterJ-k] = true;				
				
				boolean pixel1 = (image[counterI-k][counterJ]=='B')? true:false;
				boolean pixel2 = (image[counterI][counterJ-k]=='B')? true:false;
				
				if (!(pixel1 == pixel2 && pixel2 == b))
					return false; 
					
				System.out.print(counterI-k+","+ counterJ+"            ");
				System.out.println(counterI+","+ (counterJ-k));
				System.out.println();							
			}
			if (!b)
				break;
			counterI++;
			counterJ++;
		}		
		return true;
	}	
}
