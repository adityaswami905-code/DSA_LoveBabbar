package DSA_LoveBabbar.Recursion;

public class invCountProblem {

    //  COUNT INVERSIONS

    /*

Given an array of integers arr[]. You have to find the Inversion Count of the array. Inversion count is the number of pairs of elements (i, j) such that i < j and arr[i] > arr[j].

Examples:

Input: arr[] = [2, 4, 1, 3, 5]
Output: 3
Explanation: The sequence 2, 4, 1, 3, 5 has three inversions (2, 1), (4, 1), (4, 3).
Input: arr[] = [2, 3, 4, 5, 6]
Output: 0
Explanation: As the sequence is already sorted so there is no inversion count.
Input: arr[] = [10, 10, 10]
Output: 0
Explanation: As all the elements of array are same, so there is no inversion count.
Constraints:

1 ≤ arr.size() ≤ 105
1 ≤ arr[i] ≤ 104


     */

    static int merge(int[] arr, int s, int e, int mid){

        // The logic is similar as that of merge sort
        // the only difference is that here we are returning the count of inversions
        // we can solve this problem by brute force also, but it takes O(n^2) time complexity
        // So to optimize , we use the logic of merge sort which takes O(nlogn) time complexity

        int leftArrLen = mid-s+1;
        int rightArrLen = e-mid;

        int[] leftArr = new int[leftArrLen];
        int[] rightArr = new int[rightArrLen];

        int k = s;
        for(int i = 0; i < leftArrLen; i++){
            leftArr[i] = arr[k];
            k++;
        }

        k = mid+1;
        for(int j = 0; j < rightArrLen; j++){
            rightArr[j] = arr[k];
            k++;
        }

        int i = 0;
        int j = 0;
        k = s;
        int invCount = 0; // inversion count variable is initialized

        while( i < leftArrLen && j < rightArrLen){
            if(leftArr[i] <= rightArr[j]){
                arr[k] = leftArr[i];
                i++;
                k++;
            }else{
                // i.e. leftArr[i] > rightArr[j]
                arr[k] = rightArr[j];
                j++;
                k++;

                // formula for inversion count
                invCount = invCount + (leftArrLen-i);
            }
        }

        while(i < leftArrLen){
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        while(j < rightArrLen){
            arr[k] = rightArr[j];
            j++;
            k++;
        }

        // return inversion count
        return invCount;
    }

    static int mergeSort(int[] arr, int s, int e){

        // Base case
        if( s >= e){
            return 0;
        }

        // split the array into two halves (Divide and Conquer strategy)
        int mid = s + (e-s)/2;

        int leftInversions = mergeSort(arr,s,mid);

        int rightInversions = mergeSort(arr,mid+1,e);

        int intermediateInversions = merge(arr,s,e,mid);

        int invCount = leftInversions + rightInversions + intermediateInversions;
        return invCount;
    }

    static int countInversions(int[] arr){

        int s = 0;
        int e = arr.length-1;
        int ans = mergeSort(arr,s,e);
        return ans;
    }

    static void main() {

        int[] arr = {2, 4, 1, 3, 5};
        int result = countInversions(arr);
        System.out.print("Count of inversions is : "+result);
    }
}
