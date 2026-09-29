package DSA_LoveBabbar.Linked_List;

public class kthNodeFromEndOfLL {

    //  PRINT KTH NODE FROM END OF LINKED LIST

    /*

    Given the head of a linked list and an integer k, return the kth node from the end of the linked list. If k is greater than the number of nodes in the list, return -1.

Examples :

Input:
Head -> 1 -> 2 ->3 -> 4 -> 5 -> 6 -> 7 ->8 -> 9 -> Null ,k = 2
Output: 8
Explanation:
The 2nd node from end is 8.

Input: Head -> 10 -> 20 -> 30 -> 40 -> 50 -> 60 -> Null , k = 3
Output: 40
Explanation:
The 3rd node from the end is 40.

Input: Head -> 10 -> 5 -> 100 -> 5 -> Null,  k = 5
Output: -1
Explanation: The given linked list is 10 -> 5 -> 100 -> 5. Since 'k' is more than the number of nodes, the output is -1.
Constraints:
1 ≤ number of nodes ≤ 106
1 ≤ node->data , x ≤ 106
1 ≤ k ≤ 106



     */

    static class Node{

        int data;
        Node next;

        Node(int data){

            this.data = data;
            this.next = null;
        }
    }

    static int getKthFromLast(Node head, int k){

        // This question can be solved by using sliding window as well as two-pointer technique

        Node prev = head;
        Node curr = head;

        for( int i = 1; i <= k; i++ ){

            // If the k is greater than the size of LL
            // therefore
            if( curr == null ){
                return -1;
            }

            // and if k is valid
            // then
            curr = curr.next;
        }

        //now we got our sliding window
        //i.e. our sliding window is ready and the gap between thr prev and curr is k

        while( curr != null ){

            prev = prev.next;
            curr = curr.next;
        }

        // and finally return the kth node from end of LL
        return prev.data;

    }

    static void main() {

        kthNodeFromEndOfLL obj = new kthNodeFromEndOfLL();

        Node head = new Node(10);
        head.next = new Node(5);
        head.next.next = new Node(100);
        head.next.next.next = new Node(5);
//        head.next.next.next.next = new Node(50);
//        head.next.next.next.next.next = new Node(60);

        int k = 5;
        int ans = obj.getKthFromLast(head,k);
        System.out.println(
                "Kth node from end of LL is: "+ ans
        );
    }
}
