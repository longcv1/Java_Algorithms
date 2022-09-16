package balazs;

class KnapsackAlgo{
	private int n; // number of items
	private int capacity;
	private int[][] S;
	private int[] weights;
	private int[] values;
	public KnapsackAlgo(int n, int capacity, int[] weights, int[] values) {
		super();
		this.n = n;
		this.capacity = capacity;
		this.weights = weights;
		this.values = values;
		S = new int[n+1][capacity+1];
	}
	
	public void solve() {
		for(int i=1; i<n+1; i++) {
			for(int w=1; w<capacity+1; w++) {
				// whether take item i or not
				int notTakingItem = S[i-1][w];
				int takingItem = 0;
				if(weights[i] <= w)
					takingItem = values[i] + S[i-1][w-weights[i]];
				
				S[i][w] = Math.max(takingItem, notTakingItem);
			}
		}
	}
	
	public void showResult() {
		System.out.println("Total benefit: " + S[n][capacity]);
		for(int i=n, w=capacity; i>0; i--) {
			if(S[i][w] !=0 && S[i][w] != S[i-1][w]) {
				System.out.println("We take item: " + i);
				w = w-weights[i];
			}
		}
	}
}

public class KnapsackProblem {

	public static void main(String[] args) {
		int nbOfItems = 4;
		int capacity = 7;
		int[] weightOfItems = {0, 1, 3, 4, 5};
		int[] profitOfItems = {0, 1, 4, 5, 7};
		KnapsackAlgo algo = new KnapsackAlgo(nbOfItems, capacity, weightOfItems, profitOfItems);
		algo.solve();
		algo.showResult();
	}

}
