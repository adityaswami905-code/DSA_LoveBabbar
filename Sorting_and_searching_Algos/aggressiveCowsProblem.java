package DSA_LoveBabbar.Sorting_and_searching_Algos;

import java.util.Arrays;

public class aggressiveCowsProblem {

    // AGGRESSIVE COWS PROBLEM

    /*
Given an integer array arr[], which denotes the positions of stalls. All the positions are distinct. There are k aggressive cows.

Assign the cows to the stalls such that the minimum distance between any two cows is maximized.

Examples:

Input: arr[] = [1, 2, 4, 8, 9], k = 3
Output: 3
Explanation: The first cow can be placed at arr[0], the second at arr[2], and the third at arr[3]. The minimum distance between any two cows is 3 (between arr[0] and arr[2]), which is the maximum possible among all valid arrangements.
Input: arr[] = [10, 1, 2, 7, 5], k = 3
Output: 4
Explanation: The first cow can be placed at arr[0], the second at arr[1], and the third at arr[4]. In this arrangement, the minimum distance between any two cows is 4 (between arr[1] and arr[4]), which is the maximum possible among all valid arrangements.
Constraints:
2 ≤ arr.size() ≤ 106
0 ≤ arr[i] ≤ 108
2 ≤ k ≤ arr.size()
     */

    static boolean isValid(int[] stalls, int k, int minDistance){

        int cowCount = 1;
        // abhi initially pahele number ke cow par hai
        int lastPosition = stalls[0];

        for(int i = 1; i < stalls.length; i++){

            if(stalls[i] - lastPosition >= minDistance){
                cowCount++;
                lastPosition = stalls[i];
            }

            if(cowCount == k){
                return true;
            }
        }
        return false;
    }

    static int minDistance(int[] stalls, int k){

        Arrays.sort(stalls);

        int n = stalls.length;
        int s = 0;
        int e = stalls[n-1];
        int ans = -1;

        while ( s <= e){

            int mid = s + (e-s)/2;

            if(isValid(stalls,k,mid)){
                // hume possible solution mil chuke hai, toh abhi ans ko store karna hoga
                ans = mid;
                // aur desired output ke liye hame right mein move karna hoga
                s = mid+1;

            }else{
                // move left
                e = mid-1;
            }
        }
        return ans;
    }

    static void main() {

//        int[] stalls = {1, 2, 4, 8, 9};
        int [] stalls = {10, 1, 2, 7, 5};
        int ans = minDistance(stalls,3);
        System.out.print("The minimum distance between any two cows is: "+ans);

    }
}
