package DSA_LoveBabbar.Recursion;

import java.util.ArrayList;
import java.util.List;

public class phoneKeypadProblem {

    //  LETTER COMBINATIONS OF A PHONE NUMBER

    /*

    Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.




Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:

Input: digits = "2"
Output: ["a","b","c"]


Constraints:

1 <= digits.length <= 4
digits[i] is a digit in the range ['2', '9'].

     */

    static void solve(String digits, String[] mapping, int index, StringBuilder output, List<String> ans){

        // Base case
        if(index >= digits.length()){
            ans.add(output.toString());
            return;
        }

        int value = digits.charAt(index)-'0';
        String mappedString = mapping[value];

        for(int i = 0; i < mappedString.length(); i++){

            output.append(mappedString.charAt(i));
            solve(digits, mapping, index+1, output, ans);
            // Backtrack
            output.deleteCharAt(output.length()-1);
        }
    }

    static List<String> letterCombinations(String digits){

        String[] mapping = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        int index = 0;
        StringBuilder output = new StringBuilder();
        List<String> ans = new ArrayList<>();
        solve(digits,mapping,index,output,ans);
        return ans;
    }

    static void main() {

        String digits = "2";
        List<String> result = letterCombinations(digits);
        System.out.print("Letter combination of a phone keypad number: "+result);
    }
}
