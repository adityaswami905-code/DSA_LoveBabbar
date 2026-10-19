package DSA_LoveBabbar.Stack;

import java.util.Stack;

public class reverseAStack {

    //  REVERSE A STACK

    /*

    You are given a stack st[]. You have to reverse the stack.

Note: The input array represents the stack from bottom to top (last element is the top). The output is displayed by printing elements from top to bottom after reversal.

Examples:

Input: st[] = [1, 2, 3, 4]
Output: [1, 2, 3, 4]
Explanation: After reversing, the elements of stack are in opposite order.

Input: st[] = [3, 2, 1]
Output: [3, 2, 1]
Explanation: After reversing, the elements of stack are in opposite order.

Constraints:
1 ≤ st.size() ≤ 100
0 ≤ stack element ≤ 100



     */

    static void insertAtBottom(Stack<Integer> st, int topValue){

        // Base case
        if( st.empty() ){
            st.push(topValue);
            return;
        }

        // 1 case mein solve karunga baaki recusion sambhal lega
        int value = st.peek();
        st.pop();

        // Baaki recursion
        insertAtBottom(st,topValue);

        // Recusion se waapas jaate samay
        st.push(value);

    }

    // LOGIC -> Initially pop all the elements from the stack one by one and then
//             -> Apply the logic of insertion at bottom of stack
    // Due to which it takes O(n^2) Time Complexity and O(n) Space Complexity
    static void reverseAStack(Stack<Integer> st){

        // Base case
        if( st.empty() ){
            return;
        }

        // 1 case mein solve karunga baaki recursion sambhal lega
        int topValue = st.peek();
        st.pop();

        // Baaki recursion
        reverseAStack(st);

        // Aur recursion se waapas jaate samay
        insertAtBottom(st,topValue);
    }

    static void main() {

        Stack<Integer> st = new Stack<>();

        st.push(11);
        st.push(22);
        st.push(33);
        st.push(44);
        st.push(55);

        reverseAStack(st);
        // Remember that -> While printing stack, it always print in reverse order.
        while (!st.isEmpty()){
            System.out.print(st.peek() + " ");
            st.pop();
        }
        System.out.println();
    }
}
