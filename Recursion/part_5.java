package DSA_LoveBabbar.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class part_5 {

//    ALL SUBSEQUENCES OF A STRING (Include-exclude approach i.e. take-notTake)

    /*

Given a string s, generate all possible subsequences of the string (including the empty subsequence) and return them in lexicographical order.

A subsequence is obtained by deleting zero or more characters from the string without changing the relative order of the remaining characters.

Examples:

Input : s = "abc"
Output: ["", "a", "ab", "abc", "ac", "b", "bc", "c"]
Explanation: There are a total of 8 non-empty subsequences for the given string.
Input: s = "aa"
Output: ["", "a", "a", "aa"]
Constraints:

1 ≤ s.size() ≤ 16
s contains: [a-z].

     */

    static void printAllSubsequences(String s, int index, StringBuilder output, List<String> ans){

        // Base case
        if(index >= s.length()){
            // print all subsequences and return
            String subSequences = output.toString();
            ans.add(subSequences);
            return;
        }

        // include-exclude approach
        char ch = s.charAt(index);

        // take(include)
        output.append(ch);
        printAllSubsequences(s,index+1,output,ans);

        // not take(exclude)
        output.deleteCharAt(output.length()-1);
        printAllSubsequences(s,index+1,output,ans);
    }

    static List<String> powerSet(String s){

        List<String> ans = new ArrayList<>();
        // as string is immutable in java, therefore we will use StringBuilder to perform an operations
        StringBuilder output = new StringBuilder();

        int index = 0;

        printAllSubsequences(s,index,output,ans);
        Collections.sort(ans);
        return ans;

    }

    //  SUBSETS (inclusive-exclusive approach i.e. take-notTake)

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

    static void getAllSubsequences(int[] arr, int index, List<List<Integer>> ans, List<Integer> current){

        if(index >= arr.length){
            ans.add(new ArrayList<>(current));
            return;
        }

        current.add(arr[index]);
        getAllSubsequences(arr,index+1,ans,current);

        current.remove(current.size()-1);
        getAllSubsequences(arr,index+1,ans,current);
    }

    static List<List<Integer>> subSets(int[] arr){

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        int index = 0;

        getAllSubsequences(arr,index,ans,current);
        return ans;
    }

    static void main() {

//        String s = "abc";
//        List<String> result = powerSet(s);
//        System.out.print("All subsequences of a string: "+result);

        int[] arr = {1,2,3};
        List<List<Integer>> result = subSets(arr);
        System.out.print("All subsequences os an array: "+result);
    }
}
