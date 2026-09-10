package DSA_LoveBabbar.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combinationSum_II {

    //  COMBINATION SUM II

    /*

    Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.



Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8
Output:
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5
Output:
[
[1,2,2],
[5]
]


Constraints:

1 <= candidates.length <= 100
1 <= candidates[i] <= 50
1 <= target <= 30

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

        // include exclude pattern
        output.add(candidates[index]);
        solve(candidates,target-candidates[index],ans,output,index+1);

        // Backtrack
        output.removeLast();
        // unique element logic
        while(index < candidates.length-1 && candidates[index] == candidates[index+1]){
            index++;
        }
        solve(candidates,target,ans,output,index+1);

    }

    static List<List<Integer>> combinationsum2(int[] candidates, int target){

        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        int index = 0;

        solve(candidates,target,ans,output,index);
        return ans;
    }

    static void main() {

        int[] candidates = {2,5,2,1,2};
        int target = 5;
        List<List<Integer>> result = combinationsum2(candidates,target);
        System.out.print("Combination sum II: "+result);
    }
}
