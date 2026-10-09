package DSA_LoveBabbar.Linked_List;

public class cycleInLL2 {

    //  LINKED LIST CYCLE II

    /*

    Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as a parameter.

Do not modify the linked list.

Example 1:
Input: head = [3,2,0,-4], pos = 1
Output: tail connects to node index 1
Explanation: There is a cycle in the linked list, where tail connects to the second node.

Example 2:
Input: head = [1,2], pos = 0
Output: tail connects to node index 0
Explanation: There is a cycle in the linked list, where tail connects to the first node.

Example 3:
Input: head = [1], pos = -1
Output: no cycle
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

//    To detect the starting node of a cycle in a linked list,
//    the most efficient method is Floyd's Cycle-Finding Algorithm (also known as the Tortoise and Hare algorithm).
//    This approach finds the cycle entrance in O(N) time complexity and O(1) auxiliary space complexity
    static ListNode detectCycle(ListNode head){

        //Step 1 -> writing the logic for detecting cycle

        ListNode slow = head;
        ListNode fast = head;

        boolean hasCycle = false;

        while( fast != null ){
            fast = fast.next;
            if( fast != null ){

                fast = fast.next;
                slow = slow.next;

            }

            // check whether cycle is formed or not
            if( fast == slow ){
                hasCycle = true;
                break;
            }
        }

        // if cycle not formed
        if( fast != slow){
            return null;
        }

        // Step 2 -> writing a logic for detecting the head node of the cycle
        // Logic behind this is that, when we found the node where both fast and slow
        // variable met each other, at that time we got to know that there is a cycle in a given LL
        // So for next finding the head node of that cycle

        // start the slow variable again from head node of LL
        // And keep the fast node at the same place, where slow and fast met each other
        // and move both the variable forward by one step of speed
        // Let x -> be the distance from the head of the given LL to the head of the cycle
        // Let y -> be the distance from head of the cycle to fast variable
        // Let kz -> where k is the no. of loops of cycle and z is a loop of a cycle
        // fast variable( 2 step speed) = 2 * slow variable( 1 step speed)
        // i.e. Distance travelled by fast = 2 * (Distance travelled by slow)
        // i.e. s = d/t, where s directly proportional to the distance

        // Therefore, x+kz+y = 2(x+y)
        // kz = x+y
        // x = kz-y

        slow = head;
        while( fast != slow ){
            fast = fast.next;
            slow = slow.next;
        }

        return slow;

    }

    static void main() {

        cycleInLL2 obj = new cycleInLL2();

        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);

        head.next.next.next.next = head.next;

        ListNode cycleHead = obj.detectCycle(head);

        System.out.println(
                "Tail connects to the node: " + cycleHead.val
                );
    }
}
