package DSA_LoveBabbar.Recursion;

public class subsequenceWithSumK {

    //  SUBSEQUENCE WITH SUM K

    /*

    Given an array arr[] and target sum k, check if there exists a subsequence such that the sum of all elements in the subsequence equals to k.

Examples:

Input: arr = [10, 1, 2, 7, 6, 1, 5], k = 8.
Output: true
Explanation: Subsequences like [2, 6], [1, 7] sum upto 8
Input: arr = [2, 3, 5, 7, 9], k = 100.
Output: false
Explanation: No subsequence can sum upto 10
Constraints:

1 ≤ k, arr.size() ≤ 2000
1 ≤ arr[i] ≤ 1000

     */

    static boolean solve(int[] arr, int k, int index, int sum){

        if(index >= arr.length){

            if(sum == k)
                return true;
            else
                return false;
        }

        int currValue = arr[index];

        boolean includeAns = solve(arr,k,index+1,sum+currValue);
        boolean excludeAns = solve(arr,k,index+1,sum);
        return includeAns || excludeAns;
    }

    static boolean checkSubsequenceSum(int[] arr, int k){

        int index = 0;
        int sum = 0;
        boolean ans = solve(arr,k,index,sum);
        return ans;
    }

    static void main() {

        int[] arr ={10, 1, 2, 7, 6, 1, 5};
        int k =8;
        boolean result = checkSubsequenceSum(arr,k);
        System.out.print("There exists a subsequence such that the sum of all elements in the subsequence equals to k: "+result);
    }
}
