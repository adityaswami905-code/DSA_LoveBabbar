package DSA_LoveBabbar.Linked_List;

public class circularDoublyLinkedList {

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

    private Node head;
    private Node tail;
    private int size;

    public circularDoublyLinkedList(){
        head = null;
        tail = null;
        size = 0;
    }

    // INSERTION

    // Insertion at beginning
    public void insertAtHead(int data){

        Node newNode = new Node(data);

        // Case 1: If LL is empty
        if( head == null){

            head = newNode;
            tail = newNode;

            // Circular connection
            tail.next = head;
            head.previous = tail;
        }
        // Case 2: Non-empty LL
        else{
            newNode.next = head;
            newNode.previous = tail;

            head.previous = newNode;
            tail.next = newNode;

            head = newNode;
        }
        size++;
    }

    // Insertion at end
    public void insertAtTail(int data){

        Node newNode = new Node(data);

        if( head == null){

            head = newNode;
            tail = newNode;

            head.previous = tail;
            tail.next = head;
        }
        else{

            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;

            tail.next = head;
            head.previous = tail;

        }

        size++;
    }

    // Insertion at position
    public void insertAtPosition(int position, int data){

        Node currNode = new Node(data);

        if( position < 1 || position > size+1){
            System.out.println("Invalid position, cannot do anything!");
            return;
        }

        if( position == 1 ){
            insertAtHead(data);
            return;
        }

        if( position == size+1){
            insertAtTail(data);
            return;
        }

        Node prevNode = head;
        for(int i = 1; i <= position-2; i++){
            prevNode = prevNode.next;
        }

        Node nextNode = prevNode.next;

        prevNode.next = currNode;
        currNode.previous = prevNode;
        nextNode.previous = currNode;
        currNode.next = nextNode;

        size++;
    }

    // Head -> Tail
    public void printForward(){

        if( head == null ){
            System.out.println("LL is empty!");
            return;
        }

        Node temp = head;
        do {
            System.out.print(temp.data+" <-> ");
            temp = temp.next;

        }while ( temp != head);
        System.out.println("(Back to Head)");
    }

    // Tail to Head
    public void printBackward(){

        if( tail == null ){
            System.out.println("LL is empty!");
            return;
        }

        Node current = tail;
        do {
            System.out.print(current.data+" <-> ");
            current = current.previous;

        }while (current != tail);
        System.out.println("(Back to Tail)");
    }

    // SEARCHING

    public boolean search(int target){

        if (head == null){
            return false;
        }

        Node current = head;
        do{
            if (current.data == target){
                return true;
            }
            current = current.next;
        }while (current != head);

        return false;
    }

    // UTILITY FUNCTIONS

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public int getHead(){

        if (head == null) {
            throw new IllegalStateException(
                    "Circular Doubly Linked List is empty!"
            );
        }
        return head.data;
    }

    public int getTail(){
        if(tail == null){
            throw new IllegalStateException(
                    "Circular Doubly Linked List is empty!"
            );
        }

        return tail.data;
    }

    // DELETION

    // Delete beginning node
    public void deleteHead(){

        // If LL is empty
        if(head == null){
            System.out.println("Circular Doubly Linked List is empty!");
            return;
        }

        // If LL contains single node
        if( head == tail ){
            head = null;
            tail = null;
            size = 0;
            return;
        }

        // If Ll is Non-empty
        Node temp = head;

        // Move head forward
        head = head.next;

        // Maintain circular connection
        head.previous = tail;
        tail.next = head;

        // Disconnect deleted node
        temp.next = null;
        temp.previous = null;

        size--;
    }

    // Delete last node
    public void deleteTail(){

        if(tail == null){
            System.out.println("Circular Doubly Linked List is empty!");
            return;
        }

        if( head == tail ){
            head = null;
            tail = null;
            size = 0;
            return;
        }

        Node temp = tail;

        // Move tail backward
        tail = tail.previous;

        //Maintain circular connections
        tail.next = head;
        head.previous = tail;

        // Disconnect deleted node
        temp.next = null;

        // Size updation
        size--;
    }

    // Deletion at position
    public void deleteAtPosition(int position){

        if( position < 1 || position > size+1 ){
            System.out.println("Invalid position!");
            return;
        }

        if( position == 1){
            deleteHead();
            return;
        }

        if( position == size+1){
            deleteTail();
            return;
        }

        Node prevNode = head;

        for( int i = 1; i <= position-2; i++ ){
            prevNode = prevNode.next;

        }

        Node currNode = prevNode.next;
        Node nextNode = currNode.next;

        // isolate
        currNode.previous = null;
        currNode.next = null;

        // links change
        prevNode.next = nextNode;
        nextNode.previous = prevNode;

        // size updation
        size--;


    }



    static void main() {

        circularDoublyLinkedList myList = new circularDoublyLinkedList();

        myList.insertAtHead(11);
        // 11
        myList.insertAtHead(22);
        // 22 <-> 11
        myList.insertAtTail(12);
        // 22 <-> 11 <-> 12
        myList.insertAtTail(23);
        // 22 <-> 11 <-> 12 <-> 23
        myList.insertAtPosition(3,7);
        // 22 <-> 11 <-> 7 <-> 12 <-> 23

        myList.printForward();
        myList.printBackward();

        System.out.println(
                "Element found: " + myList.search(7)
        );

        System.out.println(
                "Size of Circular Doubly Linked List: " + myList.getSize()
        );

        System.out.println(
                "Circular Doubly Linked List is empty: " + myList.isEmpty()
        );

        System.out.println(
                "Head: " + myList.getHead()
        );

        System.out.println(
                "Tail: " + myList.getTail()
        );

        myList.deleteHead();
        // 11 <-> 7 <-> 12 <-> 23
        myList.printForward();

        myList.deleteAtPosition(3);
        // 11 <-> 7 <-> 23
        myList.printForward();

        myList.deleteTail();
        // 11 <-> 7
        myList.printForward();

    }
}
