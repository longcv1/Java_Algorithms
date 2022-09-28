package karimov;

import java.util.Arrays;

class CoinChangeAlgo{
	public static void solve(int[] coins, int N) {
		Arrays.sort(coins);
		int index = coins.length-1;
		while(true) {
			int coinValue = coins[index];
			index--;
			int maxAmount = (N/coinValue) * coinValue;
			if(maxAmount > 0) {
				System.out.println("Coin value: " + coinValue + " taken count: " + (N/coinValue));
				N-=maxAmount;
			}
			if(N==0) break;
		}
	}
}

public class CoinChangeProblem {

	public static void main(String[] args) {
		int[] coins = {1,2,5,10,20,50,1000};
		int amount=2035;
		CoinChangeAlgo.solve(coins, amount);
	}

}
