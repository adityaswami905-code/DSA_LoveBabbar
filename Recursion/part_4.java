package DSA_LoveBabbar.Recursion;

public class part_4 {

    //  BINARY SEARCH (RECURSIVE)

    /*

Given an array arr[], sorted in ascending order and an integer k. Return true if k is present in the array, otherwise, false.

Examples:

Input: arr[] = [1, 2, 3, 4, 6], k = 6
Output: true
Explanation: Since, 6 is present in the array at index 4 (0-based indexing), output is true.

Input: arr[] = [1, 2, 4, 5, 6], k = 3
Output: false
Explanation: Since, 3 is not present in the array, output is false.

Input: arr[] = [2, 3, 5, 6], k = 1
Output: false

Constraints:
1 ≤ arr.size() ≤ 106
1 ≤ k ≤ 106
1 ≤ arr[i] ≤ 106

     */

    static boolean solve(int[] arr, int k, int s, int e){

        // Base case
        if( s > e){
            return false;
        }

        // Processing
        int mid = s + (e-s)/2;
        if(arr[mid] == k){
            return  true;

        } else if (arr[mid] < k) {
            // move right
            s = mid+1;

        }else{
            // move left
            e = mid-1;

        }

        // Recursive relation
        return solve(arr, k, s, e);
    }

    static boolean binarySearch(int[] arr, int k){

        int s = 0;
        int e = arr.length-1;
        boolean ans = solve(arr, k, s, e);
        return ans;
    }

    static void main() {

//        int[] arr = {1, 2, 3, 4, 6};
//        int[] arr = {1, 2, 4, 5, 6};
        int[] arr ={2, 3, 5, 6};
        int k = 1;
        boolean result = binarySearch(arr,k);
        System.out.print("Element present in an array: "+result);

    }
}
