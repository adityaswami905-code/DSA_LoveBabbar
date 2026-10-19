package DSA_LoveBabbar.Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class checkRedundantBrackets {

    //  CHECK REDUNDANT BRACKETS

    /*

    Given a string of balanced expression s, check if it contains a redundant parenthesis or not. A set of parenthesis are redundant if the same sub-expression is surrounded by unnecessary or multiple brackets.
Note: Expression may contain + , - , *, and / operators. Given expression is valid and there are no white spaces present.

Examples:

Input: s = "((a+b))"
Output: true
Explanation: ((a+b)) can reduced to (a+b).

Input: s = "(a+(b)/c)"
Output: true
Explanation: (a+(b)/c) can reduced to (a+b/c) because b is surrounded by () which is redundant.

Input: s = "(a+b+(c+d))"
Output: false
Explanation:(a+b+(c+d)) doesn't have any redundant or multiple brackets.

Constraints:
1 ≤ |s| ≤105

     */

    static boolean checkRedundantBrackets(String s){

        Deque<Character> st = new ArrayDeque<>();

        for( char ch : s.toCharArray() ){

            // Push opening bracket '(' and operator ( with ignoring alphabets )
            if( ch == '(' || ch == '+' || ch == '-' || ch == '*' || ch == '/' ){
                st.push(ch);

            }
            else if( ch == ')' ){

                boolean operatorFound = false;

                while( !st.isEmpty() ) {
                    // Topmost element
                    char temp = st.peek();

                    if (temp == '+' || temp == '-' || temp == '*' || temp == '/') {
                        operatorFound = true;

                    } else if (ch == ')' && temp == '(') {
                        st.pop();
                        break;
                    }
                    st.pop();
                }
                // Redundant Brackets present
                if( operatorFound == false){
                        return true;
                }

            }


        }
        // else not present
        return false;
    }

    static void main() {

        String s = "(a+b+(c+d))";
        boolean ans = checkRedundantBrackets(s);
        System.out.println(
                "Given String contains Redundant Brackets: " + ans
        );
    }
}
