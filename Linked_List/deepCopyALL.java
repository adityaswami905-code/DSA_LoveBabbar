package DSA_LoveBabbar.Linked_List;

public class deepCopyALL {

    //  COPY LIST WITH RANDOM POINTER

    /*

    A linked list of length n is given such that each node contains an additional random pointer, which could point to any node in the list, or null.

Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, where each new node has its value set to the value of its corresponding original node. Both the next and random pointer of the new nodes should point to new nodes in the copied list such that the pointers in the original list and copied list represent the same list state. None of the pointers in the new list should point to nodes in the original list.

For example, if there are two nodes X and Y in the original list, where X.random --> Y, then for the corresponding two nodes x and y in the copied list, x.random --> y.

Return the head of the copied linked list.

The linked list is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:

val: an integer representing Node.val
random_index: the index of the node (range from 0 to n-1) that the random pointer points to, or null if it does not point to any node.
Your code will only be given the head of the original linked list.

Example 1:
Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]

Example 2:
Input: head = [[1,1],[2,1]]
Output: [[1,1],[2,1]]

Example 3:
Input: head = [[3,null],[3,0],[3,null]]
Output: [[3,null],[3,0],[3,null]]

Constraints:
0 <= n <= 1000
-104 <= Node.val <= 104
Node.random is null or is pointing to some node in the linked list.

     */

    static class Node{

        int val;
        Node next;
        Node random;

        Node(int val){

            this.val = val;
            this.next = null;
            this.random = null;

        }
    }

    // Remember this pattern: Interleave copies → copy random pointers → separate both lists.
    static Node copyRandomList(Node head){

        // if LL is empty
        if( head == null ){
            return head;
        }

        // Step 1 -> clone nodes from the old nodes
        Node temp = head;

        while( temp != null ){

            Node cloneNode = new Node(temp.val);

            cloneNode.next = temp.next;
            temp.next = cloneNode;
            temp = cloneNode.next;
        }

        // Step 2 -> Deep copy the random links of old node into the clone node
        temp = head;

        while( temp != null ){

            Node oldNode = temp;
            Node cloneNode = temp.next;

            if( oldNode.random != null ){
                cloneNode.random = oldNode.random.next;
            }

            temp = cloneNode.next;
        }

        // Step 3 -> detach both old node LL and new node LL
        temp = head;
        Node ansKeNodeKaHead = temp.next;

        while( temp != null ){

            Node oldNode = temp;
            Node cloneNode = temp.next;

            oldNode.next = cloneNode.next;
            if( cloneNode.next != null ){
                cloneNode.next = cloneNode.next.next;
            }

            temp = temp.next;
        }

        return ansKeNodeKaHead;

    }

    static void main() {

        // Create original linked list: 7 -> 13 -> 11 -> 10 -> 1
        Node head = new Node(7);
        head.next = new Node(13);
        head.next.next = new Node(11);
        head.next.next.next = new Node(10);
        head.next.next.next.next = new Node(1);

        // Set random pointers
        head.random = null;
        head.next.random = head;
        head.next.next.random = head.next.next.next.next;
        head.next.next.next.random = head.next.next;
        head.next.next.next.next.random = head;

        // Create deep copy
        Node ansHead = copyRandomList(head);

        // Print copied list and random pointers
        System.out.println("Copied Linked List (Node Value, Random Value):");

        Node temp = ansHead;

        while (temp != null) {

            System.out.print("[" + temp.val + ", ");

            if (temp.random != null) {
                System.out.print(temp.random.val);
            } else {
                System.out.print("null");
            }

            System.out.println("]");

            temp = temp.next;
        }
    }
}
