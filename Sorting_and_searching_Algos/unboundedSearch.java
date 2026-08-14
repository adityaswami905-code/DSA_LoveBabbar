package DSA_LoveBabbar.Sorting_and_searching_Algos;

class InfiniteArray {

    private int[] arr;

    InfiniteArray(int[] arr) {
        this.arr = arr;
    }

    public int get(int index) {

        if (index >= arr.length) {
            return Integer.MAX_VALUE;
        }

        return arr[index];
    }
}

public class unboundedSearch {

    // UNBOUNDED SEARCH

    /*

Unbounded array search
Given an unbounded array that is sorted, how will you search it for a given element

Solution
Simultaneously search for the end of the array and the element given using the binary search technique, doubling the size in each iteration
If we go beyond the end of the array we'll get an out of bound exception
Then we can search between previous point and the current out of bound

     */

    static int searchIndexOfTargetOnInfiniteArray(
            InfiniteArray arr,
            int target) {

        // Step 1: Check first element
        if (arr.get(0) == target) {
            return 0;
        }

        // Step 2: Find a suitable range
        int i = 1;

        while (arr.get(i) <= target) {
            i = i * 2;
        }

        // Step 3: Binary Search in [i/2, i]
        int s = i / 2;
        int e = i;

        while (s <= e) {

            int mid = s + (e - s) / 2;

            if (arr.get(mid) == target) {
                return mid;

            } else if (arr.get(mid) > target) {
                e = mid - 1;

            } else {
                s = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] array = {2, 5, 8, 12, 16, 23, 38, 45, 56, 67};
        InfiniteArray arr = new InfiniteArray(array);
        int result = searchIndexOfTargetOnInfiniteArray(arr, 56);
        System.out.println("Target index = " + result);
    }
}