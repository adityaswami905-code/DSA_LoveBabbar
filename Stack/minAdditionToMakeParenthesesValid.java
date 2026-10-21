package DSA_LoveBabbar.Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class minAdditionToMakeParenthesesValid {

    //  MINIMUM ADD TO MAKE PARENTHESES VALID

    /*

     A parentheses string is valid if and only if:

It is the empty string,
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.
You are given a parentheses string s. In one move, you can insert a parenthesis at any position of the string.

For example, if s = "()))", you can insert an opening parenthesis to be "(()))" or a closing parenthesis to be "())))".
Return the minimum number of moves required to make s valid.

Example 1:
Input: s = "())"
Output: 1

Example 2:
Input: s = "((("
Output: 3

Constraints:
1 <= s.length <= 1000
s[i] is either '(' or ')'.

     */

    static int minAddToMakeValid(String s){

        Deque<Character> st = new ArrayDeque<>();
        int addition = 0;

        for( char ch : s.toCharArray() ){

            // If their exist any opening bracket, then push it into stack
            if( ch == '(' ){
                st.push(ch);
            }
            else{
                // i.e. ch == ')'

                // check whether the stack is empty or not
                if( st.isEmpty() ){
                    // no. of opening brackets required
                    addition++;
                }
                else{
                    // i.e. if we found the closing brackets to the respective opening brackets
                    // then cancel out '(' and ')', because it makes valid parentheses
                    st.pop();
                }
            }
        }

        // Now suppose, if the stack contains only open brackets or [ '(' > ')' ] then also it is invalid
        // therefore we have to handle the case for the required closing brackets
        // we can calculate simply by identifying the size of stack
        // i.e. size of stack  = no. of opening brackets (i.e. no. of closing brackets required to make parentheses valid )
        // therefore
        int openingBrackets = st.size();
        int finalAns = openingBrackets + addition;

        return finalAns;
    }

    // The above approach is by using stack
    // i.e. it's T.C. = O(n) and S.C. = O(n)

    // But if we are pushing the same element or value into the stack
    // Then, their is the optimal approach which takes S.C. = O(1) and T.C. = O(n)
    // So, we can track unmatched opening and closing brackets using a simple counter approach in O(n) time and O(1) space
    // That can be observed in below approach

    static int minAddToMakeValid2(String s){

        // Counter for opening brackets required
        int openReq = 0;

        // Counter for closing brackets required
        int closeReq = 0;

        for( char ch : s.toCharArray() ){

            // for opening brackets
            if( ch == '(' ){
                openReq++;

            }
            else{
                // i.e. ch == ')'

                // Check if their exist any opening brackets to cancel out with respective closing brackets
                if( openReq > 0 ){
                    openReq--;

                }
                else{
                    // if not present then
                    closeReq++;
                }
            }
        }

        int finalAns = openReq + closeReq;
        return finalAns;

    }

    static void main() {

        String s = "(()(";
        int ans = minAddToMakeValid(s);
        int ans2 = minAddToMakeValid2(s);

        System.out.println(
                "The minimum number of moves required to make string valid: " + ans
        );

        System.out.println(
                "The minimum number of moves required to make string valid: " + ans2 + " (with optimal approach)"
        );
    }
}
