package DSA_LoveBabbar.Recursion;

public class quickSortAlgo {

    //  QUICK SORT

    /*

    Given an array arr[], with starting index low and ending index high, complete the functions partition() and quickSort() so that the array becomes sorted in ascending order.

Examples:

Input: arr[] = [4, 1, 3, 9, 7]
Output: [1, 3, 4, 7, 9]
Explanation: After sorting, all elements are arranged in ascending order.

Input: arr[] = [2, 1, 6, 10, 4, 1, 3, 9, 7]
Output: [1, 1, 2, 3, 4, 6, 7, 9, 10]
Explanation: Duplicate elements (1) are retained in sorted order.

Input: arr[] = [5, 5, 5, 5]
Output: [5, 5, 5, 5]
Explanation: All elements are identical, so the array remains unchanged.

Constraints:

1 ≤ arr.size(), arr[i] ≤ 105

     */

    static void quickSort(int[] arr, int low, int high){

        // For understanding
        int s = low;
        int e = high;

        // Base case
        if( s >= e){
            // i.e. if an array is invalid or contains only one element
            return;
        }

        // get pivot element by partitioning
        int pivotElement = partition(arr,s,e);
        // get the sorted array which are less than pivot element - recursively
        quickSort(arr,s,pivotElement-1);
        // get the sorted array which are greater than pivot element - recursively
        quickSort(arr,pivotElement+1,e);
    }

    static int partition(int[] arr, int low, int high){

        int s = low;
        int e = high;

        // Get the pivot element, that can be starting element, ending element, random element, middle element
        // let
        int pivotElement = arr[s];

        // We can calculate the correct position of a pivot element can be found by using count based approach,Lomuto approach, Hoare approach etc.
        // Here we are using count based approach
        int count = 0;
        for(int i = s+1; i <= e; i++){
            if(arr[i] <= pivotElement){
                count++;
            }
        }

        // correct position of the pivot element can be equal to the (count of the element which are lesser than or equal to the pivot element + s)
        int correctPosition = count+s;

        // swap the pivot element with the correct position element
        int temp = arr[correctPosition];
        arr[correctPosition] = arr[s];
        arr[s] = temp;

        int i = s;
        int j = e;

        while(i < correctPosition && j > correctPosition){

            // if the element which lies on the left side of the pivot element are lesser than the pivot element then simply move the i
            while( arr[i] <= pivotElement){
                i++;
            }

            // Also if the element which lies on the right side of the pivot element are greater than the pivot element then simply move the j
            while( arr[j] > pivotElement){
                j--;
            }

            // if the element which lies left side of the pivot element is greater than the element which are present in the right side of the pivot element, then simply swap them
            if(i < correctPosition && j > correctPosition){
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        return correctPosition;

    }

    static void main() {
        int[] arr = {2, 1, 6, 10, 4, 1, 3, 9, 7};
        quickSort(arr,0,arr.length-1);
        System.out.print("Sorted array through quickSort is: "+" ");
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }
}
