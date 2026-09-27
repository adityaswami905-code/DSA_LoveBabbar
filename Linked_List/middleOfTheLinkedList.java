package DSA_LoveBabbar.Linked_List;

public class middleOfTheLinkedList {

    //  MIDDLE OF THE LINKED LIST

    /*

    Given the head of a singly linked list, return the middle node of the linked list.

If there are two middle nodes, return the second middle node.

Example 1:

Input: head = [1,2,3,4,5]
Output: [3,4,5]
Explanation: The middle node of the list is node 3.
Example 2:

Input: head = [1,2,3,4,5,6]
Output: [4,5,6]
Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.

Constraints:

The number of nodes in the list is in the range [1, 100].
1 <= Node.val <= 100

     */

    static class ListNode{

        int val;
        ListNode next;

        ListNode(int val){
            this.val = val;
            this.next = null;

        }
    }

    // Here we are using Tortoise and Hear approach i.e. (Fast-slow pointer approach)
    //i.e. Suppose Tortoise speed is 1 step at a time
    // and Hear speed is 2 step at a time
    // i.e. if hear covers x distance then tortoise must cover x/2 distance
    // and that is how we will get the middle node i.e. midpoint
    // Hence middle of the LL is found

    public static ListNode middleNode(ListNode head){

        ListNode fast = head;
        ListNode slow = head;

        while( fast != null ){

            fast = fast.next;
            // check whether the fast variable reach the null after one step or not
            // because slow variable move 1 step forward if and only if fast variable move 2 steps
            if( fast != null ){
                fast = fast.next;
                slow = slow.next;

            }
        }
        // as fast == null means, fast traversed whole LL
        // and slow variable must be on middle node of the LL
        // therefore
        return slow;
    }

    static void main() {

        middleOfTheLinkedList obj = new middleOfTheLinkedList();

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        ListNode temp = middleNode(head);
        System.out.println("Middle Node: "+temp.val);

    }
}
