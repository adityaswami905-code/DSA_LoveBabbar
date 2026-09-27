package DSA_LoveBabbar.Linked_List;

public class palindromeLinkedList {

    //  PALINDROME LINKED LIST

    /*

    Given the head of a singly linked list, return true if it is a palindrome or false otherwise.

Example 1:

Input: head = [1,2,2,1]
Output: true
Example 2:

Input: head = [1,2]
Output: false

Constraints:

The number of nodes in the list is in the range [1, 105].
0 <= Node.val <= 9

     */

    static class ListNode{

        int val;
        ListNode next;

        ListNode(int val){

            this.val = val;
            this.next = null;
        }
    }

    static ListNode getMiddle(ListNode head){

        ListNode fast = head;
        ListNode slow = head;

        while( fast != null ){

            fast = fast.next;

            if( fast != null ){

                fast = fast.next;
                slow = slow.next;
            }
        }
        return slow;
    }

    static ListNode reverseLL(ListNode head){

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

    public static boolean isPalindrome(ListNode head){

        if( head == null ){
            return true;
        }

        if( head.next == null ){
            return true;
        }

        // Divide the LL from midpoint (i.e. Tortoise-Hear approach)
        ListNode list2 = getMiddle(head);

        // separate LL in list1 and list2
        ListNode temp = head;
        while( temp.next != list2){
            temp = temp.next;
        }
        temp.next = null;

        // reverse list2
        ListNode head2 = reverseLL(list2);

        // check palindrome and
        // return true and false
        ListNode temp1 = head;
        ListNode temp2 = head2;

        while( temp1 != null && temp2 != null ){

            if( temp1.val != temp2.val ){
                return false;
            }
            else{
                temp1 = temp1.next;
                temp2 = temp2.next;
            }
        }
        return true;
    }

    static void main() {

        palindromeLinkedList obj = new palindromeLinkedList();

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
//        head.next.next = new ListNode(2);
//        head.next.next.next = new ListNode(1);

        System.out.println(
                "LL is palindrome: " + obj.isPalindrome(head)
        );


    }
}
