package DSA_LoveBabbar.Stack;

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

    static void main() {

        int[] temperatures = {30,60,90};
        int[] output = dailyTemp(temperatures);
        System.out.print(
                "Number of days to wait a respective warmer day: "
        );
        for( int out : output ){
            System.out.print(out + " ");
        }
        System.out.println();
    }
}
