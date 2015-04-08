package questions;

import java.util.HashMap;

public class Try {
	public static void main(String[] args) {
//		reverse("this is a string");	
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
	
	
}
