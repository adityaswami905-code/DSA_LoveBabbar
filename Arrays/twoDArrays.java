package DSA_LoveBabbar.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class twoDArrays {

    //  PRINT THE SUM OF EACH ROW IN 2D ARRAY

    static List<Integer> sumOfEachRow(int[][] arr){

        List<Integer> result = new ArrayList<>();

        int m = arr.length; // for rows
        int n = arr[0].length; // for cols

        for(int row = 0; row < m; row++){
            int sum = 0;

            for(int col = 0; col < n; col++){
                sum = sum + arr[row][col];


            }
            result.add(sum);
        }
        return result;
    }

    //  PRINT THE SUM OF EACH COLS IN 2D ARRAY

    static List<Integer> sumOfEachCol(int[][] arr){

        List<Integer> result = new ArrayList<>();

        int m = arr.length; // For rows
        int n = arr[0].length; // For Cols

        for(int col = 0; col < n; col++){
            int sum = 0;

            for(int row = 0; row < m; row++){
                sum = sum + arr[row][col];
            }
            result.add(sum);
        }
        return result;
    }

    //  WAVE PRINT A MATRIX (Print the element through wave direction i.e. col[0] top to down and col[1] bottom to up and so on)

    static List<Integer> wavePrintMatrix(int[][]arr,int m, int n){

        List<Integer> result = new ArrayList<>();

        // m for no. of rows
        // n for no. of cols

        for(int col = 0; col < n; col++){

            if((col & 1) == 1){

//                for odd index col element sum
//                bottom to up approach
                for(int row = m-1; row >= 0; row--){
                    result.add(arr[row][col]);
                }

            }else{
//                for even index col element sum
//                top to down approach
                for(int row = 0; row < m; row++){
                    result.add(arr[row][col]);
                }
            }
        }
        return result;
    }

    //  TRANSPOSE OF A MATRIX

    static int[][] transposeMatrix(int[][] arr){

        if(arr == null || arr.length == 0){
            return new int[0][0];
        }

//        for original array
        int totalRows = arr.length;
        int totalCols = arr[0].length;

//        for new array
        int newTotalRows = totalCols;
        int newTotalCols = totalRows;

        int[][] newArr = new int[newTotalRows][newTotalCols];

//        Actual logic
        for(int row = 0; row < totalRows; row++){
            for(int col = 0; col < totalCols; col++){
                newArr[col][row] = arr[row][col];
            }

        }
        return newArr;
    }

    static void main() {

//        int[][] arr = {
//                        {1,2,3},
//                        {4,5,6},
//                        {7,8,9}
//                      };
//        List<Integer> ans = sumOfEachRow(arr);
//        System.out.print("Sum of the each row in 2D array is: "+ans);

//        int[][] arr = {
//                        {9,8,7},
//                        {6,5,4},
//                        {3,2,1}
//                      };
//        List<Integer> ans = sumOfEachCol(arr);
//        System.out.print("Sum of the each cols in 2D array is: "+ ans);

//        int[][] arr = {
//                        {1,4,7},
//                        {2,5,8},
//                        {3,6,9}
//                      };
//        List<Integer> ans = wavePrintMatrix(arr,3,3);
//        System.out.print("Sum of the wave elements in a 2D matrix is: "+ans);

        int[][] arr = {
                        {1,2,3},
                        {4,5,6},
                        {7,8,9}
                      };
        int[][] ans = transposeMatrix(arr);
        System.out.println(Arrays.deepToString(ans));
    }
}
