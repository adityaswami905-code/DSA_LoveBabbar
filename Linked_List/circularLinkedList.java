package DSA_LoveBabbar.Linked_List;

public class circularLinkedList {

    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;

        }
    }

    private Node head;
    private Node tail;
    private int size;

    public circularLinkedList(){
        head = null;
        tail = null;
        size = 0;
    }

   // INSERTION

    // Insertion at head
    public void insertAtHead(int data){

        Node newNode = new Node(data);

        //case 1 -> if LL is empty
        if( head == null){
            head = newNode;
            tail = newNode;

            // circular connection
            tail.next = head;
        }
        //case 2 -> if LL in non-empty
        else{

            newNode.next = head;
            head = newNode;

            // Maintain circular connection
            tail.next = head;
        }

        // size updation
        size++;
    }

    // Insertion at tail
    public void insertAtTail(int data){

        Node newNode = new Node(data);

        // case 1 -> if LL is empty
        if( head == null){
            head = newNode;
            tail = newNode;

            // Circular connection
            tail.next = head;
        }
        // Case 2 -> Non-empty LL
        else{

            tail.next = newNode;
            tail = newNode;

            // Maintain circular connection
            newNode.next = head;
        }

        // size updation
        size++;
    }

    // Insertion at position (1-based indexing)
    public void insertAtPosition(int position, int data){

        if( position < 1 || position > size){
            System.out.println("Invalid position, cannot do anything!");
            return;
        }

        if( position == 1 ){
            insertAtHead(data);
            return;

        }

        if( position == size ){
            insertAtTail(data);
            return;
        }

        Node newNode = new Node(data);
        Node prevNode = head;
        Node nextNode = prevNode.next;

        for( int i = 1; i <= position-2; i++){
            prevNode = prevNode.next;

        }

        prevNode.next = newNode;
        newNode.next = nextNode;

        size++;

    }

    static void main() {

        circularLinkedList myList = new circularLinkedList();

        myList.insertAtHead(100);


    }
}
