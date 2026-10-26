package DSA_LoveBabbar.Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class celebrityProblem {

    //  CELEBRITY PROBLEM

    /*

    Consider a party being organized by some people. A celebrity is a person
    who is known to all but does not know anyone at the party.

A square matrix mat[][] of size n * n is used to represent people at the party such that
if an element of row i and column j is set to 1 it means ith person knows jth person.
You need to return index of the celebrity in the party.
If the celebrity does not exist, return -1.
Note: Follow 0-based indexing.

Examples:

Input: mat[][] = [[1, 1, 0],
                 [0, 1, 0],
                 [0, 1, 1]]
Output: 1
Explanation: 0th and 2nd person both know 1st person and 1st person does not know anyone.
             Therefore, 1 is the celebrity person.

Input: mat[][] = [[1, 1],
                 [1, 1]]
Output: -1
Explanation: Since both the people at the party know each other.
             Hence, none of them is a celebrity person.

Input: mat[][] = [[1]]
Output: 0

Constraints:
1 ≤ mat.size(), mat[i].size() ≤ 103
0 ≤ mat[i][j] ≤ 1
mat[i][i] = 1

Expected Complexities
Time Complexity: O(n)
Auxiliary Space: O(1)

Company Tags
Zoho    Flipkart    Amazon  Microsoft   Google
Fab.com   One97   United-Health-Group   NPCI


     */

    // Stack Elimination Pattern
    static int celebrity(int[][] mat){

        int n = mat[0].length;
        Deque<Integer> st = new ArrayDeque<>();

        // Putting all individuals in a stack
        for( int i = 0; i < n; i++ ){
            st.push(i);
        }

        while( st.size() >= 2 ){

            int a = st.pop();
            int b = st.pop();

            if( mat[a][b] == 1 ){
                // that means a knows b
                // i.e. b may be celebrity
                // therefore
                st.push(b);
            }
            else{
                // mat[a][b] == 0
                // that means a does not know b
                // i.e. a may be celebrity
                // due to which
                st.push(a);
            }
        }

        // hence we will get our potential answer(i.e. celebrity)
        // so checking whether it follows its quality
        // that, celebrity does not know anyone, but everyone knows celebrity
        int celebIndex = st.pop();

        for( int i = 0; i < n; i++ ){
            // i.e. celeb kisi ko nhi jaan ta
            if( i != celebIndex ){

                if( mat[celebIndex][i] == 1 ){
                    return -1;
                }
            }
        }

        for( int i = 0; i < n; i++ ){
            // i.e. celeb ko sab jaan te hai
            if( mat[i][celebIndex] == 0 ){
                return -1;
            }
        }

        // if both condition does not return -1 then
        return celebIndex;
    }

    static void main() {

        int[][] mat = {
                        {1, 1, 0},
                        {0, 1, 0},
                        {0, 1, 1}
                    };
        int answer = celebrity(mat);
        System.out.println("Index of celebrity: " + answer );

    }
}
