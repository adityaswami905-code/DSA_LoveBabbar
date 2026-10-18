package DSA_LoveBabbar.Stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class stackWarmUpProblems {

    //  PRINT MIDDLE ELEMENT OF STACK
    static void printMiddleElementFromStack(Deque<Integer> st, int count, int size){

        // Base case
        if( count == size/2 ){

            int middleElement = st.peek();
            System.out.println("Middle Element of Stack: " + middleElement);
            return;
        }

        // 1 case mein solve karunga, baaki recursion sambhal lega
        st.pop();
        count++;
        // baaki recursion
        printMiddleElementFromStack(st,count,size);

    }

    //  INSERT AT BOTTOM OF STACK
    /*

    Given a stack st containing n integers and an integer x, insert x at the bottom of the stack.


Note: While displaying the stack, the bottommost element is printed first.

Examples :

Input: st = [4, 3, 2, 1, 8], x = 2
Output: [2, 4, 3, 2, 1, 8]
Explanation: After insertion of 2, the final stack will be [2,4,3,2,1,8].

Input: st = [5, 3, 1], x = 4
Output: [4, 5, 3, 1]
Explanation: After insertion of 4, the final stack will be [4,5,3,1].

Constraints:
1 ≤ n ≤ 105
0 ≤ x, elements of stack ≤ 109

Expected Complexities
Time Complexity: O(n)
Auxiliary Space: O(n)

     */

    static void helper(Stack<Integer> st, int value){

        // base case
        if( st.empty()){
            st.push(value);
            return;
        }

        // 1 case mein solve karunga
        int topValue = st.peek();
        st.pop();

        // baaki recursion
        helper(st,value);

        // jab recursion se wapas aa rahe hain
        st.push(topValue);
    }

    static Stack<Integer> insertAtBottom(Stack<Integer> st, int x){

        int value = x;
        helper(st, value);
        return st;
    }

    static void main() {

        Deque<Integer> st = new ArrayDeque<>();

        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);
        st.push(50);
        st.push(60);

        int count = 0;
        int size = st.size();

        //  PRINT MIDDLE ELEMENT OF STACK
        printMiddleElementFromStack(st,count,size);

//        INSERT AT BOTTOM OF STACK
        Stack<Integer> st1 = new Stack<>();
        st1.push(10);
        st1.push(20);
        st1.push(30);
        st1.push(40);

        int x = 55;
        Stack<Integer> ans = insertAtBottom(st1,x);
//        ans.pop();
        while (!ans.isEmpty()){
            System.out.print(ans.peek()+" ");
            ans.pop();
        }
        System.out.println();


    }
}
