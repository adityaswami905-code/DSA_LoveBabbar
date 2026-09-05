package DSA_LoveBabbar.Recursion;

public class coinChange_II {

    //  COIN CHANGE II

    /*

    You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0.

You may assume that you have an infinite number of each kind of coin.

The final answer is guaranteed to fit into a signed 32-bit integer.

Example 1:

Input: amount = 5, coins = [1,2,5]
Output: 4
Explanation: there are four ways to make up the amount:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1
Example 2:

Input: amount = 3, coins = [2]
Output: 0
Explanation: the amount of 3 cannot be made up just with coins of 2.
Example 3:

Input: amount = 10, coins = [10]
Output: 1

Constraints:

1 <= coins.length <= 300
1 <= coins[i] <= 5000
All the values of coins are unique.
0 <= amount <= 5000

     */

    static int solve(int amount, int[] coins, int index){

        // Base case
        if(amount == 0){
            return 1;
        }
        if(amount < 0){
            return 0;
        }
        if(index >= coins.length) {
            return 0;
        }

        // ek case khud se solve karlo, baaki recursion sambhal lega
        // maanlo abhi hamare paas 5 ka coin hain aut amount 40 hai
        // toh final amount 40-5 i.e. 35 hoga
        // aur current index ko include kiya hai toh mein current index ke coin ko bar bar use kar sakta hu
        // i.e. infinite sublime, aur agar mein usko ko ek baar exculde kardu toh ukse baad mein usse use nahi kar sakta
        int includeAns = solve(amount - coins[index],coins,index);
        // maanlo tum ne coin use nahi kiya toh amount me koi change nhi hoga i.e. amount=40
        // aur use nahi kiya matlab agla coin use karne wale ho, toh index+1
        int excludeAns = solve(amount,coins,index+1);
        int finalAns = includeAns + excludeAns;
        return finalAns;
    }

    static int change(int amount, int[] coins){

        int index = 0;
        int ans = solve(amount,coins,index);
        return ans;
    }

    static void main() {

        int amount = 5;
        int[] coins = {1,2,5};
        int result = change(amount,coins);
        System.out.print("Total number of ways: "+ result);

    }
}
