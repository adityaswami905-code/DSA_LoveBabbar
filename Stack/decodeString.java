package DSA_LoveBabbar.Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class decodeString {

    //  DECODE STRING

    /*

    Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].

The test cases are generated so that the length of the output will never exceed 105.

Example 1:
Input: s = "3[a]2[bc]"
Output: "aaabcbc"

Example 2:
Input: s = "3[a2[c]]"
Output: "accaccacc"

Example 3:
Input: s = "2[abc]3[cd]ef"
Output: "abcabccdcdcdef"

Constraints:
1 <= s.length <= 30
s consists of lowercase English letters, digits, and square brackets '[]'.
s is guaranteed to be a valid input.
All the integers in s are in the range [1, 300].

     */

    static String decodeTheString(String s){

        Deque<Integer> countStack = new ArrayDeque<>();
        Deque<StringBuilder> stringStack = new ArrayDeque<>();

        int number = 0;
        StringBuilder curr = new StringBuilder();

        for( char ch : s.toCharArray() ){

            if( Character.isDigit(ch) ){
                // Case 1 ->
                number = number*10 + (ch-'0');
            }
            else if( ch == '[' ){
                // Case 2 ->
                countStack.push(number);
                stringStack.push(curr);

                // and then reset, i.e. new values se initialize firse
                number = 0;
                curr = new StringBuilder();
            }
            else if( ch == ']' ){
                // case 3 ->
                int repeatCount = countStack.pop();
                StringBuilder prev = stringStack.pop();
                // ab hum previous mein repeat times curr ko append karne wale hai
                for( int i = 0; i < repeatCount; i++ ){
                    prev.append(curr);
                }
                // most important line
                curr = prev;
            }
            else{
                // case 4- > ch -> alphabet string
                curr.append(ch);
            }
        }
        return curr.toString();
    }

    static void main() {

        String s = "2[abc]3[cd]ef";
        String ans = decodeTheString(s);
        System.out.println(
                "Decoded String: " + ans
        );
    }
}
