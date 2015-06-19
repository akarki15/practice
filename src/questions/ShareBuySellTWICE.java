package questions;
/*http://www.geeksforgeeks.org/maximum-profit-by-buying-and-selling-a-share-at-most-twice/
*/public class ShareBuySellTWICE {
	public static void main(String[] args) {
		int [] price= 	{10, 22, 5, 75, 65, 80};
		System.out.println(maxProfit(price));
	}

	private static int maxProfit(int[] price) {
		// going right to left
		int [] profit = new int [price.length];
		rightToLeft(profit, price);
		return 0;
	}
	private static void rightToLeft(int [] profit, int [] price){
		
	}
}
