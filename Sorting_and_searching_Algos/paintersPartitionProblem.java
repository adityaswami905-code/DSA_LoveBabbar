package DSA_LoveBabbar.Sorting_and_searching_Algos;

public class paintersPartitionProblem {

    //  PAINTER'S PARTITION PROBLEM

    /*
Given an array arr[] and an integer k, where the array represents the boards and each element denotes the length of a board, and k painters are available to paint these boards. Each unit length of a board takes 1 unit of time to paint. Find the minimum time required to paint all the boards such that each painter paints only contiguous sections of the array. A painter can paint boards like [2, 3, 4], [1], or even no board, but cannot paint non-contiguous boards like [2, 4, 5].

Examples:

Input: arr[] = [5, 10, 30, 20, 15], k = 3
Output: 35
Explanation: The most optimal way will be: Painter 1 allocation : [5,10], Painter 2 allocation : [30], Painter 3 allocation : [20, 15], Job will be done when all painters finish i.e. at time = max(5 + 10, 30, 20 + 15) = 35

Input: arr[] = [10, 20, 30, 40], k = 2
Output: 60
Explanation: The most optimal way to paint: Painter 1 allocation : [10, 20, 30], Painter 2 allocation : [40], Job will be complete at time = 60
     */

    static boolean isValidSolution(int[] boards, int k, long maxLength){

        int paintersCount = 1;
        int paintLength = 0;

        for(int i = 0; i < boards.length; i++){



            if(paintLength + boards[i] <= maxLength){
                paintLength = paintLength + boards[i];

            }else{
                paintersCount++;

                if( paintersCount > k || boards[i] > maxLength){
                    return false;

                }else{
                    paintLength = 0;
                    paintLength = paintLength + boards[i];

                }

            }
        }
        return true;
    }

    static int findBoards(int[] boards, int k){

        if(boards.length < k){
            return -1;
        }

        long sum = 0;
        for(int i = 0; i < boards.length; i++){
            sum += boards[i];
        }

        long s = 0;
        long e = sum;
        long ans = -1;

        while( s <= e){

            long mid = s + (e-s)/2;

            if(isValidSolution(boards,k,mid)){
                // iska matlab ek potential answer mila hai yaha phir ho sakta hai final answer bhi mila ho
                ans = mid;
                // toh final answer ke liye hume left mein move karna chahiye kyuon ki abhi jo potential answer mila hai uske right side mein sabhi values badi hogi
                // i.e. agar ek painter ko 40 sec lag rahe hai, x length ke board pe paint karne ke liye toh woh easily waha paints 50,60,70... sec main paint kar dega
                // iske kaaran hame left main move karna chaihye ek desired output ke liye
                e = mid-1;

            }else{
                // move right
                s = mid+1;

            }

        }
        return (int) ans;
    }

    static void main() {

//        int[] boards = {5, 10, 30, 20, 15};
        int[] boards = {10, 20, 30, 40};
        int ans = findBoards(boards,2);
        System.out.print("Minimum time required to paint all the boards: "+ans);

    }
}
