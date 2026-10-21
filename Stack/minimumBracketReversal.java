package DSA_LoveBabbar.Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class minimumBracketReversal {

    //  MINIMUM BRACKET REVERSALS TO BALANCE

    /*

    Given a string s consisting of only opening and closing curly brackets '{' and '}', find out the minimum reversals required to convert the string into a balanced expression. A reversal means changing '{' to '}' or vice-versa.

Examples:

Input: s = "}{{}}{{{"
Output: 3
Explanation: One way to balance is:
"{{{}}{}}". There is no balanced sequence
that can be formed in lesser reversals.

Input: s = "{{}{{{}{{}}{{"
Output: -1
Explanation: There's no way we can balance
this sequence of braces.

Constraints:
1 ≤ |s| ≤ 105

Expected Complexities
Time Complexity: O(n)
Auxiliary Space: O(1)

Company Tags
Amazon

     */

    static int countMinReversals(String s){

        // if String length is odd then it is not possible evaluate minimum reversals
        if( s.length() % 2 == 1 ){
            return -1;
        }

        Deque<Character> st = new ArrayDeque<>();

        for( char ch : s.toCharArray() ){

            // if we found valid brackets, then they will cancel out each other
            if( ch == '}' && !st.isEmpty() && st.peek() == '{' ){
                st.pop();
            }
            else{
                st.push(ch);
            }
        }

        // Now we will get the remaining open and close brackets, which didn't cancelled out each other
        int open = 0; // No. of open brackets
        int close = 0; // No. of close brackets

        while( !st.isEmpty() ){

            if( st.peek() == '{' ){
                open++;
            }
            else{
                close++;
            }
            st.pop();
        }

        // even
        if( open % 2 == 0 ){
            return (open/2) + (close/2);

        }
        else{
            // odd
            return (open-1)/2 + 2 + (close-1)/2;
        }
    }

    // The above approach is by using stack
    // i.e. it's T.C. = O(n) and S.C. = O(n)

    // But if we are pushing the same element or value into the stack
    // Then, their is the optimal approach which takes S.C. = O(1) and T.C. = O(n)
    // So, we can track unmatched opening and closing brackets using a simple counter approach in O(n) time and O(1) space
    // That can be observed in below approach

    static int countMinReversals2(String s){

        if( s.length() % 2 == 1 ){
            return -1;
        }

        int open = 0;
        int close = 0;

        for( char ch : s.toCharArray() ){

            if( ch == '{' ){
                open++;

            }
            else{

                if( open > 0 ){
                    open--;

                }
                else{
                    close++;
                }
            }
        }

        if( open % 2 == 0 ){
            return (open/2) + (close/2);

        }
        else{
            return (open-1)/2 + 2 + (close-1)/2;
        }
    }

    static void main() {

        String s = "}{{}}{{{";
        int ans = countMinReversals(s);
        int ans2 = countMinReversals2(s);
        System.out.println(
                "Minimum count of reversal required for the given string is: " + ans );

        System.out.println(
                "Minimum count of reversal required for the given string is: " + ans2
        );
    }

}
