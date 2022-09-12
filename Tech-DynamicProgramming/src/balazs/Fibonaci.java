package balazs;

import java.util.HashMap;
import java.util.Map;

class FiboAlgorithms {
	public int Fibo(int n) {
		if (n <= 1)
			return 1;
		return Fibo(n - 2) + Fibo(n - 1);
	}

	public int FiboIterative(int n) {
		if (n <= 1)
			return 1;
		
		int[] F = new int[10];
		F[0] = 1;
		F[1] = 1;
		for (int i = 2; i <= n; i++) {
			F[i] = F[i - 2] + F[i - 1];
		}
		return F[n];
	}

	// Dynamic Programming with memorization
	public int FiboMemorization(int n, Map<Integer, Integer> table) {
		if (!table.containsKey(n)) {
			table.put(n, FiboMemorization(n - 1, table) + FiboMemorization(n - 2, table));
		}

		return table.get(n);
	}
	
	// Dynamic Programming with tabulation
	public int FiboTabulation(int n, Map<Integer, Integer> table) {
		for(int i=2; i<=n; i++) {
			table.put(i, table.get(i-1) + table.get(i-2));
		}
		return table.get(n);
	}
}

public class Fibonaci {

	public static void main(String[] args) {
		// 1. Using recursion
		FiboAlgorithms f = new FiboAlgorithms();
		System.out.println("Fibonaci recursion: " + f.Fibo(8));
		System.out.println("Fibonaci Iterative: " + f.FiboIterative(8));

		// 2. Using memorization
		Map<Integer, Integer> table = new HashMap<>();
		table.put(0, 1);
		table.put(1, 1);
		System.out.println("Fibonaci Memorization :" + f.FiboMemorization(8, table));
		System.out.println("Fibonaci Tabulation :" + f.FiboTabulation(8, table));
	}
}
