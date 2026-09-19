package DSA_LoveBabbar.Linked_List;

public class singlyLinkedList {

    static class Node{
        int data;
        Node next;
        //constructor
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    //constructor
    public singlyLinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // INSERTION

    // Insert at beginning
    public void insertAtHead(int data){

        Node newNode = new Node(data);
        // if LL is empty -> head and tail ko new node par point kardo
        if(head == null && tail == null){
            head = newNode;
            tail = newNode;
        }else{
            newNode.next = head;
            head = newNode;
        }
        // increase the size by 1
        size++;
    }

    // Insert at end
    public void insertAtTail(int data){

        Node newNode = new Node(data);
        if(head == null && tail == null){
            head = newNode;
            tail = newNode;
        }
        else{
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    // Position is 1-based indexing
    public void insertAtPosition(int position, int data){
        if(position < 1 || position > size+1){
            // insertion not possible
            System.out.println("Insertion is not possible at this position");
            return;
        }
        if(position == 1){
            insertAtHead(data);
            return;
        }
        if(position == size + 1){
            insertAtTail(data);
            return;
        }
        // middle me kahin pr insert karna chahte ho
        Node prevNode = head;
        // move previous node by (position-2) steps, to reach to the previous node of the destination location
        for(int i = 1; i <= position - 2; i++){
            prevNode = prevNode.next;
        }

        Node newNode = new Node(data);
        // update links
        newNode.next = prevNode.next;
        prevNode.next = newNode;
        // increment size
        size++;
    }

    // TRAVERSAL

    public void printList(){
        Node temp = head;

        while (temp != null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.println();
    }

    // UTILITY FUNCTIONS

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public int getHead(){
        if(head == null){
            return -1;
        }
        else{
            return head.data;
        }
    }

    public int getTail(){
        if(tail == null){
            return -1;
        }
        else{
            return tail.data;
        }
    }

    public void clear(){
        // -> HOMEWORK
    }

    static void main() {

        singlyLinkedList myList = new singlyLinkedList();
        System.out.println(myList.isEmpty());
        System.out.println("Size of LL: "+myList.getSize());

        myList.insertAtHead(10);
        myList.printList();

        myList.insertAtHead(20);
        myList.printList();

        myList.insertAtHead(30);
        myList.printList();

        myList.insertAtTail(100);
        myList.printList();

        myList.insertAtTail(110);
        myList.printList();

        myList.insertAtTail(120);
        myList.printList();

        myList.insertAtPosition(1,18);
        myList.printList();

        myList.insertAtPosition(8,7);
        myList.printList();

        myList.insertAtPosition(5,17);
        myList.printList();

        System.out.println("Head data: "+myList.getHead());
        System.out.println("Tail data: "+myList.getTail());

    }
}
