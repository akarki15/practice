package questions.wayfair;

// http://www.geeksforgeeks.org/convert-number-to-words/

// Write code to convert a given number into words. For example, if “1234” is
// given as input, output should be “one thousand two hundred thirty four”.

public class NumberToWord {
	static String[] ones = { "one", "two", "three", "four", "five", "six", "seven",
			"eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen",
			"sixteen", "seventeen", "eighteen", "ninteen" };
	static String[] tens = {"ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
	
	public static void main(String[] args) {
		printText(-1234);
	}

	private static void printText(int input) {
		
		System.out.println(digitAt(input, 2));
		
	}
	
	
	static int digitAt(int input, int pos){		
		int i =(int) (input%(Math.pow(10, pos)));
		int j = (int) (i/Math.pow(10, pos-1));
		return Math.abs(j);
	}
//	static String returnTensWords(int i){
//		String s = "";
//		if ()
//		if (i%10!=0){
//			s = ones[i%10-1];
//		}
//		
//		return "";
//	} 
}
