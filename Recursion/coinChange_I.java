package DSA_LoveBabbar.Recursion;

public class coinChange_I {

    //  COIN CHANGE I

    /*

    You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.

Example 1:

Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Example 3:

Input: coins = [1], amount = 0
Output: 0

Constraints:

1 <= coins.length <= 12
1 <= coins[i] <= 231 - 1
0 <= amount <= 104



     */

    static int solve(int[] coins, int amount){

        // Base case
        if(amount == 0){
            return 0;
        }
        if(amount < 0){
            return Integer.MAX_VALUE;
        }

        int mini = Integer.MAX_VALUE;

        // trying to solve with all possible combination
        for(int coin:coins){

            int recursionWalaAns = solve(coins, amount - coin);

            if(recursionWalaAns != Integer.MAX_VALUE){
                int finalAns = recursionWalaAns + 1;
                mini = Math.min(mini, finalAns);
            }
        }
        return mini;
    }

    static int change(int[] coins, int amount){
        int ans = solve(coins,amount);
        if(ans == Integer.MAX_VALUE){
            return -1;
        }else{
            return ans;
        }
    }
    static void main() {
        int[] coins = {1,2,5};
        int amount = 11;
        int result = change(coins,amount);
        System.out.print("The fewest number of coins that need to make up that amount: "+result);
    }
}
