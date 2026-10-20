package DSA_LoveBabbar.Stack;

import java.util.Stack;

public class checkStackIsSortedOrNot {

    //  CHECK SORTED STACK

    /*

    To check if a stack is sorted,
    We need to look at its elements from top to bottom (or bottom to top).
    However, because we can only access the top element of a stack directly,
    we must pop elements one by one to inspect them.

     */

    // Check Sort in ascending order
    // i.e. for example 1 <= 2 <= 3 <= 4 <= 5 ( here 1 is top element );
    static boolean checkStack(Stack<Integer> st){

        // Base case
        // While comparing the popped element from the top, with current top element
        // We will reach to the last top element, where we do not need to compare
        // Because the size of stack will be less than or equal to 1 i.e. stack size() <= 1
        if( st.size() <= 1 ){
            return true;
        }

        // 1 case mein solve karunga
        int prevElement = st.peek();
        st.pop();
        int currElement = st.peek();
        boolean ekCaseKaAns = prevElement <= currElement;

        // baaki recursion sambhal lega
        boolean recursionKaAns = checkStack(st);

        // recursion se waapas jaate samay, question ne kaha hai stack jaise pahile tha
        // waise he rakhna hai
        // therefore
        st.push(prevElement);

        // Overall ans
        boolean finalAns = ekCaseKaAns && recursionKaAns;

        return finalAns;
    }

    static void main() {

        Stack<Integer> st = new Stack<>();

//        st.push(10);
//        st.push(20);
//        st.push(30);
//        st.push(40);
//        st.push(50);

        st.push(5);
        st.push(4);
        st.push(3);
        st.push(2);
        st.push(1);

        boolean ans = checkStack(st);

        System.out.println(
                "Given stack is in Sorted Order: " + ans
        );
    }
}
