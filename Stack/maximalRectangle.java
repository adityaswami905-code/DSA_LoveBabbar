package DSA_LoveBabbar.Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class maximalRectangle {

    //  MAXIMAL A RECTANGLE

    /*

    Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

Example 1:
Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
Output: 6
Explanation: The maximal rectangle is shown in the above picture.

Example 2:
Input: matrix = [["0"]]
Output: 0

Example 3:
Input: matrix = [["1"]]
Output: 1


Constraints:
rows == matrix.length
cols == matrix[i].length
1 <= rows, cols <= 200
matrix[i][j] is '0' or '1'.

     */

    // logic behind finding Next Smaller Index
    static void findPreviousSmallerIndex(int[] heights, int[] prev){

        // Using stack due to monotonic stack pattern
        Deque<Integer> st = new ArrayDeque<>();

        // traversing from left to right
        for( int i = 0; i < heights.length; i++ ){

            int currIndex = i;

            // if we found any index which contains previous greater element then simply pop it
            while( !st.isEmpty() && heights[st.peek()] >= heights[currIndex] ){
                st.pop();
            }
            // if stack is empty,then return leftmost index
            if( st.isEmpty() ){
                prev[i] = -1;
            }
            // if stack is still not empty that means it contains useful element Index
            else{
                prev[i] = st.peek();
            }
            st.push(currIndex);
        }
    }

    // logic behind finding Next Smaller Index
    static int findNextSmallerIndex(int[] heights, int[] next){

        int n = heights.length;
        // Using stack due to monotonic stack pattern
        Deque<Integer> st = new ArrayDeque<>();

        // for optimal approach traversing from right to left
        for( int i = n-1; i >= 0; i-- ){

            int currIndex = i;

            // if there is next greater index then simply pop it
            while( !st.isEmpty() && heights[st.peek()] >= heights[currIndex] ){
                st.pop();
            }
            // if stack becomes empty, return rightmost index
            if( st.isEmpty() ){
                next[i] = n;
            }
            // if stack is still not empty then it means it contains useful index
            else{
                next[i] = st.peek();
            }
            st.push(currIndex);
        }
    }

    static int getMaxArea(int[] heights){

        // for finding previous smaller index
        int[] prev = new int[heights.length];
        // for finding next smaller index
        int[] next = new int[heights.length];

        findPreviousSmallerIndex(heights,prev);
        findNextSmallerIndex(heights,next);

        int maxArea = 0;
        for( int i = 0; i < heights.length; i++ ){

            int height = heights[i];
            int width = next[i] - prev[i] - 1;
            int area = height * width;
            maxArea = Math.max(maxArea,area);
        }
        return maxArea;
    }

    static int maximalRecArea(char[][] matrix){

        // calculating number of rows and columns from a given 2D matrix
        int rows = matrix.length;
        int cols = matrix[0].length;

        // i.e. if we get invalid rows and cols
        if( matrix.length == 0 || matrix[0].length == 0 ){
            return 0;
        }

        // Evaluating given 2D matrix using 1D array approach
        int[] heights = new int[rows];

        // initially maximum area 0 i.e. not -1 because if we found height and width is zero then area 0 is valid one
        int maxArea = 0;

        for( int i = 0; i < rows; i++ ){

            for( int j = 0; j < cols; j++ ){

                // if we found '1' in a cell then it is valid to consider
                if( matrix[i][j] == '1' ){
                    heights[j]++;
                }
                else{
                    // if we found '0' in a cell then it is invalid to consider
                    // because if the base of heights starts from zero then it is considered as zero
                    // even if it contains 1 above the base
                    // matrix[i][j] == '0'
                    heights[j] = 0;
                }

            }
            int area = getMaxArea(heights);
            maxArea = Math.max(maxArea,area);

        }
        return maxArea;
    }

    static void main() {

        char[][] matrix = {};
        int ans = maximalRecArea(matrix);
        System.out.println(
                "Maximal Rectangle area: " + ans + "sq.unit"
        );
    }
}
