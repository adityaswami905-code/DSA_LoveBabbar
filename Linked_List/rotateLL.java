package DSA_LoveBabbar.Linked_List;

public class rotateLL {

    //  ROTATE LIST

    /*

    Given the head of a linked list, rotate the list to the right by k places.

Example 1:
Input: head = [1,2,3,4,5], k = 2
Output: [4,5,1,2,3]

Example 2:
Input: head = [0,1,2], k = 4
Output: [2,0,1]

Constraints:
The number of nodes in the list is in the range [0, 500].
-100 <= Node.val <= 100
0 <= k <= 2 * 109

     */

    static class ListNode{

        int val;
        ListNode next;

        ListNode(int val){

            this.val = val;
            this.next = null;
        }
    }

    static ListNode rotateRight(ListNode head, int k){

        if( head == null || k == 0 ){
            return head;
        }

        // Step 1 -> make LL circular and find the length of the LL
        int Len = 1;
        ListNode temp = head;

        // Here we are checking temp.next instead of temp
        // This is because, if we check temp != null then at last temp will reach to the null
        // So then it is not possible to make it into circular LL
        // That is why, we used temp.next;
        while( temp.next != null ){
            Len++;
            temp = temp.next;
        }

        // Making LL circular
        temp.next = head;

        // modifying the value of k
        // i.e. if k is greater than the length of the LL
        k = k % Len;

        // Step 2 -> Breaking the CLL from kth, which make again into LL
        // i.e. Len-k-1;

        temp = head;
        for( int i = 1; i <= Len-k-1; i++){
            temp = temp.next;
        }

        // creating forward, so that after breaking it should become the head of the modified LL
        ListNode forward = temp.next;

        // breaking LL
        temp.next = null;

        // Returning the modified head of LL
        return forward;
    }

    static void main() {

        rotateLL obj = new rotateLL();

        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);

        int k = 4;

        ListNode newHead = rotateRight(head,k);

        while ( newHead != null ){
            System.out.print(
                    newHead.val + " -> "
            );
            newHead = newHead.next;
        }
        System.out.println("Null");
    }
}
