package DSA_LoveBabbar.Recursion;

public class partitionEqualSubsetSum {

    //  PARTITION EQUAL SUBSET SUM

    /*

    Given an integer array nums, return true if you can partition the array into two subsets such that the sum of the elements in both subsets is equal or false otherwise.

Example 1:

Input: nums = [1,5,11,5]
Output: true
Explanation: The array can be partitioned as [1, 5, 5] and [11].
Example 2:

Input: nums = [1,2,3,5]
Output: false
Explanation: The array cannot be partitioned into equal sum subsets.

Constraints:

1 <= nums.length <= 200
1 <= nums[i] <= 100

     */

    static boolean solve(int target, int[] arr, int index){

        // Base case
        if(target == 0){
            return true;
        }
        if(target < 0){
            return false;
        }
        if(index >= arr.length){
            return false;
        }

        // include exclude pattern
        boolean includeAns = solve(target - arr[index],arr,index+1);
        boolean excludeAns = solve(target,arr,index+1);
        return includeAns || excludeAns;
    }

    static boolean canPartition(int[] arr){

        int index = 0;
        int sum = 0;

        for(int num:arr){
            sum += num;
        }
        // If the sum of the elements gives the odd number, then it is not possible to divide them into equal two subset
        if((sum & 1) == 1){
            return false;
        }

        int target = sum/2;

        boolean ans = solve(target,arr,index);
        return ans;
    }

    static void main() {

        int[] arr ={ 1,5,11,5};
        boolean result = canPartition(arr);
        System.out.print("Can partition the array into two subsets such that the sum of the elements in both subsets is equal: "+result);
    }
}
