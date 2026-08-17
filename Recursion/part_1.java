package DSA_LoveBabbar.Recursion;

public class part_1 {

    //  FACTORIAL OF AN NUMBER

    /*

Given a positive integer, n. Find the factorial of n.

Examples :

Input: n = 5
Output: 120
Explanation: 1 x 2 x 3 x 4 x 5 = 120

Input: n = 4
Output: 24
Explanation: 1 x 2 x 3 x 4 = 24

Constraints:
0 ≤ n ≤ 12

     */

    static long factorial(int n){

        // Base case
        if(n == 0){
            return 1;
        }

        // Recursive relation
        long ans = n * factorial(n-1);
        return ans;
    }

    //  POWER OF TWO

    /*

Given an integer n, return true if it is a power of two. Otherwise, return false.

An integer n is a power of two, if there exists an integer x such that n == 2x.



Example 1:

Input: n = 1
Output: true
Explanation: 20 = 1

Example 2:

Input: n = 16
Output: true
Explanation: 24 = 16

Example 3:

Input: n = 3
Output: false

Constraints:

-231 <= n <= 231 - 1


     */

    static boolean isPowerOfTwo(int n){

        if( n > 1 && (n & (n-1)) == 0){
            return true;
        }
        return false;
    }

    static long powerOfTwo(int n){

        // Base case
        if( n == 0){
            return 1;
        }

        // Recursive relation
        long ans = 2 * powerOfTwo(n-1);
        return ans;
    }

    //  FIBONACCI NUMBER

    /*

The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,

F(0) = 0, F(1) = 1
F(n) = F(n - 1) + F(n - 2), for n > 1.
Given n, calculate F(n).

Example 1:

Input: n = 2
Output: 1
Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.

Example 2:

Input: n = 3
Output: 2
Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.

Example 3:

Input: n = 4
Output: 3
Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.

Constraints:

0 <= n <= 30

     */

    static int fib(int n){

        // Base case
        if( n <= 1){
            return n;
        }

        // Recursive relation
        int last = fib(n-1);
        int sLast = fib(n-2);

        return last + sLast;
    }

    static void main() {


//        long ans = factorial(4);
//        System.out.print("Factorial of number is: "+ans);

//        boolean ans = isPowerOfTwo(8);
//        System.out.print("Given number is power of 2: "+ans);

//        long ans = powerOfTwo(5);
//        System.out.print("Power of two is: "+ans);

        int result = fib(4);
        System.out.print("Fibonacci number is: "+result);
        
    }
}
