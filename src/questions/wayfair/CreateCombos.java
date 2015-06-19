package questions.wayfair;

public class CreateCombos {
	public static void main(String[] args) {
		String[][] s = { { "fast", "slow" }, { "brown", "black" },
				{ "dog", "fox" } };

		generate(s, "", 0);
	}

	private static void generate(String[][] s, String runningS, int pointer) {
		if (pointer == s.length){
			System.out.println(runningS);
			return;
		}
		for (int i = 0; i < s[0].length; i++) {
			generate(s, runningS + " " + s[pointer][i], pointer+1);
		}
	}

}
