package DSA_LoveBabbar.Sorting_and_searching_Algos;

public class part_1 {

    // BUBBLE SORT (Unsorted array me se maximum element ko apne correct position me rak deta hai)

    static void bubbleSort(int[] arr){
        int n = arr.length;

        // for no. of rounds
        for(int i = 0; i < n-1; i++){

            // for comparing neighboring element and swap if required
            for(int j = 0; j < n-i-1; j++){
                if(arr[j] > arr[j+1]){
                    // swap logic
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }

            }
        }
    }

    //  SELECTION SORT ( Unsorted array main se minimum value ko correct position mein rak deta hai)

    static void selectionSort(int[] arr){

        int n = arr.length;

        // Outer loop for no. of rounds
        for(int i = 0; i < n-1; i++){
            int minIndex = i;

            // Inner loop for comparing element at jth position and element at minIndex position
            for(int j = i+1; j < n; j++){
                if(arr[j] < arr[minIndex]){
                    minIndex = j;
                }

            }
            // Now swapping the element to sort
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    //  INSERTION SORT

    static void insertionSort(int[] arr){
        int n = arr.length;

        for(int i = 1; i < n; i++){

            int curr = i;
            int prev = i-1;
            int currValue = arr[curr];

            while(prev >= 0 && currValue < arr[prev]){
                arr[prev+1] = arr[prev];
                prev--;
            }
            arr[prev+1] = currValue;
        }
    }

    static void main() {

        int[] arr = {1,6,3,5};
//        bubbleSort(arr);
//        selectionSort(arr);
        insertionSort(arr);
        System.out.print("Sorted array is: ");
        for(int num : arr){
            System.out.print(num+" ");
        }
    }
}
