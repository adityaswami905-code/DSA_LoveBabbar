package DSA_LoveBabbar.Stack;

import java.util.*;

public class nextGreaterNodeInALL {

    //  NEXT GREATER NODE IN A LINKED LIST

    /*

    You are given the head of a linked list with n nodes.

For each node in the list, find the value of the next greater node. That is, for each node,
find the value of the first node that is next to it and has a strictly larger value than it.

Return an integer array answer where answer[i] is the value of the next greater node of the ith node (1-indexed).
If the ith node does not have a next greater node, set answer[i] = 0.

Example 1:
Input: head = [2,1,5]
Output: [5,5,0]

Example 2:
Input: head = [2,7,4,3,5]
Output: [7,0,5,5,0]

Constraints:
The number of nodes in the list is n.
1 <= n <= 104
1 <= Node.val <= 109

     */

    static class ListNode{

        int val;
        ListNode next;

        ListNode(int val){

            this.val = val;
            this.next = null;

        }
    }

    static int[] nextLargerNode(ListNode head){

        // converting LL into a list
        List<Integer> list = new ArrayList<>();

        ListNode temp = head;
        while( temp != null ){

            list.add(temp.val);
            temp = temp.next;
        }

        int n = list.size();
        int[] ans = new int[n];
        Deque<Integer> st = new ArrayDeque<>();

        // traversing in an array
        for( int i = 0; i < n; i++ ){

            // finding next greater element in  right side
            // i.e. following stack monotonic order
            while( !st.isEmpty() && list.get(i) > list.get(st.peek()) ){

                int previousValue = st.pop();
                ans[previousValue] = list.get(i);

            }
            // current value
            st.push(i);
        }
        return ans;

    }

    //  NEXT GREATER ELEMENT

    /*

    You are given an array arr[] of integers, the task is to find the next greater for each element of the array
    in order of their appearance in the array.
    Next greater element of an element in the array is the nearest element on the right
    which is greater than the current element.
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

    static ArrayList<Integer> nextLargerElement(int[] arr){

        int n = arr.length;
        // Initializing every answer to -1
        ArrayList<Integer> ans = new ArrayList<>(Collections.nCopies(n,-1));
        // storing indices in stack
        Deque<Integer> st = new ArrayDeque<>();

        for( int i = 0; i < n; i++ ){

            // i.e. current element is the next greater element
            while( !st.isEmpty() && arr[i] > arr[st.peek()] ){

                int previousElementIndex = st.pop();
                ans.set(previousElementIndex,arr[i]);

            }
            // storing current index
            st.push(i);
        }
        // keeping the remaining answer in -1
        return ans;
    }

    static void main() {

        ListNode head = new ListNode(2);
        head.next = new ListNode(7);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(5);

        int[] output = nextLargerNode(head);

        System.out.print("Output: ");
        for( int out : output ){
            System.out.print(out + " ");
        }
        System.out.println();


        int[] arr = {5, 4, 3, 1};
        ArrayList<Integer> result = nextLargerElement(arr);

        System.out.print("Result: ");
        for( int res : result ){
            System.out.print(res + " ");
        }
        System.out.println();
    }
}
