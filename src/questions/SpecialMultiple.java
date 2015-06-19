package questions;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

/*https://www.hackerrank.com/challenges/special-multiple
 */

public class SpecialMultiple {
	public static void main(String[] args) {
	
//			Scanner k = new Scanner(System.in);
//			int size = k.nextInt();
//			int[] nums = new int[size];
//			for (int i = 0; i < size; i++) {
//				nums[i] = k.nextInt();
//			}
//			for (int i = 0; i < size; i++) {
//				System.out.println(nums[i]);
//				findMultiple(nums[i]);
//			}
//			k.close();
		findMultiple(476);

	}
	

	static void findMultiple(int input) {
		int num = 1;
		long p = 0;

		while (true) {
			System.out.println(Integer.parseInt(Integer.toBinaryString(num), 10));
			p = Integer.parseInt(Integer.toBinaryString(num), 10);
			p*=9;
			
			if ((p) % input == 0) {				
				System.out.println(p);				
				break;
			}
			num++;

		}

	}

	static void p() {
		// int n =9;
		// int mask = 14;
		// TreeSet<Long> TS = new TreeSet<Long>();
		// for(int m=1;m<1<<mask;m++){
		//
		// long num = 0;
		// for(int b=0;b<mask;b++){
		// num*=10;
		// if(((m>>b)&1)==1){
		// num+=9;
		// }
		// }
		// System.out.println(num);
		// if(num%n==0){
		// TS.add(num);}
		//
		// }
		System.out.println(1 << 13);
	}

}
