package DSA_LoveBabbar.Recursion;

public class jumpGame {

    //  JUMP GAME

    /*

    You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.

Return true if you can reach the last index, or false otherwise.

Example 1:

Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.

Constraints:

1 <= nums.length <= 104
0 <= nums[i] <= 105

     */

    static boolean solve(int[] arr, int index){

        if(index == arr.length-1){
            return true;
        }
        if(index >= arr.length){
            return false;
        }
        if(arr[index] == 0){
            return false;
        }

        int jumpValue = arr[index];
        boolean overallAns = false;

        for(int jump = 1; jump <= jumpValue; jump++){

            boolean recAns = solve(arr,index+jump);
            overallAns = overallAns || recAns;
        }
        return overallAns;
    }

    static boolean canJump(int[] arr){

        int index = 0;
        boolean ans = solve(arr,index);
        return ans;
    }

    static void main() {

        int[] arr = {2,3,1,1,4};
        boolean result = canJump(arr);
        System.out.print("Can you reached the last index: "+result);
    }
}
