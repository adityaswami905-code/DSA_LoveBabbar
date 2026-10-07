package DSA_LoveBabbar.Linked_List;

import java.util.Stack;

public class delNAfterMNodesInLL {

    //  DELETE N NODES AFTER EVERY M NODES IN LINKED LIST

    /*

    Given a linked list, delete n nodes after skipping m nodes of a linked list until the last of the linked list.

Examples:

Input: head: 9 -> 1 -> 3 -> 5 -> 9 -> 4 -> 10 -> 1, n = 1, m = 2
Output: 9 -> 1 -> 5 -> 9 -> 10 -> 1
Explanation: Deleting 1 node after skipping 2 nodes each time, we have list as 9 -> 1 -> 5 -> 9 -> 10 -> 1.

Input: head: 1 -> 2 -> 3 -> 4 -> 5 -> 6, n = 1, m = 6
Output: 1 -> 2 -> 3 -> 4 -> 5 -> 6
Explanation: After skipping 6 nodes for the first time , we will reach of end of the linked list, so, we will get the given linked list itself.

Constraints:
1 <= size of linked list <= 104
1 <= n, m <= size of linked list

Expected Complexities
Time Complexity: O(n)
Auxiliary Space: O(1)

Company Tags
Amazon  Microsoft

     */

    static class Node{

        int data;
        Node next;

        Node(int data){

            this.data = data;
            this.next = null;

        }
    }

    // Problem is simple to solve
    // Can be solved by links rearrange( i.e. Pointer manipulation in CPP/C++ )
    // But only thing is to keep in mind, Null Pointer Exception
    static Node linkDelete(Node head, int m , int n){

        // creating two variables
        // i.e. prev and curr
        Node prev = null;
        Node curr = head;

        // Repeat Ignore and Delete
        while( curr != null ){

            // M Nodes are ignoring
            for( int i = 1; i <= m && curr != null; i++ ){

                prev = curr;
                curr = curr.next;

            }

            // Checking for the null pointer exception
            if( curr == null ){
                return head;
            }

            // N Nodes are deleting
            for( int i = 1; i <= n && curr != null; i++ ){

                curr = curr.next;
            }

            // Links re-arrange
            prev.next = curr;


        }
        return head;
    }

    static void main() {

        delNAfterMNodesInLL obj = new delNAfterMNodesInLL();

        Node head = new Node(9);
        head.next = new Node(1);
        head.next.next = new Node(3);
        head.next.next.next = new Node(5);
        head.next.next.next.next = new Node(9);
        head.next.next.next.next.next = new Node(4);
        head.next.next.next.next.next.next = new Node(10);
        head.next.next.next.next.next.next.next = new Node(1);

        int m = 2;
        int n = 1;
        Node newHead = obj.linkDelete(head,m,n);

        System.out.print("Modified LL is : ");
        while( newHead != null ){
            System.out.print(
                    newHead.data + " -> "
            );
            newHead = newHead.next;
        }
        System.out.println("Null");

    }
}
