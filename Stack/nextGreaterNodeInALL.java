package DSA_LoveBabbar.Stack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

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

    }
}
