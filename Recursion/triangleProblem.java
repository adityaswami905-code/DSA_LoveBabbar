package DSA_LoveBabbar.Recursion;

import java.util.List;

public class triangleProblem {

    //  TRIANGLE PROBLEM

    /*

    Given a triangle array, return the minimum path sum from top to bottom.

For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.

Example 1:

Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
Output: 11
Explanation: The triangle looks like:
   2
  3 4
 6 5 7
4 1 8 3
The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).
Example 2:

Input: triangle = [[-10]]
Output: -10

Constraints:

1 <= triangle.length <= 200
triangle[0].length == 1
triangle[i].length == triangle[i - 1].length + 1
-104 <= triangle[i][j] <= 104

     */

    static int solve(List<List<Integer>> triangle, int rowIndex, int colIndex){

        if(rowIndex == triangle.size()-1){
            return triangle.get(rowIndex).get(colIndex);
        }

        int downIndex = solve(triangle,rowIndex+1,colIndex);
        int diagIndex = solve(triangle,rowIndex+1,colIndex+1);

        int overallAns = triangle.get(rowIndex).get(colIndex) + Math.min(downIndex,diagIndex);
        return overallAns;
    }

    static int minimumTotal(List<List<Integer>> triangle){

        int rowIndex = 0;
        int colIndex = 0;
        int ans = solve(triangle,rowIndex,colIndex);
        return ans;
    }

    static void main() {

        List<List<Integer>> triangle = List.of(
                List.of(2),
                List.of(3, 4),
                List.of(6, 5, 7),
                List.of(4, 1, 8, 3)
        );
        int result = minimumTotal(triangle);
        System.out.print("Minimum total: "+result);

    }
}
