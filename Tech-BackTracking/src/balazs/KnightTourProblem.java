package balazs;

class KnightTourAlgo{
	private int [][] chestTable;
	private int boardSize;
	private int [] xMoves = {2, 1, -1, -2, -2, -1, 1, 2};
	private int [] yMoves = {1, 2, 2, 1, -1, -2, -2, -1};
	public KnightTourAlgo(int boardSize) {
		super();
		this.boardSize = boardSize;
		this.chestTable = new int [boardSize][boardSize];
		initChestTable();
	}
	
	private void initChestTable() {
		for(int i=0; i<boardSize; i++)
			for(int j=0; j<boardSize; j++)
				chestTable[i][j] = Integer.MIN_VALUE;
	}
	
	private boolean solveProblem(int stepCount, int x, int y) {
		if(stepCount == boardSize * boardSize)
			return true;
		
		for(int moveIndex=0; moveIndex<yMoves.length; moveIndex++) {
			int nextX= x + xMoves[moveIndex];
			int nextY= y + yMoves[moveIndex];
			
			if(isValid(nextX, nextY)) {
				chestTable[nextX][nextY] = stepCount;
				
				if(solveProblem(stepCount+1, nextX, nextY))
					return true;
				
				// cannot solve the problem so we backtrack
				// remove from solution "BACKTRACKING"
				chestTable[nextX][nextY] = Integer.MIN_VALUE;
			}
		}
		return false;
	}
	
	private boolean isValid(int x, int y) {
		if(x < 0 || x >= boardSize) return false;
		if(y < 0 || y >= boardSize) return false;
		
		// Check if visit same cell multiple times
		if(chestTable[x][y] != Integer.MIN_VALUE)
			return false;
		
		return true;
	}
	
	public void solve() {
		chestTable[0][0] = 0;
		
		if(solveProblem(1, 0, 0))
			showResult();
		else
			System.out.println("OOPS! Cannot find solution....");
	}
	
	private void showResult() {
		for(int i=0; i<boardSize; i++) {
			for(int j=0; j<boardSize; j++) {
				System.out.print(chestTable[i][j] + "  ");
			}		
			System.out.println();
		}
	}
}

public class KnightTourProblem {

	public static void main(String[] args) {
		KnightTourAlgo algo = new KnightTourAlgo(5);
		algo.solve();
	}

}
