package DSA_LoveBabbar.Linked_List;

public class addOneTOLL {

    //  ADD 1 TO LINKED LIST NUMBER

    /*

    You are given head of a linked list where each node contains a single digit. The digits together represent a number formed by concatenating the node values in order. Add 1 to this number and return the head of the modified linked list.

Examples :

Input: Head: 4->5->6
Output: 457
Explanation: 4->5->6 represents 456 and when 1 is added it becomes 457.

Input: Head: 1->2->3
Output: 124
Explanation:  1->2->3 represents 123 and when 1 is added it becomes 124.

Input: Head: 0->0->1
Output: 002

Constraints:
1 ≤ size of linked list ≤ 105
0 ≤ node.data ≤ 9

     */

    static class Node{

        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    static Node reverseLL(Node head){

        Node prev = null;
        Node curr = head;

        while( curr != null ){

            Node forward = curr.next;

            curr.next = prev;

            prev = curr;
            curr = forward;
        }
        return prev;
    }

    static Node addOne(Node head){

        // Step 1 -> Reverse given LL
        head = reverseLL(head);

        // Step 2 -> Add 1 to LL logic
        Node curr = head;
        int carry = 1;

        while( curr != null){

            int sum = curr.data + carry;
            int digit = sum % 10;

            // modify curr node data
            curr.data = digit;

            carry = sum/10;

            // if carry is 0, then does not need to modify the next node data
            // therefore
            if( carry == 0){
                break;
            }

            if( curr.next == null ){
                // then create a new node if the curr data value contains 9
                // then after adding carry data becomes 10
                // so to curr 0 data is given
                // and 1 to the next node
                curr.next = new Node(carry);
                carry = 0;
                break;
            }

            // take curr forward
            curr = curr.next;


        }

        // Step 3 -> Reverse produced LL
        head = reverseLL(head);

        // Step 4 -> return head of modified LL
        return head;
    }

    static void main() {

        addOneTOLL obj = new addOneTOLL();

        Node head = new Node(9);
        head.next = new Node(9);
        head.next.next = new Node(9);

        Node newHead = obj.addOne(head);

        while ( newHead != null ){

            System.out.print(
                    newHead.data + " -> "
            );
            newHead = newHead.next;
        }
        System.out.println("Null");
    }
}
