package DSA_LoveBabbar.Linked_List;

public class doublyLinkedList {

    static class Node{

        int data;
        Node previous;
        Node next;

        Node(int data){
            this.data = data;
            this.previous = null;
            this.next = null;

        }
    }

    // data members
    private Node head;
    private Node tail;
    private int size;

    // Constructor
    doublyLinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    //  INSERTION

    // insertion at head
    public void insertAtHead(int data){
        Node newNode = new Node(data);

        if(head == null && tail == null){
            head = newNode;
            tail = newNode;
        }
        else{
            newNode.next = head;
            head.previous = newNode;
            // head update
            head = newNode;
        }
        // size updation
        size++;
    }

    // insertion at tail
    public void insertAtTail(int data){

        Node newNode = new Node(data);

        if( head == null && tail == null){
            // i.e. LL is empty, therefore
            head = newNode;
            tail = newNode;
        }
        else{
            newNode.previous = tail;
            tail.next = newNode;
            // tail update
            tail = newNode;

        }
        // size updation
        size++;
    }

    // insertion at position
    public void insertAtPosition(int position, int data){

        Node temp = head;

        if( position < 1 || position > size){
            System.out.print("Invalid position, cannot do anything!");
            return;
        }

        if( position == 1){
            insertAtHead(data);
            return;
        }

        if(position == size){
            insertAtTail(data);
            return;
        }

        // In case of normal LL
        for(int i = 1; i <= position-2; i++){
            temp = temp.next;
        }

        // abhi temp inserting position ke node ke pichle node pe hoga
        Node prevNode = temp;
        Node nextNode = prevNode.next;
        Node currNode = new Node(data);

        // now time to update links
        currNode.previous = prevNode;
        prevNode.next = currNode;
        currNode.next = nextNode;
        nextNode.previous = currNode;

        // size updation
        size++;

    }

    // printing forward
    public void printList(){

        Node temp = head;

        while ( temp != null){
            System.out.print(temp.data+" -> ");
            temp = temp.next;
        }
        System.out.println();
    }

    // backward printing
    public void printBackward(){

        Node temp = tail;

        while( temp != null ){
            System.out.print(" <- "+temp.data);
            temp = temp.previous;
        }
        System.out.println();
    }

    static void main() {

        doublyLinkedList myList = new doublyLinkedList();


    }
}
