package DSA_LoveBabbar.Sorting_and_searching_Algos;

public class ekoSpoj {

    //  EKO SPOJ (Max Height for Given Total Reduction)

    /*
Given an array arr[], where arr[i] is the height of the ith tree, and an integer m denoting the metres of wood geek needs. A wood cutting machine set at height h cuts off only the part of each tree above h (shorter trees are untouched). Find the maximum h such that the total wood cut is at least m metres.

Note: It is guaranteed that sum(arr) ≥ m, so a valid height h (including possibly h = 0) always exists.

Examples:

Input: arr[] = [20, 15, 10, 17], m = 7
Output: 15
Explanation: At h = 15, tree1 gives 20-15 = 5 metres, tree4 gives 17-15 = 2 metres, and the other two trees give 0 (they're shorter than 15). Total wood = 5 + 2 = 7, which meets m. Setting h any higher, say 16, only gives 5 + 1 = 6 metres, which falls short of m.
Input: arr[] = [4, 42, 40, 26, 46], m = 20
Output: 36
Explanation: At h = 36, the trees taller than 36 give 42-36 = 6, 40-36 = 4, and 46-36 = 10 metres respectively. Total wood = 6 + 4 + 10 = 20, which exactly meets m.
Constraints:
1 ≤ arr.size() ≤ 106
1 ≤ arr[i] ≤ 106
1 ≤ m ≤ 2×106
     */

    static boolean isValidAns(int[] trees, int m, long maxHeight){

        long totalWoodCollected = 0;

        for(int i = 0; i < trees.length; i++){

            if(trees[i] > maxHeight){

                long currentWoodCollected = trees[i] - maxHeight;
                totalWoodCollected = totalWoodCollected + currentWoodCollected;
            }
        }
        if( totalWoodCollected >= m){
            return true;
        }else{
            return false;
        }
    }

    static int maxHeight(int[] trees, int m){

        long n = trees.length;
        long s = 0;
        long maxi = -1;
        long sum = 0;

        for( int i = 0; i < n; i++){
            sum += trees[i];
        }

        long e = sum;

        while( s <= e){

            long mid = s + (e-s);

            if(isValidAns(trees,m,mid)){
                maxi = mid;
                s = mid+1;

            }else {
                e = mid-1;
            }
        }
        return (int) maxi;
    }

    static void main() {

//        int[] trees = {20, 15, 10, 17};
        int[] trees = {4, 42, 40, 26, 46};
        int ans = maxHeight(trees,20);
        System.out.print("The maximum h such that the total wood cut is at least m metres is : "+ans);

    }
}
