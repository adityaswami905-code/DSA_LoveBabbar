package DSA_LoveBabbar.Stack;

public class nStacksInAnArray {

    //  N STACKS IN AN ARRAY

    /*

    Given two integers n and k. Your task is to implement a class kStacks that uses a single array of size n to simulate k independent stacks.
The class should support the following operations:

push(x, i) – Push element x into the i-th stack.
pop(i) – Pop the top element from the i-th stack and return it. Return -1 if it is empty.
There will be a sequence of queries, queries[][]. The queries are represented in numeric form:

1 x i: Call push(x, i)
2 i:  Call pop(i)
The driver code will process the queries, call the corresponding functions, and print the outputs of pop(i) operations.
You only need to implement the above two functions.

Examples:

Input: n = 4, k = 2, queries[][] = [[1, 5, 0], [1, 3, 0], [2, 0], [1, 1, 1], [2, 1]]
Output: [3, 1]
Explanation: Queries on stack are as follows:
push(5, 0): push 5 to 0-th stack
push(3, 0): push 3 to 0-th stack
pop(0): pop the top element 3 from the 0-th stack
push(1, 1): push 1 to 1-th stack
pop(1): pop the top element 1 from the 1-th stack
Input: n = 9, k = 3, queries[][] = [[1, 2, 0], [1, 5, 0], [1, 4, 1], [2, 1], [1, 3, 2], [2, 0], [2, 0]]
Output: [4, 5, 2]
Explanation: Queries on stack are as follows:
push(2, 0): push 2 to 0-th stack
push(5, 0): push 5 to 0-th stack
push(4, 1): push 4 to 1-th stack
pop(1): pop the top element 4 from the 1-th stack
push(3, 2): push 3 to 2-th stack
pop(0): pop the top element 5 from the 0-th stack
pop(0): pop the top element 2 from the 0-th stack
Constraints:

1 ≤ n, queries.size() ≤ 105
1 ≤ k ≤ n
2 ≤ queries[i].size() ≤ 3
0 ≤ values on the stacks ≤ 109

     */

    // main array to store elements
    private int[] arr;
    private int[] top;
    private int[] next;
    private int freeSpot;

    public nStacksInAnArray(int n, int k) {
        // initialize data structures for k stacks

        freeSpot = 0;
        arr = new int[n];
        top = new int[k];
        for (int i = 0; i < k; i++) {
            top[i] = -1;
        }

        next = new int[n];
        for (int i = 0; i < n - 1; i++) {
            next[i] = i + 1;
        }
        next[n - 1] = -1;
    }

    public void push(int x, int i) {
        // push element x into stack i

        // overflow check
        if (freeSpot == -1) {
            return;
        }
        // find free index
        // index -> jaha hum value insert karne wale hai, uss cell ka index
        int index = freeSpot;
        // insert value
        arr[index] = x;
        // update freeSpot
        freeSpot = next[index];
        // update next
        int stackIndex = i;
        next[index] = top[stackIndex];
        // update top
        top[stackIndex] = index;
        return;


    }

    public int pop(int i) {
        // pop element from stack i

        // check underflow
        int stackIndex = i;
        if (top[stackIndex] == -1) {
            return -1;
        }
        // find index jisko pop karna hai
        int index = top[stackIndex];
        int poppedElement = arr[index];
        // top update
        top[stackIndex] = next[index];
        // next ko update
        next[index] = freeSpot;
        // freeSpot update
        freeSpot = index;
        // return popped element
        return poppedElement;

    }

    static void main() {

        nStacksInAnArray stacks = new nStacksInAnArray(4, 2);

        // Push elements into stack 0
        stacks.push(5, 0);
        stacks.push(3, 0);

        // Pop from stack 0
        System.out.println(stacks.pop(0));  // 3

        // Push into stack 1
        stacks.push(1, 1);

        // Pop from stack 1
        System.out.println(stacks.pop(1));  // 1
    }
}
