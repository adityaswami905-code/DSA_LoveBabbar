package DSA_LoveBabbar.Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class dailyTemperatures {

    //  DAILY TEMPERATURES

    /*

    Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.

Example 1:
Input: temperatures = [73,74,75,71,69,72,76,73]
Output: [1,1,4,2,1,1,0,0]

Example 2:
Input: temperatures = [30,40,50,60]
Output: [1,1,1,0]

Example 3:
Input: temperatures = [30,60,90]
Output: [1,1,0]

Constraints:
1 <= temperatures.length <= 105
30 <= temperatures[i] <= 100

     */

    // Brute force approach
    // T.C. = O(n^2) and S.C. = O(1)
    static int[] dailyTemp(int[] temperatures){

        int n = temperatures.length;
        // for answer array
        int[] ans = new int[n];

        // traversing in temperatures array
        for( int i = 0; i < n; i++ ){

            // for moving right or comparing right element with current element
            for( int j = i+1; j < n; j++ ){
                // got the warmer day
                if( temperatures[j] > temperatures[i] ){
                    // therefore number of days between the next warmer day is
                    ans[i] = j-i;
                    break;
                }
            }
        }
        // return answer array
        return ans;
    }

    // Optimize approach i.e. using stack
   // Monotonic Decreasing Stack (Optimal)
   // Use a stack to store the indices of days that are still waiting for a warmer temperature.
   // Traverse the array once from left to right:
   // While the stack is not empty and the current day's temperature is greater than
   // the temperature at the index stored at the top of the stack, pop that index.
   // The difference between the current index and the popped index is the number of days waited.
   // Push the current index onto the stack.
   // Complexity: Time O(n) and Space O(n), because each index is pushed and popped at most once.
    static int[] dailTemp2(int[] temperatures){

        int n = temperatures.length;
        int[] ans = new int[n];

        Deque<Integer> st = new ArrayDeque<>();

        for( int i = 0; i < n; i++ ){

            while(!st.isEmpty() && temperatures[i] > temperatures[st.peek()]){

                int previousDay = st.pop();
                ans[previousDay] = i - previousDay;
            }
            st.push(i);
        }

        return ans;
    }

    static void main() {

        int[] temperatures = {73,74,75,71,69,72,76,73};
        int[] output = dailyTemp(temperatures);
        System.out.print(
                "Number of days to wait a respective warmer day: "
        );
        for( int out : output ){
            System.out.print(out + " ");
        }
        System.out.println();

        System.out.print(
                "Number of days to wait a respective warmer day: "
        );
        for( int out : output ){
            System.out.print(out + " ");
        }
        System.out.println("(Second approach)");
    }
}
