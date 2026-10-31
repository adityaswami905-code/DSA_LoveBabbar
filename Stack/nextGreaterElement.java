package DSA_LoveBabbar.Stack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;

public class nextGreaterElement {

    //  NEXT GREATER  ELEMENT

    /*

    You are given an array arr[] of integers, the task is to find the next greater for each element of the array in order of their appearance in the array. Next greater element of an element in the array is the nearest element on the right which is greater than the current element.
If there does not exist next greater of current element, then next greater element for current element is -1.

Examples

Input: arr[] = [1, 3, 2, 4]
Output: [3, 4, 4, -1]
Explanation: The next larger element to 1 is 3, 3 is 4, 2 is 4 and for 4, since it doesn't exist, it is -1.

Input: arr[] = [6, 8, 0, 1, 3]
Output: [8, -1, 1, 3, -1]
Explanation: The next larger element to 6 is 8, for 8 there is no larger elements hence it is -1, for 0 it is 1, for 1 it is 3 and then for 3 there is no larger element on right and hence -1.

Input: arr[] = [1, 2, 3, 5]
Output: [2, 3, 5, -1]
Explanation: For a sorted array, the next element is next greater element also except for the last element.

Input: arr[] = [5, 4, 3, 1]
Output: [-1, -1, -1, -1]
Explanation: There is no next greater element for any of the elements in the array, so all are -1.

Constraints:
1 ≤ arr.size() ≤ 106
0 ≤ arr[i] ≤ 109

Expected Complexities
Time Complexity: O(n)
Auxiliary Space: O(n)

Company Tags
Flipkart    Amazon  Microsoft   MakeMyTrip  Adobe

     */

    static ArrayList<Integer> nextGreaterEle(int[] arr){

        int n = arr.length;
        // initially inserting -1 in all places of answer arraylist integer
        ArrayList<Integer> result = new ArrayList<>(Collections.nCopies(n,-1));

        Deque<Integer> st = new ArrayDeque<>();

        // Monotonic Stack Pattern
        // i.e. we are traversing from right to left while comparing
        for( int i = n-1; i >= 0; i-- ){

            int curr = arr[i];
            // if stack contains any un useful element in a stack then simply pop it
            while( !st.isEmpty() && st.peek() <= curr ){

                st.pop();
            }
            // if still stack is not empty that means it contains useful elements
            // so insert it in an answer arraylist integer
            if( !st.isEmpty() ){
                result.set(i,st.peek());
            }
            // push current element
            st.push(curr);
        }
        // return answer
        return result;
    }

    static void main() {

        int[] arr = {5, 4, 3, 1};
        ArrayList<Integer> ans = nextGreaterEle(arr);
        System.out.print("Next Greater Element: ");

        for(int a : ans ){
            System.out.print(
                    a + " "
            );
        }
        System.out.println();
    }
}
