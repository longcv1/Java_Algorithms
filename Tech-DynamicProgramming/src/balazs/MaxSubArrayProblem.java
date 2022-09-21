package balazs;

class KadaneAlgo{
	int run(int[] n) {
		int globalMax = n[0];
		int localMax = n[0];
		for(int i=1; i<n.length; i++) {
			localMax = Math.max(n[i], localMax + n[i]);
		}
		if(localMax > globalMax)
			globalMax = localMax;
		
		return globalMax;
	}
}

public class MaxSubArrayProblem {
	public static void main(String[] args) {
		int [] n = { 1, -2, 2, 3, 1 };
		KadaneAlgo algo = new KadaneAlgo();
		System.out.println(algo.run(n));
	}
}
