package DSA_LoveBabbar.Linked_List;

public class doubleANumberInLL {

    //  DOUBLE A NUMBER REPRESENTED AS A LINKED LIST

    /*

    You are given the head of a non-empty linked list representing a non-negative integer without leading zeroes.

Return the head of the linked list after doubling it.

Example 1:
Input: head = [1,8,9]
Output: [3,7,8]
Explanation: The figure above corresponds to the given linked list which represents the number 189. Hence, the returned linked list represents the number 189 * 2 = 378.

Example 2:
Input: head = [9,9,9]
Output: [1,9,9,8]
Explanation: The figure above corresponds to the given linked list which represents the number 999. Hence, the returned linked list reprersents the number 999 * 2 = 1998.

Constraints:
The number of nodes in the list is in the range [1, 104]
0 <= Node.val <= 9
The input is generated such that the list represents a number that does not have leading zeros, except the number 0 itself.

     */

    static class ListNode{

        int val;
        ListNode next;

        ListNode(int val){

            this.val = val;
            this.next = null;

        }
    }

    // Linked List Reverse Logic
    static ListNode reverse(ListNode head){

        ListNode prev = null;
        ListNode curr = head;

        while( curr != null ){

            ListNode forward = curr.next;

            curr.next = prev;

            prev = curr;
            curr = forward;

        }
        return prev;
    }

    static ListNode doubleIt(ListNode head){

        // Step 1 -> reverse LL
        head = reverse(head);

        // Step 2 - > do some maths
        ListNode temp = head;

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        int carry = 0;

        while( temp != null ){

            // get value containing the respective node
            int value = temp.val;

            // calculate sum
            int sum = value * 2 + carry;

            // get digit value
            int digit = sum % 10;

            // add new node to new LL
            curr.next = new ListNode(digit);
            curr = curr.next;

            // Get carry value, also move forward temp variable
            carry = sum / 10;
            temp = temp.next;

        }

        // check whether the carry exists when temp == null
        if( temp == null && carry > 0 ){
            curr.next = new ListNode(carry);
        }

        // modify the head of new LL
        dummy = dummy.next;

        // Step 3 -> reverse LL
        head = reverse(dummy);

        // Step 4 -> return modified LL head
        return head;
    }

    static void main() {

        doubleANumberInLL obj = new doubleANumberInLL();

        ListNode head = new ListNode(9);
        head.next = new ListNode(9);
        head.next.next = new ListNode(9);

        ListNode modifiedHead = obj.doubleIt(head);

        System.out.print("Linked List after doubling a number represented as a LL: ");
        while( modifiedHead != null ){

            System.out.print(
                    modifiedHead.val + " -> "
            );
            modifiedHead = modifiedHead.next;
        }
        System.out.println("Null");
    }
}
