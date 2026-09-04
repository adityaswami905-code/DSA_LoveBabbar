package DSA_LoveBabbar.Recursion;

public class houseRobber {


    //  HOUSE ROBBER

    /*

   You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

Example 1:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
Example 2:

Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
Total amount you can rob = 2 + 9 + 1 = 12.

Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 400

     */


    static int solve(int[] arr, int index){

        // Base case
        if(index >= arr.length){
            return 0;
        }

        // take-notTake approach

        int includeAns = arr[index] + solve(arr,index+2);
        int excludeAns = 0 + solve(arr, index + 1);
        int finalAns = Math.max(includeAns,excludeAns);
        return finalAns;
    }

    static int rob(int[] arr){

        int index = 0;
        int ans = solve(arr,index);
        return ans;

    }


    //  HOUSE ROBBER (gfg)

    /*

    Given two integers n and k, where there are n houses arranged in a row and each house contains k amount of money, find the maximum amount of money a thief can rob without robbing two adjacent houses. Return the maximum amount of money that can be robbed.

Examples:

Input: n = 5, k = 10
Output: 30
Explanation: The Robber can rob from the first, third and fifth houses which will result in 30.
Input: n = 2, k = 12
Output: 12
Explanation: The Robber can only rob from the first or second which will result in 12.
Constraints:
1 ≤ n, k ≤ 103

     */

    static int evaluate(int n, int k, int i){

        if(i >= n){
            return 0;
        }

        int finalAns = k + evaluate(n,k,i+2);
        return finalAns;
    }

    static int maximizeMoney(int n, int k){

        int i = 0;
        int ans = evaluate(n,k,i);
        return ans;
    }
    static void main() {

        int[] arr = {2,7,9,3,1};
        int result = rob(arr);
        System.out.print("The maximum amount of money robbed is: "+result);

//        int result = maximizeMoney(5,10);
//        System.out.print("The maximum amount of money robbed is: "+result);

    }
}
