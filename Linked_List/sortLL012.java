package DSA_LoveBabbar.Linked_List;

public class sortLL012 {

    //  SORT A LINKED LIST OF 0'S, 1'S AND 2'S

    /*

    Given the head of a linked list where nodes can contain values 0s, 1s, and 2s only. Your task is to rearrange the list so that all 0s appear at the beginning, followed by all 1s, and all 2s are placed at the end.

Examples:

Input: head = 1 → 2 → 2 → 1 → 2 → 0 → 2 → 2
Output: 0 → 1 → 1 → 2 → 2 → 2 → 2 → 2
Explanation: All the 0s are segregated to the left end of the linked list, 2s to the right end of the list, and 1s in between. The final list will be:

Input: head = 2 → 2 → 0 → 1
Output: 0 → 1 → 2 → 2
Explanation: After arranging all the 0s, 1s and 2s in the given format, the output will be:

Constraints:
1 ≤ size of linked list ≤ 106
0 ≤ node.data ≤ 2

Expected Complexities
Time Complexity: O(n)
Auxiliary Space: O(1)

Company Tags
Amazon  Microsoft   MakeMyTrip  NPCI

     */

    static class Node{

        int data;
        Node next;

        Node(int d){
            this.data = d;
            this.next = null;
        }
    }

    static Node segregate(Node head){

        // Initially creating three dummy nodes

        // For all zero's node
        Node zeroHead = new Node(-1);
        Node zeroTail = zeroHead;

        // For all one's node
        Node oneHead = new Node(-1);
        Node oneTail = oneHead;

        // For all two's node
        Node twoHead = new Node(-1);
        Node twoTail = twoHead;

        Node temp = head;

        while( temp != null ){

            if( temp.data == 0 ){

                Node nodeToInsert = temp;
                temp = temp.next;

                nodeToInsert.next = null;

                zeroTail.next = nodeToInsert;
                zeroTail = nodeToInsert;

            }
            else if( temp.data == 1 )
            {
                Node nodeToInsert = temp;
                temp = temp.next;

                nodeToInsert.next = null;

                oneTail.next = nodeToInsert;
                oneTail = nodeToInsert;

            }
            else{

                // if temp.data == 2
                Node nodeToInsert = temp;
                temp = temp.next;

                nodeToInsert.next = null;

                twoTail.next = nodeToInsert;
                twoTail = nodeToInsert;

            }
        }

        // Now we got all sublists i.e. 0's, 1's and 2's
        // now ready to join
        zeroTail.next = (oneHead.next != null ) ? oneHead.next : twoHead.next;
        oneTail.next = twoHead.next;
        twoTail.next = null;


        // updating the zero's head
        zeroHead = zeroHead.next;

        // return the head of modified LL
        return zeroHead;
    }

    static void main() {


        sortLL012 obj = new sortLL012();

        Node head = new Node(2);
        head.next = new Node(2);
        head.next.next = new Node(0);
        head.next.next.next = new Node(1);
//        head.next.next.next.next = new Node(0);
//        head.next.next.next.next.next = new Node(2);

        Node modifiedHead = obj.segregate(head);

        System.out.print(" LL after sorting: ");

        while( modifiedHead != null ){

            System.out.print(
                    modifiedHead.data + " -> "
            );
            modifiedHead = modifiedHead.next;
        }
        System.out.println("Null");
    }
}
