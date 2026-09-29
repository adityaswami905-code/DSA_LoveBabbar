package DSA_LoveBabbar.Linked_List;

public class removeDuplicatesInLL {

    //  REMOVE DUPLICATES FROM SORTED LIST

    /*

    Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.

Example 1:
Input: head = [1,1,2]
Output: [1,2]

Example 2:
Input: head = [1,1,2,3,3]
Output: [1,2,3]

Constraints:
The number of nodes in the list is in the range [0, 300].
-100 <= Node.val <= 100
The list is guaranteed to be sorted in ascending order.

     */

    static class ListNode{

        int val;
        ListNode next;

        ListNode(int val){

            this.val = val;
            this.next = null;

        }
    }

    static ListNode removeDuplicates(ListNode head){

        // If LL is empty
        if( head == null ){
            return head;
        }

        // If Ll contains single node
        if( head.next == null ){
            return head;
        }

        // If LL contains >1 node
        ListNode prev = head;
        ListNode curr = head.next;

        while( curr != null ){

            if( prev.val != curr.val ){

                prev = prev.next;
                curr = curr.next;
            }
            else{
                // i.e. prev.val == curr.val
                prev.next = curr.next;
                curr = curr.next;
            }
        }
        return head;

    }

    static void main() {

        removeDuplicatesInLL obj = new removeDuplicatesInLL();

        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);

        ListNode ans = obj.removeDuplicates(head);

        while( ans != null ){
            System.out.print(
                    ans.val + " -> "
            );
            ans = ans.next;

        }
        System.out.println("Null");
    }
}
