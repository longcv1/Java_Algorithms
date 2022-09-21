package balazs;

class LCSAlgorithm{
	String show(String s1, String s2) {
		// we need a table for memorization
		int[][] dp = new int[s1.length()+1][s2.length()+1];

		for(int i=1; i<s1.length()+1; i++) {
			for(int j=1; j<s2.length()+1; j++) {
				if(s1.charAt(i-1) == s2.charAt(j-1)) 
					dp[i][j] = 1+ dp[i-1][j-1];
				else
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
		
		String lcs = "";
		int i = s1.length(); int j=s2.length();
		while(i>0 && j>0) {
			// if the current character of s1 and s2 are matching then it is a part of LCS
			if(s1.charAt(i-1) == s2.charAt(j-1)) {
				lcs += s1.charAt(i-1);
				i--;	j--;
			} 
			// if letter is not matched, then find the larger of two values (up and left)
			// and take a step in the direction of larger value
			else if(dp[i-1][j] > dp[i][j-1]) {
				i--; // go up
			} else {
				j--; // go left
			}
		}
		return new StringBuilder(lcs).reverse().toString();
	}
}

class LCSRecursion{
	int lcs(String s1, String s2, int m, int n) {
		if(m==0 || n==0)
			return 0;
		
		if(s1.charAt(m-1) == s2.charAt(n-1))
			return 1 + lcs(s1, s2, m-1, n-1);
		else
			return Math.max(lcs(s1, s2, m, n-1), lcs(s1, s2, m-1, n));
	}
}

public class LongestCommonSubsequence {

	public static void main(String[] args) {
		LCSAlgorithm lcs = new LCSAlgorithm();
		System.out.println(lcs.show("abcd", "rebxd"));
	}

}
