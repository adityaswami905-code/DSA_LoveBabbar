package DSA_LoveBabbar.Stack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class previousGreaterElement {

    //  PREVIOUS GREATER ELEMENT

    /*

    You are given an integer array arr[]. For every element in the array, determine its Previous Greater Element (PGE).

The Previous Greater Element (PGE) of an element x is the first element that appears to the left of x in the array and is strictly greater than x.

Note: If no such element exists, assign -1 as the PGE for that position.

Examples:

Input: arr[] = [10, 4, 2, 20, 40, 12, 30]
Output: [-1, 10, 4, -1, -1, 40, 40]
Explanation:
For 10, no elements on the left, so answer is -1.
For 4, previous greater element is 10.
For 2, previous greater element is 4.
For 20, no element on the left greater than 20, so answer is -1.
For 40, no element on the left greater than 40, so answer is -1.
For 12, previous greater element is 40.
For 30, previous greater element is 40.

Input: arr[] = [10, 20, 30, 40]
Output: [-1, -1, -1, -1]
Explanation: Each element of the array has no previous greater element.

Constraints:
1 ≤ arr.size(), arr[i] ≤ 105

Expected Complexities
Time Complexity: O(n)
Auxiliary Space: O(n)

     */

    static ArrayList<Integer> previousGreaterEle(int[] arr){

        ArrayList<Integer> result = new ArrayList<>();
        int n = arr.length;
        // initially inserting -1 in all places of answer arraylist integer
        for( int i = 0; i < n; i++ ){
            result.add(-1);
        }

        Deque<Integer> st = new ArrayDeque<>();

        // Monotonic Stack Pattern
        // i.e. moving from left to right as we want to previous greater element
        for( int i = 0; i < n; i++ ){

            int curr = arr[i];
            // If stack contains any un useful element, then simply pop it from the stack
            while( !st.isEmpty() && st.peek() <= curr ){
                st.pop();
            }


            // If stack is still not empty, that means it contains useful element,
            // so insert it into answer arraylist integer
            if( !st.isEmpty() ){
                result.set(i,st.peek());
            }
            // push current element into stack
            st.push(curr);
        }
        // return answer
        return result;
    }

    static void main() {

        int[] arr = {10, 20, 30, 40};
        ArrayList<Integer> ans = previousGreaterEle(arr);
        System.out.print("Previous Greater Element: ");

        for( int a : ans ){
            System.out.print(
                    a + " "
            );
        }
        System.out.println();

    }
}
