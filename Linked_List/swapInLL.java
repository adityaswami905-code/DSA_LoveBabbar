package DSA_LoveBabbar.Linked_List;

public class swapInLL {

    //  SWAP NODES IN A LINKED LIST

    /*

    You are given the head of a linked list, and an integer k.

Return the head of the linked list after swapping the values of the kth node from the beginning and the kth node from the end (the list is 1-indexed).

Example 1:
Input: head = [1,2,3,4,5], k = 2
Output: [1,4,3,2,5]

Example 2:
Input: head = [7,9,6,6,7,8,3,0,9,5], k = 5
Output: [7,9,6,6,8,7,3,0,9,5]

Constraints:
The number of nodes in the list is n.
1 <= k <= n <= 105
0 <= Node.val <= 100

     */

    static class ListNode{
        int val;
        ListNode next;

        ListNode(int val){

            this.val = val;
            this.next = null;

        }
    }

    static ListNode swapNodes(ListNode head, int k){

        ListNode first = head;

        for( int i = 1; i <= k-1; i++ ){
            first = first.next;
        }
        // now we got the kth node from the beginning of LL

        ListNode temp = first.next;
        ListNode second = head;

        // Using sliding window technique
        while( temp != null ){

            temp = temp.next;
            second = second.next;

        }
        // Also we got the kth node from the end of LL

        // Swap nodes
        int swap = first.val;
        first.val = second.val;
        second.val = swap;

        // return modified LL head
        return head;
    }

    static void main() {

        swapInLL obj = new swapInLL();

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int k = 2;
        ListNode newHead = obj.swapNodes(head,k);

        System.out.print(" LL after swap: ");
        while( newHead != null ){
            System.out.print(
                    newHead.val + " -> "
            );
            newHead = newHead.next;
        }
        System.out.println("Null");
    }
}
