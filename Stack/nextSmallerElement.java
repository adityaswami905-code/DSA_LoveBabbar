package DSA_LoveBabbar.Stack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class nextSmallerElement {

    //  NEXT SMALLER ELEMENT

    /*

    You are given an integer array arr[ ]. For every element in the array, your task is to find its Next Smaller Element (NSE).

The Next Smaller Element (NSE) of an element x is the first element that appears to the right of x in the array and is strictly smaller than x.
If no such element exists, assign -1 as the NSE for that position.

Examples:

Input: arr[] = [4, 8, 5, 2, 25]
Output: [2, 5, 2, -1, -1]
Explanation:
The first element smaller than 4 having index > 0 is 2.
The first element smaller than 8 having index > 1 is 5.
The first element smaller than 5 having index > 2 is 2.
There are no elements smaller than 4 having index > 3.
There are no elements smaller than 4 having index > 4.

Input: arr[] = [13, 7, 6, 12]
Output: [7, 6, -1, -1]
Explanation:
The first element smaller than 13 having index > 0 is 7.
The first element smaller than 7 having index > 1 is 6.
There are no elements smaller than 6 having index > 2.
There are no elements smaller than 12 having index > 3.

Input: arr[] = [4, 1]
Output: [1, -1]
Explanation: 4 will be updated to 1 and 1 will be updated to -1.

Constraints:
1 ≤ arr.size(), arr[i] ≤ 105

Expected Complexities
Time Complexity: O(n)
Auxiliary Space: O(1)

Company Tags
Flipkart    Amazon

     */

    static ArrayList<Integer> nextSmallerEle(int[] arr){

        // Answers is returned in Arraylist Integer
        ArrayList<Integer> result = new ArrayList<>();
        int n = arr.length;

        // initially inserting -1's in a result
        for( int i = 0; i < n; i++ ){
            result.add(-1);
        }

        // AS we can solve this problem statement by using brute force approach
        // But it takes O(n^2) T.C.
        // Therefore we are using Monotonic Stack pattern, which takes O(n) T.C.
        Deque<Integer> st = new ArrayDeque<>();
        // i.e. we are moving from right to left in a given array
        for( int i = n-1; i >= 0; i-- ){

            int curr = arr[i];

            //i.e. next greater element are popped from the stack, because they are of no use
            while( !st.isEmpty() && st.peek() >= curr ){
                    st.pop();
            }

            // and if still stack is not empty, that means a useful element is present in a stack
            // so insert that peek element in an array
            if( !st.isEmpty() ){
                result.set(i,st.peek());
            }
            // or we simply push the element in a stack
            st.push(curr);
        }
        // return answer
        return result;
    }

    static void main() {

        int[] arr = {4, 1};
        ArrayList<Integer> ans = nextSmallerEle(arr);
        System.out.print("Next Smaller Element: ");
        for( int a : ans ){
            System.out.print(
                    a + " "
            );
        }
        System.out.println();
    }
}
