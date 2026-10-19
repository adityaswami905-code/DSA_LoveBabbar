package DSA_LoveBabbar.Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class validParentheses {

    //  VALID PARENTHESES

    /*

    Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.


Example 1:
Input: s = "()"
Output: true

Example 2:
Input: s = "()[]{}"
Output: true

Example 3:
Input: s = "(]"
Output: false

Example 4:
Input: s = "([])"
Output: true

Example 5:
Input: s = "([)]"
Output: false

Constraints:
1 <= s.length <= 104
s consists of parentheses only '()[]{}'.



     */

    static boolean validParentheses(String s){

        // Approach -> push the opening brackets into the stack
        // Compare with closing brackets, whether they contains to the same category of brackets or not
        // If match then pop the matched brackets( i.e. always comparing with top element )
        // after all push and pop operation
        // Check whether the stack becomes empty or not
        // If yes then return true i.e. Valid parentheses
        // else return false i.e. Invalid parentheses

        Deque<Character> st = new ArrayDeque<>();

        for( char ch : s.toCharArray() ){

            // For opening brackets
            if( ch == '(' || ch == '[' || ch == '{' ){
                st.push(ch);
            }
            else{

                // Check whether stack contains elements or not
                if( st.isEmpty() ){
                    return false;
                }

                if( ch == ')' && st.peek() != '(' ){
                    // No match
                    return false;
                }
                else if ( ch == ']' && st.peek() != '[' ) {
                    // No match
                    return false;
                }
                else if ( ch == '}' && st.peek() != '{' ) {
                    // No match
                    return false;
                }
                else{
                    // If Matched
                    st.pop();
                }
            }
        }

        // After cancelling out opening brackets with closing brackets
        // Check, whether the stack becomes empty or not
        if( st.isEmpty() ){
            return true;
        }
        else{
            return false;
        }
    }

    static void main() {

        String s = "()[]]{}";
        boolean ans = validParentheses(s);
        System.out.println(
                "Given String contains valid parentheses: "+ ans);
    }
}
