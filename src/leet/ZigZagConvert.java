package leet;

public class ZigZagConvert {
	public static void main(String[] args) {
		System.out.println(convert("ABCDEFGHIJKLMN", 4));
	}

	public static String convert(String s, int numRows) {
		String[] rows = new String[numRows]; // Strings are like 'rows'
		for (int i = 0; i < rows.length; i++) {
			rows[i] = ""; // initialize each to empty string
		}

		int row = 0; // this is going to keep track of which 'row' we are on
		boolean dir = true; // positive indicates we are going down the rows and
							// viceversa

		for (int i = 0; i < s.length(); i++) {
			rows[row] += s.charAt(i);

			// Change the row based on which direction we are going
			if (numRows > 1) { // no need to change row if only one row
				if (row == 0) { // if we are at row no.0, next char should be
								// saved in row no.1
					row++;
					dir = true; // true since we are going down
				} else if (row == numRows - 1) { // similarly if we are at the
													// lowest "row"
					row--;
					dir = false;
				} else if (dir) {
					// else we are midway in the "row" stack. So if we were
					// going down the stacks, we increase the row
					row++;
				} else {
					row--;
				}
			}
		}
		String result = "";
		for (int i = 0; i < rows.length; i++) {
			System.out.println(rows[i]);
			result += rows[i];
		}
		System.out.println();
		return result;
	}
}
