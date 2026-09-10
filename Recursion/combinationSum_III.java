package DSA_LoveBabbar.Recursion;

import java.util.ArrayList;
import java.util.List;

public class combinationSum_III {

    //  COMBINATION SUM-III

    /*

    Find all valid combinations of k numbers that sum up to n such that the following conditions are true:

Only numbers 1 through 9 are used.
Each number is used at most once.
Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.



Example 1:

Input: k = 3, n = 7
Output: [[1,2,4]]
Explanation:
1 + 2 + 4 = 7
There are no other valid combinations.
Example 2:

Input: k = 3, n = 9
Output: [[1,2,6],[1,3,5],[2,3,4]]
Explanation:
1 + 2 + 6 = 9
1 + 3 + 5 = 9
2 + 3 + 4 = 9
There are no other valid combinations.
Example 3:

Input: k = 4, n = 1
Output: []
Explanation: There are no valid combinations.
Using 4 different numbers in the range [1,9], the smallest sum we can get is 1+2+3+4 = 10 and since 10 > 1, there are no valid combination.


Constraints:

2 <= k <= 9
1 <= n <= 60



     */

    static void solve(int k, List<List<Integer>> ans, List<Integer> output, int index, int[] candidates, int target, int count){

        if(count > k){
            return;
        }
        if(count == k && target == 0){
            ans.add(new ArrayList<>(output));
            return;
        }
        if(target < 0){
            return;
        }
        if(index >= candidates.length){
            return;
        }

        output.add(candidates[index]);
        solve(k,ans,output,index+1,candidates,target-candidates[index],count+1);

        output.removeLast();
        solve(k,ans,output,index+1,candidates,target,count);

    }

    static List<List<Integer>> combinationsum3(int k, int n){

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        int index = 0;
        int[] candidates = {1,2,3,4,5,6,7,8,9};
        int target = n;
        int count = 0;

        solve(k,ans,output,index,candidates,target,count);
        return ans;
    }

    static void main() {

        int k = 4;
        int n = 1;
        List<List<Integer>> result = combinationsum3(k,n);
        System.out.print("Combination sum III: "+result);
    }
}
