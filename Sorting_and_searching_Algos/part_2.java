package DSA_LoveBabbar.Sorting_and_searching_Algos;

public class part_2 {

    // BINARY SEARCH ( The requirement of the binary search is Monotomic nature, i.e. that data must be in Inc. or Dec. order)
    // T.C. => O(logn)

    static int binarySearch(int[] arr, int target){

        int n = arr.length;
        int start = 0;
        int end = n-1;

        //Instead of using mid = (start - end)/2 we use below formula to handle large value operations
        int mid = start + (end - start)/2;

        while( start <= end){

            if( arr[mid] == target){
                return mid;

            } else if (arr[mid] > target) {
                end = mid-1;

            }else{
                start = mid+1;
            }
            mid = start + (end-start)/2;
        }
        return -1;
    }

    static void main() {

        int[] arr = {1,2,3,5,8,10,15,21,30};
        int ans = binarySearch(arr,15);
        System.out.print("Target found at an index of: "+ans);
    }
}
