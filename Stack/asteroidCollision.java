package DSA_LoveBabbar.Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class asteroidCollision {

    //  ASTEROID COLLISION

    /*

    We are given an array asteroids of integers representing asteroids in a row. The indices of the asteroid in the array represent their relative position in space.

For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.

Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.

Example 1:
Input: asteroids = [5,10,-5]
Output: [5,10]
Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.

Example 2:
Input: asteroids = [8,-8]
Output: []
Explanation: The 8 and -8 collide exploding each other.

Example 3:
Input: asteroids = [10,2,-5]
Output: [10]
Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.

Example 4:
Input: asteroids = [3,5,-6,2,-1,4]
Output: [-6,2,4]
Explanation: The asteroid -6 makes the asteroid 3 and 5 explode, and then continues going left. On the other side, the asteroid 2 destroys -1. Since 2 and 4 are both moving right, they never collide.

Constraints:
2 <= asteroids.length <= 104
-1000 <= asteroids[i] <= 1000
asteroids[i] != 0

     */

    static int[] astCollision(int[] asteroids){

        Deque<Integer> st = new ArrayDeque<>();

        for( int ast : asteroids ){

            // if asteroid is positive then simply push it into the stack
            if( ast >= 0 ){
                st.push(ast);
            }
            else{
                // i.e. if asteroid is negative

                // initially if it's value is negative then simply push it into stack
                // because theirs no further element to compare with i.e. is stack is empty
                if( st.isEmpty() ){
                    st.push(ast);
                }
                else if(st.peek() < 0){
                    st.push(ast);
                }
                else{

                    // if the 1st entity -> +ve
                    // and 2nd entity -> -ve
                    // then check the following three conditions

                    // initially destroy value is zero i.e. yet not collided
                    boolean destroyed = false;

                    while( !st.isEmpty() && ast < 0 && st.peek() > 0 ){

                        // if asteroid magnitude is greater than peek value of stack
                        if( st.peek() < -ast ){
                            // then peek element gets explode after collision
                            st.pop();
                            // further element may present to collide with asteroid
                            continue;
                        }
                        else if( st.peek() > -ast ){

                            // i.e. if magnitude of asteroid is smaller than the element present at peek of the stack
                            // then asteroid get explode after collision
                            destroyed = true;
                            break;
                        }
                        else{
                            // i.e. both asteroid and stack peek element have same magnitude
                            // then both gets explode after collision
                            // therefore
                            st.pop();
                            destroyed = true;
                            break;
                        }
                    }
                    // and if still asteroid remains after collisions
                    // then
                    if(!destroyed){
                        st.push(ast);
                    }
                }
            }
        }

        // now inserting all stack elements into the answer array
        // but in reverse order because stack follows LIFO order
        int[] ans = new int[st.size()];
        for( int i = st.size()-1; i >= 0; i-- ){
            ans[i] = st.pop();
        }
        return ans;
    }

    static void main() {

        int[] arr = {3,5,-6,2,-1,4};
        int[] result = astCollision(arr);
        System.out.print("State of the asteroids after all collisions: ");
        for( int res : result){
            System.out.print(
                    res + " "
            );
        }
        System.out.println();
    }
}
