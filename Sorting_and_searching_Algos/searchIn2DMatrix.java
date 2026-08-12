package DSA_LoveBabbar.Sorting_and_searching_Algos;

public class searchIn2DMatrix {

    //  SEARCH A 2D MATRIX - I

    /*

You are given an m x n integer matrix matrix with the following two properties:

Each row is sorted in non-decreasing order.
The first integer of each row is greater than the last integer of the previous row.
Given an integer target, return true if target is in matrix or false otherwise.

You must write a solution in O(log(m * n)) time complexity.

Example 1:
Input: matrix = [
                [1,3,5,7],
                [10,11,16,20],
                [23,30,34,60]
                ],
target = 3
Output: true

Example 2:
Input: matrix = [
                [1,3,5,7],
                [10,11,16,20],
                [23,30,34,60]
                ],
target = 13
Output: false

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 100
-104 <= matrix[i][j], target <= 104


     */

//    Note - > The first integer of each row is greater than the last integer of the previous row.
//    (This condition must exist in the question, then only the below code will give correct output)
//    Formula to calculate rowIndex => mid / totalCols and to calculate colIndex => mid % totalCols

    static boolean searchMatrix(int[][] matrix, int target){

        int totalRows = matrix.length;;
        int totalCols = matrix[0].length;
        int n = totalRows * totalCols;

        int s = 0;
        int e = n-1;

        while( s <= e){

            int mid = s + (e-s)/2;
            int rowIndex = mid / totalCols;
            int colIndex = mid % totalCols;

            if(matrix[rowIndex][colIndex] == target){
                return true;

            } else if (matrix[rowIndex][colIndex] > target) {
                e = mid-1;

            }else{
                s = mid+1;

            }
        }
        return false;
    }

    //  SEARCH IN A 2D MATRIX - II

    /*
Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.

Example 1:
Input: matrix = [
                [1,4,7,11,15],
                [2,5,8,12,19],
                [3,6,9,16,22],
                [10,13,14,17,24],
                [18,21,23,26,30]
                ],
target = 5
Output: true
Example 2:

Input: matrix = [
                [1,4,7,11,15],
                [2,5,8,12,19],
                [3,6,9,16,22],
                [10,13,14,17,24],
                [18,21,23,26,30]
                ],
target = 20
Output: false

Constraints:

m == matrix.length
n == matrix[i].length
1 <= n, m <= 300
-109 <= matrix[i][j] <= 109
All the integers in each row are sorted in ascending order.
All the integers in each column are sorted in ascending order.
-109 <= target <= 109
     */

    static boolean searchMatrix2(int matrix[][], int target){

        int totalRows = matrix.length;
        int totalCols = matrix[0].length;

        int row = 0;
        int col = totalCols-1;

//        i.e. Searching started from top right corner in 2D matrix (i.e. ladder approach left-down,left-down)

        while ( row < totalRows && col >= 0){

            if(matrix[row][col] == target){
                return true;

            } else if (matrix[row][col] > target) {
                // Move left
                col--;

            }else{
                // Move right
                row++;
            }
        }
        return false;
    }

    static void main() {

//        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
//        boolean ans =  searchMatrix(matrix,3);
//        System.out.print("Search element is present in 2D matrix: "+ans);

        int[][] matrix = {
                            {1,4,7,11,15},
                            {2,5,8,12,19},
                            {3,6,9,16,22},
                            {10,13,14,17,24},
                            {18,21,23,26,30}
                        };
        boolean ans = searchMatrix2(matrix,5);
        System.out.print("Search element is present in 2D matrix: "+ans);
    }
}
