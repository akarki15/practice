package questions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Try {
	public static void main(String[] args) {
		read();
		// reverse("this is a string");
		/*int [] input = {2,5,3,7,1,4,1,2,3,2,3,2,12,3,123,213,213,12,31,23,12,3,213,21,3,123,12,3,12,312,};
		quickSort(input, 0, input.length-1);
		for (int i : input) {
			System.out.println(i);
		}*/
		
	}

	static void read (){
		String uri = System.getProperty("user.dir")+"/src/questions/input";
		try {			
			BufferedReader br = new BufferedReader(new FileReader(new File(uri)));
			String s; 
			while ((s=br.readLine())!=null){
				System.out.println(s.substring(4,10)+"\t"+s.substring(28, 41)+"\t"+s.substring(47, 51));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	static void reverse(String s) {
		String temp = "";
		String output = "";
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ' ') {
				output = temp + " " + output;
				temp = "";
			} else {
				temp = temp + s.charAt(i);
			}
		}
		output = temp + " " + output;
	}

	static void swap(int[] input, int i, int j) {
		int temp = input[i];
		input[i] = input[j];
		input[j] = temp;
	}

	static int partition(int[] input, int si, int ei) {
		int lowPointer = si;
		int highPointer = ei; // highPointer is the parition elelment
		
		while (highPointer > lowPointer) {
			if (input[highPointer - 1] <= input[highPointer]) {
				swap(input, lowPointer, highPointer - 1);
				lowPointer++;
			} else {
				swap(input, highPointer - 1, highPointer);
				highPointer--;
			}
		}
		return highPointer;
	}

	/* QuickSort si: starting index, ei: ending index */
	static void quickSort(int[] input, int si, int ei) {
		if (si < ei) {
			int partitionIndex = partition(input, si, ei);
			quickSort(input, si, partitionIndex - 1);
			quickSort(input, partitionIndex + 1, ei);
		}		
	}
}
