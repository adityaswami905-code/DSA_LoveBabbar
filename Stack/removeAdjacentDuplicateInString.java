package DSA_LoveBabbar.Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class removeAdjacentDuplicateInString {

    // REMOVE ALL ADJACENT DUPLICATE IN STRING

    /*

    You are given a string s consisting of lowercase English letters. A duplicate removal consists of choosing two adjacent and equal letters and removing them.

We repeatedly make duplicate removals on s until we no longer can.

Return the final string after all such duplicate removals have been made. It can be proven that the answer is unique.

Example 1:
Input: s = "abbaca"
Output: "ca"
Explanation:
For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.  The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".

Example 2:
Input: s = "azxxzy"
Output: "ay"

Constraints:
1 <= s.length <= 105
s consists of lowercase English letters.

     */

    static String removeDuplicates(String s){

        Deque<Character> st = new ArrayDeque<>();

        for( char ch : s.toCharArray() ){

            // i.e. stack contains elements
            if( !st.isEmpty() ){

                // if adjacent character are duplicate
                if( ch == st.peek() ){
                    st.pop();

                }
                else{
                    st.push(ch);
                }
            }
            else{
                // i.e. stack is empty
                st.push(ch);
            }
        }

        StringBuilder str = new StringBuilder();

        while( !st.isEmpty() ){

            str.append(st.peek());
            st.pop();
        }

        return str.reverse().toString();
    }

    static void main() {

        String s = "azxxzy";
        String ans = removeDuplicates(s);

        System.out.println(
                "String after removing all duplicate adjacent: " + ans
        );
    }
}
