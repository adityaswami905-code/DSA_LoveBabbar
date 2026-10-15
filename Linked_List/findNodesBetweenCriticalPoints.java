package DSA_LoveBabbar.Linked_List;

import java.util.ArrayList;
import java.util.List;

public class findNodesBetweenCriticalPoints {

    //  FIND THE MINIMUM AND MAXIMUM NUMBER OF NODES BETWEEN CRITICAL POINTS

    /*

    A critical point in a linked list is defined as either a local maxima or a local minima.

A node is a local maxima if the current node has a value strictly greater than the previous node and the next node.

A node is a local minima if the current node has a value strictly smaller than the previous node and the next node.

Note that a node can only be a local maxima/minima if there exists both a previous node and a next node.

Given a linked list head, return an array of length 2 containing [minDistance, maxDistance] where minDistance is the minimum distance between any two distinct critical points and maxDistance is the maximum distance between any two distinct critical points. If there are fewer than two critical points, return [-1, -1].



Example 1:
Input: head = [3,1]
Output: [-1,-1]
Explanation: There are no critical points in [3,1].

Example 2:
Input: head = [5,3,1,2,5,1,2]
Output: [1,3]
Explanation: There are three critical points:
- [5,3,1,2,5,1,2]: The third node is a local minima because 1 is less than 3 and 2.
- [5,3,1,2,5,1,2]: The fifth node is a local maxima because 5 is greater than 2 and 1.
- [5,3,1,2,5,1,2]: The sixth node is a local minima because 1 is less than 5 and 2.
The minimum distance is between the fifth and the sixth node. minDistance = 6 - 5 = 1.
The maximum distance is between the third and the sixth node. maxDistance = 6 - 3 = 3.

Example 3:
Input: head = [1,3,2,2,3,2,2,2,7]
Output: [3,3]
Explanation: There are two critical points:
- [1,3,2,2,3,2,2,2,7]: The second node is a local maxima because 3 is greater than 1 and 2.
- [1,3,2,2,3,2,2,2,7]: The fifth node is a local maxima because 3 is greater than 2 and 2.
Both the minimum and maximum distances are between the second and the fifth node.
Thus, minDistance and maxDistance is 5 - 2 = 3.
Note that the last node is not considered a local maxima because it does not have a next node.

Constraints:
The number of nodes in the list is in the range [2, 105].
1 <= Node.val <= 105

     */

    static class ListNode{

        int val;
        ListNode next;

        ListNode(int val){

            this.val = val;
            this.next = null;

        }
    }

    static int[] nodesBetweenCriticalPoints(ListNode head){

        // if LL is empty
        if( head == null ){
            return new int[]{-1,-1};
        }

        ListNode prev = head;
        ListNode curr = head.next;
        int i = 1;

        List<Integer> criticalPoints = new ArrayList<>();

        while( curr != null && curr.next != null ){

            // find the local maxima
            if( curr.val > prev.val && curr.val > curr.next.val ){
                criticalPoints.add(i);
            }

            // Find the local minima
            if( curr.val < prev.val && curr.val < curr.next.val ){
                criticalPoints.add(i);
            }

            // also move the variables forward
            prev = prev.next;
            curr = curr.next;
            i = i + 1;
        }

        // Now list of critical points is ready
        // therefore

        // If size of critical point is less than 2
        if( criticalPoints.size() < 2 ){
            return new int[]{-1,-1};
        }

        int minDist = Integer.MAX_VALUE;

        for( int j = 1; j < criticalPoints.size(); j++){

            minDist = Math.min( minDist, criticalPoints.get(j) - criticalPoints.get(j-1));
        }

//        int maxDist = criticalPoints.get(criticalPoints.size()-1) - criticalPoints.get(0);
        int maxDist = criticalPoints.getLast() - criticalPoints.getFirst();

        // return minDist and maxDist respectively
        return new int[]{minDist, maxDist};

    }

    static void main() {

        findNodesBetweenCriticalPoints obj = new findNodesBetweenCriticalPoints();

        ListNode head = new ListNode(5);
        head.next = new ListNode(3);
//        head.next.next = new ListNode(1);
//        head.next.next.next = new ListNode(2);
//        head.next.next.next.next = new ListNode(5);
//        head.next.next.next.next.next = new ListNode(1);
//        head.next.next.next.next.next.next = new ListNode(2);

        int[] ans = obj.nodesBetweenCriticalPoints(head);

        System.out.print("Local Minima and Local Maxima are: ");
        for( int i = 0 ; i < ans.length; i++ ){
            System.out.print(ans[i]+" ");
        }

    }
}
