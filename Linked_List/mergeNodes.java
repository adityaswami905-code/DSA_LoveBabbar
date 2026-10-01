package DSA_LoveBabbar.Linked_List;

public class mergeNodes {

    //  MERGE NODES IN BETWEEN ZERO'S

    /*

    You are given the head of a linked list, which contains a series of integers separated by 0's. The beginning and end of the linked list will have Node.val == 0.

For every two consecutive 0's, merge all the nodes lying in between them into a single node whose value is the sum of all the merged nodes. The modified list should not contain any 0's.

Return the head of the modified linked list.

Example 1:
Input: head = [0,3,1,0,4,5,2,0]
Output: [4,11]
Explanation:
The above figure represents the given linked list. The modified list contains
- The sum of the nodes marked in green: 3 + 1 = 4.
- The sum of the nodes marked in red: 4 + 5 + 2 = 11.

Example 2:
Input: head = [0,1,0,3,0,2,2,0]
Output: [1,3,4]
Explanation:
The above figure represents the given linked list. The modified list contains
- The sum of the nodes marked in green: 1 = 1.
- The sum of the nodes marked in red: 3 = 3.
- The sum of the nodes marked in yellow: 2 + 2 = 4.

Constraints:
The number of nodes in the list is in the range [3, 2 * 105].
0 <= Node.val <= 1000
There are no two consecutive nodes with Node.val == 0.
The beginning and end of the linked list have Node.val == 0.

     */

    static class ListNode{

        int val;
        ListNode next;

        ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }

    static ListNode mergeNodesInBetweenZeros(ListNode head){

        ListNode read = head.next;
        ListNode write = head;
        // Now just think by declaring two variable above it means LL must contains at least 2 nodes, is it true?
        // The answer is YES, because the question itself says that the given LL starts and end with zero(0)

        while( read != null ){

            // initializing sum variable
            int sum = 0;

            // add the node values in sum until the node value contains zero
            while( read.val != 0 ){

                // Updating sum
                sum = sum + read.val;
                // updating read variable
                read = read.next;
            }

            // I reached here, means i got the node containing value zero
            // Therefore
            // Now writing the updated sum value in write node
            // i.e.
            write.val = sum;

            // removing the nodes which are not needed
            write.next = read.next;

            // and finally updating the read and write respectively
            read = read.next;
            write = write.next;
        }

        // returning the head of the modified LL
        return head;
    }

    static void main() {

        mergeNodes obj = new mergeNodes();

        ListNode head = new ListNode(0);
        head.next = new ListNode(3);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(0);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next.next = new ListNode(0);

        ListNode newHead = obj.mergeNodesInBetweenZeros(head);

        while( newHead != null ){
            System.out.print(
                    newHead.val + " -> "
            );
            newHead = newHead.next;
        }
        System.out.print("Null");
    }
}
