package DSA_LoveBabbar.Sorting_and_searching_Algos;

public class part_3 {

    // BINARY SEARCH - LOWER BOUND ( Agar ek sorted elements ka array diya hai aur usme target value agar multiple time occur hote hai toh sabse kam index wale target value ko Lower Bound bola jata hai)
    //                               Aur agar, woh target value present nahi hai to just greater number ke index to lower bound bola jata hai)

    static int getLowerBound(int[] arr, int target){

        int n = arr.length;
        int start = 0;
        int end = n-1;
//        int ans = -1;
        int ans = n; // In case of if you wanted to calculate freq using upper and lower bound to pass the all test cases

        while( start <= end){

            int mid = start + (end - start)/2;

            if(arr[mid] >= target){

                ans = mid;
                // move left
                end = mid-1;
            }else{
//                move right
                start = mid+1;
            }
        }
        return ans;
    }

//    BINARY SEARCH - UPPER BOUND ( The sorted array in which target is not present or present, so the value just greater than the target value and the  index of that value is called upper bound)

    static int getUpperBound(int[] arr, int target){

        int n = arr.length;
        int start = 0;
        int end = n-1;
//        int ans = -1;
        int ans = n; // In case of if you wanted to calculate freq using upper and lower bound to pass the all test cases

        while(start <= end){
            int mid = start + (end - start)/2;

            if(arr[mid] <= target){
                // move right
                start = mid+1;
            }else{
//                arr[mid] > target
//                move left
                ans = mid;
                end = mid - 1;

            }

        }
        return ans;
    }

    //  NUMBER OF OCCURRENCE (Using upper bound and lower bound i.e. freq => upper bound - lower bound)

    static int getFreq(int[] arr, int target){

        int upperBound = getUpperBound(arr,target);
        int lowerBound = getLowerBound(arr, target);

        return upperBound - lowerBound;
    }

    static void main() {

//        int[] arr = {10,20,30,30,30,30,30,40,50};
//        int ans = getLowerBound(arr,30);
//        System.out.print("Lower bound is: "+ans);

//        int[] arr = {10,20,30,40,40,40,50,60};
//        int ans = getUpperBound(arr,25);
//        System.out.print("Upper bound is: "+ans);

        int[] arr = {10,20,30,40,40,40};
        int ans = getFreq(arr,40);
        System.out.print("Frequency of that element in an array is: "+ans);



    }
}
