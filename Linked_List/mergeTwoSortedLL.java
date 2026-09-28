package DSA_LoveBabbar.Linked_List;

public class mergeTwoSortedLL {

    //  MERGE TWO SORTED LINKED LIST

    /*

    You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.

Example 1:
Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]

Example 2:
Input: list1 = [], list2 = []
Output: []

Example 3:
Input: list1 = [], list2 = [0]
Output: [0]

Constraints:
The number of nodes in both lists is in the range [0, 50].
-100 <= Node.val <= 100
Both list1 and list2 are sorted in non-decreasing order.

     */

    static class ListNode{

        int val;
        ListNode next ;

        ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }

    static ListNode mergeTwoLinkedList(ListNode list1, ListNode list2){

        ListNode dummy = new ListNode(-1);
        ListNode ansHead = dummy;
        ListNode ansTail = dummy;

        while( list1 != null && list2 != null ) {

            if (list1.val < list2.val) {

                ansTail.next = list1;
                ansTail = ansTail.next;
                list1 = list1.next;
            }
            // else case
//            i.e.list1.val >= list2.val
            else {
                ansTail.next = list2;
                ansTail = ansTail.next;
                list2 = list2.next;
            }
        }
            // above was the basic case i.e. both LL are of same size
            // but if the list1 LL is larger than list2 then
            if ( list1 != null ){
                ansTail.next = list1;
            }

            // ans vice-versa
            if ( list2 != null ){
                ansTail.next = list2;
            }

            // as we know that we created a dummy node containing val -1 and contains ansHead
            // so to return the correct ans, as it asked merge the two sorted LL and give the head of the merged LL
            // i.e. moving the ansHead forward and dummy will point to the null and remaining Java Garbage Collector
            ansHead = ansHead.next;
            dummy = null;



        // return final head
        return ansHead;
    }

    static void main() {

        mergeTwoSortedLL obj = new mergeTwoSortedLL();

        // list1 = 1 -> 2 -> 3
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(4);

        //list2 = 1 -> 3 -> 4
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(3);
        head2.next.next = new ListNode(4);

        ListNode ans = obj.mergeTwoLinkedList(head1,head2);

        while (ans.next != null){
            System.out.print(ans.val+" -> ");
            ans = ans.next;
        }
        System.out.println("Null");
    }
}
