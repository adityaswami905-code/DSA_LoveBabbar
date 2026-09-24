package DSA_LoveBabbar.Linked_List;

public class circularSinglyLinkedList {

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

    public circularSinglyLinkedList(){
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

        if( position < 1 || position > size+1){
            System.out.println("Invalid position, cannot do anything!");
            return;
        }

        if( position == 1 ){
            insertAtHead(data);
            return;

        }

        if( position == size+1 ){
            insertAtTail(data);
            return;
        }

        Node newNode = new Node(data);
        Node prevNode = head;


        for( int i = 1; i <= position-2; i++){
            prevNode = prevNode.next;

        }

        Node currNode = newNode;
        Node nextNode = prevNode.next;

        prevNode.next = currNode;
        currNode.next = nextNode;


        size++;

    }

    // SEARCHING

    public boolean search(int target){

        if( head == null ){
            return false;
        }

        Node temp = head;
        do {

            if( temp.data == target){
                return true;
            }
            else{
                temp = temp.next;
            }
        }while ( temp != head );

        return false;
    }

    // DELETION

    // Delete at head
    public void deleteHead(){

        // Case 1 -> If LL is empty
        if( head == null ){
            System.out.println("LL is empty, cannot do anything!");
            return;
        }

        // Case 2 -> If LL contains a single node
        if( head == tail ){
            head.next = null;
            head = null;
            tail = null;
            size = 0;
            return;
        }

        // Case 3 -> If LL contains more than one node
        Node temp = head;
        head = head.next;
        temp.next = null;

        // Maintain circular connection
        tail.next = head;

        // Size updation
        size--;
    }

    // Deletion at tail

    public void deleteAtTail(){

        if ( head == null ){
            System.out.println("LL is empty, cannot do anything!");
            return;
        }

        if( head == tail ){
            head.next = null;
            head = null;
            tail = null;
            size = 0;
            return;
        }

        Node prevNode = head;

        for(int i = 1; i <= size - 2; i++){

            prevNode = prevNode.next;
        }

        prevNode.next = head;
        tail.next = null;

        tail = prevNode;
        size--;

    }

    // Deletion at position
    // i.e. 1-based indexing
    public void deleteAtPosition(int position){

        if( position < 1 || position > size+1){
            System.out.println("Invalid position, cannot do anything!");
            return;
        }

        if( position == 1 ){
            deleteHead();
            return;
        }

        if( position == size+1 ){
            deleteAtTail();
            return;
        }

        Node prevNode = head;

        for( int i = 1; i <= position - 2; i++){
            prevNode = prevNode.next;

        }

        Node currNode = prevNode.next;
        Node nextNode = currNode.next;

        prevNode.next = nextNode;
        currNode.next = null;

        size--;


    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public int getHead(){

        if( head == null ){
            throw new IllegalStateException(
                    "Circular Linked List is empty"
            );
        }

        return head.data;
    }

    public int getTail(){

        if ( tail == null ){
            throw new IllegalStateException(
                    "Circular Linked List is empty!"
            );
        }

        return tail.data;
    }


    public void printList(){

        if( head == null){
            System.out.println("LL is empty, nothing to print!");
            return;
        }

        Node temp = head;

        do{
            System.out.print(temp.data +" -> ");
            temp = temp.next;
        }while (temp != head);
        System.out.println("(Back to head)");
    }

    static void main() {

        circularSinglyLinkedList myList = new circularSinglyLinkedList();

        myList.insertAtHead(100);
        myList.insertAtTail(10);
        myList.printList();

        myList.insertAtPosition(2,1);
        myList.printList();

        System.out.println("Element found: "+myList.search(3));

        myList.deleteHead();
        myList.printList();

        myList.deleteAtTail();
        myList.printList();

        myList.insertAtTail(50);
        myList.insertAtHead(67);
        myList.insertAtPosition(2,45);

        myList.printList();
        myList.deleteAtPosition(3);
        myList.printList();

        // UTILITY FUNCTIONS

        System.out.println(
                "Size of Circular Singly Linked List: " + myList.getSize()
        );

        System.out.println(
                "Circular Singly Linked List is empty: " + myList.isEmpty()
        );

        System.out.println(
                "Head of CSLL is: " + myList.getHead()
        );

        System.out.println(
                "Tail of CSLL is: " + myList.getTail()
        );



    }
}
