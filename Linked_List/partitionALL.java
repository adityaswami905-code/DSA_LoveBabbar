package DSA_LoveBabbar.Linked_List;

public class partitionALL {

    //  PARTITION LIST

    /*

    Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

Example 1:
Input: head = [1,4,3,2,5,2], x = 3
Output: [1,2,2,4,3,5]

Example 2:
Input: head = [2,1], x = 2
Output: [1,2]


Constraints:
The number of nodes in the list is in the range [0, 200].
-100 <= Node.val <= 100
-200 <= x <= 200

     */

    static class ListNode{

        int val;
        ListNode next;

        ListNode(int val){

            this.val = val;
            this.next = null;

        }
    }

    static ListNode partitionList(ListNode head, int x){

        ListNode lesserHead = new ListNode(-1);
        ListNode lesserTail = lesserHead;

        ListNode greaterHead = new ListNode(-1);
        ListNode greaterTail = greaterHead;

        ListNode temp = head;

        while( temp != null ){

            // Step 1 -> creating a LL containing all the nodes, such that all nodes less than x come before nodes greater than or equal to x
            if( temp.val < x ){

                ListNode nodeToInsert = temp;
                temp = temp.next;

                nodeToInsert.next = null;

                lesserTail.next = nodeToInsert;
                lesserTail = lesserTail.next;

            }
            // Step 2 -> creating a LL containing all the nodes, such that all nodes greater than or equal to x come after nodes lesser than x
            else{
                // i.e. temp.val >= x

                ListNode nodeToInsert = temp;
                temp = temp.next;

                nodeToInsert.next = null;

                greaterTail.next = nodeToInsert;
                greaterTail = greaterTail.next;

            }
        }
        // Step 3 -> merging two sub list
        lesserTail.next = greaterHead.next;
        greaterTail.next = null;
        lesserHead = lesserHead.next;

        // return modified LL head
        return lesserHead;
    }

    static void main() {

        partitionALL obj = new partitionALL();

        ListNode head = new ListNode(2);
        head.next = new ListNode(1);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(2);
//        head.next.next.next.next = new ListNode(5);
//        head.next.next.next.next.next = new ListNode(2);


        ListNode modifiedHead = obj.partitionList(head, 2);

        System.out.print("Partition List: ");

        while( modifiedHead != null ){

            System.out.print(
                    modifiedHead.val + " -> "
            );
            modifiedHead = modifiedHead.next;
        }
        System.out.println("Null");
    }
}
