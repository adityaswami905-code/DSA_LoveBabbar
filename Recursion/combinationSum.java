package DSA_LoveBabbar.Recursion;

import java.util.ArrayList;
import java.util.List;

public class combinationSum {


    //  COMBINATION SUM

    /*

    Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.

The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.



Example 1:

Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.
Example 2:

Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]
Example 3:

Input: candidates = [2], target = 1
Output: []


Constraints:

1 <= candidates.length <= 30
2 <= candidates[i] <= 40
All elements of candidates are distinct.
1 <= target <= 40



     */

    static void solve(int[] candidates, int target, List<List<Integer>> ans, List<Integer> output, int index){

        // Base case
        if(target == 0){
            ans.add(new ArrayList<>(output));
            return;
        }
        if(target < 0){
            return;
        }
        if(index >= candidates.length){
            return;
        }

        // 1 case solve karo, baki recursion sambhal lega
        // include exclude

        output.add(candidates[index]);
        solve(candidates,target-candidates[index],ans,output,index);

        // Backtrack
        output.removeLast();
        solve(candidates,target,ans,output,index+1);
    }

    static List<List<Integer>> combinationsum(int[] candidates, int target){

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        int index = 0;

        solve(candidates,target,ans,output,index);
        return ans;
    }

    static void main() {

        int[] candidates = {2,3,5};
        int target = 8;
        List<List<Integer>> result = combinationsum(candidates,target);
        System.out.print("Combination sum: "+result);
    }
}
