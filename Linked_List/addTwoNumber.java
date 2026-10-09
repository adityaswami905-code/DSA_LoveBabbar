package DSA_LoveBabbar.Linked_List;

public class addTwoNumber {

    //  ADD TWO NUMBERS

    /*

    You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example 1:
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.

Example 2:
Input: l1 = [0], l2 = [0]
Output: [0]

Example 3:
Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]


Constraints:
The number of nodes in each linked list is in the range [1, 100].
0 <= Node.val <= 9
It is guaranteed that the list represents a number that does not have leading zeros.

     */

    static class ListNode{

        int val;
        ListNode next;

        ListNode(int val){

            this.val = val;
            this.next = null;

        }
    }

    static ListNode addTwoNumbersOfLL(ListNode l1, ListNode l2){

        int carry = 0;
        ListNode newHead = new ListNode(-1);
        ListNode newTail = newHead;

        while( l1 != null || l2 != null || carry != 0 ){
            int sum = 0;
            if( l1 != null ){
                sum = sum + l1.val;
                l1 = l1.next;

            }

            if( l2 != null ){
                sum = sum + l2.val;
                l2 = l2.next;

            }

            sum = sum + carry;
            int digit = sum % 10;

            carry = sum / 10;

            ListNode newNode = new ListNode(digit);
            newTail.next = newNode;
            newTail = newNode;

            //

        }
        newHead = newHead.next;

        return newHead;
    }

    static void main() {

        addTwoNumber obj = new addTwoNumber();

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(5);
        l1.next.next = new ListNode(8);

        ListNode l2 = new ListNode(3);
        l2.next = new ListNode(2);
        l2.next.next = new ListNode(4);

        ListNode modifiedHead = obj.addTwoNumbersOfLL(l1,l2);

        System.out.print("LL after adding two number: ");

        while ( modifiedHead != null ){

            System.out.print(
                    modifiedHead.val + " -> "
            );
            modifiedHead = modifiedHead.next;
        }
        System.out.println("Null");
    }
}
