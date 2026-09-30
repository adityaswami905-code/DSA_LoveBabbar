package DSA_LoveBabbar.Linked_List;

public class oddEvenLL {

    //  ODD EVEN LINKED LIST

    /*

    Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.

The first node is considered odd, and the second node is even, and so on.

Note that the relative order inside both the even and odd groups should remain as it was in the input.

You must solve the problem in O(1) extra space complexity and O(n) time complexity.

Example 1:
Input: head = [1,2,3,4,5]
Output: [1,3,5,2,4]

Example 2:
Input: head = [2,1,3,5,6,4,7]
Output: [2,3,6,7,1,5,4]

Constraints:
The number of nodes in the linked list is in the range [0, 104].
-106 <= Node.val <= 106

     */

    static class ListNode{

        int val;
        ListNode next;

        ListNode(int val){

            this.val = val;
            this.next = null;

        }
    }

    static ListNode oddEvenList(ListNode head){

        // If LL is empty
        if( head == null ){
            return head;
        }

        // if LL contains single element
        if( head.next == null ){
            return head;
        }

        // if LL contains multiple nodes
        ListNode oddHead = head;
        ListNode oddTail = head;
        ListNode evenHead = head.next;
        ListNode evenTail = head.next;

        while( evenTail != null && evenTail.next != null ){

            // links re-arranging
            oddTail.next = evenTail.next;
            // update oddTail
            oddTail = evenTail.next;

            evenTail.next = oddTail.next;
            // update evenTail
            evenTail = oddTail.next;

            // But one question may arrive in mind that in the condition of while loop
            // we are checking that evenTail must not be equal to the null
            // but why we didn't checked for odd tail
            // because odd tail is initially pointing to the head node
            // and at that point it was not updated that why we are using even tail's next

        }

        // now merging the odd and even list to get desired LL
        // this is because, all odd position node will be first half of the modified LL

        oddTail.next = evenHead;

        // and return the head of the modified LL
        return oddHead;
    }

    static void main() {

        oddEvenLL obj = new oddEvenLL();

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode modifiedHead = obj.oddEvenList(head);

        while (modifiedHead != null ){
            System.out.print(modifiedHead.val + " -> ");
            modifiedHead = modifiedHead.next;
        }
        System.out.println("Null");
    }
}
