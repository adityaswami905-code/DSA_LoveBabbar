package DSA_LoveBabbar.Recursion;

import java.util.ArrayList;
import java.util.Collections;

public class permutationsOfString {

    //  ALL STRING PERMUTATIONS IN A SORTED ORDER

    /*

    Given a string s. Find all permutations  of a given string. Return the permutations in lexicographically non-decreasing order.

Examples :

Input: s = "AA"
Output: ["AA", "AA"]
Explanation: There are total 2 permutations, as given in the output.
Input: s = "ABC"
Output: ["ABC", "ACB", "BAC", "BCA", "CAB", "CBA"]
Explanation: There are total 6 permutations, as given in the output.
Constraints:
1 ≤ s.size() ≤ 5

     */

    static void solve(String s, String outputString, ArrayList<String> ans){

        if(s.isEmpty()){
            ans.add(outputString);
            return;
        }

        for(int i = 0; i < s.length(); i++){

            char ch = s.charAt(i);
            String remString = s.substring(0,i) + s.substring(i+1);
            solve(remString,outputString+ch,ans);
        }

    }

    static ArrayList<String> permutation(String s){

        ArrayList<String> ans = new ArrayList<>();

        solve(s,"", ans);
        Collections.sort(ans);
        return ans;
    }

    static void main() {

        String s = "ABC";
        ArrayList<String> result = permutation(s);
        System.out.print("All string permutations in a sorted order: "+result);
    }
}
