package DSA_LoveBabbar.Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class longestValidParentheses {

    //  LONGEST VALID PARENTHESES

    /*

    Given a string containing just the characters '(' and ')', return the length of the longest valid (well-formed) parentheses substring.

Example 1:
Input: s = "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()".

Example 2:
Input: s = ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()".

Example 3:
Input: s = ""
Output: 0

Constraints:
0 <= s.length <= 3 * 104
s[i] is '(', or ')'.

     */

    static int longestValidParenthesesLen(String s){

        // We have solved the valid parentheses before where, it ask in boolean type
        // that whether the string is valid or not
        // but here along with validation it asking the maximum valid parentheses length
        // in integer type, so we are playing with index, instead of elements

        Deque<Integer> st = new ArrayDeque<>();

        // initially we pushed with -1 value i.e. index
        // so it can help us while calculating the length of valid parentheses
        st.push(-1);
        int maxLen = 0;

        for( int i = 0; i < s.length(); i++ ){

            char ch = s.charAt(i);

            if( ch == '(' ){
                // i.e. opening bracket present
                st.push(i);

            }
            else{
                // that means closing bracket present
                st.pop();
                // agar stack ke andar koi valid index nahi tha,
                // toh pakka stack empty hua hoga
                if( st.isEmpty() ){
                    // Invalid case
                    // reset kar do
                    // left string part ko neglect kar do
                    // and new left boundary set kar do aur aage badho
                    st.push(i);

                }
                else{
                    // valid case
                    int currLen = i - st.peek();
                    maxLen = Math.max(maxLen,currLen);
                }
            }
        }
        return maxLen;
    }

    static void main() {

        String s = "";
        int ans = longestValidParenthesesLen(s);

        System.out.println(
                "Longest valid Parentheses Length is: " + ans
        );
    }
}
