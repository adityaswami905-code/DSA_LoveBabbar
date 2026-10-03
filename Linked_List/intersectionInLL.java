package DSA_LoveBabbar.Linked_List;

public class intersectionInLL {

    //  INTERSECTION OF TWO LINKED LISTS

    /*

    Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return null.

For example, the following two linked lists begin to intersect at node c1:

The test cases are generated such that there are no cycles anywhere in the entire linked structure.
Note that the linked lists must retain their original structure after the function returns.

Custom Judge:
The inputs to the judge are given as follows (your program is not given these inputs):
intersectVal - The value of the node where the intersection occurs. This is 0 if there is no intersected node.
listA - The first linked list.
listB - The second linked list.
skipA - The number of nodes to skip ahead in listA (starting from the head) to get to the intersected node.
skipB - The number of nodes to skip ahead in listB (starting from the head) to get to the intersected node.
The judge will then create the linked structure based on these inputs and pass the two heads, headA and headB to your program. If you correctly return the intersected node, then your solution will be accepted.

Example 1:
Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
Output: Intersected at '8'
Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect).
From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,6,1,8,4,5]. There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.

- Note that the intersected node's value is not 1 because the nodes with value 1 in A and B (2nd node in A and 3rd node in B) are different node references. In other words, they point to two different locations in memory, while the nodes with value 8 in A and B (3rd node in A and 4th node in B) point to the same location in memory.

Example 2:
Input: intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
Output: Intersected at '2'
Explanation: The intersected node's value is 2 (note that this must not be 0 if the two lists intersect).
From the head of A, it reads as [1,9,1,2,4]. From the head of B, it reads as [3,2,4]. There are 3 nodes before the intersected node in A; There are 1 node before the intersected node in B.

Example 3:
Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
Output: No intersection
Explanation: From the head of A, it reads as [2,6,4]. From the head of B, it reads as [1,5]. Since the two lists do not intersect, intersectVal must be 0, while skipA and skipB can be arbitrary values.
Explanation: The two lists do not intersect, so return null.


Constraints:
The number of nodes of listA is in the m.
The number of nodes of listB is in the n.
1 <= m, n <= 3 * 104
1 <= Node.val <= 105
0 <= skipA <= m
0 <= skipB <= n
intersectVal is 0 if listA and listB do not intersect.
intersectVal == listA[skipA] == listB[skipB] if listA and listB intersect.


     */

    static class ListNode {

        int val;
        ListNode next;

        ListNode(int val) {

            this.val = val;
            this.next = null;
        }
    }

    static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        // if any LL is empty
        if (headA == null || headB == null) {
            return null;
        }

        ListNode a = headA;
        ListNode b = headB;

        // for traversing the LLA and LLB
        while (a != null && b != null) {

            a = a.next;
            b = b.next;
        }

        // if a == null and there is chance that b may be equal to null or not
        if (a == null) {
            // So to calculate whether the b contains extra nodes or not
            int bExtraLen = 0;

            // calculating the extra length
            while (b != null) {
                bExtraLen++;
                b = b.next;
            }

            // And if the extra length is greater than zero, then moving the head of b forward
            // which is equal to the extra length of b
            while (bExtraLen-- > 0) {
                headB = headB.next;
            }
        } else {
            // If b == null and there is chance that a may be equal to null or not

            // So to calculate whether tha a contains extra nodes or not
            int aExtraLen = 0;

            // Calculating the extra length
            while (a != null) {
                aExtraLen++;
                a = a.next;
            }

            // And if the extra length is greater than zero, then moving the head of a forward
            // which is equal to the extra length of b
            while (aExtraLen-- > 0) {
                headA = headA.next;
            }

        }

        // Now headA and headB will travel to the same length
        while (headA != null && headB != null) {

            // if the node of headA and headB equal, then return intersection node
            if (headA == headB) {
                return headA;
            } else {
                // Move the headA and headB forward
                headA = headA.next;
                headB = headB.next;
            }

        }
        // else return null
        return null;
    }

    public static void main(String[] args) {

        intersectionInLL obj = new intersectionInLL();

        // Common part
        ListNode common = new ListNode(8);
        common.next = new ListNode(4);
        common.next.next = new ListNode(5);

        // List A
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = common;

        // List B
        ListNode headB = new ListNode(5);
        headB.next = new ListNode(6);
        headB.next.next = new ListNode(1);
        headB.next.next.next = common;

        ListNode commonNode = obj.getIntersectionNode(headA, headB);

        if (commonNode != null) {
            System.out.println(
                    "Intersection node of two LL is: "
                            + commonNode.val
            );
        } else {
            System.out.println("No intersection");
        }
    }
}
