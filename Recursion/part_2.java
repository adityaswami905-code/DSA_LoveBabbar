package DSA_LoveBabbar.Recursion;

public class part_2 {

    //  CLIMBING STAIRS

    /*

You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Example 1:

Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps

Example 2:

Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step

Constraints:

1 <= n <= 45

     */

    // This code is correct but submitting it on leet code may lead to TLE i.e. Time Limit Exceed (I will optimise this code , when i will start DP i.e. Dynamic Programming)

    static int climbingStairs(int n){

        // Base case
        if( n == 1 ){
            return 1;
        }

        if( n == 2){
            return 2;

        }
        int ans = climbingStairs(n-1) + climbingStairs(n-2);
        return ans;
    }

    static void main() {


        int n = 4;
        int result = climbingStairs(n);
        System.out.print("Number of ways to climb the stairs: "+result);
    }
}
