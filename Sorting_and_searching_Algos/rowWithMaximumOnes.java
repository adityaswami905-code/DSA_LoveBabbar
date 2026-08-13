package DSA_LoveBabbar.Sorting_and_searching_Algos;

public class rowWithMaximumOnes {

    //  ROW WITH MAX 1'S IN ROWWISE SORTED

    /*

You are given a 2D binary array arr[][] consisting of only 1s and 0s. Each row of the array is sorted in non-decreasing order. Your task is to find and return the index of the first row that contains the maximum number of 1s. If no such row exists, return -1.

Note:

The array follows 0-based indexing.
The number of rows and columns in the array are denoted by n.
Examples:

Input: arr[][] = [[0,1,1,1],
               [0,0,1,1],
               [1,1,1,1],
               [0,0,0,0]]
Output: 2
Explanation: Row 2 contains the most number of 1s (4 1s). Hence, the output is 2.
Input: arr[][] = [[0,0],
               [1,1]]
Output: 1
Explanation: Row 1 contains the most number of 1s (2 1s). Hence, the output is 1.
Input: arr[][] = [[0,0],
               [0,0]]
Output: -1
Explanation: No row contains any 1s, so the output is -1.
Constraints:
1 ≤ arr.size(), arr[i].size() ≤ 103

     */

    // Logic to find the index of first occurrence of 1's in a row;
    static int indexOfFirstOccOfOnesInRow(int[][] mat, int row){

        int totalRow = mat.length;;
        int totalCol = mat[0].length;

        int ans = -1;

//        Condition where there are no 1's in a row
        if(mat[row][totalCol-1] == 0){
            return totalCol;

        }else{
//            Condition where there are multiple 1's in a row

            int s = 0;
            int e = totalCol-1;

            while(s <=e ){

                int mid = s + (e-s)/2;

                if(mat[row][mid] == 0){
                    // Agar mat[row][mid] element agar zero hai, iska matlab answer right side mein hoga, kyoun ki
//                    yaha ek sorted arrray hai (0's aur 1's ke form mein)
//                    Therefore move right
                    s = mid+1;
                }else{
//                    mat[row][mid] == 1
//                    Iska matlab ye ek potential answer ho sakta hai, toh abhi ke liye ye potential answer store karte hai
//                    Aur left side mein move karte hai, final answer ki khoj mein
                    ans = mid;
                    // Move left
                    e = mid-1;
                }
            }
        }
        return ans;
    }

    static int indexOfRowWithMaxOnes(int[][] mat){

        int totalRow = mat.length;
        int totalCOl = mat[0].length;

        int maxi = -1;
        int maxiWaliKaRowIndex = -1;

        for(int row = 0; row < totalRow; row++){

            int firstOcc = indexOfFirstOccOfOnesInRow(mat,row);
            // Total number ones in a row can be calculated by subtracting (the totalCol of that row - index of the first occurrence of 1's)
            int totalCount = totalCOl - firstOcc;

            if(totalCount != 0 && totalCount > maxi){
                maxi = totalCount;
                maxiWaliKaRowIndex = row;
            }
        }
        return maxiWaliKaRowIndex;

    }
    static void main() {

        int[][] mat = {
                        {0,1,1,1},
                        {0,0,1,1},
                        {1,1,1,1},
                        {0,0,0,0}
                    };

//        int[][] mat = {
//                        {0,0},
//                        {1,1}
//                      };

//        int[][] mat = {
//                        {0,0},
//                        {0,0}
//                    };
        int ans = indexOfRowWithMaxOnes(mat);
        System.out.print("Index of the row with maximum number of 1's is: "+ans);
    }
}
