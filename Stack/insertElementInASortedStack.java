package DSA_LoveBabbar.Stack;

import java.util.Stack;

public class insertElementInASortedStack {

    //  SORTED INSERT

    /*

    To insert an element into a sorted stack while maintaining its sorted order,
    we can use either a recursive approach (which avoids using extra loop structures)
    or an iterative approach using an auxiliary stack.

Assuming the stack is sorted in ascending order (where the smallest element is at the top):

Recursive Approach (No Loops)

This method pops elements off the stack recursively until it finds the correct insertion spot,
pushes the new element, and then restores the popped elements as the recursion unwinds.
• Time Complexity: O(N)
• Space Complexity: O(N) due to the recursion call stack

     */

    static void sortedInsert(Stack<Integer> st, int x){

        // Base case
        if( st.empty() ){
            // i.e. while comparing x with the top element, it found that all elements present
            // in stack are less than x, then it will be add at last of the stack
            // i.e. first pushed element after recursion if stack becomes empty will be x
            st.push(x);
            return;
        }

        // 1 case mein solve karunga
        int topElement = st.peek();
        if( topElement < x ){

            st.pop();
            // baaki recursion sambhal lega
            sortedInsert(st,x);

            // recursion se waapas jaate samay
            st.push(topElement);
        }
        else{
            // i.e. topElement >= x
            st.push(x);
            return;
        }
    }

    static void main() {

        Stack<Integer> st = new Stack<>();

        st.push(5);
        st.push(3);
        st.push(2);
        st.push(1);

        sortedInsert(st,4);

        while( !st.isEmpty() ){
            System.out.print(
                    st.peek() + " "
            );
            st.pop();
        }
        System.out.println();
    }
}
