package DSA_LoveBabbar.Sorting_and_searching_Algos;

public class singleNonDuplicate {

    //  FIND SINGLE NON-DUPLICATE ELEMENT USING BINARY SEARCH

    /*

    In this problem the array is given, in which it contains all the element, which occur twice except one in monotonic order
    i.e. int[] arr = {10,10,20,20,30,30,40,40,50,60,60}
              index => 0  1  2  3  4  5  6  7  8  9  10
    In above array we can see directly that element 50 is single non  duplicate element and all other elements are in pair
    But while solving through code, we can notice that elements pair lying left side of the unique element is that they start through even index
    whereas on right side pair start through odd index
    Also array is in sorted format, so we can apply binary search logic

     */

    static  int singleNonDuplicateElement(int[] arr){

        int n = arr.length;;
        int s = 0;
        int e = n-1;

//        For single element in an array
        if( s == e){
            return arr[s];
        }

//        For multi elements in an array
        while( s <= e){

            int mid = s + (e-s)/2;

            int currentValue = arr[mid];

            int previousValue = -1;
            if(mid-1 >= 0){
                previousValue = arr[mid-1];

            }

            int nextValue = -1;
            if(mid+1 < n){
                nextValue = arr[mid+1];

            }

            if(previousValue != currentValue && nextValue != currentValue){
                return currentValue;
            }

            if (previousValue == currentValue && nextValue != currentValue){
                int endingIndex = mid;

                if((endingIndex & 1) == 1){
//                    Iska matlab odd index hai
//                    Means move right
                    s = mid + 1;

                }else{
//                    In case of even, move left
                    e = mid - 1;

                }

            } else if (previousValue != currentValue && nextValue == currentValue) {
                int startingIndex = mid;

                if((startingIndex & 1) == 1){
                    // Iska matlab odd index hai
                    // move left
                    e = mid - 1;

                }else{
                    s = mid + 1;

                }
            }
        }
        return -1;
    }



    static void main() {

        int[] arr = {10,10,20,30,30,40,40,50,50,60,60};
//        int[] arr = {10,10,20,20,30,30,40,40,50,60,60};
        int ans = singleNonDuplicateElement(arr);
        System.out.print("Single non duplicate element using binary search is: "+ans);
    }
}
