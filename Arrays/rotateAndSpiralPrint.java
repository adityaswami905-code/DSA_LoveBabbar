package DSA_LoveBabbar.Arrays;

import java.util.ArrayList;
import java.util.List;

public class rotateAndSpiralPrint {

    //  ROTATE IMAGE

    static void rotate90Clockwise(int[][] matrix, int N) {

//        Step1 -> Transpose of a matrix
        for (int row = 0; row < N; row++) {
            for (int col = row + 1; col < N; col++) {
                // Swap
                int temp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = temp;
            }
        }

//        Step2 -> Reverse the all row elements
        for (int row = 0; row < N; row++) {


            int colStart = 0;
            int colEnd = N - 1;

            while (colStart <= colEnd) {
//            swap
                int temp = matrix[row][colStart];
                matrix[row][colStart] = matrix[row][colEnd];
                matrix[row][colEnd] = temp;

                colStart++;
                colEnd--;
            }

        }
    }

    //  SPIRAL PRINT A MATRIX

    static List<Integer> spiralPrint(int[][] matrix){

        int m = matrix.length;
        int n = matrix[0].length;

        List<Integer> result = new ArrayList<>();

        int startingRow = 0;
        int endingRow = m-1;
        int startingCol = 0;
        int endingCol = n-1;

        while (startingRow <= endingRow && startingCol <= endingCol){

            // Travel in row from left to right
            for(int col = startingCol; col <= endingCol; col++){
                result.add(matrix[startingRow][col]);
            }
            startingRow++;

            // Travel in col from top to bottom
            for(int row = startingRow; row <= endingRow; row++){
                result.add(matrix[row][endingCol]);
            }
            endingCol--;

            // Travel in row from right to left
            if(startingRow <= endingRow){
                for(int col = endingCol; col >= startingCol; col--){
                    result.add(matrix[endingRow][col]);
                }
                endingRow--;
            }


            // Travel in col from bottom to up
            if(startingCol <= endingCol){
                for(int row = endingRow; row >= startingRow; row--){
                    result.add(matrix[row][startingCol]);
                }
                startingCol++;

            }
        }
        return result;
    }


    static void main() {

//        int[][] matrix = {
//                            {1,2,3},
//                            {4,5,6},
//                            {7,8,9}
//                         };
//        rotate90Clockwise(matrix,3);
//        for(int[] row : matrix){
//            for(int num : row){
//                System.out.print(num+" ");
//            }
//            System.out.println();
//        }

        int[][] matrix = {
                            {1,2,3,4,5},
                            {6,7,8,9,10},
                            {11,12,13,14,15},
                            {16,17,18,19,20},
                            {21,22,23,24,25}
                         };
        List<Integer> ans = spiralPrint(matrix);
        System.out.print(ans+" ");
    }
}
