package DSA_LoveBabbar.Queue;

public class myQueue {

    // Data members
    int[] arr;
    int front;
    int rear;
    int size;
    int capacity;

    // Constructor
    public myQueue(int n){
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
            rear++;
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
            front++;
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

    // return size of queue
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

        // In your mind you have thought that, we can check simply
        // i.e. if size == capacity then it is full
        // it is true but for some limited conditions only
        // i.e. think if we declared queue of capacity = 5 i.e. it stores five element
        // and first element in a queue is front and last is rear, now if we popped some elements from queue
        // that elements will be removed from front( i.e. queue) front would be removed and got updated but capacity is still full
        // therefore we used below logic
        if( rear == capacity-1 ){
            return true;
        }
        else{
            return false;
        }
    }

    static void main() {

        myQueue q = new myQueue(5);

        System.out.println(q.enqueue(10));
        System.out.println(q.enqueue(20));
        System.out.println(q.enqueue(30));

        System.out.println("Front: " + q.getFront());
        System.out.println("Rear: " + q.getRear());
        System.out.println("Size: " + q.getSize());

        System.out.println("Removed: " + q.dequeue());

        System.out.println("Front: " + q.getFront());
        System.out.println("Is Empty: " + q.isEmpty());
        System.out.println("Is Full: " + q.isFull());
    }
}
