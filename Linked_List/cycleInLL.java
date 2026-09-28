package DSA_LoveBabbar.Linked_List;

public class cycleInLL {

    //  LINKED LIST CYCLE

    /*

    Given head, the head of a linked list, determine if the linked list has a cycle in it.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

Return true if there is a cycle in the linked list. Otherwise, return false.

Example 1:
Input: head = [3,2,0,-4], pos = 1
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).

Example 2:
Input: head = [1,2], pos = 0
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.

Example 3:
Input: head = [1], pos = -1
Output: false
Explanation: There is no cycle in the linked list.

Constraints:
The number of the nodes in the list is in the range [0, 104].
-105 <= Node.val <= 105
pos is -1 or a valid index in the linked-list.


     */

    static class ListNode{

        int val;
        ListNode next;

        ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }

    // Here we are using, Floyd's Cycle-Finding Algorithm, also known as the Tortoise and Hare approach. This method runs in O(n) time and O(1) constant space

    static boolean hasCycle(ListNode head){

        ListNode fast = head;
        ListNode slow = head;

        while( fast != null ){

            fast = fast.next;

            if( fast != null ){

                fast = fast.next;
                slow = slow.next;
            }

            // Logic behind whether the cycle is formed or not
            // i.e. We know that if two object are running in a circular path
            // and if they both has different speed (i.e. one will be fast and one will be slow) then they will meet at the same point
            // but if they both has same speed then they never meet to each other at the same point
            if( fast == slow ){
                return true;
            }
        }
        return false;
    }

    static void main() {

        cycleInLL obj = new cycleInLL();

        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);

        // Creating cycle
        head.next.next.next.next = head.next;

        System.out.println(obj.hasCycle(head));
    }
}
