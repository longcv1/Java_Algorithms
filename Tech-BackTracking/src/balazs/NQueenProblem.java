package balazs;

class NQueenAlgorithm{
	private int[][] chessTable;
	private int nbOfQueens;
	public NQueenAlgorithm(int nbOfQueens) {
		super();
		this.nbOfQueens = nbOfQueens;
		this.chessTable = new int[nbOfQueens][nbOfQueens];
	}
	
	private boolean setQueens(int colIndex) {
		// We found the location for N queens
		if(colIndex == nbOfQueens)
			return true;
		
		for(int rowIndex=0; rowIndex < nbOfQueens; rowIndex++) {
			if(isPlacevalid(rowIndex, colIndex)) {
				chessTable[rowIndex][colIndex] = 1;
				
				// solve the problem for the next column
				if(setQueens(colIndex+1))
					return true;
				
				// BACK TRACK
				chessTable[colIndex][rowIndex] = 0;
			}
		}
		
		return false;
	}
	
	private boolean isPlacevalid(int rowIndex, int colIndex) {
		// Check queens have the same row
		for(int i=0;i<colIndex;i++) {
			if(chessTable[rowIndex][i] == 1)
				return false;
		}
		
		// Check diagonal from left to bottom right
		for(int i=rowIndex, j=colIndex; i>=0 && j>=0; i--,j--) {
			if(chessTable[i][j] == 1)
				return false;
		}
		
		// Check diagonal from right to bottom left
		for(int i=rowIndex, j=colIndex; i<chessTable.length && j>=0; i++,j--) {
			if(chessTable[i][j] == 1)
				return false;
		}
		
		return true;
	}
	
	public void solve() {
		if(setQueens(0)) {
			printQueens();
		}
		else
			System.out.println("There is no solution.....!");
	}
	
	public void printQueens() {
		for(int i=0;i<chessTable.length;i++) {
			for(int j=0;j<chessTable.length;j++){
				if(chessTable[i][j] == 1)
					System.out.print(" * ");
				else
					System.out.print(" - ");
			}
			System.out.println();
		}
	}
	
}


public class NQueenProblem {

	public static void main(String[] args) {
		NQueenAlgorithm algo = new NQueenAlgorithm(1000);
		algo.solve();
	}

}
