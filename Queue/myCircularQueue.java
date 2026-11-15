package DSA_LoveBabbar.Queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class myCircularQueue {

    // Data members
    int[] arr;
    int front;
    int rear;
    int size;
    int capacity;

    // Constructor
    public myCircularQueue(int n){
        arr = new int[n];
        capacity = n;
        size = 0;
        front = 0;
        rear = -1;
    }

    // Insert element at rear
    public boolean enqueue(int x){

        if( isFull() ){
            return false;
        }
        else{
            rear = ( rear + 1 ) % capacity;
            // i.e. we are maintaining circular nature
            arr[rear] = x;
            size++;
            return true;
        }
    }

    // Remove element from front
    public int dequeue(){

        if( isEmpty() ){
            return -1;
        }
        else{
            int removedElement = arr[front];
            arr[front] = -1;
            front = ( front + 1 ) % capacity;
//            i.e. to maintain circular nature
            size--;
            return removedElement;
        }
    }

    // Get front element
    public int getFront(){

        if( isEmpty() ){
            return -1;
        }
        else{
            return arr[front];
        }
    }

    // Get rear element
    public int getRear(){

        if( isEmpty() ){
            return -1;
        }
        else{
            return arr[rear];
        }
    }

    // Return size of queue
    public int getSize(){

        return this.size;
    }

    // Check if queue is empty
    public boolean isEmpty(){

        if( size == 0 ){
            return true;
        }
        else{
            return false;
        }
    }

    // Check if queue is full
    public boolean isFull(){

        // Here our basic condition will work because we are using circular queue
        // therefore
        if( size == capacity ){
            return true;
        }
        else{
            return false;
        }
    }

    static void main() {

        myCircularQueue q = new myCircularQueue(3);

        System.out.println(q.enqueue(10));
        System.out.println(q.enqueue(20));
        System.out.println(q.enqueue(30));

        System.out.println("Front: " + q.getFront());
        System.out.println("Rear: " + q.getRear());
        System.out.println("Size: " + q.getSize());

        System.out.println("Removed: " + q.dequeue());

        // Demonstrating circular behaviour
        // i.e. front -> 20
        // and rear -> 40
        System.out.println(q.enqueue(40));

        System.out.println("Front: " + q.getFront());
        System.out.println("Rear: " + q.getRear());
        System.out.println("Size: " + q.getSize());

        System.out.println("Is Empty: " + q.isEmpty());
        System.out.println("Is Full: " + q.isFull());

        // Also be declared as ->
        //Queue<Integer> q1 = new ArrayDeque<>();
    }
}
