package questions;

/*http://www.geeksforgeeks.org/given-a-number-find-next-smallest-palindrome-larger-than-this-number/
 */
public class NextPalindrome {
	public static void main(String[] args) {
		/* findNextSmallestPalindrome(4594); */
		// System.out.println(reverseInt(4536));
		// System.out.println(getLeftPart(45336, false, 5 ));
		System.out.println(findNextSmallestPalindrome(99999)+" is the answer");
	}

	static int findNextSmallestPalindrome(int i) {			
		int size = (int) Math.log10(i)+1;
		
		boolean even = false; 
		if (size%2==0) even = true;
		
		int leftPart = getLeftPart(i, even, size);
		int middle = getMiddle(i, size); // will only get used for odd sizes
		
		int firstTry; 
		if (even){
			firstTry = (int) (leftPart*Math.pow(10, size/2)+reverseInt(leftPart));
			System.out.println(firstTry);
		}else{
			int offset = (int) Math.pow(10, (int)(size/2)+1);			
			firstTry = (int) (leftPart*offset+middle*(offset/10)+reverseInt(leftPart));
			System.out.println("First Try: "+firstTry);
		}
		
		if (firstTry>i) 
			return firstTry;
		else {
			int newCase = 0;
			if (even){
				newCase = (int) ((leftPart+1)*Math.pow(10, size/2));
			}else {
				newCase =leftPart*10 + middle+1;
				newCase = newCase* ((int) Math.pow(10, size/2));
			}
			System.out.println("NewCase:"+newCase);			
			return findNextSmallestPalindrome(newCase);
		}
				
	}

	private static int getMiddle(int i, int size) {
		int parse = (int) (i / Math.pow(10, (int) size / 2));
		return (parse % 10);
	}

	static int getLeftPart(int num, boolean even, int size) {
		int stopIndex = size / 2;
		if (!even) {
			stopIndex++;
		}
		return (int) (num / (Math.pow(10, stopIndex)));
	}

	static int reverseInt(int num) {
		int size = (int) Math.log10(num) + 1;
		int reverse = 0;
		for (int i = 0; i < size; i++) {
			int digitToAdd = num % 10;
			reverse = reverse * 10 + digitToAdd;
			num = num / 10;
		}
		return reverse;
	}
}
