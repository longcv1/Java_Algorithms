package balazs;


class Constants{
    static final int BOARD_SIZE = 9;
    static final int MIN_NUMBER = 1;
    static final int MAX_NUMBER = 9;
    static final int BOX_SIZE = 3;
}

class SudokuAlgo{
    private int [][] sudokuTable;
    SudokuAlgo(int[][] sudokuTable){
        this.sudokuTable = sudokuTable;
    }

    public void solveProblem(){
        if(solve(0,0))
            showResult();
        else
            System.out.println("OOPS! Cannot find solution......");
    }

    private boolean solve(int rowIndex, int colIndex){
        // base case
        if(rowIndex == Constants.BOARD_SIZE){
            colIndex++;
            if(colIndex ==  Constants.BOARD_SIZE) {
                return true;
            } else{
                rowIndex=0;
            }
        }
        //skip filled cells
        if(sudokuTable[rowIndex][colIndex] !=0){
            return solve(rowIndex+1, colIndex);
        }

        //consider all the numbers from 1-9
        for(int num=Constants.MIN_NUMBER; num<=Constants.MAX_NUMBER; num++){
            if(isValid(rowIndex, colIndex, num)){
                //we assign the number to that location
                sudokuTable[rowIndex][colIndex] = num;
                if(solve(rowIndex+1,colIndex))
                    return true;

                //BACKTRACKING
                sudokuTable[rowIndex][colIndex] = 0;
            }
        }
        return false;
    }

    private boolean isValid(int rowIndex, int colIndex, int num){
        //if the given number is already in the column
        for (int i = 0; i < Constants.BOARD_SIZE; i++) {
            if(sudokuTable[i][colIndex] == num)
                return false;
        }

        //if the given number is already in the row
        for (int i = 0; i < Constants.BOARD_SIZE; i++) {
            if(sudokuTable[rowIndex][i] == num)
                return false;
        }

        //if the given number is already in the box
        int boxRowOffset = (rowIndex/3) * Constants.BOX_SIZE;
        int boxColOffset = (colIndex/3) * Constants.BOX_SIZE;

        for(int i=0; i<Constants.BOX_SIZE; i++){
            for(int j=0; j<Constants.BOX_SIZE; j++){
                if(sudokuTable[boxRowOffset+i][boxColOffset+j] == num)
                    return false;
            }
        }
        return true;
    }

    void showResult(){
        for (int i=0; i<Constants.BOARD_SIZE; i++){
            if(i%3 == 0) System.out.println();
            for(int j=0; j<Constants.BOARD_SIZE; j++){
                if(j%3 == 0) System.out.print(" ");
                System.out.print(sudokuTable[i][j] + " ");
            }
            System.out.println();
        }
    }
}


public class SudokuProblem {

	public static void main(String[] args) {
		int[][] sudokuTable = {
                {3,0,6,5,0,8,4,0,0},
                {5,2,0,0,0,0,0,0,0},
                {0,8,7,0,0,0,0,3,1},

                {0,0,3,0,1,0,0,8,0},
                {9,0,0,8,6,3,0,0,5},
                {0,5,0,0,9,0,6,0,0},

                {1,3,0,0,0,0,2,5,0},
                {0,0,0,0,0,0,0,7,4},
                {0,0,5,2,0,6,3,0,0}
        };
        SudokuAlgo algo = new SudokuAlgo(sudokuTable);
        algo.solveProblem();
	}

}
