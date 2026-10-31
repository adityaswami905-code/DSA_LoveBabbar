package DSA_LoveBabbar.Stack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;

public class previousSmallerElement {

    //  PREVIOUS SMALLER ELEMENT

    /*

    You are given an integer array arr[ ].  The task is to find Previous Smaller Element (PSE) for every element in the array. The Previous Smaller Element (PSE) of an element x is the first element that appears to the left of x in the array and is strictly smaller than x.

Note: If no such element exists, assign -1 as the PSE for that position.

Examples:

Input: arr[] = [1, 6, 2]
Output: [-1, 1, 1]
Explanation:
For 1, there is no element on the left, so answer is -1.
For 6, previous smaller element is 1.
For 2, previous smaller element is 1.

Input: arr[] = [1, 5, 0, 3, 4, 5]
Output: [-1, 1, -1, 0, 3, 4]
Explanation:
For 1, no element on the left, so answer is -1.
For 5, previous smaller element is 1.
For 0, no element on the left smaller than 0, so answer is -1.
For 3, previous smaller element is 0.
For 4, previous smaller element is 3.
For 5, previous smaller element is 4.

Constraints:
1 ≤ arr.size(), arr[i] ≤ 105

Expected Complexities
Time Complexity: O(n)
Auxiliary Space: O(n)

     */

    static ArrayList<Integer> previousSmallerEle(int[] arr){

        int n = arr.length;
        // initially inserting -1's in answer arraylist integer
        ArrayList<Integer> result = new ArrayList<>(Collections.nCopies(n,-1));

        Deque<Integer> st = new ArrayDeque<>();
        // Follows Monotonic Stack Pattern
        for(int i = 0; i < n; i++ ){

            int curr = arr[i];
            // if the stack contains unuseful element then simply pop it
            // i.e. previous greater elements are popped from stack
            while( !st.isEmpty() && st.peek() >= curr ){
                st.pop();
            }
            // if stack is still not empty then that means that it contains useful elements
            // so insert it in answer arraylist integer
            if( !st.isEmpty() ){
                result.set(i,st.peek());
            }
            // push curr element into the stack
            st.push(curr);
        }
        return result;
    }

    static void main() {

        int[] arr ={1, 5, 0, 3, 4, 5};
        ArrayList<Integer> ans = previousSmallerEle(arr);
        System.out.print("Previous Smaller Element: ");
        for( int a : ans ){
            System.out.print(
                    a + " "
            );
        }
        System.out.println();
    }
}
