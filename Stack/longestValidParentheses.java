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

    // after space optimization
    // this question can be solve in O(1) space complexity and O(n) time complexity
    // whereas above approach using stack takes T.C. = O(n) and S.C. = O(n)
    // but optimized approach can be seen as below approach;

    static int longestValidParenthesesLen2(String s){

        int open = 0;
        int close = 0;
        int maxLen = 0;

        // i.e. from left to right traversal on string
        for( int i = 0; i < s.length(); i++){

            char ch = s.charAt(i);

            if( ch == '(' ){
                open++;
            }
            else{
                close++;
            }
            // check valid or invalid case
            if( close > open ){

                // i.e. invalid case then reset it
                open = 0;
                close = 0;
            }
            else if( open == close ){

                maxLen = Math.max(maxLen, 2*close);
            }
        }

        open = 0;
        close = 0;

        // right to left traversal on string
        for( int i = s.length() - 1; i  > 0; i-- ){

            char ch = s.charAt(i);

            if( ch == '(' ){
                open++;
            }
            else{
                close++;
            }

            if( open > close ){
                // invalid case reset it
                open++;
                close++;
            }
            else if( open == close){

                maxLen = Math.max(maxLen,2*open);
            }
        }
        return maxLen;
    }

    static void main() {

        String s = "(()";
        int ans = longestValidParenthesesLen(s);
        int ans2 = longestValidParenthesesLen2(s);

        System.out.println(
                "Longest valid Parentheses Length is: " + ans
        );

        System.out.println(
                "Longest valid Parentheses Length is: " + ans2 + "(second approach)"
        );
    }
}
