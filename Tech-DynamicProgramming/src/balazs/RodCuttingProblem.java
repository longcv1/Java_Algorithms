package balazs;

class RodCuttingAlgo {
	private int rodLength;
	private int[][] dpTable;
	private int[] prices;
	public RodCuttingAlgo(int rodLength, int[] prices) {
		super();
		this.rodLength = rodLength;
		this.prices = prices;
		this.dpTable = new int [prices.length + 1][rodLength + 1];
	}
	
	public void solve() {
		for(int i=1; i<prices.length; i++) {
			for(int j=1; j<rodLength + 1; j++) {
				if(i <= j) {
					dpTable[i][j] = Math.max(dpTable[i-1][j], prices[i] + dpTable[i][j-1]);
				} else {
					dpTable[i][j] = dpTable[i-1][j];
				}
			}
		}
	}
	
	public void show() {
		System.out.println("Max profit: " + dpTable[prices.length-1][rodLength-1]);
		for(int rowIndex = prices.length -1, colIndex = rodLength; rowIndex > 0;) {
			if(dpTable[rowIndex][colIndex] != 0 && dpTable[rowIndex][colIndex] != dpTable[rowIndex-1][colIndex]) {
				System.out.println("use piece: " + rowIndex + "m");
				colIndex -= rowIndex;
			} else {
				rowIndex--;
			}
		}
	}
	
}

public class RodCuttingProblem {

	public static void main(String[] args) {
		int n=5;
		int[] prices = { 2, 5, 7, 3, 9 };
		RodCuttingAlgo  algo = new RodCuttingAlgo(n, prices);
		algo.solve();
		algo.show();
	}
}
