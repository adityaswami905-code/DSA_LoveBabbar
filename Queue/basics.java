package DSA_LoveBabbar.Queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class basics {

//    QUEUE -> It is a linear Data Structure which follows FIFO(i.e. First In First out) ordering
//    Removal from front and insertion at rear

    static void main() {

        // Creation of Queue
        Deque<Integer> queue = new ArrayDeque<>();
        // Insertion
        queue.offer(10);
        // size check
        System.out.println("Size of queue: " + queue.size());
        queue.offer(20);
        // front -> 10
        // rear -> 20
        System.out.println("Front me element konsa hai: " + queue.peek());
        queue.offer(30);
        //front -> 10
        //rear -> 30
        // removal using poll method
        System.out.println("Removed element: " + queue.poll());
        System.out.println("Size: " + queue.size());

        if( queue.isEmpty() ){
            System.out.println("Q is empty");
        }
        else{
            System.out.println("Q is not empty");
        }
    }
}
