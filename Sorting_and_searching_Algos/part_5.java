package DSA_LoveBabbar.Sorting_and_searching_Algos;

public class part_5 {

    //  FIND THE PIVOT INDEX OF A ROTATED ARRAY (In this array, the array is rotated in such a way that, it is divided into two parts but both part are in ascending order we just need to find that in which our answer should be present)
//                                                 The two parts would be in such a way that all the left part elements are greater than all the elements present in right part and vice-versa

    static int findPivotIndex(int[] arr){

        int n = arr.length;
        int start = 0;
        int end = n-1;
        int ans = -1;

        // If the array is present in ascending order only (i.e. contains only one part)
        if(arr[start] < arr[end]){
            return -1;
        }

        while( start <= end){

            int mid = start + (end-start)/2;

            if(arr[mid] <= arr[n-1]){
                // If the arr[mid] is less than or equal to the end element present in array then we are in right part of the element
                // Need to move to the left side
                end = mid-1;
            }else{
//                arr[mid] > arr[n-1]
                // Then we are in the right part of the array and contains potential ans
                ans = mid;
                // Though we got the answer but there is the possibility of existing the final ans
                // For that we need to move to the right
                start = mid+1;
            }
        }
        return ans;
    }

    static int binarySearch(int[] arr, int start, int end, int target){

        int n = arr.length;

        while(start <= end){

            int mid = start + (end-start)/2;

            if(arr[mid] == target){
                return mid;
            } else if (arr[mid] < target) {
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return -1;
    }

    //  SEARCH IN ROTATED SORTED ARRAY

    static int search(int[] arr, int target){

        int n = arr.length;
        int pivotIndex = findPivotIndex(arr);

        if(pivotIndex == -1){
            int ans = binarySearch(arr,0,n-1,target);
            return ans;
        }else{
            int startArray1 = 0;
            int endArray1 = pivotIndex;

            if(target >= arr[startArray1] && target <= arr[endArray1]){
                int ans = binarySearch(arr,startArray1,endArray1,target);
                return ans;
            }
            int startArray2 = pivotIndex+1;
            int endArray2 = n-1;
            if(target >= arr[startArray2] && target <= arr[endArray2]){
                int ans = binarySearch(arr,startArray2,endArray2,target);
                return ans;
            }
        }
        return -1;

    }

    static void main() {

//        int[] arr = {50,60,70,10,20,30,40};
//        int ans = findPivotIndex(arr);
//        System.out.print("Pivot index in a rotated array is: "+ans);

        int[] arr = {4,5,6,7,0,1,2};
        int ans = search(arr,0);
        System.out.print("Index of the target element in a rotated sorted array is: "+ans);

    }
}
