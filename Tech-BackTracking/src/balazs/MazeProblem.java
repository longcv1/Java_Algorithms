package balazs;

class MazeAlgo{
	private int[][] maze;
	private int[][] solution;
	private int maxSize;
	public MazeAlgo(int[][] maze) {
		super();
		this.maze = maze;
		this.maxSize = maze.length;
		this.solution = new int[maxSize][maxSize];
	}
	
	public void solve() {
		if(solveProblem(0, 0))
			showResult();
		else
			System.out.println("OOPS! Cannot find solution.....");
	}
	
	private boolean solveProblem(int rowIndex, int colIndex) {
		// if we reach the destination
		if(isFinished(rowIndex, colIndex)) {
			return true;
		}
		
		if(isValid(rowIndex, colIndex)) {
			solution[rowIndex][colIndex] = 1;
			
			// go forward in the horizontal direction
			if(solveProblem(rowIndex, colIndex+1))
				return true;
			
			// go downward in the vertical direction
			if(solveProblem(rowIndex+1, colIndex))
				return true;
			
			// BACKTRACKING
			solution[rowIndex][colIndex] = 0;
		}
		
		return false;
	}
	
	private boolean isFinished(int rowIndex, int colIndex) {
		if(rowIndex == maxSize-1 && colIndex == maxSize-1) {
			solution[rowIndex][colIndex] = 1;
			return true;
		}
		return false;
	}

	private boolean isValid(int rowIndex, int colIndex) {
		if(rowIndex < 0 || rowIndex >= maxSize) return false;
		if(colIndex < 0 || colIndex >= maxSize) return false;		
		if(maze[rowIndex][colIndex] == 0)    	return false;
		
		return true;
	}
	
	private void showResult() {
		for(int i=0; i<maxSize; i++) {
			for(int j=0; j<maxSize; j++) {
				if(solution[i][j] == 1)
					System.out.print(" S ");
				else
					System.out.print(" - ");
			}
			System.out.println();
		}
	}
}


public class MazeProblem {

	public static void main(String[] args) {
		int mazeTable[][] = 
		{
				{1,1,1,1},
				{1,0,1,0},
				{0,0,1,1},
				{1,0,1,1}
		};
		
		MazeAlgo algo = new MazeAlgo(mazeTable);
		algo.solve();
	}
}
