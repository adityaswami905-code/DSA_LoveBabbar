package DSA_LoveBabbar.Stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class basics {

    // Stack is nothing but, the linear data structure which follows the LIFO(Last In First Out) order.

    // Stack can be used as -> Stack<Integer> st = new Stack<>();
    // But this is, old approach which contains certain drawbacks/demerits.

    // So modern approach -> Deque<Integer> st = new ArrayDeque<>();


    //  STACK IMPLEMENTATION USING ARRAY
    static class MyStack {

        // Private data members
        private int[] arr;
        private int capacity;
        private int top;

        // Constructor
        public MyStack(int capacity) {
            this.capacity = capacity;
            this.arr = new int[capacity];
            this.top = -1;

        }

        // Member functions
        public void push(int value) {
            if (top == capacity - 1) {
                System.out.println("Cannot insert element, Stack Overflow!");
                return;
            } else {
                top++;
                arr[top] = value;
            }
        }

        public void pop() {

            if (top == -1) {
                System.out.println("Cannot pop, Stack Underflow!");
                return;
            } else {
                arr[top] = -1;
                top--;
            }
        }

        public int peek() {

            if (top == -1) {
                System.out.println("Stack empty, unable to peek!");
                return -1;
            } else {
                return arr[top];
            }
        }

        public int getSize() {

            // Size = current number of elements inside stack
            return top + 1;
        }

        public int getCapacity() {
            return this.capacity;
        }

        public boolean checkEmpty() {

            if (top == -1) {
                return true;
            } else {
                return false;
            }
        }

    }

    // Stack traversal
    // Imp -> Application -> Elements -> Travel -> Order Reverse
    public static void traversal(MyStack stack) {

        while (!stack.checkEmpty()) {
            System.out.print(stack.peek() + " ");
            stack.pop();
        }
        System.out.println();
    }

    //  STACK IMPLEMENTATION USING LINKED LIST
    public static class StackUsingLinkedList {

        // Node structure
        static class MyListNode {
            int val;
            MyListNode next;

            MyListNode(int val) {
                this.val = val;
                this.next = null;
            }
        }

        // Stack data members
        private MyListNode top;
        private int size;

        // Constructor
        public StackUsingLinkedList() {
            top = null;
            size = 0;
        }

        // PUSH: Insert at the top
        public void pushInLL(int val) {

            MyListNode newNode = new MyListNode(val);

            newNode.next = top;
            top = newNode;

            size++;
        }

        // POP: Remove the top element
        public void popInLL() {

            if (top == null) {
                System.out.println("Cannot pop, Stack Underflow!");
                return;
            }

            top = top.next;
            size--;
        }

        // PEEK: Return the top element
        public int peekInLL() {

            if (top == null) {
                System.out.println("Stack is empty, unable to peek!");
                return -1;
            }

            return top.val;
        }

        // Get stack size
        public int getSizeInLL() {
            return size;
        }

        // Check whether stack is empty
        public boolean checkEmptyInLL() {
            return top == null;
        }

        // Display stack from top to bottom
        public void traversalInLL() {

            MyListNode curr = top;

            while (curr != null) {
                System.out.print(curr.val + " -> ");
                curr = curr.next;
            }

            System.out.println("null");
        }
    }


        static void main() {

            Deque<Integer> st = new ArrayDeque<>();

            st.push(10);
            st.push(20);
            st.push(30);

            System.out.println("Stack Size: " + st.size());

            // 30 pop hua hai
            st.pop();
            // Stack ke top par 20 nazar aa raha hoga
            System.out.println("Stack ka top element: " + st.peek());
            System.out.println("Stack Size: " + st.size());


            while (!st.isEmpty()) {

                System.out.println(st.peek());
                st.pop();
            }

//        st.pop();
//        st.pop();

            System.out.println(st.isEmpty());

            //  STACK IMPLEMENTATION USING ARRAY

            MyStack stack = new MyStack(3);

            stack.push(10);
            System.out.println("Stack ka size: " + stack.getSize());

            stack.push(20);
            System.out.println("Stack ka size: " + stack.getSize());

            stack.push(30);
            System.out.println("Stack ka size: " + stack.getSize());

            traversal(stack);

//        stack.pop();
//        stack.pop();
//        stack.pop();
            System.out.println("Stack ka top: " + stack.peek());


//        stack.push(40);
//        System.out.println("Stack ka size: " + stack.getSize());
//
//        stack.pop();
//        System.out.println("Stack ka size: " + stack.getSize());
//        stack.pop();
//        System.out.println("Stack ka size: " + stack.getSize());
//        stack.pop();
//        System.out.println("Stack ka size: " + stack.getSize());

//        stack.pop();

            System.out.println(stack.checkEmpty());
            System.out.println(stack.getCapacity());

            //  STACK IMPLEMENTATION USING LINKED LIST

            StackUsingLinkedList stack2 = new StackUsingLinkedList();

            stack2.pushInLL(100);
            System.out.println("Stack2 Size: " + stack2.getSizeInLL());
            stack2.pushInLL(200);
            stack2.pushInLL(300);
            System.out.println("Stack2 Size: " + stack2.getSizeInLL());

            stack2.popInLL();
//            stack2.popInLL();
//            stack2.popInLL();
            System.out.println("Stack2 top element: " + stack2.peekInLL());

            System.out.println("Is stack2 empty: " + stack2.checkEmptyInLL());

            stack2.traversalInLL();

        }

}
