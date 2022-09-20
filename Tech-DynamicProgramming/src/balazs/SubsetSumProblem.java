package balazs;

class SubsetSumAlgo {
	private boolean [][] S;
	private int [] nums;
	private int m;
	public SubsetSumAlgo(int[] nums, int m) {
		super();
		this.nums = nums;
		this.m = m;
		this.S = new boolean[nums.length+1][m+1];
	}
	void solve() {
		// first column has True value
		// first row has False value as default
		for(int i=0; i<=nums.length; i++) {
			S[i][0] = true;
		}
		for(int rowIndex=1; rowIndex<nums.length+1; rowIndex++) {
			for(int colIndex=1; colIndex<m+1; colIndex++) {
				if(colIndex < nums[rowIndex-1]) {
					S[rowIndex][colIndex] = S[rowIndex-1][colIndex];
				} else {
					if(S[rowIndex-1][colIndex]) 
						S[rowIndex-1][colIndex] = S[rowIndex-1][colIndex];
				    else 
						S[rowIndex][colIndex] = S[rowIndex-1][colIndex-nums[rowIndex-1]];
				}
			}
		}
	}
	void show() {
		System.out.println("Solution: " + S[nums.length][m]);
		if(!S[nums.length][m])
			return;
		int colIndex = this.m;
		int rowIndex = this.nums.length;
		while(rowIndex > 0 || colIndex > 0) {
			if(S[rowIndex][colIndex] == S[rowIndex-1][colIndex]) {
				rowIndex -= 1;
			} else {
				System.out.println("take: " + nums[rowIndex-1]);
				colIndex = colIndex - nums[rowIndex-1];
				rowIndex -= 1;
			}
		}
	}
}

public class SubsetSumProblem {

	public static void main(String[] args) {
		int[] numbers = { 3,4,5};
		int m = 9;
		SubsetSumAlgo algo = new SubsetSumAlgo(numbers, m);
		algo.solve();
		algo.show();
	}

}
