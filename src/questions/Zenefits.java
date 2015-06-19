package questions;

import java.util.Scanner;

public class Zenefits {
	// GOOD NODES PROBLEM. WORKS! 
	/*http://www.careercup.com/question?id=5840928073842688
*/	
	public static void main(String args[]) throws Exception {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT */
		/*
		
		 * Scanner sc = new Scanner(System.in); int size = sc.next(); int []
		 * input = new int [size+1];
		 * 
		 * //discard input[0] for easier comprehension for (int i=1; i<size;
		 * i++){ input [i] = sc.nextInt(); } sc.close();
		 */
		int[] input = { 0, 1, 1, 2, 3 };
		System.out.println(goodNodes(input));
		// System.out.println(goodNodes(input));
		
	}
	
	
	static int counter; // counts the number of nodes needed to be processed
	
	static int goodNodes(int[] input) {
		counter = 0; 
		if (input.length == 2)
			return 0;
		// mem stores whether a node is good ('g'), or not good ('b'). it is
		// empty ('\0') if it has not been processed and '-' if under process.
		char[] mem = new char[input.length];

		// discard mem[0] since there is no node 0

		mem[1] = 'g'; // node 1 is good

		for (int i = 2; i < input.length; i++) {

//			System.out.println("_______________");
			process(i, mem, input);

		}

		for (int i = 1; i < input.length; i++) {
			System.out.println(mem[i]);
		}
		return counter;
	}

	static char process(int i, char[] mem, int[] input) {
//		System.out.println("next " + i);

		if (mem[i] == 'g') {
			return 'g';
		} else if (mem[i] == '-') {
			counter++;
			mem[i] = 'b';
			return 'b';
		} else if (mem[i] == 'b') {
			return 'b';
		}
		// node is unprocessed
		mem[i] = '-';
		char next = process(input[i], mem, input);
		mem[i] = next;
//		System.out.println(i + " _ " + next);
		return next;

	}
}
