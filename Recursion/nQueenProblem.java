package DSA_LoveBabbar.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class nQueenProblem {

    //  N-QUEENS

    /*

    The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.



Example 1:


Input: n = 4
Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
Example 2:

Input: n = 1
Output: [["Q"]]


Constraints:

1 <= n <= 9

     */

    static boolean isSafeToPlace(int rowIndex, int colIndex, int n, char[][] board){

        // isSafeToPlace function/method mein woh logic rahega jaha queen rakh sakte hai ye phir nahi rakh sakte hai
        // jaise ke hume pata hai ki queen 8 direction mein move karti hai
        // i.e. vertically up,down; horizontally left, right; upper left,right diagonal and lower left,right diagonal direction
        // but yaha sirf 3 possibility check karni hai i.e. horizontally left, upper left diagonal and lower left diagonal direction
        // kyon ki ek column mein sirf ek he queen rakhni hai toh vertical up,down mein check karna koi sense nahi banata
        // aur queen left to right rakhi jaa rahi hai to upper right diagonal, horizontally right aur lower right diagonal direction is cancelled to check

        // For horizontal left
        int row = rowIndex;
        int col = colIndex;

        while(col >= 0){

            if(board[row][col] == 'Q'){
                return false;
            }
            col--;
        }

        // For upper left diagonal
        row = rowIndex;
        col = colIndex;

        while(row >= 0 && col >= 0){

            if(board[row][col] == 'Q'){
                return false;
            }
            row--;
            col--;
        }

        // For lower left diagonal
        row = rowIndex;
        col = colIndex;

        while(row < n && col >= 0){

            if(board[row][col] == 'Q'){
                return false;
            }
            row++;
            col--;
        }

        // else case
        return true;
    }

    static void solve(int n, char[][] board, List<List<String>> ans, int colIndex){

        // Base case
        // If colIndex goes out of bound or beyond n
        if(colIndex >= n){

            List<String> temp = new ArrayList<>();
            for(int i = 0; i < n; i++){
                temp.add(new String(board[i]));
            }

            ans.add(temp);
            return;

        }

        // 1 case khud solve karo, baki recursion solve karega

        for(int rowIndex = 0; rowIndex < n; rowIndex++){

            // Agar uss particular cell pe 'Q' rakh na safe hai toh, rakh sakte hai
            if(isSafeToPlace(rowIndex,colIndex,n,board)){

                board[rowIndex][colIndex] = 'Q';
                // Recursive call
                solve(n,board,ans,colIndex+1);
                //Backtrack step
                board[rowIndex][colIndex] = '.';
            }
        }
    }

    static List<List<String>> nQueenSolve(int n){

        char[][] board = new char[n][n];
        // Initially it assigns '.' value in all cells of a board
        for(int i = 0; i < n; i++){
            Arrays.fill(board[i],'.');
        }

        List<List<String>> ans = new ArrayList<>();
        int colIndex = 0;

        solve(n,board,ans,colIndex);
        return ans;
    }

    //  N QUEEN PROBLEM (GFG)

    /*

    The N-Queens puzzle is the problem of placing N queens on an N * N chessboard such that no two queens attack each other. Two queens attack each other if they are placed in the same row, the same column, or the same diagonal.

Given an integer n representing the number of queens, find all distinct solutions to this puzzle. Each solution should be represented as an array of size n, where the ith element (1-based indexing) denotes the column position of the queen placed in the ith row.

Note: You may return the solutions in any order.

Examples:

Input: n = 1
Output: [1]
Explanation: Only one queen can be placed in the single cell available.
Input: n = 4
Output: [[2, 4, 1, 3], [3, 1, 4, 2]]
Explanation: There are 2 possible solutions for n = 4.

Input: n = 3
Output: []
Explanation: There are no possible solutions for n = 3.
Constraints:
1 ≤ n ≤ 10



     */

    // Similar question as asked in leetcode but difference is, in leetcode blank cell is represented as '.' and queen cell as 'Q'
    // where as in GFG N Queen problem, we have to show the column number starting with 1, which show the queen present in nth column cell

    static boolean isPossibleToPlace(int rowIndex, int columnIndex, int n, int[][] chessBoard){

        int r = rowIndex;
        int c = columnIndex;

        while(c >= 0){
            if(chessBoard[r][c] != 0){
                return false;
            }
            c--;
        }

        r = rowIndex;
        c = columnIndex;
        while(r >= 0 && c >= 0){
            if(chessBoard[r][c] != 0){
                return false;
            }
            r--;
            c--;
        }

        r = rowIndex;
        c = columnIndex;
        while(r < n && c >= 0){
            if(chessBoard[r][c] != 0){
                return false;
            }
            r++;
            c--;
        }

        return true;
    }

    static void evaluate(int n, int[][] chessBoard, int columnIndex, ArrayList<ArrayList<Integer>> ans){

        if(columnIndex >= n){

            ArrayList<Integer> output = new ArrayList<>();
            for(int i = 0; i < n; i++){

                for(int j = 0; j < n; j++){

                    if(chessBoard[i][j] != 0){
                        output.add(chessBoard[i][j]);
                        break;

                    }

                }
            }
            ans.add(output);
            return;
        }

        for(int rowIndex = 0; rowIndex < n; rowIndex++){

            if(isPossibleToPlace(rowIndex,columnIndex,n,chessBoard)){

                chessBoard[rowIndex][columnIndex] = columnIndex+1;
                evaluate(n,chessBoard,columnIndex+1,ans);

                chessBoard[rowIndex][columnIndex] = 0;
            }
        }
    }

    static ArrayList<ArrayList<Integer>> nQueen(int n){

        int[][] chessBoard = new int[n][n];
        for(int i = 0; i < n; i++){
            Arrays.fill(chessBoard[i],0);
        }

        int columnIndex = 0;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        evaluate(n,chessBoard,columnIndex,ans);
        return ans;
    }

    static void main() {

//        int n = 4;
//        List<List<String>> result = nQueenSolve(n);
//        System.out.print("Number of possible arrangement are: "+result);

        int n = 4;
        ArrayList<ArrayList<Integer>> solution = nQueen(n);
        System.out.print("Number of possible arrangement are: "+solution);
    }
}
