package DSA_LoveBabbar.Recursion;

public class mergeSortAlgo {

    // MERGE SORT

    /*

    Given an array arr[], its starting position l and its ending position r. Sort the array using the merge sort algorithm.

Examples:

Input: arr[] = [4, 1, 3, 9, 7]
Output: [1, 3, 4, 7, 9]
Explanation: We get the sorted array after using merge sort

Input: arr[] = [10, 9, 8, 7, 6, 5, 4, 3, 2, 1]
Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
Explanation: We get the sorted array after using merge sort

Constraints:

1 ≤ arr.size() ≤ 105
0 ≤ arr[i] ≤ 105


     */

    static void merge(int[] arr, int s, int e, int mid){

        // size of the left part of an array and right part of an array
        int leftArrLen = mid-s+1;
        int rightArrLen = e-mid;

        int[] leftArr = new int[leftArrLen];
        int[] rightArr = new int[rightArrLen];

        int k = s;

        // copy of the left part of an array
        for(int i = 0 ;i < leftArrLen; i++){
            leftArr[i] = arr[k];
            k++;
        }

        // copy of the right part of an array
        k = mid+1;
        for(int j = 0; j < rightArrLen; j++){
            rightArr[j] = arr[k];
            k++;
        }

        int i = 0;
        int j = 0;
        k = s;

        // comparing the elements from the left and right part of an array and merging them in increasing order i.e. sorted order
        while( i < leftArrLen && j < rightArrLen){

            if(leftArr[i] < rightArr[j]){
                // if element of left array  is less than right arr, then store the left array element into original arr
                arr[k] = leftArr[i];
                i++;
                k++;

            }else{
                // if element of right array is less than left arr, then store the right array element into original arr
                arr[k] = rightArr[j];
                j++;
                k++;
            }
        }

        // for further conditions
        // if given array is odd
        // and if left array contains more element , then merge them, at last
        while( i < leftArrLen){
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        // similar for the right array
        // if right array contains more element, then merge them, at last
        while( j < rightArrLen){
            arr[k] = rightArr[j];
            j++;
            k++;
        }

    }

    static void mergeSort(int[] arr, int l, int r){

        // For simplification
        // let
        int s = l;
        int e = r;

        // Base case
        if(s >= e){
            // i.e. if array is invalid or contains only one element
            return;
        }

        // Divide the given array into two halves
        int mid = (s+e)/2;

        // let's sort the left part of an array - recursively
        mergeSort(arr,s,mid);

        // let's sort the right part of an array - recursively
        mergeSort(arr,mid+1,e);

        // merge the left part of an array and right part of an array
        merge(arr,s,e,mid);
    }

    static void main() {
//        int[] arr = {4, 1, 3, 9, 7};
        int[] arr = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        int l = 0;
        int r = 9;
        mergeSort(arr,l,r);

        // for printing the answer
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }
}
