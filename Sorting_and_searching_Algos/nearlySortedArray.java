package DSA_LoveBabbar.Sorting_and_searching_Algos;

public class nearlySortedArray {

    //  FIND AN ELEMENT IN A NEARLY SORTED ARRAY ELEMENTS CAN BE SWAPPED WITH ADJACENT ONE'S

    /*

    Nearly sorted array means, the ith element may present at arr[i], arr[i-1] or arr[i+1]
    i.e. sortedArray = { 10,20,30,40,50,60,70,80}
    whereas nearlySortedArray = {10,30,20,50,40,70,60,80}
     */

    static int findElementIndexInNearlySortedArray(int[] arr, int k){
//        k -> Target element

        int n = arr.length;
        int s = 0;
        int e = n-1;

        while( s <= e){

            int mid = s + (e-s)/2;

            if(mid-1 > 0 &&arr[mid-1] == k){
                return mid-1;
            }

            if( arr[mid] == k){
                return mid;
            }

            if(mid+1 <= n && arr[mid+1] == k){
                return mid+1;
            }

            if(arr[mid] > k){
//                e = mid-1;
                // For optimization we use  e = mid - 2, because mid-1 element is already checked
                // Therefore checking the checked element dose not make any sense
                e = mid - 2;

            }else{
                s = mid+2;
            }
        }
        return -1;
    }

    static void main() {

        int[] arr = { 10,30,20,50,40,70,60,80};
        int ans = findElementIndexInNearlySortedArray(arr,70);
        System.out.print("Index of an element in nearly sorted array is: "+ans);

    }
}
