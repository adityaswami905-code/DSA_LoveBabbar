package DSA_LoveBabbar.Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class largestAreaInHistogram {

    //  LARGEST RECTANGLE IN HISTOGRAM

    /*

    Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.

Example 1:
Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.

Example 2:
Input: heights = [2,4]
Output: 4

Constraints:
1 <= heights.length <= 105
0 <= heights[i] <= 104

     */

    //  HISTOGRAM MAX RECTANGULAR AREA

    /*

    Given a histogram represented by an array arr[], where each element of the array denotes the height of the bars in the histogram. All bars have the same width of 1 unit.

Find the largest rectangular area possible in the given histogram, where the rectangle can be formed using a number of contiguous bars.

Examples:

Input: arr[] = [60, 20, 50, 40, 10, 50, 60]
Output: 100
Explanation: We get the maximum by picking bars highlighted above in green (50, and 60). The area is computed = 50 * 2 = 100.

Input: arr[] = [3, 5, 1, 7, 5, 9]
Output: 15
Explanation:  We get the maximum by picking bars 7, 5 and 9. The area is computed = 5 * 3 = 15.

Input: arr[] = [3]
Output: 3
Explanation: In this example the largest area would be 3 of height 3 and width 1.

Constraints:
1 ≤ arr.size() ≤ 105
0 ≤ arr[i] ≤ 104

Expected Complexities
Time Complexity: O(n)
Auxiliary Space: O(n)

Company Tags
Microsoft   Google  NPCI

     */

    // Previous smaller element logic( but with respect to index )
    static void findPreviousSmallerIndex(int[] heights, int[] prev){

        // using stack because follows monotonic stack pattern
        Deque<Integer> st = new ArrayDeque<>();
        // for optimize approach traversing from left to right
        for( int i = 0; i < heights.length; i++ ){

            int currIndex = i;

            // if we found previous larger index then simply pop it from stack
            while(!st.isEmpty() && heights[st.peek()] >= heights[currIndex]){
                st.pop();
            }
            // leftmost index
            if( st.isEmpty() ){
                prev[i] = -1;
            }
            // if stack is still not empty, then it means it contains useful element
            else{
                prev[i] = st.peek();
            }
            // push current element index
            st.push(currIndex);
        }
    }

    // next smaller index logic( but with respect to index)
    static void findNextSmallerIndex(int[] heights, int[] next){
        // Length of heights array
        int n = heights.length;
        // using stack because follows monotonic stack pattern
        Deque<Integer> st = new ArrayDeque<>();
        // for optimal approach we are traversing from right to left
        for( int i = n-1; i >= 0; i-- ){

            int currIndex = i;
            // if we found next greater index then simply pop it from stack
            while(!st.isEmpty() && heights[st.peek()] >= heights[currIndex]){
                st.pop();
            }
            // rightmost index
            if( st.isEmpty() ){
                next[i] = n;
            }
            // if stack is still not empty then that means it contains useful element index
            else{
                next[i] = st.peek();
            }
            // push current element index
            st.push(currIndex);
        }
    }

    static int largestRectangleArea(int[] heights){

        int[] prev = new int[heights.length];
        int[] next = new int[heights.length];
        // finding previous and next smaller index
        findPreviousSmallerIndex(heights,prev);
        findNextSmallerIndex(heights,next);
        // initially area is
        int maxArea = -1;

        for(int i = 0; i < heights.length; i++){
            // rectangle height
            int recHeight = heights[i];
            // rectangle width
            int recWidth = next[i] - prev[i] - 1;
            // area formula for rectangle
            int area = recHeight * recWidth;
            // Calculating maximum area of rectangle
            maxArea = Math.max(maxArea,area);
        }
        // return maximum area of rectangle
        return maxArea;
    }

    static void main() {

        int[] heights = {2,4};
        int ans = largestRectangleArea(heights);
        System.out.println(
                "Largest Rectangle Area In Histogram: " + ans +" Units"
        );
    }
}
