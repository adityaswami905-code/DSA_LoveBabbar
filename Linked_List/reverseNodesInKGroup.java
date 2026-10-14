package DSA_LoveBabbar.Linked_List;

public class reverseNodesInKGroup {

    //  REVERSE NODES IN K GROUP ( Leet code )

    /*

    Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

You may not alter the values in the list's nodes, only nodes themselves may be changed.

Example 1:
Input: head = [1,2,3,4,5], k = 2
Output: [2,1,4,3,5]

Example 2:
Input: head = [1,2,3,4,5], k = 3
Output: [3,2,1,4,5]

Constraints:
The number of nodes in the list is n.
1 <= k <= n <= 5000
0 <= Node.val <= 1000


     */

    static class ListNode{

        int val;
        ListNode next;

        ListNode(int val){

            this.val = val;
            this.next = null;

        }
    }

    static ListNode reverseKGroup(ListNode head, int k){

        // Calculate Length of LL, and then solve accordingly
        int Len = 0;
        ListNode temp = head;

        while( temp != null ){

            Len++;
            temp = temp.next;

        }

        if( Len < k ){
            return head;
        }

        // Logic for reverse LL of k size
        ListNode prev = null;
        ListNode curr = head;

        for( int i = 1; i <= k; i++ ){

            ListNode forward = curr.next;

            curr.next = prev;

            prev = curr;
            curr = forward;

        }

        // Get the head of remaining solved LL by the recursion
        ListNode recursionKeAnsKaHead = reverseKGroup(curr, k);

        // connecting the tail node of LL that i solved, to the head node of remaining solved LL by the recursion
        head.next = recursionKeAnsKaHead;

        // return modified LL head
        return prev;
    }

    //  LINKED LISTS GROUP REVERSE ( GFG )

    /*

    Given a Singly linked list, reverse every k node in the linked list and return the head of the modified list. If the node count is not a multiple of k then the left-out nodes at the end, should be considered as a group and must be reversed.

Examples:

Input: head: 1 -> 2 -> 3 -> 4 -> 5 -> 6, k = 2

Output: 2 -> 1 -> 4 -> 3 -> 6 -> 5
Explanation: Linked List is reversed in a group of size k = 2.

Input: head: 1 -> 2 -> 3 -> 4 -> 5 -> 6, k = 4,

Output: 4 -> 3 -> 2 -> 1 -> 6 -> 5
Explanation: Linked List is reversed in a group of size k = 4.

Constraints:
1 ≤ size of linked list ≤ 105
0 ≤ node.data ≤ 106
1 ≤ k ≤ head.size()

Expected Complexities
Time Complexity: O(n)
Auxiliary Space: O(1)

Company Tags
Paytm   VMWare  Accolite    Amazon  Microsoft   Snapdeal    Hike
MakeMyTrip  Walmart GoldmanSachs Adobe SAPLabs

     */

    static class Node{

        int data;
        Node next;

        Node(int data){

            this.data = data;
            this.next = null;

        }
    }

    static Node llReverseGroup(Node head, int k){

        if( head == null || k <= 1 ){
            return head;
        }

        Node prev = null;
        Node curr = head;
        int count = 0;

        while( curr != null && count < k ){

            Node forward = curr.next;

            curr.next = prev;

            prev = curr;
            curr = forward;

            count++;
        }

        Node recursionKeAnsKaHead = llReverseGroup(curr, k);

        head.next = recursionKeAnsKaHead;

        return prev;
    }

    static void main() {

        reverseNodesInKGroup obj = new reverseNodesInKGroup();

//        ******************* LeetCode ***************

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int k = 3;
        ListNode newHead = obj.reverseKGroup(head, k);

        System.out.print(" LL after reversing the nodes in "+k+" groups: ");

        while( newHead != null ){

            System.out.print(
                    newHead.val + " -> "
            );
            newHead = newHead.next;
        }
        System.out.println("Null");

//        ****************** GFG ***************

        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);

        int k1 = 3;
        Node newHead1 = obj.llReverseGroup(head1, k);

        System.out.print(" LL after reversing the nodes in "+k+" groups (GFG) : ");

        while( newHead1 != null ){

            System.out.print(
                    newHead1.data + " -> "
            );
            newHead1 = newHead1.next;
        }
        System.out.println("Null");
    }
}
