package DSA_LoveBabbar.Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class checkStringIsValidOrNot {

    //  CHECK IF WORD IS VALID AFTER SUBSTITUTIONS

    /*

    Given a string s, determine if it is valid.

A string s is valid if, starting with an empty string t = "", you can transform t into s after performing the following operation any number of times:

Insert string "abc" into any position in t. More formally, t becomes tleft + "abc" + tright, where t == tleft + tright. Note that tleft and tright may be empty.
Return true if s is a valid string, otherwise, return false.

Example 1:
Input: s = "aabcbc"
Output: true
Explanation:
"" -> "abc" -> "aabcbc"
Thus, "aabcbc" is valid.

Example 2:
Input: s = "abcabcababcc"
Output: true
Explanation:
"" -> "abc" -> "abcabc" -> "abcabcabc" -> "abcabcababcc"
Thus, "abcabcababcc" is valid.

Example 3:
Input: s = "abccba"
Output: false
Explanation: It is impossible to get "abccba" using the operation.

Constraints:
1 <= s.length <= 2 * 104
s consists of letters 'a', 'b', and 'c'

     */

    static boolean isValid(String s){

        Deque<Character> st = new ArrayDeque<>();

        for( char ch : s.toCharArray() ){

            // Push the letters if they are equal to 'a' or 'b'
            if( ch == 'a' || ch == 'b' ){
                st.push(ch);

            }
            else{
                // i.e. ch == 'c'
                // Then compare the top 2 elements are equal to 'b' and 'a' respectively

                // if size of stack is less than 2
                // i.e. it may not contain letters a || b || both
                if( st.size() < 2 ){
                    return false;
                }

                if( st.peek() != 'b' ){
                    return false;
                }
                // if top letter is b
                st.pop();

                if( st.peek() != 'a' ){
                    return false;
                }
                // if top letter is a
                st.pop();
            }
        }

        // if stack is empty then, word is valid after substitutions
        // therefore
        if( st.isEmpty() ){
            return true;
        }
        else{
            return false;
        }
    }

    static void main() {

        String s = "abccba";
        boolean ans = isValid(s);

        System.out.println("String is Valid: " + ans);
    }
}
