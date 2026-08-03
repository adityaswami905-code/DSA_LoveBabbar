package DSA_LoveBabbar.Arrays;

public class Part_1 {

    // FIND THE AVERAGE OF ARRAY ELEMENTS

     static double getAverage(int[] arr){
        double sum = 0;
        for (int i : arr){
            sum += i;
        }
        int size = arr.length;
        double avg = sum/size;
        return avg;
    }

    //  MULTIPLY EACH ARRAY BY 10

    static int[] multiplyBy10(int[] arr){
         int size = arr.length;
         int[ ] newArray = new int[size];

        for (int i = 0; i < size; i++) {
            int element = arr[i];
            int newElement = element * 10;
            newArray[i] = newElement;
        }
        return newArray;
    }

    //  SEARCH FOR AN ELEMENT IN AN ARRAY { LINEAR SEARCH }

    static boolean findTargetElement(int[] arr, int target){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == target){
                return true;
            }

        }
        return false;
    }

    //  FIND THE MAXIMUM ELEMENT IN AN ARRAY

    static int getMaxi(int[] arr){
         int maxi = arr[0];
         // Assuming that the array is containing at least one element

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > maxi){
                maxi = arr[i];
            }

        }
        return maxi;
    }

    //  RETURN THE SUM OF +VE AND -VE NUMBERS

    static int[] getPosNegSum(int[] arr){
         int positiveSum = 0;
         int negativeSum = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] >= 0){
                positiveSum = positiveSum + arr[i];
            }else{
                negativeSum = negativeSum + arr[i];
            }

        }
        int[] ans = {positiveSum,negativeSum};
        return ans;
    }

    //  COUNT THE NUMBERS OF ZERO'S AND ONE'S

    static int[] getZeroOneCount(int[] arr){
         int zeroCount = 0;
         int oneCount = 0;

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 0){
                zeroCount++;
            }else{
//                arr[i]==1
                oneCount++;
            }

        }
        int[] ans = {zeroCount, oneCount};
        return ans;
    }

    //  FIND FIRST UNSORTED ELEMENT IN AN ARRAY

    static int getUnsortedElement(int[] arr){

    // Array must be in unsorted array otherwise this method get outOfBound error

        for (int i = 0; i < arr.length; i++) {
            if(arr[i+1] <= arr[i] ){
                return arr[i+1];
            }

        }
        return -1;
    }

    //  SWAP ALTERNATE ELEMENTS IN AN ARRAY

    static int[] swappedElement(int[] arr){

//         Array must be of even length for this method

        for (int i = 0; i < arr.length; i=i+2) {

            int swap = arr[i+1];
            arr[i+1] = arr[i];
            arr[i] = swap;
        }
        return arr;
    }

    //  PRINT ARRAY INTERSECTION ELEMENTS

    static int[] intersectionElements(int[] arr1, int[] arr2){
         int size = arr1.length;
         int[] newArray = new int[size];

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i] == arr2[j]){
                    newArray[i] = arr1[i] ;
                }

            }


        }
        return newArray;

    }

    //  PRINT ALTERNATE EXTREME ELEMENTS OF AN ARRAY

    static void main() {

//        int[] arr = {1,2,3,4,5,6};
//        System.out.println(getAverage(arr));

//        int[] arr = {1,2,3,4,5};
//        int[] ans = multiplyBy10(arr);
//        System.out.println("New elements in the array are: ");
//        for(int i:ans){
//            System.out.println(i);
//        }

//        int[] arr = {3,7,17,18,5};
//        boolean ans = findTargetElement(arr, 17);
//        System.out.println(ans);

//        int[] arr = {17,10,1 ,8 ,6,18,5};
//        int ans = getMaxi(arr);
//        System.out.println("Maximum element in an array is:" + ans);

//        int[] arr = {1,-3,5,-7,9};
//        int[] ans = getPosNegSum(arr);
//        System.out.println("Positive element sum: "+ans[0]);
//        System.out.println("Negative element sum: "+ans[1]);

//        int[] arr = {0,1,0,1,0,1,1,1};
//        int[] ans = getZeroOneCount(arr);
//        System.out.println("Zero's count: "+ans[0]);
//        System.out.println("One's count: "+ans[1]);

//        int[] arr = {1,3,5,4,7,9};
//        int ans = getUnsortedElement(arr);
//        System.out.println(ans);

//        int[] arr = {1,2,3,4,5,6};
//        int[] ans = swappedElement(arr);
//        System.out.print("Array after swapping alternate element: ");
//        for(int i : ans){
//            System.out.print(i+" ");
//        }

        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {2,4,6,8,10};
        int[] ans = intersectionElements(arr1,arr2);
        System.out.print("Intersection elements are: ");
        for(int i : ans){
            System.out.print(i+" ");
        }



    }
}
