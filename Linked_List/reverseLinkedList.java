package DSA_LoveBabbar.Linked_List;

public class reverseLinkedList {

    //  REVERSE LINKED LIST

    /*

    Given the head of a singly linked list, reverse the list, and return the reversed list.

Example 1:
Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]

Example 2:
Input: head = [1,2]
Output: [2,1]

Example 3:
Input: head = []
Output: []

Constraints:

The number of nodes in the list is the range [0, 5000].
-5000 <= Node.val <= 5000

     */

    static class ListNode{
        int val;
        ListNode next;

        ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }

    // 1st approach : iterative approach
    public ListNode reverseList(ListNode head){

        // As we want ot reverse the LL i.e. reverse the links between the nodes
        // Therefore prev variable is on null
        ListNode prev = null;

        // and initially head is on curr node
        ListNode curr = head;

        while( curr != null){

            // forward variable creation
            ListNode forward = curr.next;

            // reverse the link
            // i.e.
            curr.next = prev;

            // take each variable one step forward after the new link is linked
            //i.e.
            prev = curr;
            curr = forward;


        }
        // return updated head
        return prev;
    }

    // 2nd approach : recursive approach
    public ListNode solve(ListNode prev, ListNode curr){

        // Base case
        if( curr == null ){
            return prev;
        }

        // 1 case mein solve karunga baaki recursion solve karega
        ListNode forward = curr.next;

        curr.next = prev;

//        prev = curr;
//        curr = forward;
//
//        ListNode ans = solve(prev,curr);
//        return ans;

        // ************* or ************

        return solve(curr,forward);

    }

    public ListNode reverseList2(ListNode head){

        ListNode prev = null;
        ListNode curr = head;

        ListNode ans = solve(prev,curr);
        return ans;
    }

    static void main() {

        reverseLinkedList obj = new reverseLinkedList();

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

//        ListNode newHead = obj.reverseList(head);
        ListNode newHead = obj.reverseList2(head);

        // creation of temp variable for traversing
        ListNode temp = newHead;

        // Printing reverse LL
        while ( temp != null){
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println();

    }
}
