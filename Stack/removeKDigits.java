package DSA_LoveBabbar.Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class removeKDigits {

    //  REMOVE K DIGITS

    /*

    Given string num representing a non-negative integer num, and an integer k,
    return the smallest possible integer after removing k digits from num.

Example 1:
Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.

Example 2:
Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.

Example 3:
Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0.


Constraints:
1 <= k <= num.length <= 105
num consists of only digits.
num does not have any leading zeros except for the zero itself.

     */

    static String removeDigits(String s, int k){

        Deque<Character> st = new ArrayDeque<>();

        // applying monotonic pattern on input string
        for( char ch : s.toCharArray() ){

            while( !st.isEmpty() && k > 0 && st.peek() > ch ){

                st.pop();
                k--;
            }
            // insert current character
            st.push(ch);
        }

        // Case 2 - > If some removals still exists, then taking care of it
        while( k > 0 && !st.isEmpty() ){

            st.pop();
            k--;
        }

        // Building answer string, reversing it(because st follows LIFO order) and removing leading order
        StringBuilder ans = new StringBuilder();
        while( !st.isEmpty() ){
            ans.append(st.peek());
            st.pop();
        }
        // reversing String Builder
        ans.reverse();
        // removing leading zero's
        int index = 0;
        while( index < ans.length() && ans.charAt(index) == '0' ){
            index++;
        }

        String result = ans.substring(index);

        if(result.isEmpty()){
            return "0";
        }
        else{
            return result;
        }
    }

    static void main() {

        String s = "10";
        String output = removeDigits(s,2);
        System.out.println(
                "Smallest possible integer: " + output
        );
    }
}
