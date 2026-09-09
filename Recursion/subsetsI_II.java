package DSA_LoveBabbar.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class subsetsI_II {

    //  SUBSETS I

    /*

    Given an integer array nums of unique elements, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:

Input: nums = [0]
Output: [[],[0]]

Constraints:

1 <= nums.length <= 10
-10 <= nums[i] <= 10
All the numbers of nums are unique.

     */

    static void solve(int[] arr,int index, List<Integer> output, List<List<Integer>> ans){

        if(index >= arr.length){

            ans.add(new ArrayList<>(output));
            return;
        }

        int currValue = arr[index];

        output.add(currValue);
        solve(arr,index+1,output,ans);

        output.removeLast();
        solve(arr, index+1, output, ans);

    }

    static List<List<Integer>> subSets(int[] arr){
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> output = new ArrayList<>();

        int index = 0;
        solve(arr,index,output,ans);
        return ans;
    }

    //  SUBSETS II

    /*

    Given an integer array nums that may contain duplicates, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

Example 1:

Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
Example 2:

Input: nums = [0]
Output: [[],[0]]

Constraints:

1 <= nums.length <= 10
-10 <= nums[i] <= 10

     */

    static void solve2(int[] arr, int index, List<List<Integer>> ans, List<Integer> output){

        if(index >= arr.length){

            ans.add(new ArrayList<>(output));
            return;
        }

        int currValue2 = arr[index];

        output.add(currValue2);
        solve2(arr,index+1,ans,output);

        output.removeLast();

        while (index < arr.length-1 && arr[index] == arr[index+1]){
            index++;
        }

        solve2(arr,index+1,ans,output);
    }

    static List<List<Integer>> subsetsII(int[] arr){
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> output = new ArrayList<>();

        int index = 0;
        solve2(arr,index, ans,output);
        return ans;
    }

    static void main() {
//        int[] arr = {1,2,3};
//        List<List<Integer>> result = subSets(arr);
//        System.out.print("Subsets: "+result);

        int[] arr = {1,2,2};
        List<List<Integer>> result = subsetsII(arr);
        System.out.print("Subsets-II: "+result);
    }
}
