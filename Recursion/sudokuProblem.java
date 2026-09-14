package DSA_LoveBabbar.Recursion;

public class sudokuProblem {

    //  SUDOKU SOLVER

    /*

    Write a program to solve a Sudoku puzzle by filling the empty cells.

A sudoku solution must satisfy all of the following rules:

Each of the digits 1-9 must occur exactly once in each row.
Each of the digits 1-9 must occur exactly once in each column.
Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
The '.' character indicates empty cells.



Example 1:


Input: board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]
Output: [["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4","8"],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3"],["4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],["9","6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3","4","5","2","8","6","1","7","9"]]
Explanation: The input board is shown above and the only valid solution is shown below:




Constraints:

board.length == 9
board[i].length == 9
board[i][j] is a digit or '.'.
It is guaranteed that the input board has only one solution.

     */

    static  boolean findEmptyCell(char[][] board, int[] emptyCell){

        for(int i = 0; i < 9; i++){

            for(int j = 0; j < 9; j++){

                if(board[i][j] == '.'){

                    // row index
                    emptyCell[0] = i;
                    // column index
                    emptyCell[1] = j;
                    // if empty cell found then return true
                    return true;
                }
            }
        }
        // else return false;
        return false;
    }

    static boolean isPossibleToPlace(char[][] board, char charValue, int rowIndex, int colIndex){

        // Rules:

        // 1) -> value must not be duplicate in a single row of 9*9 board(sudoku board) i.e. horizontally
        // Therefore for this rule, rowIndex remain same and colIndex varies from 0 to <9
        for(int col = 0; col < 9; col++){

            if(board[rowIndex][col] == charValue){
                return false;
            }
        }

        // 2) -> value must not be duplicate in a single column of 9*9 board(sudoku board) i.e. vertically
        // Therefore for this rule, colIndex remain same and rowIndex varies from 0 to <9
        for(int row = 0; row < 9; row++){

            if(board[row][colIndex] == charValue){
                return false;
            }
        }

        // 3) -> value must not be duplicate in a sub matrix of 3*3 of 9*9 board(sudoku board) i.e. 3*3 matrix
        // Therefore for this rule, to calculate the exact rowIndex and colIndex for a particular sub matrix logic is given as below

        int startingRow = rowIndex - rowIndex%3; // logic for calculating row of subMatrix
        int startingCol = colIndex - colIndex%3; // logic for calculating col of subMatrix

        // as it is sub matrix then we have to travel only three time
        for(int i = 0; i < 3; i++){

            for(int j = 0; j < 3; j++){

                int actualRow = startingRow + i;
                int actualCol = startingCol + j;

                if(board[actualRow][actualCol] == charValue){
                    return true;
                }
            }
        }

        // else return true
        return true;
    }

    static boolean solveSudokuSolver(char[][] board){

        int[] emptyCell = new int[2];

        if(!findEmptyCell(board,emptyCell)){
            // if empty cell is not found then return true
            return true;
        }

        int rowIndex = emptyCell[0];
        int colIndex = emptyCell[1];

        for(int value = 1; value <= 9; value++){

            char charValue = (char) (value + '0');

            if(isPossibleToPlace(board,charValue,rowIndex,colIndex)){

                // if it is possible to place a value in empty cell, then place desired value to the particular cell
                board[rowIndex][colIndex] = charValue;

                // recursive call, if true return true
                if(solveSudokuSolver(board)){
                    return true;
                }

                // backtrack step
                board[rowIndex][colIndex] = '.';
            }
        }
        // and if no solution is present then simply return false
        return false;
    }

    static void sudokuSolver(char[][] board){

        solveSudokuSolver(board);
    }

    static void main() {

        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        sudokuSolver(board);
        // for printing answer of the sudoku problem
        for(int i = 0; i < 9; i++){

            for(int j = 0; j < 9; j++){

                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
}
