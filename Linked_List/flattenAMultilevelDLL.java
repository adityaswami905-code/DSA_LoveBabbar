package DSA_LoveBabbar.Linked_List;

public class flattenAMultilevelDLL {

    //  FLATTEN A MULTILEVEL DOUBLY LINKED LISTS

    /*

    You are given a doubly linked list, which contains nodes that have a next pointer, a previous pointer, and an additional child pointer. This child pointer may or may not point to a separate doubly linked list, also containing these special nodes. These child lists may have one or more children of their own, and so on, to produce a multilevel data structure as shown in the example below.

Given the head of the first level of the list, flatten the list so that all the nodes appear in a single-level, doubly linked list. Let curr be a node with a child list. The nodes in the child list should appear after curr and before curr.next in the flattened list.

Return the head of the flattened list. The nodes in the list must have all of their child pointers set to null.

Example 1:
Input: head = [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
Output: [1,2,3,7,8,11,12,9,10,4,5,6]
Explanation: The multilevel linked list in the input is shown.
After flattening the multilevel linked list it becomes:

Example 2:
Input: head = [1,2,null,3]
Output: [1,3,2]
Explanation: The multilevel linked list in the input is shown.
After flattening the multilevel linked list it becomes:

Example 3:
Input: head = []
Output: []
Explanation: There could be empty list in the input.

Constraints:
The number of Nodes will not exceed 1000.
1 <= Node.val <= 105

How the multilevel linked list is represented in test cases:

We use the multilevel linked list from Example 1 above:

 1---2---3---4---5---6--NULL
         |
         7---8---9---10--NULL
             |
             11--12--NULL
The serialization of each level is as follows:

[1,2,3,4,5,6,null]
[7,8,9,10,null]
[11,12,null]
To serialize all levels together, we will add nulls in each level to signify no node connects to the upper node of the previous level. The serialization becomes:

[1,    2,    3, 4, 5, 6, null]
             |
[null, null, 7,    8, 9, 10, null]
                   |
[            null, 11, 12, null]
Merging the serialization of each level and removing trailing nulls we obtain:

[1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]

     */

    static class Node{

        int val;
        Node next;
        Node prev;
        Node child;

        Node(int val){

            this.val = val;
            this.next = null;
            this.prev = null;
            this.child = null;

        }
    }

    static Node flattenDLL(Node head){

        // If DLL is empty
        if( head == null ){
            return head;
        }

        Node p = head;

        while( p != null ){

            // if DLL, does not contain any child node
            if( p.child == null ){
                p = p.next;
            }
            else{
                // If p.child contains DLL, then

                Node temp = p.child;
                // Traversing temp over the Child DLL
                while( temp.next != null ){
                    temp = temp.next;
                }

                // Links manipulation

                // Check whether the p's next is null or not
                if( p.next != null ){
                    temp.next = p.next;
                    p.next.prev = temp;
                }

                p.next = p.child;
                p.child.prev = p;

                p.child = null;
            }

        }

        // Return head of modified DLL
        return head;
    }

    // Connect two nodes in a doubly linked list
    static void connect(Node a, Node b) {
        a.next = b;
        b.prev = a;
    }

    public static void main(String[] args) {

        // Level 1: 1 <-> 2 <-> 3 <-> 4 <-> 5 <-> 6
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);

        connect(n1, n2);
        connect(n2, n3);
        connect(n3, n4);
        connect(n4, n5);
        connect(n5, n6);

        // Level 2: 7 <-> 8 <-> 9 <-> 10
        Node n7 = new Node(7);
        Node n8 = new Node(8);
        Node n9 = new Node(9);
        Node n10 = new Node(10);

        connect(n7, n8);
        connect(n8, n9);
        connect(n9, n10);

        // Level 3: 11 <-> 12
        Node n11 = new Node(11);
        Node n12 = new Node(12);

        connect(n11, n12);

        // Create child connections
        n3.child = n7;
        n8.child = n11;

        // Flatten the multilevel doubly linked list
        Node head = flattenDLL(n1);

        // Print flattened list
        Node temp = head;

        System.out.print("Flattened DLL: ");

        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }
}
