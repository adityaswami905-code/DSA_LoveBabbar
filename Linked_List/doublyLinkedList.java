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

        if( head == null ){
            System.out.println("LL is empty, cannot print anything!");
            return;
        }

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

    //  SEARCHING

    public boolean searchInLL(int target){

        if(head == null){
            System.out.print("LL is empty, i.e. no node is present!");
            return false;
        }

        Node temp = head;

        while( temp != null){

            if( temp.data == target){
                return true;
            }
            else{
                temp = temp.next;
            }
        }

        return false;
    }

    // Updation in LL

    public void updateInLL(int oldValue, int newValue){

       // -> HOMEWORK
    }

    // DELETION

    // Deletion at head
    public void deleteHead(){

        if( head == null ){
            System.out.println("No node to delete!");
            return;
        }

        if( head == tail){
            // i.e. only single node is present
            head = null;
            tail = null;
            size = 0;
            return;
        }

        // If LL has more than one node
        head = head.next;
        head.previous = null;

        // size updation
        size--;
    }

    // Deletion at tail
    public void deleteTail(){

        if( head == null){
            System.out.println("LL is empty, cannot delete anything!");
            return;
        }

        if( head == tail){
            head = null;
            tail = null;
            size = 0;
             return;
        }

        Node preNode = tail.previous;
        Node currNode = tail;

        // links modification
        preNode.next = null;
        currNode.previous = null;
        // update tail
        tail = preNode;

        // size updation
        size--;
    }

    // deletion at position
    public void deleteAtPosition(int position){

        if ( position < 1 || position > size ){
            System.out.println("Invalid LL, cannot do anything!");
            return;
        }

        if( position == 1 ){
            deleteHead();
            return;
        }

        if( position == size){
            deleteTail();
            return;
        }

        Node currNode = head;

        for( int i = 1; i <= position-1; i++){
            currNode = currNode.next;
        }

        // abhi us node par hain jise delete karna hai
        Node  preNode = currNode.previous;
        Node nextNode = currNode.next;

        // change links
        preNode.next = nextNode;
        nextNode.previous = preNode;
        currNode.next = null;
        currNode.previous = null;

        // size updation
        size--;
    }

    static void main() {

        doublyLinkedList myList = new doublyLinkedList();

        myList.insertAtHead(10);
        myList.printList();

        myList.insertAtHead(20);
        myList.printList();

        myList.insertAtHead(30);
        myList.printList();

        myList.insertAtTail(11);
        myList.printList();

        myList.insertAtTail(12);
        myList.printList();

        myList.insertAtTail(13);
        myList.printList();

        myList.insertAtPosition(4,3);
        myList.printList();

        myList.printBackward();

        System.out.println("Element present: "+ myList.searchInLL(18));

        myList.deleteHead();
        myList.printList();

        myList.deleteTail();
        myList.printList();

        myList.deleteAtPosition(3);
        myList.printList();

    }
}
