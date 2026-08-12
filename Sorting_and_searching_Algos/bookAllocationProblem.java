package DSA_LoveBabbar.Sorting_and_searching_Algos;

public class bookAllocationProblem {

    //  BOOK ALLOCATION PROBLEM ( ALLOCATE MINIMUM PAGES )
    /*
Given an array arr[] of integers, where each element arr[i] represents the number of pages in the i-th book. You also have an integer k representing the number of students. The task is to allocate books to each student such that:

Each student receives atleast one book.
Each student is assigned a contiguous sequence of books.
No book is assigned to more than one student.
All books must be allocated.
The objective is to minimize the maximum number of pages assigned to any student. In other words, out of all possible allocations, find the arrangement where the student who receives the most pages still has the smallest possible maximum. If it is not possible to allocate books to all students, return -1;

Note: Test cases are generated such that the answer always fits in a 32-bit integer.

Examples:

Input: arr[] = [12, 34, 67, 90], k = 2
Output: 113
Explanation: Allocation can be done in following ways:
=> [12] and [34, 67, 90] Maximum Pages = 191
=> [12, 34] and [67, 90] Maximum Pages = 157
=> [12, 34, 67] and [90] Maximum Pages = 113.
The third combination has the minimum pages assigned to a student which is 113.

Input: arr[] = [15, 17, 20], k = 5
Output: -1
Explanation: Since there are more students than total books, it's impossible to allocate a book to each student.

Constraints:
1 ≤ arr.size() ≤ 106
1 ≤ arr[i], k ≤ 104

*/

    // If you see the statement like Minimum of maximum or Maximum of minimum then it uses binary search

    static boolean isValidAnswer(int[] arr,int k,long maxPages){

        int studentCount = 1;
        long pages = 0;

        for(int i = 0; i < arr.length; i++){

            if(pages + arr[i] <= maxPages){
//                iska matlab mein agle pages ke count ko add kar sakt hoo
                pages = pages+arr[i];
            }else{
                studentCount++;
                if(studentCount > k || arr[i] > maxPages){
                    return false;

                }else{
//                    iska matlab naye student ko abhi book pages assigned hoge
                    pages = 0;

                    pages = pages+arr[i];

                }
            }
        }
        return true;

    }

    static int findPages(int[] arr, int k){

        // agar pages ke count jyada hai student ke numbers se toh us time pe -1 ans return karna
        if(arr.length < k){
            return -1;
        }

        long n = arr.length;
        long s = 1;
        long sum = 0;
        long ans = -1;

        for(int i = 0; i < n; i++){
            sum += arr[i];
        }

        long e = sum;

        while( s <= e){

            long mid = s + (e-s)/2;

            if(isValidAnswer(arr,k,mid)){

                // Iska matlab answer exists karta hai, magar ho sakta hai ki woh final answer na hoke ek potential answer ho
                ans = mid;
                // ab yaha pe answer mila hai, toh iske right part mein check karne ki jarurat nahi kyoun ki right part mein saare values bade he hoge
                // toh (The objective is to minimize the maximum number of pages assigned to any student.) iske kaaran hume left mein jana hoga
                e = mid-1;


            }else{
                // move right
                s = mid+1;
            }
        }

        return (int) ans;

    }

    static void main() {

        int[] arr = {12, 34, 67, 90};
//        int[] arr = {15, 17, 20};
        int ans = findPages(arr,2);
        System.out.print("Minimum pages allocated to the student is: "+ans);

    }
}
