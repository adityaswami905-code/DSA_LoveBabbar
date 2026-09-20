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

    // DELETION

    // Delete first node
    public void deleteHead(){
        if(head == null){
            System.out.println("LL is empty, cannot delete anything!");
            return;
        }
        // main logic
        head = head.next;
        size--;
        // BE CAUTIOUS -> Check whether after deletion LL has become empty or not
        if(head == null){
            tail = null;
        }
    }

    // Delete last node
    public void deleteTail(){

        if(head == null){
            System.out.println("LL is empty, cannot delete anything!");
            return;
        }
        // check for single mode
        if(head == tail){
            head = null;
            tail = null;
            size = 0;
            return;
        }

        // for normal , >1 length wali LL
        Node temp = head;
        for(int i = 1; i <= size-2; i++){
            temp = temp.next;
        }
        // now temp is pointing to the 2nd last node of LL
        temp.next = null;
        tail = temp;

        // size updation
        size--;

    }

    // Delete 1-based position
    public void deleteAtPosition(int position){

        if( position < 1 || position > size){
            System.out.println("Invalid position, cannot do anything!");
            return;
        }

        if( position == 1){
            deleteHead();
            return;
        }

        if( position == size){
            deleteTail();
            return;
        }

        Node prev = head;

        for(int i = 1; i <= position-2; i++){
            prev = prev.next;
        }
        // iska matlab temp abhi current ke ek position piche hai
        Node curr = prev.next;
        Node forward = curr.next;

        // main logic
        prev.next = forward;
        curr.next = null;

        // size update
        size--;
    }

    // Delete first occurrence value
    public boolean deleteValue(int target){

        if( head == null){
            System.out.println(" Deletion not possible, no node is present to delete!");
            return false;
        }

        if( head.data == target){
            deleteHead();
            return true;
        }

        Node prev = head;
        Node curr = prev.next;

        while ( curr != null){

            if(curr.data == target){
                Node forward = curr.next;
                prev.next = forward;
                curr.next = null;
                size--;
                return true;
            }
            else{
                prev = prev.next;
                curr = curr.next;
            }
        }
        return false;
    }

    //  SEARCHING

    // Return true if value exists
    public boolean search(int target){
        Node temp = head;
        while( temp != null){
            if(temp.data == target){
                return true;
            }
            else{
                temp = temp.next;
            }
        }
        // agar main yaha pohoch gaya
        // iska matlab hain ki LL poori traverse ho chuki hai
        // and kahin par bhi target nahi mila
        return false;
    }

    // Returns 1-based position
    public int findPosition(int target){
        Node temp = head;
        int position = 1;

        while( temp != null){

            if(temp.data == target){
                return position;
            }
            else{
                temp = temp.next;
                position++;
            }
        }

        // Aur agar poora LL traverse hone ke baad bhi agar target nahi mila toh return -1 karna
        return -1;
    }

    //  UPDATION

    // Update using position
    public void updateAtPosition(int position, int newData){

        if( position < 1 || position > size+1 ){
            System.out.println("Invalid position!");
            return;
        }

        Node temp = head;
        // take temp to the position given in input
        for(int i = 1; i <= position-1; i++){
            temp = temp.next;
        }

        // ab mera temp, exact position wali node par hai
        // replace old data with new
        temp.data = newData;
    }

    // Update first occurrence of value
    public boolean updateValue(int oldValue, int newValue){
        Node temp = head;

        while( temp != null){

            if(temp.data == oldValue){
                temp.data = newValue;
                return true;
            }
            //move to next node
            temp = temp.next;
        }
        // agar main yaha pahuch gaya
        // iska matlab LL me mujhe kahin bhi old value mili he nhi
        return false;
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
        System.out.println("Target found : "+ myList.search(3));
        System.out.println("Position of target is: "+myList.findPosition(17));

        myList.updateAtPosition(300,3);
        myList.printList();

        System.out.println("Value updated: "+myList.updateValue(120,21));
        myList.printList();

        myList.deleteHead();
        myList.printList();

        myList.deleteTail();
        myList.printList();

        myList.deleteAtPosition(6);
        myList.printList();

        myList.deleteAtPosition(1);
        myList.printList();

        System.out.println(myList.getSize());

        myList.deleteAtPosition(5);
        myList.printList();

        myList.deleteValue(10);
        myList.printList();

    }
}
