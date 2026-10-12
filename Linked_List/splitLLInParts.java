package DSA_LoveBabbar.Linked_List;

public class splitLLInParts {

    //  SPLIT LINKED LIST IN PARTS

    /*

    Given the head of a singly linked list and an integer k, split the linked list into k consecutive linked list parts.

The length of each part should be as equal as possible: no two parts should have a size differing by more than one. This may lead to some parts being null.

The parts should be in the order of occurrence in the input list, and parts occurring earlier should always have a size greater than or equal to parts occurring later.

Return an array of the k parts.

Example 1:
Input: head = [1,2,3], k = 5
Output: [[1],[2],[3],[],[]]
Explanation:
The first element output[0] has output[0].val = 1, output[0].next = null.
The last element output[4] is null, but its string representation as a ListNode is [].

Example 2:
Input: head = [1,2,3,4,5,6,7,8,9,10], k = 3
Output: [[1,2,3,4],[5,6,7],[8,9,10]]
Explanation:
The input has been split into consecutive parts with size difference at most 1, and earlier parts are a larger size than the later parts.

Constraints:
The number of nodes in the list is in the range [0, 1000].
0 <= Node.val <= 1000
1 <= k <= 50

     */

    static class ListNode{

        int val;
        ListNode next;

        ListNode(int val){

            this.val = val;
            this.next = null;

        }
    }

    static ListNode[] splitListsToParts(ListNode head, int k){

        ListNode[] ans = new ListNode[k];

        // Calculate length of LL
        int Len = 0;
        ListNode temp = head;
        while( temp != null ){

            Len++;
            temp = temp.next;
        }

        // Calculate base size and extra nodes
        int baseSize = (Len / k);
        int extraNode = (Len % k);

        ListNode prev = null;
        ListNode curr = head;

        // Create sub lists
        for( int parts = 0; parts < k; parts++){

            // If LL is empty
            if( curr == null ){
                ans[parts] = curr;
                continue;
            }

            ans[parts] = curr;
            // Calculate width i.e. Size of sub lists
            int width = baseSize + ( extraNode > 0 ? 1 : 0 );
            extraNode--;

            // creation of sub list
            for( int i = 1 ; i <= width; i++ ){

                prev = curr;
                curr = curr.next;

            }

            // point next of end node of sub list to null
            prev.next = null;
        }
        return ans;
    }

    static void main() {

        splitLLInParts obj = new splitLLInParts();

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next.next.next.next.next = new ListNode(10);

        ListNode[] output = obj.splitListsToParts(head,3);

        for(int i = 0; i < output.length; i++) {

            System.out.print("Part " + (i + 1) + ": ");

            ListNode node = output[i];

            while(node != null) {
                System.out.print(node.val + " -> ");
                node = node.next;
            }

            System.out.println("null");
        }

    }
}
